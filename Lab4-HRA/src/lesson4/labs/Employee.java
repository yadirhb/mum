package lesson4.labs;

public abstract class Employee {
	
	protected int empId;

	public Employee(int empId) {
		this.empId = empId;
	}
	
	public void print() {
		System.out.println("Employee Id: " + this.empId);
	}
	
	public Paycheck calcCompensation(int month, int year) {
		double grossPay = this.caclGrossPay(month, year);
		
		return new Paycheck(grossPay);
	}
	
	abstract double caclGrossPay(int month, int year);
}
