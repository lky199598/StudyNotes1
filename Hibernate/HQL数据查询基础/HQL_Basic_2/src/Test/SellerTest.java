package Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JavaBean.Commodity;
import JavaBean.Customer;
import JavaBean.Seller;
import Util.HibernateSessionFactory;

public class SellerTest {

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

		Seller s = new Seller();
		s.setAddress("黄海市");
		s.setBusiness("很大范围");
		s.setName("小天");
		s.setStar(5);
		s.setTel("15896489357");
		s.setWebsite("dkjfjfsk.sdi");

		Seller s1 = new Seller();
		s1.setAddress("缎市区");
		s1.setBusiness("市区附近");
		s1.setName("小丽");
		s1.setStar(5);
		s1.setTel("15896489357");
		s1.setWebsite("dkjfjfsk.sdi");
		session.save(s);
		session.save(s1);
	}

	@Test
	public void QueryTest() {
		Query q = session.createQuery("from Seller");
		List<Seller> list = q.list();
		for (Seller s : list)
			System.out.println(s);
	}

	@Test
	public void Select_Object() {
		Query q = session.createQuery("select s.name,s.tel from Seller s");
		List<Object[]> list = q.list();
		for (Object[] obj : list) {
			System.out.println("name: " + obj[0] + "\ttel: " + obj[1]);
		}
	}

	@Test
	public void Select_Object_1() {
		Query q = session.createQuery("select s.name from Seller s");
		List<Object> list = q.list();
		for (Object obj : list) {
			System.out.println("name: " + obj);
		}
	}

	@Test
	public void Select_List() {
		Query q = session
				.createQuery("select new list(s.name, s.tel, s.address) from Seller s");

		List<List> list = q.list();
		for (List l : list) {
			System.out.print("name: " + l.get(0));
			System.out.print("tel: " + l.get(1));
			System.out.print("address: " + l.get(2)+"\n\n");
		}
	}
	
	@Test
	public void Select_Map() {
		Query q = session
				.createQuery("select new map(s.name, s.tel, s.address) from Seller s");

		List<Map> list = q.list();
		for (Map m : list) {
			System.out.print("name: " + m.get("0"));
			System.out.print("  tel: " + m.get("1"));
			System.out.print("  address: " + m.get("2")+"\n\n");
		}
	}
	
	@Test
	public void Select_Seller() {
		Query q = session
				.createQuery("select new Seller(s.name, s.tel, s.address) from Seller s");

		List<Seller> list = q.list();
		for (Seller s : list) {
			System.out.print("name: " + s.getName());
			System.out.print("  tel: " + s.getTel());
			System.out.print("  address: " + s.getAddress()+"\n\n");
		}
	}
	
	
	@Test
	public void Distinct_Test()
	{
		Query q = session.createQuery("select distinct c.sex from Customer c");
		List<Object> list = q.list();
		for(Object obj:list)
			System.out.println(obj);
	}
	
	@Test
	public void Test_Where()
	{
		Query q = session.createQuery("from Customer c where c.description is not null");
		List<Customer> list = q.list();
		for(Customer c:list)
			System.out.println(c);
	}
	@Test
	public void Test_between()
	{
		Query q = session.createQuery("select c.age from Customer c where c.age not between 20 and 50");
		List<Object> list = q.list();
		for(Object obj:list)
			System.out.println(obj);
	}
	
	@Test
	public void Test_like()
	{
		Query q = session.createQuery("select c.name from Customer c where c.name like '肥_'");
		List<Object> list = q.list();
		for(Object obj:list)
			System.out.println(obj);
	}
	
	@Test
	public void Test_like_1()
	{
		Query q = session.createQuery("select c.address from Customer c where c.address like '%梧州%'");
		List<Object> list = q.list();
		for(Object obj:list)
			System.out.println(obj);
	}
	@Test
	public void Test_like_2()
	{
		Query q = session.createQuery("select c.age,c.address from Customer c where c.age between 20 and 50 and c.address like '%梧州%'");
		List<Object[]> list = q.list();
		for(Object[] obj:list)
			System.out.println(obj[0]+"\t"+obj[1]);
	}
	
	@Test
	public void Test_like_3()
	{
		Query q = session.createQuery("select c.age,c.address from Customer c where c.age between 20 and 50 or c.address like '%梧州%'");
		List<Object[]> list = q.list();
		for(Object[] obj:list)
			System.out.println(obj[0]+"\t"+obj[1]);
	}
	
	@Test
	public void UniqueResult()
	{
		Query q = session.createQuery("from Customer c where c.name='肥'");
		Customer c = (Customer) q.uniqueResult();
		System.out.println(c);		
	}
	
	@Test
	public void Test_mul()
	{
		Query q = session.createQuery("from Commodity c where c.price*5>360");
		List<Commodity> list = q.list();
		
		for(Commodity c:list)
		System.out.println(c);		
	}
	
	@Test
	public void Test_in()
	{
		//年龄20和50
		Query q = session.createQuery("from Customer c where c.age in (20,50)");
		List<Customer> list = q.list();
		
		for(Customer c:list)
		System.out.print(c.getAge()+"\t");		
	}
	@Test
	public void Test_in_1()
	{
		//年龄20和50
		Query q = session.createQuery("from Customer c where c.age not in (20,50)");
		List<Customer> list = q.list();
		
		for(Customer c:list)
		System.out.print(c.getAge()+"\t");		
	}
	
	@Test
	public void Test_OrderBy()
	{
		//from Customer c order by c.age asc
		Query q = session.createQuery("from Customer c order by c.age desc");
		List<Customer> list = q.list();
		
		for(Customer c:list)
		System.out.print(c.getAge()+"\t");		
	}
	
	@Test
	public void Test_OrderBy_1()
	{
		//from Customer c order by c.age asc
		Query q = session.createQuery("from Commodity c order by c.seller.seller_id asc,c.price desc, c.name asc");
		List<Commodity> list = q.list();
		
		for(Commodity c:list)
		System.out.println(c.getSeller().getSeller_id()+"\t"+c.getPrice()+"\t"+c.getName());		
	}
	
	
	@Test
	public void Test_All()
	{
		String str = "select c.seller.name,c.seller.tel, c.name, c.price  from Commodity c where c.name like '%衬衫%' and c.price<100 order by c.seller.seller_id desc,c.price asc,c.name asc";
	    Query q = session.createQuery(str);
	    List<Object[]> list = q.list();
	    
	    for(Object[] obj:list)
	    {
	    	System.out.println(obj[0]+"\t"+obj[1]+"\t"+obj[2]+"\t"+obj[3]);
	    System.out.println();
	    }
	}
	
	@Test
	public void Test_Date()
	{
		String str = "select c.birthday from Customer where c.birthday between new Date(1995-1900, 2-1, 1) and new Date(2016-1900,2-1,1)";
	    Query q = session.createQuery(str);
	    List<Object> list = q.list();
	    
	    for(Object obj:list)
	    {
	    	System.out.println(obj);
	    System.out.println();
	    }
	}
}
