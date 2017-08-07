package odysseus.view.Panels;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Menu selects which game mode player or builder choose to go to
 */
/**
 * Template for both player and builder game type selection.
 * @author Kevin Valente
 *
 */
public class Menu extends JPanel {

	public JButton btnPuzzle;
	public JButton btnLightning;
	public JButton btnRelease;
	public JButton btnRageQuit;


	/**
	 * Create the panel.
	 */
	public Menu() {

		btnPuzzle = new JButton("Puzzle");
		btnPuzzle.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnLightning = new JButton("Lightning");
		btnLightning.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnRelease = new JButton("Release");
		btnRelease.setFont(new Font("Lucida Bright", Font.PLAIN, 18));

		btnRageQuit = new JButton("Rage Quit!");
		btnRageQuit.setFont(new Font("Lucida Bright", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap(105, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnRageQuit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLightning, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRelease, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnPuzzle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(66))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnPuzzle)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLightning)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnRelease)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnRageQuit)
						.addContainerGap(21, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}
}
