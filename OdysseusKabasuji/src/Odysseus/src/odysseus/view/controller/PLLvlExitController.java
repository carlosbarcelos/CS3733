package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.Lightning;
import odysseus.view.Frames.PlayerLLvl;
import odysseus.view.Frames.PlayerLevelL;

/**
 * Allows player to exit a lightning level and takes them back to the lightning level select.
 * @author valente
 */
public class PLLvlExitController implements ActionListener {
	Lightning model;
	PlayerLLvl two;
	
	public PLLvlExitController (PlayerLLvl t, Lightning model2) {
		this.two = t;
		this.model = model2;
	}

	/**
	 * Returns from a Lightning level to the Lightning level select.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			PlayerLevelL one = two.getPreviousFrame();
			
			model.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}