package hnu.houseweb.dao;

import hnu.houseweb.entity.Area;
import hnu.houseweb.entity.Village;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageMapper {

    /*用于房源挂牌时输入搜索联动*/
    public List<Village> search(String keyword);

    @Select("select id,name,latitude,longitude from village")
    public List<Village> getAll();

    @Update("update village set latitude = #{lat,jdbcType=VARCHAR},longitude = #{lng,jdbcType=VARCHAR} where id = #{id,jdbcType=VARCHAR}")
    public void updateV(String lat,String lng,String id);

    /*获得视野内的小区village*/
    @Select("select id,latitude,longitude,name,(select count(houseNo) from houseDetail where communityNo = id) count from village where (latitude BETWEEN #{min_lat} AND #{max_lat}) AND (longitude BETWEEN #{min_lng} AND #{max_lng}) ")
    public List<Village> villageCanSee(String max_lat,String max_lng,String min_lat,String min_lng);

    @Insert("insert into area(id,name,latitude,longitude,border) values(#{id,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR},#{latitude,jdbcType=VARCHAR},#{longitude,jdbcType=VARCHAR},#{border,jdbcType=VARCHAR})")
    public void addArea(String id,String name,String latitude,String longitude,String border);

    @Delete("delete from area where id = #{id,jdbcType=VARCHAR}")
    public void deleteArea(String id);

    @Select("select * from area where id like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') OR name like CONCAT('%',#{kw,jdbcType=VARCHAR},'%')")
    public List<Area> findArea(String kw);

    /*获得视野内的区域area*/
    @Select("select * from area where (latitude BETWEEN #{min_lat} AND #{max_lat}) AND (longitude BETWEEN #{min_lng} AND #{max_lng})")
    public List<Area> areaCanSee(String max_lat,String max_lng,String min_lat,String min_lng);

    /* 获得全部area，用于火星坐标转换 */
    @Select("select id,name from area")
    public List<Area> areaAll();
    @Select("select id,name,longitude,latitude,border from area where id = #{id,jdbcType=VARCHAR}")
    public Area getAreaDetail(String id);
    @Update("update area set longitude = #{longitude,jdbcType=VARCHAR}, latitude=#{latitude,jdbcType=VARCHAR}, border = #{border,jdbcType=VARCHAR} where id = #{id,jdbcType=VARCHAR}")
    public int updateArea(String id,String name,String latitude,String longitude,String border);

    /* 小区增删查改*/
    @Select("select id,name from village")
    public List<Village> villageAll();
    @Select("select id,name,address,year,build_type,property_costs,property_company,longitude,latitude from village where id = #{id,jdbcType=VARCHAR}")
    public Village getVillageDetail(String id);
    @Update("update village set longitude = #{longitude,jdbcType=VARCHAR}, latitude=#{latitude,jdbcType=VARCHAR}, address = #{address,jdbcType=VARCHAR},name = #{name,jdbcType=VARCHAR},year = #{year,jdbcType=VARCHAR},build_type = #{build_type,jdbcType=VARCHAR},property_costs = #{property_costs,jdbcType=VARCHAR},property_company = #{property_company,jdbcType=VARCHAR} where id = #{id,jdbcType=VARCHAR}")
    public int updateVillage(String id,String name,String latitude,String longitude,String address,String year,String build_type,String property_costs,String property_company);
    @Delete("delete from village where id = #{id,jdbcType=VARCHAR}")
    public void deleteVillage(String id);
    @Insert("insert into village(id,name,latitude,longitude,address,build_type,property_costs,property_company) values(#{id,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR},#{latitude,jdbcType=VARCHAR},#{longitude,jdbcType=VARCHAR},#{address,jdbcType=VARCHAR},#{build_type,jdbcType=VARCHAR},#{property_costs,jdbcType=VARCHAR},#{property_company,jdbcType=VARCHAR})")
    public void addVillage(String id,String name,String latitude,String address,String longitude,String year,String build_type,String property_costs,String property_company);
    @Select("select * from village where id like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') OR name like CONCAT('%',#{kw,jdbcType=VARCHAR},'%')")
    public List<Village> findVillage(String kw);


}