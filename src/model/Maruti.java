package model;

/**
 * Class Maruti inherits from Class Car and calculates the Resale Value of the Car
 * 
 * @author Abhar
 *
 */
public class Maruti extends Car
{
    public Maruti(final int carId, final int price, final String model)
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