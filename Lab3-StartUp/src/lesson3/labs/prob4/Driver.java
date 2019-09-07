package lesson3.labs.prob4;

public class Driver {

	public static void main(String[] args) {

		Property[] objects = { new House(new Address("IL","Chicago", "1000 N Main St", "123A"), 9000), new Condo(new Address("IA", "Fairfield", "1000 N 4th S", "23"), 2), new Trailer(new Address("IA", "Fairfield", "1000 N 4th S", "37")) };
		double totalRent = Admin.computeTotalRent(objects);
		System.out.println(totalRent);
		
		// List all properties
		for(Property p : Admin.getPropertysByCity(objects, "Fairfield")) {
			Address address = p.getAddress();
			System.out.println("Property: " + address.getStreet() + ", " + address.getNumber() );
		}
	}
}
