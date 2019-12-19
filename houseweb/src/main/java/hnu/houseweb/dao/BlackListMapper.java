package hnu.houseweb.dao;

import hnu.houseweb.entity.BlackList;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlackList record);

    int insertSelective(BlackList record);

    BlackList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BlackList record);

    int updateByPrimaryKey(BlackList record);
}