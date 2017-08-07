package odysseus.view.Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;

import odysseus.common.entities.AbsLevel;

import javax.swing.JScrollPane;
import javax.swing.JButton;

/**
 * Template for Building a game.
 * 
 * Includes board, bullpen, and a scrollable window that shows 
 * all the pieces that can be used to create the level.
 * 
 * @author Kevin Valente
 *
 */
public class LvlMaker extends JPanel {

	BoardView panel_1;
	BullpenView panel;
	PieceSelectorView panel_2;

	/**
	 * Create the panel.
	 */
	public LvlMaker(AbsLevel level) {

		panel_1 = new BoardView(level, true);
		panel_1.setBackground(Color.GREEN);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Lucida Bright", Font.BOLD, 18));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSave)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnSave))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
					.addContainerGap())
		);

		panel = new BullpenView(level);
		scrollPane_1.setViewportView(panel);
		panel.setBackground(Color.MAGENTA);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 448, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 88, Short.MAX_VALUE)
				);
		panel.setLayout(gl_panel);

		 panel_2 = new PieceSelectorView(level);
		panel_2.setBackground(Color.CYAN);
		scrollPane.setViewportView(panel_2);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 121, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 348, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 478, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 298, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);

	}
	
	/**
	 * A simple getter
	 * @return
	 */
	public BoardView getBoardView(){
		return panel_1;
	}
	
	public BullpenView getBullpenView(){
		return panel;
	}
	
	public PieceSelectorView getPieceSelectorView(){
		return panel_2;
	}
}
