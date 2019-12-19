package hnu.houseweb.filter;

import hnu.houseweb.serviceImpl.user.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class MyUserDeatils implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    /*登录操作, 将用户信息写入权限控制器 */
    public UserDetails loadUserByUsername(@Param("username") String userName) throws UsernameNotFoundException {
        String password1 = userService.getPassword(userName);
        String userType = userService.getUserType(userName);

        if(password1==null){
            throw new UsernameNotFoundException("user not found");
        }
        else {
            System.out.println("loginsuccess");
            return new User(userName,password1,AuthorityUtils.commaSeparatedStringToAuthorityList(userType));
        }
//        String password=passwordEncoder.encode("12345");
//            return new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
    }





//    private Collection<GrantedAuthority> authority(){
//        List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
//        authority.add(new SimpleGrantedAuthority("PRODUCT"));
//        return authority;
//    }

}
