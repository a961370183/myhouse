package hnu.houseweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("hnu.houseweb.dao")//Mybatis的DAO所在包,这是必要的，因为SpringBootApplication，只负责扫描Controller和Service
@ComponentScan({"hnu.houseweb.controller","hnu.houseweb.serviceImpl","hnu.houseweb.filter"})
public class HousewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HousewebApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
