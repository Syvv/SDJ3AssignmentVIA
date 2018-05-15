package TCPServer;

import java.util.ArrayList;

public class Product {

	int productNr;
	ArrayList<Part> parts;
	String desc;
	
	public Product(int nr, ArrayList<Part> parts, String desc)
	{
		productNr = nr;
		this.parts = parts;
		this.desc = desc;
	}
	
}
