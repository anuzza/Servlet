package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String psw = request.getParameter("password");
		
		UserDao udao = new UserDaoImpl();
		
		
		if (udao.login(un, psw)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("activeuser", un);
			session.setMaxInactiveInterval(180);
			
			
			request.setAttribute("uname", un);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
			
		}else {
			request.setAttribute("error", "user not found!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		// cmt
		
		
	}

}
