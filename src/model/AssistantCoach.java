package model;
import java.util.*;

public class AssistantCoach extends Coach{

	//Constants
	public final static String YES = "si";
	public final static String NO = "no";

	//Atributes
	private String professionalPlayer;

	//Relationships
	private ArrayList<Expertise> expertises;

	//Getters and Setters 

	/**
	* This method returns the name of an employee. <br>
	* <b>name</b>: getName <br>
	* @return String <code> name </code> that is a variable with the name of an employee.
	*/

	public String getProfessionalPlayer(){
		return professionalPlayer;
	}

	/**
	* this method modifies the name of an employee. <br>
	* <b>name</b>: setName <br>
	* <b>post</b>: the name of an employee has been changed. <br>
	* @param name is a String variable.
	*/

	public void setProfessionalPlayer(String professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}


	public ArrayList<Expertise> getExpertises(){
		return expertises;
	}

	public void setExpertises(ArrayList<Expertise> expertises){
		this.expertises = expertises;
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

	public AssistantCoach(String name, String id, double salary, int yearsExperience, int professionalPlayer, ArrayList<Integer> expertises){
		super(name,id,salary,yearsExperience);
		if(professionalPlayer==1){
			this.professionalPlayer = YES;
		} else{
			this.professionalPlayer = NO;
		}	
		this.expertises = new ArrayList<Expertise>();
		for(int k=0; k<expertises.size();k++){
			switch(expertises.get(k)){
				case 1:
					this.expertises.add(Expertise.OFENSIVO); 
					break;
				case 2:
					this.expertises.add(Expertise.DEFENSIVO); 
					break;
				case 3:
					this.expertises.add(Expertise.POSESION); 
					break;
				case 4:
					this.expertises.add(Expertise.JUGADAS_LABORATORIO); 
					break;
				case 5:
					this.expertises.add(Expertise.ENTRENADOR_FISICO); 
					break;
				case 6:
					this.expertises.add(Expertise.ENTRENADOR_DE_ARQUEROS); 
					break;					
			}
		}	
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
		for(int k=0;k<expertises.size();k++){
				message+="\n                                          **  Experticia #"+(k+1)+": "+expertises.get(k);	
		}
		return super.toString()+"\n                                          **  Cargo: Entrenador Asistente"+
		"\n                                          **  Ha sido jugador profesional?: "+professionalPlayer+message;
	}
}