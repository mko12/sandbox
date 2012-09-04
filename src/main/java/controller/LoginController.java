package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login(@ModelAttribute("user") User user,
			BindingResult result, HttpServletRequest request) {

		String nextJsp = "failedlogin";
		String username = user.getUsername();
		
		user = userSvc.verifyUser(user);
		
		if (user != null) 
			nextJsp = "redirect:/card/cards";
		
		
		  ModelAndView mv = new ModelAndView(nextJsp);
		  mv.addObject("name", username); 
		 
		  request.getSession().setAttribute("name", username);
		  request.getSession().setAttribute("loginStatus", userSvc.getLoginStatus().toString());
			  
		  return mv;
	}
}
