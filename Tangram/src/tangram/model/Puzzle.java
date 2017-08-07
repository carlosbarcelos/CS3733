package tangram.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Initial puzzle has border coordinates.
 * 
 * Note: This one is hard-coded, since I am trying to get this done as quickly as possible.
 * 
 * Coordinates are clockwise with upper left point being first.
 */
public class Puzzle implements Iterable<Coordinate> {
	/** store points */ 
	ArrayList<Coordinate> polygon = new ArrayList<Coordinate>();;

	/**
	 * Puzzle constructed from points. 
	 * @param points
	 */
	public Puzzle(Coordinate[] points) {
		for (Coordinate c : points) {
			polygon.add(c);
		}

		polygon.add(points[0]);
	}

	/** Expose points in order. */
	@Override
	public Iterator<Coordinate> iterator() {
		return polygon.iterator();
	}

	/** Number of points in polygon. */
	public int size() {
		return polygon.size();
	}
}
