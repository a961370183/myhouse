package hnu.houseweb.dao;

import hnu.houseweb.entity.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(String adminno);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminno);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("select * from admin where adminNo = #{adminNo,jdbcType=INTEGER} and password = #{password,jdbcType=VARCHAR}")
    Admin findAdminByNo(int adminNo,String password);

    @Select("select * from admin where name = #{name,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}")
    Admin findAdminByName(String name,String password);
}