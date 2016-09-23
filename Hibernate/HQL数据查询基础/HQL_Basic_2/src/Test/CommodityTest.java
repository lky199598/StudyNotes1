package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JavaBean.Commodity;
import JavaBean.Seller;
import Util.HibernateSessionFactory;

public class CommodityTest {

	private Session session;
	private Transaction ts;

	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getCurrentSession();
		ts = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		ts.commit();// 提交事务
		session.close();// 关闭会话
		HibernateSessionFactory.getSessionFactory().close(); // 关闭会话工厂
	}

	@Test
	public void save() {

		/*Seller s = new Seller();
		s.setAddress("黄海市");
		s.setBusiness("很大范围");
		s.setName("鞋子");
		s.setStar(5);
		s.setTel("15896489357");
		s.setWebsite("dkjfjfsk.sdi");

		Seller s1 = new Seller();
		s1.setAddress("黄第市");
		s1.setBusiness("市区附近");
		s1.setName("服装");
		s1.setStar(5);
		s1.setTel("15896489357");
		s1.setWebsite("dkjfjfsk.sdi");
		session.save(s);
		session.save(s1);*/
		
		Commodity c = new Commodity();
		c.setCategory("服装");
		c.setDescription("很好的服装");
		c.setName("裤子");
		c.setPrice((double) 60);
		c.setUnit("套");
		
		Seller s = (Seller) session.get(Seller.class, new Long(3));
		c.setSeller(s);
		session.save(c);
		
		
		/*Commodity c = new Commodity();
		c.setCategory("鞋子");
		c.setDescription("很好的鞋子");
		c.setName("跑鞋");
		c.setPrice((double) 60);
		c.setUnit("双");
		
		Seller seller = new Seller();
		seller.setAddress("是假市");
		seller.setBusiness("很大范围");
		seller.setName("小铮");
		seller.setStar(5);
		seller.setTel("15896489357");
		seller.setWebsite("dkjfjfsk.sdi");
		
		c.setSeller(seller);
		session.save(c);*/
	}

	@Test
	public void Query() {
		Query q = session.createQuery("from Commodity");	
		List<Commodity> list = q.list();	
		for(Commodity c:list)
			System.out.println(c+"\n"+c.getSeller()+"\n");
			
	}
}
