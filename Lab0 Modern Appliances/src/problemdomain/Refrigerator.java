package problemdomain;

/**
* Represents a Refrigerator object with item number, brand, quantity, wattage, color, price, number of doors, height, width.
* @author Sherry
* @version January 23, 2026
*/
public class Refrigerator extends Appliance {
	
	private int numOfDoors;
	private int height;
	private int width;
	
	/**
	 * Create a Refrigerator object with item number, brand, quantity, wattage, color, price, number of doors, height, width.
	 * @param itemNum
	 * @param brand
	 * @param quantity
	 * @param wattage
	 * @param color
	 * @param price
	 * @param numOfDoors
	 * @param height
	 * @param width
	 */
	public Refrigerator(long itemNum, String brand, int quantity, int wattage, String color, double price, int numOfDoors, int height, int width) {
		
		
		super(itemNum, brand, quantity, wattage, color, price);
		this.numOfDoors = numOfDoors;
		this.height = height;
		this.width = width;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nNumber of Doors: " + numOfDoors + 
				"\nHeight: " + height +
				"\nWidth: " + width;
	}

	/**
	 * @return the numOfdoors
	 */
	public int getNumOfDoors() {
		return numOfDoors;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param numOfDoors the numOfDoors to set
	 */
	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}
	
	

	

}
