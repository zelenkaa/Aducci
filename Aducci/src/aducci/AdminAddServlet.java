package aducci;

import java.io.IOException;
import javax.servlet.http.*;

import aducci.core.UserCore;

@SuppressWarnings("serial")
public class AdminAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {	
		UserCore.AddAuthorizedUser(req.getParameter("email"));
		try
		{
			req.getRequestDispatcher("/WEB-INF/jsp/admin/admin.jsp").forward(req, resp);
		}
		catch(Exception e)
		{
		
		}
	}
	
}
