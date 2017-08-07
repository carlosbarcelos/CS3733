package odysseus.common.entities;

import java.util.*;

import junit.framework.TestCase;

public class TestLevel extends TestCase {
	
	/*
	 * Now hear this: When creating levels to test, make their level number -x
	 * or use a pre-made level. This way we only submit the actual levels and do
	 * not override their data when testing.
	 * ALSO make sure to delete the levl that was creatd for testing, or else Kabasuji will get confused.
	 */
	
	// Test saving and loading a level from disk
	public void testSerialize(){
		List<Piece> pieces = new ArrayList<Piece>();
		for(int i = 1; i  <= 6; i ++){
			pieces.add(new Piece(i));
		}
		Puzzle pl = new Puzzle(null, null, -1, true, pieces, 6);
		pl.saveLevel();
		
		Puzzle loadedLevel = (Puzzle) pl.loadLevel(pl.levelNumber);
		assertEquals(loadedLevel.counter.getMovesMade(), pl.counter.getMovesMade());
		
		pl.counter.update();
		pl.saveLevel();
		Puzzle loadedLevel2 = (Puzzle) pl.loadLevel(pl.levelNumber);
		
		// The base level
		assertEquals(loadedLevel.counter.getMovesMade(), 0);
		assertEquals(loadedLevel2.counter.getMovesMade(), 1);
		
		pl.deleteLevel();
	}
	
	// Test a Puzzle Level and its components
	
	
	// Test a Lightning Level and its components
	
	
	// Test a Release Level and its components
	
	// Hard code a puzzle level to play
	public void testCreateLevel(){
		// Create an unlocked level
		Board board = new Board();
		Bullpen bullpen = new Bullpen();
		List<Piece> pieces = new ArrayList<Piece>();
		Piece p;
		
		// Create the board
		/*
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 
		 */
		Square oldSquare;
		Square[][] boardSquares = board.getSquares();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				oldSquare = boardSquares[i][j+6];
				board.changeSquare(oldSquare); // Change the empty to a hint
				oldSquare = boardSquares[i][j+6];
				board.changeSquare(oldSquare); // Change the hint to a null
				
				oldSquare = boardSquares[i+6][j];
				board.changeSquare(oldSquare); // Change the empty to a hint
				oldSquare = boardSquares[i+6][j];
				board.changeSquare(oldSquare); // Change the hint to a null
				
				oldSquare = boardSquares[i+6][j+6];
				board.changeSquare(oldSquare); // Change the empty to a hint
				oldSquare = boardSquares[i+6][j+6];
				board.changeSquare(oldSquare); // Change the hint to a null
			}
		}
		
		// Fill the bullpen and the list of pieces
		p = new Piece(1);
		bullpen.add(p);
		pieces.add(p);
		
		p = new Piece(2);
		bullpen.add(p);
		pieces.add(p);
		
		p = new Piece(4);
		bullpen.add(p);
		pieces.add(p);
		
		p = new Piece(10);
		bullpen.add(p);
		pieces.add(p);
		
		p = new Piece(20);
		bullpen.add(p);
		pieces.add(p);
		
		p = new Piece(29);
		bullpen.add(p);
		pieces.add(p);		
		
		Puzzle puzzleLevel = new Puzzle(board,bullpen,1,true,pieces,5);
		puzzleLevel.saveLevel();
		
		// Create a locked level
		Board board2 = new Board();
		Bullpen bullpen2 = new Bullpen();
		List<Piece> pieces2 = new ArrayList<Piece>();
		Piece p2;
		
		// Create the board
		/*
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 1 1 1 1 1 1 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0 0 0 0 0 0
		 * 
		 */
		Square oldSquare2;
		Square[][] boardSquares2 = board2.getSquares();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				oldSquare2 = boardSquares2[i][j+6];
				board2.changeSquare(oldSquare2); // Change the empty to a hint
				oldSquare2 = boardSquares2[i][j+6];
				board2.changeSquare(oldSquare2); // Change the hint to a null
				
				oldSquare2 = boardSquares2[i+6][j];
				board2.changeSquare(oldSquare2); // Change the empty to a hint
				oldSquare2 = boardSquares2[i+6][j];
				board2.changeSquare(oldSquare2); // Change the hint to a null
				
				oldSquare2 = boardSquares2[i+6][j+6];
				board2.changeSquare(oldSquare2); // Change the empty to a hint
				oldSquare2 = boardSquares2[i+6][j+6];
				board2.changeSquare(oldSquare2); // Change the hint to a null
			}
		}
		
		// Fill the bullpen and the list of pieces
		p2 = new Piece(1);
		bullpen2.add(p2);
		pieces2.add(p2);
		
		p2 = new Piece(2);
		bullpen2.add(p2);
		pieces2.add(p2);
		
		p2 = new Piece(4);
		bullpen2.add(p2);
		pieces2.add(p2);
		
		p2 = new Piece(10);
		bullpen2.add(p2);
		pieces2.add(p2);
		
		p2 = new Piece(20);
		bullpen2.add(p2);
		pieces2.add(p2);
		
		p2 = new Piece(29);
		bullpen2.add(p2);
		pieces2.add(p2);		
		
		Puzzle puzzleLevel2 = new Puzzle(board,bullpen,2,false,pieces,5);
		puzzleLevel2.saveLevel();
	}
}
