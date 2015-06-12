package kr.ac.jeju.service;


import kr.ac.jeju.model.User;
import kr.ac.jeju.model.UserBasket;
import kr.ac.jeju.repository.ProductDaoMapper;
import kr.ac.jeju.repository.UserBasketDaoMapper;
import kr.ac.jeju.repository.UserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoMapper userDaoMapper;

	@Autowired
	UserBasketDaoMapper userBasketDaoMapper;

	@Override
	public List<User> list() {
		return userDaoMapper.findAll();
	}

	@Override
	public void cancel(int id) {
		userBasketDaoMapper.delete(id);
	}

	@Override
	public void purchase(UserBasket userBasket) {
		userBasketDaoMapper.insert(userBasket);
	}

	@Transactional
	@Override
	public void register(User user) {
		//아이디 중복 처리 해야됨
		userDaoMapper.insert(user);
	}
}
