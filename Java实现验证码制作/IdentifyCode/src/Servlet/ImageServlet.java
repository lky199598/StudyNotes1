package Servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //BufferedImage 子类描述具有可访问图像数据缓冲区的 Image
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		
		//Graphics 类是所有图形上下文的抽象基类，允许应用程序在组件（已经在各种设备上实现）以及闭屏图像上进行绘制。 
		//Graphics 对象封装了 Java 支持的基本呈现操作所需的状态信息。此状态信息包括以下属性		
		Graphics g = bi.getGraphics();
		
		//Color 类用于封装默认 sRGB 颜色空间中的颜色，或者用于封装由 ColorSpace 标识的任意颜色空间中的颜色
		Color c = new Color(200,150,255);
		g.setColor(c);//将此图形上下文的当前颜色设置为指定颜色。
		g.fillRect(0, 0, 68, 22);//   填充指定的矩形。
	    
		Random r = new Random();
		String str = "";
		char a;
		for(int i=0;i<4;i++)
		{
			if(r.nextInt(2) == 0)
				 a = (char) (r.nextInt(10)+'0');
			else
				a = (char)(r.nextInt(26)+'A');
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)) );
			g.drawString(a+"", (i*15)+3, 18);
			str+=a;
		}
		
		request.getSession().setAttribute("code", str);
	    ImageIO.write(bi, "JPG", response.getOutputStream());
	}

}
