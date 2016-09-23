package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JavaBean.Message;

/*
 * 对Mysql消息表相关操作
 */

public class MessageDao {

	public ArrayList<Message> Select_Information_From_Column(String command,
			String description) {

		Connection conn = JDBC_Connection.get_Connection();
		
		ArrayList<Message> list = new ArrayList<Message>();

		StringBuffer str = new StringBuffer(
				"select id,command,description,content from Message where 1=1");
		List<String> param_list = new ArrayList<String>();
		if (command != null && !"".equals(command.trim())) {
			str.append(" and command=?");
			param_list.add(command);
		
		}
		/* command.trim(), 此方法可用于截去字符串开头和末尾的空白 */
		if (description != null && !"".equals(description.trim())) {
			//mysql 字符串拼接用空格拼
			str.append(" and description like '%' ? '%'");
			param_list.add(description);
		}

		try {
			PreparedStatement pre= conn.prepareStatement(str.toString());
			for (int i = 0; i < param_list.size(); i++)
				pre.setString(i + 1, param_list.get(i).trim());

			ResultSet res = pre.executeQuery();
			while (res.next()) {

				Message m = new Message();
				m.setId(res.getInt("id"));
				m.setCommand(res.getString("command"));
				m.setContent(res.getString("content"));
				m.setDescription(res.getString("description"));
				list.add(m);
			}
			JDBC_Connection.close(conn, pre, res);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
