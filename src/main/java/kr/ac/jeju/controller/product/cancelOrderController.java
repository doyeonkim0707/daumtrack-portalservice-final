package kr.ac.jeju.controller.product;

import kr.ac.jeju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cancel")
public class cancelOrderController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String cancel(@RequestParam(value = "id", required = true) int id){

        userService.cancel(id);

        return "redirect:/shoppingBasket";
    }

}
