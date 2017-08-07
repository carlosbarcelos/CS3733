package odysseus.view.Frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import odysseus.Builder;
import odysseus.common.entities.AbsLevel;
import odysseus.view.Panels.SplashTitle;
import odysseus.view.controller.BuilderController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;

/**
 * Initialization screen for the builder.
 * @author Kevin Valente
 *
 */
public class BSplashScreen extends JFrame {

	JPanel contentPane;
	Builder model;
	JTextField textField;

	/**
	 * Create the frame.
	 */
	public BSplashScreen(Builder m) {
		this.model = m;
		textField = new JTextField();
		textField.setColumns(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		SplashTitle panel = new SplashTitle();

		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
				);

		JButton btnBuilder = new JButton("Builder");
		btnBuilder.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(156)
						.addComponent(btnBuilder)
						.addContainerGap(185, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
						.addContainerGap(58, Short.MAX_VALUE)
						.addComponent(btnBuilder)
						.addGap(55))
				);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		btnBuilder.addActionListener(new BuilderController(this, model));

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
	 * @return The Builder and all of its associated values.
	 */
	public Builder getBuilder(){
		return model;
	}
}