package com.po;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {

	 private Connection conn=null;
	    
	    public void get_Connection()
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";
	            conn=DriverManager.getConnection(url, "root", "");
	        }
	        catch(ClassNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }

	    public void close()
	    {
	        if(conn != null)
	        {
	            try
	            {
	                conn.close();
	            }
	            catch(SQLException e)
	            {
	                System.out.println("数据库关闭失败!\n");
	                e.printStackTrace();
	            }
	            conn=null;
	        }

	    }
    
    
    public ResultSet select_All_Information(Object obj)
    {
    	get_Connection();    	
        Class c=obj.getClass();
        // System.out.println(c1.getName() + "\t" + c1.getSimpleName());
        try
        {
            PreparedStatement pre=conn.prepareStatement("select *from " + c.getSimpleName());
            ResultSet res=pre.executeQuery();
            return res;
               
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet select_from_ID(Object obj)
    {
    	get_Connection();
    	
        Class c=obj.getClass();
        Field[] f = c.getDeclaredFields();
        // System.out.println(c1.getName() + "\t" + c1.getSimpleName());
        try
        {
            PreparedStatement pre=conn.prepareStatement("select from " + c.getSimpleName()+" where "+f[0].getName()+"=?");
            pre.setObject(1, f[0].get(obj));
            ResultSet res=pre.executeQuery();
            return res;
               
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    // insert into User(User_id, User_name, User_password,
    // User_telephone,User_idcard,User_sex,User_birthday)values(?,?,?,?,?,?,?)"

    public boolean insert(Object obj)
    {
    	get_Connection();
        Class c=obj.getClass();
        StringBuffer str=new StringBuffer("insert into " + c.getSimpleName() + "(");
        Field[] f=c.getDeclaredFields();
        for(int i=0; i < f.length; i++)
        {
            if(i + 1 == f.length)
                str.append(f[i].getName() + ")values(");
            else
                str.append(f[i].getName() + ", ");
        }
        for(int i=0; i < f.length; i++)
        {
            if(i + 1 == f.length)
                str.append("?)");
            else
                str.append("?, ");
        }
        try
        {
            PreparedStatement pre=conn.prepareStatement(str.toString());

            for(int i=0; i < f.length; i++)
            {
                f[i].setAccessible(true);
                pre.setObject(i + 1, f[i].get(obj));//pre.setString(i, "aaa");
                System.out.print(f[i].get(obj) + "\t");
            }
            pre.executeUpdate();

            // ResultSet res=pre.executeQuery();
            
            close();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Object obj)
    {
    	get_Connection();
        Class c=obj.getClass();
        Field[] f=c.getDeclaredFields();
        try
        {
            f[0].setAccessible(true);
            PreparedStatement pre=conn.prepareStatement("delete from " + c.getSimpleName() + " where " + f[0].getName() + "=?");
            pre.setObject(1, f[0].get(obj));
            pre.executeUpdate();
            close();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
return false;
    }

    // update Rent_rented set Rent_rented_station=?,End_time=? where User_id=? and House_id=?

    public boolean update(Object obj)
    {
    	get_Connection();
        Class c=obj.getClass();
        try
        {
            StringBuffer str=new StringBuffer("update " + c.getSimpleName() + " set ");

            Field[] f=c.getDeclaredFields();

            for(int i=1; i < f.length; i++)
            {
                if(i + 1 == f.length)
                    str.append(f[i].getName() + "=? where " + f[0].getName() + "=?");
                else
                    str.append(f[i].getName() + "=?, ");
            }

            PreparedStatement pre=conn.prepareStatement(str.toString());
            for(int i=0; i < f.length; i++)
            {
                f[i].setAccessible(true);
                if(i == 0)
                    pre.setObject(f.length, f[0].get(obj));
                else
                    pre.setObject(i, f[i].get(obj));
            }

            pre.executeUpdate();
            close();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}









