package JavaBean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 商家信息持久化类
 * 
 * @author Administrator
 * 
 */
public class Seller{
	private Long seller_id;// 主键
	private String name;// 名称
	private String tel;// 电话
	private String address;// 地址
	private String website;// 网站
	private Integer star;// 星级
	private String business;// 经营范围
	//private Set<Commodity> c = new HashSet<Commodity>();
	
		public Seller(){
		
	}
	
	public Seller(String name,String tel,String address){
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

/*	public Set<Commodity> getC() {
		return c;
	}

	public void setC(Set<Commodity> c) {
		this.c = c;
	}*/

	

	public String getName() {
		return name;
	}

	public Long getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String toString() {
		return "主键:" + this.getSeller_id() + "    |    名称:" + this.getName()
				+ "    |     电话:" + this.getTel() + "    |   星级 :"
				+ this.getStar() + "    |   网址:" + this.getWebsite()
				+ "    |    地址:" + this.getAddress() + "    |   经营范围:"
				+ this.getBusiness();
	}
}
