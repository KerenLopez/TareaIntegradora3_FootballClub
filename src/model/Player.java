package model;

public class Player extends Employee implements MarketPriceAndLevelPlayer{

	//Atributes
	private int numShirt;
	private int numGoals;
	private double averageGrade;
	private double marketPrice;
	private double level;

	//Relationship
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
	* This method modifies the number of shirt that a player has. <br>
	* <b>name</b>: setNumShirt <br>
	* <b>post</b>: the number of shirt of a player has been changed. <br>
	* @param numShirt is an integer variable.
	*/

	public void setNumShirt(int numShirt){
		this.numShirt = numShirt;
	}

	/**
	* This method returns the number of goals that a player has scored in the club. <br>
	* <b>name</b>: getNumGoals <br>
	* @return integer <code> numGoals </code> that is a variable with the number of goals that a player has scored in the club.
	*/

	public int getNumGoals(){
		return numGoals;
	}

	/**
	* This method modifies the number of goals that a player has scored in the club. <br>
	* <b>name</b>: setNumGoals <br>
	* <b>post</b>: the number of goals that a player has scored in the club has been changed. <br>
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
	* This method modifies the average grade of a player. <br>
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
	* This method modifies the market price of a player. <br>
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
	* This method modifies the level of a player as a star inside the world of soccer. <br>
	* <b>name</b>: setLevel<br>
	* <b>post</b>: the level of a player as a star inside the world of soccer has been changed. <br>
	* @param level is a double variable.
	*/

	public void setLevel(double level){
		this.level = level;
	}

	/**
	* This method returns the position of a player in the soccer field. <br>
	* <b>name</b>: getPosition <br>
	* @return Position <code> position </code> that is a constant that represents the position of a player in the soccer field.
	*/

	public Position getPosition(){
		return position;
	}

	/**
	* This method modifies the position of a player in the soccer field. <br>
	* <b>name</b>: setPosition<br>
	* <b>post</b>: the position of a player in the soccer field has been changed. <br>
	* @param position is a constant of type Position.
	*/

	public void setPosition(Position position){
		this.position = position;
	}

	/**
	* Builder method <br>
	* <b>name</b>: Player <br>
	* <b>pre</b>: the variables name, id, salary, numShirt, averageGrade and position are already inicializated. <br>
	* <b>post</b>: the relationship and some atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a new player.
	* @param id is a String variable that contains the identificacion of a new player.
	* @param salary is a double variable that contains the value of the new player's salary.
	* @param numShirt is an integer variable that contains the new player's number of shirt in a team.
	* @param averageGrade is a double variable that contains the new player's average grade.
	* @param position is an integer variable that represents the new player's position in the soccer field.
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

	/**
	* This method calculates the market price of a goalie. <br>
	* <b>name</b>: goalieMarketPrice.<br>
 	* <b>post</b>: the market price of a goalie was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a goalie.
	*/

	@Override
	public double goalieMarketPrice(){
		marketPrice = (getSalary()*12)+(averageGrade*150);
		return marketPrice;
	}

	/**
	* This method calculates the market price of a defense. <br>
	* <b>name</b>: defenseMarketPrice.<br>
 	* <b>post</b>: the market price of a defense was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a defense.
	*/

	@Override
	public double defenseMarketPrice(){
		marketPrice = (getSalary()*13)+(averageGrade*125)+(numGoals*100);
		return marketPrice;
	}

	/**
	* This method calculates the market price of a midfielder. <br>
	* <b>name</b>: midfielderMarketPrice.<br>
 	* <b>post</b>: the market price of a midfielder was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a midfielder.
	*/

	@Override
	public double midfielderMarketPrice(){
		marketPrice = (getSalary()*14)+(averageGrade*135)+(numGoals*125);
		return marketPrice;
	}

	/**
	* This method calculates the market price of a forward. <br>
	* <b>name</b>: forwardMarketPrice.<br>
 	* <b>post</b>: the market price of a forward was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a forward.
	*/

	@Override
	public double forwardMarketPrice(){
		marketPrice = (getSalary()*12)+(averageGrade*145)+(numGoals*150);
		return marketPrice;
	}

	/**
	* This method calculates the level of a goalie as a star inside the world of soccer. <br>
	* <b>name</b>: goalieLevel.<br>
 	* <b>post</b>: the level of a goalie as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a goalie as a star inside the world of soccer.
	*/

	@Override
	public double goalieLevel(){
		level = averageGrade*0.9;
		return level;
	}

	/**
	* This method calculates the level of a defense as a star inside the world of soccer. <br>
	* <b>name</b>: defenseLevel.<br>
 	* <b>post</b>: the level of a defense as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a defense as a star inside the world of soccer.
	*/

	@Override
	public double defenseLevel(){
		level = (averageGrade*0.9)+(numGoals/100);
		return level;
	}

	/**
	* This method calculates the level of a midfielder as a star inside the world of soccer. <br>
	* <b>name</b>: midfielderLevel.<br>
 	* <b>post</b>: the level of a midfielder as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a midfielder as a star inside the world of soccer.
	*/

	@Override
	public double midfielderLevel(){
		level = (averageGrade*0.9)+(numGoals/90);
		return level;
	}

	/**
	* This method calculates the level of a forward as a star inside the world of soccer. <br>
	* <b>name</b>: forwardLevel.<br>
 	* <b>post</b>: the level of a forward as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a forward as a star inside the world of soccer.
	*/

	@Override
	public double forwardLevel(){
		level = (averageGrade*0.9)+(numGoals/80);
		return level;
	}

	/**
	* This method produces a String with all the information about a player. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of a player was returned. <br>
 	* @return out in a <code> String </code> variable all information about a player.
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