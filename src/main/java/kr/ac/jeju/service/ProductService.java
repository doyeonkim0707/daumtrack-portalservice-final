package kr.ac.jeju.service;


import kr.ac.jeju.model.ProductItem;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {

    List<ProductItem> list();
    void uploadProduct(ProductItem productItem, BindingResult result);
}
