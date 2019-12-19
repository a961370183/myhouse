package hnu.houseweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("admin")
public class AdminController {
    /* 路由到管理员后台首页 */
    @RequestMapping("")
    public String admin1(){
        return "admin/index1";
    }
    /* 路由到管理员后台首页 */
    @RequestMapping("/")
    public String admin2(){
        return "admin/index1";
    }
    @RequestMapping("test")
    public String admin3(){
        return "admin/index";
    }
    /* 路由到管理员后台首页 */
    @RequestMapping("manage")
    public String admin4(){
        return "admin/usermanage";
    }
    /* 路由到管理员后台首页 */
    @RequestMapping("user")
    public String admin(){
        return "admin/user";
    }
    /* 路由到管理员后台首页 */
    @RequestMapping("agent")
    public String admin5(){
        return "admin/agentmanage";
    }
    @RequestMapping("agentpass")
    public String admin6(){
        return "admin/agent";
    }
    @RequestMapping("agentreview")
    public String admin7(){
        return "admin/agentreview";
    }


}
