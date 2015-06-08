package kr.ac.jeju.service;


import kr.ac.jeju.model.User;
import kr.ac.jeju.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> list() {
		return userDao.findAll();
	}

}
