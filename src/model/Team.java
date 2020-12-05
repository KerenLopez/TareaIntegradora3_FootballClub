package model;
import java.util.*;

public class Team{

	//Atributes
	private String name;
	private char id;

	//Constants
	public final static char TEAM_A = 'A';
	public final static char TEAM_B = 'B';
	public final static int MAX_NUM_PLAYERS = 25;
	public final static int MAX_NUM_ASSCOACHES = 3;
	public final static int SEVEN = 7;
	public final static int SIX = 6;

	//Relationships
	private Player[][] dressingRoom;
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
	* This method modifies the name of a team. <br>
	* <b>name</b>: setName <br>
	* <b>post</b>: the name of a team has been changed. <br>
	* @param name is a String variable.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* This method returns the ID of a team. <br>
	* <b>name</b>: getId <br>
	* @return char <code> id </code> that is a variable with the ID of a team.
	*/

	public char getId(){
		return id;
	}

	/**
	* This method modifies the ID of a team. <br>
	* <b>name</b>: setId <br>
	* <b>post</b>: the ID of a team has been changed. <br>
	* @param id is a char variable.
	*/

	public void setId(char id){
		this.id = id;
	}

	/**
	* This method returns the dressing room of a team. <br>
	* <b>name</b>: getDressingRoom <br>
	* @return Player[][] <code> dressingRoom </code> that is a matrix of players that represents how they are located in the dressing room of a team.
	*/

	public Player[][] getDressingRoom(){
		return dressingRoom;
	}

	/**
	* This method modifies the dressing room of a team. <br>
	* <b>name</b>: setDressingRoom <br>
	* <b>post</b>: the dressing room of a team has been changed. <br>
	* @param dressingRoom is a matrix of Players.
	*/

	public void setDressingRoom(Player[][] dressingRoom){
		this.dressingRoom = dressingRoom;
	}

	/**
	* This method returns all the lineups of a team. <br>
	* <b>name</b>: getLineups <br>
	* @return ArrayList of Lineup <code> lineups </code> that contains all the lineups of a team.
	*/

	public ArrayList<Lineup> getLineups(){
		return lineups;
	}

	/**
	* This method modifies the lineups of a team. <br>
	* <b>name</b>: setLineups<br>
	* <b>post</b>: the lineups of a team has been changed. <br>
	* @param lineups is an ArrayList of type Lineup.
	*/

	public void setLineups(ArrayList<Lineup> lineups){
		this.lineups = lineups;
	}

	/**
	* This method returns the main coach of a team. <br>
	* <b>name</b>: getMainCoach <br>
	* @return MainCoach <code> mainCoach </code> that is an object that represents the main coach of a team.
	*/

	public MainCoach getMainCoach(){
		return mainCoach;
	}

	/**
	* This method modifies the main coach of a team. <br>
	* <b>name</b>: setMainCoach<br>
	* <b>post</b>: the main coach of a team has been changed. <br>
	* @param mainCoach is an object of type MainCoach.
	*/

	public void setMainCoach(MainCoach mainCoach){
		this.mainCoach = mainCoach;
	}

	/**
	* This method returns the assistant coaches of a team. <br>
	* <b>name</b>: getAssistantCoaches <br>
	* @return AssistantCoach <code> assistantCoaches[] </code> that is a list with the assistant coaches of a team.
	*/

	public AssistantCoach[] getAssistantCoaches(){
		return assistantCoaches;
	}

	/**
	* This method modifies the assistant coaches of a team. <br>
	* <b>name</b>: setAssistantCoaches <br>
	* <b>post</b>: the assistant coaches of a team has been changed. <br>
	* @param assistantCoaches is a list of AssistantCoach objects.
	*/

	public void setAssistantCoaches(AssistantCoach[] assistantCoaches){
		this.assistantCoaches = assistantCoaches;
	}

	/**
	* This method returns the players of a team. <br>
	* <b>name</b>: getPlayers <br>
	* @return Player[] <code> players </code> that is a list with the players of a team.
	*/

	public Player[] getPlayers(){
		return players;
	}

	/**
	* This method modifies the players of a team. <br>
	* <b>name</b>: setPlayers <br>
	* <b>post</b>: the players of a team has been changed. <br>
	* @param players is a list of Player objects.
	*/

	public void setPlayers(Player[] players){
		this.players = players;
	}

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: Team <br>
	* <b>pre</b>: the variables name and id are already inicializated. <br>
	* <b>post</b>: the atributes and some relationships of the class were inicializated. <br>
	* @param name is a String variable that contains the name of a team.
	* @param id is a String variable that contains the ID of a team.
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
	* This method looks for a number of shirt in the list of players belonging to a team. <br>
	* <b>name</b>: findNumShirt.<br>
	* <b>pre</b>: the variable numShirt is already inicializated. <br>
 	* <b>post</b>: the number of shirt was founded or not. <br>
 	* @param numShirt is an integer variable that contains the number of a shirt. 
 	* @return String <code> message </code> that is variable with a notice for the user.
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

	/**
	* This method looks for an employee in the members of a team. <br>
	* <b>name</b>: findMember.<br>
	* <b>pre</b>: the variable id is already inicializated. <br>
 	* <b>post</b>: the employee was founded or not in the members of the team. <br>
 	* @param id is an String variable that contains the id of an employee. 
 	* @return String <code> message </code> that is variable with a notice for the user.
	*/

