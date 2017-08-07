package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.common.entities.Lightning;
import odysseus.view.Frames.BuilderLLvl;
import odysseus.view.Frames.BuilderMenu;

/**
 * Allows builder to exit lightning level  and takes them back to the lighting level select.
 * @author Kevin Valente
 *
 */
public class BLLvlExitController implements ActionListener {
	Lightning model;
	BuilderLLvl two;
	
	public BLLvlExitController (BuilderLLvl builderLLvl, Lightning model2) {
		this.two = builderLLvl;
		this.model = model2;
	}

	/**
	 * Returns the builder from the Lightning level to 
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