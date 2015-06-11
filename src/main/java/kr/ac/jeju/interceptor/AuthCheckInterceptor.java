package kr.ac.jeju.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.CookieHandler;
import java.net.HttpCookie;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String sessionid = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(int i = 0; i <cookies.length; i++){
				if(cookies[i].getName().equals("userName")){
					sessionid = cookies[i].getValue();
					return true;
				}
			}
		}
		response.sendRedirect(request.getContextPath()+"/");
		return false;
	}
	
}