	public String findMember(String id){
		String message = "\nEl empleado pertenece al equipo";
		boolean find = false;
		for(int k=0;k<players.length;k++){
			if(players[k]!=null && players[k].getId().equals(id)){
				find = true;
			}
		}
		for(int x=0;x<assistantCoaches.length;x++){
			if(assistantCoaches[x]!=null && assistantCoaches[x].getId().equals(id)){
				find = true;
			}
		}
		if(mainCoach!=null && mainCoach.getId().equals(id)){
			find = true;
		} 
		if(!find){
			message = "\nEl empleado no pertenece al equipo ingresado, intentelo nuevamente";
		} return message;	
	}

	/**
	* This method adds a player in a team. <br>
	* <b>name</b>: addPlayer.<br>
	* <b>pre</b>: the object newPlayer is already inicializated. <br>
 	* <b>post</b>: the player was added successfully or the player couldn't be added to a team. <br>
 	* @param newPlayer is an object of type Player that is going to be added to a team. 
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

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

	/**
	* This method adds a main coach in a team. <br>
	* <b>name</b>: addMainCoach.<br>
	* <b>pre</b>: the object newMCoach is already inicializated. <br>
 	* <b>post</b>: the main coach was added successfully or the main coach couldn't be added to a team. <br>
 	* @param newMCoach is an object of type MainCoach that is going to be added to a team. 
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String addMainCoach(MainCoach newMCoach){
		String message = "\nEl entrenador principal ha sido asignado al equipo y registrado en el club exitosamente";
		if(mainCoach==null){
			mainCoach = newMCoach;		
		} else{
			message = "\nYa se ha asignado un entrenador principal al equipo, no es posible agregar otro";
		}
		return message;
	}

	/**
	* This method adds a assistant coach in a team. <br>
	* <b>name</b>: addAssistantCoach.<br>
	* <b>pre</b>: the object newAssCoach is already inicializated. <br>
 	* <b>post</b>: the assistant coach was added successfully or the assistant coach couldn't be added to a team. <br>
 	* @param newMCoach is an object of type AssistantCoach that is going to be added to a team. 
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

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

	/**
	* This method removes an employee of a team. <br>
	* <b>name</b>: deleteEmployee.<br>
	* <b>pre</b>: the object fireEmployee is already inicializated. <br>
 	* <b>post</b>: the employee was removed successfully or the employee couldn't be removed of a team. <br>
 	* @param fireEmployee is an object of type Employee that is going to be removed of a team. 
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

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

	/**
	* This method adds a player to a dressing room. <br>
	* <b>name</b>: addPlayersToDressingRoom <br>
	* <b>post</b>: All the players of a team were successfully added to the dressing room. <br>
	*/

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

	/**
	* This method saves the information of the dressing room of a team in variable that will be shown later to the user. <br>
	* <b>name</b>: showDressingRoom.<br>
 	* <b>post</b>: the information of the dressing room was returned successfully. <br>
 	* @return String <code> message </code> that is a variable with the information of the dressing room of a team.
	*/

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

	/**
	* This method looks for the players who were left without a dressing room. <br>
	* <b>name</b>: calculatePlayersOut.<br>
 	* <b>post</b>: the players who are without a dressing room were returned successfully. <br>
 	* @return Player ArrayList <code> playersOut </code> that contains the players who were left without a dressing room.
	*/

	public ArrayList<Player> calculatePlayersOut(){
		boolean stop = false;
		ArrayList<Player> playersOut = new ArrayList<>();
		for(int k=0;k<players.length;k++){
			stop = false;
			for(int x = 0;x<SEVEN && !stop;x++){
				for(int i = 0;i<SIX && !stop;i++){
					if(dressingRoom[x][i]!=null && players[k]!=null){
						if(dressingRoom[x][i].getId().equals(players[k].getId())){
							stop = true;
						}
					}
				}
			} 
			if(!stop && players[k]!=null){
				playersOut.add(players[k]);
			}
		} 
		return playersOut;
	}

	/**
	* This method adds a lineup of a team. <br>
	* <b>name</b>: addNewLineup.<br>
	* <b>pre</b>: the variables such as date, tactic, defenses, midfielders and forwards are already inicializated. <br>
 	* <b>post</b>: the lineup of a team was added successfully to the ArrayList of lineups. <br>
 	* @param date is a String variable that contains the date when a lineup was implemented by a team.
	* @param tactic is a integer variable that represents the tactic that is used in a lineup.
	* @param defenses is a integer variable that contains the number of players that are going to be in the line of defense at the formation.
	* @param midfielders is a integer variable that contains the number of players that are going to be in the line of midfielders at the formation.
	* @param forwards is a integer variable that contains the number of players that are going to be in the line of forwards at the formation.
 	* @return String <code> message </code> that is a variable with the formation that was used in a lineup.
	*/

	public String addNewLineup(String date, int tactic, int defenses, int midfielders, int forwards){
		Lineup newLineup = new Lineup(date, tactic);
		lineups.add(newLineup);
		String message = newLineup.showFormation(defenses, midfielders, forwards);
		return message;
	}

	/**
	* This method produces a String with all the information of a team. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: All the information of a team was returned. <br>
 	* @return out in a <code> String </code> variable all the information of a team.
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
		message+="\n                                          *******************************************************"+"\n                                          ***************** lista de alineaciones ***************";
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