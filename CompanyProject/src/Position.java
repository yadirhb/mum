
public class Position {
	private String title;
	
	private Employee employee;
	
	Position(String title) {
		this.title = title;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {return this.employee; }
	
	public double getEmployeeSalary() {
		return this.employee != null ? this.employee.getSalary() : 0.0;
	}
}
