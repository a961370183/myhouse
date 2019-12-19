package hnu.houseweb.dao;

import hnu.houseweb.entity.Hangout;
import hnu.houseweb.entity.HangoutKey;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HangoutMapper {
    int deleteByPrimaryKey(HangoutKey hangoutKey);

    int insert(Hangout record);

    int insertSelective(Hangout record);

    Hangout selectByPrimaryKey(HangoutKey hangoutKey);

    int updateByPrimaryKeySelective(Hangout record);

    int updateByPrimaryKey(Hangout record);

    @Select("select * from hangout where userId=#{userId} and houseNo=#{houseNo}")
    Hangout selectByPrimaryKey(@Param("userId") int userId, @Param("houseNo") int houseNo);

    @Insert("insert into hangout(userId, houseNo) value(#{userId},#{houseNo})")
    int insertHangout(@Param("userId") int userId, @Param("houseNo") int houseNo);

    @Select("select COUNT(*) from hangout where houseNo = #{houseno}")
    int countByHouseNo(@Param("houseno") int houseno);

    @Select("select * from hangout where userId=#{userId}")
    List<Hangout> selectByUserId(@Param("userId") int userId);

    @Select("select userId from hangout where houseNo=#{houseNo} LIMIT 1")
    Integer selectUserIdByHouseNo(@Param("houseNo") int houseNo);
}