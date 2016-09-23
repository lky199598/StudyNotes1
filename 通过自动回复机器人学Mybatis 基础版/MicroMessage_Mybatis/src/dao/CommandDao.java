package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import JavaBean.Command;
import db.DBAccess;

public class CommandDao {

	public ArrayList<Command> Select_Information_From_Column(String name) {

		// System.out.println(command+"\t"+description);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Command> Command_List = new ArrayList<Command>();
		try {
			sqlSession = dbAccess.getSqlSession();
			Command c = new Command();
			if (name != null)
				c.setName(name);
			Command_List = sqlSession.selectList("Command.Query_Command_List",
					c);
			return (ArrayList<Command>) Command_List;
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
	
	
	public boolean Insert_Command() {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Command c = new Command();
		c.setCommand_id(100);
		c.setName("科技");
		c.setDescription("先进科技");
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("Insert_Command", c);
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
		CommandDao c = new CommandDao();
		c.Insert_Command();
	}
}
