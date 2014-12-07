import java.io.Serializable;

/**
 * Kelas berikut digunakan untuk merepresentasikan pemain.
 *
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.07
 *
 */

public class Player implements Serializable
{
	private static final long serialVersionUID = 944226352762037188L;

	String lambang;
	String nama;

	/***************************
	 * Constructor
	 * 
	 * @param nama Nama pemain.
	 ***************************/
	public Player(String nama)
	{
		this.nama = nama;
		this.lambang = nama.substring(0,1).toUpperCase();
	}
	
	/***********************************************
	 * Memeriksa apakah pemain ini sudah menang.
	 * 
	 * @param papan Papan permainan dimana pemain
	 * 				sedang berada.
	 * @return Apakah pemain ini menang.
	 ***********************************************/
	public boolean isWin(Board papan)
	{
		return Engine.checkWin(papan, this);
	}
	
	/***********************************************
	 * Mengembalikan lambang si pemain berupa char.
	 * 
	 * @return Lambang pemain.
	 ***********************************************/
	public String getLambang()
	{
		return nama;
	}
	
	/********************************
	 * Mengembalikan nama si pemain.
	 * 
	 * @return Nama pemain.
	 ********************************/
	public String getNama()
	{
		return nama;
	}
	
	/*****************************************
	 * Mengeset lambang pemain (berupa char).
	 * 
	 * @param lambang Lambang pemain.
	 *****************************************/
	public void setLambang(char lambang)
	{
		this.lambang = "" + lambang;
	}
	
	/***************************
	 * Mengeset nama pemain.
	 * 
	 * @param nama Nama pemain.
	 ***************************/
	public void setNama(String nama)
	{
		this.nama = nama.substring(0,1).toUpperCase();
	}
	
	/*****************************************************
	 * Mengeset nama sekaligus lambang pemain.
	 * 
	 * @param nama Nama pemain.
	 * @param lambang Lambang char yang digunakan pemain.
	 *****************************************************/
	public void setPemain(String nama, char lambang)
	{
		this.nama = nama;
		this.lambang = "" + lambang;
	}
	
}
