package odysseus.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import odysseus.Builder;
import odysseus.common.entities.Board;
import odysseus.common.entities.Bullpen;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.common.entities.Release;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.controller.BuilderLightningController;
import odysseus.view.controller.BuilderPuzzleController;
import odysseus.view.controller.BuilderReleaseController;

/**
 * Test cases for the Builder Level Controllers.
 * @author Kevin Valente
 *
 */
public class TestBuilderLevelControllers extends TestCase {
	Builder b;
	BuilderMenu bm;

	ActionEvent e = null;
	
	public ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	public ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	public long time = 0;
	public List<Piece> list;

	public void testBuilderLightningController(){
		b = new Builder();
		b.initialize();
		
		bm = new BuilderMenu(b);
		bm.setVisible(true);

		assertTrue(bm.isVisible());

		BuilderLightningController blc = new BuilderLightningController(bm,b);
		blc.actionPerformed(e);
		
		assertFalse(bm.isVisible());
	}
	
	public void testBuilderPuzzleController(){
		b = new Builder();
		b.initialize();
		
		bm = new BuilderMenu(b);
		bm.setVisible(true);

		assertTrue(bm.isVisible());
		
		BuilderPuzzleController bpc = new BuilderPuzzleController(bm,b);
		bpc.actionPerformed(e);
		
		assertFalse(bm.isVisible());
	}
	
	public void testBuilderReleaseController(){
		b = new Builder();
		b.initialize();
		
		bm = new BuilderMenu(b);
		bm.setVisible(true);

		assertTrue(bm.isVisible());
		
		BuilderReleaseController brc = new BuilderReleaseController(bm,b);
		brc.actionPerformed(e);
		
		assertFalse(bm.isVisible());
	}

}
