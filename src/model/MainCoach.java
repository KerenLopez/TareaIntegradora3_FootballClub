package model;
import java.util.*;

public class MainCoach extends Coach implements MarketPriceAndLevelMainCoach{

	//Atributes
	private int numTeams;
	private int numChampionships;
	private ArrayList<String> championships;
	private double marketPrice;
	private double level;

	//Getters and Setters 

	/**
	* This method returns the number of teams that a main coach has been in charge during his career. <br>
	* <b>name</b>: getNumTeams <br>
	* @return integer <code> numTeams</code> that is a variable with the number of teams that a main coach has been in charge during his career.
	*/

	public int getNumTeams(){
		return numTeams;
	}

	/**
	* This method modifies the number of teams that a main coach has been in charge during his career. <br>
	* <b>name</b>: setNumTeams <br>
	* <b>post</b>: the number of teams that a main coach has been in charge during his career has been changed. <br>
	* @param numTeams is an integer variable.
	*/

	public void setNumTeams(int numTeams){
		this.numTeams = numTeams;
	}

	/**
	* This method returns the number of championships that a coach has achieved during his career. <br>
	* <b>name</b>: getNumChampionships <br>
	* @return integer <code> numChhampionships </code> that is a variable with the number of championships that a coach has achieved during his career.
	*/

	public int getNumChampionships(){
		return numChampionships;
	}

	/**
	* This method modifies the number of championships that a coach has achieved during his career. <br>
	* <b>name</b>: setNumChampionships <br>
	* <b>post</b>: championships that a coach has achieved during his career has been changed. <br>
	* @param numChampionships is an integer variable.
	*/

	public void setNumChampionships(int numChampionships){
		this.numChampionships = numChampionships;
	}

	/**
	* This method returns the names of all the championships that a coach has achieved during his career. <br>
	* <b>name</b>: getChampionships <br>
	* @return ArrayList of Strings <code> championships </code> that contains all the names of the championships that a coach has achieved during his career.
	*/

	public ArrayList<String> getChampionships(){
		return championships;
	}

	/**
	* This method modifies the names of all the championships that a coach has achieved during his career. <br>
	* <b>name</b>: setChampionships<br>
	* <b>post</b>: the names of all the championships that a coach has achieved during his career has been changed. <br>
	* @param championships is an ArrayList of Strings.
	*/

	public void setChampionships(ArrayList<String> championships){
		this.championships = championships;
	}

	/**
	* This method returns the market price of a main coach. <br>
	* <b>name</b>: getMarketPrice <br>
	* @return double <code> marketPrice </code> that is variable with the market price of a main coach.
	*/

	public double getMarketPrice(){
		return marketPrice;
	}

	/**
	* This method modifies the market price of a main coach. <br>
	* <b>name</b>: setMarketPrice<br>
	* <b>post</b>: the market price of a main coach has been changed. <br>
	* @param marketPrice is a double variable.
	*/

	public void setMarketPrice(double marketPrice){
		this.marketPrice = marketPrice;
	}

	/**
	* This method returns the level of a main coach as a star inside the world of soccer. <br>
	* <b>name</b>: getLevel <br>
	* @return double <code> level </code> that is variable with the level of a main coach as a star inside the world of soccer.
	*/

	public double getLevel(){
		return level;
	}

	/**
	* This method modifies the level of a main coach as a star inside the world of soccer. <br>
	* <b>name</b>: setLevel<br>
	* <b>post</b>: the level of a main coach as a star inside the world of soccer has been changed. <br>
	* @param level is a double variable.
	*/

	public void setLevel(double level){
		this.level = level;
	}

	/**
	* Builder method <br>
	* <b>name</b>: MainCoach <br>
	* <b>pre</b>: the variables name, id, salary, yearsExperience, numTeams, numChampionships and the ArrayList of championships are already inicializated. <br>
	* <b>post</b>: All the atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a main coach.
	* @param id is a String variable that contains the identificacion of a main coach.
	* @param salary is a double variable that contains the value of the main coach's salary.
	* @param yearsExperience is an integer variable that contains the main coach's number years of experience.
	* @param numTeams is an integer variable that contains the number of teams that a main coach has been in charge during his career.
	* @param numChampionships is an integer variable that contains the number of championships that a main coach has achieved during his career.
	* @param championships is an ArrayList of Strings that contains the names of all the championships that a main coach has achieved during his career.
	*/

	public MainCoach(String name, String id, double salary, int yearsExperience, int numTeams, int numChampionships, ArrayList<String> championships){
		super(name,id,salary,yearsExperience);
		this.numTeams = numTeams;
		this.numChampionships = numChampionships;
		this.championships = championships;
		marketPrice = 0;
		level = 0;
	}

	/**
	* This method calculates the market price of a main coach. <br>
	* <b>name</b>: coachMarketPrice.<br>
 	* <b>post</b>: the market price of a main coach was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a main coach.
	*/

	@Override
	public double coachMarketPrice(){
		marketPrice = (getSalary()*10)+(getYearsExperience()*100)+(numChampionships*50); 
		return marketPrice;
	}

	/**
	* This method calculates the level of a main coach as a star inside the world of soccer. <br>
	* <b>name</b>: coachLevel.<br>
 	* <b>post</b>: the level of a main coach as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a main coach as a star inside the world of soccer.
	*/

	@Override
	public double coachLevel(){
		level = 5 +(numChampionships/10);
		return level;
	}

	/**
	* This method produces a String with the information of a main coach. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of a main coach was returned. <br>
 	* @return out in a <code> String </code> variable all information of a main coach.
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