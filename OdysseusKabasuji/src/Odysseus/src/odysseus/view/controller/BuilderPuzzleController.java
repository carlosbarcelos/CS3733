package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Builder;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.Frames.BuilderPLvl;

/**
 * Allows builder to move from the menu to a puzzle level select.
 * @author Kevin Valente
 *
 */
public class BuilderPuzzleController implements ActionListener {
	Builder model;
	BuilderMenu one;
	
	public BuilderPuzzleController (BuilderMenu menuBuilder, Builder model2) {
		this.one = menuBuilder;
		this.model = model2;
	}

	/**
	 * Switch from the Main Menu to the Puzzle level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelP.setValue(ival);  // update
			BuilderPLvl two = new BuilderPLvl(model.levelP);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}