package kr.ac.jeju.controller.product;

import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.repository.ProductDaoMapper;
import kr.ac.jeju.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/editProduct")
public class editProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public String getEditForm(Model model,
                              @RequestParam(value = "id", required = false) int id,
                              @CookieValue(value = "userName", required = false) Cookie userCookie) {

        ProductItem productItem = productService.printProductInfo(id);

        String cookieName = null;
        if (userCookie != null) {
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

    @RequestMapping(method = RequestMethod.POST)
    public String edit(ProductItem productItem, BindingResult result,
                       @CookieValue(value = "userName", required = false) Cookie userCookie,
                       @RequestParam(value = "id", required = true) int id) {

        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.err.println("Error:" + error.getCode() + "-" + error.getDefaultMessage());
            }
            return "/product/editForm";
        }

        if(!productItem.getFileData().isEmpty()){
            try {
                productItem.setDistributor(URLDecoder.decode(userCookie.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            productService.updateProduct(productItem, result);
        }
        return "redirect:/productInfo?id=" + productItem.getId() ;
    }
}
