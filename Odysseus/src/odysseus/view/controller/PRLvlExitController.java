package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.Release;
import odysseus.view.Frames.PlayerLevelR;
import odysseus.view.Frames.PlayerRLvl;

/**
 * Allows player to exit a release level and takes them back to the release level select.
 * @author Kevin Valente
 */
public class PRLvlExitController implements ActionListener {
	Release model;
	PlayerRLvl two;
	
	public PRLvlExitController (PlayerRLvl t, Release model2) {
		this.two = t;
		this.model = model2;
	}

	/**
	 * Returns from a Release level to the Release level select.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			PlayerLevelR one = two.getPreviousFrame();
			
			model.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}