package com.enbw.tictactoe;

import org.omg.CORBA.RepositoryIdHelper;

public class Spielklasse {
	
	private static Spielklasse spielklasse;
	public final static String SPIELER0 = "O";
	public final static String SPIELER1 = "X";
	
	private int counter;
	private String[][] spielfeld;
	private MainController mainController;
	
	public Spielklasse(MainController mainController){
		this.mainController = mainController;
		counter = 0;
		spielfeld = new String[3][3];
	}
	
	public String clicked(int x, int y) {
		/*
		 * Schritt2: Tuhe dies nur wenn der Platz noch nicht belegt ist.
		 */
		if(spielfeld[x][y] == null) {
			/*Schritt1: 
			 * Gebe das Symbol für den akutellen Spieler zurück.
			 * Speichere den Zug in deinem Spielfeld 
			 * Welchsel den Spieler
			 */
			String spieler;
			if(counter++%2 == 0)
				spieler = SPIELER0;
			else
				spieler = SPIELER1;
			
			spielfeld[x][y] = spieler;
			
			if(checkSieg(spieler))
				beendeSpiel(true);
			if(counter == 9)
				beendeSpiel(false);
				
			return spieler;
		}
		return spielfeld[x][y];
	}
	
	private boolean checkSieg(String spieler) {
		if(checkHorizontal(spieler))
			return true;
		if(checkVertikal(spieler))
			return true;
		if(checkDiagonal(spieler))
			return true;
		return false;
	}
	private boolean checkHorizontal(String spieler) {
		/*
		 * Schritt 2.1 Prüfe Horizontal ob der Spieler gewonnen hat 	
		 */
		boolean[] zeile = new boolean[3];
		for(int y = 0; y<3; y++) {
			for(int x=0; x<3; x++) {
				if(spielfeld[x][y] == spieler) 
					zeile[y] = true;
				else {
					zeile[y] = false;
					break;
				}
			}
			if(zeile[y])
				return true;
		}
		return false;
	}
	
	private boolean checkVertikal(String spieler) {
	/*
	 * Schritt 2.2 Prüfe Vertikal ob der Spieler gewonnen hat 	
	 */
		boolean[] spalte = new boolean[3];
		for(int x = 0; x<3; x++) {
			for(int y=0; y<3; y++) {
				if(spielfeld[x][y] == spieler) 
					spalte[x] = true;
				else {
					spalte[x] = false;
					break;
				}
			}
			if(spalte[x])
				return true;
		}
		return false;
	}
	
	private boolean checkDiagonal(String spieler) {
	/*
	 * Schritt 2.3 Prüfe ob der Spieler Diagonal gewonnen hat
	 */
		boolean runter = true;
		boolean hoch = true; 
		for(int i=0; i<3; i++) {
			runter = spielfeld[i][i] == spieler;
			if(!runter)
				break;
		}
		for(int i=0; i<3; i++) {
			hoch = spielfeld[2-i][i] == spieler;
				if(!hoch)
					break;
		}
		return runter || hoch;	
	}
	
	private void beendeSpiel(boolean sieg) {
		mainController.endSpiel(sieg);
	}
}
