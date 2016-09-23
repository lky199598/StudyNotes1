package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
     private static SessionFactory sessionFactory;
     private static Session session;
     
     //静态代码块进行初始化
     static{
    	 //创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
    	 Configuration config = new Configuration().configure();
    	 StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
    	 
    	 StandardServiceRegistry ssr = ssrb.build(); 
    	 sessionFactory =  config.buildSessionFactory(ssr);  
    	      	  
     }
	
     public static SessionFactory getSessionFactory()
     {
    	 return sessionFactory;
     }
     
     public static Session getSession()
     {
    	 session = sessionFactory.openSession();
    	 return session;
     }
     
     public static void closeSession(Session session)
     {
    	 if(session != null)
    		 session.close();
     }
}
