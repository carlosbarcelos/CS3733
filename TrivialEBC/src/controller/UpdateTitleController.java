package controller;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.Model;
import view.Application;

public class UpdateTitleController implements ActionListener {
	Application application;     /** Application we have control over. */
	Model model;                 /** Model containing state. */
	
	public UpdateTitleController(Application app, Model m) {
		this.application = app;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf = application.getNameField();
		
		// update entity class
		model.setTitle(tf.getText());
		
		// cause refresh as appropriate
		application.setTitle (model.getTitle());
	}
}
