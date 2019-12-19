package hnu.houseweb.controller;


import hnu.houseweb.service.tools.SmsService;
import hnu.houseweb.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Random;

@Controller
@RequestMapping("sign")
public class JumpController {
    @Autowired
    private IUserService userService;
    @Autowired
    private HttpSession session;

    /*路由：注册页面*/
    @RequestMapping("register")
    @ResponseBody
    public String register(@RequestParam("name") String username, @RequestParam("password")String password, @RequestParam("email")String email,@RequestParam("tel") String tel){
        userService.register(username,password,email,tel);
        return "success";
    }

    /*路由：用户中心*/
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(Principal principal){
        System.out.println(principal.getName());
        return "userhome/home";
    }

    @RequestMapping("/getcode")
    @ResponseBody
    public int getcode(@RequestParam("tel") String phone) {
        long l=System.currentTimeMillis();
        int k1=(int) (l%10000);
        Random random = new Random();
        int x = random.nextInt(899999);
         x = x+100000;
         String str = Integer.toString(x);
        //session中保存我后台生成的code,为了将来拿出来与用户提交的进行比较。
        session.setAttribute("autocode",str);
        //成功返回0，失败返回1
        if(phone!=null){
            //把后台生成的code和所发送的手机号传进发送消息类，调用执行。
            SmsService.send(phone,str);
            return 0;
        }else{
            return 1;
        }
    }

    @RequestMapping("/comparecode")
    @ResponseBody
    public int authorization(@RequestParam("code") String preauthcode) {
        String autocode= (String) session.getAttribute("autocode");
        //验证码不为空时，到后台进行比较，返回响应码，为1，提示请先获得验证码
        //为2，提示验证码错误
        //为3，验证码正确，无提示
        System.out.println("存内存的  "+autocode);
        System.out.println(preauthcode);
        if(autocode==null){
            return 1;
        }else if(autocode.equals(preauthcode)){
            return 3;

        }else{
            return 2;
        }
    }

}
