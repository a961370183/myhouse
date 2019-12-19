package hnu.houseweb.controller.house;

import com.alibaba.fastjson.JSONObject;
import hnu.houseweb.entity.*;
import hnu.houseweb.service.company.CompanyService;
import hnu.houseweb.service.house.CollectService;
import hnu.houseweb.service.house.HouseDetailService;
import hnu.houseweb.service.house.HouseSearchService;
import hnu.houseweb.service.question.AnswerService;
import hnu.houseweb.service.question.QuestionService;
import hnu.houseweb.serviceImpl.question.AnswerServiceImpl;
import hnu.houseweb.serviceImpl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class HouseController {

    /*依赖注入 房源、收藏、用户、公司、房源搜索的Service*/
    @Autowired
    HouseDetailService houseDetailImpl;
    @Autowired
    CollectService collectServiceImpl;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CompanyService companyServiceImpl;
    @Autowired
    HouseSearchService houseSearchImpl;
    @Autowired
    QuestionService questionServiceImpl;
    @Autowired
    AnswerService answerServiceImpl;

    /*ResponseBody返回house, 为了不刷新页面获取*/
    @RequestMapping("/getHouse/**/**")
    @ResponseBody
    public String getHouse(HttpServletRequest request){
        String paramUrl = request.getServletPath();
        String currentPage = request.getParameter("page");
        if(currentPage==null){
            currentPage = "1";
        }
        if(paramUrl.length()>10){
            paramUrl = paramUrl.substring(10);
            paramUrl += "-"+ currentPage;
        }else{
            paramUrl = currentPage;
        }
        Map map= houseSearchImpl.mapFind(paramUrl);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toJSONString();
    }


    /* 获取用户的房源列表,用于房源管理、中介机构名下房源查看 */
    @RequestMapping("/getMyHouses")
    @ResponseBody
    public String getMyHouse(){
        /* 一个很关键的点是区分个人和用户账号，用user的role来区分 1为用户,2为中介 */
        User user = userService.userInfo();
        JSONObject jsonObject = new JSONObject();
        if(user!=null){
            int role = user.getRole();
            if(role == 1){
                jsonObject.put("houses", houseDetailImpl.getHouseByUserId(user.getUserId()));
            }else if(role == 2){
                jsonObject.put("houses", houseDetailImpl.getHouseByUserId(user.getUserId()));
            }
            return jsonObject.toJSONString();
        }
        return "error";
    }

    /*删除某个房源。并返回最新的房源列表*/
    @RequestMapping("/deleteHouse")
    @ResponseBody
    public String deleteHouse(int houseNo){
        /* 一个很关键的点是区分个人和用户账号，用user的role来区分 1为用户,2为中介 */
        User user = userService.userInfo();
        JSONObject jsonObject = new JSONObject();
        if(user!=null){
            int role = user.getRole();
            if(houseNo!=0) {
                if (role == 1) {
                    houseDetailImpl.deleteUserHouseByHouseNo(houseNo,user.getUserId());
                    jsonObject.put("houses",houseDetailImpl.getHouseByUserId(user.getUserId()));
                } else if (role == 2) {
                    houseDetailImpl.deleteAgentHouseByHouseNo(houseNo,user.getUserId());
                    jsonObject.put("houses",houseDetailImpl.getHouseByWorkNo(user.getUserId()));
                }
            }
            return jsonObject.toJSONString();
        }
        return "error";
    }

    /*获取userId*/
    private int getUserId(){
        User user = userService.userInfo();
        if(user!=null)
            return user.getUserId();
        else
            return 0;
    }

    /* 获取中介workNo (待实现 )*/
    private int getAgentWorkNo(){
        return 0;
    }


//收藏相关
    /* 执行收藏房源操作, 参数为房源编号 */
    @RequestMapping("/collectService/collect/{houseno}")
    @ResponseBody
    public String collectHouse(HttpServletRequest request,@PathVariable int houseno){
        String result = "0";
        //获取用户id
        int userId = getUserId();
        if(userId!=0) {
            Collect collect = new Collect();
            collect.setUserId(userId);
            collect.setHouseNo(houseno);
            collect.setCreated(new Date());
            //try,catch. 如果收藏记录插入成功, 则返回1
            try {
                collectServiceImpl.insertCollect(collect);
                result = "1";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            result = "2";
        }
        System.out.println("collectService done" + result);
        return result;
    }

    /* 取消对房源的收藏, 参数为房源编号 */
    @RequestMapping("/collectService/cancle/{houseno}")
    @ResponseBody
    public String deleteCollectHouse(@PathVariable int houseno){
        String result = "0";
        //获取用户id
        int userId = getUserId();
        if(userId!=0) {
            Collect collect = new Collect();
            collect.setUserId(userId);
            collect.setHouseNo(houseno);
            collect.setCreated(new Date());
            //try,catch. 如果收藏记录删除成功, 则返回1
            try {
                collectServiceImpl.deleteCollect(collect);
                result = "1";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            result = "2";
        }
        return result;
    }

    @RequestMapping("/collectService/getCollectNum/{houseno}")
    @ResponseBody
    public int getCollectNum(@PathVariable int houseno){
        return collectServiceImpl.getCollectNumOfHouse(houseno);
    }

    /*获取收藏房源*/
    @RequestMapping("/collectService/getCollectHouse")
    @ResponseBody
    public List<HouseDetail> getCollectHouse(int userid){return houseDetailImpl.getCollectHouse(userid); }

    /* 提问*/
    @RequestMapping("/questionService/askQuestion")
    @ResponseBody
    public List askQuestion(int houseNo,int userId,String content){
        Question question = new Question();
        String result = "0";
        Date date = new Date(System.currentTimeMillis());
        question.setCreated(date);
        question.setHouseNo(houseNo);
        question.setUserId(userId);
        question.setQuestionContent(content);
        try {
            questionServiceImpl.insertQuestion(question);
            System.out.println("提问成功");
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return getQuestion(houseNo);
    }

    /* 操作：得到房源下面的问题列表和其答案*/
    @RequestMapping("/questionService/getQuestion")
    @ResponseBody
    public List getQuestion(int houseNo){
        List list = new ArrayList();
        List<Question> questions = questionServiceImpl.findByHouseNo(houseNo);
        for(Question question : questions){
            Map map = new HashMap();
            map.put("question",question);
            map.put("answers",answerServiceImpl.getAnswerOfQuestion(question.getQuestionNo()));
            list.add(map);
        }
        return list;
    }

    @RequestMapping("/getRegionCount")
    @ResponseBody
    public List getRegionCount(){
        /*返回格式类似于：
        * [{region:'',name:'',latitude:'',longtitude:'',count:''}]
        * 最主要是这个count，是这个区域的房源数量
        * */
        return houseSearchImpl.getRegionCount();
    }
}
