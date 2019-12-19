package hnu.houseweb.dao;

import hnu.houseweb.entity.HouseReview;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseReviewMapper {
    int deleteByPrimaryKey(String id);

    int insert(HouseReview record);

    int insertSelective(HouseReview record);

    HouseReview selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HouseReview record);

    int updateByPrimaryKey(HouseReview record);
}