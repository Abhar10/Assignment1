import java.util.Comparator;

/**
 * Class SortByName implements the Java Interface Comparator. This Class sorts the 
 * Customers according to the Name of the Customer.
 * 
 * @author Abhar Sinha
 * @since 2019-02-18
 */
class SortByName implements Comparator<Customer> 
{ 
    
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