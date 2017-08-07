package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.Player;
import odysseus.view.Panels.SplashTitle;
import odysseus.view.controller.PlayerController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;

/**
 * Initialization screen for the player.
 * @author Kevin Valente
 *
 */
public class PSplashScreen extends JFrame {

	JPanel contentPane;
	Player model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public PSplashScreen(Player p) {
		this.model = p;
		textField = new JTextField();
		textField.setColumns(10);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		SplashTitle panel = new SplashTitle();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addContainerGap())
				);

		JButton btnPlayer = new JButton("Player");
		btnPlayer.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(153)
						.addComponent(btnPlayer)
						.addContainerGap(158, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(68)
						.addComponent(btnPlayer)
						.addContainerGap(68, Short.MAX_VALUE))
				);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

		btnPlayer.addActionListener(new PlayerController(this, model));

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
	 * A simple getter.
	 * 
	 * @return The Player and all values associated with it.
	 */
	public Player getPlayer(){
		return model;
	}
}
