package tangram.controller;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.util.Iterator;

import tangram.model.*;
import tangram.view.*;

/**
 * Ensures:
 * 
 * If selected piece in model then MouseMove follows that piece here. Piece is drawn
 * always relative to its center.
 * 
 * When mouse pressed inside *AND* no selected piece, then we can move that piece around.
 */
public class PuzzleController extends MouseAdapter {

	PuzzleView puzzleView;
	TangramPiecesView tangramView;
	Model model;

	PlacedPiece draggingPiece;
	Point draggingAnchor;

	// while mouse controller is in play, remember rotation (hey, just for fun).
	int rotation = 0;

	public PuzzleController(Application app, Model m) {
		this.puzzleView = app.getPuzzleView();
		this.tangramView = app.getTangramView();
		this.model = m;
	}

	// could be in the model. Subtract from coordinates when translating.
	Point getOffsetFromAnchor(TangramPiece piece) {
		Iterator<Coordinate> it = piece.iterator();
		Coordinate anchor = it.next();

		return new Point ((int)(puzzleView.N*anchor.x), (int)(puzzleView.N*anchor.y));
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// clear rotation state back to normal
		rotation = 0;
	}

	/** Once released, no more dragging. */
	public void mouseReleased(MouseEvent me) {
		draggingPiece = null;
		draggingAnchor = null;
	}

	@Override
	public void mouseExited(MouseEvent me) {
		if (draggingPiece != null) {
			
			// piece is no longer on the board, so remove it!
			model.getPlacedPieces().remove(draggingPiece);
			draggingPiece = null;
			draggingAnchor = null;
		}
		
		// clear the view of partial drawings once mouse exits region
		model.setActive(null);
		
		tangramView.refresh();   // Only necessary if one draws available pieces differently.
		tangramView.repaint();
		
		puzzleView.redraw();     // fix board as well
		puzzleView.repaint();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent me) {
		// piece is hovering but not yet on the board. 
		if ((me.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) == 0) {
			rotation += me.getWheelRotation();

			// no piece currently selected. Nothing to do.
			TangramPiece selected = model.getSelected();
			if (selected == null) {
				return;
			}

			Polygon p = computeActivePolygon(me.getPoint(), model.getSelected());
			PlacedPiece pp = new PlacedPiece(model.getSelected(), p);
			model.setActive(pp);
			puzzleView.repaint();
		} else if ((me.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) == (1 << 10)) {
			// rotating piece that was found on the board. Sanity check just in case...
			if (draggingPiece != null) {
				// Since we are physically altering the polygon of the dragged piece, we only need
				// + or - 1 for the rotation.
				if (me.getWheelRotation() < 0) {
					rotation = -1;
				} else { rotation = 1; }
				
				Polygon poly = draggingPiece.getPolygon();
				Point pt = me.getPoint();
				
				poly = rotatePolygon(poly, draggingPiece.getPiece(), rotation, (int) pt.getX(), (int) pt.getY());
				draggingPiece.setPolygon(poly);
				puzzleView.redraw();
				puzzleView.repaint();
			}
		}
	}

	@Override
	public void mouseMoved (MouseEvent me) {
		TangramPiece selected = model.getSelected();
		if (selected == null) { return; }

		Polygon p = computeActivePolygon(me.getPoint(), model.getSelected());
		PlacedPiece pp = new PlacedPiece(model.getSelected(), p);
		model.setActive(pp);
		puzzleView.repaint();
	}

	@Override
	public void mouseDragged (MouseEvent me) {
		// if nothing being dragged, leave
		if (draggingPiece == null) {
			return;
		}

		int diffX = me.getPoint().x - draggingAnchor.x;
		int diffY = me.getPoint().y - draggingAnchor.y;
		draggingAnchor = me.getPoint();

		draggingPiece.getPolygon().translate(diffX, diffY);
		puzzleView.redraw();
		puzzleView.repaint();
	}


	/** Determine which piece was selected in the PiecesView. */
	public void mousePressed (MouseEvent me) {
		PlacedPiece pp = model.getActive();
		if (pp == null) {
			draggingAnchor = me.getPoint();

			// perhaps we are pressing inside one of the existing pieces? Take LAST piece that
			// intersects, since that will ensure we grab topmost one.
			for (PlacedPiece exist : model.getPlacedPieces()) {
				if (exist.contains(draggingAnchor)) {
					// perhaps we will be dragging this one. Keep going until last one chosen.
					draggingPiece = exist;
				}
			}
			return;
		}

		model.setActive(null);    // no longer being dragged around
		model.setSelected(null);

		model.addPiece(pp);

		puzzleView.redraw();   // has changed state
		tangramView.refresh();  // has changed state

		puzzleView.repaint();
		tangramView.repaint();   // has also changed state since piece no longer selected.
	}

	/**
	 * Given a piece, returns polygon reflecting the rotation.
	 * 
	 */
	Polygon computeActivePolygon(Point pt, TangramPiece selected) {
		if (selected == null) {
			return null;
		}
		Point offset = getOffsetFromAnchor(selected);
		Polygon poly = puzzleView.computePolygon((int)pt.getX()-offset.x, (int)pt.getY()-offset.y, selected);

		int centerx = (int) (pt.getX() + puzzleView.N*selected.getCenter().x - offset.x);
		int centery = (int) (pt.getY() + puzzleView.N*selected.getCenter().y - offset.y);
		
		return rotatePolygon(poly, selected, rotation, centerx, centery);
	}
	
	/**
	 * Given the piece associated with specific Polygon, rotate based on (centerx, centery) and 
	 * rotation angle.
	 */
	Polygon rotatePolygon(Polygon poly, TangramPiece piece, int angle, int centerx, int centery) {
		// The following came from a google search for rotating a polygon. Nifty.
		// note we use center of piece as rotation point, computed from the coordinate

		PathIterator pi = poly.getPathIterator(AffineTransform.getRotateInstance(Math.toRadians(angle*3), centerx, centery));

		float coords[] = new float[6];
		int xpoints[] = new int[piece.size()];
		int ypoints[] = new int[piece.size()];

		int idx = 0;
		while (!pi.isDone()) {
			int type = pi.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO || type == PathIterator.SEG_LINETO) {
				xpoints[idx] = (int) coords[0];
				ypoints[idx] = (int) coords[1];
				idx++;
			}
			pi.next();
		}

		return new Polygon(xpoints, ypoints, piece.size());
	}
}
