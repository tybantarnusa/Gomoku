import java.awt.Color;

/**
 * Kelas utama dari permainan gomoku.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.08
 * 
 */
public class Main {
	
	static Window window = new Window("Gomoku by Thoyib Antarnusa");
	static GameData data = new GameData(new Board(19), new Player("Hitam", Color.BLACK), new Player("Putih", Color.WHITE), 1);
	
	/******************************
	 * Method main.
	 * 
	 * @param args Parameter args.
	 ******************************/
	public static void main(String[] args) throws Exception {
		window.setVisible(true);
	}
}
