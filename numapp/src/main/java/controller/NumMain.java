package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Num;
import model.NumLogic;

@WebServlet("/NumMain")
public class NumMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String org = request.getParameter("org");
		Num num = new Num(org);
		NumLogic logic =new NumLogic();
		logic.execute(num);
		request.setAttribute("num", num);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}

}
