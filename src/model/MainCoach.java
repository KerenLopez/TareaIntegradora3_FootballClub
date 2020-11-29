package model;

public class MainCoach extends Coach implements MarketPrice, Level{

	//Atributes
	private int numTeams;
	private int numChampionships;
	private ArrayList <String> championships;
	private double marketPrice;
	private double level;

	//Getters and Setters 

	/**
	* This method returns the number of shirt that a player has. <br>
	* <b>name</b>: getNumShirt <br>
	* @return integer <code> numShirt </code> that is a variable with the number of shirt that a player has.
	*/

	public int getNumTeams(){
		return numTeams;
	}

	/**
	* this method modifies the number of shirt that a player has. <br>
	* <b>name</b>: setNumShirt <br>
	* <b>post</b>: the number of shirt of a player has been changed. <br>
	* @param numTeams is an integer variable.
	*/

	public void setNumTeams(int numTeams){
		this.numTeams = numTeams;
	}

	/**
	* This method returns the number of shirt that a player has. <br>
	* <b>name</b>: getNumShirt <br>
	* @return integer <code> numShirt </code> that is a variable with the number of shirt that a player has.
	*/

	public int getNumChampionships(){
		return numChampionships;
	}

	/**
	* this method modifies the number of shirt that a player has. <br>
	* <b>name</b>: setNumShirt <br>
	* <b>post</b>: the number of shirt of a player has been changed. <br>
	* @param numChampionships is an integer variable.
	*/

	public void setNumChampionships(int numChampionships){
		this.numChampionships = numChampionships;
	}

	public ArrayList<String> getChampionships(){
		return championships;
	}

	public void setChampionships(ArrayList<String> championships){
		this.championships = championships;
	}

	/**
	* This method returns the market price of a player. <br>
	* <b>name</b>: getMarketPrice <br>
	* @return double <code> marketPrice </code> that is variable with the market price of a player.
	*/

	public double getMarketPrice(){
		return marketPrice;
	}

	/**
	* this method modifies the market price of a player. <br>
	* <b>name</b>: setMarketPrice<br>
	* <b>post</b>: the market price of a player has been changed. <br>
	* @param marketPrice is a double variable.
	*/

	public void setMarketPrice(double marketPrice){
		this.marketPrice = marketPrice;
	}

	/**
	* This method returns the level of a player as a star inside the world of soccer. <br>
	* <b>name</b>: getLevel <br>
	* @return double <code> level </code> that is variable with the level of a player as a star inside the world of soccer.
	*/

	public double getLevel(){
		return level;
	}

	/**
	* this method modifies the level of a player as a star within the world of soccer. <br>
	* <b>name</b>: setLevel<br>
	* <b>post</b>: the level of a player as a star within the world of soccer has been changed. <br>
	* @param level is a double variable.
	*/

	public void setLevel(double level){
		this.level = level;
	}

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

	public MainCoach(String name, String id, double salary, int yearsExperience, int numTeams, int numChampionships, ArrayList<String> championships){
		super(name,id,salary,yearsExperience);
		this.numTeams = numTeams;
		this.numChampionships = numChampionships;
		this.championships = championships;
		marketPrice = 0;
		level = 0;
	}

	public double coachMarketPrice(){
		marketPrice = (salary*10)+(yearsExperience*100)+(numChampionships*50); 
		return marketPrice;
	}

	public double coachLevel(){
		level = 5 +(numChampionships/10);
		return level;
	}

	/**
	* This method produces a String with the information of a private playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return out in a <code> String </code> variable all information of a private playlist.
	*/

	@Override
	public String toString(){
		String message = "";
		for(int k=0;k<championships.size();k++){
				message+="\n                                          **  Campeonato ganado #"+(k+1)+": "+championships.get(k);	
		}
		return super.toString()+"\n                                          **  Cargo: Entrenador principal"+
		"\n                                          **  Numero de equipos con los que ha trabajado: "+numTeams+
		"\n                                          **  Numero de campeonatos ganados: "+numChampionships+
		message+
		"\n                                          **  Precio de mercado: "+coachMarketPrice()+
		"\n                                          **  Nivel: "+coachLevel();
	}
}