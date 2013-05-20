package aducci.user;


import aducci.core.UserCore;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class Authentication {

	public static LoginState IsAuthorizedUser()
	{
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		if(!userService.isUserLoggedIn())
		{
			return LoginState.notLoggedIn;
		}
		
		return UserCore.IsAuthorizedUser(user) ? LoginState.validEmail : LoginState.invalidEmail;		
		
	}	
}
