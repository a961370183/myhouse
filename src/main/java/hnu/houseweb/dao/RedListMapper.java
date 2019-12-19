package hnu.houseweb.dao;

import hnu.houseweb.entity.RedList;
import org.springframework.stereotype.Repository;

@Repository
public interface RedListMapper {
    int deleteByPrimaryKey(String id);

    int insert(RedList record);

    int insertSelective(RedList record);

    RedList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RedList record);

    int updateByPrimaryKey(RedList record);
}