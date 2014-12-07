import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Kelas untuk membuat jendela permainan.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 *
 */
public class Window extends JFrame {
	private static final long serialVersionUID = 7489465402626577257L;
	
	private JPanel shownPanel;
	
	/*********************************************
	 * Constructor.
	 * 
	 * @param title Judul pada jendela permainan.
	 *********************************************/
	public Window(String title)
	{
		super(title);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		shownPanel = new MainMenu();
		add(shownPanel);
	}

	/*********************************************
	 * Untuk menuju panel permainan sesungguhnya.
	 *********************************************/
	public void toGamePanel()
	{
		shownPanel.setVisible(false);
		remove(shownPanel);
		shownPanel = new GamePanel();
		add(shownPanel);
		shownPanel.setVisible(true);
	}
	
	/******************************
	 * Untuk menuju ke menu utama.
	 ******************************/
	public void toMainMenu()
	{
		shownPanel.setVisible(false);
		remove(shownPanel);
		shownPanel = new MainMenu();
		add(shownPanel);
		shownPanel.setVisible(true);
	}
	
}
