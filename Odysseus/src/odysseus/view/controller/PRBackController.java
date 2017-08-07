package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.AbsLevel;
import odysseus.view.Frames.PlayerLevelR;
import odysseus.view.Frames.PlayerMenu;

/**
 * Allows player to exit the release level select and takes them back to the menu.
 * @author Kevin Valente
 */
public class PRBackController implements ActionListener {
	AbsLevel model;
	PlayerLevelR two;
	
	public PRBackController (PlayerLevelR t, AbsLevel m) {
		this.two = t;
		this.model = m;
	}

	/**
	 * Returns Release level select to the Main Menu.
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