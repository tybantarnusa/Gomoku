import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Kelas untuk GUI pengaturan permainan.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.10
 * 
 */
public class Customization extends JPanel {
	private static final long serialVersionUID = -4301473403833330241L;
	
	public static JTextField player1;
	public static JTextField player2;
	
	/******************************************
	 * Constructor sekaligus membuat panelnya.
	 ******************************************/
	public Customization()
	{
		super();
		setLayout(new GridLayout(9,1));
	
		JPanel header = new JPanel();
		header.add(new JLabel("Pemain"));
		
		JPanel custom = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new GridLayout(1,2));
		
		JPanel name = new JPanel(new GridLayout(1,2));
		name.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Nama Pemain"));
		
		JPanel player1name = new JPanel();
		player1name.add(new JLabel("Player 1: "));
		player1 = new JTextField(10);
		player1name.add(player1);
		
		JPanel player2name = new JPanel();
		player2name.add(new JLabel("Player 2: "));
		player2 = new JTextField(10);
		player2name.add(player2);
		
		name.add(player1name);
		name.add(player2name);
		custom.add(name, BorderLayout.NORTH);
				
		JButton start = new JButton("START");
		Listener.createNewGameListener();
		start.addActionListener(Listener.newGame);
		JButton mainMenu = new JButton("MAIN MENU");
		Listener.createMainMenuListener();
		mainMenu.addActionListener(Listener.goToMainMenu);
		
		buttons.add(start);
		buttons.add(mainMenu);
		
		add(header, BorderLayout.SOUTH);
		add(new JPanel());
		add(custom, BorderLayout.CENTER);
		add(new JPanel());
		add(buttons);
	}
}
