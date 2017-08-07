package odysseus.view.Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import odysseus.common.entities.AbsLevel;
import odysseus.common.entities.Board;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Square;

/**
 * Knows how to draw board which is composed of squares.
 * @author Kevin Valente
 *
 */

public class BoardView extends JPanel {

	AbsLevel level;
	Board board;

	boolean isBuilder;

	Square[][] squares = new Square[12][12];

	ArrayList<Piece> piece;
	Square[][] squares2 = new Square[7][7];


	/**
	 * Create the panel.
	 */
	public BoardView(AbsLevel level, boolean isBuilder) {
		super();

		this.level = level;
		this.isBuilder = isBuilder;
		this.board = level.board;
		this.squares = board.getSquares();
	}

	/** Fundamental operation for drawing a square. */
	void drawSquare (Graphics g, Square square) {

		if (square == null) { return; }

		//		System.out.println("sq:" + square.getX() + "," + square.getY());
		if(square.getType().equals("null")){
			g.setColor(Color.white);
		}
		else if(square.getType().equals("empty")){
			g.setColor(Color.cyan);
		}
		else if(square.getType().equals("hint")){
			g.setColor(Color.GREEN);
		}
		else if(square.getType().equals("filled")){
			g.setColor(Color.red);
		}
		g.fillRect(square.getX(), square.getY(), Square.WIDTH-1, Square.WIDTH-1);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int numPieces = board.getPieces().size();

		g.setColor(Color.white);
		g.fillRect(0,  0, getWidth(), getHeight());

		// where you grab pieces from the board.
		if(isBuilder){
			for(int i = 0; i < squares.length; i++){
				for(int j = 0; j < squares[i].length; j++) {
					drawSquare (g, squares[i][j]);
				}		
			}
		}

		else{
			for(int i = 0; i < squares.length; i++){
				for(int j = 0; j < squares[i].length; j++) {
					if(squares[i][j].getType() != "null"){
						drawSquare (g, squares[i][j]);
					}
				}		
			}
		}
		if(numPieces == 0){return;}
		else{
			for(Piece p : piece){
				squares2 = p.getSquares();
				for(int i = 1; i < squares2[i].length;i++){
					for(int j = 1; j < squares2[j].length; j++){
						if(squares2[i][j].getType().equals("filled")){
							drawSquare(g, squares2[i][j]);
						}
					}
				}

			}
		}
	}

	/**
	 * A simple getter.
	 * 
	 * @return The board and all of its associated values.
	 */
	public Board getBoard() {
		return board;
	}
}
