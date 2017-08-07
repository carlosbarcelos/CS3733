package odysseus.view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import odysseus.common.entities.AbsLevel;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Square;

/**
 * Makes a panel were all the pieces are stored.
 * @author Kevin Valente
 *
 */
public class PieceSelectorView extends JPanel {

	AbsLevel level;
	Piece[] p = new Piece[35];
	Square[][] squares = new Square[7][7];

	int xpos;
	int ypos;
	/**
	 * Create the panel.
	 */
	public PieceSelectorView(AbsLevel level) {
		this.level = level;
	}

	/**
	 * Sets the size of the Panel. 
	 */
	public Dimension getPreferredSize() {
		return new Dimension (Square.WIDTH*7*p.length, Square.WIDTH*7*4);
	}

	/** Fundamental operation for drawing a square. */
	void drawSquare (Graphics g, Square square) {

		if (square == null) { return; }

		//		System.out.println("sq:" + square.getX() + "," + square.getY());
		g.setColor(Color.red);
		g.fillRect(square.getX()+(xpos*Square.WIDTH*7), square.getY()+(ypos*Square.WIDTH*7), Square.WIDTH-1, Square.WIDTH-1);
	}

	/**
	 * Draws the Piece Selector with all 35 pieces
	 */
	public void paintComponent(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0,  0, getWidth(), getHeight());

		for(int i = 0; i < 35; i++){
			p[i] = new Piece(i+1);
		}
		try{
			for(Piece p2 : p){
				squares = p2.getSquares();
				for(int i = 1; i < squares.length;i++){
					for(int j = 1; j < squares.length; j++){
						try{
							if(squares[i][j].getType().equals("filled")){
								drawSquare(g, squares[i][j]);
							}
						} catch(NullPointerException e){}
					}
				}
				if(xpos == 3){
					xpos=0;
					ypos++;
				}
				else{
					xpos++;
				}
			}

		}catch (NullPointerException e){}
	}
}
