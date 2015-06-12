package kr.ac.jeju.service;


import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.model.UserBasket;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {

    List<ProductItem> list();
    List<ProductItem> userBasketList(UserBasket userBasket);
    ProductItem printProductInfo(int id);
    void uploadProduct(ProductItem productItem, BindingResult result);
    void updateProduct(ProductItem productItem, BindingResult result);

}
