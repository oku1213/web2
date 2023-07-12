package controlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NumLogic;
import model.Numbeans;

@WebServlet("/NumMain")
public class NumMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String org = request.getParameter("org");
		Numbeans nb = new Numbeans(org);
		NumLogic nl = new NumLogic();
		nl.execute(nb);
		HttpSession session = request.getSession();
		session.setAttribute("nb",nb);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		rd.forward(request, response);
		
		
		
	
	}
}
