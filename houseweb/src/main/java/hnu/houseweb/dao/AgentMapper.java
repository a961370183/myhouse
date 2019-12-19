package hnu.houseweb.dao;

import hnu.houseweb.entity.Agent;
import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.AgentPart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AgentMapper {
    int deleteByPrimaryKey(String workno);

    int insert(Agent record);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(String workno);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);

    @Select("select * from agent where workNo= #{id} and name=#{name}")
    public Agent exists(int id,String name);

    @Select("select * from agent where workNo=#{workNo}")
    public Agent selectByWorkNo(@Param("workNo") int workNo);

    @Update("update agent set tel=#{tel} where workNo=#{workNo}")
    public boolean updateTel(@Param("workNo") int workNo, @Param("tel") String tel);

    @Select("select agent.workNo, agent.name, company.compName, agent.starLevel from agent,company where agent.compNo=company.compNo")
    public List<AgentPart> getAllAgentPart();

    @Select("select agent.workNo, agent.name, company.compName, agent.starLevel from agent,company " +
            "where agent.compNo=company.compNo and agent.workNo like #{condition}")
    public List<AgentPart> getAgentPartByWorkNoLike(@Param("condition") String condition);

    @Select("select agent.workNo, agent.name, company.compName, agent.starLevel from agent,company " +
            "where agent.compNo=company.compNo and agent.name like binary #{condition} ")
    public List<AgentPart> getAgentPartByNameLike(@Param("condition") String condition);

    @Select("select agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc, count(*) contractNum " +
            "from agent,company,contracting " +
            "where agent.compNo=company.compNo AND agent.workNo=contracting.workNo " +
            "AND agent.workNo=#{workNo} AND contractState='1'")
    public AgentDetail getAgentDetail(@Param("workNo") int workNo);

    @Insert("insert into contracting(userId,workNo,contractSrc,created) value(#{userId},#{workNo},#{contractSrc},NOW())")
    public int contractAgent(@Param("userId") int userId, @Param("workNo") int workNo, @Param("contractSrc") String contractSrc);


    @Select("select status from agent where (workno= #{userId})")
    public String getStatus(int id);


    @Select("select * from agent where (workno= #{userId})")
    public Agent existsId(int userId);

    @Select("select * from agent where (credentialid= #{cardId})")
    public Agent  existsCard(String cardId);


    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo")
    public List<AgentDetail> getAllAgentDetail();

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "WHERE a.workNo LIKE #{condition}")
    public List<AgentDetail> getAgentDetailByWorkNoLike(@Param("condition") String condition);

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "WHERE a.name LIKE binary #{condition}")
    public List<AgentDetail> getAgentDetailByNameLike(@Param("condition") String condition);

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "ORDER BY a.starLevel DESC")
    public List<AgentDetail> getStarLevelSortedAllAgentDetail();

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "WHERE a.workNo LIKE #{condition} " +
            "ORDER BY a.starLevel DESC")
    public List<AgentDetail> getStarLevelSortedAgentDetailByWorkNoLike(@Param("condition") String condition);

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "WHERE a.name LIKE binary #{condition} " +
            "ORDER BY a.starLevel DESC")
    public List<AgentDetail> getStarLevelSortedAgentDetailByNameLike(@Param("condition") String condition);

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "WHERE a.workNo=#{workNo}")
    public AgentDetail getOneAgentDetail(@Param("workNo") int workNo);


    @Update("update agent set name=#{name},credentialid=#{credentialid},compno=#{compNo},imgurl=#{imgurl},status=#{status},created=#{date},tel=#{tel} where workNo=#{userId}")
    public void myUpdate(String userId, String name, String credentialid, int compNo, String imgurl, int status, Date date, String tel);

    @Insert("insert into agent(workNo,name,credentialid,compno,imgurl,created,tel) values (#{userId},#{name},#{credentialid},#{compNo},#{imgurl},#{date},#{tel})" )
    public void insert_second(String userId, String name, String credentialid, int compNo, String imgurl, Date date,String tel);

    @Select("select a.*,c.compname from agent a,company c where (status= #{status}) and (a.compno=c.compno)")
    List<Agent> getAll(@Param("status") int status);

    @Update("update agent set status=#{status},reply=#{reply} where workNo=#{userId}")
    void changeStatus(@Param("status")int status,@Param("userId") String userId,@Param("reply") String reply);

    @Select("select u.email,a.name,a.tel,a.workNo,a.starLevel,a.reply,a.status,a.created,c.compName from agent a,company c,user u where (a.compNo = c.compNo) AND (u.userid = a.workno) AND (a.name like #{name}) AND a.status<>'0'")
    public List<Agent> getAllAgents(@Param("name") String name);

    @Update("update user u,agent a set a.tel = #{tel},a.status = #{status},u.email = #{email},u.tel = #{tel} where u.userId = a.workNo and a.workNo = #{workNo}")
    public int updateOneAgent(Agent agent);

    @Delete("DELETE from agent where workNo = #{workNo}")
    public int delOneAgent(@Param("workNo") int workNo);
}