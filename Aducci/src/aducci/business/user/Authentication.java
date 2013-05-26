package aducci.business.user;

import aducci.core.AuthorizedEmailCore;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Authentication {

	public static LoginState GetLoginState() {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		if (!userService.isUserLoggedIn()) {
			return LoginState.notLoggedIn;
		}

		return AuthorizedEmailCore.IsAuthorizedEmail(user.getEmail()) ? LoginState.validEmail : LoginState.invalidEmail;
	}
	
	
}
