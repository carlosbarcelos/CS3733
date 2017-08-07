package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Player;
import odysseus.view.Frames.PlayerLevelR;
import odysseus.view.Frames.PlayerMenu;

/**
 * Allows player to move from the menu to a release level select.
 * @author Kevin Valente
 *
 */
public class PlayerReleaseController implements ActionListener {
	Player model;
	PlayerMenu one;
	
	public PlayerReleaseController (PlayerMenu playerMenu, Player model2) {
		this.one = playerMenu;
		this.model = model2;
	}

	/**
	 * Switch the Main Menu to the Release level select.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelR.setValue(ival);  // update
		
			PlayerLevelR two = new PlayerLevelR(model.levelR);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}