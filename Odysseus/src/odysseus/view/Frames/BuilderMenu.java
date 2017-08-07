package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.Builder;
import odysseus.common.entities.AbsLevel;
import odysseus.view.Panels.Menu;
import odysseus.view.controller.BuilderLightningController;
import odysseus.view.controller.BuilderPuzzleController;
import odysseus.view.controller.BuilderReleaseController;
import odysseus.view.controller.NoMoreController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Builder's menu allows the builder to choose a game type (Puzzle, Lightning, Release).
 * @author Kevin Valente
 *
 */
public class BuilderMenu extends JFrame {

	JPanel contentPane;
	BSplashScreen prevFrame;
	Builder model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public BuilderMenu(Builder model2) {
		this.model = model2;
		textField = new JTextField();
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Menu panel = new Menu();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(48)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		JLabel lblBuilder = new JLabel("Builder");
		lblBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuilder.setFont(new Font("Lucida Bright", Font.BOLD, 30));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblBuilder, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblBuilder, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
						.addContainerGap())
				);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		
		panel.btnRageQuit.addActionListener(new NoMoreController(this, model));
		panel.btnPuzzle.addActionListener(new BuilderPuzzleController(this, model));
		panel.btnLightning.addActionListener(new BuilderLightningController(this, model));
		panel.btnRelease.addActionListener(new BuilderReleaseController(this, model));
		
		refresh();
	}

	/**
	 * Used to synchronize with model
	 */
	public void refresh() {
		if (model.levelL != null) {
			textField.setText("" + model.levelL.getValue());
		}
	}

	/**
	 * Allows anyone to see JTextField without allowing them to modify it 
	 * @return textField and all values associated with it
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Sets the JFrame used before this one. This allows the
	 * application to open up the previous JFrame when called.
	 * @param one JFrame to be set as prevFrame
	 */
	public void setPreviousFrame(BSplashScreen one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public BSplashScreen getPreviousFrame() {
		return prevFrame;
	}
}
