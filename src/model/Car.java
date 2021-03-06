package model;

/**
 * Car class stores information of a car such as Car ID, Car Model, Car Price
 * and calculates the resale calue of the Car.
 * 
 * @author Abhar Sinha
 * @since 2019-02-18
 */
public abstract class Car
{
	private int mCarId;
	private String mCarModel;
	protected double mResaleValue;
	protected int mCarPrice;

	public Car(final int carId, final int price, final String model)
	{
	this.mCarId = carId;
	this.mCarPrice = price;
	this.mCarModel = model;
	}
	
	//Setter function to set Car ID
	public int getCarId()
	{
		return mCarId;
	}
	
	//Setter function to set Car price
	public int getCarPrice()
	{
		return mCarPrice;
	}
	
	//Setter function to set Car Model
	public String getCarModel()
	{
		return mCarModel;
	}
	
	//Function to calculate Resale value of the Car
	public double getResaleValue()
	{
		return mResaleValue;
	}
	
	abstract void calculateResaleValue(final int rate);
}




