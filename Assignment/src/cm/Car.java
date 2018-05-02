package cm;

public class Car {
	private String model;
	private String chassisNumber;
	private int weight;
	
	public Car(String model, String chassisNumber, int weight) {
		this.model = model;
		this.chassisNumber = chassisNumber;
		this.weight = weight;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getChassisNumber() {
		return chassisNumber;
	}
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return model + " / " + chassisNumber + " / " + weight;
	}
}
