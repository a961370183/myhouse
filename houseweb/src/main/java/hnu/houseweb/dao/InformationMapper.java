package hnu.houseweb.dao;

import hnu.houseweb.entity.Agent;
import hnu.houseweb.entity.Company;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationMapper {

    @Select("select workNo,name from agent where cast(workNo as char) like concat('%',#{workNo,jdbcType=INTEGER},'%') limit 5")
    List<Agent> searchAgentByWorkNo(int workNo);
    @Select("select workNo,name from agent where name like concat('%',#{name,jdbcType=VARCHAR},'%')  limit 5")
    List<Agent> searchAgentByName(String name);
    @Select("select compNo,compName from company where cast(compNo as char) like concat('%',#{compNo,jdbcType=INTEGER},'%')  limit 5")
    List<Company> searchCompByCompNo(int compNo);
    @Select("select compNo,compName from company where compName like concat('%',#{compName,jdbcType=VARCHAR},'%') limit 5")
    List<Company> searchCompByCompName(String compName);

    @Select("select workNo,name from agent")
    List<Agent> getAllAgent();

    @Select("select compNo,compName from company")
    List<Company> getAllComp();
}
