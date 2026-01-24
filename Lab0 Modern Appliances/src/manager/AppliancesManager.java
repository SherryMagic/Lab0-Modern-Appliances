package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
//import java.io.*;
import java.util.*;

import problemdomain.Appliance;
import problemdomain.Dishwasher;
import problemdomain.Microwave;
import problemdomain.Refrigerator;
import problemdomain.Vacuum;

/**
 * Represents the Appliance manager to manager Appliances
 * @author Sherry, Han
 * @version January 23, 2026
 */
public class AppliancesManager {
	
	private final static String FILE_NAME = "res/appliances.txt";

	private static ArrayList<Appliance> appliances = new ArrayList<Appliance>();
	private static Scanner keyboard = new Scanner(System.in);
	
	/**
	 * Creates a Appliance Manager to manage appliances.
	 */
	public AppliancesManager()
	{
		loadAppliances();
		displayMenu();
		//keyboard.close();
	}
	
	/**
	 * Loads Appliance Object into a list by reading appliance data from data file.
	 * @return
	 */
	private ArrayList<Appliance> loadAppliances () {
		File file = new File(FILE_NAME);
		if(file.exists()) {
			try (Scanner in = new Scanner(file)){
				while(in.hasNext()) {
					String line = in.nextLine();
					//System.out.println(line);
					String[] data = line.split(";");
					char firstDigit = data[0].charAt(0);
					Appliance appliance = null;
					switch (firstDigit) {
					case '1':
						appliances.add(new Refrigerator(
							Long.parseLong(data[0]),
                            data[1],
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            data[4],
                            Double.parseDouble(data[5]),
                            Integer.parseInt(data[6]),
                            Integer.parseInt(data[7]),
                            Integer.parseInt(data[8])
                            ));
//						System.out.println(appliances);
						break;
					case '2':
						appliances.add(new Vacuum(
							Long.parseLong(data[0]),
                            data[1],
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            data[4],
                            Double.parseDouble(data[5]),
                            data[6],
                            Integer.parseInt(data[7])
                            ));
//						System.out.println(appliances);
						break;
					case '3':
						appliances.add(new Microwave(
							Long.parseLong(data[0]),
                            data[1],
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            data[4],
                            Double.parseDouble(data[5]),
                            Double.parseDouble(data[6]),
                            data[7]
                            ));
//						System.out.println(appliances);
						break;
					case '4':
					case '5':
						appliances.add(new Dishwasher(
							Long.parseLong(data[0]),
                            data[1],
                            Integer.parseInt(data[2]),
                            Integer.parseInt(data[3]),
                            data[4],
                            Double.parseDouble(data[5]),
                            data[6],
                            data[7]
                            ));
//						System.out.println(appliances);
						break;
						
					}
				}
			} catch (Exception e) {
				System.out.println("Error loading file.");
			}
		}
		return appliances;
	}
	
	/**
	 * Displays a main menu.
	 */
	private void displayMenu() {
		int choice = 0;
		while(choice != 5) {
			System.out.println("Welcome to Modern Appliances!");
			System.out.println("How may we assist you?");
			System.out.println("1 – Check out appliance\r\n"
					+ "2 – Find appliances by brand\r\n"
					+ "3 – Display appliances by type\r\n"
					+ "4 – Produce random appliance list\r\n"
					+ "5 – Save & exit");
			System.out.println("Enter option: ");
			
			choice = Integer.parseInt(keyboard.nextLine());
			switch(choice) {
			case 1:
				checkOutAppliances ();
				break;
			case 2:
				findApplianceByBrand ();
				break;
			case 3:
				displayAppliancesByType ();
				break;
			case 4:
				randomApplianceList ();
				break;
			case 5:
				saveAppliancesToFile();
				break;
			default:
				System.out.println("Error! Enter 1 to 5.");
			}
		}
	}
	
	/**
	 * Customers purchase an appliance.
	 */
	private static void checkOutAppliances () {
        System.out.print("Enter the item number of an appliance: ");
        long item = Long.parseLong(keyboard.nextLine());

        for (Appliance a : appliances) {
            if (a.getItemNum() == item) {
                if (a.getQuantity() > 0) {
                    a.decrementQuantity();
                    System.out.println("Appliance "+ a.getItemNum() +" has been checked out.");
                    //System.out.println(a);
                } else {
                    System.out.println("The appliance is not available to be checked out.");
                }
                return;
            }
        }
        System.out.println("No appliances found with that item number.");
	}
	
