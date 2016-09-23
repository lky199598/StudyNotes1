package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.Items;

public class Cart {

	private HashMap<Items, Integer> goods;
	
	public Cart()	{
		goods = new HashMap<Items, Integer>();
	}
	
	
	public HashMap<Items, Integer> getGoods()
	{
		return goods;
	}
	
	public double TotalPrice()
	{
		double sum=0.0;
		for(Entry<Items, Integer> entry : goods.entrySet())
			sum+=( entry.getKey().getPrice() )*( entry.getValue() );
		return sum;
	}
	
	public void AddInCart(Items item, int number)
	{
		if(goods.containsKey(item))
			goods.put(item, goods.get(item)+number);
		else
			goods.put(item, number);
		
		TotalPrice();//重新计算购物车的总金额
	}
	
	public void RemoveFromCart(Items item)
	{
		goods.remove(item);
		TotalPrice();
	}
	
	public static void main(String[] args)
	{
		Items i1 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
		Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
		Items i3 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
		
		Cart c = new Cart();
		
		c.AddInCart(i1, 1);
		c.AddInCart(i2, 2);
		c.AddInCart(i3, 3);
		
		for(Entry<Items, Integer> entry : c.getGoods().entrySet())
			System.out.println(entry.getKey()+",  商品数量为: "+entry.getValue());
	}
}
