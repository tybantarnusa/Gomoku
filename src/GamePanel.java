import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Kelas GUI dari permainan gomoku sesungguhnya.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.08
 *
 */
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1552746400473185110L;

	/***************
	 * Constructor.
	 ***************/
	public GamePanel() {
		super(new BorderLayout());
		add(new BoardGUI(Main.data.getBoard()), BorderLayout.CENTER);
		add(new GameMenu(), BorderLayout.SOUTH);
	}
}

/**
 * Kelas yang membuat GUI dari papan permainan.
 * 
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.10
 * 
 */
class BoardGUI extends JPanel {
	private static final long serialVersionUID = -844054677852447437L;

	private Board board;
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

			protected final int X;
			protected final int Y;
			
			private boolean filled;
			private Player player;			
			
			/***************
			 * Constructor.
			 ***************/
			public Grid(int x, int y)
			{
				super();
				
				this.X = x;
				this.Y = y;
				
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
			public void fill(Player player)
			{
				this.player = player;
				filled = true;
			}
						
			/******************************************
			 * Mengembalikan pemain yang ada di petak.
			 *
			 * @return Pemain yang ada di petak.
			 ******************************************/
			public Player getPlayer()
			{
				return player;
			}
		}
		
		/**
		 * Kelas yang merepresentasikan batu dari permainan gomoku.
		 * 
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 *
		 */
		class Stone extends JComponent
		{
			private static final long serialVersionUID = 5671889580515372544L;

			private Grid grid;
			
			/********************************
			 * Constructor.
			 * 
			 * @param grid Petak pada papan.
			 ********************************/
			public Stone(Grid grid)
			{
				this.grid = grid;
			}
			
			/*******************************
			 * Menggambarkan lingkaran.
			 * 
			 * @param g Parameter graphics.
			 *******************************/
			public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setPaint(grid.getPlayer().getColor());
				
				double DIAMETER = grid.getWidth()/2+4;
				g2.fill(new Ellipse2D.Double(1.5,0,DIAMETER,DIAMETER));
			}
		}
		
		/**
		 * Kelas untuk tiap kotak-kotak pada papan permainan
		 * untuk tempat menaruh batu permainan.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 *
		 */
		class GomokuButton implements ActionListener
		{
			Grid grid;
		
			/*********************
			 * Constructor.
			 * 
			 * @param grid Petak.
			 *********************/
			public GomokuButton(Grid grid)
			{
				this.grid = grid;
			}
			
			/***************************************
			 * Implementasi method actionPerformed.
			 * Fungsi utama permainan.
			 * 
			 * @param event ActionEvent.
			 ***************************************/
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!grid.isFilled()) {
					grid.fill(Main.data.getCurrentPlayer());
					grid.add(new Stone(grid));
					
					final String KOORDINAT = (grid.X+1) + "," + (grid.Y+1);
					Main.data.getBoard().putPlayer(Main.data.getCurrentPlayer(), KOORDINAT);
					Main.data.getBoard().cetak();	// DEBUG
					
					grid.revalidate();
					
					if (Engine.checkWin(Main.data.getBoard(), Main.data.getCurrentPlayer())) {
						JOptionPane.showMessageDialog(null, "Selamat! " + Main.data.getCurrentPlayer().getNama() + " menang dalam " + Main.data.getTurns() + " giliran!", "SELAMAT!", JOptionPane.INFORMATION_MESSAGE);
						Main.window.toMainMenu();
					}
					
					// Mengganti pemain tiap turn.
					if (Main.data.getTurns() % 2 == 0) {
						Main.data.setCurrentPlayer(Main.data.getPlayer1());
					} else {
						Main.data.setCurrentPlayer(Main.data.getPlayer2());
					}
					
					Main.data.setTurns(Main.data.getTurns()+1);
				} else {
					System.out.println("Kotak sudah terisi.");
				}
			}
			
		}
		
		/********** MEMBUAT PETAK-PETAK PAPAN **********/
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Grid grid = new Grid(i, j);
				
				if ((j-i) % 2 == 0) {
					grid.setBackground(Color.LIGHT_GRAY);
				} else {
					grid.setBackground(Color.GRAY);
				}
				
				grid.setMargin(new Insets(0,0,0,0));
				grid.addActionListener(new GomokuButton(grid));
				
				if (Main.data.getBoard().isFilled((i+1)+","+(j+1)))
				{
					grid.fill(Main.data.getBoard().getPlayerAt(i, j));
					grid.add(new Stone(grid));
				}
				
				add(grid);
			}
		}
		/************************************************/
	}

	/*********************************
	 * Mengembalikan papan permainan.
	 * 
	 * @return Papan permainan.
	 *********************************/
	public Board getBoard() {
		return board;
	}

	/********************************
	 * Mengeset papan permainan.
	 * 
	 * @param board Papan permainan.
	 ********************************/
	public void setBoard(Board board) {
		this.board = board;
	}
}

/**
 * Kelas yang digunakan untuk membuat menu
 * yang berada di bagian bawah permainan.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.10
 *
 */
class GameMenu extends JPanel
{
	private static final long serialVersionUID = -6479713536202156821L;

	JPanel features;
	JButton exitGame;
	
	/***************
	 * Constructor.
	 ***************/
	public GameMenu()
	{
		super(new BorderLayout());	
		features = new JPanel(new GridLayout(1,2));
		
		makeFeatureButtons();
		makeExitGame();
		
		add(features, BorderLayout.WEST);
		add(exitGame, BorderLayout.EAST);
	}
	
	/*******************************
	 * Membuat tombol-tombol fitur.
	 *******************************/
	private void makeFeatureButtons()
	{
		JButton saveGame = new JButton("SAVE GAME");
		JButton showHistory = new JButton("HISTORY");
		
		Listener.createSaveGameListener();
		saveGame.addActionListener(Listener.getSaveGame());
		
		features.add(saveGame);
		features.add(showHistory);
	}
	
	/****************************************
	 * Membuat tombol keluar dari permainan.
	 ****************************************/
	private void makeExitGame()
	{
		exitGame = new JButton("TO MAIN MENU");
		Listener.createMainMenuListener();
		exitGame.addActionListener(Listener.getMainMenuListener());
	}
}