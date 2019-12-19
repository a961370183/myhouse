package hnu.houseweb.controller.admin;

import hnu.houseweb.dao.VillageMapper;
import hnu.houseweb.entity.Admin;
import hnu.houseweb.entity.Area;
import hnu.houseweb.entity.User;
import hnu.houseweb.entity.Village;
import hnu.houseweb.service.admin.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    LoginService loginService;
    @Autowired
    VillageMapper villageMapper;

    /* 路由到管理员后台首页 */
    @RequestMapping("")
    public String admin1(){
        return "admin/index";
    }
    /* 路由到管理员后台首页 */
    @RequestMapping("/")
    public String admin2(){
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("admin")!=null){
            return "admin";
        }
        return "admin/loginPage";
    }
    @RequestMapping("agent")
    public String admin5(){
        return "admin/agentmanage";
    }
    @RequestMapping("company")
    public String admin8(){
        return "admin/company";
    }
    @RequestMapping("/loginService")
    @ResponseBody
    public String loginService(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int count = 8;
        /*第一道关卡：是否非法入侵*/
        if(username==null || password==null){
            return "非法访问，请输入工号、密码再访问";
        }

        if(session.getAttribute("count")!=null){
            count = (Integer)session.getAttribute("count");
        }

        /* 检查尝试次数 ，session过期为半小时 */
        if(count <= 0){
            return "2";
        }else{
            count -=1;
            try{
                int adminNo = Integer.parseInt(username);
                Admin admin = loginService.loginByAdminNo(adminNo,password);
                if(admin!=null){
                    session.setAttribute("count",null);
                    session.setAttribute("admin",admin);
                }else{
                    session.setAttribute("count",count);
                    Cookie cookie = new Cookie("count",String.valueOf(count));
                    response.addCookie(cookie);
                    return "2";
                }
            }catch (Exception e){
                System.out.println("使用的是姓名登录");
                Admin admin = loginService.loginByName(username,password);
                if(admin!=null){
                    session.setAttribute("count",null);
                    session.setAttribute("admin",admin);
                }else{
                    session.setAttribute("count",count);
                    Cookie cookie = new Cookie("count",String.valueOf(count));
                    response.addCookie(cookie);
                    return "2";
                }
            }
        }
        return "1";
    }
    @RequestMapping("/logoutService")
    public String logoutService(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("admin",null);
        return "admin/loginPage";
    }

    @RequestMapping("/mapManage")
    public String mapManage(){
        return "admin/mapManage/mapManage";
    }

    @RequestMapping("/communityManage")
    public String communityManage(){
        return "admin/mapManage/communityManage";
    }

    @RequestMapping("/areaManage")
    public String areaManage(){
        return "admin/mapManage/areaManage";
    }


    @RequestMapping("/mapManage/addVillage")
    @ResponseBody
    public String addCommunity(String id,String name,String address,String latitude,String longitude,String year,String build_type,String property_costs,String property_company){
        String result = "0";
        if(id==null) {
            id = String.valueOf(System.currentTimeMillis()).substring(4);
            try {
                villageMapper.addVillage(id,name,latitude,longitude,address,year,build_type,property_costs,property_company);
                result = "1";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                villageMapper.updateVillage(id,name,latitude,longitude,address,year,build_type,property_costs,property_company);
                result = "2";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    @RequestMapping("/mapManage/getVillages")
    @ResponseBody
    public List getVillages(){
        return villageMapper.villageAll();
    }


    @RequestMapping("/mapManage/getVillageDetail")
    @ResponseBody
    public Village getVillageDetail(String id){
        return villageMapper.getVillageDetail(id);
    }

    @RequestMapping("/mapManage/deleteVillage")
    @ResponseBody
    public String deleteVillage(@RequestParam(value = "id[]")String[] id){
        String result = "0";
        try {
            for(int i = 0;i < id.length;i ++){
                villageMapper.deleteVillage(id[i]);
            }
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("/mapManage/findVillage")
    @ResponseBody
    public List findVillage(String keyword){
        System.out.println(keyword);
        if(keyword.trim().length()>0)
            return villageMapper.findVillage(keyword);
        else
            return villageMapper.villageAll();
    }

    /* 区域 */
    @RequestMapping("/mapManage/getAreas")
    @ResponseBody
    public List getAreas(){
        return villageMapper.areaAll();
    }

    @RequestMapping("/mapManage/getAreaDetail")
    @ResponseBody
    public Area getAreaDetail(String id){
        return villageMapper.getAreaDetail(id);
    }

    @RequestMapping("/mapManage/addArea")
    @ResponseBody
    public String addArea(String id,String name,String longitude,String latitude,String border){
        String result = "0";
        System.out.println(border);
        if(id==null) {
            id = String.valueOf(System.currentTimeMillis()).substring(4);
            try {
                villageMapper.addArea(id, name, latitude, longitude, border);
                result = "1";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                villageMapper.updateArea(id, name, latitude, longitude, border);
                result = "2";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @RequestMapping("/mapManage/findArea")
    @ResponseBody
    public List findArea(String keyword){
        System.out.println(keyword);
        if(keyword.trim().length()>0)
            return villageMapper.findArea(keyword);
        else
            return villageMapper.areaAll();
    }

    @RequestMapping("/mapManage/deleteArea")
    @ResponseBody
    public String deleteArea(@RequestParam(value = "id[]")String[] id){
        String result = "0";
        try {
            for(int i = 0;i < id.length;i ++){
                villageMapper.deleteArea(id[i]);
            }
            result = "1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/user")
    public String user(){
        return "admin/user";
    }

    /* 路由到管理员后台首页 */
    @RequestMapping("manage")
    public String admin4(){
        return "admin/usermanage";
    }
    /* 路由到管理员后台首页 */

    @RequestMapping("agentpass")
    public String admin6(){
        return "admin/agent";
    }

    @RequestMapping("agentreview")
    public String admin7(){
        return "admin/agentreview";
    }

    /*路由到信息管理后台页面*/
    @RequestMapping("/compPunishManage")
    public String compPunishManage(){
        return "admin/information/compPunishManage";
    }
    @RequestMapping("/agentPunishManage")
    public String agentPunishManage(){
        return "admin/information/agentPunishManage";
    }
    @RequestMapping("/redListManage")
    public String redListManage(){
        return "admin/information/redListManage";
    }
    @RequestMapping("/blackListManage")
    public String blackListManage(){
        return "admin/information/blackListManage";
    }
    @RequestMapping("/lawNewsManage")
    public String lawNewsManage(){
        return "admin/information/lawNewsManage";
    }


    /* 路由到管理员后台房源管理 */
    @RequestMapping("/housemanage")
    public String check(){
        return "admin/house";
    }
    /*路由到管理员后台房源审核*/
    @RequestMapping("/housereview")
    public String pass(){
        return "admin/housereview";
    }
}
