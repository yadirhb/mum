package lesson3.labs.prob4;

public abstract class Property {
	private Address address;
	
	protected Property(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	abstract double computeRent();
}
