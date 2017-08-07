package tangram.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Individual Tangram piece, based on (0,0) - (1,1) square.
 * 
 * This piece is an abstract concept, using fractional coordinates of 1/4, 1/2 and 3/4
 * to define each position.
 * 
 * While I'm sure it could be computed, I need the "center" for each piece. This is to be
 * the anchor point when dragging or rotating the piece. Any center will do, actually.
 * 
 * Anchor point is first one.
 */
public class TangramPiece implements Iterable<Coordinate> {
	/** store points */ 
	ArrayList<Coordinate> polygon = new ArrayList<Coordinate>();
	
	/** Center point. */
	final Coordinate center;
	
	/** 
	 * Construct Tangram piece based on array of border coordinates assumed to be in order.
	 * Polygon is closed from last point to first point. 
	 * 
	 * Note that the points[] array contains all unique points. We close the polygon here.
	 */
	public TangramPiece(Coordinate[] points, Coordinate center) {
		for (Coordinate c : points) {
			polygon.add(c);
		}
		
		// close the loop
		polygon.add(points[0]);
		this.center = center;
	}

	@Override
	public Iterator<Coordinate> iterator() {
		return polygon.iterator();
	}	
	
	/** Return number of points in polygon. */
	public int size() {
		return polygon.size();
	}
	
	/** 
	 * If you are going to use in hashtable, must have hashcode method. Note doesn't have to 
	 * guarantee uniqueness, but if two pieces are same then they have same hashcode.
	 * 
	 * We are not overriding equals(Object o) because we choose to use == as comparison.
	 */
	public int hashCode() {
		return polygon.size();
	}

	/** Get center point. */
	public Coordinate getCenter() {
		return center;
	}
}
