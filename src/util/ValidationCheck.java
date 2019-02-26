package util;

import java.util.HashSet;

/**
 * Class ValidationCheck contains method which checks whether entered customer name contains
 * only valid characters and method to check if two customers with same ID are not entered
 * 
 * @author Abhar
 *
 */
public final class ValidationCheck {
	
	/**
	 * 
	 * @param customerName Check whether customer name contains valid characters
	 * @return true or false whether user name valid or not
	 */
    public static boolean isValidName(final String customerName)
    {
    	int countValidChar = 0;
    	int nameLength = customerName.length();
    	
    	//Count the numbers of valid characters in customer name
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
    
    /**
     * 
     * @param id The ID whose uniqueness to be determined
     * @param idSet Set contains all the ID's of the Customers
     * @return true or false depending on the condition whether contains 
     * all unique characters
     */
    public static boolean isIdUnique(int id, HashSet<Integer> idSet)
    {
    	//Check is Set is not Empty
    	if(idSet.isEmpty() != true)
    	{
    		
    	//If Set already contains the entered ID
    	if(idSet.contains(id) == true)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    	}
    	
    	//return true if there is no ID present in the Set
    	return true;
    }
	}