	/**
	 * When a customer enter a brand, it will search for and display the appliances with the same brand.
	 */
	private void findApplianceByBrand () {
		
	    System.out.print("Enter brand to search for: ");
	    String searchBrand = keyboard.nextLine().trim();

	    boolean found = false;

	    System.out.println("Matching Appliances:");

	    for (Appliance appliance : appliances) {
	        if (appliance.getBrand().equalsIgnoreCase(searchBrand)) {
	            System.out.println(appliance);
	            // spacing between appliances
	            System.out.println(); 
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No appliances found with that brand.");
	    }
		
	}
	
	/**
	 * When a customer enter a type of appliance, it will search for the same type of appliance and display them.
	 */
	private void displayAppliancesByType() {
	    System.out.println("Appliance Types");
	    System.out.println("1 – Refrigerators");
	    System.out.println("2 – Vacuums");
	    System.out.println("3 – Microwaves");
	    System.out.println("4 – Dishwashers");
	    System.out.print("Enter type of appliance: ");
	    
	    int typeOption = keyboard.nextInt();
	    // consume newline
	    keyboard.nextLine(); 

	    boolean found = false;

	    switch(typeOption) {
	    	// Refrigerators
	        case 1: 
	            System.out.print("Enter number of doors: 2 (double door), 3 (three doors) or 4 (four doors): ");
	            int doors = keyboard.nextInt();
	            keyboard.nextLine();
	            System.out.println("Matching refrigerators:");
	            for (Appliance a : appliances) {
	                if (a instanceof Refrigerator) {
	                    Refrigerator r = (Refrigerator) a;
	                    if (r.getNumOfDoors() == doors) {
	                        System.out.println(r);
	                        System.out.println();
	                        found = true;
	                    }
	                }
	            }
	            break;
	        // Vacuums
	        case 2: 
	            System.out.print("Enter battery voltage value. 18 V (low) or 24 V (high): ");
	            int voltage = keyboard.nextInt();
	            keyboard.nextLine();
	            System.out.println("Matching vacuums:");
	            for (Appliance a : appliances) {
	                if (a instanceof Vacuum) {
	                    Vacuum v = (Vacuum) a;
	                    if (v.getBatteryVoltage() == voltage) {
	                        System.out.println(v);
	                        System.out.println();
	                        found = true;
	                    }
	                }
	            }
	            break;
	        // Microwaves
	        case 3: 
	            System.out.print("Room where the microwave will be installed: K (kitchen) or W (work site): ");
	            String room = keyboard.nextLine().trim().toUpperCase();
	            System.out.println("Matching microwaves:");
	            for (Appliance a : appliances) {
	                if (a instanceof Microwave) {
	                    Microwave m = (Microwave) a;
	                    if (m.getRoomType().equalsIgnoreCase(room)) {
	                        System.out.println(m);
	                        System.out.println();
	                        found = true;
	                    }
	                }
	            }
	            break;
	        // Dishwashers
	        case 4: 
	            System.out.print("Enter the sound rating of the dishwasher: Qt (Quietest), Qr (Quieter), Qu(Quiet) or M (Moderate): ");
	            String sound = keyboard.nextLine().trim();
	            System.out.println("Matching dishwashers:");
	            for (Appliance a : appliances) {
	                if (a instanceof Dishwasher) {
	                    Dishwasher d = (Dishwasher) a;
	                    if (d.getSoundRating().equalsIgnoreCase(sound)) {
	                        System.out.println(d);
	                        System.out.println();
	                        found = true;
	                    }
	                }
	            }
	            break;

	        default:
	            System.out.println("Invalid option.");
	    }

	    if (!found) {
	        System.out.println("No appliances found with the selected criteria.");
	    }
	}

	/**
	 * When a customer enter a number, it will display the number of random appliance.
	 */
	private void randomApplianceList() {
	    System.out.print("Enter number of appliances: ");
	    int num = keyboard.nextInt();
	    // consume leftover newline
	    keyboard.nextLine(); 

	    if (num <= 0) {
	        System.out.println("Number must be greater than 0.");
	        return;
	    }

	    System.out.println("Random appliances:");

	    // If requested number is more than list size, adjust
	    int listSize = appliances.size();
	    if (num > listSize) num = listSize;

	    // Create a copy of appliances to pick randomly without duplicates
	    ArrayList<Appliance> copy = new ArrayList<>(appliances);
	    Collections.shuffle(copy);

	    for (int i = 0; i < num; i++) {
	        System.out.println(copy.get(i));
	        System.out.println(); 
	    }
	}

	/**
	 * Save Appliance data of the list to data file.
	 */
	private void saveAppliancesToFile() {
	    try (PrintWriter writer = new PrintWriter(new File(FILE_NAME))) {
	        for (Appliance appliance : appliances) {
	            if (appliance instanceof Refrigerator) {
	                Refrigerator r = (Refrigerator) appliance;
	                writer.printf("%d;%s;%d;%d;%s;%.2f;%d;%d;%d%n",
	                        r.getItemNum(),
	                        r.getBrand(),
	                        r.getQuantity(),
	                        r.getWattage(),
	                        r.getColor(),
	                        r.getPrice(),
	                        r.getNumOfDoors(),
	                        r.getHeight(),
	                        r.getWidth());
	            } else if (appliance instanceof Vacuum) {
	                Vacuum v = (Vacuum) appliance;
	                writer.printf("%d;%s;%d;%d;%s;%.2f;%s;%d%n",
	                        v.getItemNum(),
	                        v.getBrand(),
	                        v.getQuantity(),
	                        v.getWattage(),
	                        v.getColor(),
	                        v.getPrice(),
	                        v.getGrade(),
	                        v.getBatteryVoltage());
	            } else if (appliance instanceof Microwave) {
	                Microwave m = (Microwave) appliance;
	                writer.printf("%d;%s;%d;%d;%s;%.2f;%.1f;%s%n",
	                        m.getItemNum(),
	                        m.getBrand(),
	                        m.getQuantity(),
	                        m.getWattage(),
	                        m.getColor(),
	                        m.getPrice(),
	                        m.getCapacity(),
	                        m.getRoomType());
	            } else if (appliance instanceof Dishwasher) {
	                Dishwasher d = (Dishwasher) appliance;
	                writer.printf("%d;%s;%d;%d;%s;%.2f;%s;%s%n",
	                        d.getItemNum(),
	                        d.getBrand(),
	                        d.getQuantity(),
	                        d.getWattage(),
	                        d.getColor(),
	                        d.getPrice(),
	                        d.getFeature(),
	                        d.getSoundRating());
	            }
	        }
	        System.out.println("Appliances saved successfully!");
	    } catch (FileNotFoundException e) {
	        System.out.println("Error saving appliances: " + e.getMessage());
	    }
	}
}
