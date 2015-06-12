package kr.ac.jeju.controller.shoppingbasket;

import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.model.UserBasket;
import kr.ac.jeju.service.ProductService;
import kr.ac.jeju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping(value = "/shoppingBasket")
public class UserBasketController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getShoppingBasketList(Model model,
                                        @CookieValue(value = "userName", required = true)Cookie userCookie){

        int sum = 0;
        String cookieName = null;
        if (userCookie != null) {
            try {
                cookieName = URLDecoder.decode(userCookie.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {
            return "/";
        }
        int id = 0;
        UserBasket userBasket = new UserBasket(cookieName, id);
        List<ProductItem> userBasketList = productService.userBasketList(userBasket);

        for(int i=0; i< userBasketList.size(); i++){
            sum += userBasketList.get(i).getPrice();
        }

        model.addAttribute("userBasket", userBasketList);
        model.addAttribute("userName", cookieName);
        model.addAttribute("sum", sum);

        return "basket/myShoppingbasket";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String purchase(Model model,
                           @RequestParam(value = "id", required = false) int id,
                           @CookieValue(value = "userName", required = true)Cookie userCookie){

        int sum = 0;
        String cookieName = null;
        if (userCookie != null) {
            try {
                cookieName = URLDecoder.decode(userCookie.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {
            return "/";
        }
        UserBasket userBasket = new UserBasket(cookieName, id);
        userService.purchase(userBasket);
        List<ProductItem> userBasketList = productService.userBasketList(userBasket);

        for(int i=0; i< userBasketList.size(); i++){
            sum += userBasketList.get(i).getPrice();
        }

        model.addAttribute("userBasket", userBasketList);
        model.addAttribute("userName", cookieName);
        model.addAttribute("sum", sum);

        return "basket/myShoppingbasket";
    }
}
