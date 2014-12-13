import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

/**
 * Kelas yang digunakan untuk membuat listener-listener
 * dari tombol-tombol yang ada.
 * 
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.10
 *
 */
public abstract class Listener implements ActionListener
{
	public static Listener newGame;
	public static Listener praNewGame;
	public static Listener saveGame;
	public static Listener loadGame;
	public static Listener quit;
	public static Listener goToMainMenu;
	public static Listener showHistory;
	
	public abstract void actionPerformed(ActionEvent event);
	
	/**********************************************
	 * Membuat listener untuk menampilkan tampilan
	 * memberikan nama pada pemain.
	 **********************************************/
	public static void createPraNewGameListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai listener
		 * untuk melakukan permainan baru (memberi nama pemain).
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 * 
		 */
		class NewGameListener extends Listener
		{
			
			/*****************************************************************
			 * Implementasi method actionPerformed untuk memberi nama pemain.
			 *****************************************************************/
			@Override
			public void actionPerformed(ActionEvent event)
			{
				Main.window.toCustomize();
			}
			
		}
		
		praNewGame = new NewGameListener();
	}
	
	/*********************************************
	 * Membuat listener untuk melakukan new game.
	 *********************************************/
	public static void createNewGameListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai listener
		 * untuk melakukan permainan baru.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * 		   Beta Tester: Dwiki Setya M.
		 * @version 2014.12.08
		 * 
		 */
		class NewGameListener extends Listener
		{
			
			/*******************************************************
			 * Implementasi method actionPerformed untuk new game.
			 *******************************************************/
			@Override
			public void actionPerformed(ActionEvent event)
			{
				String p1name;
				String p2name;
				
				try {
					/*********** Mengassign nama pemain. *************/
					if (Customization.player1.getText().equals("")) {
						p1name = "Hitam";	// Nama default.
					} else {
						p1name = Customization.player1.getText();
					}
					
					if (Customization.player2.getText().equals("")) {
						p2name = "Putih";	// Nama default.
					} else {
						p2name = Customization.player2.getText();
					}
					/*************************************************/
				} catch (NullPointerException NPEx) {
					p1name = Main.data.getPlayer1().getNama();
					p2name = Main.data.getPlayer2().getNama();
				}
				
				Main.data = new GameData(new Board(19), new Player(p1name, Color.BLACK), new Player(p2name, Color.WHITE), 1);	// Membuat data baru.
				Main.window.toGamePanel();
			}
			
		}
		
		newGame = new NewGameListener();
	}
	
	/*****************************************
	 * Membuat listener untuk mengesave game.
	 *****************************************/
	public static void createSaveGameListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai listener
		 * untuk mengesave game.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 * 
		 */
		class SaveGameListener extends Listener
		{
			
			/*******************************************************
			 * Implementasi method actionPerformed untuk mengeload.
			 *******************************************************/
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try {
					
					File file = new File("memory.sav");
					if (file.exists()) {
						int choice = JOptionPane.showConfirmDialog(null, "Sudah ada file yang tersimpan. Overwrite?", "Saving...", JOptionPane.YES_OPTION);
						if (choice == 1) return;
					}
					
					ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file));
					save.writeObject(Main.data);
					save.close();
					JOptionPane.showMessageDialog(null, "Berhasil di-save!", "Saving...", JOptionPane.PLAIN_MESSAGE);
				} catch (IOException IOEx) {
					JOptionPane.showMessageDialog(null, "Save gagal!", "Saving...", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
		saveGame = new SaveGameListener();
	}
	
	/*****************************************
	 * Membuat listener untuk mengeload game.
	 *****************************************/
	public static void createLoadGameListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai listener
		 * untuk mengeload game.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 * 
		 */
		class LoadGameListener extends Listener
		{
			
			/*******************************************************
			 * Implementasi method actionPerformed untuk mengeload.
			 *******************************************************/
			@Override
			public void actionPerformed(ActionEvent event)
			{
				try {
					ObjectInputStream load = new ObjectInputStream(new FileInputStream("memory.sav"));
					Main.data = (GameData) load.readObject();
					load.close();
					Main.window.toGamePanel();
				} catch (FileNotFoundException FNFEx) {
					JOptionPane.showMessageDialog(null, "Tidak ada save file!", "Loading...", JOptionPane.ERROR_MESSAGE);
				} catch (IOException IOex) {
					JOptionPane.showMessageDialog(null, "Save file corrupted!", "Loading...", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException CNFex) {
					JOptionPane.showMessageDialog(null, "Load gagal!", "Loading...", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		loadGame = new LoadGameListener();
	}
	
	/*******************************************
	 * Membuat listener untuk keluar dari game.
	 *******************************************/
	public static void createQuitListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai listener
		 * untuk keluar dari permainan.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 *
		 */
		class QuitListener extends Listener {
			
			/***************************************
			 * Implementasi method actionPerformed.
			 * 
			 * @param event ActionEvent.
			 ***************************************/
			@Override
			public void actionPerformed(ActionEvent event) {
				Main.window.dispatchEvent(new WindowEvent(Main.window, WindowEvent.WINDOW_CLOSING));
			}	
		}
		
		quit = new QuitListener();
	}
	
	/****************************************
	 * Membuat listener untuk ke menu utama.
	 ****************************************/
	public static void createMainMenuListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai
		 * listener untuk ke menu utama.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.08
		 * 
		 */
		class MainMenuListener extends Listener
		{
			/***************************************
			 * Implementasi method actionPerformed.
			 * 
			 * @param event ActionEvent.
			 ***************************************/
			@Override
			public void actionPerformed(ActionEvent event)
			{
				Main.window.toMainMenu();
			}
		}
		
		goToMainMenu = new MainMenuListener();
	}
	
	/*************************************************
	 * Membuat listener untuk ke memunculkan history.
	 *************************************************/
	public static void createHistoryListener()
	{
		/**
		 * Kelas yang mengextends Listener sebagai
		 * listener untuk memunculkan frame history.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
		 * @version 2014.12.10
		 * 
		 */
		class HistoryListener extends Listener
		{
			/***************************************
			 * Implementasi method actionPerformed.
			 * 
			 * @param event ActionEvent.
			 ***************************************/
			@Override
			public void actionPerformed(ActionEvent event)
			{
				Main.history.setVisible(true);
			}
		}
		
		showHistory = new HistoryListener();
	}
	
}
