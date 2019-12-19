package hnu.houseweb.serviceImpl.house;

import hnu.houseweb.dao.AgentHangoutMapper;
import hnu.houseweb.dao.HangoutMapper;
import hnu.houseweb.dao.HouseDetailMapper;
import hnu.houseweb.dao.HouseMapper;
import hnu.houseweb.entity.*;
import hnu.houseweb.entity.HouseDetail;
import hnu.houseweb.service.house.UploadHouseService;
import hnu.houseweb.service.house.UploadHouseService;
import hnu.houseweb.service.tools.ImgTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;


@Service
@Transactional
public class UploadHouseServiceImpl implements UploadHouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private HouseDetailMapper houseDetailMapper;

    @Autowired
    private HangoutMapper hangoutMapper;

    @Autowired
    private AgentHangoutMapper agentHangoutMapper;

    @Autowired
    ImgTools imgTools;

    @Override
    /* 检查房产证号是否已再此平台使用过, 若已存在, 则返回true 不让再次录入此房源*/
    public boolean checkHouseNo(int userId, String propertyNo) {
        boolean exist = false;
        try {
            House house = houseMapper.selectByPropertyNo(propertyNo);
            //有该房产证号，说明之前已经上架过了
            if(house!=null){
                exist = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return exist;
    }

    @Override
    /* 新录入房源, 填入空的房源详细信息, 不属于挂牌阶段 , 待详细信息输入完毕, 再进行挂牌*/
    public boolean uploadHouse(User user, House house){
        houseMapper.insertSelective(house);
        HouseDetail houseDetail = new HouseDetail();
        houseDetail.setHouseNo(house.getHouseNo());
        houseDetailMapper.insertSelective(houseDetail);
        if(user.getRole() == 1) {
            Hangout hangout = new Hangout();
            hangout.setCreated(new Date());
            hangout.setHouseNo(house.getHouseNo());
            hangout.setUserId(user.getUserId());
            hangout.setPeriod(3);
            hangoutMapper.insertSelective(hangout);
        }
        else{
            AgentHangout hangout = new AgentHangout();
            hangout.setCreated(new Date());
            hangout.setHouseNo(house.getHouseNo());
            hangout.setWorkNo(user.getUserId());
            hangout.setPeriod(3);
            agentHangoutMapper.insertSelective(hangout);
        }
        return true;
    }

    /*操作：进行房源详细信息录入(待实现)*/
    @Override
    public String uploadHouseDetail(MultipartFile[] insideUrl,
                                    MultipartFile[] outsideUrl,
                                    MultipartFile[] envUrl,
                                    MultipartFile coverUrl,
                                    MultipartFile video,
                                    int houseNo,User user,
                                    HttpServletRequest request) {
        String result = "0";
        int period = 3;     //默认挂牌3个月
        int userId = user.getUserId();
        HouseDetail houseDetail = getHouseDetail(request);
        houseDetail.setHouseNo(houseNo);

        /* 这一系列的URL都是文件存储完成后 得到的文件路径, 存进数据库*/
        String insideUrlFinal = "";
        String outsideUrlFinal = "";
        String envUrlFinal = "";
        String videoUrlFinal = "";
        String coverUrlFinal = "";
        String tempUrl = "";

        System.out.println(coverUrl.getContentType()+" "+insideUrl.length+ " " +outsideUrl.length + " " +envUrl.length+" "+video.getContentType() );
        if (coverUrl.getContentType().startsWith("image")) {
            tempUrl = imgTools.saveHouseImg(coverUrl, userId, houseNo);
            coverUrlFinal = tempUrl;
        }
        if (insideUrl.length > 0 && insideUrl[0].getContentType().startsWith("image")) {
            for (MultipartFile file : insideUrl) {
                System.out.println(file.getContentType());
                System.out.println(file.getOriginalFilename());
                if (file.getContentType().startsWith("image")) {
                    tempUrl = imgTools.saveHouseImg(file, userId, houseNo);
                    insideUrlFinal += tempUrl + ";";
                }
            }
        }
        if (outsideUrl.length > 0 && outsideUrl[0].getContentType().startsWith("image")) {
            for (MultipartFile file : outsideUrl) {
                System.out.println(file.getOriginalFilename());
                System.out.println(file.getContentType());
                if (file.getContentType().startsWith("image")) {
                    tempUrl = imgTools.saveHouseImg(file, userId, houseNo);
                    outsideUrlFinal += tempUrl + ";";
                }
            }
        }
        if (envUrl.length > 0 && envUrl[0].getContentType().startsWith("image")) {
            for (MultipartFile file : envUrl) {
                System.out.println(file.getOriginalFilename());
                System.out.println(file.getContentType());
                if (file.getContentType().startsWith("image")) {
                    tempUrl = imgTools.saveHouseImg(file, userId, houseNo);
                    envUrlFinal += tempUrl + ";";
                }
            }
        }
        if (video.getContentType().startsWith("video")) {
            System.out.println("video :" + video.getContentType() + " name: " + video.getOriginalFilename());
            try {
                String relativePath = "video/house/" + userId + "/" + houseNo;
                videoUrlFinal = imgTools.saveFile(video, relativePath);
            } catch (Exception e) {
                System.out.println("视频存储错误");
                e.printStackTrace();
            }
        }
        System.out.println("coverOrigin " + request.getParameter("coverOrigin"));
        System.out.println("insideOrigin " + request.getParameter("insideOrigin"));
        System.out.println("outsideOrigin " + request.getParameter("outsideOrigin"));
        System.out.println("envOrigin " + request.getParameter("envOrigin"));

        //历史图片： 用户在前端对预览图片操作后的图片列表(不包括新上传的)
        //如果用户这一次没上传图片，则选择从历史图片找
        if(coverUrlFinal.length()<2){
            coverUrlFinal = request.getParameter("coverOrigin"); //置空串, 因为前端可能删除了原有的封面图
        }

        //补全历史图片。相当于历史的  加上新的
        insideUrlFinal = request.getParameter("insideOrigin") + insideUrlFinal;

        //补全历史图片
        outsideUrlFinal = request.getParameter("outsideOrigin") + outsideUrlFinal;

        //补全历史图片
        envUrlFinal = request.getParameter("envOrigin") + envUrlFinal;


        if(insideUrlFinal.length()>1){
            insideUrlFinal = insideUrlFinal.substring(0,insideUrlFinal.length()-1);
        }
        if(outsideUrlFinal.length()>1){
            outsideUrlFinal = outsideUrlFinal.substring(0,outsideUrlFinal.length()-1);
        }
        if(envUrlFinal.length()>1){
            envUrlFinal = envUrlFinal.substring(0,envUrlFinal.length()-1);
        }

        System.out.println("各种文件存储后生成的路径：");
        System.out.println("封面图: " + coverUrlFinal);
        System.out.println("室内图: " + insideUrlFinal);
        System.out.println("室外图: " + outsideUrlFinal);
        System.out.println("环境图: " + envUrlFinal);
        System.out.println("视频路径:" + videoUrlFinal);

        houseDetail.setCoverUrl(coverUrlFinal);
        houseDetail.setInsideUrl(insideUrlFinal);
        houseDetail.setOutsideUrl(outsideUrlFinal);
        houseDetail.setEnvUrl(envUrlFinal);

        if (videoUrlFinal.length()>0)
            houseDetail.setVideoUrl(videoUrlFinal);


        if (houseDetailMapper.selectByPrimaryKey(houseNo) == null) {
            System.out.println(houseNo + "  的房源详细未存在新增房源详细");
            houseDetailMapper.insertSelective(houseDetail);
            result = "1";
        } else {
            System.out.println(houseNo + "  执行修改房源详细");
            houseDetailMapper.updateByPrimaryKeySelective(houseDetail);
            result = "2";
        }

        Date date = new Date(System.currentTimeMillis());
        if(user.getRole()==1) {
            System.out.println("个人");
            Hangout hangout = new Hangout();
            hangout.setHouseNo(houseNo);
            hangout.setUserId(userId);
            hangout.setCreated(date);
            hangout.setPeriod(period);
            hangoutMapper.updateByPrimaryKeySelective(hangout);
        }else{
            System.out.println("中介");
            AgentHangout hangout = new AgentHangout();
            hangout.setHouseNo(houseNo);
            hangout.setWorkNo(userId);
            hangout.setCreated(date);
            hangout.setPeriod(period);
            agentHangoutMapper.updateByPrimaryKeySelective(hangout);
        }
        System.out.println("房源挂牌修改成功");
        System.out.println("house: " + houseDetail);
        return  result;
    }



    /* 将表单转成Pojo, 因为表单包含文件, 所以暂未找到用RequestBody从前端接收JSON直接转成Pojo的方法, 所以手动转了*/
    private HouseDetail getHouseDetail(HttpServletRequest request){
        /* 其实可以将表单序列化成JSON对象, 然后在这里转就行了！！！*/
        HouseDetail houseDetail = new HouseDetail();
        /* 保留一个位置给 HouseNo*/
        System.out.println("title " + request.getParameter("title"));
        System.out.println("size " + request.getParameter("size"));
        System.out.println("region " + request.getParameter("region"));
        System.out.println("address " + request.getParameter("address"));
        System.out.println("roomNum " + request.getParameter("roomNum"));
        System.out.println("hallNum " + request.getParameter("hallNum"));
        System.out.println("toiletNum " + request.getParameter("toiletNum"));
        System.out.println("kitchenNum " + request.getParameter("kitchenNum"));
        System.out.println("buildYear " + request.getParameter("buildYear"));
        System.out.println("floor " + request.getParameter("floor"));
        System.out.println("maxFloor " + request.getParameter("maxFloor"));
        System.out.println("faceAt " + request.getParameter("faceAt"));
        System.out.println("lookTime " + request.getParameter("lookTime"));
        System.out.println("decoration " + request.getParameter("decoration"));
        System.out.println("t1 " + request.getParameter("t1"));
        System.out.println("t2 " + request.getParameter("t2"));
        System.out.println("t3 " + request.getParameter("t3"));
        System.out.println("yongTu " + request.getParameter("yongTu"));
        System.out.println("ownStatus " + request.getParameter("ownStatus"));
        System.out.println("structure " + request.getParameter("structure"));
        System.out.println("elevator " + request.getParameter("elevator"));
        System.out.println("diyaInfo " + request.getParameter("diyaInfo"));
        System.out.println("title " + request.getParameter("title"));
        System.out.println("sellReason " + request.getParameter("sellReason"));
        System.out.println("houseInfo " + request.getParameter("houseInfo"));
        System.out.println("keyPoint " + request.getParameter("keyPoint"));
        houseDetail.setCommunity(request.getParameter("community"));
        houseDetail.setTitle(request.getParameter("title"));
        houseDetail.setRegion(request.getParameter("region"));
        houseDetail.setAddress(request.getParameter("address"));
        houseDetail.setBuildYear(request.getParameter("buildYear"));
        houseDetail.setFloor(request.getParameter("floor"));
        houseDetail.setFaceAt(request.getParameter("faceAt"));
        houseDetail.setLookTime(request.getParameter("lookTime"));
        houseDetail.setDecoration(request.getParameter("decoration"));
        houseDetail.setYongTu(request.getParameter("yongTu"));
        houseDetail.setOwnStatus(request.getParameter("ownStatus"));
        houseDetail.setStructure(request.getParameter("structure"));
        houseDetail.setElevator(request.getParameter("elevator"));
        houseDetail.setDiyaInfo(request.getParameter("diyaInfo"));
        houseDetail.setSellReason(request.getParameter("sellReason"));
        houseDetail.setHouseInfo(request.getParameter("houseInfo"));
        houseDetail.setKeyPoint(request.getParameter("keyPoint"));
        /* 数值的统一处理, 事实上这些不能为空的 */
        try {
            houseDetail.setMaxFloor(Integer.parseInt(request.getParameter("maxFloor")));
            houseDetail.setRoomNum(Integer.parseInt(request.getParameter("roomNum")));
            houseDetail.setHallNum(Integer.parseInt(request.getParameter("hallNum")));
            houseDetail.setToiletNum(Integer.parseInt(request.getParameter("toiletNum")));
            houseDetail.setKitchenNum(Integer.parseInt(request.getParameter("kitchenNum")));
            houseDetail.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
            houseDetail.setSize(BigDecimal.valueOf(Double.parseDouble(request.getParameter("size"))));
            System.out.println(request.getParameter("lat").substring(0,8));
            System.out.println(BigDecimal.valueOf(Double.parseDouble(request.getParameter("lat").substring(0,8))));
            houseDetail.setLatitude(BigDecimal.valueOf(Double.parseDouble(request.getParameter("lat").substring(0,8))));
            houseDetail.setLongitude(BigDecimal.valueOf(Double.parseDouble(request.getParameter("lng").substring(0,8))));
        }catch (Exception e){
            System.out.println("数值转换过程错误");
            e.printStackTrace();
        }
        String tag = "";
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");
        String t3 = request.getParameter("t3");
        if(t1!=null){
            tag += "t1";
            System.out.println("近地铁");
        }else{
            tag += "t0";
        }
        if(t2!=null){
            tag += "t2";
            System.out.println("近学区");
        }else{
            tag+="t0";
        }
        if(t3!=null){
            tag += "t3";
            System.out.println("有电梯");
        }else{
            tag+="t0";
        }
        houseDetail.setTag(tag);
        return houseDetail;
    }
}
