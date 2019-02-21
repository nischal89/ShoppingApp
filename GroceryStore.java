package shoppingApp;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GroceryStore
{
	private ArrayList<String> items = new ArrayList<>();

	Scanner f = new Scanner(System.in);
	// add items to the array list
	public void addGroceryItem(String item)
	{
		items.add(item);
		System.out.println("\n " + item + " successfully added, now choose next action");
	}

	public static void printInstructions()
	{
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list.");
		System.out.println("\t 3 - To remove an item from the list.");
		System.out.println("\t 4 - To search for an item in the list.");
		System.out.println("\t 5 - To quit the application.");
	}
	// print the stored items

	public void printGroceryList()
	{
		System.out.println("You have " + items.size() + " items in your grocery list");
		
		Collections.sort(items);
		
		for(int i=0; i< items.size(); i++)
		{
			 
			System.out.println((i+1) + ". " + items.get(i));
			
		}
	}

	public void removeItem()
    {
        System.out.println("Enter the item number: ");
        int itemNo = f.nextInt();
        f.nextLine();
        items.remove(itemNo-1);
        System.out.println("Item " + itemNo + " successfully removed. Now please choose what you want to do next.");
    }

	public String findItem()
	{
		//        boolean exists = groceryList.contains(searchItem);
		
		String toFind = f.nextLine();
		if (items.contains(toFind)) {
		    System.out.println("your item exists in the shopping list");
		} else {
		    System.out.println("the item you are looking for doesnot exist.");
		    System.out.println("if you want to add it press 2");
		}
		return null;
	}

	public void save() throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		for(int i = 0; i < items.size(); i++) {
			writer.write(items.get(i));			 
			writer.write('\n');
		}
		writer.close();
	}	
	public void read() throws IOException {


		Scanner r = new Scanner(new File("output.txt"));

		while (r.hasNextLine())
			items.add(r.nextLine());

		System.out.println("You have" + items + "in your shopping list");

	}
	public void deleteAll () throws IOException {
	
			items.removeAll(items);
		
		
		
		
	}
	
}	
	

