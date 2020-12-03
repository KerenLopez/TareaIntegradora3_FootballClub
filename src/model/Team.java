package model;
import java.util.*;

public class Team{

	//Atributes
	private String name;
	private char id;

	//Constants
	public final static char TEAM_A = 'A';
	public final static char TEAM_B = 'B';

	//Constants
	public final static int MAX_NUM_PLAYERS = 25;
	public final static int MAX_NUM_ASSCOACHES = 3;
	public final static int SEVEN = 3;
	public final static int SIX = 3;
	public final static int FOUR = 4;

	//Relationships
	private Player[][] dressingRoom;
	private Coach[][] office;
	private ArrayList <Lineup> lineups;
	private MainCoach mainCoach;
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

	/**
	* This method returns the id of a team. <br>
	* <b>name</b>: getId <br>
	* @return char <code> id </code> that is a variable with the id of a team.
	*/

	public char getId(){
		return id;
	}

	/**
	* this method modifies the id of a team. <br>
	* <b>name</b>: setId <br>
	* <b>post</b>: the id of a team has been changed. <br>
	* @param id is a char variable.
	*/

	public void setId(char id){
		this.id = id;
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
		assistantCoaches = new AssistantCoach[MAX_NUM_ASSCOACHES];
		lineups = new ArrayList<Lineup>();
		if(id==TEAM_A){
			dressingRoom = new Player[SEVEN][SEVEN];
		}else{
			dressingRoom = new Player[SEVEN][SIX];
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
					message = "\nEl numero de camiseta ingresado ya se encuentra asignado a otro jugador del equipo, intentelo nuevamente";
				}
			} 
		} else{
			message = "\nEl rango en el que el numero de camiseta de un jugador debe encontrarse es entre 1 y 99";
		} return message;	
	}

	public String addPlayer(Player newPlayer){
		String message = "\nEl jugador ha sido asignado al equipo y registrado en el club exitosamente";
		boolean add = false;
		if(players[MAX_NUM_PLAYERS-1]==null){
			for(int k=0;k<players.length && !add;k++){
				if(players[k]==null){
					players[k]= newPlayer;
					add = true;
				}
			}
		}else{
			message = "\nYa han sido agregados todos los jugadores posibles al equipo";
		} return message;	
	}

	public String addMainCoach(MainCoach newMCoach){
		String message = "\nEl entrenador principal ha sido asignado al equipo y registrado en el club exitosamente";
		if(mainCoach==null){
			mainCoach = newMCoach;		
		} else{
			message = "\nYa se ha asignado un entrenador principal al equipo, no es posible agregar otro";
		}
		return message;
	}

	public String addAssistantCoach(AssistantCoach newAssCoach){
		String message = "\nEl entrenador asistente ha sido asignado al equipo y registrado en el club exitosamente";
		boolean add = false;
		if(assistantCoaches[MAX_NUM_ASSCOACHES-1]==null){
			for(int k=0;k<assistantCoaches.length && !add;k++){
				if(assistantCoaches[k]==null){
					assistantCoaches[k]=newAssCoach;
					add = true;
				}
			} 
		}else{
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
			if(!find){
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
				if(assistantCoaches[x]!=null && assistantCoaches[x].getId().equals(((AssistantCoach)fireEmployee).getId())){
					assistantCoaches[x]= null;
					find = true;
				}
			}
			if(find==false){
				message = "\nEl empleado no pertenece al equipo ingresado, intentelo nuevamente";
			}
		} 
		return message;
	}

	public void addPlayersToDressingRoom(){
		boolean stop = false;
		List<Player> listPlayers = Arrays.asList(players);
		Collections.shuffle(listPlayers);
		listPlayers.toArray(players);
		if(id==TEAM_A){
			for(int i=0;i<SEVEN;i++){
				for(int v=0;v<SEVEN;v++){
					dressingRoom[i][v]=null;
				}
			}
			for(int x=0;x<players.length;x++){
				if(players[x]!=null){
					stop = false;
					for(int k=0;k<SEVEN && !stop;k++){
						if(k%2==0){
							for(int j=0;j<SEVEN && !stop;j+=2){
								if(dressingRoom[k][j]==null){
									dressingRoom[k][j] = players[x];
									stop = true;
								}
							}
						}else{
							for(int j=SEVEN-1;j>=0 && !stop;j-=2){
								if(dressingRoom[k][j]==null){
									dressingRoom[k][j] = players[x];
									stop = true;
								}
							}
						}
					}
				}	
			}	
		} else{
			for(int i=0;i<SEVEN;i++){
				for(int v=0;v<SIX;v++){
					dressingRoom[i][v]=null;
				}
			}
			for(int x=0;x<players.length;x++){
				if(players[x]!=null){
					stop = false;
					for(int k=0;k<SEVEN && !stop;k++){
						if(k%2==0){
							for(int j=0;j<SIX && !stop;j+=2){
								if(dressingRoom[k][j]==null){
									dressingRoom[k][j] = players[x];
									stop = true;
								}
							}
						}else{
							for(int j=SIX-1;j>=0 && !stop;j-=2){
								if(dressingRoom[k][j]==null){
									dressingRoom[k][j] = players[x];
									stop = true;
								}
							}
						}
					}
				}	
			}	
		}		
	}

	public String showDressingRoom(){
		String message = "";
		addPlayersToDressingRoom();
		if(id==TEAM_A){
			for(int x=0;x<SEVEN;x++){
				for(int i = 0;i<SEVEN;i++){
					if(dressingRoom[x][i]!=null){
						message += "["+dressingRoom[x][i].getName()+"]"+" ";
					}else{
						message += "[	    ]"+" ";
					}
				}
				message+="\n";
			}
		}else{
			for(int x=0;x<SEVEN;x++){
				for(int i = 0;i<SIX;i++){
					if(dressingRoom[x][i]!=null){
						message += "["+dressingRoom[x][i].getName()+"]"+" ";
					}else{
						message += "[	    ]"+" ";
					}
				}
				message+="\n";
			}
		} return message;
	}

	public Player[] calculatePlayersOut(){
		Player[] playersOut = new Player[FOUR];
		for(int x=0;x<SEVEN;x++){
			for(int i = 0;i<SIX;i++){
				if(dressingRoom[x][i]!=null && !(dressingRoom[x][i].getName().equals(players[x]))){
					playersOut[x] = players[x];
				}
			}
		} return playersOut;
	}

	public String addNewLineup(String date, int tactic, int defenses, int midfielders, int forwards){
		Lineup newLineup = new Lineup(date, tactic);
		lineups.add(newLineup);
		String message = newLineup.showFormation(defenses, midfielders, forwards);
		return message;
	}

	/**
	* This method produces a String with the information of a private playlist. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of the playlist was returned. <br>
 	* @return out in a <code> String </code> variable all information of a private playlist.
	*/

	public String toString(){
		int contC = 0, contP = 0;
		String message = "";
		if(mainCoach!=null){
			message+="\n                                          **  Entrenador principal: "+mainCoach.getName();
		}else{
			message+="\n                                          **  Entrenador principal: No tiene";
		}
		for(int k=0;k<assistantCoaches.length;k++){
			if(assistantCoaches[k]!=null){
				message+="\n                                          **  Entrenador asistente #"+(k+1)+": "+assistantCoaches[k].getName();	
				contC+=1;
			}
		}
		for(int j=0;j<players.length;j++){
			if(players[j]!=null){
				message+="\n                                          **  Jugador #"+players[j].getNumShirt()+": "+players[j].getName();
				contP+=1;
			}
		}
		if(contC==0){
			message+="\n                                          **  Entrenadores asistentes: No tiene";
		}
		if(contP==0){
			message+="\n                                          **  Jugadores: No tiene";
		}
		message+="\n                                          **************** lista de alineaciones ***************";
		if(lineups.isEmpty()){
			message+="\n                                          No ha sido agregado ninguna alineacion al equipo aun";
		}else{
			for(int x=0;x<lineups.size();x++){
				message+=lineups.get(x).toString();
			}
		}
		return "\n                                          *******************************************************"+
			"\n                                          ********************** Equipo "+id+" ***********************"+
			"\n                                          **  Nombre: "+name+message;
	}
}