package TCPServer;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Factory {

	ArrayList<Car> cars = new ArrayList<>();
	
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
	
	public boolean addCar(String cnr, String model, Double weight)
	{
		cars.add(new Car(cnr,model,weight));
		//TODO Add to text file(Database)
		return true;//Car succesfully added
	}

}
