package hnu.houseweb.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径

        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login","/admin/loginService");
    }
}
