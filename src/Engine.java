/**
 * Kelas berikut digunakan sebagai sistem yang dilakukan
 * pada game untuk menentukan kemenangan dan sistem lainnya.
 *
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @version 2014.12.08
 *
 */
 
public class Engine
{
	private static final int WIN_CONDITION = 5;
	
	private static int x = 0;
	private static int y = 0;
	
	private static int count;
	
	private static boolean doneChecking = false;
	
	private static Board board;
	private static Player player;
	
	/****************************************
	 * Pemeriksaan kemenangan apabila bidak
	 * sudah tersusun lima secara horizontal.
	 * 
	 * @return Apakah pemain sudah menang.
	 ****************************************/
	public static boolean checkHorizontal()
	{
		int pointer = y;
		
		// Memeriksa dan menghitung ke kanan
		while (!doneChecking) {
			
			// Apabila menaruh di sisi paling kanan papan permainan
			if (pointer + 1 == board.getKolom()) {
				
				doneChecking = true;
			
			// Algoritma pemeriksaan ke kanan
			} else {
				pointer++;
				
				if (board.getPlayerAt(x, pointer) == player) {
				
					count++;
					
				} else {
					
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		doneChecking = false;
		pointer = y;
		
		// Memeriksa dan menghitung ke kiri
		while (!doneChecking) {
		
			// Apabila menaruh di sisi paling kiri papan
			if (pointer == 0) {
			
				doneChecking = true;
			
			// Algoritma pemeriksaan ke kiri
			} else {
				pointer--;
				
				if (board.getPlayerAt(x, pointer) == player) {
				
					count++;
					
				} else {
					
					doneChecking = true;
					
				}
			}
		}
		
		// Mengambalikan variabel ke nilai asal
		pointer = y;
		doneChecking = false;
		
		// Memeriksa apakah jumlah pemain yang sama yang tersusun itu sudah lima atau lebih
		if (count >= WIN_CONDITION) {
			
			count = 1;
			return true;
		
		} else {
			
			count = 1;
			return false;
		
		}
	}
	
	/****************************************
	 * Pemeriksaan kemenangan apabila bidak
	 * sudah tersusun lima secara vertikal.
	 * 
	 * @return Apakah pemain sudah menang.
	 ****************************************/
	public static boolean checkVertikal()
	{
		int pointer = x;
		
		// Memeriksa dan menghitung ke bawah
		while (!doneChecking) {
			
			// Apabila menaruh di sisi paling bawah papan
			if (pointer + 1 == board.getBaris()) {
				
				doneChecking = true;
			
			// Algoritma pemeriksaan ke bawah	
			} else {
				pointer++;
				
				if (board.getPlayerAt(pointer, y) == player) {
				
					count++;
					
				} else {
				
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		doneChecking = false;
		pointer = x;
		
		// Memeriksa dan menghitung ke atas
		while (!doneChecking) {
			
			// Apabila menaruh di sisi paling atas papan
			if (pointer == 0) {
				
				doneChecking = true;
			
			// Algoritma pemeriksaan ke atas	
			} else {
				pointer--;
				
				if (board.getPlayerAt(pointer, y) == player) {
					count++;
					
				} else {
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		pointer = x;
		doneChecking = false;
		
		// Pemeriksaan apabila jumlah pemain yang tersusun sama sudah lima atau lebih secara vertikal
		if (count >= WIN_CONDITION) {
			
			count = 1;
			return true;
		
			
		} else {
			
			count = 1;
			return false;
			
		}
	}
	
	/*****************************************************
	 * Pemeriksaan kemenangan apabila bidak sudah tersusun
	 * lima secara diagonal dengan gradien -1.
	 * 
	 * @return Apakah pemain sudah menang.
	 *****************************************************/
	public static boolean checkDiagonalTurun()
	{
		int pointerX = x;
		int pointerY = y;
		
		while (!doneChecking) {
			
			// Apabila menaruh pada sisi paling kanan dan paling bawah papan
			if (pointerX + 1 == board.getBaris() || pointerY + 1 == board.getKolom()) {
			
				doneChecking = true;
			
			// Algoritma pemeriksaan ke kanan bawah
			} else {
				pointerX++;
				pointerY++;
			
				if (board.getPlayerAt(pointerX, pointerY) == player) {
				
					count++;
					
				} else {
				
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		doneChecking = false;
		pointerX = x;
		pointerY = y;
		
		while (!doneChecking) {
			
			// Apabila menaruh pada sisi paling atas dan paling kiri papan
			if (pointerX == 0 || pointerY == 0) {
			
				doneChecking = true;
			
			// Algoritma pemeriksaan ke atas kiri	
			} else {
				pointerX--;
				pointerY--;
			
				if (board.getPlayerAt(pointerX, pointerY) == player) {
			
					count++;
					
				} else {
			
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		pointerX = x;
		pointerY = y;
		doneChecking = false;
		
		// Memeriksa apakah pemain sudah sama sebanyak lima atau lebih secara diagonal turun
		if (count >= WIN_CONDITION) {
			
			count = 1;
			return true;
		
		} else {
			
			count = 1;
			return false;
			
		}
	}
	
	/*****************************************************
	 * Pemeriksaan kemenangan apabila bidak sudah tersusun
	 * lima secara diagonal dengan gradien 1.
	 * 
	 * @return Apakah pemain sudah menang.
	 *****************************************************/
	public static boolean checkDiagonalNaik()
	{
		int pointerX = x;
		int pointerY = y;
		
		while (!doneChecking) {
			
			// Apabila menaruh pada sisi paling kiri dan paling bawah papan
			if (pointerX + 1 == board.getBaris() || pointerY == 0) {
			
				doneChecking = true;
			
			// Algoritma pemeriksaan ke kiri bawah	
			} else {
				pointerX++;
				pointerY--;
			
				if (board.getPlayerAt(pointerX, pointerY) == player) {
			
					count++;
					
				} else {
			
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		doneChecking = false;
		pointerX = x;
		pointerY = y;
		
		while (!doneChecking) {
			
			// Apabila menaruh pada sisi paling kanan dan paling atas popan
			if (pointerX == 0 || pointerY + 1 == board.getKolom()) {
			
				doneChecking = true;
			
			// Algoritma pemeriksaan ke atas kanan	
			} else {
				pointerX--;
				pointerY++;
			
				if (board.getPlayerAt(pointerX, pointerY) == player) {
			
					count++;
					
				} else {
			
					doneChecking = true;
					
				}
			}
		}
		
		// Mengembalikan variabel ke nilai asal
		pointerX = x;
		pointerY = y;
		doneChecking = false;
		
		// Memeriksa apakah pemain sudah sama sebanyak lima atau lebih secara diagonal naik
		if (count >= WIN_CONDITION) {
			
			count = 1;
			return true;
		
		} else {
		
			count = 1;
			return false;
		
		}
	}
	
	/****************************************************
	 * Pemeriksaan kemenangan dengan menggabungkan
	 * keempat arah pemeriksaan.
	 * 
	 * @param papan Papan permainan yang ingin diperiksa.
	 * @param warna Warna pemain yang ingin diperiksa
	 * 		kemenangannya.
	 * @return Apakah pemain sudah menang.
	 ****************************************************/
	public static boolean checkWin(Board papan, Player warna)
	{
		x = papan.getLastPutX();
		y = papan.getLastPutY();
		
		count = 1;
		board = papan;
		player = warna;
		
		return checkHorizontal() || checkVertikal() || checkDiagonalTurun() || checkDiagonalNaik();
	}
}
