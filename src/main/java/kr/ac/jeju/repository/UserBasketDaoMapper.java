package kr.ac.jeju.repository;

import kr.ac.jeju.model.ProductItem;
import kr.ac.jeju.model.UserBasket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBasketDaoMapper {
    void insert(UserBasket userBasket);
    void delete(int id);
    List<ProductItem> selectById(UserBasket userBasket);

}
