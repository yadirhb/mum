package lesson3.labs.prob3;

public class Circle {
	private double radius;
	
	Circle(double radius){
		this.radius = radius;
	}
	
	public double computeArea() {
		return 3.14 * radius * radius;
	}
}
