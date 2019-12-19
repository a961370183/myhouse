package hnu.houseweb.dao;

import hnu.houseweb.entity.ServiceEvaluation;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceEvaluationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceEvaluation record);

    int insertSelective(ServiceEvaluation record);

    ServiceEvaluation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceEvaluation record);

    int updateByPrimaryKey(ServiceEvaluation record);
}