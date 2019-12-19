package hnu.houseweb.dao;

import hnu.houseweb.entity.BlackList;
import hnu.houseweb.entity.Law;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawMapper {
    int deleteByPrimaryKey(int lawno);

    int insert(Law record);

    int insertSelective(Law record);

    Law selectByPrimaryKey(int lawno);

    int updateByPrimaryKeySelective(Law record);

    int updateByPrimaryKeyWithBLOBs(Law record);

    int updateByPrimaryKey(Law record);

    @Select("select * from law order by created desc")
    List<Law> getLawNews();

    @Select("select * from law where lawNo = #{lawNo,jdbcType=INTEGER}")
    Law getLawDetail(int lawNo);

    @Select("select * from law where law.title like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') OR law.content like CONCAT('%',#{kw,jdbcType=VARCHAR},'%') order by created desc")
    List<Law> findLaw(String kw);
}