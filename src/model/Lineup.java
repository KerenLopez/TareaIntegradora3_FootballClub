package model;

public class Lineup{

	//Constants
	public final static int TEN = 10;
	public final static int SEVEN = 7;

	//Atributes
	private String date;
	private int[][] formation;

	//Relationships
	private Tactic lineupTactic;

	/**
	* Builder method <br>
	* <b>name</b>: PrivatePL <br>
	* <b>pre</b>: the variable name, the object pAuthorizedUser and the lists like minutes and seconds are already inicializated. <br>
	* <b>post</b>: the atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a playlist.
	* @param minutes is a list of integers that contains the minutes that all the songs of a playlist lasts.
	* @param seconds is a list of integers that contains the seconds that all the songs of a playlist lasts.
	* @param pAuthorizedUser is an User object that contains the information of the only user that can access to the playlist.
	*/

	public Lineup(String date, int lineupTactic){
		this.date = date;
		formation = new int[TEN][SEVEN]
		switch(tactic){
			case 1:
				this.lineupTactic = Tactic.POSESION; 
				break;
			case 2:
				this.lineupTactic = Tactic.CONTRAATAQUE;
				break;
			case 3:
				this.lineupTactic = Tactic.PRESION_ALTA;
				break;
			case 4:
				this.lineupTactic = Tactic.POR_DEFECTO;
				break;	
		}
	}

	public String addFormation(int defenses, int midfielders, int forwards){
		String message = "";
		
	}
}