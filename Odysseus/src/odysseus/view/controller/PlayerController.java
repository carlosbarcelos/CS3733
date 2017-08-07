package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import odysseus.view.Frames.PlayerMenu;
import odysseus.Builder;
import odysseus.Player;
import odysseus.common.entities.AbsLevel;
import odysseus.view.Frames.PSplashScreen;
/**
 * Allows player to move from the splash screen to the menu.
 * @author Kevin Valente
 *
 */
public class PlayerController implements ActionListener {
	Player model;
	PSplashScreen one;
	
	public PlayerController (PSplashScreen pSplashScreen, Player model2) {
		this.one = pSplashScreen;
		this.model = model2;
	}

	/**
	 * Switches from the Splash Screen to the Main Menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelL.setValue(ival);  // update
		
			PlayerMenu two = new PlayerMenu(model);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}
