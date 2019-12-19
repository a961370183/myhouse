package hnu.houseweb.dao;

import hnu.houseweb.entity.AgentDetail;
import hnu.houseweb.entity.Contract;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractMapper {
    int deleteByPrimaryKey(String contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(String contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    @Select("select * from contracting where workNo=#{workNo} and contractState='3'")
    List<Contract> getContractBy(@Param("workNo") int workNo);

    @Select("select * from contracting, agent where contracting.workNo=agent.workNo and contractState='3'")
    List<Contract> getAllContracts();

    @Select("select * from contracting, agent where contracting.workNo=agent.workNo and name like #{name} and contractState='3'")
    List<Contract> getContractsByNameLike(@Param("name") String name);

    @Select("SELECT a.workNo, a.compName, a.name, a.starLevel, a.tel, a.workYear, a.imgSrc, contractNum FROM " +
            "(SELECT agent.workNo, company.compName, agent.name, agent.starLevel, agent.tel, agent.workYear, agent.imgSrc FROM agent,company WHERE agent.compNo=company.compNo AND STATUS='1') AS a " +
            "LEFT JOIN (SELECT workNo, COUNT(*) contractNum FROM contracting where contractState='3' GROUP BY workNo) AS b ON a.workNo=b.workNo " +
            "ORDER BY contractNum DESC")
    List<AgentDetail> getContractNumSortedAgentDetail();
}