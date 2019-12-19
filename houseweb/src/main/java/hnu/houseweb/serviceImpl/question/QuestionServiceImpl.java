package hnu.houseweb.serviceImpl.question;
import hnu.houseweb.dao.QuestionMapper;
import hnu.houseweb.entity.QAUnion;
import hnu.houseweb.entity.Question;
import hnu.houseweb.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question> findByUserID(int userid) {
        return questionMapper.findByUserID(userid);
    }

    @Override
    public int deleteByQuestionno(int questionno) {
        return questionMapper.deleteByPrimaryKey(questionno);
    }

    @Override
    public int insertQuestion(Question q) {
        questionMapper.insertSelective(q);
        return 1;
    }

    public List<Question> findByHouseNo(int houseNo){
        return questionMapper.getQuestionByHouseNo(houseNo);
    }

    @Override
    public Question getQuestion(int questionNo){
        return questionMapper.selectByPrimaryKey(questionNo);
    }
}