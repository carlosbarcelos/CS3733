package quiz3.controller;

import java.awt.event.*;

import javax.swing.JTextField;

import quiz3.model.*;
import quiz3.move.IMove;
import quiz3.move.ModifyValue;
import quiz3.undo.UndoManager;
import quiz3.view.*;

public class ChangeTemperatureController implements ActionListener {
	Application application;     /** Application we have control over. */
	Model model;                 /** Model containing state. */
	
	public ChangeTemperatureController(Application app, Model m) {
		this.application = app;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf = application.getFahrenheitField();
		
		IMove move = new ModifyValue(model, Integer.valueOf(tf.getText()));
		
		// request move
		if (move.execute()) {
			UndoManager.instance().recordMove(move);
			application.refresh();
		}
	}
}
