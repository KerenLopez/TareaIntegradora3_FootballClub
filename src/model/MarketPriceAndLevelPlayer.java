package model;

public interface MarketPriceAndLevelPlayer{

	//Methods

	/**
	* This method calculates the market price of a goalie. <br>
	* <b>name</b>: goalieMarketPrice.<br>
 	* <b>post</b>: the market price of a goalie was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a goalie.
	*/
	public double goalieMarketPrice();

	/**
	* This method calculates the market price of a defense. <br>
	* <b>name</b>: defenseMarketPrice.<br>
 	* <b>post</b>: the market price of a defense was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a defense.
	*/
	public double defenseMarketPrice();
	
	/**
	* This method calculates the market price of a midfielder. <br>
	* <b>name</b>: midfielderMarketPrice.<br>
 	* <b>post</b>: the market price of a midfielder was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a midfielder.
	*/
	public double midfielderMarketPrice();

	/**
	* This method calculates the market price of a forward. <br>
	* <b>name</b>: forwardMarketPrice.<br>
 	* <b>post</b>: the market price of a forward was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a forward.
	*/
	public double forwardMarketPrice();

	/**
	* This method calculates the level of a goalie as a star inside the world of soccer. <br>
	* <b>name</b>: goalieLevel.<br>
 	* <b>post</b>: the level of a goalie as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a goalie as a star inside the world of soccer.
	*/
	public double goalieLevel();

	/**
	* This method calculates the level of a defense as a star inside the world of soccer. <br>
	* <b>name</b>: defenseLevel.<br>
 	* <b>post</b>: the level of a defense as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a defense as a star inside the world of soccer.
	*/
	public double defenseLevel();
	
	/**
	* This method calculates the level of a midfielder as a star inside the world of soccer. <br>
	* <b>name</b>: midfielderLevel.<br>
 	* <b>post</b>: the level of a midfielder as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a midfielder as a star inside the world of soccer.
	*/
	public double midfielderLevel();
	
	/**
	* This method calculates the level of a forward as a star inside the world of soccer. <br>
	* <b>name</b>: forwardLevel.<br>
 	* <b>post</b>: the level of a forward as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a forward as a star inside the world of soccer.
	*/
	public double forwardLevel();
}