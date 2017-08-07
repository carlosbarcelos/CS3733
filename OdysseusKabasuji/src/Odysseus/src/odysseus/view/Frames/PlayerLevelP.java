package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Puzzle;
import odysseus.view.Frames.PlayerMenu;
import odysseus.view.Panels.SelectLevel;
import odysseus.view.controller.PPBackController;
import odysseus.view.controller.PlayerLvlController;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Player's level select for the puzzle level.
 * @author Kevin Valente
 *
 */
public class PlayerLevelP extends JFrame {

	JPanel contentPane;
	PlayerMenu prevFrame;
	public Puzzle model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public PlayerLevelP(Puzzle m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		SelectLevel panel_1 = new SelectLevel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
						.addContainerGap())
				);

		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setFont(new Font("Lucida Bright", Font.BOLD, 28));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPuzzle, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPuzzle, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addContainerGap())
				);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		panel_1.btnBack.addActionListener(new PPBackController(this, model));
		panel_1.btnLevel.addActionListener(new PlayerLvlController(this, model,1));
		panel_1.btnLevel_1.addActionListener(new PlayerLvlController(this, model,2));
		panel_1.btnLevel_2.addActionListener(new PlayerLvlController(this, model,3));
		panel_1.btnLevel_3.addActionListener(new PlayerLvlController(this, model,4));
		panel_1.btnLevel_4.addActionListener(new PlayerLvlController(this, model,5));

		// sync
		refresh();
	}

	/**
	 * Used to synchronize with model
	 */
	public void refresh() {
		if (model != null) {
			textField.setText("" + model.getValue());
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
	public void setPreviousFrame(PlayerMenu one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public PlayerMenu getPreviousFrame() {
		return prevFrame;
	}
}