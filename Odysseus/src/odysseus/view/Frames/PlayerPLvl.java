package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Puzzle;
import odysseus.view.Panels.LvlPlay;
import odysseus.view.Panels.MoveView;
import odysseus.view.controller.PLvlExitController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 * Allows player to play a puzzle level.
 * @author Kevin Valente
 *
 */
public class PlayerPLvl extends JFrame {

	JPanel contentPane;
	PlayerLevelP prevFrame;
	Puzzle model;
	JTextField textField;

	LvlPlay panel_1 ;
	MoveView panel;


	/**
	 * Create the frame.
	 */
	public PlayerPLvl(Puzzle m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblMoves = new JLabel("Moves:");
		lblMoves.setFont(new Font("Lucida Bright", Font.PLAIN, 16));

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		panel_1 = new LvlPlay(model);

		panel = new MoveView(this);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblMoves)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
						.addComponent(btnExit))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(6)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblMoves, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);

		btnExit.addActionListener(new PLvlExitController(this, model));

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
	public void setPreviousFrame(PlayerLevelP one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public PlayerLevelP getPreviousFrame() {
		return prevFrame;
	}

	/**
	 * A simple getter.
	 * 
	 * @return The Player and all values associated with it.
	 */
	public Puzzle getPuzzle(){
		return model;
	}
}