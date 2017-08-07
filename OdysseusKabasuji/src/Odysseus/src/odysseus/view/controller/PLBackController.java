package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.AbsLevel;
import odysseus.view.Frames.PlayerLevelL;
import odysseus.view.Frames.PlayerMenu;

/**
 * Allows player to exit the lightning level select and takes them back to the menu.
 * @author Kevin Valente
 */
public class PLBackController implements ActionListener {
	AbsLevel model;
	PlayerLevelL two;
	
	public PLBackController (PlayerLevelL t, AbsLevel model2) {
		this.two = t;
		this.model = model2;
	}

	/**
	 * Return from the Lightning level to the Main Menu.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			PlayerMenu one = two.getPreviousFrame();
			
			model.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}