package shoppingApp;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Me {

	public static void main(String[] args) throws IOException{


		final Logger logger = Logger.getLogger(Me.class.getName());
		Me.setUpLogger();

		logger.info("Application Started");

		GroceryStore store = new GroceryStore();
		System.out.println("Choose an option from 0 to 5: ");
		GroceryStore.printInstructions();
		store.read();
		Scanner s = new Scanner(System.in);
		logger.info("Choice made");
		int choice;

		do {
			choice = s.nextInt();
			s.nextLine();


			switch(choice) {


			case 0:	
				System.out.println("pressed : " + choice);
				System.out.println("choose an option from below");
				GroceryStore.printInstructions();//print info
				logger.info("instructions printed");

				break;

			case 1:	
				System.out.println("pressed : " + choice);
				store.printGroceryList();//print info
				System.out.println("Now please choose what you want to do next.");
				logger.info("List Printed");

				break;

			case 2:
				System.out.println("pressed : " + choice + " please enter the item you want to add");
				String str = s.nextLine();
				store.addGroceryItem(str);
				logger.info("items added");

				break;

			
			case 3:
				System.out.println("pressed : " + choice);
				store.removeItem();

				break;

			case 4:
				System.out.println("pressed : " + choice);
				store.findItem();
				break;

			case 5:
				System.out.println("pressed : " + choice);
				store.save();
				logger.info("List saved and application exited");
				System.out.println("List saved and application closed");
				
				break;
			case 6:
				System.out.println("pressed : " + choice);
				store.deleteAll();
				logger.info("List empteied and application exited");
				System.out.println("List empteied and application closed");
				
				
			default:
				store.save();
				choice = 6;
				
				break;

			}
		}while(choice != 5);
	}
	public static void setUpLogger() {
		final Logger logger = Logger.getLogger(Me.class.getName());
		LogManager.getLogManager().reset();
		logger.setLevel(Level.ALL);


		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);
		logger.addHandler(ch);

		try {
			FileHandler fh = new FileHandler("mylog.log", true);
			fh.setLevel(Level.ALL);
			logger.addHandler(fh);

		} catch (IOException e) {
			logger.log(Level.SEVERE, "file logger not working", e);
		}
	
	}

}
