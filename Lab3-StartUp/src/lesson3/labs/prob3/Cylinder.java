package lesson3.labs.prob3;

public class Cylinder {
	private Circle base;
	private double height;
	
	Cylinder(Circle base, double height){
		if(base == null) throw new NullPointerException("Base cannot be null.");
		this.base = base;
		this.height = height;
	}
	
	public double cumputeVolume() {
		return this.base.computeArea() * this.height;
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle(2);
		
		Cylinder cylinder = new Cylinder(circle, 2);
		
		System.out.println("Circle area is: " + circle.computeArea());
		System.out.println("Cylinder volume is: " + cylinder.cumputeVolume());
	}
}
