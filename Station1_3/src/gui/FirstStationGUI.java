package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Car;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FirstStationGUI {

	private JFrame frame;
	private JTextField chassisNumberTextField;
	private JTextField modelTextField;
	private JLabel lblChassisNumber;
	private JLabel lblModel;
	private JLabel lblWeight;
	private JTextField weightTextField;
	
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstStationGUI window = new FirstStationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstStationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		chassisNumberTextField = new JTextField();
		chassisNumberTextField.setBounds(115, 11, 86, 20);
		frame.getContentPane().add(chassisNumberTextField);
		chassisNumberTextField.setColumns(10);
		
		modelTextField = new JTextField();
		modelTextField.setBounds(115, 42, 86, 20);
		frame.getContentPane().add(modelTextField);
		modelTextField.setColumns(10);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double weight = Integer.parseInt(weightTextField.getText());
				Car car = new Car(chassisNumberTextField.getText(), modelTextField.getText(), weight);
				try {
					Client.sendCar(car);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddCar.setBounds(115, 106, 89, 23);
		frame.getContentPane().add(btnAddCar);
		
		lblChassisNumber = new JLabel("Chassis number: ");
		lblChassisNumber.setBounds(10, 14, 103, 14);
		frame.getContentPane().add(lblChassisNumber);
		
		lblModel = new JLabel("Model: ");
		lblModel.setBounds(10, 42, 46, 14);
		frame.getContentPane().add(lblModel);
		
		lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(10, 67, 46, 14);
		frame.getContentPane().add(lblWeight);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(115, 73, 86, 20);
		frame.getContentPane().add(weightTextField);
		weightTextField.setColumns(10);
	}
}
