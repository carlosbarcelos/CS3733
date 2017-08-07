package odysseus.common.controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import odysseus.common.entities.Board;
import odysseus.common.entities.Model;
import odysseus.common.entities.Piece;
import odysseus.view.Panels.BoardView;

public class MoveAndPlaceSquareController extends MouseAdapter implements ActionListener, MouseListener{
	
	BoardView boardView;
	Model model;
	
	Piece pieceBeingDragged;
	
	public MoveAndPlaceSquareController(BoardView boardView, Model model){
		this.boardView = boardView;
		this.model = model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent me){
		//if piece is selected, place it on board
		//if no piece is selected then select the one you're on
		pieceBeingDragged = model.getSelected();
		if(pieceBeingDragged == null){
			
		}
		else{
			//place piece on board
			Board board = boardView.getBoard();
			board.add(pieceBeingDragged);
			
			model.setSelected(null);
		}
		
	}
	
	public void MouseMoved(MouseEvent me){
		//MouseMoved is a thing that exists in Mouse Events
		//Basically, it tracks the location of the mouse
		//Convert the current location of the mouse to a location in the board
		//Refresh/repaint the board continuously to show dragging piece
		//If pieceBeingDragged is null, then this should not run
		Point mouseCoords = me.getPoint();
		Point boardTopLeft = boardView.getLocation();

		int xBoard = 0;
		int yBoard = 0;
		
		xBoard = mouseCoords.x - boardTopLeft.x;
		yBoard = mouseCoords.y - boardTopLeft.y;

			
		boardView.repaint();
	}
	

}
