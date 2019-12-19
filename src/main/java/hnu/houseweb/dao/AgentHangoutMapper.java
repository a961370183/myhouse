package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentHangout;
import hnu.houseweb.entity.AgentHangoutKey;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentHangoutMapper {
    int deleteByPrimaryKey(AgentHangoutKey key);

    int insert(AgentHangout record);

    int insertSelective(AgentHangout record);

    AgentHangout selectByPrimaryKey(AgentHangoutKey key);

    int updateByPrimaryKeySelective(AgentHangout record);

    int updateByPrimaryKey(AgentHangout record);
}