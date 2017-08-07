package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Player;
import odysseus.view.Frames.PlayerLevelP;
import odysseus.view.Frames.PlayerMenu;

/**
 * Allows player to move from the menu to a puzzle level select.
 * @author Kevin Valente
 *
 */
public class PlayerPuzzleController implements ActionListener {
	Player model;
	PlayerMenu one;
	
	public PlayerPuzzleController (PlayerMenu playerMenu, Player model2) {
		this.one = playerMenu;
		this.model = model2;
	}

	/**
	 * Switch the Main Menu to the Puzzle level select.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelP.setValue(ival);  // update
		
			PlayerLevelP two = new PlayerLevelP(model.levelP);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}