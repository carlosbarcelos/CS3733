package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.Puzzle;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.Frames.BuilderPLvl;

/**
 * Allows builder to exit puzzle level  and takes them back to the lighting level select.
 * @author Kevin Valente
 *
 */
public class BLvlExitController implements ActionListener {
	Puzzle model;
	BuilderPLvl two;
	
	public BLvlExitController (BuilderPLvl builderPLvl, Puzzle model2) {
		this.two = builderPLvl;
		this.model = model2;
	}

	/**
	 * Returns the builder from the Player level to 
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