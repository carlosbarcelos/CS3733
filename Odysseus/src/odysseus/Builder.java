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
import odysseus.view.Frames.BSplashScreen;

/**
 * Kabasuji the Builder's side.
 * 
 * @author Kevin Valente
 */
public class Builder extends Kabasuji {

	/** IMPORTANT NOTE: These entities should ONLY be changed in the Window Builder*/ 
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

		levelP = new Puzzle(board, bullpen, 0, false, null, 0);
		levelL = new Lightning(board, bullpen, 0, false, null, time);
		levelR = new Release(board, bullpen, 0, false, null);

		levelP.setValue(17);
		levelL.setValue(17);
		levelR.setValue(17);
	}

	/**
	 * Allows access to Builder related stuff. 
	 */
	@Override
	public boolean isBuilder(){
		return true;
	}

	// This is the executable to access the builder section of the Kabasuji Game
	public static void main(String[] args) {

		Builder b = new Builder();
		b.initialize();
		b.launch(b);
	}

	void launch (Builder b) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSplashScreen ssb = new BSplashScreen(b);
					ssb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
