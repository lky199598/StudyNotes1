package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;


/**
 * Servlet implementation class GetUser
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	    String email=request.getParameter("email");
	    String gender=request.getParameter("gender");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date birthday = null;
	    try {
	    	birthday=sdf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String[] favorite=request.getParameterValues("favorite");
	    String introduce=request.getParameter("introduce");
	    boolean isAccept;
	    if(request.getParameter("isAccept") != null)
	    	isAccept=true;
	    else
	    	isAccept=false;	    
	    User U=new User(username, password, email, gender, birthday, favorite, introduce, isAccept);
	    	
	request.getSession().setAttribute("user", U);
	request.getRequestDispatcher("/ShowUser.jsp").forward(request, response);
	}

}
