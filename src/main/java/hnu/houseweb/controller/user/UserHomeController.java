package hnu.houseweb.controller.user;

import hnu.houseweb.entity.User;
import hnu.houseweb.serviceImpl.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/userhome")
public class UserHomeController {

    @Autowired
    UserServiceImpl userService;

    /*路由：到用户中心首页*/
    @RequestMapping("")
    public String userHome(){
        return "userhome/home";
    }

    /*路由：到用户中心首页*/
    @RequestMapping("/**")
    public String userHome2(){
        return "userhome/home";
    }

    /*路由：到用户中心房源管理页*/
    @RequestMapping("/houseManage")
    public String uploadHouse(Model mv) {
        User user = userService.userInfo();
        mv.addAttribute("userInfo",user);
        return "userhome/houseManage";
    }
   @RequestMapping("/process")
    public String process() {
        return "userhome/process";
    }

    /*路由：到中介个人信息页面*/
    @RequestMapping("/zhongjie")
    public String zhongJie(){
        return "userhome/zhongjie";
    }

    /*路由：到用户登录页面*/
    @RequestMapping("/zhongjiesign")
    public String zhongJieSign(){
        return "userhome/zhongjiesign";
    }

    /*路由：到中介签约页面*/
    @RequestMapping("/zhongjieqianyue")
    public String zhongJieQianYue(){
        return "userhome/zhongjieqianyue";
    }

    /*路由：到用户中心首页*/
    @RequestMapping("/zhongjiesign1")
    public String zhongJieSign1(){
        return "userhome/zhongjiesign1";
    }

    /*路由：到中介管理页面（管理员）*/
    @RequestMapping("/zhongjiemanage")
    public String zhongJieManage(){
        return "userhome/zhongjiemanage";
    }

    /*路由：到中介信息页面（中介）*/
    @RequestMapping("/agentInformation")
    public String agentInformation() {
        return "userhome/agent-information";
    }

    /*路由：到等待签约管理页面（中介）*/
    @RequestMapping("/agentContractingManage")
    public String agentContractingManage() {
        return "userhome/agent-contracting-manage";
    }

    /*路由：到已签约管理页面（中介）*/
    @RequestMapping("/agentContractedManage")
    public String agentContractedManage() {
        return "userhome/agent-contracted-manage";
    }

    /*路由：到我的问题管理页面*/
    @RequestMapping("/myquestion")
    public String questionManage(){ return "userhome/MyQA"; }

    /*路由：到我的回答管理页面*/
    @RequestMapping("/myanswer")
    public String answerManage(){return "userhome/houseQA";}
}
