package entity;

public class Items {
	private int id;
	private String name;
	private String city;
	private int price;
	private int number;// 库存
	private String picture;

	public Items(){}
	
	public Items(int id,String name,String city,int price,int number,String picture)
	{
		this.id = id;
		this.name = name;
		this.city = city;
		this.picture = picture;
		this.price = price;
		this.number = number;
		this.picture=picture;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public boolean equals(Object obj)
	{
		if(obj==null)
			return false;
		
		if(obj.getClass() == this.getClass())
		{
			Items item  = (Items)obj;
			if(this.getId() == item.getId() && this.getName().equals(item.getName()))
				return true;
			return false;
		}		
		return false;
	}

	public int hashCode()
	{
		return (this.getId()+this.getName()).hashCode();
	}

	
	public String toString()
	{
		return "商品编号为: "+this.getId()+",  商品名称: "+this.getName();
	}
	
	public static void main(String[] args)
	{
		Items i1 = new Items();
		Items i2 = new Items();
		
		i1.setId(111);i1.setName("aaa");		
		i2.setId(111); i2.setName("aaa");	
	}
}
