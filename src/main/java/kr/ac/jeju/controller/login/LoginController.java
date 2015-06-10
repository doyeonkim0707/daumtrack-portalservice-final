package kr.ac.jeju.controller.login;

import kr.ac.jeju.Exception.IdPasswordNotMatchingException;
import kr.ac.jeju.model.AuthInfo;
import kr.ac.jeju.model.LoginCommand;
import kr.ac.jeju.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String submit(LoginCommand loginCommand) {

        try {
            AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());

            return "redirect:/";
        } catch (IdPasswordNotMatchingException e) {
            //errors 넣어야됨.
            return "/login/loginForm";
        }
    }
}
