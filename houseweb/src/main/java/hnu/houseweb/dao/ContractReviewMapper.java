package hnu.houseweb.dao;

import hnu.houseweb.entity.ContractReview;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractReviewMapper {
    int deleteByPrimaryKey(String id);

    int insert(ContractReview record);

    int insertSelective(ContractReview record);

    ContractReview selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ContractReview record);

    int updateByPrimaryKey(ContractReview record);
}