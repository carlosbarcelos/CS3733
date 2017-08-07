package odysseus.common.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Instantiate a default set of Pieces to use, based on the canonical structure.
 * 
 * All pieces are defined using clockwise polygon ordering.
 */
public class Model {
	/** Set of pieces. */
	List<Piece> set;
	
	/** Which piece is selected. */
	Piece selected = null;
	
	/** Puzzle being solved. */
	AbsLevel level;
	
	/** Placed pieces, with their coordinates. */
	List<Piece> placedPieces = new ArrayList<Piece>();
	
	/** A piece is being actively floated around (but not already on the board). Not yet in placedPieces. */
	Piece activePiece;
	
	/** A piece was on the board and is being dragged around. This piece is in placedPieces. */
	Piece draggingPiece;
	
	public Model (AbsLevel level) {
		this.level = level;
		this.set = level.bullpen.getListPiece();
	}

	/** Return the pieces in the model. */
	public List<Piece> getPieces() {
		return set;
	}
	
	/** Set which piece is 'selected'. */
	public void setSelected(Piece p) {
		this.selected = p;
	}

	/** Determines the currently selected piece. */
	public Piece getSelected() {
		return selected;
	}

	/** The puzzle being solved. */
	public void setLevel(AbsLevel l) {
		this.level = l;
	}

	/** Get puzzle. */
	public AbsLevel setLevel() {
		return level;
	}
	
	/** Return placed pieces. */
	public List<Piece> getPlacedPieces() {
		return placedPieces;
	}
	
	/** Get piece which user is 'hovering' over the board. */
	public Piece getActive() {
		return activePiece;
	}
	
	/** Set the piece that will hover over the board. */
	public void setActive(Piece pp) {
		activePiece = pp;
	}

	/** Get piece that is already on the board, but is now under control of user. */
	public Piece getDraggingPiece() {
		return activePiece;
	}
	
	/** Set the piece that is already on the board, and is now under control of user. */
	public void setDraggingPiece(Piece pp) {
		activePiece = pp;
	}
	
	/** Place piece on the board. Perhaps Puzzle should know piece placement? Decide later. */
	public void addPiece(Piece pp) {
		placedPieces.add(pp);
	}
}
