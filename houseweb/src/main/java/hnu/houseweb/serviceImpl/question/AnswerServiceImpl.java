package hnu.houseweb.serviceImpl.question;

import hnu.houseweb.dao.AnswerMapper;
import hnu.houseweb.entity.Answer;
import hnu.houseweb.service.question.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerMapper answerMapper;

    @Override
    public Answer findByQuestionNo(int questionno) {
        return answerMapper.selectByQuestionNo(questionno);
    }

    @Override
    public int deleteByQuestionNo(int questionno) { return answerMapper.deleteByQuestionNo(questionno); }

    public List<Answer> getAnswerOfQuestion(int questionNo){
        return answerMapper.getAnswerOfQuestion(questionNo);
    }

    @Override
    public int addAnswer(int questionno, String ansContent,int userId) {
        Answer ans=new Answer();
        ans.setQuestionNo(new Integer(questionno));
        ans.setAnswerContent(ansContent);
        ans.setAnswerTime(new Date());
        ans.setUserId(new Integer(userId));
        answerMapper.insert(ans);
        return 1;
    }
}
