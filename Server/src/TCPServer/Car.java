package TCPServer;

public class Car {
	
	String chassisNumber;
	String model;
	Double weight;

	public Car(String cnr, String model, Double weight)
	{
		this.model = model;
		this.weight = weight;
		chassisNumber = cnr;
	}
	
}
