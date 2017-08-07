package quiz3.view;

import java.awt.event.*;
import javax.swing.*;

import quiz3.model.*;
import quiz3.controller.*;

public class Application extends JFrame {
	JTextField fahrenheitField;    /** Relevant GUI widgets for this screen. */
	JButton convertButton;
	Model model;             
	JLabel lblCelsius;
	
	public Application(Model m) {
		this.model = m;
		initialize();
		
		// synchronize view with GUI
		refresh();
	}
	
	public JTextField getFahrenheitField() {
		return fahrenheitField;
	}
	
	public JButton getConvertButton() {
		return convertButton;
	}
	
	public JLabel getCelsiusLabel() {
		return lblCelsius;
	}
	
	void initialize() {
		setTitle("Fahrenheit to Celsius");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 290, 100);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Fahrenheit:");
		contentPane.add(lblName);
		
		fahrenheitField = new JTextField(10);
		contentPane.add(fahrenheitField);
		
		convertButton = new JButton("Convert");
		contentPane.add(convertButton);
		
		lblCelsius = new JLabel("Celsius: ");
		contentPane.add(lblCelsius);
		
		// install controller.
		convertButton.addActionListener(new ChangeTemperatureController(this, model));
		
		// install undo controller.
		fahrenheitField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.isControlDown() && e.getKeyCode() == 'Z') {
					new UndoController(Application.this, model).process();
				}
			}
		});
	}

	/** Boundary knows how to refresh itself in relation to model. */ 
	public void refresh() {
		getFahrenheitField().setText("" + model.getFahrenheit());
		getCelsiusLabel().setText("Celsius: " + model.getCelsius());
	}
}
