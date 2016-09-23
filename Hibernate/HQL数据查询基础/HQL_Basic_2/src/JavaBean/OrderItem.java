package JavaBean;


/**
 * 订单明细信息持久化类
 * 
 * @author Administrator
 * 
 */
public class OrderItem  {
	private Long orderitem_id;// 主键
	private Double discount;// 折扣
	private Double actPrice;// 价格
	private Double amount;// 数量
	//private Integer position;
	
	private Order order;
	private Commodity commodity;// 订单商品
	
   
	public OrderItem() {

	}

	public Long getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(Long orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	/*public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}*/

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getActPrice() {
		return actPrice;
	}

	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String toString() {
		return "订单明细主键:" + this.getOrderitem_id() + "    |    商品:"
				+ this.getCommodity().getName() + "    |     折扣:"
				+ this.getDiscount() + "    |   价格 :" + this.getActPrice()
				+ "    |   数量:" + this.getAmount();
	}

}
