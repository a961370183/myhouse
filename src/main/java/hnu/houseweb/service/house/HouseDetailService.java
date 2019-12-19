package hnu.houseweb.service.house;

import hnu.houseweb.entity.AgentHouse;
import hnu.houseweb.entity.HouseDetail;
import hnu.houseweb.entity.HousePart;
import hnu.houseweb.entity.UserHouse;

import java.util.List;

public interface HouseDetailService {
    /*获取个人房源*/
    public UserHouse getUserHouse(int houseNo);
    /*获取中介房源*/
    public AgentHouse getAgentHouse(int houseNo);

    public List<HousePart> getHouseByUserId(int userId);

    public List<HousePart> getHouseByWorkNo(int workNo);

    public boolean deleteUserHouseByHouseNo(int houseNo,int userId);

    public boolean deleteAgentHouseByHouseNo(int houseNo,int workNo);

    /*获取收藏房源*/
    public List<HouseDetail> getCollectHouse(int userid);
}
