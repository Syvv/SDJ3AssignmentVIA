package gui;

import model.Car;
import model.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	FirstStationGUI firstStation = new FirstStationGUI();
	ThirdStationGUI thirdStation = new ThirdStationGUI();
	
	static ObjectInputStream inToServer;
	static ObjectOutputStream outToServer;
	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		while (true) {
			@SuppressWarnings("resource")
			Socket clientSocket = new Socket("localhost", 6789);
			System.out.println("Connected to the server");
	        inToServer = new ObjectInputStream(clientSocket.getInputStream());
			outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			
			FirstStationGUI.main(args);
			ThirdStationGUI.main(args);
		}
	}
	
	public static void sendCar(Car car) throws IOException {
		outToServer.writeObject(car);
	}
	
	public static void sendProduct(Product product) throws IOException {
		outToServer.writeObject(product);
	}

}
