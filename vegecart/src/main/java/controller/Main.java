package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartLogic;
import model.Vegetable;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/cart.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		if(name.isEmpty() || price.isEmpty()) {
			request.setAttribute("err", "未記入の項目があります");
		}else {
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			if(cart == null) {
				cart = new Cart();
			}
			Vegetable vege = new Vegetable(name,Integer.parseInt(price));
			CartLogic logic = new CartLogic();
			logic.execute(cart, vege);
			session.setAttribute("cart", cart);
			request.setAttribute("msg", vege.getName() + "カートに追加しました");
		}
		doGet(request, response);
	}
}