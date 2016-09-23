package JavaBean;

/**
 * 商品信息持久化类
 * 
 * @author Administrator
 * 
 */
public class Commodity  {
	private Long commodity_id;// 主键
	private String name;// 名称
	private Double price;// 价格
	private String unit;// 单位
	private String category;// 类别
	private String description;// 简介
	private Seller seller;// 商家
    
	public Commodity() {
	
	}

	public Long getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(Long commodity_id) {
		this.commodity_id = commodity_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String toString() {
		return "主键:" + this.getCommodity_id() + "    |   名称:" + this.getName()
				+ "    |     价格:" + this.getPrice() + "    |   单位 :"
				+ this.getUnit() + "    |   分类:" + this.getCategory()
				+ "    |   经营商家:" + this.getSeller().getName() + "    |   简介:"
				+ this.getDescription();
	}

}
