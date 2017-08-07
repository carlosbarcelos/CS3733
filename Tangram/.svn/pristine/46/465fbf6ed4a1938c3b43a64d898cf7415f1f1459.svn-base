package tangram.controller;

import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tangram.model.Model;
import tangram.model.PlacedPiece;
import tangram.model.TangramPiece;
import tangram.view.TangramPiecesView;

/**
 * Determine when a piece is selected in view. Only one piece selected at a time. 
 * In this case, don't need top-level Application, just the TangramPiecesView 
 */
public class PieceSelectionController extends MouseAdapter {

	TangramPiecesView piecesView;
	Model model;
	
	public PieceSelectionController(TangramPiecesView view, Model m) {
		this.piecesView = view;
		this.model = m;
	}

	/** Determine which piece was selected in the PiecesView. */
	public void mousePressed (MouseEvent me) {
		
		// there is 1-to-1 relationship based on index, between polygons and pieces
		int idx = 0;
		for (Polygon p : piecesView.getPieces()) {
			if (p.contains(me.getPoint())) {
				// if this was already the selected piece, DE-select it
				if (model.getSelected() == model.getPieces().get(idx)) {
					model.setSelected(null);
				} else {
					TangramPiece selected = model.getPieces().get(idx);
					
					// check to make sure that it has not already been placed. If it has, do nothing
					for (PlacedPiece pp : model.getPlacedPieces()) {
						if (pp.getPiece() == selected) { 
							model.setSelected(null);
							return;
						}
					}
					model.setSelected(selected);
				}
				
				piecesView.refresh();
				return;
			}
			idx++;
		}
	}
}
