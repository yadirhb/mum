package lesson3.labs.prob2;

import java.util.LinkedList;
import java.util.List;

public class Landlord {
	private List<Building> buildings;
	
	Landlord(List<Building> builds) throws Exception{
		if(builds == null) throw new NullPointerException("No allowed a null list of appartments");
		else if(builds.isEmpty()) throw new Exception("Not allowed empty lists. Must contain at least one appartment per building");
		this.buildings = builds;
	}
	
	public double getRentProfit() {
		double result = 0;
		
		for(Building b : this.buildings) {
			result += b.getRentProfit();
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		Appartment a1 = new Appartment(1, 450.0);
		Appartment a2 = new Appartment(2, 500);
		List<Appartment> b1Appartments = new LinkedList<>();
		b1Appartments.add(a1);
		b1Appartments.add(a2);
		
		Building b1 = new Building( b1Appartments, 200);
		
		Appartment a21 = new Appartment(1, 450.0);
		Appartment a22 = new Appartment(2, 500);
		List<Appartment> b2Appartments = new LinkedList<>();
		b2Appartments.add(a21);
		b2Appartments.add(a22);
		
		Building b2 = new Building( b2Appartments, 200);
		
		List<Building> buildings = new LinkedList<>();
		buildings.add(b1);
		buildings.add(b2);
		Landlord landLord = new Landlord(buildings);
		
		System.out.println("Profits: " + landLord.getRentProfit());
	}
}
