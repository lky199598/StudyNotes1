package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import dao.Cart;
import dao.ItemsDao;
import entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemsDao itemsdao = new ItemsDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");		
		String action=request.getParameter("action");				
		
		if(action.equals("add"))
	    {
			AddIntoCart(request);
		 	request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
		else 
			if(action.equals("show"))
				request.getRequestDispatcher("/Cart.jsp").forward(request, response);
			else
				if(action.equals("delete"))
				{
					DeleteCart(request);
					request.getRequestDispatcher("/Cart.jsp").forward(request, response);
				}
	}

	public void AddIntoCart(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int number = Integer.parseInt(request.getParameter("number"));

		Items item = itemsdao.getItems_information(id);

		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		cart.AddInCart(item, number);
	}

	public void DeleteCart(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Items item = itemsdao.getItems_information(id);

		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.RemoveFromCart(item);
	}

}
