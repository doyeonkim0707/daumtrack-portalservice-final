package kr.ac.jeju.controller.register;

import kr.ac.jeju.Exception.AlreadyExistingMemberException;
import kr.ac.jeju.model.LoginCommand;
import kr.ac.jeju.model.User;
import kr.ac.jeju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registerUser")
public class RegisterUserController {

    @Autowired
    UserService userService;

    @RequestMapping("/step1")
    public String handelStep1(Model model, User user){

        /*model.addAttribute("registerRequest",new LoginCommand());*/

        return "registerUser/step1";
    }

    @RequestMapping(value = "/step2", method = RequestMethod.POST)
    public String handelStep2(User newUser){
        //아이디 중복 처리 해야됨
        try {
            userService.register(newUser);
            return "redirect:/";
        }catch (AlreadyExistingMemberException ex){
            return "registerUser/step2";
        }
    }
}
