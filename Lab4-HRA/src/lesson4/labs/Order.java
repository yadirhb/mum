package lesson4.labs;

public class Order {
	private int orderNo;
	private Date orderDate;
	private int orderAmount;

	public Order(int orderNo, int orderAmount, int month, int year) {
		this.orderDate = new Date(month, year);
		this.orderAmount = orderAmount;
		this.orderNo = orderNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

}
