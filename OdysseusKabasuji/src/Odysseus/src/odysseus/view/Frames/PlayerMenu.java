package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.Player;
import odysseus.view.Panels.Menu;
import odysseus.view.controller.PlayerLightningController;
import odysseus.view.controller.PlayerPuzzleController;
import odysseus.view.controller.PlayerReleaseController;
import odysseus.view.controller.RageQuitController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Player's menu allows the builder to choose a game type (Puzzle, Lightning, Release).
 * @author Kevin Valente
 *
 */
public class PlayerMenu extends JFrame {

	JPanel contentPane;
	PSplashScreen prevFrame;
	Player model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public PlayerMenu(Player model2) {
		this.model = model2;
		textField = new JTextField();
		textField.setColumns(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		Menu panel_1 = new Menu();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
				);

		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Lucida Bright", Font.BOLD, 26));
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblPlayer, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPlayer, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
						.addContainerGap())
				);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		panel_1.btnPuzzle.addActionListener(new PlayerPuzzleController(this, model));
		panel_1.btnLightning.addActionListener(new PlayerLightningController(this, model));
		panel_1.btnRelease.addActionListener(new PlayerReleaseController(this, model));
		panel_1.btnRageQuit.addActionListener(new RageQuitController(this, model));

		refresh();
	}

	/**
	 * Used to synchronize with model
	 */
	public void refresh() {
		if (model != null) {
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
	public void setPreviousFrame(PSplashScreen one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public PSplashScreen getPreviousFrame() {
		return prevFrame;
	}
}