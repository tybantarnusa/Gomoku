import java.io.Serializable;

/**
 * Kelas yang digunakan sebagai penyimpanan data
 * yang digunakan pada permainan.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.06
 *
 */
public class GameData implements Serializable {
	private static final long serialVersionUID = 3004475260201699023L;
	
	private Board board;
	private Player currentPlayer;
	private Player player1;
	private Player player2;
	private int turns;
	
	/******************************************************************
	 * Constructor dengan lima parameter.
	 * 
	 * @param currentPlayer Pemain yang sedang jalan.
	 * @param player1 Pemain pertama.
	 * @param player2 Pemain kedua.
	 * @param turns Jumlah langkah yang telah terjadi dalam permainan.
	 ******************************************************************/
	public GameData(Board board, Player currentPlayer, Player player1, Player player2, int turns)
	{
		this.board = board;
		this.currentPlayer = currentPlayer;
		this.player1 = player1;
		this.player2 = player2;
		this.turns = turns;
	}
	
	/******************************************************************
	 * Constructor dengan empat parameter.
	 * 
	 * @param player1 Pemain pertama.
	 * @param player2 Pemain kedua.
	 * @param turns Jumlah langkah yang telah terjadi dalam permainan.
	 ******************************************************************/
	public GameData(Board board, Player player1, Player player2, int turns)
	{
		this.board = board;
		this.currentPlayer = player1;
		this.player1 = player1;
		this.player2 = player2;
		this.turns = turns;
	}
	
	/*********************************
	 * Mengembalikan papan permainan.
	 * 
	 * @return Papan permainan.
	 *********************************/
	public Board getBoard() {
		return board;
	}

	/******************************************************
	 * Mengembalikan pemain yang sedang berjalan saat ini.
	 * 
	 * @return Pemain yang sedang berjalan saat ini.
	 ******************************************************/
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/********************************
	 * Mengembalikan pemain pertama.
	 * 
	 * @return Pemain pertama.
	 ********************************/
	public Player getPlayer1() {
		return player1;
	}

	/******************************
	 * Mengembalikan pemain kedua.
	 * 
	 * @return Pemain kedua.
	 ******************************/
	public Player getPlayer2() {
		return player2;
	}

	/*****************************************************
	 * Mengembalikan jumlah langkah yang telah dilakukan.
	 * 
	 * @return Jumlah langkah yang telah dilakukan.
	 *****************************************************/
	public int getTurns() {
		return turns;
	}

	/*************************************************************
	 * Mengeset data pemain yang sedang berjalan saat ini.
	 * 
	 * @param currentPlayer Pemain yang sedang berjalan saat ini.
	 *************************************************************/
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/*********************************
	 * Mengeset pemain pertama.
	 * 
	 * @param player1 Pemain pertama.
	 *********************************/
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/*******************************
	 * Mengeset pemain kedua.
	 * 
	 * @param player2 Pemain kedua.
	 *******************************/
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	/************************************************
	 * Mengeset jumlah langkah yang telah dilakukan.
	 * 
	 * @param turns Jumlah langkah.
	 ************************************************/
	public void setTurns(int turns) {
		this.turns = turns;
	}

}
