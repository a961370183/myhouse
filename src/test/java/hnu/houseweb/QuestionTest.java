package hnu.houseweb;

import hnu.houseweb.dao.AnswerMapper;
import hnu.houseweb.dao.CollectMapper;
import hnu.houseweb.dao.HouseDetailMapper;
import hnu.houseweb.entity.Answer;
import hnu.houseweb.entity.HousePart;
import hnu.houseweb.entity.Question;
import hnu.houseweb.service.house.HouseSearchService;
import hnu.houseweb.service.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class QuestionTest {

    @Autowired
    HouseDetailMapper housedetailMapper;

    @Autowired
    HouseSearchService houseSearchImpl;

    @Autowired
    CollectMapper collectMapper;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerMapper answerMapper;
    @Test
    void contextLoads() {
        for(Answer q: answerMapper.getAnswerOfQuestion(1)){
            System.out.println(q);
        }
    }

    private void insert(){
        Question question = new Question();
        String result = "0";
        Date date = new Date(System.currentTimeMillis());
        question.setCreated(date);
        question.setHouseNo(2);
        question.setUserId(11111);
        question.setQuestionContent("hello");
        questionService.insertQuestion(question);
    }

    private List<Question> get(){
        return questionService.findByHouseNo(2);
    }
}