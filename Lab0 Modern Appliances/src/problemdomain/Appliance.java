package problemdomain;

/**
 * Represents an Appliance object with item number, brand, quantity, wattage, color, price.
 * @author Sherry
 * @version January 23, 2026
 */
public abstract class Appliance {

	// attributes
	private long itemNum;
	private String brand;
	private int quantity;
	private int wattage;
	private String color;
	private double price;
	
	/**
	 * Create an appliance with item number, brand, quantity, wattage, color, price.
	 * @param itemNum
	 * @param brand
	 * @param quantity
	 * @param wattage
	 * @param color
	 * @param price
	 */
	public Appliance(long itemNum, String brand, int quantity, int wattage, String color, double price) {
		super();
		this.itemNum = itemNum;
		this.brand = brand;
		this.quantity = quantity;
		this.wattage = wattage;
		this.color = color;
		this.price = price;
	}

	/**
	 * @return the itemNum
	 */
	public long getItemNum() {
		return itemNum;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the wattage
	 */
	public int getWattage() {
		return wattage;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param itemNum the itemNum to set
	 */
	public void setItemNum(long itemNum) {
		this.itemNum = itemNum;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param wattage the wattage to set
	 */
	public void setWattage(int wattage) {
		this.wattage = wattage;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Create a method to decrement the quantity of an appliance when a customer purchases an appliance.
	 */
    public void decrementQuantity() {
        if (quantity > 0) 
        	quantity--;
    }

	@Override
	public String toString() {
		return "ItemNumber: " + itemNum + 
				"\nBrand: " + brand + 
				"\nQuantity: " + quantity +
				"\nWattage： " + wattage +
				"\nColor: " + color +
				"\nPrice: " + price;
	}
	
	
	
		
		
}
