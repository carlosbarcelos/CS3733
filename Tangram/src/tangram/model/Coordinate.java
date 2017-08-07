package tangram.model;

/**
 * Based on unit square, this reflects core coordinate for a border point of a Tangram piece.
 * 
 * Note we will have to use 'double' since the sqrt(2) eventually comes into play.
 */
public class Coordinate {
	public final double x;
	public final double y;
	
	public Coordinate (double x, double y) {
		this.x = x;
		this.y = y;
	}
	
}
