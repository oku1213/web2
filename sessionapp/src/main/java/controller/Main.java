package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name ="山田";
		int age =28;
		//超重要
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("age", age);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/result.jsp");
		rd.forward(request, response);
		//1行目で済む書き方
		//request.getRequestDispatcher("WEB-INF/view/result.jsp").forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
