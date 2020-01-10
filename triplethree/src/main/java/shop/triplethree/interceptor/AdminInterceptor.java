
package shop.triplethree.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

	// 요청을 컨트롤러에 보내기 전 작업

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("================ Before Method");
		logger.info("info - {}", "호출완료");
		logger.debug("debug - {}", "호출디버그");
		logger.error("error - {}", "호출에러");
		logger.warn("warn - {}", "호출경고");
		logger.trace("trace - {}", "호출trace");
		System.out.println(request.getRequestURI() + " <<<<<<<<");
		String URI = request.getRequestURI();
		HttpSession session = request.getSession(true);
    	String departCheck = (String)session.getAttribute("SDEMGNAME");
		if ("인사팀".equals(departCheck)||"인사1팀".equals(departCheck)||"인사2팀".equals(departCheck)) {
			return true;

		} else {
			try {
				response.sendRedirect("/notPermission");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

	}

}
