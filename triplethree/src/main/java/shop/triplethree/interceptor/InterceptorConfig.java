package shop.triplethree.interceptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier(value = "loginInterceptor")
	private HandlerInterceptor loginInterceptor;
	
	@Autowired
	@Qualifier(value = "adminInterceptor")
	private HandlerInterceptor adminInterceptor;
 
			
	// application.properties에 설정된 값을 가지고 오기
	@Value("${resources.notload.list}") 
	private List<String> notLoadList;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**") // 제한할패턴
				.excludePathPatterns("/mapper/**")// 제외할패턴
				.excludePathPatterns(notLoadList);// 제외할패턴
			
		
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/**") // 제한할패턴
				.excludePathPatterns("/mapper/**")// 제외할패턴
				.excludePathPatterns(notLoadList);// 제외할패턴
		/*
		 * registry.addInterceptor(commonInterceptor) .addPathPatterns("/**") // 추가할 url
		 * 패턴 .excludePathPatterns("/user/**"); // 제외할 url 패턴
		 * url패턴 쓰기 TIP) *은 하나 또는 하나이상 포함 글자 , ?는 한글자 포함  , ** 하나 이상의 폴더 또는 글자
		 */
	}
}
