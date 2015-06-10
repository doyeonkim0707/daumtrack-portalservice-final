package kr.ac.jeju.controller.login;

import kr.ac.jeju.Exception.IdPasswordNotMatchingException;
import kr.ac.jeju.model.AuthInfo;
import kr.ac.jeju.model.LoginCommand;
import kr.ac.jeju.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login/loginForm")
public class LoginController {

    @Autowired
    AuthService authService;

    @RequestMapping(method = RequestMethod.GET)
    public String form(LoginCommand loginCommand){
        return  "login/loginForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(LoginCommand loginCommand, HttpServletResponse response, Model model, HttpServletRequest req) {

        try {
            AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());

            CookieGenerator cookieGer = new CookieGenerator();

            cookieGer.setCookieName("userName");

            try {
                cookieGer.addCookie(response, URLEncoder.encode(authInfo.getName(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if(authInfo.isLoginStatus()){
                cookieGer.setCookieMaxAge(60 * 60 * 24 * 30);
            }else {
                cookieGer.setCookieMaxAge(0);
            }

            return "redirect:/";
        } catch (IdPasswordNotMatchingException e) {
            //errors 넣어야됨.
            return "/login/loginForm";
        }

    }
}
