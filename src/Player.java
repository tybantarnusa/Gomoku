import java.awt.Color;
import java.io.Serializable;

/**
 * Kelas berikut digunakan untuk merepresentasikan pemain.
 *
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.08
 *
 */
public class Player implements Serializable
{
	private static final long serialVersionUID = 944226352762037188L;

	private String lambang;
	private String nama;
	private Color warna;

	/***************************
	 * Constructor
	 * 
	 * @param nama Nama pemain.
	 ***************************/
	public Player(String nama, Color warna)
	{
		this.nama = nama;
		this.lambang = nama.substring(0,1).toUpperCase();
		this.warna = warna;
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
	
	/******************************
	 * Mengembalikan warna pemain.
	 * 
	 * @return Nama pemain.
	 ******************************/
	public Color getColor()
	{
		return warna;
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
	
	/*******************
	 * Method toString.
	 *******************/
	public String toString()
	{
		return "" + lambang;
	}
	
}
