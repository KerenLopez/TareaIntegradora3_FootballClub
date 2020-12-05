package model;

public interface MarketPriceAndLevelMainCoach{

	//Methods
	
	/**
	* This method calculates the market price of a main coach. <br>
	* <b>name</b>: coachMarketPrice.<br>
 	* <b>post</b>: the market price of a main coach was calculated. <br>
 	* @return double <code> marketPrice </code> that is a variable with the market price of a main coach.
	*/
	public double coachMarketPrice();
	/**
	* This method calculates the level of a main coach as a star inside the world of soccer. <br>
	* <b>name</b>: coachLevel.<br>
 	* <b>post</b>: the level of a main coach as a star inside the world of soccer was calculated. <br>
 	* @return double <code> level </code> that is a variable with the level of a main coach as a star inside the world of soccer.
	*/
	public double coachLevel();
}