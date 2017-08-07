package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.AbsLevel;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.Frames.BuilderRLvl;
/**
 * Allows builder to exit release level and takes them back to the menu.
 * @author Kevin Valente
 *
 */
public class BRLvlExitController implements ActionListener {
	AbsLevel model;
	BuilderRLvl two;
	
	public BRLvlExitController (BuilderRLvl builderPLvl1, AbsLevel m) {
		this.two = builderPLvl1;
		this.model = m;
	}

	/**
	 * Returns the builder from the Release level to 
	 * the Main Menu.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(two.getTextField().getText());
			two.setVisible(false);
			BuilderMenu one = two.getPreviousFrame();
			
			model.setValue(ival);  // update
		
			two.setVisible(false);
			two.dispose();
			one.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}