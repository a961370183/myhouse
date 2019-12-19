package hnu.houseweb.dao;

import hnu.houseweb.entity.Contracting;
import hnu.houseweb.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractingMapper {

    @Select("select * from contracting where userId=#{userId} and workNo=#{workNo} and contractState in ('0','1')")
    Contracting selectContracting(@Param("userId") int userId, @Param("workNo") int workNo);

    @Select("select * from user where userId in (select userId from contracting where workNo=#{workNo} and contractState=#{contractState})")
    List<User> getContractingUsers(@Param("workNo") int workNo, @Param("contractState") String contractState);

    @Update("update contracting set contractState=#{contractState}, created=NOW() where workNo=#{workNo} and userId=#{userId}")
    int updateContractingUser(@Param("workNo") int workNo, @Param("userId") int userId, @Param("contractState") String contractState);


    @Select("select * from contracting where workNo=#{workNo}")
    List<Contracting> getContractings(@Param("workNo") int workNo);


    @Insert("insert contracting (userid,workno,created,ContractSrc) values (#{id},#{workNo},#{created},#{url})")
    void setContracting(int id, int workNo, String created,String url);

    @Select("select c.*,a.name from contracting c,agent a where userId=#{userId} and c.workNo=a.workNo")
    List<Contracting> getAllContracting(@Param("userId") int userId);
    @Select("select * from contracting contractNo=#{contractNo}")
    Contracting getContracting(int contractNo);
    @Update("update  contracting " +
            "set description=#{comment} , starLevel=#{star},contractState = 3 " +
            "where contractNo=#{contractNo}")
    void comment(int contractNo, String comment,int star);
}
