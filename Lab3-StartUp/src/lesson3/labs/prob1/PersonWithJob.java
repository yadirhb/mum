package lesson3.labs.prob1;

public class PersonWithJob implements Person {
	
	private double salary;
	private Person person;
	
	public String getName() {
		return this.person.getName();
	}
	
	public double getSalary() {
		return salary;
	}
	
	PersonWithJob(Person person, double s) {
		if(person == null) throw new NullPointerException("The person instance cannot be null");
		this.person = person;
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPerson;
		
		boolean isEqual = this.person.equals(p.person) && this.getSalary() == p.getSalary();
		return isEqual;
	}
	
	public static void main(String[] args) {
		Person p2 = new CommonPerson("Joe");
		Person p1 = new PersonWithJob(p2, 30000);
	
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}


}
