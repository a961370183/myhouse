package hnu.houseweb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userhome")
public class MyFavoriteController {
    @RequestMapping("/myfavorite")
    public String tomyfavorite(){
        return "userhome/myfavorite";
    }
}
