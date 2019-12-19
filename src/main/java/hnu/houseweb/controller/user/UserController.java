package hnu.houseweb.controller.user;
import com.alibaba.druid.support.json.JSONUtils;
import hnu.houseweb.entity.User;
import hnu.houseweb.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController //声明Rest风格的控制器
//@EnableAutoConfiguration //自动配置，相当于写了spring的配置文件
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /*操作：按姓名寻找用户 */
    @RequestMapping("find")
    public List<User> find(){
        return userService.findByUsername();
    }

    /*操作：返回登录用户的详细信息 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public User currentUserName(Principal principal) {
        String userName= principal.getName();
        return userService.exists(userName);
    }

    /*操作：更改当前用户的昵称 */
    @RequestMapping("changeNick")
    public void changeNick(String userName,String nickName){
        System.out.println("访问到");
        userService.changeNick(userName,nickName);
    }
    @RequestMapping("changeTel")
    public void changeTel(String userName,String tel){
        userService.changeTel(userName,tel);
    }

    /*操作: 获取用户的头像 */
    @RequestMapping(value = "/queryImg")
    public void queryImg(MultipartFile file, String userName) throws IOException {

        userService.queryImg(file,userName);
    }

    /*操作：获取全部用户信息, 此功能有待确认, 需要为管理员权限*/
    @RequestMapping("getall")
    public List<User> getAll(){
        return userService.getAll();
    }

    /*操作: 更改当前用户的Email*/
    @RequestMapping("changeEmail")
    public void changeEmail(String userName,String email){
        userService.changeEmail(userName,email);
    }

    /*操作: 更改当前用户密码 */
    @RequestMapping("changePassword")
    public void changepassword(String userName,String password){
        userService.changePassword(userName,password);
    }

    /*操作：判断用户是否存在*/
    @RequestMapping("exists")
    public String exists(String userName){
        HashMap<String,Boolean> hashMap = new HashMap();
        User user = userService.exists(userName);
        if(user==null) {
            hashMap.put("valid",true);
        }
        else{
            hashMap.put("valid",false);
        }
        return JSONUtils.toJSONString(hashMap);
    }

    /*操作；更换用户真实姓名*/
    @RequestMapping("changeName")
    @ResponseBody
    public void changeName(String userName,String name){
        userService.changeName(userName,name);
    }

    /*操作：删除用户（平台管理员）*/
    @RequestMapping("delete")
    public void delete(int id){
        userService.delete(id);
    }

}
