package odysseus.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import odysseus.Builder;
import odysseus.common.entities.AbsLevel;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Square;
import odysseus.view.Frames.BuilderLLvl;
import odysseus.view.Frames.BuilderMenu;

/**
 * Allows builder to move from the menu to the lightning level select.
 * @author Kevin Valente
 *
 */
public class BuilderLightningController implements ActionListener {
	Builder model;
	BuilderMenu one;
	
	public BuilderLightningController (BuilderMenu menuBuilder, Builder model2) {
		this.one = menuBuilder;
		this.model = model2;
	}

	/**
	 * Switches from Main Menu to the Lightning level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get value
		try {
			int ival  = Integer.parseInt(one.getTextField().getText());
			one.setVisible(false);
			
			model.levelL.setValue(ival);  // update
		
			BuilderLLvl two = new BuilderLLvl(model.levelL);
			two.setPreviousFrame(one);
			two.setVisible(true);
		} catch (Exception ex) {
			System.err.println("Not Integer!!!");
		}
	}
}