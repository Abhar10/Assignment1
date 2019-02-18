package assignment1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Admin class returns the result as per the request of the admin.
 * There are 5 options for the customer. The choices are 1) To Add a new customer
 * 2) To add a new car to an existing customer. 3) To return the name of the customer
 * given his ID. 4) To return the list of customers with their cars in sorted order.
 * 5) To generate prize according to ID's chosen by the Admin
 * 
 * @author Abhar Sinha
 * @since 2019-02-18
 *
 */
public class Admin {
	public static void main(String args[]) {
		
		ArrayList<Car> carList = new ArrayList<Car>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		HashSet<Integer> idHashSet = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		
		printChoice();
		//Inputs the choice by admin
		int choice = sc.nextInt();
		
		while(choice != 0)
		{
			
		switch(choice) {
		
		case 1:
			AdminUtil.addNewCustomer(carList, customerList, idHashSet);
			break;
			
		case 2:
			AdminUtil.addCarToExistingCustomer(customerList);
			break;
			
		case 3:
			System.out.println("Enter a valid Id of Customer to search the respective Customer" );
			int inputId = sc.nextInt();
			
			AdminUtil.printCustomerNameById(inputId, customerList);
			break;
			
		case 4:
			AdminUtil.sortCustomersByName(customerList);
			break;
			
		case 5:
			AdminUtil.generatePrizes(customerList);
			break;
			
		default:
			System.out.println("Not a Valid Choice");
			break;
		}
		
		printChoice();
		choice = sc.nextInt();
		
		}
	}
	
	//Method to Print the options avaiable to the Admin
    public static void printChoice()
	{
		System.out.println("Input 1 to Add a new Customer");
		System.out.println("Input 2 to Add new Car to existing Customer");
		System.out.println("Input 3 to Search a Customer by the inputted Id");
		System.out.println("Input 4 to List all Customers with their cars sorted by name");
		System.out.println("Input 5 to Generate prizes for the customer");
		System.out.println("Input 0 to Exit the program");	
	}
}
	
	


