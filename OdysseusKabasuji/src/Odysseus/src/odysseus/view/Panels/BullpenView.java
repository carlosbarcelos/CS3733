package odysseus.view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import odysseus.common.entities.*;

/**
 * Knows how to draw a bullpen.
 * @author Kevin Valente
 *
 */
public class BullpenView extends JPanel {

	AbsLevel level;
	Bullpen bullpen;

	ArrayList<Piece> piece;
	Square[][] squares2 = new Square[7][7];

	int numPieces;

	int xpos;
	int ypos;

	/**
	 * Create the panel.
	 */
	public BullpenView(AbsLevel level) {
		this.level = level;
		this.bullpen = level.bullpen;
		this.piece = bullpen.getListPiece();
		numPieces = bullpen.getNumberPieces();
	}


	/**
	 * Sets the size of the Panel. 
	 */
	public Dimension getPreferredSize() {
		return new Dimension (Square.WIDTH*7*piece.size(), Square.WIDTH*7*4);
	}

	/** Fundamental operation for drawing a square. */
	void drawSquare (Graphics g, Square square) {

		if (square == null) { return; }

		//		System.out.println("sq:" + square.getX() + "," + square.getY());
		g.setColor(Color.red);
		g.fillRect(square.getX()+(xpos*Square.WIDTH*7), square.getY()+(ypos*Square.WIDTH*7), Square.WIDTH-1, Square.WIDTH-1);
	}

	/**
	 * Draws the bullpen and any pieces within it.
	 */
	@Override
	public void paintComponent(Graphics g) {
		xpos=0;
		ypos=0;
		g.setColor(Color.ORANGE);
		g.fillRect(0,  0, getWidth(), getHeight());

		if(numPieces == 0){return;}
		else{
			try{
				for(Piece p : piece){
					squares2 = p.getSquares();
					for(int i = 1; i < squares2.length;i++){
						for(int j = 1; j < squares2.length; j++){
							try{
								if(squares2[i][j].getType().equals("filled")){
									drawSquare(g, squares2[i][j]);
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

	/**
	 * A simple getter.
	 * 
	 * @return A list of pieces currently available in the bullpen.
	 */
	public ArrayList<Piece> getPieces() {
		return piece;
	}
}
