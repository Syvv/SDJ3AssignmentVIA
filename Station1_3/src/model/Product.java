package model;

import java.util.ArrayList;

public class Product {
	private String description;
	private ArrayList<Part> parts;
	
	public Product(String description) {
		this.description = description;
		parts = new ArrayList<>();
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<Part> getParts() {
		return parts;
	}
	
	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}
	
	public void addPart(Part part) {
		parts.add(part);
	}
	

}
