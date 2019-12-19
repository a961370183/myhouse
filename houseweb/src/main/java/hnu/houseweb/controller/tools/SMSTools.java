package hnu.houseweb.controller.tools;

import hnu.houseweb.service.tools.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SMSTools {

    @Autowired
    SMSService smsService;

    @RequestMapping(value="/SMSTools/registerSMS", method= RequestMethod.POST)
    @ResponseBody
    public String sendSMS(String tel, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(smsService.registerSMS(tel,session)){
            System.out.println("短信已发送");
            return "1";
        }else{
            return "0";
        }
    }
}
