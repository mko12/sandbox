package converter;

import java.beans.PropertyEditorSupport;

import entity.User;

import service.UserService;

/**
 * Used from example: http://empire5.com/development/binding-a-custom-object-in-spring-3/
 * 
 * @author cjting
 *
 */
public class UserConverter extends PropertyEditorSupport {
 
    private final UserService userSvc;
 
    public UserConverter(UserService userService) {
        this.userSvc = userService;
    }
 
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		User user = userSvc.getUser(Integer.parseInt(text));
        setValue(user);
	}

}