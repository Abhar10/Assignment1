package assignment1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import utilpackage.ValidationCheck;

/**
 * AdminUtil Class contains important methods required by Admin Class.
 * 
 * @author Abhar Sinha
 * @since 2019-02-18
 */
public final class AdminUtil {
	
	/**
	 * Method to add a new customer
	 * 
	 * @param carList Method Takes the list of cars owned by a customer
	 * @param customerList Method Takes the list of customers entered by admin
	 * @param idHashSet Stores the ID's of the all the customers 
	 */
	public static void addNewCustomer(final ArrayList<Car> carList, ArrayList<Customer> customerList, HashSet<Integer> idHashSet)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Customer ID and Customer Name");
		int custIdInput = sc.nextInt();
		
		//Check if the Entered ID is unique and is not used by any other customer
		if(ValidationCheck.isIdUnique(custIdInput, idHashSet) != true)
		{
			System.out.println("Please Enter a Unique Customer Id");
			return;
		}
		idHashSet.add(custIdInput);
		String custNameInput = sc.next();
		
		//check if Name consists of valid characters
		if(ValidationCheck.isValidName(custNameInput) != true)
		{
			System.out.println("Please enter a valid Customer Name");
			return;
		}
		
	    Customer customerObj = new Customer(custIdInput, custNameInput, carList);
	    customerList.add(customerObj);
	}
	
	/**
	 * Method to add Car to an existing customer
	 * 
	 * @param customerId The id of customer to whom new car added
	 * @param car The new car to be added
	 * @param customerList List of customers entered by admin
	 */
	public static void addCarToCustomer(final int customerId, final Car car, ArrayList<Customer> customerList)
	{
		int i, customerFlag = 0;
		//Search the List of Customers to whom new car to be added
		for(i=0;i<customerList.size();i++)
		{
			if(customerId == customerList.get(i).getCustomerId())
			{
				//If customer with entered ID found set the customerFlag
				customerFlag = 1;
				break;
			}
		}
		
		//If No Customer with entered ID exists in the list
		if(customerFlag == 0)
		{
			System.out.println("No Customer with Inputed Id Found");
			return;
		}
		
		customerList.get(i).addCarToCustomer(car);
	}
	
	/**
	 * Method to add car to an existing customer according to the Car Type
	 * 
	 * @param customerList The list stores all the customers
	 */
	public static void addCarToExistingCustomer(ArrayList<Customer> customerList)
	{
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Input Customer Id to whom New Car to be added");
	   int customerIdInput = sc.nextInt();
	
	   System.out.println("Input Car Id, Car Price and Car Model");
	   int carIdInput = sc.nextInt();
	   int carPriceInput = sc.nextInt();
	   String carModelInput = sc.next();
	
	   System.out.println("Input Type of the Car");
	   String carTypeInput = sc.next();
	
	   //If car type is Toyota
	   if(carTypeInput.equals("Toyota"))
	   {	
	    	addCarToCustomer(customerIdInput, new Toyota(carIdInput, carPriceInput, carModelInput), customerList);
	   }
	   //If car type is Maruti
	   else if(carTypeInput.equals("Maruti"))
	   {
		    addCarToCustomer(customerIdInput, new Maruti(carIdInput, carPriceInput, carModelInput), customerList);
	   }
	   //If car type is Hyundai
	   else if(carTypeInput.equals("Hyundai"))
	   {
		    addCarToCustomer(customerIdInput, new Hyundai(carIdInput, carPriceInput, carModelInput), customerList);
	   }
	   //If any other type except the three entered
	   else
	   {
		    System.out.println("Input Car Type not a valid Car Type");
     	}
	  }
	
	/**
	 * Method to print customer name given provided his ID
	 * 
	 * @param id ID of the customer whose corresponding name the admin wants
	 * @param customerList List of the customers
	 */
	
	public static void printCustomerNameById(final int id, final ArrayList<Customer> customerList)
	{
		Iterator<Customer> iter = customerList.iterator();
		
		//Check the Customer List if customer with entered ID exists
		while(iter.hasNext())
		{
			Customer tempCustomer = iter.next();
			if(tempCustomer.getCustomerId() == id)
			{
				String tempName = tempCustomer.getCustomerName();
				System.out.println(tempName);
				return;
			}
		}
		//If no customer with entered ID found
		System.out.println("Please input an existing ID");
	}
	}
	
    
    