package controller;

import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
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
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
    User user, BindingResult result) {
 
        userSvc.addUser(user);
 
        return "redirect:/user/users";
    }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId")
    Integer userId) {
 
        userSvc.deleteUser(userId);
 
        return "redirect:/user/users";
    }
}