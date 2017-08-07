package tangram.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Instantiate a default set of Tangrams to use, based on the canonical structure.
 * 
 * All pieces are defined using clockwise polygon ordering
 */
public class Model {
	/** Set of tangram pieces. */
	List<TangramPiece> set;
	
	/** Which piece is selected. */
	TangramPiece selected = null;
	
	/** Puzzle being solved. */
	Puzzle puzzle;
	
	/** Placed pieces, with their coordinates. */
	List<PlacedPiece> placedPieces = new ArrayList<PlacedPiece>();
	
	/** A piece is being actively floated around (but not already on the board). Not yet in placedPieces. */
	PlacedPiece activePiece;
	
	/** A piece was on the board and is being dragged around. This piece is in placedPieces. */
	PlacedPiece draggingPiece;
	
	public Model () {
		TangramPiece p1, p2, p3, p4, p5, p6, p7;
		
		// define 10 coordinates used for all pieces.
		Coordinate c0 = new Coordinate(0,    0);
		Coordinate c1 = new Coordinate(1,    0);
		Coordinate c2 = new Coordinate(0.25, 0.25);
		Coordinate c3 = new Coordinate(0,    0.5);
		Coordinate c4 = new Coordinate(0.5,  0.5);
		Coordinate c5 = new Coordinate(0.25 ,0.75);
		Coordinate c6 = new Coordinate(0.75, 0.75);
		Coordinate c7 = new Coordinate(0,    1);
		Coordinate c8 = new Coordinate(0.5,  1);
		Coordinate c9 = new Coordinate(1,    1);
		
		// now define the seven pieces
		p1 = new TangramPiece(new Coordinate[] { c0, c1, c4 }    , new Coordinate(0.5, 0.25));
		p2 = new TangramPiece(new Coordinate[] { c0, c2, c5, c3} , new Coordinate(0.125, 0.275));
		p3 = new TangramPiece(new Coordinate[] { c2, c4, c5 }    , new Coordinate(0.275, 0.5));
		p4 = new TangramPiece(new Coordinate[] { c1, c9, c4 }    , new Coordinate(0.75, 0.5));
		p5 = new TangramPiece(new Coordinate[] { c3, c8, c7 }    , new Coordinate(0.125, 0.875));
		p6 = new TangramPiece(new Coordinate[] { c4, c6, c8, c5 }, new Coordinate(0.5, 0.75));
		p7 = new TangramPiece(new Coordinate[] { c6, c9, c8 }    , new Coordinate(0.75, 0.875));
		
		// add to specific set
		set = new ArrayList<TangramPiece>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p5);
		set.add(p6);
		set.add(p7);
		
		// Needed for this quick example to start with specific shape.
		float T= (float) Math.sqrt(2);
		Coordinate[] coords = new Coordinate[] {
				new Coordinate(0.75      ,0), 
				new Coordinate(1         ,0.25),
				new Coordinate(1.25      ,0),
				new Coordinate(1.25      ,0.5),
				new Coordinate(1.5       ,0.25),				
				new Coordinate(2         ,0.75),
				new Coordinate(0.5+3*T/4, 0.75),
				new Coordinate(0.5+T/2   ,0.75+T/4),
				new Coordinate(0.5+T/4   ,0.75+T/4),
				new Coordinate(0.5       ,0.75),
				new Coordinate(0         ,0.75),
				new Coordinate(0.5       ,0.25),
				new Coordinate(0.75      ,0.5),
		};
		
		this.puzzle = new Puzzle(coords);
	}

	/** Return the pieces in the model. */
	public List<TangramPiece> getPieces() {
		return set;
	}
	
	/** Set which piece is 'selected'. */
	public void setSelected(TangramPiece p) {
		this.selected = p;
	}

	/** Determines the currently selected piece. */
	public TangramPiece getSelected() {
		return selected;
	}

	/** The puzzle being solved. */
	public void setPuzzle(Puzzle p) {
		this.puzzle = p;
	}

	/** Get puzzle. */
	public Puzzle getPuzzle() {
		return puzzle;
	}
	
	/** Return placed pieces. */
	public List<PlacedPiece> getPlacedPieces() {
		return placedPieces;
	}
	
	/** Get piece which user is 'hovering' over the board. */
	public PlacedPiece getActive() {
		return activePiece;
	}
	
	/** Set the piece that will hover over the board. */
	public void setActive(PlacedPiece pp) {
		activePiece = pp;
	}

	/** Get piece that is already on the board, but is now under control of user. */
	public PlacedPiece getDraggingPiece() {
		return activePiece;
	}
	
	/** Set the piece that is already on the board, and is now under control of user. */
	public void setDraggingPiece(PlacedPiece pp) {
		activePiece = pp;
	}
	
	/** Place piece on the board. Perhaps Puzzle should know piece placement? Decide later. */
	public void addPiece(PlacedPiece pp) {
		placedPieces.add(pp);
	}
}
