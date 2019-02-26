package model;

import java.util.ArrayList;

/**
 * Customer class to store informtion of customer such as customer name, customer ID 
 * and stores the list of cars owned by a customer.
 * 
 * @author Abhar Sinha
 * @since 2019-02-28
 */
public class Customer {
	
	private int mCustomerId;
	private String mCustomerName;
	public ArrayList<Car> carList = new ArrayList<Car>();
	
	public Customer(final int customerId, final String customerName, final ArrayList<Car> carList)
	{
		
		this.mCustomerId = customerId;
		this.mCustomerName = customerName;
		this.carList = new ArrayList<Car>(carList);
	}
	
	//Getter function to get customer ID
	public int getCustomerId()
	{
		return mCustomerId;
	}
	
	//Getter function to get customer Name
	public String getCustomerName() {
		return mCustomerName;
	}
	
	//Function to add new car to the created customer object
	public void addCarToCustomer(final Car car)
	{
		this.carList.add(car);
	}

	

			
}

