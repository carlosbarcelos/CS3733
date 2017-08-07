package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Builder;
import odysseus.common.entities.AbsLevel;
import odysseus.view.Frames.BSplashScreen;
import odysseus.view.Frames.BuilderMenu;

/**
 * Allows the builder to move from the splash screen to the menu.
 * @author Kevin Valente
 *
 */
public class BuilderController implements ActionListener {
	Builder model;
	BSplashScreen one;
	
	public BuilderController (BSplashScreen splashScreenB, Builder model2) {
		this.one = splashScreenB;
		this.model = model2;
	}

	/**
	 * Switches from the Splash Screen to the Main Menu. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelL.setValue(ival);  // update
		
			BuilderMenu two = new BuilderMenu(model);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}
