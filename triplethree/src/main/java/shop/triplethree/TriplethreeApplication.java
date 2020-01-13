package shop.triplethree;


import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;



@SpringBootApplication

public class TriplethreeApplication {

	//세션시간 설정하는 값
	@Bean
	public HttpSessionListener httpSessionListener(){

	    return new SessionListener();

	 }
	
	public static void main(String[] args) {
		SpringApplication.run(TriplethreeApplication.class, args);
	}
}
