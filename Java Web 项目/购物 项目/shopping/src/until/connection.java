package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection
{
    private static Connection conn=null;
    
    public static Connection get_Connection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=utf-8";
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
        return conn;
    }

    public static void close()
    {
        if(conn != null)
        {
            try
            {
                conn.close();
            }
            catch(SQLException e)
            {
                System.out.println("Êý¾Ý¿â¹Ø±ÕÊ§°Ü!\n");
                e.printStackTrace();
            }
            conn=null;
        }

    }
}
