package problemdomain;



/**
* Represents a Microwave object with item number, brand, quantity, wattage, color, price, capacity, room type.
* @author Sherry
* @version January 23, 2026
*/
public class Microwave extends Appliance {
	
	private double capacity;
	private String roomType;
	
	/**
	 * Creates a Microwave object with item number, brand, quantity, wattage, color, price, capacity, room type.
	 * @param itemNum
	 * @param brand
	 * @param quantity
	 * @param wattage
	 * @param color
	 * @param price
	 * @param capacity
	 * @param roomType
	 */
	public Microwave(long itemNum, String brand, int quantity, int wattage, String color, double price, double capacity, String roomType) {
		
		super(itemNum, brand, quantity, wattage, color, price);
		
		this.capacity = capacity;
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nCapacity: " + capacity + 
				"\nRoom Type: " + roomType; 
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the capacity
	 */
	public double getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	
	
	
}
