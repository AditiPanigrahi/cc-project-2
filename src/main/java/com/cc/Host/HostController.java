package com.cc.Host;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.User.User;
import com.cc.User.UserRepository;

@RestController
public class HostController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<User> getUser() {
		List<User> users = (List<User>) userRepository.findAll();
		System.out.println(userRepository.findAll());
		return users;
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.GET)
	public void saveUser() {
		User user = new User();
		user.setUserType("Host");
		user.setName("aditi");
		userRepository.save(user);
	}

}
