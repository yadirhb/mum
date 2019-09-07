package lesson3.labs.prob2;

public class RentRecord {
	private double amount;
	private String date;
	
	RentRecord(double amount, String date){
		this.amount = amount;
		this.date = date;
	}
	
	public double getAmount() {
		return amount;
	}
	public String getDate() {
		return date;
	}
	
}
