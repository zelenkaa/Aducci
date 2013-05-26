package aducci.servlet.admin;

import java.io.IOException;
import javax.servlet.http.*;

import aducci.core.AuthorizedEmailCore;

@SuppressWarnings("serial")
public class AdminAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		AuthorizedEmailCore.AddAuthorizedEmail(req.getParameter("email"));

		try {
			req.getRequestDispatcher("/WEB-INF/jsp/admin/admin.jsp").forward(req, resp);
		} catch (Exception e) {
		}
	}

}
