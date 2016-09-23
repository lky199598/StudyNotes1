package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JDBC_reflect;
import dao.MessageDao;
import JavaBean.Message;

/**
 * 列表页面初始化控制
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		request.setCharacterEncoding("utf-8");
		
		//接受页面的值
		String command = request.getParameter("command");
		String description = request.getParameter("description");
//向页面传值
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		
		//查询内容列表并传给页面
		List<Message> Message_list = new MessageDao().Select_Information_From_Column(command, description);
	    request.setAttribute("Message_list", Message_list);
        request.setAttribute("Message_Length", Message_list.size());

		//向页面跳转  
	   request.getRequestDispatcher("/WEB-INF/JSP/back/list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
