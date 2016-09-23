package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import until.connection;
import entity.Items;

public class ItemsDao {
	
	public ArrayList<Items> getAllItems()
	{
		ArrayList<Items> list = new ArrayList<Items>();
		Connection conn = connection.get_Connection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select *from items");
		    ResultSet res = pre.executeQuery();
		    
		    while(res.next())
		    {
		    	Items item = new Items();
		    	item.setId(res.getInt("id"));
		    	item.setName(res.getString("name"));
		    	item.setCity(res.getString("city"));
		    	item.setNumber(res.getInt("number"));
		    	item.setPrice(res.getInt("price"));
		    	item.setPicture(res.getString("picture"));
		    	list.add(item);
		    }
		    
		    if(pre != null)
		    {
		    	pre.close();
		    	pre=null;		    	
		    }
		    
		    if(res != null)
		    {
		    	res.close();
		    	res=null;
		    }
		    connection.close();
		    return list;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Items getItems_information(int id)
	{
		Connection conn = connection.get_Connection();
		PreparedStatement pre=null;
		ResultSet res=null;
		
		try {
			 pre= conn.prepareStatement("select *from items where id=?");
			 pre.setInt(1, id);
			 res= pre.executeQuery();
			
			if(res.next())
			{
				Items items = new Items();
				items.setId(res.getInt("id"));
				items.setName(res.getString("name"));
				items.setCity(res.getString("city"));
				items.setNumber(res.getInt("number"));
				items.setPrice(res.getInt("price"));
				items.setPicture(res.getString("picture"));
				
				connection.close();
			return items;
			}
		    			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			 if(pre != null)
			    {
			    	try {
						pre.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	pre=null;		    	
			    }
			    
			    if(res != null)
			    {
			    	try {
						res.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	res=null;
			    }
		}
		return null;
	}
	
	public ArrayList<Items> getFiveList(String record_id)
	{
		System.out.println("record_ID: "+record_id);
		ArrayList<Items> list = new ArrayList<Items>();
		int count=5;//返回前五条记录
		if(record_id != null && record_id.length() > 0)
		{
			String[] id = record_id.split(",");
			if(id.length >= 6)
				for(int i=id.length-2; i>id.length-2-count; i--)
					list.add(getItems_information(Integer.parseInt(id[i])));
			
			else
				for(int i=id.length-2; i>=0; i--)					
					list.add(getItems_information(Integer.parseInt(id[i])));			
		return list;
		}
		return null;		
	}
}
