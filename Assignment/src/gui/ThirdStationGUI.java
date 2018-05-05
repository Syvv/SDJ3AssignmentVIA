package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Part;
import model.Product;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThirdStationGUI {

	private JFrame frame;
	private JTextField descriptionTextField;
	
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Part> parts = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdStationGUI window = new ThirdStationGUI();
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
	public ThirdStationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Adding elements into ArrayList parts
		parts.add(new Part("Engine", 1));
		parts.add(new Part("Break", 2));
		parts.add(new Part("Wheel", 3));
		
		// Parts that are going to be inserted into product
		ArrayList<String> newParts = new ArrayList<>();
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProductDescription = new JLabel("Product description:");
		lblProductDescription.setBounds(10, 11, 117, 14);
		frame.getContentPane().add(lblProductDescription);
		
		JComboBox<String> partsComboBox = new JComboBox<String>();
		for(Part part: parts) {
			partsComboBox.addItem(part.getName());
		}
		
		partsComboBox.setBounds(131, 34, 85, 20);
		frame.getContentPane().add(partsComboBox);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(130, 8, 86, 20);
		frame.getContentPane().add(descriptionTextField);
		descriptionTextField.setColumns(10);
		
		JLabel lblParts = new JLabel("Parts:");
		lblParts.setBounds(10, 37, 97, 14);
		frame.getContentPane().add(lblParts);
		
		JLabel currentNumberOfPartslabel = new JLabel("0");
		currentNumberOfPartslabel.setBounds(131, 65, 46, 14);
		frame.getContentPane().add(currentNumberOfPartslabel);
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product newProduct = new Product(descriptionTextField.getText());
				// Looping through names to get the parts and add them into newProduct
				for(String newPart: newParts) {
					for(Part part: parts) {
						if (newPart == part.getName()) {
							newProduct.addPart(part);
						}
					}
				}
				// Adding the newProduct with the parts and description into products ArrayList
				products.add(newProduct);
				
				// Printing the parts and description to check if it works
				System.out.println(products.get(0).getDescription());
				for(Part part: products.get(0).getParts()) {
					System.out.println(part.getName());
				}
			}
		});
		btnAddProduct.setBounds(124, 93, 103, 23);
		frame.getContentPane().add(btnAddProduct);
		
		JButton btnAddPart = new JButton("Add part");
		btnAddPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newParts.add((String) partsComboBox.getSelectedItem());
				currentNumberOfPartslabel.setText(String.valueOf(newParts.size()));
			}
		});
		btnAddPart.setBounds(226, 33, 89, 23);
		frame.getContentPane().add(btnAddPart);
		
		JLabel lblNumberOfParts = new JLabel("Number of parts:");
		lblNumberOfParts.setBounds(10, 62, 97, 14);
		frame.getContentPane().add(lblNumberOfParts);
	}
}
