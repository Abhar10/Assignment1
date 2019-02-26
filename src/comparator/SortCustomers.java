package comparator;

import java.util.ArrayList;
import java.util.Collections;

import model.Customer;


/**
 * Class sorts the customer according to their name
 * 
 * @author Abhar
 *
 */
public final class SortCustomers {
	
	    /**
	     * Method sorts the Customers according to their Name
	     * 
	     * @param customerList Customer List to be Sorted
	     */
		public static void printSortedCustomersByName(ArrayList<Customer> customerList)
		{
			//Check if Customer List is not empty
			if(customerList.size() == 0)
			{
				System.out.println("There are currently no Customer");
				return;
			}
			
			Collections.sort(customerList, new SortByNameComparator());
			
			//Print the Sorted Customer List along with their Cars
			for(int i=0; i<customerList.size(); i++)
			{
				
				System.out.println("Name of the customer is " + customerList.get(i).getCustomerName());
				//If customer contains 0 car
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

}
