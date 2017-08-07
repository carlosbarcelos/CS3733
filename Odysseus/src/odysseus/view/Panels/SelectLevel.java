package odysseus.view.Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * Template used for both player and builder level select.
 * @author Kevin Valente
 *
 */
public class SelectLevel extends JPanel {
	public JButton btnLevel;
	public JButton btnLevel_1;
	public JButton btnLevel_2;
	public JButton btnLevel_3;
	public JButton btnLevel_4;
	public JButton btnBack;

	/**
	 * Create the panel.
	 */
	public SelectLevel() {

		btnLevel = new JButton("Level 1");
		btnLevel.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		
		btnLevel_1 = new JButton("Level 2");
		btnLevel_1.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnLevel_2 = new JButton("Level 3");
		btnLevel_2.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnLevel_3 = new JButton("Level 4");
		btnLevel_3.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnLevel_4 = new JButton("Level 5");
		btnLevel_4.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		JLabel lblEasy = new JLabel("Easy");
		lblEasy.setFont(new Font("Lucida Bright", Font.BOLD, 20));

		JLabel lblHard = new JLabel("Hard");
		lblHard.setFont(new Font("Lucida Bright", Font.BOLD, 20));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.WHITE);

		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.WHITE);
		panel_4.setBackground(Color.WHITE);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(29)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblEasy)
												.addComponent(lblHard))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLevel_4)
														.addGap(18)
														.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLevel_3)
														.addGap(18)
														.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLevel_2)
														.addGap(18)
														.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLevel_1)
														.addGap(18)
														.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLevel)
														.addGap(18)
														.addComponent(panel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnBack)))
						.addContainerGap(52, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnLevel_1)
										.addComponent(lblEasy))
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_2)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLevel_3)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnLevel_4)
										.addComponent(lblHard)))
						.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
						.addComponent(btnBack)
						.addContainerGap())
				);
		setLayout(groupLayout);

	}
}


