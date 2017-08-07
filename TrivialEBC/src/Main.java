import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.QuitController;

import view.Application;
import model.Model;

public class Main {
	public static void main(String[] args) {

		// create model first
		Model m = new Model();
		m.setTitle("Please Set Title.");

		// then launch application 
		final Application app = new Application (m);

		// state how to deal with leaving
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (new QuitController().confirm(app)) {
					app.dispose();
				}
			}      
		});

		app.setVisible(true);
	}
}
