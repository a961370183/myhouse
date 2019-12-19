package hnu.houseweb.service.user;


import hnu.houseweb.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface IUserService {

    public void register(String username, String password,String email,String tel);
    public List<User> findByUsername();
    public void delete(int id);
    public User exists(String username);
    public List<User> getAll();
    public String getPassword(String username);
    public String getUserType(String username);
    public void changeNick(String username,String nickname);
    public void changeEmail(String username,String email);
    public void changeName(String username,String name);
    public void changeTel(String userName,String tel);
    public void queryImg(MultipartFile file,String username);
    public String getMessage();
    public User createUser(User user); //创建账户
    public void changePassword(String username, String newPassword);//修改密码
    public void correlationRoles(Long userId, Long... roleIds); //添加用户-角色关系
    public void unCorrelationRoles(Long userId, Long... roleIds);// 移除用户-角色关系
    public User findByUsername(String username);// 根据用户名查找用户
    public Set<String> findRoles(String username);// 根据用户名查找其角色
    public Set<String> findPermissions(String username); //根据用户名查找其权限
}
