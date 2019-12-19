package hnu.houseweb.dao;

import hnu.houseweb.entity.BlackList;
import hnu.houseweb.entity.CompPunishment;
import hnu.houseweb.entity.RedList;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedListMapper {
    int deleteByPrimaryKey(String id);

    int insert(RedList record);

    int insertSelective(RedList record);

    RedList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RedList record);

    int updateByPrimaryKey(RedList record);

    @Select("select a.name,r.* from redList r,agent a where r.workNo = a.workNo order by r.created desc")
    List<RedList> getRedList();

    @Select("select a.name,r.* from blackList r,agent a where r.workNo = a.workNo order by r.created desc")
    List<BlackList> getBlackList();

    @Select("select a.name,r.* from redList r,agent a where r.workNo = a.workNo and a.name like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') order by r.created desc")
    List<RedList> findRedList(String kw);

    @Select("select a.name,r.* from blackList r,agent a where r.workNo = a.workNo and a.name like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') order by r.created desc")
    List<BlackList> findBlackList(String kw);

    @Select("select a.name,a.workNo,c.compName,a.imgSrc,r.* from redList r,agent a,company c where r.workNo = a.workNo and a.compNo = c.compNo and id = #{id,jdbcType=VARCHAR}")
    RedList getRedDetail(String id);

    @Select("select a.name,a.workNo,c.compName,a.imgSrc,r.* from blackList r,agent a,company c where r.workNo = a.workNo and a.compNo = c.compNo and id = #{id,jdbcType=VARCHAR}")
    BlackList getBlackDetail(String id);

}