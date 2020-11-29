package model;
import java.util.*;

public class Team{

	//Atributes
	private String name;
	private char id;

	//Constants
	public final static int MAX_NUM_PLAYERS = 25;
	public final static int MAX_NUM_ASSCOACHES = 3;

	//Relationships
	private Player[][] dressingRoom;
	private ArrayList <Lineup> lineups;
	private Coach mainCoach;
	private AssistantCoach[] assistantCoaches;
	private Player[] players;

	//Getters and Setters 

	/**
	* This method returns the name of a team. <br>
	* <b>name</b>: getName <br>
	* @return String <code> name </code> that is a variable with the name of a team.
	*/

	public String getName(){
		return name;
	}

	/**
	* this method modifies the name of a team. <br>
	* <b>name</b>: setName <br>
	* <b>post</b>: the name of a team has been changed. <br>
	* @param name is a String variable.
	*/

	public void setName(String name){
		this.name = name;
	}

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: FootballClub <br>
	* <b>post</b>: The atributes and relationships of the class were inicializated. <br>
	*/

	public Team(String name, char id){
		this.name = name;
		this.id = id;
		players = new Player[MAX_NUM_PLAYERS];
		assistantCoaches = new Coach[MAX_NUM_ASSCOACHES];
		lineups = new ArrayList<Lineup>();
		if(id=='A'){
			dressingRoom = new Player[7][7];
		}else{
			dressingRoom = new Player[7][6];
		}
	}

	/**
	* This method looks for the name of a user in the list of registered users, and returns an object of type User. <br>
	* <b>name</b>: findTeam.<br>
	* <b>pre</b>: the variable nameUser is already inicializated. <br>
 	* <b>post</b>: An object of type User was returned. <br>
 	* @param nameTeam is a String variable that contains the name of the user. 
 	* @return User <code> objUser </code> that is an object that could be null or full.
	*/

	public String findNumShirt(int numShirt){
		String message = "El numero de camiseta puede ser asignado";
		Player objPlayer = null;
		boolean find =false;
		if(numShirt>=1 && numShirt<=99){
			for(int k=0;k<players.length && !find;k++){
				if(players[k]!=null && players[k].getNumShirt()==numShirt){
					find=true;
					message = "\nEl numero de camiseta ingresado ya se encuentra asignado a otro jugador del equipo";
				}
			} 
		} else{
			message = "\nEl rango en el que el numero de camiseta de un jugador debe encontrarse es entre 1 y 99";
		} return message;	
	}

	public String addPlayer(Player newPlayer){
		String message = "\nEl jugador ha sido asignado al equipo y registrado en el club exitosamente";
		if(players[MAX_NUM_PLAYERS-1]==null){
			for(int k=0;k<players.length;k++){
				if(players[k]!=null){
					players[k]=newPlayer;
				}
			}
		} else{
			message = "\nYa han sido agregados todos los jugadores posibles al equipo";
		} return message;
	}

	public String addMainCoach(MainCoach newMainCoach){
		String message = "\nEl entrenador principal ha sido asignado al equipo y registrado en el club exitosamente";
		if(mainCoach==null){
			mainCoach = newMainCoach;
		} else{
			message = "\nEl equipo ya cuenta con un entrenador principal asignado";
		} return message;
	}

	public String addAsistantCoach(AssistantCoach newAssCoach){
		String message = "\nEl entrenador asistente ha sido asignado al equipo y registrado en el club exitosamente";
		if(assistantCoaches[MAX_NUM_ASSCOACHES-1]==null){
			for(int k=0;k<assistantCoaches.length;k++){
				if(assistantCoaches[k]!=null){
					assistantCoaches[k]=newAssCoach;
				}
			}
		} else{
			message = "\nYa han sido agregados todos los entrenadores asistentes posibles al equipo";
		} return message;
	}

	public String deleteEmployee(Employee fireEmployee){
		String message = "\nEl proceso se realizo exitosamente, el empleado fue despedido";
		boolean find = false;
		if(fireEmployee instanceof Player){
			for(int k=0;k<players.length;k++){
				if(players[k]!=null && players[k].getId().equals(((Player)fireEmployee).getId())){
					players[k]= null;
					find = true;
				}
			}
			if(find==false){
				message = "\nEl empleado no pertenece al equipo ingresado, intentelo nuevamente";
			}
		}
		if(fireEmployee instanceof MainCoach){
			if(mainCoach!=null && mainCoach.getId().equals(((MainCoach)fireEmployee).getId())){
				mainCoach = null;
			} else{
				message = "\nEl empleado no pertenece al equipo ingresado, intentelo nuevamente";
			}
		}
		if(fireEmployee instanceof AssistantCoach){
			for(int x=0;x<assistantCoaches.length;x++){
				if(assistantCoaches[k]!=null && assistantCoaches[k].getId().equals(((AssistantCoach)fireEmployee).getId())){
					assistantCoaches[k]= null;
					find = true;
				}
			}
			if(find==false){
				message = "\nEl empleado no pertenece al equipo ingresado, intentelo nuevamente";
			}
		} 
		return message;
	}

	/**
	* This method produces a String with the information of a private playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return out in a <code> String </code> variable all information of a private playlist.
	*/

	public String toString(){
		String message = "";
		for(int k=0;k<assistantCoaches.length;k++){
			if(players[k]!=null){
				message+="\n                                          **  Entrenador asistente #"+(k+1)+": "+assistantCoaches[k].getName();	
			}
		}
		for(int j=0;j<players.length;j++){
			if(players[k]!=null){
				message+="\n                                          **  Jugador #"+players[k].getNumShirt()+": "+players[k].getName();
			}
		}
		return "\n                                          *******************************************************"+
			"\n                                          ********************** Equipo "+id+" ***********************"+
			"\n                                          **  Nombre: "+name+
			"\n                                          **  Entrenador principal: "+mainCoach.getName()+message;
	}
}