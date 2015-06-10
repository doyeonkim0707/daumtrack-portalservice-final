package kr.ac.jeju.controller.register;

import kr.ac.jeju.Exception.AlreadyExistingMemberException;
import kr.ac.jeju.model.RegisterRequest;
import kr.ac.jeju.model.User;
import kr.ac.jeju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegistController {

    @Autowired
    UserService userService;

    @RequestMapping("/step1")
    public String handelStep1(Model model){

        model.addAttribute("registerRequest",new User());

        return "register/step1";
    }

    @RequestMapping(value = "/step2", method = RequestMethod.POST)
    public String handelStep2(User newUser){
        try {
            userService.register(newUser);
            return "redirect:/";
        }catch (AlreadyExistingMemberException ex){
            return "register/step2";
        }
    }
}
