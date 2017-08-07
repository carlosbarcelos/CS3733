package odysseus.view.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import odysseus.view.Frames.PlayerPLvl;

/**
 * Allows a player to see how many moves he/she can make.
 * @author Kevin Valente
 *
 */
public class MoveView extends JPanel {

	PlayerPLvl ppl;

	/** Font for this widget [default = 48 point, Plain, Dialog].  */
	protected Font font = new Font ("Dialog", Font.PLAIN, 48);

	public MoveView() {
		this(null);
	}

	/**
	 * Create the panel.
	 */
	public MoveView(PlayerPLvl ppl) {
		super();
		this.ppl = ppl;
		setSize(100, 80);
	}

	/**
	 * Sets the size of the Panel.
	 */
	public Dimension getPreferredSize() {
		return new Dimension (100, 80);
	}

	/**
	 * Draws the number of moves a player has mad and the number of moves a player can make.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String s = Integer.toString(ppl.getPuzzle().counter.getMovesMade());
//		String s2 = Integer.toString(ppl.getPuzzle().counter.getNumMoves());
//		String s3 = ("/" +s + s2);
		//		String s = Integer.toString(5);
		g.setColor(Color.yellow);
		g.fillRect(0, 0, getWidth(), getHeight());

		//g.setFont(font);
		g.setColor(Color.black);
		g.drawString(s, 20, 20);

	}

}
