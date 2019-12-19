package hnu.houseweb.dao;

import hnu.houseweb.entity.Law;
import org.springframework.stereotype.Repository;

@Repository
public interface LawMapper {
    int deleteByPrimaryKey(String lawno);

    int insert(Law record);

    int insertSelective(Law record);

    Law selectByPrimaryKey(String lawno);

    int updateByPrimaryKeySelective(Law record);

    int updateByPrimaryKeyWithBLOBs(Law record);

    int updateByPrimaryKey(Law record);
}