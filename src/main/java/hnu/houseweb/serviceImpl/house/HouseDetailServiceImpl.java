package hnu.houseweb.serviceImpl.house;

import hnu.houseweb.dao.AgentHangoutMapper;
import hnu.houseweb.dao.HangoutMapper;
import hnu.houseweb.dao.HouseDetailMapper;
import hnu.houseweb.dao.HouseMapper;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.house.HouseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
