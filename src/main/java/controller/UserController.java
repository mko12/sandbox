package controller;

import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import service.UserService;

import entity.User;

@Controller
@RequestMapping("/user/*")
public class UserController {
 
    @Autowired
    private UserService userSvc;
 
    @RequestMapping("/users")
    public String listUsers(Map<String, Object> map) {
 
        map.put("user", new User());
        map.put("userList", userSvc.getUsers());
        return "user";
    }
 
    
/**    @RequestMapping("/details/{userId}")
    public String getUserDetails(@PathVariable("userId")
    Integer userId, Model model) {
  //  Map<String, Object> map) {
  	
    //	  map.put("user", userSvc.getUser(userId));
     //     map.put("userId", Integer.toString(userId));
    	model.addAttribute("userId", Integer.toString(userId)); 
    	model.addAttribute("user", userSvc.getUser(userId));
        return "userdetails";
    }
    */
    
    /**
	 * Edit an existing User
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/details/{userId}", method=RequestMethod.GET)
    public ModelAndView getUserDetails(@PathVariable("userId") Integer userId) { 
		
		User user = userSvc.getUser(userId);
	
		ModelAndView mav = new ModelAndView("userdetails");
		mav.addObject("user", user);
        mav.addObject("userId", Integer.toString(userId));
        
        return mav;
    }
	
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
    User user, BindingResult result) {
 
        userSvc.addUser(user);
 
        return "redirect:/ihelp/user/users";
    }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId")
    Integer userId) {
 
        userSvc.deleteUser(userId);
 
        return "redirect:/ihelp/user/users";
    }
}