package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JavaBean.Message;


/*
 * 使用反射，对Mysql的操作：增删改查
 */

public class JDBC_reflect {

	// Field 提供有关类或接口的单个字段的信息，以及对它的动态访问权限。反射的字段可能是一个类（静态）字段或实例字段。
	public ArrayList<Object> Select_All_Information(Object obj) {

		Connection conn = JDBC_Connection.get_Connection();
		ArrayList<Object> list = new ArrayList<Object>();

		Class c = obj.getClass();// 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
		// System.out.println(c.getName() + "\t" + c.getName());
		StringBuffer str = new StringBuffer();
		try {
			// 返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段
			Field[] f = c.getDeclaredFields();

			// getDeclaredFields(), 包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。

			str.append("select ");
			for (Field field : f)
				str.append(field.getName()).append(",");
			str.deleteCharAt(str.length() - 1);
			str.append(" from ").append(c.getSimpleName());

			PreparedStatement pre = conn.prepareStatement(str.toString());
			ResultSet res = pre.executeQuery();

			Object o = null;
			while (res.next()) {
				o = c.newInstance();
				for (int i = 0; i < f.length; i++) {
					// 将此对象的 accessible 标志设置为指示的布尔值。值为 true 则指示反射的对象在使用时应该取消
					// Java 语言访问检查。值为 false则指示反射的对象应该实施 Java 语言访问检查。
					f[i].setAccessible(true);

					// 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
					f[i].set(o, res.getObject(f[i].getName()));
					// System.out.print(f[i].get(o) + "\t");
				}
				list.add(o);
			}
			JDBC_Connection.close(conn, pre, res);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Object Select_Information_From_ID(Object obj, Object id) {
		Connection conn = JDBC_Connection.get_Connection();
		Class c = obj.getClass();
		Field field[] = c.getDeclaredFields();

		try {
			field[0].setAccessible(true);
			PreparedStatement pre = conn
					.prepareStatement("select *from " + c.getSimpleName()
							+ " where " + field[0].getName() + "=?");
			pre.setObject(1, id);
			ResultSet res = pre.executeQuery();

			Object o = null;
			if (res.next()) {
				o = c.newInstance();
				for (Field f : field) {
					f.setAccessible(true);
					f.set(o, res.getObject(f.getName()));
				}

			}

			JDBC_Connection.close(conn, pre, res);
			return o;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// "insert into List(User_id, House_id, Rent_rented_station, End_time)
	// values(?,?,?,?)"
	public boolean Insert(Object obj) {

		Connection conn = JDBC_Connection.get_Connection();

		Class c = obj.getClass();
		Field[] field = c.getDeclaredFields();

		String str = new String("insert into " + c.getSimpleName() + "(");
		for (int i = 0; i < field.length; i++) {

			if (i == field.length - 1)
				str += field[i].getName() + ")values(";
			else
				str += field[i].getName() + ",";
		}
		for (int i = 0; i < field.length; i++) {
			if (i == field.length - 1)
				str += "?)";
			else
				str += "?,";
		}

		try {
			PreparedStatement pre = conn.prepareStatement(str);
			for (int i = 0; i < field.length; i++) {
				field[i].setAccessible(true);
				pre.setObject(i + 1, field[i].get(obj));
			}
			pre.executeUpdate();
			JDBC_Connection.close(conn, pre, null);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean Delete(Object obj) {
		Connection conn = JDBC_Connection.get_Connection();
		Class c = obj.getClass();
		Field[] field = c.getDeclaredFields();

		try {
			field[0].setAccessible(true);
			PreparedStatement pre = conn
					.prepareStatement("delete from " + c.getSimpleName()
							+ " where " + field[0].getName() + "=?");
			pre.setObject(1, field[0].get(obj));
			pre.executeUpdate();
			JDBC_Connection.close(conn, pre, null);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// update Rent_rented set Rent_rented_station=?,End_time=? where User_id=?
	// and House_id=?
	public boolean update(Object obj) {
		Connection conn = JDBC_Connection.get_Connection();
		Class c = obj.getClass();
		Field[] f = c.getDeclaredFields();

		String str = new String("update " + c.getName() + " set ");
		for (int i = 1; i < f.length; i++) {
			if (i == f.length - 1)
				str += f[i].getName() + "=? where " + f[0].getName() + "=?";
			else
				str += f[i].getName() + "=?, ";
		}

		try {

			PreparedStatement pre = conn.prepareStatement(str);
			for (int i = 0; i < f.length; i++) {
				f[i].setAccessible(true);
				if (i == 0)
					pre.setObject(f.length, f[i].get(obj));
				else
					pre.setObject(i, f[i].get(obj));
			}
			pre.executeUpdate();
			JDBC_Connection.close(conn, pre, null);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		/*
		 * JDBC j = new JDBC();
		 * 
		 * // List<Object> list = j.Select_All_Information(new Message());
		 * List<Message> list1 = j.Select_Information_From_Column(null, "精彩");
		 * // System.out.println("合金杀手是"+list1.size()); for (Message m : list1)
		 * { System.out.println(m.toString()); }
		 */
		StringBuffer str = new StringBuffer("  和幅度 ");
		System.out.println(str.append("123" + "456"));
	}
}
