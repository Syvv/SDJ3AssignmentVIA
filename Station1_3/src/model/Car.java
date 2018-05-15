package model;

public class Car {
	
	String chassisNumber;
	String model;
	double weight;

	public Car(String cnr, String model, Double weight)
	{
		this.model = model;
		this.weight = weight;
		chassisNumber = cnr;
	}
	
}
