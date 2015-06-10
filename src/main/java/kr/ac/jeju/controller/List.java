package kr.ac.jeju.controller;


import kr.ac.jeju.model.User;
import kr.ac.jeju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class List {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public java.util.List<User> list() {
		return userService.list();
	}
}
