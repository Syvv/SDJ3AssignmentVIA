package model;

public class Part {
	private String name;
	private int palletNumber;
	
	public Part(String name, int palletNumber) {
		this.name = name;
		this.palletNumber = palletNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPalletNumber() {
		return palletNumber;
	}
	
	public void setPalletNumber(int palletNumber) {
		this.palletNumber = palletNumber;
	}
	
	public Part returnPart() {
		return this;
	}

}
