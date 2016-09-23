package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tiantian.dao.impl.jdbcDao;

public class test {
	public static void main(String[] args) {
		ResultSet res=new jdbcDao("tiantian").select_from_Table("user");
		try {
			while(res.next()){
				System.out.println(res.getString("User_id"));
				System.out.println(res.getString("User_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}	
