package odysseus.view.Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import odysseus.common.controllers.MoveAndPlaceSquareController;
import odysseus.common.controllers.PieceSelectionController;
import odysseus.common.entities.AbsLevel;
import odysseus.common.entities.Model;
import odysseus.common.entities.Square;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Template for playing a game.
 * 
 * Includes board and bullpen.
 * @author valente
 *
 */
public class LvlPlay extends JPanel {

	BoardView panel_1;
	BullpenView panel;
	Square[][] square = new Square[12][12];	

	/**
	 * Create the panel.
	 */
	public LvlPlay(AbsLevel level) {
		Model model = new Model(level);

		panel_1 = new BoardView(level, false);
		panel_1.setBackground(Color.GREEN);

		//panel.addMouseListener(new PieceSelectionController(panel, new Model(level)));


		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 438, Short.MAX_VALUE))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		panel = new BullpenView(level);
		scrollPane.setViewportView(panel);
		panel.setBackground(Color.MAGENTA);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 438, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 88, Short.MAX_VALUE)
				);
		panel.setLayout(gl_panel);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 444, Short.MAX_VALUE)
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 182, Short.MAX_VALUE)
				);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);

		panel.addMouseListener(new PieceSelectionController(panel, model));
		panel_1.addMouseListener(new MoveAndPlaceSquareController(panel_1, model));
	}



	public BoardView getBoardView(){
		return panel_1;
	}

	public BullpenView getBullpenView(){
		return panel;
	}
	
	private Point getBoardTopLeft(){
		return panel_1.getLocation();
	}

}
