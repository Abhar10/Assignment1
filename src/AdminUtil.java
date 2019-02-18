import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * AdminUtil Class contains all the methods required by Admin Class.
 * 
 * @author Abhar Sinha
 * @since 2019-02-18
 */
public class AdminUtil {
	//Method to create a new customer
	public static void addNewCustomer(ArrayList<Car> carList, ArrayList<Customer> customerList, HashSet<Integer> idHashSet)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Customer ID and Customer Name");
		int custIdInput = sc.nextInt();
		//Check if the Entered ID is unique and is not used by any other customer
		if(isIdUnique(custIdInput, idHashSet) != true)
		{
			System.out.println("Please Enter a Unique Customer Id");
			return;
		}
		idHashSet.add(custIdInput);
		String custNameInput = sc.next();
		//check if Name consists of valid characters
		if(isValidName(custNameInput) != true)
		{
			System.out.println("Please enter a valid Customer Name");
			return;
		}
		
	    Customer customerObj = new Customer(custIdInput, custNameInput, carList);
	    customerList.add(customerObj);
	}
	//Method to add new car to a customer
	public static void addCarToCustomer(int customerId, Car car, ArrayList<Customer> customerList)
	{
		int i, customerFlag = 0;
		for(i=0;i<customerList.size();i++)
		{
			if(customerId == customerList.get(i).getCustomerId())
			{
				customerFlag = 1;
				break;
			}
		}
		
		if(customerFlag == 0)
		{
			System.out.println("No Customer with Inputed Id Found");
			return;
		}
		
		customerList.get(i).addCarToCustomer(car);
	}
	
	//Method to add new car to an existing customer
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
	
	   if(carTypeInput.equals("Toyota"))
	   {	
	    	addCarToCustomer(customerIdInput, new Toyota(carIdInput, carPriceInput, carModelInput), customerList);
	   }
	   else if(carTypeInput.equals("Maruti"))
	   {
		    addCarToCustomer(customerIdInput, new Maruti(carIdInput, carPriceInput, carModelInput), customerList);
	   }
	   else if(carTypeInput.equals("Hyundai"))
	   {
		    addCarToCustomer(customerIdInput, new Hyundai(carIdInput, carPriceInput, carModelInput), customerList);
	   }
	   else
	   {
		    System.out.println("Input Car Type not a valid Car Type");
     	}
	  }
	//Method to find customer name by ID
	public static void printCustomerNameById(int id, ArrayList<Customer> customerList)
	{
		Iterator<Customer> iter = customerList.iterator();
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
		System.out.println("Please input an existing ID");
	}
	//Method to sort customers by name and print them with their cars
	public static void sortCustomersByName(ArrayList<Customer> customerList)
	{
		if(customerList.size() == 0)
		{
			System.out.println("There are currently no Customer");
			return;
		}
		
		Collections.sort(customerList, new SortByName());
		for(int i=0; i<customerList.size(); i++)
		{
			
			System.out.println("Name of the customer is " + customerList.get(i).getCustomerName());
			if(customerList.get(i).carList.size() == 0)
			{
				System.out.println(customerList.get(i).getCustomerName() + " owns no car");
			}
			else
			{
				System.out.println(customerList.get(i).getCustomerName() +" owns the following car(s)");
			    for(int j=0; j<customerList.get(i).carList.size(); j++)
			    {
				    System.out.println(customerList.get(i).carList.get(j).getCarModel());
			    }
			}
		}
	}
	//Method to generate prizes according to the condition
    public static void generatePrizes(ArrayList<Customer> customerList) {
		
    	        int prizeCount=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter 3 valid customer ID's");
		//HashSet to store user inputed ID's
		HashSet<Integer> idSet = new HashSet<Integer>();
		Random rand = new Random();
		
		for(int i=0; i<3; i++)
		{
		    idSet.add(sc.nextInt());
		}

		for(int i=0; i<6; i++)
		{
			int randomNum = rand.nextInt(6);
			
			//Check whether the number of customers is not less than 6
			if(customerList.size() <= randomNum)
			{
			   //Check if no one among the customer has won the prize
			   if(i == 5 && prizeCount == 0)
			   {
				   System.out.println("No one was lucky enough to win the prize");
			   }
			   //Skip the current i and move to the next value of i
			   continue;
			}
			
			int randomCustomerId = customerList.get(randomNum).getCustomerId();
			//Check which random ID's does HashSet contains
			if(idSet.isEmpty() != true && idSet.contains(randomCustomerId) == true)
			{
				//Remove customer from HashSet to enable no repetition
				idSet.remove(randomCustomerId);
				System.out.println("Custome with Id " + randomCustomerId + " has won the price");
				prizeCount++;
			}
			//Check if no one among the customer has won the prize
			else if(i == 5 && prizeCount == 0)
			{
				System.out.println("No one was lucky enough to win the prize");
			}
			}
		}
    
    //Check if the entered name contains characters between a-z and A-Z
    public static boolean isValidName(String customerName)
    {
    	int countValidChar = 0;
    	int nameLength = customerName.length();
    	
    	for(int i = 0; i < nameLength; i++)
    	{
    		int asciiValue = customerName.charAt(i);
    		if((asciiValue >= 65 && asciiValue <= 90) || (asciiValue >= 97 && asciiValue <= 122))
    		{
    			countValidChar++;
    		}
    	}
    	//if all characters are valid
    	if(countValidChar == nameLength)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    //Method to check if entered ID is not used by any other Customer
    public static boolean isIdUnique(int id, HashSet<Integer> idSet)
    {
    	if(idSet.isEmpty() != true)
    	{
    	if(idSet.contains(id) == true)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    	}
    	return true;
    }
	}


