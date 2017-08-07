package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Player;
import odysseus.view.Frames.PlayerLevelL;
import odysseus.view.Frames.PlayerMenu;

/**
 * Allows player to move from the menu to the lightning level select.
 * @author Kevin Valente
 *
 */
public class PlayerLightningController implements ActionListener {
	Player model;
	PlayerMenu one;
	
	public PlayerLightningController (PlayerMenu playerMenu, Player model2) {
		this.one = playerMenu;
		this.model = model2;
	}

	/**
	 * Switch from the Main Menu to the Lightning level select.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelL.setValue(ival);  // update
		
			PlayerLevelL two = new PlayerLevelL(model.levelL);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}