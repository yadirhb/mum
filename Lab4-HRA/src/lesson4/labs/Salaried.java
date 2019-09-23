package lesson4.labs;

public class Salaried extends Employee {
	
	private double salary;

	public Salaried(int empId, double salary) {
		super(empId);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	double caclGrossPay(int month, int year) {
		return this.salary;
	}

}
