package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentPunishment;
import hnu.houseweb.entity.CompPunishment;
import hnu.houseweb.entity.Punishment;
import hnu.houseweb.entity.PunishmentKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PunishmentMapper {
    int deleteByPrimaryKey(PunishmentKey key);

    int insert(Punishment record);

    int insertSelective(Punishment record);

    Punishment selectByPrimaryKey(PunishmentKey key);

    int updateByPrimaryKeySelective(Punishment record);

    int updateByPrimaryKey(Punishment record);

    /*中介检查公示查询*/
    @Select("select a.name,a.workNo,p.created,p.result,p.reason,p.id from punishment p,agent a where p.workNo = a.workNo order by p.created desc")
    List<AgentPunishment> getAgentPunishment();

    /*机构检查公示查询*/
    @Select("select c.compName,c.compNo,p.created,p.result,p.reason,p.id from compPunishment p,company c where p.compNo = c.compNo order by p.created desc")
    List<CompPunishment> getCompPunishment();

    /* 查询中介检查 */
    @Select("select a.name,a.workNo,p.created,p.result,p.reason,p.id from punishment p,agent a where p.workNo = a.workNo and a.name like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') order by p.created desc ")
    List<AgentPunishment> findAgentPunishment(String kw);

    @Select("select c.compName,c.compNo,p.created,p.result,p.reason,p.id from compPunishment p,company c where p.compNo = c.compNo and c.compName like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') order by p.created desc")
    List<CompPunishment> findCompPunishment(String kw);
    /*机构检查公示详细*/
    @Select("select c.*,p.created,p.result,p.reason,p.result,p.id from compPunishment p,company c where p.compNo = c.compNo and id = #{id,jdbcType=VARCHAR} order by p.created desc")
    CompPunishment getCompPunishmentDetail(String id);

    /*中介检查公示详细*/
    @Select("select a.name,a.workNo,p.created,p.result,c.compName,c.address,c.legalRepresentor,p.result,p.reason,p.id from punishment p,agent a,company c where a.compNo = c.compNo and p.workNo = a.workNo and id = #{id,jdbcType=VARCHAR} order by p.created desc")
    AgentPunishment getAgentPunishmentDetail(String id);


    /*
    * 修改
    * 增加
    * */
    @Delete("delete from punishment where id = #{id,jdbcType=VARCHAR}")
    int deleteAgentPunishment(String id);

    @Delete("delete from compPunishment where id = #{id,jdbcType=VARCHAR}")
    int deleteCompPunishment(String id);

    @Insert("insert into punishment(id,adminNo,workNo,reason,created,result) values(#{id,jdbcType=VARCHAR}, #{adminNo,jdbcType=INTEGER}, #{workNo,jdbcType=INTEGER}, #{reason,jdbcType=VARCHAR},#{created,jdbcType=TIMESTAMP}, #{result,jdbcType=VARCHAR})")
    int addAgentPunishment(Punishment p);

    @Insert("insert into compPunishment(id,adminNo,compNo,reason,created,result) values(#{id,jdbcType=VARCHAR}, #{adminNo,jdbcType=INTEGER}, #{compNo,jdbcType=INTEGER}, #{reason,jdbcType=VARCHAR},#{created,jdbcType=TIMESTAMP}, #{result,jdbcType=VARCHAR})")
    int addCompPunishment(Punishment p);

    @Update("update punishment set adminNo = #{adminNo,jdbcType=INTEGER}, workNo = #{workNo,jdbcType=INTEGER}, reason = #{reason,jdbcType=VARCHAR}, created = #{created,jdbcType=TIMESTAMP} ,result =  #{result,jdbcType=VARCHAR}  where id = #{id,jdbcType=VARCHAR}")
    int updateAgentPunishment(Punishment p);

    @Update("update compPunishment set adminNo = #{adminNo,jdbcType=INTEGER}, compNo = #{compNo,jdbcType=INTEGER}, reason = #{reason,jdbcType=VARCHAR}, created = #{created,jdbcType=TIMESTAMP},result =  #{result,jdbcType=VARCHAR}  where id = #{id,jdbcType=VARCHAR}")
    int updateCompPunishment(Punishment p);
}