package hnu.houseweb.service.question;

import hnu.houseweb.entity.QAUnion;
import hnu.houseweb.entity.Question;

import java.util.List;

public interface QuestionService {

    public List<Question> findByUserID(int userid);

    public  int deleteByQuestionno(int questionno);

    public int insertQuestion(Question q);

    public List<Question> findByHouseNo(int houseNo);
}
