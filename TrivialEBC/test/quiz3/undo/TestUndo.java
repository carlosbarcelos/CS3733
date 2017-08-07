package quiz3.undo;

import quiz3.move.IMove;
import junit.framework.TestCase;

public class TestUndo extends TestCase {
	
	protected void setUp() {
		// hack
		UndoManager.instance = null;
	}
	
	protected void tearDown() {
		
	}
	
	public void testSingleton() {
		UndoManager um = UndoManager.instance();
		assertTrue (um.undoStack.isEmpty());
		
		// Anonymous class for fake move that will always succeed
		IMove im = new IMove() {

			public boolean execute() { return true; }
			public boolean undo() {	return true; }
			
		};
		
		um.recordMove(im);
		
		assertEquals (1, um.undoStack.size());
	}

	public void testSecond() {
		UndoManager um = UndoManager.instance();
		assertTrue (um.undoStack.isEmpty());
	}	
	
}
