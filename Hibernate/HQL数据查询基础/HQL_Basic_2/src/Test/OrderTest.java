package Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JavaBean.Customer;
import JavaBean.Order;
import JavaBean.Seller;
import Util.HibernateSessionFactory;

public class OrderTest {

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
		Order order = new Order();
		
		Order o = new Order();
		o.setOrder_id(88);
		o.setAmount((double) 80);
		o.setStatus("交易中");
		o.setTradeDate(new Date());
		
		Customer customer = new Customer();
		customer.setAddress("梧州市");
		customer.setAge(18);
		customer.setBirthday(new Date(1999, 1,1));
		customer.setDescription("这个人很好哒");
		customer.setEmail("892173291@qq.com");
		customer.setName("肥哆哆");
		customer.setSex("男");
customer.setTel("8948549509");

		o.setCustomer(customer);
		session.save(customer);
		session.save(o);
	}


}
