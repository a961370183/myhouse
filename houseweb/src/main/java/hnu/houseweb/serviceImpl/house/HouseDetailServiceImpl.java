package hnu.houseweb.serviceImpl.house;

import hnu.houseweb.dao.*;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.house.HouseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HouseDetailServiceImpl implements HouseDetailService {

    @Autowired
    HouseDetailMapper housedetailMapper;
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    HangoutMapper hangoutMapper;
    @Autowired
    AgentHangoutMapper agentHangoutMapper;

    @Autowired
    HouseReviewMapper houseReviewMapper;

    @Override
    public UserHouse getUserHouse(int houseNo) {
        return housedetailMapper.userHouseDetail(houseNo);
    }

    @Override
    public AgentHouse getAgentHouse(int houseNo) {
        return housedetailMapper.agentHouseDetail(houseNo);
    }

    @Override
    public List<HousePart> getHouseByUserId(int userId) {
        return housedetailMapper.findHouseByUserId(userId);
    }

    @Override
    public List<HousePart> getHouseByWorkNo(int workNo) {
        return housedetailMapper.findHouseByWorkNo(workNo);
    }

    @Override
    /*删除房源、房源明细、挂牌明细*/
    public boolean deleteUserHouseByHouseNo(int houseNo,int userId){
        boolean result = true;
        housedetailMapper.deleteByPrimaryKey(houseNo);
        houseMapper.deleteByPrimaryKey(houseNo);
        HangoutKey hangoutKey = new HangoutKey();
        hangoutKey.setHouseNo(houseNo);
        hangoutKey.setUserId(userId);
        hangoutMapper.deleteByPrimaryKey(hangoutKey);
        return result;
    }

    @Override
    /*删除房源、房源明细、挂牌明细*/
    public boolean deleteAgentHouseByHouseNo(int houseNo,int workNo){
        boolean result = true;
        housedetailMapper.deleteByPrimaryKey(houseNo);
        houseMapper.deleteByPrimaryKey(houseNo);
        AgentHangoutKey agentHangoutKey = new AgentHangoutKey();
        agentHangoutKey.setHouseNo(houseNo);
        agentHangoutKey.setWorkNo(workNo);
        agentHangoutMapper.deleteByPrimaryKey(agentHangoutKey);
        return result;
    }

    @Override
    public List<HouseDetail> getCollectHouse(int userid) {
        List<HouseDetail> houseDetailList=new ArrayList<HouseDetail>();
        houseDetailList=housedetailMapper.selectByUseridInCollect(userid);
        for (HouseDetail houseDetail : houseDetailList){
            int houseno =houseDetail.getHouseNo();
            if (hangoutMapper.countByHouseNo(houseno)==0){
                houseDetail.setRole(0);
            }
            else{
                houseDetail.setRole(1);
            }
        }
        return houseDetailList;
    }

    @Override
    public int getKeeperId(int houseNo) {
        int integer= -1;
        if (hangoutMapper.selectUserIdByHouseNo(houseNo)!=null){
            integer=hangoutMapper.selectUserIdByHouseNo(houseNo);
        }
        else if (agentHangoutMapper.selectWorkNoByHouseNo(houseNo)!=null){
            integer=agentHangoutMapper.selectWorkNoByHouseNo(houseNo);
        }
        return integer;
    }

    @Override
    public List<Map> getUnCheckedHouse() {
        List list = new ArrayList();
        List<House> houseList=houseMapper.selectByStatus(0);
        for (House house : houseList){
            Map map =new HashMap();
            map.put("house",house);
            int no=house.getHouseNo();
            HouseDetail u = housedetailMapper.userHouseDetail(no);

            HouseDetail a = housedetailMapper.agentHouseDetail(no);

            if (u!=null){
                u.setRole(1);
                map.put("houseDetail",u);

            }
            else{
                a.setRole(2);
                map.put("houseDetail",a);

            }
            list.add(map);
        }
        return list;
    }

    @Override
    public int changeStatus(int houseNo, int status) {
        return houseMapper.updateStatus(houseNo,status);
    }

    @Override
    public int updateHouseCheck(int houseNo, String comment, int status) {
        HouseReview houseReview=new HouseReview();
        houseReview.setAdminNo(26010500);
        houseReview.setHouseNo(houseNo);
        houseReview.setComment(comment);
        houseReview.setCreated(new Date());
        houseReview.setResult(status==1?"1":"2");
        houseReviewMapper.insert(houseReview);
        return houseMapper.updateStatus(houseNo,status);
    }
}
