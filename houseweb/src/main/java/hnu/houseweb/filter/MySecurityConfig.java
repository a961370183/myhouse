package hnu.houseweb.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    private ErrorPage errorPage;

    /*  b0vv权限控制器，对指定的路径进行拦截，跳转到登录界面 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/userhome/**/**").authenticated()
            .antMatchers("/propertyPage/**/**").authenticated()
            .antMatchers("/uploadHouse//uploadHouseDetail/**").authenticated()
            .antMatchers("/houseUpload/**/**").authenticated()
            .anyRequest().permitAll()
        .and()
            .formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/house").loginPage("/login.html")
        .and()
            .csrf().disable();
    }
}