package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentReview;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentReviewMapper {
    int deleteByPrimaryKey(String id);

    int insert(AgentReview record);

    int insertSelective(AgentReview record);

    AgentReview selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AgentReview record);

    int updateByPrimaryKey(AgentReview record);
}