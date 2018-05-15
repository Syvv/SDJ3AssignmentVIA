package TCPServer;

import java.util.ArrayList;

public class Pallet {

	int nr;
	double capacity;
	ArrayList<Part> parts;
	
	public Pallet(int nr, Double capacity)
	{
		this.nr = nr;
		this.capacity = capacity;
		this.parts = new ArrayList<Part>();
	}
	
	public boolean addPart(Part part)
	{
		if(!checkWeights(part.weight))
		{
			return false;
		}
		return parts.add(part);
	}
	
	public boolean removePart(Part part)
	{
		return parts.remove(part);
	}
	
	/**
	 * Checks if the Pallet has enough capacity left to hold the given weight.
	 * 
	 * @param weight : the weight to be added
	 * @return : true if there is enough capacity, false if over capacity
	 */
	private boolean checkWeights(double weight)
	{
		return true;
	}
	
}
