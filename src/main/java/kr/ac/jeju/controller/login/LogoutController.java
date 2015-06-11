package kr.ac.jeju.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletResponse res,
                         @CookieValue(value = "userName", required = false) Cookie userCookie){

        if(userCookie != null){
            userCookie.setMaxAge(0);
            res.addCookie(userCookie);
        }

        return "redirect:/";
    }

}
