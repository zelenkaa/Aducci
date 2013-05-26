package aducci.servlet.game;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aducci.business.user.Authentication;
import aducci.business.user.LoginState;

@SuppressWarnings("serial")
public class CreateGameServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		LoginState state = Authentication.GetLoginState();

		try {
			if (state == LoginState.validEmail) {
				
				
				//req.getRequestDispatcher("/WEB-INF/jsp/game.jsp").forward(req, resp);
			}
			else if (state == LoginState.notLoggedIn) {
				resp.getWriter().println("<p>Please <a href=\"/\">sign in</a>.</p>");
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
