
public class Employee {
	private int id;
	private String name;
	private String birthDate;
	private int ssn;
	private double salary;
	
	Employee(int id, String name, String birthDate, int ssn, double salary){
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
}	
