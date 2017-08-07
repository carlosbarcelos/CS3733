package quiz3.controller;

import quiz3.model.Model;
import quiz3.move.IMove;
import quiz3.undo.*;
import quiz3.view.Application;

public class UndoController {
	
	Application application;
	Model model;

	public UndoController(Application application, Model model) {
		this.application = application;
		this.model = model;
	}

	public boolean process() {
		UndoManager mgr = UndoManager.instance();
		
		// see if there is anything that can be undone
		IMove m = mgr.removeLastMove();
		if (m == null) { return false; }
		
		// now complete the request, if possible, and update GUI and model
		if (!m.undo()) {
			return false;
		}
		
		// refresh GUI with new information
		application.refresh();
		return true;
	}
}
