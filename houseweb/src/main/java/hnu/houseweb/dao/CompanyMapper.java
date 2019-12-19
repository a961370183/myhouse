package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.Company;
import hnu.houseweb.entity.CompanyPart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    int deleteByPrimaryKey(String compno);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String compno);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<CompanyPart> getTenCompany();

    @Select("select compNo, compName, starLevel from company")
    List<CompanyPart> getAllCompanyPart();

    @Select("select compNo, compName, starLevel from company where compNo like #{condition}")
    List<CompanyPart> getCompanyPartByCompNoLike(@Param("condition") String condition);

    @Select("select compNo, compName, starLevel from company where compName like #{condition}")
    List<CompanyPart> getCompanyPartByCompNameLike(@Param("condition") String condition);

    @Select("select compNo, compName, starLevel from company order by starLevel desc")
    List<CompanyPart> getStarLevelSortedAllCompanyPart();

    @Select("select compNo, compName, starLevel from company where compNo like #{condition} order by starLevel desc")
    List<CompanyPart> getStarLevelSortedCompanyPartByCompNoLike(@Param("condition") String condition);

    @Select("select compNo, compName, starLevel from company where compName like #{condition} order by starLevel desc")
    List<CompanyPart> getStarLevelSortedCompanyPartByCompNameLike(@Param("condition") String condition);

    @Select("select * from company where compNo=#{compNo}")
    Company selectByCompNo(@Param("compNo") int compNo);

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company " +
            "WHERE agent.compNo=company.compNo AND STATUS='1' AND agent.compNo=#{compNo}) AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contract GROUP BY workNo) AS b ON a.workNo=b.workNo")
    List<AgentDetail> getAgentDetails(@Param("compNo") int compNo);

    @Select("select * from company where compName like #{compName}")
    public List<Company> getAllCompanies(@Param("compName") String compName);

    @Insert("insert into company(compName,qualifyNo,address,licenseNo,storesNum,registFund,starLevel,legalRepresentor,employeeNum,tel)" +
            "VALUES(#{compName},#{qualifyNo},#{address},#{licenseNo},#{storesNum},#{registFund},#{starLevel},#{legalRepresentor},#{employeeNum},#{tel})")
    public int setOneCompany(Company company);

    @Delete("delete from company where compNo = #{compNo}")
    public int delOneCompany(@Param("compNo") int compNo);

    @Update("update company set compName = #{compName},qualifyNo = #{qualifyNo},address = #{address},licenseNo = #{licenseNo}, storesNum = #{storesNum}, registFund = #{registFund}, legalRepresentor=#{legalRepresentor},employeeNum=#{employeeNum},tel = #{tel}" +
            "where compNo = #{compNo}")
    public int updateOneCompany(Company company);
}