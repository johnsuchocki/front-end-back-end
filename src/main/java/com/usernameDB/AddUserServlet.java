package com.usernameDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	
	Users addToDBUser = new Users();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addToDBUser.setUserName(request.getParameter("username"));
		addToDBUser.setRealName(request.getParameter("firstname"));
		addToDBUser.setEmail(request.getParameter("email"));
		addToDBUser.setAge(request.getParameter("age"));
	
		System.out.println(addToDBUser.toString());
		
		DAO.addToDB(addToDBUser);
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
