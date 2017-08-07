package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Puzzle;
import odysseus.view.Panels.LvlMaker;
import odysseus.view.controller.BLvlExitController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 * Allows builder to design a puzzle level.
 * @author Kevin Valente
 *
 */
public class BuilderPLvl extends JFrame {

	JPanel contentPane;
	BuilderMenu prevFrame;
	Puzzle model;
	JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public BuilderPLvl(Puzzle m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 903);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblSetMove = new JLabel("Set Move:");
		lblSetMove.setFont(new Font("Lucida Bright", Font.BOLD, 16));

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		LvlMaker panel_1 = new LvlMaker(model);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		textField_1.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
										.addGap(6))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblSetMove)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
										.addComponent(btnExit))))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSetMove)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);

		btnExit.addActionListener(new BLvlExitController(this, model));

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
	public void setPreviousFrame(BuilderMenu one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public BuilderMenu getPreviousFrame() {
		return prevFrame;
	}
}