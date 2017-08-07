package quiz3.controller;

import java.awt.*;
import java.awt.event.*;

import quiz3.view.*;
import quiz3.model.*;

public class ProcessControlZController implements KeyEventDispatcher {
	
	Application application;
	Model model;
	boolean ready = true;
	
	public ProcessControlZController(Application app, Model m) {
		this.application = app;
		this.model = m;				
	}
	
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.isControlDown() && e.getKeyCode() == 'z') {
			if (ready) {
				if (!new UndoController(application, model).process()) {
					return false;
				} else {
					ready = false;
					
					e.consume();
					return true;
				}
			} else if (e.getModifiers() == KeyEvent.KEY_RELEASED) {
				ready = true;
			}
		}

		return false;
	}
}
