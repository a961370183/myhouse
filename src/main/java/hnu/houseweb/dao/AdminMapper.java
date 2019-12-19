package hnu.houseweb.dao;

import hnu.houseweb.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(String adminno);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminno);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}