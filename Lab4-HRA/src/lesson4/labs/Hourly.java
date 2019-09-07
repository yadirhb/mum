package lesson4.labs;

public class Hourly extends Employee {

	private double hourlyWage;
	private double hoursPerWeek;

	public Hourly(int empId, double hourlyWage, double hoursPerWeek) {
		super(empId);

		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}

	@Override
	double caclGrossPay(int month, int year) {
		return hourlyWage * hoursPerWeek * 4;
	}
}
