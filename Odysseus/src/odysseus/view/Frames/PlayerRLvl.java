package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Release;
import odysseus.view.Panels.LvlPlay;
import odysseus.view.controller.PRLvlExitController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;

/**
 * Allows player to build a release level.
 * @author Kevin Valente
 *
 */
public class PlayerRLvl extends JFrame {

	JPanel contentPane;
	PlayerLevelR prevFrame;
	public Release model;
	JTextField textField;


	/**
	 * Create the frame.
	 */
	public PlayerRLvl(Release m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		
		LvlPlay panel_1 = new LvlPlay(model);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblScore)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
							.addComponent(btnExit)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblScore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(btnExit))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		btnExit.addActionListener(new PRLvlExitController(this, model));

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
	public void setPreviousFrame(PlayerLevelR one) {
		prevFrame = one;
	}

	/**
	 * Allows anyone to see the prevFrame without allowing them to modify it 
	 * @return the prevFrame and all values associated with it
	 */
	public PlayerLevelR getPreviousFrame() {
		return prevFrame;
	}
}