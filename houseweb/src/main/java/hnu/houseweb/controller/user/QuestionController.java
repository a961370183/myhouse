package hnu.houseweb.controller.user;

import hnu.houseweb.dao.AgentHangoutMapper;
import hnu.houseweb.dao.HangoutMapper;
import hnu.houseweb.dao.HouseMapper;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.house.HouseDetailService;
import hnu.houseweb.service.house.HouseSearchService;
import hnu.houseweb.service.question.AnswerService;
import hnu.houseweb.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //声明Rest风格的控制器
@RequestMapping("/question")
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private HouseDetailService houseDetailService;

    @Autowired
    private HouseSearchService houseSearch;

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private HangoutMapper hangoutMapper;

    @Autowired
    private AgentHangoutMapper agentHangoutMapper;

    @RequestMapping("")
    @ResponseBody
    public List<
            Question> find(int userId){
        return questionService.findByUserID(userId);
    }

    @RequestMapping("/relatedAnswer")
    @ResponseBody
    public Answer findAnswer(int questionNo){return answerService.findByQuestionNo(questionNo);}

    @RequestMapping("/getQA")
    @ResponseBody
    public List<QAUnion> findQA(int userid){
        List<Question> questionlist=questionService.findByUserID(userid);
        List<QAUnion> qalist = new ArrayList<QAUnion>();
        for (Question q : questionlist){
            HouseDetail houseDetail = null;
            AgentHouse a = houseMapper.getAgentHousePart(q.getHouseNo());
            UserHouse u = houseMapper.getUserHousePart(q.getHouseNo());
            QAUnion qaUnion = new QAUnion();
            if(a!=null){
                qaUnion.setQuestion(q);
                qaUnion.setAnswerList(answerService.getAnswerOfQuestion(q.getQuestionNo()));
                qaUnion.setHouseDetail(a);
                qalist.add(qaUnion);
            }
            else if(u!=null){
                qaUnion.setQuestion(q);
                qaUnion.setAnswerList(answerService.getAnswerOfQuestion(q.getQuestionNo()));
                qaUnion.setHouseDetail(u);
                qalist.add(qaUnion);
            }
        }
        return  qalist;
    }

    @RequestMapping("/deleteQA")
    @ResponseBody
    public  int deleteQA(int questionno){
        int deleteq=questionService.deleteByQuestionno(questionno);
        int deletea=answerService.deleteByQuestionNo(questionno);
        return  (deleteq);
    }

    @RequestMapping("/QAtoHouses")
    @ResponseBody
    public  List<QAtoHouse> findQAtoHouses(int userid){
        List<QAtoHouse> qAtoHouseList= new ArrayList<QAtoHouse>();
        System.out.println(userid);
        List<Hangout> hangoutList = hangoutMapper.selectByUserId(userid);
        List agentHangouts = agentHangoutMapper.selectHouseByWorkNo(userid);
        for (Hangout itemHouse : hangoutList){
            HouseDetail houseDetail = null;
            UserHouse u = houseMapper.getUserHousePart(itemHouse.getHouseNo());
            houseDetail = u;
            int houseNo = itemHouse.getHouseNo();
            List<Question> questionlist=questionService.findByHouseNo(houseNo);
            System.out.println(qAtoHouseList);
            List<QAUnion> qalist = new ArrayList<QAUnion>();
            for (Question q : questionlist){
                qalist.add(new QAUnion(q,answerService.findByQuestionNo(q.getQuestionNo()),null));
            }
            qAtoHouseList.add(new QAtoHouse(houseDetail,houseNo,qalist));
        }

        for(Object o : agentHangouts){
            AgentHouse a = houseMapper.getAgentHousePart((int) o);
            HouseDetail houseDetail = a;
            List<Question> questionlist=questionService.findByHouseNo((int) o);
            System.out.println(questionlist);
            List<QAUnion> qalist = new ArrayList<QAUnion>();
            for (Question q : questionlist){
                qalist.add(new QAUnion(q,answerService.findByQuestionNo(q.getQuestionNo()),null));
            }
            qAtoHouseList.add(new QAtoHouse(houseDetail,(int) o,qalist));
        }
        return qAtoHouseList;
    }

    @RequestMapping("/answerQuestion")
    @ResponseBody
    public  int submitAnswer(int questionno,String ansContent,int userId){
        answerService.addAnswer(questionno,ansContent,userId);
        return 1;
    }
}
