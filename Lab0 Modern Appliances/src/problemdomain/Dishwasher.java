package problemdomain;

/**
 * Represents a dishwasher object with item number, brand, quantity, wattage, color, price, feature, and sound rating.
 * @author Sherry
 * @version January 23, 2026
 */
public class Dishwasher extends Appliance {
	
	private String feature;
	private String soundRating;

	/**
	 * Creates a dishwasher object with item number, brand, quantity, wattage, color, price, feature, and sound rating.
	 * @param itemNum
	 * @param brand
	 * @param quantity
	 * @param wattage
	 * @param color
	 * @param price
	 * @param feature
	 * @param soundRating
	 */
	public Dishwasher(long itemNum, String brand, int quantity, int wattage, String color, double price, String feature, String soundRating) {
		
		super(itemNum, brand, quantity, wattage, color, price);
		
		this.feature = feature;
		this.soundRating = soundRating;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\nFeature: " + feature + 
				"\nSound Rating: " + soundRating;
	}

	/**
	 * @return the soundRating
	 */
	public String getSoundRating() {
		return soundRating;
	}

	/**
	 * @param soundRating the soundRating to set
	 */
	public void setSoundRating(String soundRating) {
		this.soundRating = soundRating;
	}

	/**
	 * @return the feature
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	
}
