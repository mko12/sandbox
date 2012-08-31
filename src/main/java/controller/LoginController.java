package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;

import entity.User;

@Controller
public class LoginController {

	@Autowired
	private UserService userSvc;

	@RequestMapping("/login")
	public String listUsers(Map<String, Object> map) {

		map.put("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {

		String nextJsp = "failedlogin";
		user = userSvc.verifyUser(user);
		if (user != null) 
			nextJsp = "/card/cards";
		return nextJsp;
	}
}
