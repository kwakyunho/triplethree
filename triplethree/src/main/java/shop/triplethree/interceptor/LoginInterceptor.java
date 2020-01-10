package shop.triplethree.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
      
    // 요청을 컨트롤러에 보내기 전 작업
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
    	logger.info("================ Before Method");
    	logger.info("info - {}", "호출완료");
    	logger.debug("debug - {}", "호출디버그");
    	logger.error("error - {}", "호출에러");
    	logger.warn("warn - {}", "호출경고");
    	logger.trace("trace - {}", "호출trace");
    	System.out.println(request.getRequestURI() + " <<<<<<<<");
    	HttpSession session = request.getSession(true);
    	String sessionCheck = (String)session.getAttribute("CHECK");
    	System.out.println(sessionCheck + "<<<<<<<< sessionCheck 확인");
    	if(sessionCheck != null) {
    		return true;   
    		
    	}else {
    		try {
				response.sendRedirect("/notLogin");
			} catch (IOException e) {
				e.printStackTrace();
			}
    		return false;
    	}
    	
    }    
    
	
	/*
	 * @Override public void postHandle( HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView) {
	 * logger.info("================ PostHandle Method Executed");
	 * 
	 * 
	 * }
	 */
	 

   
}