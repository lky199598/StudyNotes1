package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Cart;
import dao.ItemsDao;
import entity.Items;


public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemsDao itemsdao = new ItemsDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyServlet() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getParameter("action");
	 if(action.equals("BuyShopping")) {
			BuyShopping(request);			
			request.getRequestDispatcher("/BuyShoppingSuccess.jsp").forward(request, response);
		} 
	 else
		 if(action.equals("BuyShoppingFromCart"))
		 {
			 BuyShoppingFromCart(request);
			 request.getRequestDispatcher("/BuyShoppingFromCartSuccess.jsp").forward(request, response);
		 }
	 else if (action.equals("DeleteBuyRecord")) {
			DeleteBuyRecord(request);
			request.getRequestDispatcher("/Buy.jsp").forward(request, response);
		}

	}
	
	public void InsertBuy(HttpServletRequest request) {
		
		int Buy_id = Integer.parseInt(request.getParameter("Buy_id"));

		int Buy_number = Integer.parseInt(request.getParameter("Buy_number"));
		Items item = itemsdao.getItems_information(Buy_id);
		
		String name = item.getName();
		String city = item.getCity();
		String picture = item.getPicture();
		double price = item.getPrice();

		itemsdao.InsertBuy(Buy_id, name, city, picture, price, Buy_number);

	}
	
	public void BuyShopping(HttpServletRequest request)
	{
		int Buy_id = Integer.parseInt(request.getParameter("Buy_id"));
		int Buy_number = Integer.parseInt(request.getParameter("Buy_number"));
		
		InsertBuy(request);
		itemsdao.After_AddCart(Buy_id, Buy_number);
	}

	public void BuyShoppingFromCart(HttpServletRequest request)
	{
		int Buy_id = Integer.parseInt(request.getParameter("Buy_id"));
		InsertBuy(request);		
		itemsdao.RemoveFromCart(Buy_id);
	}
	
	public void DeleteBuyRecord(HttpServletRequest request) {
		int Buy_id = Integer.parseInt(request.getParameter("Buy_id"));
		itemsdao.DeleteBuyRecord(Buy_id);
	}

}
