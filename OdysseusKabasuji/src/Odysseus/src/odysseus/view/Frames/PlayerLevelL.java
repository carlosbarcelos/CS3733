package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.common.entities.Lightning;
import odysseus.view.Panels.SelectLevel;
import odysseus.view.controller.PLBackController;
import odysseus.view.controller.PlayerLLvlController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Player's level select for the lightning level.
 * @author Kevin Valente
 *
 */
public class PlayerLevelL extends JFrame {

	JPanel contentPane;
	PlayerMenu prevFrame;
	public Lightning model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public PlayerLevelL(Lightning m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setFont(new Font("Lucida Bright", Font.BOLD, 28));
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);

		SelectLevel panel = new SelectLevel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblLightning, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
		
		panel.btnBack.addActionListener(new PLBackController(this, model));
		panel.btnLevel.addActionListener(new PlayerLLvlController(this, model,1));
		panel.btnLevel_1.addActionListener(new PlayerLLvlController(this, model,2));
		panel.btnLevel_2.addActionListener(new PlayerLLvlController(this, model,3));
		panel.btnLevel_3.addActionListener(new PlayerLLvlController(this, model,4));
		panel.btnLevel_4.addActionListener(new PlayerLLvlController(this, model,5));

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