package hnu.houseweb.dao;
import hnu.houseweb.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

   @Insert("insert user (userName,password,email,tel) values (#{userName},#{password},#{email},#{tel})")
    public void save( String userName, String password, String email,String tel);

   @Select("select * from user order by userid limit #{page},#{size}")
    public List<User> getAllPage(@Param("page") int page,@Param("size") int size);

    @Select("select * from user")
    public List<User> getAll();

    @Select("select * from user where username = #{userName}")
    public User findByUserName(@Param("userName") String userName);

    @Select("select * from user where userName= #{username}")
    public User exists(@Param("username") String username);

    @Select("select password from user where userName= #{userName}")
    public String getPassword(@Param("userName") String userName);

    @Delete("delete from user where id = #{id}")
    public void delete(@Param("id") int id);

    @Select( "select rname from user ,role where user.role=role.role and userName= #{userName}" )
    String getUserType(@Param("userName")String userName);

    @Update("update user set nickname=#{nickName} where userName = #{userName}")
    public void changeNick(String userName,String nickName);

    @Update("update user set email=#{email} where userName = #{userName}")
    public void changeEmail( String userName, String email);

    @Update("update user set img=#{file} where userName = #{userName}")
    void queryImg(String file,String userName);

    @Update("update user set name=#{name} where userName = #{userName}")
    void changeName(String userName, String name);

    @Update("update user set password=#{newPassword} where userName = #{userName}")
    void changePassword(String userName, String newPassword);

    @Update("update user set role=#{role} where userId= #{userId}")
    void changeStatus(String userId, int role);
    @Update("update user set tel=#{tel} where userName = #{userName}")
    void changeTel(String userName, String tel);
}
