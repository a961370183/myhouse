package hnu.houseweb.serviceImpl.user;

import hnu.houseweb.dao.UserMapper;
import hnu.houseweb.entity.User;
import hnu.houseweb.service.user.IUserService;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(String userName, String password,String email,String tel) {
        String secretPassword=passwordEncoder.encode(password);
        userMapper.save(userName,secretPassword,email,tel);
    }

    @Override
    public List<User> findByUsername() {
        return null;
    }


    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User exists(String name) {
        return userMapper.exists(name);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public String getPassword(String userName) {
        return userMapper.getPassword(userName);
    }

    @Override
    public String getUserType(String userName) {
        return userMapper.getUserType(userName);
    }

    @Override
    public void changeNick(@Param("userName") String userName, @Param("nickName") String nickName) {
        userMapper.changeNick(userName,nickName);
    }
    public void changeTel(@RequestParam("userName") String userName, @RequestParam("tel") String tel) {
        userMapper.changeTel(userName,tel);
    }

    @Override
    public void changeEmail(@Param("username") String userName, @Param("email")String email) {
        userMapper.changeEmail(userName,email);
    }

    @Override
    public void changeName(@Param("username")String userName,@Param("name") String name) {
        userMapper.changeName(userName,name);
    }


    @Override
    public void queryImg( @Param("file")MultipartFile file,@Param("username") String userName) {
       try {
           System.out.println(userName);
           String base64EncoderImg = "data:image/jpeg;base64,"+ Base64.encodeBase64String(file.getBytes());
           System.out.println(base64EncoderImg);

         userMapper.queryImg(base64EncoderImg,userName);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void changePassword(@Param("username") String username, @Param("password") String newPassword) {
        String secretPassword=passwordEncoder.encode(newPassword);
        userMapper.changePassword(username,secretPassword);
    }


    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void unCorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public User findByUsername(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public Set<String> findRoles(String userName) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String userName) {
        return null;
    }

    /*获取用户详细信息*/
    public User userInfo(){
        User user = null;
        org.springframework.security.core.userdetails.User user1 = null;
        try {
            if (SecurityContextHolder.getContext()!=null && SecurityContextHolder.getContext().getAuthentication()!=null)
                user1 = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }catch (Exception e){
            System.out.println("用户未登录");
        }
        if(user1!=null) {
            user = findByUsername(user1.getUsername());
        }
        return user;
    }

}
