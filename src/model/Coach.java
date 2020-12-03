package model;

public abstract class Coach extends Employee{

	//Atributes
	protected int yearsExperience;

	//Getters and Setters 

	/**
	* This method returns the years of experience that a coach has. <br>
	* <b>name</b>: getYearsExperience <br>
	* @return integer <code> yearsExperience </code> that is a variable with the years of experience that a coach has.
	*/

	public int getYearsExperience(){
		return yearsExperience;
	}

	/**
	* this method modifies the years of experience that a coach has. <br>
	* <b>name</b>: setYearsExperience <br>
	* <b>post</b>: the years of experience of a coach has been changed. <br>
	* @param years is an integer variable.
	*/

	public void setYearsExperience(int yearsExperience){
		this.yearsExperience = yearsExperience;
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

	public Coach (String name, String id, double salary, int yearsExperience){
		super(name,id,salary);
		this.yearsExperience = yearsExperience;
	}

	/**
	* This method produces a String with the information of a private playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return out in a <code> String </code> variable all information of a private playlist.
	*/

	@Override
	public String toString(){
		return super.toString()+"\n                                          **  Experiencia: "+yearsExperience+" anios";
	}
}