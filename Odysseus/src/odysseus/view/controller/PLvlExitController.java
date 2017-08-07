package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.view.Frames.PlayerPLvl;
import odysseus.common.entities.Puzzle;
import odysseus.view.Frames.PlayerLevelP;

/**
 * Allows player to exit a puzzle level and takes them back to the puzzle level select.
 * @author Kevin Valente
 */
public class PLvlExitController implements ActionListener {
	Puzzle model;
	PlayerPLvl two;
	
	public PLvlExitController (PlayerPLvl t, Puzzle model2) {
		this.two = t;
		this.model = model2;
	}

	/**
	 * Returns from a Puzzle level to the Puzzle level select.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			PlayerLevelP one = two.getPreviousFrame();
			
			model.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}