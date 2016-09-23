package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.BuyShopping;
import entity.Items;

public class ItemsDao {
	private Connection conn;
	private PreparedStatement pre;
	private ResultSet res;

	public ItemsDao() {
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

	public ArrayList<Items> getAllItems() {
		ArrayList<Items> list = new ArrayList<Items>();
		get_Connection();

		try {
			pre = conn.prepareStatement("select *from items");
			res = pre.executeQuery();

			while (res.next()) {
				Items item = new Items();
				item.setId(res.getInt("Shopping_id"));
				item.setName(res.getString("name"));
				item.setCity(res.getString("city"));
				item.setNumber(res.getInt("number"));
				item.setPrice(res.getInt("price"));
				item.setPicture(res.getString("picture"));
				list.add(item);
			}
			close();
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Items getItems_information(int id) {
		get_Connection();

		try {
			pre = conn
					.prepareStatement("select *from items where Shopping_id=?");
			pre.setInt(1, id);
			res = pre.executeQuery();

			if (res.next()) {
				Items items = new Items();
				items.setId(res.getInt("Shopping_id"));
				items.setName(res.getString("name"));
				items.setCity(res.getString("city"));
				items.setNumber(res.getInt("number"));
				items.setPrice(res.getInt("price"));
				items.setPicture(res.getString("picture"));

				close();
				return items;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Items> getFiveList(String record_id) {
		System.out.println("record_ID: " + record_id);
		ArrayList<Items> list = new ArrayList<Items>();
		int count = 5;// 返回前五条记录
		if (record_id != null && record_id.length() > 0) {
			String[] id = record_id.split(",");
			if (id.length >= 6)
				for (int i = id.length - 2; i > id.length - 2 - count; i--)
					list.add(getItems_information(Integer.parseInt(id[i])));

			else
				for (int i = id.length - 2; i >= 0; i--)
					list.add(getItems_information(Integer.parseInt(id[i])));
			return list;
		}
		return null;
	}

	public void After_AddCart(int id, int BuyNumber)// 商品加入购物车后库存量的变化
	{

		get_Connection();
		try {
			int number = 0;
			pre = conn
					.prepareStatement("select number from items where Shopping_id=?");
			pre.setInt(1, id);
			res = pre.executeQuery();
			if (res.next())
				number = res.getInt("number");

			pre = conn
					.prepareStatement("update items set number=? where Shopping_id=?");
			pre.setInt(1, number - BuyNumber);
			pre.setInt(2, id);
			pre.executeUpdate();
			close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void After_DeleteCart(int id, int DeleteNumber) {

		get_Connection();
		try {
			int number = 0;
			pre = conn
					.prepareStatement("select number from items where Shopping_id = ?");
			pre.setInt(1, id);
			res = pre.executeQuery();
			if (res.next())
				number = res.getInt("number");

			pre = conn
					.prepareStatement("update items set number=? where Shopping_id=?");
			pre.setInt(1, number + DeleteNumber);
			pre.setInt(2, id);
			pre.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Cart> Select_From_Cart() {
		get_Connection();
		ArrayList<Cart> list = new ArrayList<Cart>();
		try {
			pre = conn.prepareStatement("select *from cart");
			res = pre.executeQuery();
			while (res.next()) {
				Cart c = new Cart();
				c.setCart_id(res.getInt(1));
				c.setCart_number(res.getInt(2));
				list.add(c);
			}
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	public ArrayList<BuyShopping> Select_BuyShopping()
	{
		ArrayList<BuyShopping> list = new ArrayList<BuyShopping>();
		get_Connection();
		try {
			pre = conn
					.prepareStatement("select *from buy");
			res = pre.executeQuery();
			while(res.next())
			{
				BuyShopping bs = new BuyShopping();
				bs.setBuy_id(res.getInt("buy_id"));
				bs.setCity(res.getString("city"));
				bs.setName(res.getString("name"));
				bs.setNumber(res.getInt("number"));
				bs.setPicture(res.getString("picture"));
				bs.setPrice(res.getDouble("price"));
				list.add(bs);
			}
			
			close();
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	// "insert into List(User_id, House_id, Rent_rented_station, End_time)values(?,?,?,?)"
	public void InsertBuy(int buy_id,String name, String city, String picture, double price, int buy_number)
	{
		int number=0;
		get_Connection();
		try {
			pre = conn
					.prepareStatement("select number from buy where buy_id=?");
			pre.setInt(1, buy_id);
			res = pre.executeQuery();
			if (res.next()) {
				number = res.getInt(1);
				System.out.println("number: "+number);
				pre = conn.prepareStatement("update buy set number=? where buy_id=?");
				
				pre.setInt(1, number + buy_number);
				pre.setInt(2, buy_id);
		        pre.executeUpdate();
				
			} else {
				pre = conn
						.prepareStatement("insert into Buy(buy_id, name, city, price, number, picture)values(?,?,?,?,?,?)");
				pre.setInt(1, buy_id);
				pre.setString(2, name);
				pre.setString(3, city);
				pre.setDouble(4, price);
				pre.setInt(5, buy_number);
				pre.setString(6, picture);
				
				pre.executeUpdate();
			}
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void DeleteBuyRecord(int buy_id)
	{
		get_Connection();
		try {		
				pre = conn
						.prepareStatement("delete from buy where buy_id=?");
				pre.setInt(1, buy_id);				
				pre.executeUpdate();			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void RemoveFromCart(int Cart_id) {
		get_Connection();
		try {
			pre = conn.prepareStatement("delete from Cart where Cart_id=?");
			pre.setInt(1, Cart_id);
			pre.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void AddInCart(int Cart_id, int Cart_number) {
		int number = 0;
		get_Connection();
		try {
			pre = conn
					.prepareStatement("select Cart_number from cart where cart_id=?");
			pre.setInt(1, Cart_id);
			res = pre.executeQuery();
			if (res.next()) {
				number = res.getInt(1);
				System.out.println("number: "+number);
				pre = conn.prepareStatement("update Cart set Cart_number=? where cart_id=?");
				pre.setInt(1, number + Cart_number);
				pre.setInt(2, Cart_id);
		        pre.executeUpdate();
				
			} else {
				pre = conn
						.prepareStatement("insert into Cart(Cart_id, Cart_number)values(?,?)");
				pre.setInt(1, Cart_id);
				pre.setInt(2, Cart_number);
				pre.executeUpdate();
			}
			
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
