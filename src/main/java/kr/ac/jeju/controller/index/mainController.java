package kr.ac.jeju.controller.index;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(ModelMap model){

        model.addAttribute("message", "Hello world!");
        return "index";
    }

}
