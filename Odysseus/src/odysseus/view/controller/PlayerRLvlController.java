package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import odysseus.common.entities.Release;
import odysseus.view.Frames.PlayerLevelR;
import odysseus.view.Frames.PlayerRLvl;

/**
 * Allows player to move from the release level select to a release level.
 * @author Kevin Valente
 *
 */
public class PlayerRLvlController implements ActionListener {
	Release model;
	PlayerLevelR one;
	int numLevel;
	Release r;

	public PlayerRLvlController (PlayerLevelR o, Release model2, int numLevel) {
		this.one = o;
		this.model = model2;
		this.numLevel = numLevel;
	}

	
	/**
	 * Switch Release level select to the appropriate level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Load the given level; if the level does not exist, catch the NullPointer
		try{
			r = (Release) model.loadLevel(numLevel);
		} catch(NullPointerException n){
			System.err.printf("Release level %d not found.", numLevel);
		}


		if(r != null){
			if(r.isUnlocked()){
				// get value
				try {
					int ival  = Integer.parseInt(one.getTextField().getText());
					one.setVisible(false);

					r.setValue(ival);  // update

					PlayerRLvl two = new PlayerRLvl(r);
					two.setPreviousFrame(one);
					two.setVisible(true);
				} catch (Exception ex) {
					System.err.println("Not Integer!!!");
				}
			}
		}
	}
}