package hnu.houseweb.dao;

import hnu.houseweb.entity.Agent;
import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.AgentPart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Select("select a.*,c.compname from agent a,company c where a.compNo=c.compNo and workNo=#{workNo}")
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

    @Update("update agent set name=#{name},credentialid=#{credentialid},compno=#{compNo},imgurl=#{imgurl},status=#{status},created=#{date},tel=#{tel} where workNo=#{userId}")
    public void myUpdate(String userId, String name, String credentialid, int compNo, String imgurl, int status,Date date,String tel);

    @Insert("insert into agent(workNo,name,credentialid,compno,imgurl,created,tel) values (#{userId},#{name},#{credentialid},#{compNo},#{imgurl},#{date},#{tel})" )
    public void insert_second(String userId, String name, String credentialid, int compNo, String imgurl, Date date,String tel);
    @Select("select * from agent where (credentialid= #{cardId})")
    public Agent  existsCard(String cardId);
    @Select("select a.*,c.compname from agent a,company c where (status= #{status}) and (a.compno=c.compno)")
    List<Agent> getAll(@Param("status") int status);
    @Update("update agent set status=#{status},reply=#{reply} where workNo=#{userId}")
    void changeStatus(@Param("status")int status,@Param("userId") String userId,@Param("reply") String reply);
}