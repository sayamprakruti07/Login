package com.login;
import java.io.IOException;

import com.login.dao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		
		LoginDao dao = new LoginDao();
		
		//if(uname.equals("prakruti") && pass.equals("hello"))
		if(dao.checkDetails(uname, pass))
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
			
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
