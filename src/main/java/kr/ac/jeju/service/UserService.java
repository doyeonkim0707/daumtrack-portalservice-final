package kr.ac.jeju.service;

import kr.ac.jeju.model.User;

import java.util.List;

public interface UserService {

	List<User> list();
	void register(User NewUser);
}
