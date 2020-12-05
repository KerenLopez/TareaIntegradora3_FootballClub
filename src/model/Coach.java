package model;

public abstract class Coach extends Employee{

	//Atributes
	private int yearsExperience;

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
	* This method modifies the years of experience that a coach has. <br>
	* <b>name</b>: setYearsExperience <br>
	* <b>post</b>: the years of experience of a coach has been changed. <br>
	* @param yearsExperience is an integer variable.
	*/

	public void setYearsExperience(int yearsExperience){
		this.yearsExperience = yearsExperience;
	}

	/**
	* Builder method <br>
	* <b>name</b>: Coach <br>
	* <b>pre</b>: the variables name, id, salary and yearsExperience are already inicializated. <br>
	* <b>post</b>: the atribute of the class was inicializated. <br>
	* @param name is a String variable that contains the name of a coach.
	* @param id is a String variable that contains the identificacion of a coach.
	* @param salary is a double variable that contains the value of the coach's salary.
	* @param yearsExperience is an integer variable that contains the coach's number years of experience.
	*/

	public Coach (String name, String id, double salary, int yearsExperience){
		super(name,id,salary);
		this.yearsExperience = yearsExperience;
	}

	/**
	* This method produces a String with the information of a coach. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of a coach was returned. <br>
 	* @return out in a <code> String </code> variable all information of a coach.
	*/

	@Override
	public String toString(){
		return super.toString()+"\n                                          **  Experiencia: "+yearsExperience+" anios";
	}
}