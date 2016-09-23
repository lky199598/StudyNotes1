package dao;

import java.lang.reflect.Field;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BuyShopping;
import entity.Goods;

public class JDBC {
	private Connection conn;
	private PreparedStatement pre;
	private ResultSet res;

	public JDBC() {
		conn = null;
		pre = null;
		res = null;
	}

	public void get_Connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf-8";
			conn = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("数据库关闭失败!\n");
				e.printStackTrace();
			}
			conn = null;
		}

		if (pre != null) {
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pre = null;
		}

		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			res = null;
		}

	}
	
	
	//Field 提供有关类或接口的单个字段的信息，以及对它的动态访问权限。反射的字段可能是一个类（静态）字段或实例字段。
	public ArrayList<Object> Select_All_Information(Object obj)
	{
		ArrayList<Object> list = new ArrayList<Object>();
		
	 	Class c = obj.getClass();// 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
	 // System.out.println(c.getName() + "\t" + c.getName());
		try {
			pre = conn.prepareStatement("select *from "+c.getSimpleName());
			res = pre.executeQuery();
			
			Field[] f = c.getDeclaredFields();
 // 返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段
	//		包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
			
			Object o = null;			
			while(res.next())
			{
				o = c.newInstance();
				for(int i=0; i<f.length; i++)
				{					
//将此对象的 accessible 标志设置为指示的布尔值。值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false则指示反射的对象应该实施 Java 语言访问检查。					
					f[i].setAccessible(true);
				    					
					//将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
					f[i].set(o, res.getObject(f[i].getName()));
					 System.out.print(f[i].get(o) + "\t");
				}
				list.add(o);
			}
			close();
			
			return list; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	
	public Object Select_Information_From_ID(Object obj, Object id)
	{
		get_Connection();
		Class c = obj.getClass();
		Field field[] = c.getDeclaredFields();
			
			try {
				field[0].setAccessible(true);
				pre = conn.prepareStatement("select *from "+c.getSimpleName()+" where "+field[0].getName()+"=?");
				pre.setObject(1, id);
				res = pre.executeQuery();
				
				Object o=null;
				if(res.next())
				{
					o = c.newInstance();
					for(Field f : field)
					{
						f.setAccessible(true);
					    f.set(o, res.getObject(f.getName()));				
					}
					
				}
					
				close();
				return o;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return null;
	}
	
	
	// "insert into List(User_id, House_id, Rent_rented_station, End_time)
	//values(?,?,?,?)"
	public boolean Insert(Object obj)
	{
		
		get_Connection();
				
		Class c = obj.getClass();		
		Field[] field = c.getDeclaredFields();		
		
		String str = new String("insert into "+c.getSimpleName()+"(");
		for(int i=0; i<field.length; i++)
		{
			
			if(i==field.length-1)
				str+=field[i].getName()+")values(";
			else
			str+=field[i].getName()+",";			
		}
		for(int i=0; i<field.length; i++)
		{
			if(i==field.length-1)
				str+="?)";
			else
			str+="?,";	
		}
		
		try {
			pre = conn.prepareStatement(str);
			for(int i=0; i<field.length; i++)
			{
				field[i].setAccessible(true);
				pre.setObject(i+1, field[i].get(obj));
			}			
			pre.executeUpdate();
			close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean Delete(Object obj)
	{
		get_Connection();
		Class c = obj.getClass();
		Field[] field = c.getDeclaredFields();
		
		try {
			field[0].setAccessible(true);
			pre = conn.prepareStatement("delete from "+c.getSimpleName()+" where "+field[0].getName()+"=?");
			pre.setObject(1, field[0].get(obj));
		    pre.executeUpdate(); 
		    close();
		    return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	  // update Rent_rented set Rent_rented_station=?,End_time=? where User_id=? and House_id=?
     public boolean update(Object obj)
     {
    	 get_Connection();
    	 Class c = obj.getClass();
    	 Field[] f = c.getDeclaredFields();
    	 
    	 String str = new String("update "+c.getName()+" set ");
         for(int i=1; i<f.length; i++)
         {
        	 if(i==f.length-1)
        		 str+=f[i].getName()+"=? where "+f[0].getName()+"=?";
        	 else
        		 str+=f[i].getName()+"=?, ";
         }
         
         try {
        	 
			pre = conn.prepareStatement(str);
			  for(int i=0; i<f.length; i++)
		         {
		        	 f[i].setAccessible(true);
		        	 if(i==0)
		        		 pre.setObject(f.length, f[i].get(obj));
		        	 else
		        		 pre.setObject(i, f[i].get(obj));
		         }		         
		         pre.executeUpdate();
		         close();
		         return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
       return false;
     }
	
	
	
	//返回最近五项浏览记录
	public ArrayList<Goods> Get_Browse_Record(String record_id) {
		System.out.println("record_ID: " + record_id);
		ArrayList<Goods> list = new ArrayList<Goods>();
		Goods g = new Goods();
		int count = 5;// 返回前五条记录
		if (record_id != null && record_id.length() > 0) {
			String[] id = record_id.split(",");
			if (id.length >= 6)
				for (int i = id.length - 2; i > id.length - 2 - count; i--)
					list.add((Goods)Select_Information_From_ID(g, Integer.parseInt(id[i])));

			else
				for (int i = id.length - 2; i >= 0; i--)
					list.add((Goods)Select_Information_From_ID(g, Integer.parseInt(id[i])));
			return list;
		}
		return null;
	}

	public int Goods_Number(int id)
	{	
		get_Connection();
		int number=0;
		try {	
			pre = conn
					.prepareStatement("select number from Goods where GoodsID=?");
			pre.setInt(1, id);
			res = pre.executeQuery();
			if (res.next())
				number=res.getInt("number");
			 close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	
	public void After_Buy_Goods(int id, int BuyNumber)// 点击购买商品后库存量的变化
	{
		get_Connection();
		try {
			int number=Goods_Number(id);
			pre = conn
					.prepareStatement("update Goods set number=? where GoodsID=?");
			pre.setInt(1, number - BuyNumber);
			pre.setInt(2, id);
			pre.executeUpdate();
			close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 取消购买商品后库存量的变化
	public void After_Cancel_Goods(int id, int CancelNumber) {

		get_Connection();
		try {
			int number = Goods_Number(id);			
			pre = conn
					.prepareStatement("update Goods set number=? where GoodsID=?");
			pre.setInt(1, number + CancelNumber);
			pre.setInt(2, id);
			pre.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
