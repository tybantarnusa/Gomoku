import java.io.Serializable;

/**
 * Kelas berikut digunakan untuk merepresentasikan
 * objek papan permainan gomoku.
 *
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 *
 */

public class Board implements Serializable
{
	private static final long serialVersionUID = -4578591166367315049L;
	
	private int baris;
	private int kolom;
	
	private int[] lastPut;
	
	private Player arrayPapan[][];
	
	/***************************************
	 * Constructor
	 *
	 * @param ukuran Ukuran papan permainan.
	 ***************************************/
	public Board(int ukuran)
	{
		baris = ukuran;
		kolom = ukuran;
		arrayPapan = new Player[baris][kolom];
		lastPut = new int[2];
	}
	
	/******************************************
	 * Mencetak gambaran antarmuka papan ke
	 * command prompt atau terminal.
	 ******************************************/
	public void cetak()
	{
		for (int i = 0; i < baris; i++) {
			System.out.printf("%2d: ", i+1);
			for (int j = 0; j < kolom; j++) {
				if (arrayPapan[i][j] != null) {
					System.out.print(arrayPapan[i][j].getNama());
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	
	/************************************************
	 * Mengambil koordinat x dari input yang
	 * berbentuk "x,y".
	 * 
	 * @param koordinat Input berbentuk string "x,y".
	 * @return Koordinat x bertipe integer yang
	 * 		   sesungguhnya.
	 ************************************************/
	public int coordinateX(String koordinat)
	{
		String[] XY = koordinat.split("[ ,]");
		return Integer.parseInt(XY[0])-1;
	}
	
	/************************************************
	 * Mengambil koordinat y dari input yang
	 * berbentuk "x,y".
	 * 
	 * @param koordinat Input berbentuk string "x,y".
	 * @return Koordinat y bertipe integer yang
	 * 		   sesungguhnya.
	 ************************************************/
	public int coordinateY(String koordinat)
	{
		String[] XY = koordinat.split("[ ,]");
		return Integer.parseInt(XY[1])-1;
	}
	
	/***********************************************
	 * Memeriksa apakah papan pada koordinat
	 * (x,y) sudah terisi atau belum.
	 * 
	 * @param koordinat Koordinat dari papan yang
	 * 					ingin diperiksa.
	 * @return Apakah papan pada koordinat tersebut
	 * 		   sudah terisi.
	 * *********************************************/
	public boolean isFilled(String koordinat)
	{
		int x = coordinateX(koordinat);
		int y = coordinateY(koordinat);
		
		// Apabila papan pada koordinat (x,y) belum terisi
		if (arrayPapan[x][y] == null) {
	
			return false;
	
		// Apabila papan pada koordinat (x,y) sudah terisi
		} else {
	
			return true;
	
		}
	}
	
	/**************************************************
	 * Menaruh bidak salah satu pemain ke dalam papan
	 * permainan.
	 *
	 * @param warna Warna pemain yang ingin diletakkan
	 *		pada papan permainan.
	 * @param koordinat Koordinat dimana warna pemain
	 *		    diletakkan pada papan.
	 **************************************************/
	public void putPlayer(Player warna, String koordinat)
	{
		int x = coordinateX(koordinat);
		int y = coordinateY(koordinat);
		
		lastPut[0] = x;
		lastPut[1] = y;
		
		arrayPapan[x][y] = warna;
	}
	
	/*********************************************
	 * Untuk mengambil apa yang ada pada koordinat
	 * (x,y) pada papan baik berupa pemain atau kosong.
	 *
	 * @param x Koordinat x pada papan.
	 * @param y Koordinat y pada papan.
	 * @return Isi pada papan di koordinat (x,y).
	 *********************************************/
	public Player getPapan(int x, int y)
	{
		return arrayPapan[x][y];
	}
	
	/******************************
	 * Method accessor dan mutator
	 ******************************/
	public void setKolom(int kolom)
	{
		this.kolom = kolom;
	}
	
	public int getKolom()
	{
		return kolom;
	}
	
	public void setBaris(int baris)
	{
		this.baris = baris;
	}
	
	public int getBaris()
	{
		return baris;
	}
	
	public int getLastPutX()
	{
		return lastPut[0];
	}
	
	public int getLastPutY()
	{
		return lastPut[1];
	}
	
}
