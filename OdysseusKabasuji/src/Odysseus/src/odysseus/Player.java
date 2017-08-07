package odysseus;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import odysseus.common.entities.Board;
import odysseus.common.entities.Bullpen;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.common.entities.Release;
import odysseus.view.Frames.PSplashScreen;

/**
 * Kabatsuji on the Player's side.
 * 
 * @author Kevin Valente
 *
 */
public class Player extends Kabasuji {
	public Puzzle levelP;
	public Lightning levelL;
	public Release levelR;

	public Board board;
	public Bullpen bullpen;

	public ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	public ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	public long time = 0;
	public List<Piece> list;

	/**
	 * Basic initialize.
	 * 
	 *Eventually gets overwritten with actual level data.
	 */
	public void initialize(){
		board = new Board();
		bullpen = new Bullpen(bullpenPieces);

		levelP = new Puzzle(board, bullpen, 0, false, list, 0);
		levelL= new Lightning(board, bullpen, 0, false, null, time);
		levelR = new Release(board, bullpen, 0, false, null);

		levelP.setValue(17);
		levelL.setValue(17);
		levelR.setValue(17);
	}

	/**
	 * Denies access to Builder related stuff. 
	 */
	@Override
	public boolean isBuilder(){
		return false;
	}

	// This is the executable to access the builder section of the Kabasuji Game
	public static void main(String[] args) {

		Player p = new Player();
		p.initialize();
		p.launch(p);
	}

	void launch (Player p) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSplashScreen ssp = new PSplashScreen(p);
					ssp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

