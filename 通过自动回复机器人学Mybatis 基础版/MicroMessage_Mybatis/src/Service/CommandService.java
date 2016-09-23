package Service;

/*
 * 维护Message表相关的业务功能
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import JavaBean.Command;
import JavaBean.Content;
import JavaBean.Message;
import Util.Iconst;
import dao.CommandDao;
import dao.JDBC_reflect;
import dao.MessageDao_1;
import db.DBAccess;

public class CommandService {

	public String Query_By_Command(String command)
	{
		List<Command> command_list;
		CommandDao c = new CommandDao();
		if(Iconst.Help_Command.equals(command))
		{
			command_list = c.Select_Information_From_Column(null);
			StringBuffer str = new StringBuffer();
			for(int i=0; i<command_list.size(); i++)
			{
				str.append("回复["+command_list.get(i).getName()+"]可以查看"+command_list.get(i).getDescription()+"<br/>");
			}
	return str.toString();
		}
			
		command_list = c.Select_Information_From_Column(command);
		
		if(command_list != null && command_list.size() > 0)
		{
			List<Content> content_list = command_list.get(0).getContent_list();
			if(content_list != null && content_list.size() > 0)
			{
			int n = new Random().nextInt(content_list.size());			
			return content_list.get(n).getContent();
			}
		}
		return Iconst.No_Matching_Content;
 	}
	

}
