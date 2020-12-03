package model;

public class Player extends Employee implements MarketPriceAndLevelPlayer{

	//Atributes
	private int numShirt;
	private int numGoals;
	private double averageGrade;
	private double marketPrice;
	private double level;

	//Relationships
	private Position position;

	//Getters and Setters 

	/**
	* This method returns the number of shirt that a player has. <br>
	* <b>name</b>: getNumShirt <br>
	* @return integer <code> numShirt </code> that is a variable with the number of shirt that a player has.
	*/

	public int getNumShirt(){
		return numShirt;
	}

	/**
	* this method modifies the number of shirt that a player has. <br>
	* <b>name</b>: setNumShirt <br>
	* <b>post</b>: the number of shirt of a player has been changed. <br>
	* @param numShirt is an integer variable.
	*/

	public void setNumShirt(int numShirt){
		this.numShirt = numShirt;
	}

	/**
	* This method returns the number of goals that a player has scored in a team. <br>
	* <b>name</b>: getNumGoals <br>
	* @return integer <code> numGoals </code> that is a variable with the number of goals that a player has scored in a team.
	*/

	public int getNumGoals(){
		return numGoals;
	}

	/**
	* this method modifies the number of goals that a player has scored in a team. <br>
	* <b>name</b>: setNumGoals <br>
	* <b>post</b>: the number of goals that a player has scored in a team has been changed. <br>
	* @param numGoals is an integer variable.
	*/

	public void setNumGoals(int numGoals){
		this.numGoals = numGoals;
	}

	/**
	* This method returns the average grade of a player. <br>
	* <b>name</b>: getAverageGrade <br>
	* @return double <code> averageGrade </code> that is variable with the average grade of a player.
	*/

	public double getAverageGrade(){
		return averageGrade;
	}

	/**
	* this method modifies the average grade of a player. <br>
	* <b>name</b>: setAverageGrade<br>
	* <b>post</b>: the average grade of a player has been changed. <br>
	* @param averageGrade is a double variable.
	*/

	public void setAverageGrade(double averageGrade){
		this.averageGrade = averageGrade;
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
	* This method returns the position of a player in the field. <br>
	* <b>name</b>: getPosition <br>
	* @return Position <code> position </code> that is a constant that represents the position of a player in the field.
	*/

	public Position getPosition(){
		return position;
	}

	/**
	* this method modifies the position of a player in the field. <br>
	* <b>name</b>: setPosition<br>
	* <b>post</b>: the position of a player in the field has been changed. <br>
	* @param position is a constant of type Position.
	*/

	public void setPosition(Position position){
		this.position = position;
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

	public Player(String name, String id, double salary, int numShirt, double averageGrade, int position){
		super(name,id,salary);
		this.numShirt = numShirt;
		numGoals = 0;
		this.averageGrade = averageGrade;
		switch(position){
			case 1:
				this.position = Position.PORTERO; 
				break;
			case 2:
				this.position = Position.DEFENSOR; 
				break;
			case 3:
				this.position = Position.VOLANTE; 
				break;
			case 4:
				this.position = Position.DELANTERO; 
				break;					
		}
	}

	@Override
	public double goalieMarketPrice(){
		marketPrice = (salary*12)+(averageGrade*150);
		return marketPrice;
	}

	@Override
	public double defenseMarketPrice(){
		marketPrice = (salary*13)+(averageGrade*125)+(numGoals*100);
		return marketPrice;
	}

	@Override
	public double midfielderMarketPrice(){
		marketPrice = (salary*14)+(averageGrade*135)+(numGoals*125);
		return marketPrice;
	}

	@Override
	public double forwardMarketPrice(){
		marketPrice = (salary*12)+(averageGrade*145)+(numGoals*150);
		return marketPrice;
	}

	@Override
	public double goalieLevel(){
		level = averageGrade*0.9;
		return level;
	}

	@Override
	public double defenseLevel(){
		level = (averageGrade*0.9)+(numGoals/100);
		return level;
	}

	@Override
	public double midfielderLevel(){
		level = (averageGrade*0.9)+(numGoals/90);
		return level;
	}

	@Override
	public double forwardLevel(){
		level = (averageGrade*0.9)+(numGoals/80);
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
		if(position.equals(Position.PORTERO)){
			message = "\n                                          **  Precio de mercado: "+goalieMarketPrice()+
			"\n                                          **  Nivel: "+goalieLevel();
		}	
		if(position.equals(Position.DEFENSOR)){
			message = "\n                                          **  Precio de mercado: "+defenseMarketPrice()+
			"\n                                          **  Nivel: "+defenseLevel();
		}
		if(position.equals(Position.VOLANTE)){
			message = "\n                                          **  Precio de mercado: "+midfielderMarketPrice()+
			"\n                                          **  Nivel: "+midfielderLevel();
		}
		if(position.equals(Position.DELANTERO)){
			message = "\n                                          **  Precio de mercado: "+forwardMarketPrice()+
			"\n                                          **  Nivel: "+forwardLevel();	 
		}
		return super.toString()+"\n                                          **  Cargo: Jugador"+
		"\n                                          **  Numero de camiseta: "+numShirt+
		"\n                                          **  Goles marcados en el club: "+numGoals+
		"\n                                          **  Calificacion promedio: "+averageGrade+
		"\n                                          **  Posicion: "+position+message;
	}
}