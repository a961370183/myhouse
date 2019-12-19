package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentHangout;
import hnu.houseweb.entity.AgentHangoutKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentHangoutMapper {
    int deleteByPrimaryKey(AgentHangoutKey key);

    int insert(AgentHangout record);

    int insertSelective(AgentHangout record);

    AgentHangout selectByPrimaryKey(AgentHangoutKey key);

    int updateByPrimaryKeySelective(AgentHangout record);

    int updateByPrimaryKey(AgentHangout record);

    @Select("select workNo from agentHangout where houseNo=#{houseNo} LIMIT 1")
    Integer selectWorkNoByHouseNo(@Param("houseNo") int houseNo);

    @Select("select houseNo from agentHangout where workNo = #{workNo,jdbcType=INTEGER}")
    List<Integer> selectHouseByWorkNo(int workNo);
}