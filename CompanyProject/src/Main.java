import java.util.LinkedList;
import java.util.List;

public class Main {
	static void main(String[] args) {
		Employee e1 = new Employee(0, "Peter", "01/02/1952", 101010101, 140000);
		Employee e2 = new Employee(1, "Maria", "01/02/1952", 561651013, 85000);
		Employee e3 = new Employee(2, "John Doe", "01/02/1952", 983130310, 94000);
		
		Position p1 = new Position("a");
		p1.setEmployee(e1);
		
		Position p2 = new Position("b");
		p2.setEmployee(e2);
		
		Position p3 = new Position("c");
		p3.setEmployee(e3);
		
		List<Position> positions1 = new LinkedList<Position>();
		positions1.add(p1);
		positions1.add(p2);
		Department d1 = new Department("one", "Downtown", positions1);
		
		List<Position> positions2 = new LinkedList<Position>();
		positions2.add(p3);
		Department d2 = new Department("two", "East", positions2);
		
		List<Department> departments = new LinkedList<Department>();
		departments.add(d1);
		departments.add(d2);
		
		Company c = new Company("Apple", departments);
		
		System.out.println("Salaries: " + c.getCompanySalaryTotal());
		
	}
}
