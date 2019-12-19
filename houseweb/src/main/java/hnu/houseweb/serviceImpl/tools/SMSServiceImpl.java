package hnu.houseweb.serviceImpl.tools;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import hnu.houseweb.service.tools.SMSService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class SMSServiceImpl  implements SMSService {
    public boolean sendSMS(String tel,String code){
        // 短信应用SDK AppID     // 1400开头
        int appid = 1400260142;
        // 短信应用SDK AppKey
        String appkey = "9f6d61f93020c2c112432397a8f2a8b4";
        // 需要发送短信的手机号码
        // phoneNumber = "13999999999";
        // 短信模板ID，需要在短信应用中申请
        int templateId = 426150 ;
        // 签名，使用的是`签名内容`，而不是`签名ID`
        String smsSign = "快乐学习网";
        try {
            //String[] params = {};//参数，验证码为5678，30秒内填写
            String[] params = {code};//参数，验证码为123456，100秒内填写
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", tel,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            return true;
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();

        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }catch (Exception e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkSMS(String smsCode,HttpSession session){
        if(smsCode.equalsIgnoreCase((String) session.getAttribute("smsCode"))){
            return true;
        }
        return false;
    }

    public boolean registerSMS(String tel, HttpSession session){
        StringBuilder code = new StringBuilder();
        Random random = new Random(1);
        for(int i = 0;i < 6;i++){
            code.append(random.nextInt(10));
        }
        if(sendSMS(tel,code.toString())){
            session.setAttribute("smsCode",code.toString());
            final Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    session.removeAttribute("smsCode");
                    timer.cancel();
                }
            },5*60*1000);
            return true;
        }
        return false;
    }
}
