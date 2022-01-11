package com.servlet;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.model.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("signup.jsp").forward(request, response);
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		String un = request.getParameter("username");
		String psw = request.getParameter("password");
		
		
//		System.out.println(fn+ln+un+psw);
		
//		request.setAttribute("fn", fn);
//		request.setAttribute("ln", ln);
//		request.setAttribute("un", un);
//		request.setAttribute("psw", psw);
		
		
		
		User u = new User ();
		u.setFname(fn);
		u.setLname(ln);
		u.setUsername(un);
		u.setPassword(psw);
		
		
		UserDao udao = new UserDaoImpl();
		udao.signup(u);
		
		
		
		
		
//		request.setAttribute("user", u);
//		request.setAttribute(psw, response);
				
				
		
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}	
		

}
