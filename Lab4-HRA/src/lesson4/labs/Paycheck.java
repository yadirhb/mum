/**
 * 
 */
package lesson4.labs;

/**
 * @author 610545
 *
 */
final class Paycheck {
	
	private double grossPay;
	
	private double fica = 0.0;
	private double stateTax = 0.0;
	private double localTax = 0.0;
	private double medicare = 0.0;
	private double ssTax = 0;

	/**
	 * 
	 */
	public Paycheck(double grossPay) {
		this.grossPay = grossPay;
		
		this.fica = Utils.getPercent(23, grossPay);
		this.stateTax = Utils.getPercent(5, grossPay);
		this.localTax = Utils.getPercent(1, grossPay);
		this.medicare = Utils.getPercent(3, grossPay);
		this.ssTax = Utils.getPercent(7.5, grossPay);
	}
	
	public void print() {
		System.out.println("FICA is " + fica + "%");
		System.out.println("State tax is " + stateTax + "%");
		System.out.println("Local tax is " + localTax + "%");
		System.out.println("Medicare is " + medicare + "%");
		System.out.println("Social Security is " + ssTax + "%");
	}
	
	public double getNetPay() {
		double taxes = this.fica + this.stateTax + this.localTax + this.medicare + this.ssTax;		
		return grossPay - taxes;
	}
}
