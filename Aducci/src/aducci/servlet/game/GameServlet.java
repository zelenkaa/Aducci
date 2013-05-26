package aducci.servlet.game;

import java.io.IOException;
import javax.servlet.http.*;

import aducci.business.user.Authentication;
import aducci.business.user.LoginState;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GameServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		LoginState state = Authentication.GetLoginState();

		try {
			if (state == LoginState.validEmail) {
				req.getRequestDispatcher("/WEB-INF/jsp/game.jsp").forward(req, resp);
			}
			else if (state == LoginState.notLoggedIn) {
				UserService userService = UserServiceFactory.getUserService();
				String thisURL = req.getRequestURI() + "?" + req.getQueryString();
				resp.getWriter().println("<p>Please <a href=\"" + userService.createLoginURL(thisURL) + "\">sign in</a>.</p>");
			}
			else {
				req.getRequestDispatcher("unavailable.html").forward(req, resp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
