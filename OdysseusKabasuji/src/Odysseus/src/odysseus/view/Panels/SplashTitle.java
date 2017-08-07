package odysseus.view.Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Template for the SplashScreen.
 * 
 * Contains the name of the game and the team that made it.
 * @author Kevin Valente
 *
 */
public class SplashTitle extends JPanel {

	/**
	 * Create the panel.
	 */
	public SplashTitle() {
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		
		JLabel lblByTeamOdysseus = new JLabel("by Team Odysseus");
		lblByTeamOdysseus.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		lblByTeamOdysseus.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblByTeamOdysseus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
						.addComponent(lblKabasuji, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKabasuji)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblByTeamOdysseus)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
