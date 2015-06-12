package kr.ac.jeju.service;

import kr.ac.jeju.model.User;
import kr.ac.jeju.model.UserBasket;

import java.util.List;

public interface UserService {

	List<User> list();
	void cancel(int id);
	void purchase(UserBasket userBasket);
	void register(User NewUser);


}
