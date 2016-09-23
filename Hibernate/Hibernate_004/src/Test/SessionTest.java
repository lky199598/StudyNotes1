package Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import JavaBean.Student;

public class SessionTest {

	@Test
	public void OpenSession() {
		// 创建配置对象
		Configuration config = new Configuration().configure();

		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// 创建会话工厂对象
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);

		// 会话对象
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		System.out.println(session1 == session2);

		/*
		 * if(session != null)
		 * System.out.println("openSession(): Session创建成功！\n"); else
		 * System.out.println("openSession(): Session创建失败！\n");
		 */
	}

	@Test
	public void GetCurrentSession() {
		// 创建配置对象
		Configuration config = new Configuration().configure();

		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// 创建会话工厂对象
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);

		// 会话对象
		Session session1 = sessionFactory.getCurrentSession();
		Session session2 = sessionFactory.getCurrentSession();
		System.out.println(session1 == session2);

		/*
		 * if(session != null)
		 * System.out.println("getCurrentSession(): Session创建成功！\n"); else
		 * System.out.println("getCurrentSession(): Session创建失败！\n");
		 */

	}

	// openSession每次创建新的session对象，getCurrentSession使用现有的session对象
	@Test
	public void Save_Student_OpenSession() {
		// 创建配置对象
		Configuration config = new Configuration().configure();

		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// 创建会话工厂对象
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);

		// 会话对象1
		Session session1 = sessionFactory.getCurrentSession();

		// 开启事务
		Transaction transaction = session1.beginTransaction();

		// 生成一个学生对象
		//Student stu = new Student("88", new Date());
		session1.doWork(new Work() {

			@Override
			public void execute(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("Connection hashCode: " + arg0.hashCode());
			}
		});

		//session1.save(stu);
		// session1.close();
		// 提交事务
		transaction.commit();

		// 会话对象2
		Session session2 = sessionFactory.openSession();

		// 开启事务
		transaction = session2.beginTransaction();

		// 生成一个学生对象
		//stu = new Student("666", new Date());
		session2.doWork(new Work() {

			@Override
			public void execute(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("Connection hashCode: " + arg0.hashCode());
			}
		});

		session2.save(stu);
		transaction.commit();
	}

	// openSession每次创建新的session对象，getCurrentSession使用现有的session对象
	@Test
	public void Save_Student_GetCurrentSession() {
		// 创建配置对象
		Configuration config = new Configuration().configure();

		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		// 创建会话工厂对象
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);

		// 会话对象1
		Session session1 = sessionFactory.getCurrentSession();

		// 开启事务
		Transaction transaction = session1.beginTransaction();

		// 生成一个学生对象
	//	Student stu = new Student("8", new Date());
		session1.doWork(new Work() {

			@Override
			public void execute(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("Connection hashCode: " + arg0.hashCode());
			}
		});

		session1.save(stu);
		// session1.close();
		// 提交事务
		transaction.commit();

		// 会话对象2
		Session session2 = sessionFactory.getCurrentSession();
		// 开启事务
		transaction = session2.beginTransaction();
		// 生成一个学生对象
		//stu = new Student("6", new Date());
		session2.doWork(new Work() {

			@Override
			public void execute(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("Connection hashCode: " + arg0.hashCode());
			}
		});

		//session2.save(stu);
		transaction.commit();
	}

}
