

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/result")
public class Result extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int dogAge = Integer.parseInt(request.getParameter("age"));
		int humanAge = dogAge * 7;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>犬年齢計算機</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>結果</p>");
		out.printf("<p>%sちゃん(%d歳)の年齢を人間に換算すると%d歳です</p>",name,dogAge,humanAge);
		out.println("</body>");
		out.println("</html>");
		
	}
}
