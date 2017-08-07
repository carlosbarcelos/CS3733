package odysseus.common.controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import odysseus.common.entities.Model;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Square;
import odysseus.view.Panels.BoardView;
import odysseus.view.Panels.BullpenView;

public class PieceSelectionController extends MouseAdapter implements ActionListener, MouseListener{
	BullpenView bullpenView;
	Model model;
	Piece piece;
	

	public PieceSelectionController(BullpenView bullpenView, Model model){
		this.bullpenView = bullpenView;
		this.model = model;
	}

	public Point getOffsetFromAnchor(Piece piece){
		Square topLeftSquare = piece.decodeSquare(1);
		int[] squareCoordinates = topLeftSquare.getLocation();

		return new Point(squareCoordinates[0], squareCoordinates[1]);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();  
		if(command.equals("Level 1")){
			System.out.println("worked");
		}
	}

	@Override
	public void mousePressed(MouseEvent me){
		ArrayList<Piece> pieces = bullpenView.getPieces();
		System.out.println(me.getPoint());

		// Find the index of the piece in the bullpen
		int index = findBullpenIndex(me.getPoint());
		Piece thisIsThePiece  = bullpenView.getPieces().get(index);
	
		if (model.getSelected() == null){
			model.setSelected(thisIsThePiece);
			System.out.println("Deselected Piece # " + thisIsThePiece.ID);
		}
		else {
			System.out.println("Selected Piece # " + thisIsThePiece.ID);
			model.setSelected(null);

		}

	}

	@Override
	public void mouseEntered(MouseEvent me){

	}
	@Override
	public void mouseExited(MouseEvent me){

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	// Subdivide the bullpen into a grid so that the mouseEvent can find a piece
	// 0 1 2 3
	// 4 5 6 7
	// . . . .
	public int findBullpenIndex(Point point){
		int xFactor = 0;
		int yFactor = 0;

		//Find the xFactor of the bullpenIndex
		if(point.x > 0 & point.x < 7*Square.WIDTH){
			xFactor = 0;
		} else if(point.x < 14*Square.WIDTH){
			xFactor = 1;
		} else if(point.x < 21*Square.WIDTH){
			xFactor = 2;
		} else if(point.x < 28*Square.WIDTH){
			xFactor = 3;
		} else{
			System.err.println("MousePressed :: Non-playale area.");
		}
		//Find the yFactor of the bullpenIndex
		if(point.y > 0 & point.y < 7*Square.WIDTH){
			yFactor = 0;
		} else if(point.y < 14*Square.WIDTH){
			yFactor = 4;
		} else if(point.y < 21*Square.WIDTH){
			yFactor = 8;
		} else if(point.y < 28*Square.WIDTH){
			yFactor = 12;
		} else{
			System.err.println("MousePressed :: Non-playale area.");
		}

		return xFactor + yFactor;

	}

}


