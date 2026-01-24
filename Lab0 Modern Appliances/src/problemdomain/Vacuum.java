package problemdomain;

/**
* Represents a Vacuum object with item number, brand, quantity, wattage, color, price, grade, battery voltage.
* @author Sherry
* @version January 23, 2026
*/
public class Vacuum extends Appliance {
	
	private String grade;
	private int batteryVoltage;

	/**
	 * Creates a Vacuum object with item number, brand, quantity, wattage, color, price, grade, battery voltage.
	 * @param itemNum
	 * @param brand
	 * @param quantity
	 * @param wattage
	 * @param color
	 * @param price
	 * @param grade
	 * @param batteryVoltage
	 */
	public Vacuum(long itemNum, String brand, int quantity, int wattage, String color, double price, String grade, int batteryVoltage) {
		
		super(itemNum, brand, quantity, wattage, color, price);
		
		this.grade = grade;
		this.batteryVoltage = batteryVoltage;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nGrade: " + grade + 
				"\nBattery Voltage: " + batteryVoltage;
	}

	/**
	 * @return the batteryVoltage
	 */
	public int getBatteryVoltage() {
		return batteryVoltage;
	}

	/**
	 * @param batteryVoltage the batteryVoltage to set
	 */
	public void setBatteryVoltage(int batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
	
}
