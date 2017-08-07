package tangram.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tangram.model.*;

/**
 * Shows all Tangram pieces in single panel, meant to be scrolled over.
 * 
 * Each piece is shows in its normal orientation, assuming squareSize pixels for square length
 * 
 * Drawn so center is in middle of unit square
 */
public class TangramPiecesView extends JPanel {

	/** Model. */
	Model model;
	
	/** Pieces to be drawn. */
	List<TangramPiece> set;

	/** Actual polygons that were drawn. */
	List<Polygon> pieces;

	/** Size of each square. */
	public final int squareSize = 64;

	/** Buffer for between and around pieces. */
	public final int offset = 4;

	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;

	/** Given a set of Tangram pieces, draw them in this panel. */
	public TangramPiecesView(Model model) {
		this.model = model;
		this.set = model.getPieces();
	}

	/** Retrieve polygon shapes drawn in this view. */
	public List<Polygon> getPieces() {
		return pieces;
	}

	/** 
	 * Swing thing. We must be large enough to draw all tangram pieces. 
	 */
	@Override
	public Dimension getMinimumSize() {
		int width = squareSize + 2*offset;
		int height = 2*offset + set.size()*(squareSize+offset);

		return new Dimension (width, height);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Tangram pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = squareSize + 2*offset;
		int height = 2*offset + set.size()*(squareSize+offset);

		return new Dimension (width, height);
	}

	/**
	 * Draw each piece vertically
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

			redraw();
		}

		// if no offscreenImage, then Swing hasn't fully initialized; leave now
		if (offScreenImage == null) {
			System.err.println("Swing not ready for drawing.");
			return;
		}

		// copy image into place.
		g.drawImage(offScreenImage, 0, 0, this);
	}

	/** Helper method to return polygon for tangram piece anchored at (x,y). */
	Polygon computePolygon(int x, int y, TangramPiece p) {
		int[] xpoints = new int[p.size()];
		int[] ypoints = new int[p.size()];

		// convert coordinate sequence into (x,y) points.
		int idx = 0;
		for (Coordinate c : p) {
			xpoints[idx] = (int) (x + squareSize*c.x);
			ypoints[idx] = (int) (y + squareSize*c.y);
			idx++;
		}

		return new Polygon(xpoints, ypoints, p.size());
	}

	/**
	 * Purpose of this method is to redraw image in the face of changes to the pieces.
	 * In our case, this only means whether a piece is selected or not. 
	 * 
	 */
	public void refresh() {
		redraw();
		repaint();
	}

	/** Redraws all pieces into offscreen image, offset by center point. */
	void redraw() {
		// Once created, draw each, with buffer.
		int x = offset;
		int y = offset;
		
		pieces = new ArrayList<Polygon>();
		for (TangramPiece piece : set) {
			Polygon polyshape = computePolygon (x, y, piece);
			
			if (piece == model.getSelected()) {
				offScreenGraphics.setColor(Color.red);
			} else {
				// if already on board then show in gray
				boolean played = false;
				for (PlacedPiece pp : model.getPlacedPieces()) {
					if (pp.getPiece() == piece) {
						played = true;
						break;
					}
				}
				if (played) {
					offScreenGraphics.setColor(Color.gray);	
				} else {
					offScreenGraphics.setColor(Color.black);
				}
			}
			
			offScreenGraphics.fillPolygon(polyshape);
			pieces.add(polyshape);

			// draw pieces vertically down 
			y += squareSize + offset;
		}
	}

}
