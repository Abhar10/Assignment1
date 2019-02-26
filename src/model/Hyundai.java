package model;

/**
* Class Hyundai inherits from Class Car and calculates the Resale Value of the Car
* 
* @author Abhar
*
*/
public class Hyundai extends Car
{
   public Hyundai(final int carId, final int price, final String model)
   {
   super(carId, price, model);
   }
   
   //Method calculates the Resale Value of the Car
   @Override
   public void calculateResaleValue(final int rate)
   {
   	mResaleValue = (rate * mCarPrice)/100;
   }   
}
