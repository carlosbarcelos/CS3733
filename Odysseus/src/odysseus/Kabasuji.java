package odysseus;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Stack;

import javax.swing.JFrame;

import odysseus.common.controllers.*;
import odysseus.common.entities.*;

/**
 * Kabasuji is the super class to both Builder and Player. The Kabasuji class
 * is responsible for the container and doing and undoing moves.
 * 
 * @author Carlos Barcelos
 *
 */
abstract public class Kabasuji {
	protected Stack<Move> moves = new Stack<Move>();
	protected ArrayList<AbsLevel> puzzleLevels = new ArrayList<AbsLevel>();
	protected ArrayList<AbsLevel> lightningLevels = new ArrayList<AbsLevel>();
	protected ArrayList<AbsLevel> releaseLevels = new ArrayList<AbsLevel>();
	
	public Kabasuji(){
		initalize();
	}
	
	/**
	 * Initalize all of the levels that are currently on disk. Run through each file system
	 * and add particular levels to a particular level array.
	 */
	public void initalize(){
		File[] puzzleFiles = new File("src/odysseus/leveldata/Puzzle").listFiles();
		File[] lightningFiles = new File("src/odysseus/leveldata/Lightning").listFiles();
		File[] releaseFiles = new File("src/odysseus/leveldata/Release").listFiles();
		AbsLevel l = null;
		
		int cnt = 1;
		for(File f : puzzleFiles){
			if(f.isFile()){
				l  = new Puzzle(null,null,1,true,null,1); // Give the level somthing to override
				puzzleLevels.add(l.loadLevel(cnt++));
			}
		}
		cnt = 1;
		for(File f : lightningFiles){
			if(f.isFile()){
				l  = new Lightning(null,null,1,true,null,(long)10); // Give the level somthing to override
				lightningLevels.add(l.loadLevel(cnt++));
			}
		}
		cnt = 1;
		for(File f : releaseFiles){
			if(f.isFile()){
				l  = new Release(null,null,1,true,null); // Give the level somthing to override
				releaseLevels.add(l.loadLevel(cnt++));
			}
		}
	}
	
	/**
	 * Return the full history of moves made within the game.
	 */
	public Enumeration<Move> getMoves(){
		return moves.elements();
	}
	
	/**
	 * Return, and remove, the most recent move made.
	 */
	public Move popMove(){
		// No moves to remove
		if(moves.isEmpty()){
			return null;
		}
		
		return moves.pop();
	}
	
	/**
	 * Push the most recent move onto the stack of existing moves.
	 * 
	 * @return True - Confirm that the move was successfully added.
	 */
	public boolean pushMove(Move m){
		moves.push(m);
		return true;
	}
	
	/**
	 * Returns true if the game mode is currently Builder.
	 */
	public boolean isBuilder(){
		return false;
	}
	
	/**
	 * Call a pre-loaded level to play from Kabasuji
	 * 
	 * @param i - The number of the level that is requested.
	 * @return puzzleLevel - The level to play.
	 */
	public Puzzle getPuzzle(int i){
		try{
			return (Puzzle) puzzleLevels.get(i);
		} catch(NullPointerException n){
			System.err.printf("Puzzle Level %d does not exist.", i);
			return null;
		}
	}
	
	/**
	 * Call a pre-loaded level to play from Kabasuji
	 * 
	 * @param i - The number of the level that is requested.
	 * @return releaseLevel - The level to play.
	 */
	public Release getRelease(int i){
		try{
			return (Release) releaseLevels.get(i);
		} catch(NullPointerException n){
			System.err.printf("Release Level %d does not exist.", i);
			return null;
		}
	}
	
	/**
	 * Call a pre-loaded level to play from Kabasuji
	 * 
	 * @param i - The number of the level that is requested.
	 * @return lightningLevel - The level to play.
	 */
	public Lightning getLightning(int i){
		try{
			return (Lightning) lightningLevels.get(i);
		} catch(NullPointerException n){
			System.err.printf("Lightning Level %d does not exist.", i);
			return null;
		}
	}
	
}
