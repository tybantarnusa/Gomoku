import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Kelas GUI dari menu utama permainan.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 *
 */
public class MainMenu extends JPanel {
	private static final long serialVersionUID = -3088890058631223710L;

	/***************
	 * Constructor.
	 ***************/
	public MainMenu()
	{
		super();
		setLayout(new GridLayout(3,1));
	
		add(new TitleText());
		add(new NavigationButtons());
	}
	
}

/**
 * Kelas untuk menggambar string judul game.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 * 
 */
class TitleText extends JComponent {	
	private static final long serialVersionUID = -4765517702009806737L;

	/************************************
	 * Agar bisa digambarkan pada frame.
	 * 
	 * @param g Parameter graphics.
	 ************************************/
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.DARK_GRAY);
		
		g2.setFont(new Font("Calibri", Font.BOLD, 51));
		g2.drawString("FIVE IN A ROW", 90,80);
		
		g2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		g2.drawString("Thoyib Antarnusa (c) 2014", 135, 100);
	}
}

/**
 * Kelas untuk membuat tombol-tombol navigasi yang
 * ada pada menu utama.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 * 
 */
class NavigationButtons extends JPanel {
	private static final long serialVersionUID = -4120532055629577048L;

	private JButton newGame;
	private JButton loadGame;
	private JButton exitGame;
	
	public NavigationButtons()
	{
		super();
		setLayout(new GridLayout(3,1));
		
		/************** MEMBUAT TOMBOL-TOMBOL *****************/
		newGame = new JButton("NEW GAME");
		loadGame = new JButton("LOAD GAME");
		exitGame = new JButton("EXIT");
		
		Listener.createNewGameListener();
		Listener.createLoadGameListener();
	
		newGame.addActionListener(Listener.getNewGame());
		loadGame.addActionListener(Listener.getLoadGame());
		/******************************************************/
		
		add(newGame);
		add(loadGame);
		add(exitGame);
	}
}