package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Builder;
import odysseus.common.entities.AbsLevel;
import odysseus.view.Frames.BSplashScreen;
import odysseus.view.Frames.BuilderMenu;

/**
 * Allows builder to exit the menu and takes them back to the splash screen.
 * @author valente
 */
public class NoMoreController implements ActionListener {
	Builder model;
	BuilderMenu two;
	
	public NoMoreController (BuilderMenu menuBuilder, Builder model2) {
		this.two = menuBuilder;
		this.model = model2;
	}

	/**
	 * Returns from the Main Menu to the Spash Screen.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			BSplashScreen one = two.getPreviousFrame();
			
			model.levelL.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}
