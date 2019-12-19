package hnu.houseweb.filter;

import hnu.houseweb.entity.Admin;
import hnu.houseweb.entity.User;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin==null) {
            try {
                response.sendRedirect("/admin/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
