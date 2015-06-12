package kr.ac.jeju.repository;

import kr.ac.jeju.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoMapper {

	 List<User> findAll();
	 void insert(User user);
	 User findById(String id);

}
