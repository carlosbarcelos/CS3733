package odysseus.common.entities;

import java.util.*;


import junit.framework.TestCase;
import odysseus.*;
import odysseus.common.controllers.BullpenToBoardMove;

public class TestPuzzle extends TestCase {
	Kabasuji game = new Player();
	Puzzle puzzleLevel1; // A normal puzzleLevel, given pieces
	Puzzle puzzleLevel2; // What if a puzzleLevel is not given pieces?
	Board board = new Board();
	Bullpen bullpen = new Bullpen();
	List<Piece> pieces = new ArrayList<Piece>();


	public void setUp(){
		for(int i = 1; i <=5; i++){
			pieces.add(new Piece(i));
		}
		for(Piece p : pieces){
			bullpen.add(p);
		}
		puzzleLevel1 = new Puzzle(board, bullpen, 1, true, pieces, 0);
		puzzleLevel2 = new Puzzle(board, bullpen, 2, false, null, 3);

	}

	// No pieces can be placed after the move limit is met
	public void testPuzzleLevel(){
		// Make as many moves as there are pieces
		BullpenToBoardMove btb;
		int cnt = bullpen.getNumberPieces();
		ArrayList<Piece> bullpenPieces = bullpen.getListPiece();
		for(int i = 0; i < cnt; i++){
			Piece target = bullpenPieces.get(0);
			btb = new BullpenToBoardMove(bullpen,board,target,puzzleLevel1.counter);
			assertTrue(btb.valid(game));
			assertTrue(btb.doMove(game));
			assertEquals(puzzleLevel1.counter.getMovesMade(), i + 1);
			if(puzzleLevel1.bullpen.getNumberPieces() <= 2){
				assertEquals(puzzleLevel1.starsEarned(), 3 - puzzleLevel1.bullpen.getNumberPieces());
			}
		}


		// Test that a move can not be made after the move limit has been met (isOver)
		btb = new BullpenToBoardMove(bullpen,board,null,puzzleLevel1.counter);
		assertFalse(btb.doMove(game));

		// Appropriate star ranking
		assertEquals(puzzleLevel1.starsEarned(), 3);
		assertTrue(puzzleLevel1.isOver());
	}
}

