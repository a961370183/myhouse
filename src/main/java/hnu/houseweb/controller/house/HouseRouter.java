package hnu.houseweb.controller.house;

import hnu.houseweb.entity.*;
import hnu.houseweb.service.company.CompanyService;
import hnu.houseweb.service.house.CollectService;
import hnu.houseweb.service.house.HouseDetailService;
import hnu.houseweb.service.house.HouseSearchService;
import hnu.houseweb.serviceImpl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class HouseRouter {
    @Autowired
    HouseDetailService houseDetailImpl;
    @Autowired
    CollectService collectServiceImpl;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CompanyService companyServiceImpl;
    @Autowired
    HouseSearchService houseSearchImpl;

    /* 路由到房源浏览首页, 同时也是检索房源页面 */
    @RequestMapping("/house/**/**")
    public String leadToIndex(Model mv, HttpServletRequest request){
        System.out.println(request.getParameter("page"));
        String currentPage = request.getParameter("page");
        if(currentPage==null){
            currentPage = "1";
        }
        String paramUrl = request.getServletPath();
        if(paramUrl.length()>7){
            paramUrl = paramUrl.substring(7);
            paramUrl += "-"+ currentPage;
        }else{
            paramUrl = currentPage;
        }

        /* 携带公司机构列表、房源列表到页面, 页面对这些数据进行渲染 */
        List<CompanyPart> comps = companyServiceImpl.getSomeComps();
        Map map= houseSearchImpl.mapFind(paramUrl);
        List<HousePart> houses = null;
        int totalNum = 0;
        try {
            houses = (List<HousePart>) map.get("house");
            totalNum = (int)map.get("totalNum");
        }catch (Exception e){
            System.out.println("Map 房子列表 类型转换失败");
            e.printStackTrace();
        }
        User user = userService.userInfo();
        mv.addAttribute("comps",comps);
        mv.addAttribute("houses",houses);
        mv.addAttribute("currentPage",currentPage);
        mv.addAttribute("totalNum",totalNum);
        mv.addAttribute("userInfo",user);

        /*路由*/
        return "house/index";
    }


    /*路由到房源详情页面, 这里是个人房源的URL访问路径, 参数为房源编号*/
    @RequestMapping("/userHouseDetail/{houseno}")
    public String userHouseDetail(Model mv, @PathVariable int houseno ){
        //获取用户id
        int userId = getUserId();
        User user = userService.userInfo();
        //检测该用户对当前房源是否已收藏, 把收藏信息带回到房源详情页面
        CollectKey ck = new CollectKey();
        mv.addAttribute("house",houseDetailImpl.getUserHouse(houseno));
        System.out.println(mv.getAttribute("house"));
        ck.setHouseNo(houseno);
        ck.setUserId(userId);
        Collect c = collectServiceImpl.getCollect(ck);
        if(c!=null){
            mv.addAttribute("collect",c);
        }
        mv.addAttribute("userInfo",user);
        //路由到房源详情页面，并携带者上面获取到的房源详情对象,以及收藏信息
        return "house/houseDetail";
    }

    /*路由到房源详情页面, 这里是中介房源的URL访问路径, 参数为房源编号*/
    @RequestMapping("/agentHouseDetail/{houseNo}")
    public String agentHouseDetail(Model mv, @PathVariable int houseNo ){
        //获取用户id
        int userId = getUserId();
        User user = userService.userInfo();
        //检测该用户对当前房源是否已收藏, 把收藏信息带回到房源详情页面
        CollectKey ck = new CollectKey();
        mv.addAttribute("house",houseDetailImpl.getAgentHouse(houseNo));
        ck.setHouseNo(houseNo);
        ck.setUserId(userId);
        Collect c = collectServiceImpl.getCollect(ck);
        if(c!=null){
            mv.addAttribute("collect",c);
        }
        mv.addAttribute("userInfo",user);
        //路由到房源详情页面，并携带者上面获取到的房源详情对象,以及收藏信息
        return "house/houseDetail";
    }

    /*路由到 房源挂牌详细信息页，可进行修改或者新增房源详细信息*/
    @RequestMapping("/houseUpload/{houseNo}")
    public String houseUpload(Model mv, @PathVariable int houseNo, HttpServletResponse response) throws Exception{
        int role = 1;
        UserHouse userHouseDetail = null;
        AgentHouse agentHouseDetail = null;
        User user = userService.userInfo();
        if(role==1){
            userHouseDetail = houseDetailImpl.getUserHouse(houseNo);
            /* 验证房源归属 , 不匹配则跳回房源首页*/
            if(userHouseDetail!=null){
                if(!userHouseDetail.getName().equals(user.getName())){
                    response.sendRedirect("/house");
                }else{
                    mv.addAttribute("houseDetail",userHouseDetail);
                }
            }
        }else if(role==2){
            agentHouseDetail = houseDetailImpl.getAgentHouse(houseNo);
            /* 验证房源归属 , 不匹配则跳回房源首页*/
            if(agentHouseDetail!=null) {
                if (!agentHouseDetail.getName().equals(user.getName())) {
                    response.sendRedirect("/house");
                }else{
                    mv.addAttribute("houseDetail",agentHouseDetail);
                }
            }
        }else {
            response.sendRedirect("/house");
        }
        mv.addAttribute("userInfo",user);
        return "house/houseUpload";
    }

    /* 路由到房产证号录入界面 */
    @RequestMapping("/propertyPage/")
    public String propertyPage(Model mv){
        User user =  userService.userInfo();
        mv.addAttribute("userInfo",user);
        return "house/propertyPage";
    }

    /*地图找房*/
    @RequestMapping("/mapSearch")
    public String mapSearch(){
        return "house/mapSearch";
    }
    /*获取userId*/
    private int getUserId(){
        User user = userService.userInfo();
        if(user!=null)
            return user.getUserId();
        else
            return 0;
    }
}
