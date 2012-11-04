package controller;

import java.security.Principal;
import java.util.Map;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import service.UserService;
import to.UserTO;
import entity.User;

@Controller
@RequestMapping("/user/*")
public class UserController {
 
	protected static Logger logger = Logger.getLogger("controller");
	
    @Autowired
    private UserService userSvc;
 
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @RequestMapping("/users")
    public String listUsers(Map<String, Object> map, Principal principal) {
 
    	logger.debug("Received request to list all the USERS");
    	
    	String name = principal.getName();
    	
        map.put("user", new User());
        map.put("userList", userSvc.getUsers());
        map.put("username", name);
        return "user";
    }
    
    /**
	 * Edit an existing User
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/details/{userId}", method=RequestMethod.GET)
    public ModelAndView getUserDetails(@PathVariable("userId") Integer userId) { 
		
		logger.debug("Received request to get details for a USER");
		
		User user = userSvc.getUser(userId);
	
		ModelAndView mav = new ModelAndView("userdetails");
		mav.addObject("user", user);
        mav.addObject("userId", Integer.toString(userId));
        
        return mav;
    }
	
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
    User user, BindingResult result) {
    	String message = "======== Received request to add a USER. UserName:" + user.getUsername();
    	logger.debug(message);
    	
    	user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
        userSvc.addUser(user);
 
        return "redirect:/ihelp/user/users";
    }
    
    @RequestMapping(value="/json/{userId}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody UserTO getUserInJSON(@PathVariable("userId") Integer userId) {
    	String message = "======== Received request to return a USER in JSON. User ID: " + userId;
    	logger.debug(message);
    	
    	User user = userSvc.getUser(userId);
		// Convert User to UserTO
    	UserTO userTO = new UserTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail()); 
		return userTO;
	} 
    
    /**
     * Update a  user
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateFlashcard(@ModelAttribute("user") User user) {
    	
    	logger.debug("Received request to update a user");
    	
    	userSvc.updateUser(user);
    	 
        return "redirect:/ihelp/user/users";
    }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId")
    Integer userId) {
 
    	String debugMessage = "Received request to delete a USER with id= " + userId;
    	logger.debug(debugMessage);
    	
        userSvc.deleteUser(userId);
 
        return "redirect:/ihelp/user/users";
    }
}