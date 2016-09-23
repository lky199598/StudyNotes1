package Test;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import JavaBean.Student;

public class StudentTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before//测试类中要有注解
	public void init()
	{
		//创建配置对象
		Configuration config = new Configuration().configure();
		
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		
		//创建会话工厂对象
		 sessionFactory= config.buildSessionFactory(serviceRegistry);
		
		//会话对象
		session = sessionFactory.openSession();
		
		//开启事务
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory()
	{	
		session.flush();
		transaction.commit();//提交事务
		
		session.close();//关闭会话
		
		sessionFactory.close();//关闭会话工厂
	}
	
/*	@Test
	public void Test_Save_Student()
	{
		Student stu = new Student();
		stu.setName("手机号");
		stu.setDate(new Date());
		session.save(stu);
	}*/
	
	
	@Test
	public void Write_Blob() throws Exception
	{
		Student stu = new Student();
		//stu.setId(6);
		stu.setDate(new Date());
		stu.setName("丝素");
		
		
		File f = new File("D:/我的图片/吹笛.jpg");
		
  	     	InputStream is = new FileInputStream(f);
		  
			Blob image = Hibernate.getLobCreator(session).createBlob(is, is.available());
			//is.available 输入流可用的字节长度
		
			stu.setPicture(image);
		
			session.save(stu);
			
	}
	
	@Test
	public void Read_Blob() throws Exception
	{
		Student stu = (Student) session.get(Student.class, 2);
			
		//获得Blob对象
	    Blob image = stu.getPicture();
	    //获得照片的输入流
	    InputStream is = image.getBinaryStream();
	    byte[] b = new byte[is.available()];
	    is.read(b);
	    
	    File f = new File("D:/dest.jpg");
		OutputStream os = new FileOutputStream(f);
		os.write(b);
	
		is.close();
		os.close();
	}
}





