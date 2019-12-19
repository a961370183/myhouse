package hnu.houseweb.service.tools;

import javax.servlet.http.HttpSession;

public interface SMSService {

    public boolean sendSMS(String tel,String code);
    public boolean checkSMS(String smsCode, HttpSession session);
    public boolean registerSMS(String tel, HttpSession session);
}
