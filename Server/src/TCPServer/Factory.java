package TCPServer;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Factory {

	ArrayList<Car> cars = new ArrayList<>();
	ArrayList<Part> parts = new ArrayList<>();
	ArrayList<Product> products = new ArrayList<>();
	ArrayList<Pallet> pallets = new ArrayList<>();
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		  String clientSentence;
		  ServerSocket welcomeSocket = new ServerSocket(6789);
		  
		  while (true) {
			  Socket connectionSocket = welcomeSocket.accept();
			  BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			  DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			  
			  clientSentence = inFromClient.readLine();
			  System.out.println("Received: " + clientSentence);
			  
			  //TODO Handle input
			  outToClient.writeChars("OK");//Message was received, contained syntactically correct info and is appropriatly processed
		}
		
	}
	
	public boolean addCar(String cnr, String model, double weight)
	{
		cars.add(new Car(cnr,model,weight));
		//TODO Add to text file(Database)
		return true;//Car succesfully added
	}
	
	public boolean addPart(String cnr, double weight, String desc)
	{
		Car temp = null;
		for(Car c:cars)
		{
			if(c.chassisNumber.equals(cnr))
			{
				temp = c;
				break;
			}
		}
		if(temp==null)
		{
			return false;
		}
		parts.add(new Part(parts.size(),temp,weight,desc));
		//TODO Add to text file(Database)
		return true;
	}
	
	public boolean addProduct(int productNr,int[] partNrs, String desc)
	{
		ArrayList<Part> tempp = new ArrayList<Part>();
		for(Part p:parts)
		{
			for(int i:partNrs)
			{
				if(i==p.partNr)
				{
					tempp.add(p);
				}
			}
		}
		if(tempp.isEmpty())
		{
			return false;
		}
		products.add(new Product(products.size(),tempp,desc));
		return true;
	}

}
