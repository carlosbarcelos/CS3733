package tangram.model;

import java.awt.Point;
import java.awt.Polygon;

/** 
 * Records the placement of a Tangram piece on the board with associated polygon.
 * 
 * Note that this polygon may in fact be rotated and is in a specific coordinate 
 * system, not just the [0,1] unit square in which Tangram pieces were defined.
 * 
 * This class acts as a bridge between the abstract realm (a tangram piece) and the
 * physical realm (pixels in a GUI).
 */
public class PlacedPiece {
	
	TangramPiece piece;
	Polygon polygon;
	
	public PlacedPiece (TangramPiece tp, Polygon p) {
		this.piece = tp;
		this.polygon = p;
	}
	
	public boolean contains (Point p) {
		return polygon.contains(p);
	}
	
	public Polygon getPolygon() {
		return polygon;
	}
	
	public TangramPiece getPiece() {
		return piece;
	}

	/** Used when rotating piece. */
	public void setPolygon(Polygon poly) {
		polygon = poly;
	}
}
