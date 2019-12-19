package hnu.houseweb.service.question;

import hnu.houseweb.entity.Answer;

import java.util.List;

public interface AnswerService {

    public Answer findByQuestionNo(int questionno);

    public  int deleteByQuestionNo(int questionno);

    public List<Answer> getAnswerOfQuestion(int questionNo);

    public int addAnswer(int questionno, String ansContent,int userId);

}
