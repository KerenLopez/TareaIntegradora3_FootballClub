package model;
import java.util.*;

public class AssistantCoach extends Coach{

	//Constants
	public final static String YES = "si";
	public final static String NO = "no";

	//Atribute
	private String professionalPlayer;

	//Relationship
	private ArrayList<Expertise> expertises;

	//Getters and Setters 

	/**
	* This method returns yes or no depending on whether the assistant coach has ever been a professional player. <br>
	* <b>name</b>: getProfessionalPlayer <br>
	* @return String <code> professionalPlayer </code> that is a variable that contains yes or no depending on whether the assistant coach has ever been a professional player.
	*/

	public String getProfessionalPlayer(){
		return professionalPlayer;
	}

	/**
	* This method modifies if the assistant coach has ever been a professional player or not. <br>
	* <b>name</b>: setProfessionalPlayer <br>
	* <b>post</b>: the atribute of professional player has been changed. <br>
	* @param professionalPlayer is a String variable.
	*/

	public void setProfessionalPlayer(String professionalPlayer){
		this.professionalPlayer = professionalPlayer;
	}

	/**
	* This method returns all the expertises of an assistant coach. <br>
	* <b>name</b>: getExpertises <br>
	* @return ArrayList of Expertise <code> expertises </code> that contains all the expertises of an assistant coach.
	*/

	public ArrayList<Expertise> getExpertises(){
		return expertises;
	}

	/**
	* This method modifies the expertises of an assistant coach. <br>
	* <b>name</b>: setExpertises<br>
	* <b>post</b>: the expertises of an assistant coach has been changed. <br>
	* @param expertises is an ArrayList of type Expertise.
	*/

	public void setExpertises(ArrayList<Expertise> expertises){
		this.expertises = expertises;
	}

	/**
	* Builder method <br>
	* <b>name</b>: AssistantCoach <br>
	* <b>pre</b>: the variables name, id, salary, yearsExperience, professional player and the ArrayList of expertises are already inicializated. <br>
	* <b>post</b>: the atribute and the relationship of the class were inicializated. <br>
	* @param name is a String variable that contains the name of an assistant coach coach.
	* @param id is a String variable that contains the identificacion of a assistant coach.
	* @param salary is a double variable that contains the value of the assistant coach's salary.
	* @param yearsExperience is an integer variable that contains the assistant coach's number years of experience.
	* @param professionalPlayer is an integer variable that represents if the assistant coach has ever been a professional player or not.
	* @param expertises is an ArrayList of integers that represents the expertises of an assistant coach.
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
	* This method looks for an expertise in the list of expertises. <br>
	* <b>name</b>: findExpertise.<br>
	* <b>pre</b>: the variable newExpertise is already inicializated. <br>
 	* <b>post</b>: A boolean variable was returned. <br>
 	* @param newExpertise is an Expertise object that represents an expertise of an assistant coach. 
 	* @return boolean <code> find </code> that is a variable that could be true or false.
	*/

	public boolean findExpertise(Expertise newExpertise){
		boolean find = false;
		for(int i=0;i<expertises.size() && !find;i++){
			if(expertises.get(i).equals(newExpertise)){
				find = true;
			}
		} return find;
	}

	/**
	* This method updates the expertises of an assistant coach. <br>
	* <b>name</b>: updateExpertises <br>
	* <b>post</b>: the expertises of an assistant coach were successfully updated. <br>
	* @param cExpertises is an ArrayList of integers that represents the expertises that an assistant coach can have. cExpertises!=null
	*/

	public void updateExpertises(ArrayList<Integer> cExpertises){
		ArrayList<Expertise> newExpertises = new ArrayList<>();
		for(int j=0; j<cExpertises.size();j++){
			switch(cExpertises.get(j)){
				case 1:
					newExpertises.add(Expertise.OFENSIVO); 
					break;
				case 2:
					newExpertises.add(Expertise.DEFENSIVO); 
					break;
				case 3:
					newExpertises.add(Expertise.POSESION); 
					break;
				case 4:
					newExpertises.add(Expertise.JUGADAS_LABORATORIO); 
					break;
				case 5:
					newExpertises.add(Expertise.ENTRENADOR_FISICO); 
					break;
				case 6:
					newExpertises.add(Expertise.ENTRENADOR_DE_ARQUEROS); 
					break;					
			}
		}
		for(int k=0;k<newExpertises.size();k++){
			boolean add = findExpertise(newExpertises.get(k));
			if(add == false){
				expertises.add(newExpertises.get(k));
			}
		}
	}

	/**
	* This method produces a String with the information of an assistant coach. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of an assistant coach was returned. <br>
 	* @return out in a <code> String </code> variable all the information of an assistant coach.
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