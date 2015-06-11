package kr.ac.jeju.controller.product;

import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.repository.ProductDaoMapper;
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

@Controller
@RequestMapping("/editProduct")
public class editProductController {

    @Autowired
    ProductDaoMapper productDaoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String edit(Model model,
                       @RequestParam(value = "id", required = false) int id,
                       @CookieValue(value = "userName", required = false) Cookie userCookie){

        ProductItem productItem = productDaoMapper.findById(id);

        String cookieName = null;
        if(userCookie != null){
            try {
                cookieName = URLDecoder.decode(userCookie.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        model.addAttribute(productItem);
        model.addAttribute("userId", cookieName);

        return "/product/editForm";
    }
}
