package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 数据库的加载，连接和关闭
 */

public class JDBC_Connection {
	private final static String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8";
	private final static String user = "root";
	private final static String password = "";

	public static Connection get_Connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
	        return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn,PreparedStatement pre,ResultSet res) {

		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			res = null;
		}
		if (pre != null) {
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pre = null;
		}

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

	}

}
