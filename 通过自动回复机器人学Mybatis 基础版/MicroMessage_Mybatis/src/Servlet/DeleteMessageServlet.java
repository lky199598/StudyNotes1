package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDao_1;
import JavaBean.Message;
import Service.MessageService;

/**
 * Servlet implementation class DeleteMessageServlet
 */
@WebServlet("/DeleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置编码

		// 接受页面的值
		String id = request.getParameter("id");
		new MessageService().Delete_One_Message(id);

		// 向下一个页面传值,不知道原因，超链接传值的时候，上方设置编码的方法不管用

		System.out.println("DeleteMessageServlet:"
				+ new String(request.getParameter("command").getBytes(
						"ISO-8859-1"), "utf-8")
				+ "\t"
				+ new String(request.getParameter("description").getBytes(
						"ISO-8859-1"), "utf-8"));

		// 向页面跳转
		request.getRequestDispatcher("/ListServlet.action").forward(request,
				response);
	}

}
