package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import JavaBean.Message;
import db.DBAccess;

public class MessageDao_1 {

	public ArrayList<Message> Select_Information_From_Column(String command,
			String description) {

		// System.out.println(command+"\t"+description);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> Message_List = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();
			Message m = new Message();
			if (command != null)
				m.setCommand(command.trim());

			if (description != null)
				m.setDescription(description.trim());

			//接口式编程的规范
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			Message_List = imessage.Select_Message_Information(m);
			
			return (ArrayList<Message>) Message_List;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return null;
	}

	public boolean Delete_One_Message(int id) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();

			sqlSession.delete("Message.Delete_One_Message", id);
			sqlSession.commit();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return false;
	}
	
	public boolean Delete_Batch_Message(List<Integer> ids) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();

			sqlSession.delete("Message.Delete_Batch_Message", ids);
			sqlSession.commit();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		return false;
	}
	
	
	
	

	public static void main(String[] args) {
		MessageDao_1 m = new MessageDao_1();
		m.Select_Information_From_Column("", "");
	}
}
