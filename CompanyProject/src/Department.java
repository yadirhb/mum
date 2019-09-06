import java.util.LinkedList;
import java.util.List;

public class Department {
	private String name;
	private String location;
	private List<Position> positions;
	
	Department(String name, String location, List<Position> positions){
		this.name = name;
		this.location = location;
		
		this.positions = positions != null ? positions : new LinkedList<Position>();
	}
	
	
	public void addPosition(Position position) {
		positions.add(position);
	}
	
	public double getDepartmentSalaryTotal() {
	
		double total = 0.0;
		
		for(Position p : positions) {
			total += p.getEmployeeSalary();
		}
		
		return total;
	}
}
