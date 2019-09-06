package lesson3.labs.prob2;

import java.util.List;

public class Appartment {
	private String name;
	private List<RentRecord> records;
	
	Appartment(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<RentRecord> getRecords() {
		return records;
	}
	
	
}
