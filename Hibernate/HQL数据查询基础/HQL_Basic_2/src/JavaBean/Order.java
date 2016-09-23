package JavaBean;

import java.io.Serializable;
import java.util.Date;

/**
 * 订 单信息持久化类
 * 
 * @author Administrator
 * 
 */
public class Order implements Serializable{
	private Integer order_id;// 主键
	private Date tradeDate;// 交易日期
	private String status;// 订单状态
	private Double amount;// 订单金额
	
	private Customer customer;// 客户
   

	public Order() {
	}


	public Integer getOrder_id() {
		return order_id;
	}




	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}




	public Date getTradeDate() {
		return tradeDate;
	}




	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Double getAmount() {
		return amount;
	}




	public void setAmount(Double amount) {
		this.amount = amount;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	public String toString() {
		return "订单主键:" + this.order_id + "    |    客户:"
				+ this.getCustomer().getName() + "    |     交易日期:"
				+ this.getTradeDate() + "    |   订单状态 :" + this.getStatus()
				+ "    |   订单金额:" + this.getAmount();
	}

	public static void main(String[] args) {
		Order o = new Order();
		o.setAmount((double) 80);
	}
}
