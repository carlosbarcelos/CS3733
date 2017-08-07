package view;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.UpdateTitleController;
import model.Model;

public class Application extends JFrame {
	JTextField nameField;    /** Relevant GUI widgets for this screen. */
	JButton setButton;
	Model model;             /** Model */
	JTextField otherField;
	String defaultValue = "Click to Change";
	
	public Application(Model m) {
		this.model = m;
		initialize();
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	
	public JButton getSetButton() {
		return setButton;
	}
	
	void initialize() {
		setTitle(model.getTitle());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 100);
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("New Title:");
		contentPane.add(lblName);
		
		nameField = new JTextField(10);
		contentPane.add(nameField);
		
		nameField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (Character.isAlphabetic(e.getKeyCode())) {
					return;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		otherField = new JTextField(10);
		otherField.setText(defaultValue);
		contentPane.add(otherField);
		
		otherField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (otherField.getText().equals(defaultValue)) {
					otherField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		

		setButton = new JButton("Set");
		contentPane.add(setButton);
		
		// install controller.
		setButton.addActionListener(new UpdateTitleController(this, model));
	}
}





