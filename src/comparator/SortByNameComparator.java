package comparator;


import java.util.Comparator;
import model.Customer;


/**
 * Class SortByName implements the Java Interface Comparator. This Class sorts the 
 * Customers according to the Name of the Customer.
 * 
 * @author Abhar Sinha
 * @since 2019-02-18
 */
class SortByNameComparator implements Comparator<Customer> 
{ 
    //Compare customers according to their name
    public int compare(final Customer customer1, final Customer customer2) 
    { 
    	
        if(customer1.getCustomerName().compareTo(customer2.getCustomerName()) == 0)
        {
        	return 0;
        }
        else if(customer1.getCustomerName().compareTo(customer2.getCustomerName()) < 0)
        {
        	return -1;
        }
        else
        {
        	return 1;
        }
    } 
} 