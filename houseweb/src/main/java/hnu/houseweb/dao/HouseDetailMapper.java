package hnu.houseweb.dao;

import hnu.houseweb.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface HouseDetailMapper {
    int deleteByPrimaryKey(Integer houseno);

    int insert(HouseDetail record);

    int insertSelective(HouseDetail record);

    HouseDetail selectByPrimaryKey(Integer houseno);

    int updateByPrimaryKeySelective(HouseDetail record);

    int updateByPrimaryKey(HouseDetail record);

    @Select("select * from houseDetail where houseNo=any(select houseNo from collect where userId= #{userid} order by created DESC)")
    List<HouseDetail> selectByUseridInCollect(@Param("userid") int userid);

//    @Select("select houseNo,title,city,district,size,tag,price,roomNum,hallNum,elevator,coverUrl,community,address,type from housedetail")
    List<HousePart> getSome();

    /*检索页面用到的Dao*/
    //根据检索条件查询个人房源列表，以及总数(用于分页)
    List<HousePart> findUserHouse(@Param("HouseParam") HouseParam houseParam);
    int findUserHouseTotal(@Param("HouseParam") HouseParam houseParam);
    //根据检索条件查询中介房源列表，以及总数(用于分页)
    List<HousePart> findAgentHouse(@Param("HouseParam") HouseParam houseParam);
    int findAgentHouseTotal(@Param("HouseParam") HouseParam houseParam);
    //根据检索条件查询两种角色的房源列表，以及总数(用于分页)
    List<HousePart> findBoth(@Param("HouseParam") HouseParam houseParam);
    int findBothTotal(@Param("HouseParam") HouseParam houseParam);
    List<HousePart> mapFindBoth(@Param("HouseParam") HouseParam houseParam);

    /*房源详细浏览页面用到的Dao， 分为个人和中介两个*/
    UserHouse userHouseDetail(int houseNo);
    AgentHouse agentHouseDetail(int houseNo);

    /*房源管理：根据UserId，或者WorkNo 查找该角色持有的房源列表*/
    List<HousePart> findHouseByUserId(int userId);
    List<HousePart> findHouseByWorkNo(int workNo);

    /*各区的房源数量统计*/
    List<HouseCount> regionHouseCount();

    /* 查找小区房源数量 */
    int communityHouseCount(String communityNo);
}