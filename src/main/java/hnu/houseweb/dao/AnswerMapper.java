package hnu.houseweb.dao;

import hnu.houseweb.entity.Answer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerMapper {
    int deleteByPrimaryKey(int answerNo);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(int answerNo);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    /*11-29修改为驼峰命名 - 周*/
    @Delete("delete from answer where questionNo = #{questionNo}")
    int deleteByQuestionNo(@Param("questionNo") int questionNo);

    @Select("select * from answer where questionNo = #{questionNo} ORDER BY answerTime DESC LIMIT 1")
    Answer selectByQuestionNo(@Param("questionNo") int questionNo);

    @Select("select answer.*,user.name from answer,user,question where question.questionNo=answer.questionNo and answer.userId=user.userId and question.questionNo=#{questionNo,jdbcType=INTEGER} order by answerTime limit 5")
    List<Answer> getAnswerOfQuestion(@Param("questionNo") int questionNo);

}