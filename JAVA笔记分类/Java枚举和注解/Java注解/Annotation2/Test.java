package Annotation2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.tracing.dtrace.ArgsAttributes;

public class Test {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setUserID("aaa");

		Student s2 = new Student();
		s2.setUserID("bbb");
		s2.setAge(18);
		s2.setSex(true);

		Student s3 = new Student();
		s3.setUserID("ccc");
		s3.setSex(true);
		s3.setScore(98.8);
		s3.setEmail("1145748@qq.com,89605780@qq.com");
		s3.setAge(20);
	    s3.setCla('男');

		System.out.println(Query(s1) + "\n");
		System.out.println(Query(s2) + "\n");
		System.out.println(Query(s3) + "\n");
	}

	// select * from student 1=1 and id = 10 and name = 'baoyou'
	// select * from student 1=1 and email in (
	// '1223716098@qq.com','curiousby@163.com' )

	private static String Query(Object obj) {
		Class c = obj.getClass();

		boolean IsExist = c.isAnnotationPresent(Table.class);
		if (!IsExist)
			return null;

		Table t = (Table) c.getAnnotation(Table.class);
		String TableName = t.value();

		StringBuffer sb = new StringBuffer();
		sb.append("select *from ").append(TableName).append(" Where ");

		Field[] f = c.getDeclaredFields();

		for (int i = 0; i < f.length; i++) {
			boolean FieldIsExist = f[i].isAnnotationPresent(Column.class);
			
			if (FieldIsExist) {
				Column col = f[i].getAnnotation(Column.class);
				String ColumnName = col.value();
				// 得到成员变量的类型的类类型
				Class ColumnType = f[i].getType();

				String MethodName = null;
				if (ColumnType.getName().equals("boolean"))
					MethodName = "is"
							+ ColumnName.substring(0, 1).toUpperCase()
							+ ColumnName.substring(1);
				else
					MethodName = "get"
							+ ColumnName.substring(0, 1).toUpperCase()
							+ ColumnName.substring(1);

				try {
					Method m = c.getMethod(MethodName);
					Object ColumnValue = m.invoke(obj);

					if (ColumnValue == null)
						continue;

					else if (ColumnValue instanceof Character
							&& (char) ColumnValue == '\0')
						continue;

					else if ((ColumnValue instanceof Byte && (Byte) ColumnValue == 0)
							|| (ColumnValue instanceof Short && (Short) ColumnValue == 0)
							|| (ColumnValue instanceof Integer && (Integer) ColumnValue == 0)
							|| (ColumnValue instanceof Long && (Long) ColumnValue == 0)
							|| (ColumnValue instanceof Float && (Float) ColumnValue == 0)
							|| (ColumnValue instanceof Double && (Double) ColumnValue == 0))
						continue;

					if (i == 0)
						sb.append(ColumnName + "=");
					else
						sb.append(" and " + ColumnName + "=");

					if (ColumnValue instanceof String) {
						if (((String) ColumnValue).contains(",")) {
							String[] str = ((String) ColumnValue).split(",");
							sb.append(" in ( ");
							for (String s : str)
								sb.append("'").append(s).append("',");
							sb.deleteCharAt(sb.length() - 1);
							sb.append(" )");
						} else
							sb.append("'").append(ColumnValue).append("'");
					}

					else
						sb.append(ColumnValue);
				}

				catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return sb.toString();
	}

}
