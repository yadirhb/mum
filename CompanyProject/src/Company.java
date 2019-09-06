import java.util.LinkedList;
import java.util.List;

public class Company {
	private String name;
	private List<Department> departments;

	Company(String name, List<Department> departments) {
		this.name = name;
		this.departments = new LinkedList<Department>();
	}

	public void addDepartment(Department department) {
		this.departments.add(department);
	}

	public double getCompanySalaryTotal() {
		double total = 0.0;
		for(Department d : this.departments) {
			total += d.getDepartmentSalaryTotal();
		}
		return total;
	}
}
