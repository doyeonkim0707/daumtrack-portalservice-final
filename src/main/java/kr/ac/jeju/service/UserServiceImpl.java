package kr.ac.jeju.service;


import kr.ac.jeju.model.User;
import kr.ac.jeju.repository.UserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoMapper userDaoMapper;

	@Override
	public List<User> list() {
		return userDaoMapper.findAll();
	}

	@Transactional
	@Override
	public void register(User user) {
		//아이디 중복 처리 해야됨
		userDaoMapper.insert(user);
	}
}
