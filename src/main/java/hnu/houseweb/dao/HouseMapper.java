package hnu.houseweb.dao;

import hnu.houseweb.entity.House;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface HouseMapper {
    int deleteByPrimaryKey(Integer houseno);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer houseno);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    @Select("select * from house where houseNo = #{houseNo}")
    House selectByHouseNo(@Param("houseNo") String houseNo);

    @Select("select * from house where propertyNo = #{propertyNo}")
    House selectByPropertyNo(@Param("propertyNo") String propertyNo);

    @Insert("insert into house(propertyNo) value(#{propertyNo})")
    int insertHouse(@Param("propertyNo") String propertyNo);

    @Delete("delete from house where houseNo=#{houseNo}")
    int deleteHouse(@Param("houseNo") String houseNo);
}