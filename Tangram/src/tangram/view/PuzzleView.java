package tangram.view;

import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

import tangram.model.*;

/**
 * Here is where the pieces are to be played (in 512x512 size). 
 */
public class PuzzleView extends JPanel {

	/** Core model. */
	Model model;
	
	/** around edges. */
	int offset = 32;
	
	/** Base size of puzzle. */
	public final int N = 256;   // can be 512 to see scrolling...
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;

	/** Color mapping. Could also be used within TangramPiecesView but for now keep here. */
	Hashtable<TangramPiece,Color> colorMapping = new Hashtable<TangramPiece,Color>();
	
	/** Only here so we can safely open within WindowBuilder. */
	PuzzleView() {
		model = new Model();
	}
	
	/** Given a set of Tangram pieces, draw them in this panel. */
	public PuzzleView(Application app, Model model) {
		this.model = model;
		
		// initially allocate random color with each piece
		Random rand = new Random();
		for (TangramPiece p : model.getPieces()) {
			Color randomColor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
			colorMapping.put(p, randomColor);
		}
	}
	

	/** 
	 * Swing thing. We must be large enough to draw all tangram pieces. 
	 */
	@Override
	public Dimension getMinimumSize() {
		int width = 2*N + 2*offset;
		int height = 2*N + 2*offset;

		return new Dimension (width, height);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Tangram pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = 2*N + 2*offset;
		int height = 2*N + 2*offset;
		
		return new Dimension (width, height);
	}


	/**
	 * Draw background puzzle and all active pieces.
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
		
		// double check if no model (for WindowBuilder)
		if (model == null) { return; }
		
		// draw active polygon.
		PlacedPiece active = model.getActive();
		if (active != null) {
			g.setColor(colorMapping.get(active.getPiece()));
			g.fillPolygon(active.getPolygon());
		}
	}
	
	/** Helper method to return polygon for tangram piece anchored at (x,y). */
	public Polygon computePolygon(int x, int y, Puzzle p) {
		int[] xpoints = new int[p.size()];
		int[] ypoints = new int[p.size()];

		// convert coordinate sequence into (x,y) points.
		int idx = 0;
		for (Coordinate c : p) {
			xpoints[idx] = (int) (x + N*c.x);
			ypoints[idx] = (int) (y + N*c.y);
			idx++;
		}

		return new Polygon(xpoints, ypoints, p.size());
	}
	
	/** 
	 * Helper method to return polygon for tangram piece anchored at (x,y). 
	 *
	 * Appropriate that this method be in View since it is responsible for
	 * mapping abstract pieces into pixel locations.
	 */
	public Polygon computePolygon(int x, int y, TangramPiece tp) {
		int[] xpoints = new int[tp.size()];
		int[] ypoints = new int[tp.size()];

		// convert coordinate sequence into (x,y) points.
		int idx = 0;
		for (Coordinate c : tp) {
			xpoints[idx] = (int) (x + N*c.x);
			ypoints[idx] = (int) (y + N*c.y);
			idx++;
		}

		return new Polygon(xpoints, ypoints, tp.size());
	}

	/** Draw background and then all pieces on top of it. */
	public void redraw() {
		// Once created, draw each, with buffer.
		int x = offset;
		int y = offset;
		
		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);
		
		Puzzle p = model.getPuzzle();
		Polygon polyshape = computePolygon (x, y, p);
		offScreenGraphics.setColor(Color.black);
		offScreenGraphics.fillPolygon(polyshape);
		
		// placed pieces.
		if (model.getPlacedPieces() != null) {
			for (PlacedPiece pp : model.getPlacedPieces()) {
				if (pp != model.getDraggingPiece()) {
					offScreenGraphics.setColor(colorMapping.get(pp.getPiece()));
					offScreenGraphics.fillPolygon(pp.getPolygon());
				}
			}
		}		
	}

}
