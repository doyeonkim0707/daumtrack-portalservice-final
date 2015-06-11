package kr.ac.jeju.controller.register;


import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/uploadProduct")
public class UploadProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUploadForm(Model model,
                                @CookieValue(value = "userName", required = false) Cookie userCookie) throws UnsupportedEncodingException {

        model.addAttribute(new ProductItem());
        model.addAttribute("userName", URLDecoder.decode(userCookie.getValue(), "UTF-8"));

        return "/uploadProduct/uploadForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(ProductItem productItem, BindingResult result, HttpServletRequest req,
                         @CookieValue(value = "userName", required = false) Cookie userCookie){

        if(result.hasErrors()){
            for(ObjectError error : result.getAllErrors()){
                System.err.println("Error:" + error.getCode() + "-" + error.getDefaultMessage());
            }
            return "/uploadProduct/uploadForm";
        }

        if(!productItem.getFileData().isEmpty()){
            try {
                productItem.setDistributor(URLDecoder.decode(userCookie.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            productService.uploadProduct(productItem, result);
        }
        return "redirect:/";
    }
}