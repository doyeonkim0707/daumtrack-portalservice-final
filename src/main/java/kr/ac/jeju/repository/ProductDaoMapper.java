package kr.ac.jeju.repository;

import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.model.User;
import kr.ac.jeju.model.UserBasket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDaoMapper {

    void insert(ProductItem productItem);
    void update(ProductItem productItem);
    List<ProductItem> findAll();
    ProductItem findById(int id);
    List<ProductItem> findUserProductList(UserBasket userBasket);

}
