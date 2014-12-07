import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Kelas GUI dari permainan gomoku sesungguhnya.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 *
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1552746400473185110L;

	public GamePanel() {
		super(new BorderLayout());
		add(new BoardGUI(Main.data.getBoard()), BorderLayout.CENTER);
		add(new GameMenu(), BorderLayout.SOUTH);
	}
}

class BoardGUI extends JPanel {
	private static final long serialVersionUID = -844054677852447437L;

	private int size;
	
	/********************************
	 * Constructor.
	 * 
	 * @param board Papan permainan.
	 ********************************/
	public BoardGUI(Board board) {
		super();
		this.size = board.getBaris();
		
		setLayout(new GridLayout(size, size));
		createGrid();
	}
	
	/********************************************
	 * Membuat tempat-tempat yang bisa digunakan
	 * untuk menaruh batu untuk dimainkan.
	 ********************************************/
	private void createGrid() {
		
		/**
		 * Kelas yang mengextends JButton sebagai tempat
		 * menaruh batu untuk dimainkan.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.07
		 *
		 */
		class Grid extends JButton
		{
			private static final long serialVersionUID = -167434286535250663L;

			private boolean filled;
			
			/***************
			 * Constructor.
			 ***************/
			public Grid()
			{
				super();
				filled = false;
			}
			
			/**************************************
			 * Mengembalikan nilai boolean filled.
			 * 
			 * @return Apakah petak sudah terisi.
			 **************************************/
			public boolean isFilled()
			{
				return filled;
			}
			
			/*****************
			 * Mengisi petak.
			 *****************/
			public void fill()
			{
				filled = true;
			}
		}
		
		/********* MEMBUAT PETAK-PETAK PAPAN **********/
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Grid grid = new Grid();
				grid.addActionListener(null);
				add(grid);
			}
		}
		/**********************************************/
	}
}

class GameMenu extends JPanel
{
	JPanel features;
	JButton exitGame;
	
	public GameMenu()
	{
		super(new BorderLayout());	
		features = new JPanel(new GridLayout(1,2));
		
		makeFeatureButtons();
		makeExitGame();
		
		add(features, BorderLayout.WEST);
		add(exitGame, BorderLayout.EAST);
	}
	
	private void makeFeatureButtons()
	{
		JButton saveGame = new JButton("SAVE GAME");
		JButton showHistory = new JButton("HISTORY");
		
		saveGame.addActionListener(Listener.getSaveGame());
		
		features.add(saveGame);
		features.add(showHistory);
	}
	
	private void makeExitGame()
	{
		exitGame = new JButton("EXIT GAME");
	}
}