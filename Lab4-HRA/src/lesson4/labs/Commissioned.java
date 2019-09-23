package lesson4.labs;

import java.util.LinkedList;
import java.util.List;

public class Commissioned extends Employee {
	private List<Order> orders;
	private double commision;
	private double baseSalary;

	public Commissioned(int empId, double commision, double baseSalary, List<Order> orders) {
		super(empId);
		this.orders = orders == null ? new LinkedList<Order>() : orders;
		this.commision = commision;
		this.baseSalary = baseSalary;
	}

	@Override
	double caclGrossPay(int month, int year) {
		double commissions = 0;
		for(Order o : this.orders) {
			Date date = o.getOrderDate();
			if(date.getMonth() == month && date.getYear() == year) {
				commissions += Utils.getPercent(this.commision, o.getOrderAmount());
			}
		}
		return this.baseSalary + commissions;
	}

}
