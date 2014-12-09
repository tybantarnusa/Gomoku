import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
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
	private static Listener newGame;
	private static Listener saveGame;
	private static Listener loadGame;
	private static Listener quit;
	private static Listener goToMainMenu;
	
	public abstract void actionPerformed(ActionEvent event);
	
	public static void createNewGameListener()
	{
		Main.data = new GameData(new Board(19), new Player("Hitam", Color.BLACK), new Player("Putih", Color.WHITE), 1);
		
		/**
		 * Kelas yang mengextends Listener sebagai listener
		 * untuk melakukan permainan baru.
		 * 
		 * @author Mgs. Muhammad Thoyib Antarnusa
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
				Main.window.toGamePanel();
			}
			
		}
		
		newGame = new NewGameListener();
	}
	
	/*****************************************
	 * Membuat listener untuk mengesave game.
	 * 
	 * @param data Data yang akan disave.
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
					ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("memory.sav"));
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
				} catch (IOException IOex) {
					JOptionPane.showMessageDialog(null, "Load gagal!", "Loading...", JOptionPane.ERROR_MESSAGE);
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
		class mainMenuListener extends Listener
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
		
		goToMainMenu = new mainMenuListener();
	}
		
	/************************************
	 * Mengembalikan listener new game.
	 * 
	 * @return Listener new game.
	 ************************************/
	public static Listener getNewGame() {
		return newGame;
	}

	/************************************
	 * Mengembalikan listener save game.
	 * 
	 * @return Listener save game.
	 ************************************/
	public static Listener getSaveGame() {
		return saveGame;
	}

	/************************************
	 * Mengembalikan listener load game.
	 * 
	 * @return Listener load game.
	 ************************************/
	public static Listener getLoadGame() {
		return loadGame;
	}
	
	/************************************
	 * Mengembalikan listener quit game.
	 * 
	 * @return Listener quit game.
	 ************************************/
	public static Listener getQuit() {
		return quit;
	}
	
	/****************************************************
	 * Mengembalikan listener keluar permainan saat ini.
	 * 
	 * @return Listener kembali ke menu utama.
	 ****************************************************/
	public static Listener getMainMenuListener() {
		return goToMainMenu;
	}

	/**************************************
	 * Mengeset listener save game.
	 * 
	 * @param saveGame Listener save game.
	 **************************************/
	public static void setSaveGame(Listener saveGame) {
		Listener.saveGame = saveGame;
	}

	/**************************************
	 * Mengeset listener load game.
	 * 
	 * @param loadGame Listener load game.
	 **************************************/
	public static void setLoadGame(Listener loadGame) {
		Listener.loadGame = loadGame;
	}
	
}
