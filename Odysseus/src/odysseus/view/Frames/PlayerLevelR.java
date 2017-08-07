package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Release;
import odysseus.view.Panels.SelectLevel;
import odysseus.view.controller.PRBackController;
import odysseus.view.controller.PlayerRLvlController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Player's level select for release level. 
 * @author Kevin Valente
 *
 */
public class PlayerLevelR extends JFrame {

	JPanel contentPane;
	PlayerMenu prevFrame;
	public Release model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public PlayerLevelR(Release m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setFont(new Font("Lucida Bright", Font.BOLD, 28));
		
		SelectLevel panel = new SelectLevel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRelease, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		panel.btnBack.addActionListener(new PRBackController(this, model));
		panel.btnLevel.addActionListener(new PlayerRLvlController(this, model,1));
		panel.btnLevel_1.addActionListener(new PlayerRLvlController(this, model,2));
		panel.btnLevel_2.addActionListener(new PlayerRLvlController(this, model,3));
		panel.btnLevel_3.addActionListener(new PlayerRLvlController(this, model,4));
		panel.btnLevel_4.addActionListener(new PlayerRLvlController(this, model,5));

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