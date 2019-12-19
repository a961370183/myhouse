package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentHouse;
import hnu.houseweb.entity.House;
import hnu.houseweb.entity.HouseDetail;
import hnu.houseweb.entity.UserHouse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface HouseMapper {
    int deleteByPrimaryKey(Integer houseno);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer houseno);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    @Select("select * from house where houseNo = #{houseNo}")
    House selectByHouseNo(@Param("houseNo") String houseNo);

    @Select("select * from house where propertyNo = #{propertyNo}")
    House selectByPropertyNo(@Param("propertyNo") String propertyNo);

    @Insert("insert into house(propertyNo) value(#{propertyNo})")
    int insertHouse(@Param("propertyNo") String propertyNo);

    @Delete("delete from house where houseNo=#{houseNo}")
    int deleteHouse(@Param("houseNo") String houseNo);

    @Select("select * from house where status=#{status}")
    List<House> selectByStatus(@Param("status") int status);

    @Update("update house set status=#{status} where houseNo=#{houseNo}")
    int updateStatus(@Param("houseNo") int houseNo,@Param("status") int status);

    @Select("select houseDetail.houseNo,title from houseDetail,house,hangout,user where house.houseNo = #{houseNo,jdbcType=INTEGER} and houseDetail.houseNo=house.houseNo and hangout.houseNo=house.houseNo and hangout.userId=user.userId")
    UserHouse getUserHousePart(int houseNo);

    @Select("select houseDetail.houseNo,title from houseDetail,house,agentHangout,agent,company\n" +
            "    where house.houseNo = #{houseNo,jdbcType=INTEGER}\n" +
            "    and houseDetail.houseNo=house.houseNo\n" +
            "    and agentHangout.houseNo=house.houseNo\n" +
            "    and agentHangout.workNo=agent.workNo\n" +
            "    and agent.compNo=company.compNo\n" +
            "    and\n" +
            "      agent.status = '1'")
    AgentHouse getAgentHousePart(int houseNo);

}