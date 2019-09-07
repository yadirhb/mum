package lesson3.labs.prob2;

import java.util.List;

public class Building {
	private List<Appartment> apparts;
	private double maintainanceCosts;
	
	Building(List<Appartment> apparts, double mantainanceCosts) throws Exception{
		if(apparts == null) throw new NullPointerException("No allowed a null list of appartments");
		else if(apparts.isEmpty()) throw new Exception("Not allowed empty lists. Must contain at least one appartment per building");
		this.apparts = apparts;
		
		this.maintainanceCosts = mantainanceCosts;
	}
	
	public double getRentProfit() {
		double result = 0;
		
		for(Appartment a : this.apparts) {
			result += a.getRent();
		}
		
		return result - this.maintainanceCosts;
	}
}
