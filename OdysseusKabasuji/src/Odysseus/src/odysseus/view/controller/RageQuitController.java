package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.view.Frames.PlayerMenu;
import odysseus.Player;
import odysseus.view.Frames.PSplashScreen;

/**
 * Allows player to exit the menu and takes them back to the splash screen.
 * @author valente
 */
public class RageQuitController implements ActionListener {
	Player model;
	PlayerMenu two;
	
	public RageQuitController (PlayerMenu t, Player model2) {
		this.two = t;
		this.model = model2;
	}

	/**
	 * Returns from the Main Menu to the Splash Screen.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			PSplashScreen one = two.getPreviousFrame();
			
			model.levelL.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}