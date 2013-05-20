package aducci;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {	
		try 
		{			
			req.getRequestDispatcher("/WEB-INF/jsp/admin/admin.jsp").forward(req, resp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
