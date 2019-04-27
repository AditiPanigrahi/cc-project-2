package com.cc.project2.Host;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.project2.User.User;
import com.cc.project2.User.UserRepository;

@RestController
public class HostController {
	
	@Autowired
	private UserRepository UserRepository;
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<User> getUser() {
		List<User> users = (List<User>) UserRepository.findAll();
		System.out.println(UserRepository.findAll());
		return users;
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.GET)
	public void saveUser() {
		User user = new User();
		user.setUserType("Host");
		user.setName("aditi");
		UserRepository.save(user);
	}

}
