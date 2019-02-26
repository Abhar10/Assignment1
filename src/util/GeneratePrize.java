package util;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import model.Customer;

/**
 * Class to generate Prize according to the condition that the three admin entered ID 
 * matching with the randomly generated ID's wins the Prize
 * 
 * @author Abhar
 *
 */
public final class GeneratePrize {

	/**
	 * Method checks if any of the ID,s randomly generated ID's matches with the
	 * ID's entered by the admin
	 * 
	 * @param customerList Check wheteher there is any lucky customer from the list
	 */
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
}

