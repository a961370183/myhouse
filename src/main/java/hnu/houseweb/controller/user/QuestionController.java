package hnu.houseweb.controller.user;

import hnu.houseweb.dao.HangoutMapper;
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
    private HangoutMapper hangoutMapper;
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
            AgentHouse a = houseDetailService.getAgentHouse(q.getHouseNo());
            UserHouse u = houseDetailService.getUserHouse(q.getHouseNo());
            if(a!=null){
                qalist.add(new QAUnion(q,answerService.findByQuestionNo(q.getQuestionNo()),a));
            }
            else if(u!=null){
                qalist.add(new QAUnion(q,answerService.findByQuestionNo(q.getQuestionNo()),u));
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
        List<Hangout> hangoutList = hangoutMapper.selectByUserId(userid);
        for (Hangout itemHouse : hangoutList){
            HouseDetail houseDetail = null;
            AgentHouse a = houseDetailService.getAgentHouse(itemHouse.getHouseNo());
            UserHouse u = houseDetailService.getUserHouse(itemHouse.getHouseNo());
            if(a!=null){
                houseDetail = a;
            }else if (u!=null){
                houseDetail = u;
            }
            int houseNo = itemHouse.getHouseNo();
            List<Question> questionlist=questionService.findByHouseNo(houseNo);
            List<QAUnion> qalist = new ArrayList<QAUnion>();
            for (Question q : questionlist){
                qalist.add(new QAUnion(q,answerService.findByQuestionNo(q.getQuestionNo()),null));
            }
            qAtoHouseList.add(new QAtoHouse(houseDetail,houseNo,qalist));
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
