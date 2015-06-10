package kr.ac.jeju.controller.index;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(ModelMap model, HttpServletRequest req) throws UnsupportedEncodingException {

        String sessionid = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for(int i = 0; i <cookies.length; i++){
                if(cookies[i].getName().equals("userName")){
                    sessionid = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                }
            }
        }

        model.addAttribute("userId", sessionid);
        return "index";
    }

}
