package hnu.houseweb.controller;


import hnu.houseweb.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("sign")
public class JumpController {
    @Autowired
    private IUserService userService;

    /*路由：注册页面*/
    @RequestMapping("register")
    public String register(@RequestParam("name")String username, @RequestParam("password")String password, @RequestParam("email")String email){
        System.out.println(username);
        userService.register(username,password,email);
        return "redirect:/login.html";
    }

    /*路由：用户中心*/
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String home(Principal principal){
        System.out.println(principal.getName());
        return "userhome/home";
    }
}
