import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Jendela riwayat pemain menaruh batu.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.10
 *
 */
public class History extends JFrame {
	private static final long serialVersionUID = 1546809816171027037L;
	
	JTextArea texts;
	
	/***************
	 * Constructor.
	 ***************/
	public History()
	{
		super("Moves History");
		this.setSize(250,350);
		this.setResizable(false);
		this.setLocation(Main.window.getX()+Main.window.getWidth()+10, Main.window.getY());
		texts = new JTextArea();
		texts.setLineWrap(true);
		texts.setWrapStyleWord(true);
		texts.setEditable(false);
		texts.setFont(new Font("Calibri", Font.BOLD, 16));
		texts.setBackground(Color.LIGHT_GRAY);
		JScrollPane pane = new JScrollPane(texts);
		
		this.add(pane);
	}
	
	/***************************************************
	 * Menambahkan langkah yang dilakukan pada riwayat.
	 * 
	 * @param player Pemain yang melakukan langkah.
	 * @param koordinat Menaruh pada koordinat sekian.
	 ***************************************************/
	public void add(Player player, String koordinat)
	{
		texts.append(player.getNama() + " meletakkan pada (" + koordinat + ")\n");
	}
	
	/*******************************************
	 * Menghapus keseluruhan riwayat permainan.
	 *******************************************/
	public void clear()
	{
		texts.setText("");
	}
}
