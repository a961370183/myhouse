package hnu.houseweb.dao;

import hnu.houseweb.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    int deleteByPrimaryKey(int questionNo);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(int questionNo);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    @Select("select * from question where userid = #{userid}")
    List<Question> findByUserID(@Param("userid") int userid);

    @Select("select * from question where houseNo = #{houseNo} order by created desc limit 5")
    List<Question> getQuestionByHouseNo(@Param("houseNo") int houseNo);
}