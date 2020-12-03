package model;
import java.util.*;

public class FootballClub{

	//Constant
	public final static int NUM_TEAMS = 2;
	public final static int SIX = 6;

	//Atributes
	private String name;
	private String nit;
	private String foundationDate;

	//Relationships
	private Team teamA;
	private Team teamB;
	private Coach[][] office;
	private ArrayList <Employee> employees;

	//Getters and Setters 

	/**
	* This method returns the name of a user. <br>
	* <b>name</b>: getUserName <br>
	* @return String <code> userName </code> that is a variable with the name of a user.
	*/

	public String getName(){
		return name;
	}

	/**
	* this method modifies the name of a user. <br>
	* <b>name</b>: setUserName <br>
	* <b>post</b>: the name of the user has been changed. <br>
	* @param name is a String variable.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* This method returns the title of a song. <br>
	* <b>name</b>: getTitle <br>
	* @return String <code> title </code> that is variable with the title of a song.
	*/

	public String getNit(){
		return nit;
	}

	/**
	* this method modifies the title of a song. <br>
	* <b>name</b>: setTitle <br>
	* <b>post</b>: the title of the song has been changed. <br>
	* @param pTitle is a String variable.
	*/

	public void setNit(String nit){
		this.nit = nit;
	}

	/**
	* This method returns the title of a song. <br>
	* <b>name</b>: getTitle <br>
	* @return String <code> title </code> that is variable with the title of a song.
	*/

	public String getFoundationDate(){
		return foundationDate;
	}

	/**
	* this method modifies the title of a song. <br>
	* <b>name</b>: setTitle <br>
	* <b>post</b>: the title of the song has been changed. <br>
	* @param foundationDate is a String variable.
	*/

	public void setFoundationDate(String foundationDate){
		this.foundationDate = foundationDate;
	}

	/**
	* This method returns the genres of a playlist in the manager as list of Genre constants. <br>
	* <b>name</b>: getGenres <br>
	* @return Genre <code> genres[] </code> that is a list with all the genres of a playlist.
	*/

	public Coach[][] getOffice(){
		return office;
	}

	/**
	* this method modifies the genres of a playlist. <br>
	* <b>name</b>: setGenres <br>
	* <b>post</b>: the genres of a playlist has been changed. <br>
	* @param pGenres is a list of Genre constants.
	*/

	public void setOffice(Coach[][] office){
		this.office = office;
	}

	public ArrayList<Employee> getEmployees(){
		return employees;
	}

	public void setElements(ArrayList<Employee> employees){
		this.employees = employees;
	}

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: FootballClub <br>
	* <b>post</b>: The atributes and relationships of the class were inicializated. <br>
	*/

	public FootballClub(String name, String nit, String date){
		this.name = name;
		this.nit = nit;
		this.foundationDate = date;
		employees = new ArrayList<Employee>();
		office = new Coach[SIX][SIX];
	}

	/**
	* This method looks for the name of a user in the list of registered users, and returns an object of type User. <br>
	* <b>name</b>: createTeam.<br>
	* <b>pre</b>: the variable nameUser is already inicializated. <br>
 	* <b>post</b>: An object of type User was returned. <br>
 	* @param nameTeam is a String variable that contains the name of the user. 
 	* @return User <code> objUser </code> that is an object that could be null or full.
	*/

	public String createTeam(String nameTeam, char id){
		String message = "\nEl equipo ha sido creado exitosamente";
		if(id==Team.TEAM_A){
			teamA = new Team(nameTeam, id);
		} else{
			if(teamA.getName().equalsIgnoreCase(nameTeam)){
				message = "\nYa existe un equipo registrado con ese nombre, intentelo nuevamente";
			} else{
				teamB = new Team(nameTeam, id);
			}
		} return message;	
	}

	/**
	* This method looks for an specific employee in the list of registered employees, and returns an object of type Employee. <br>
	* <b>name</b>: findEmployee.<br>
	* <b>pre</b>: the variable nameEmployee is already inicializated. <br>
 	* <b>post</b>: An object of type Employee was returned. <br>
 	* @param id is a String variable that contains the name of an employee. 
 	* @return Employee <code> findEmployee </code> that is an object that could be null or full.
	*/

	public Employee findEmployee(String id){
		Employee objEmployee = null;
		boolean find = false;
		for(int k=0;k<employees.size() && !find;k++){
			if(employees.get(k).getId().equalsIgnoreCase(id)){
				find = true;
				objEmployee = employees.get(k);
			}
		} return objEmployee;
	}

	/**
	* This method creates a new employee with its features, and adds it to the list of users. <br>
	* <b>name</b>: addEmployee.<br>
	* <b>pre</b>: the variables userName, password, and age are already inicializated. <br>
 	* <b>post</b>: the user was created successfully or the user couldn't be created. <br>
 	* @param nameEmployee is a String variable that contains the name of the user. 
 	* @param id is a String variable that contains the password of the user.
 	* @param salary is an integer variable that contains the age of the user.
 	* @param numShirt an integer variable that contains the age of the user.
 	* @param team is an integer variable that contains the age of the user.
 	* @param position is an integer variable that contains the age of the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String addEmployee(String name, String id, double salary, int numShirt, String team, double averageGrade, int position){
		Employee objEmployee = findEmployee(id);
		String message = "";
		if(objEmployee==null && (teamA.getName().equalsIgnoreCase(team)||teamB.getName().equalsIgnoreCase(team))){
			if(teamA.getName().equalsIgnoreCase(team)){
				message = teamA.findNumShirt(numShirt);
			}else{
				message = teamB.findNumShirt(numShirt);
			}
			if(message.equals("El numero de camiseta puede ser asignado")){
				Player newEmployee = new Player(name, id, salary, numShirt, averageGrade, position);
				if(teamA.getName().equalsIgnoreCase(team)){
				message = teamA.addPlayer(newEmployee);
				}else{
					message = teamB.addPlayer(newEmployee);
				}
				if(message.equals("\nEl jugador ha sido asignado al equipo y registrado en el club exitosamente")){
					employees.add(newEmployee);
				}
			} 
		} else{ 
			if(objEmployee!=null){
				message = "\nYa existe un empleado con esa identificacion, intentelo nuevamente";
			} 
			if(!(teamA.getName().equalsIgnoreCase(team)) && !(teamB.getName().equalsIgnoreCase(team))){
				message = "\nEl equipo no existe, intentelo nuevamente";
			}
		} return message;	
	}

	/**
	* This method creates a new user with its features, and adds it to the list of users. <br>
	* <b>name</b>: createUser.<br>
	* <b>pre</b>: the variables userName, password, and age are already inicializated. <br>
 	* <b>post</b>: the user was created successfully or the user couldn't be created. <br>
 	* @param userName is a String variable that contains the name of the user. 
 	* @param password is a String variable that contains the password of the user.
 	* @param age is an integer variable that contains the age of the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String addEmployee(String name, String id, double salary, int experience, int numTeams, String team, int numChampionships, ArrayList<String> championships){
		Employee objEmployee = findEmployee(id);
		String message = "";
		if(objEmployee==null && (teamA.getName().equalsIgnoreCase(team)||teamB.getName().equalsIgnoreCase(team))){
			MainCoach newEmployee = new MainCoach(name, id, salary, experience, numTeams, numChampionships, championships);
			if(teamA.getName().equalsIgnoreCase(team)){
				message = teamA.addMainCoach(newEmployee);
			}else{
				message = teamB.addMainCoach(newEmployee);
			}
			if(message.equals("\nEl entrenador principal ha sido asignado al equipo y registrado en el club exitosamente")){
				employees.add(newEmployee);
				addCoachesToOffices(newEmployee);
			}	
		} else{ 
			if(objEmployee!=null){
				message += "\nYa existe un empleado con esa identificacion, intentelo nuevamente";
			} 
			if(!(teamA.getName().equalsIgnoreCase(team)) && !(teamB.getName().equalsIgnoreCase(team))){
				message += "\nEl equipo no existe, digitelo nuevamente";
			}	
		} return message;	
	}

	/**
	* This method creates a new user with its features, and adds it to the list of users. <br>
	* <b>name</b>: createUser.<br>
	* <b>pre</b>: the variables userName, password, and age are already inicializated. <br>
 	* <b>post</b>: the user was created successfully or the user couldn't be created. <br>
 	* @param userName is a String variable that contains the name of the user. 
 	* @param password is a String variable that contains the password of the user.
 	* @param age is an integer variable that contains the age of the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String addEmployee(String name, String id, double salary, int experience, int profession, ArrayList<Integer> expertises, String team){
		Employee objEmployee = findEmployee(id); 
		String message = "";
		if(objEmployee==null && (teamA.getName().equalsIgnoreCase(team)||teamB.getName().equalsIgnoreCase(team))){
			AssistantCoach newEmployee = new AssistantCoach(name, id, salary, experience, profession, expertises);
			if(teamA.getName().equalsIgnoreCase(team)){
				message = teamA.addAssistantCoach(newEmployee);
			}else{
				message = teamB.addAssistantCoach(newEmployee);
			}
			if(message.equals("\nEl entrenador asistente ha sido asignado al equipo y registrado en el club exitosamente")){			
				employees.add(newEmployee);
				addCoachesToOffices(newEmployee);
			}	
		} else{
			if(objEmployee!=null){
				message += "\nYa existe un empleado con esa identificacion, intentelo nuevamente";
			} 
			if(!(teamA.getName().equalsIgnoreCase(team)) && !(teamB.getName().equalsIgnoreCase(team))){
				message += "\nEl equipo no existe, digitelo nuevamente";
			}
		} return message;	
	}

	public void addCoachesToOffices(Coach coach){
		boolean stop = false;
		for(int i=0;i<SIX && !stop;i+=2){
			if(i%2==0){
				for(int j=0;j<SIX && !stop;j+=2){
					if(office[i][j]==null){
						office[i][j] = coach;
						stop = true;
					}
				}
			}else{
				for(int j=SIX-1;j>=0 && !stop;j-=2){
					if(office[i][j]==null){
						office[i][j] = coach;
						stop = true;
					}
				}
			}
		}			
	}

	public String deleteEmployee(String id, String team){
		String message = "";
		Employee objEmployee = findEmployee(id);
		if(objEmployee!=null && (teamA.getName().equalsIgnoreCase(team)||teamB.getName().equalsIgnoreCase(team))){
			if(teamA.getName().equalsIgnoreCase(team)){
				message = teamA.deleteEmployee(objEmployee);
			}else{
				message = teamB.deleteEmployee(objEmployee);
			}
			if(message.equals("\nEl proceso se realizo exitosamente, el empleado fue despedido")){
				objEmployee.setState(Employee.INACTIVE);
			}	
		} else{
			if(objEmployee==null){
				message += "\nNo existe un empleado del club con la identificacion ingresada, intentelo nuevamente";
			} 
			if(!(teamA.getName().equalsIgnoreCase(team)) && !(teamB.getName().equalsIgnoreCase(team))){
				message += "\nEl equipo no existe, digitelo nuevamente";
			}
		} return message;	
	}

	public String changeSalaryEmployee(String id, double newSalary, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nEl salario del empleado ha sido actualizado exitosamente";
		switch(option){
			case 1:
				if(objEmployee!=null && objEmployee instanceof Player){
					((Player)objEmployee).setSalary(newSalary);
				}else{
					if(objEmployee==null){
						message += "\nEl empleado no existe, intentelo nuevamente";
					}
					if(!(objEmployee instanceof Player)){
						message += "\nEl empleado al que desea actualizarle la informacion no es un jugador, intentelo nuevamente";
					}
				}
				break;
			case 2:
				if(objEmployee!=null && objEmployee instanceof MainCoach){
					((MainCoach)objEmployee).setSalary(newSalary);
				}else{
					if(objEmployee==null){
						message += "\nEl empleado no existe, intentelo nuevamente";
					}
					if(!(objEmployee instanceof MainCoach)){
						message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador principal, intentelo nuevamente";
					}
				}
				break;
			case 3:
				if(objEmployee!=null && objEmployee instanceof AssistantCoach){
					((AssistantCoach)objEmployee).setSalary(newSalary);
				}else{
					if(objEmployee==null){
						message += "\nEl empleado no existe, intentelo nuevamente";
					}
					if(!(objEmployee instanceof AssistantCoach)){
						message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador asistente, intentelo nuevamente";
					}
				}
				break;		
		} return message;
	}

	public String changeNumShirt(String id, String team, int numShirt, int option){
		Employee objEmployee = findEmployee(id);
		String message = "";
		if(objEmployee!=null && (teamA.getName().equalsIgnoreCase(team)||teamB.getName().equalsIgnoreCase(team)) && objEmployee instanceof Player && option==1){
			if(teamA.getName().equalsIgnoreCase(team)){
				message = teamA.findNumShirt(numShirt);
			}else{
				message = teamB.findNumShirt(numShirt);
			}
			if(message.equals("El numero de camiseta puede ser asignado")){
				((Player)objEmployee).setNumShirt(numShirt);
				message =  "\nEl numero de camiseta del jugador ha sido actualizado exitosamente";
			}
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(teamA.getName().equalsIgnoreCase(team)) && !(teamB.getName().equalsIgnoreCase(team))){
				message += "\nEl equipo no existe, digitelo nuevamente";
			}
			if(!(objEmployee instanceof Player)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un jugador, intentelo nuevamente";
			}
			if(option!=1){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a jugadores";
			}
		} return message;		
	}

	public String changeNumGoals(String id, int numGoals, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nEl numero de goles que el jugador ha marcado en el club ha sido actualizado exitosamente";
		if(objEmployee!=null && objEmployee instanceof Player && option==1){
			((Player)objEmployee).setNumGoals(numGoals);
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(objEmployee instanceof Player)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un jugador, intentelo nuevamente";
			}
			if(option!=1){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a jugadores";
			}
		} return message;		
	}

	public String changeAverageGrade(String id, double averageGrade, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nLa calificacion promedio del jugador ha sido actualizada exitosamente";
		if(objEmployee!=null && objEmployee instanceof Player && option==1){
			((Player)objEmployee).setAverageGrade(averageGrade);
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(objEmployee instanceof Player)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un jugador, intentelo nuevamente";
			}
			if(option!=1){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a jugadores";
			}
		} return message;
	}

	public String changePosition(String id, int position, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nLa posicion del jugador ha sido actualizada exitosamente";
		if(objEmployee!=null && objEmployee instanceof Player && option==1){
			switch(position){
				case 1:
					((Player)objEmployee).setPosition(Position.PORTERO); 
					break;
				case 2:
					((Player)objEmployee).setPosition(Position.DEFENSOR);  
					break;
				case 3:
					((Player)objEmployee).setPosition(Position.VOLANTE); 
					break;
				case 4:
					((Player)objEmployee).setPosition(Position.DELANTERO); 
					break;
			}		
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(objEmployee instanceof Player)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un jugador, intentelo nuevamente";
			}
			if(option!=1){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a jugadores";
			}
		} return message;
	}

	public String changeExperienceEmployee(String id, int experience, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nLa calificacion promedio del jugador ha sido actualizada exitosamente";
		switch(option){
			case 1:
				message = "\nLo sentimos, este atributo solo puede ser actualizado a entrenadores";
				break;
			case 2:
				if(objEmployee!=null && objEmployee instanceof MainCoach){
					((MainCoach)objEmployee).setYearsExperience(experience);
				}else{
					if(objEmployee==null){
						message += "\nEl empleado no existe, intentelo nuevamente";
					}
					if(!(objEmployee instanceof MainCoach)){
						message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador principal, intentelo nuevamente";
					}
				}
				break;
			case 3:
				if(objEmployee!=null && objEmployee instanceof AssistantCoach){
					((AssistantCoach)objEmployee).setYearsExperience(experience);
				}else{
					if(objEmployee==null){
						message += "\nEl empleado no existe, intentelo nuevamente";
					}
					if(!(objEmployee instanceof AssistantCoach)){
						message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador asistente, intentelo nuevamente";
					}
				}
				break;			
		} return message;
	}

	public String changeNumTeamsEmployee(String id, int numTeams, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nEl numero de equipos que el entrenador ha tenido a cargo durante su carrera ha sido actualizado exitosamente";
		if(objEmployee!=null && objEmployee instanceof MainCoach && option==2){
			((MainCoach)objEmployee).setNumTeams(numTeams);
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(objEmployee instanceof MainCoach)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador principal, intentelo nuevamente";
			}
			if(option!=2){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a entrenadores principales";
			}
		} return message;
	}

	public String changeChampionshipsEmployee(String id, int numChampionships, ArrayList<String> championships, int option){
		Employee objEmployee = findEmployee(id);
		String message = "\nLos campeonatos ganados por el entrenador principal han sido actualizados exitosamente";
		if(objEmployee!=null && objEmployee instanceof MainCoach && option==2){
			objEmployee.setNumChampionships((getNumChampionships())+numChampionships);
			for(int j=0;j<championships.size();j++){
				((MainCoach)objEmployee).getChampionships().add(championships.get(j));
			}
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(objEmployee instanceof MainCoach)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador principal, intentelo nuevamente";
			}
			if(option!=2){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a entrenadores principales";
			}
		} return message;
	}

	public String changeExpertisesEmployee(String id, ArrayList<Integer> expertises, int option){
		Employee objEmployee = findEmployee(id);
		ArrayList<Expertise> cExpertises = new ArrayList<>();
		String message = "\nLas experticias del entrenador han sido actualizadas exitosamente";
		if(objEmployee!=null && objEmployee instanceof AssistantCoach && option==3){
			for(int k=0; k<expertises.size();k++){
				switch(expertises.get(k)){
					case 1:
						cExpertises.add(Expertise.OFENSIVO); 
						break;
					case 2:
						cExpertises.add(Expertise.DEFENSIVO); 
						break;
					case 3:
						cExpertises.add(Expertise.POSESION); 
						break;
					case 4:
						cExpertises.add(Expertise.JUGADAS_LABORATORIO); 
						break;
					case 5:
						cExpertises.add(Expertise.ENTRENADOR_FISICO); 
						break;
					case 6:
						cExpertises.add(Expertise.ENTRENADOR_DE_ARQUEROS); 
						break;					
				}
			}
			for(int i=0;i<((AssistantCoach)objEmployee).getExpertises().size();i++){
				if(((AssistantCoach)objEmployee).getExpertises().get(i).equals(cExpertises.get(i))){
					cExpertises.remove(i);
				}
			}
			for(int j=0;j<cExpertises.size();j++){
				((AssistantCoach)objEmployee).getExpertises().add(cExpertises.get(j));
			}
		}else{
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(!(objEmployee instanceof AssistantCoach)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador asistente, intentelo nuevamente";
			}
			if(option!=3){
				message += "\nLo sentimos, este atributo solo puede ser actualizado a entrenadores asistentes";
			}
		} return message;
	}

	public String changeInfoTeam(String name, String newName){
		String message = "\nEl nombre del equipo ha sido actualizado correctamente";
		if(teamA.getName().equalsIgnoreCase(name)||teamB.getName().equalsIgnoreCase(name)){
			if(teamA.getName().equalsIgnoreCase(name)){
				if(!teamB.getName().equalsIgnoreCase(newName)){
					teamA.setName(newName);
				}		
			}else{
				if(!teamA.getName().equalsIgnoreCase(newName)){
					teamB.setName(newName);
				}
			}
		}else{
			message = "\nEl equipo no existe, intentelo nuevamente";
		} return message;
	}

	public String addLineupToTeam(String nameTeam, String date, int tactic, int defenses, int midfielders, int forwards){
		String message = " ";
		if(teamA.getName().equalsIgnoreCase(name)||teamB.getName().equalsIgnoreCase(name)){
			if(teamA.getName().equalsIgnoreCase(name)){
				message = teamA.addNewLineup(date,tactic,defenses,midfielders,forwards);	
			}else{
				message = teamB.addNewLineup(date,tactic,defenses,midfielders,forwards);	
			}
		}else{
			message = "\nEl equipo no existe, intentelo nuevamente";
		} return message;
	}

	/**
	* This method displays the information of all the playlists that were created by the user. <br>
	* <b>name</b>: showPlaylists.<br>
 	* <b>post</b>: the information of each song of each playlist was saved in a String variable that is going to be shown in the Main class. <br>
 	* @return String <code> message </code> that is a variable with all the information of the playlists that were added by a user.
	*/

	public String showEmployees(){
		String message = "";
		for(int k=0;k<employees.size();k++){
			message += employees.get(k).toString();
		} 
		return message;
	}

	/**
	* This method displays the information of all the playlists that were created by the user. <br>
	* <b>name</b>: showPlaylists.<br>
 	* <b>post</b>: the information of each song of each playlist was saved in a String variable that is going to be shown in the Main class. <br>
 	* @return String <code> message </code> that is a variable with all the information of the playlists that were added by a user.
	*/

	public String showTeams(){
		String message = teamA.toString()+"\n"+teamB.toString();
		return message;
	}

	public String showAnEmployee(String id){
		String message = "";
		Employee objEmployee = findEmployee(id);
		if(objEmployee==null){
			message = "El empleado no existe, intentelo nuevamente";
		} else{
			message = objEmployee.toString();
		} return message;
	}

	public String showATeam(String name){
		String message = "";
		if(teamA.getName().equalsIgnoreCase(name)||teamB.getName().equalsIgnoreCase(name)){
			if(teamA.getName().equalsIgnoreCase(name)){
				message = teamA.toString();		
			}else{
				message = teamB.toString();
			}
		}else{
			message = "\nEl equipo no existe, intentelo nuevamente";
		} return message;
	}

	public String showFacilities(){
		String message = "\nCamerino del equipo A: \n"+teamA.showDressingRoom()+"\nCamerino del equipo B: \n"+teamB.showDressingRoom()+"\nJugadores del equipo B que se quedaron sin camerino: \n";
		Player[] playersOutDressingRoom = teamB.calculatePlayersOut();
		for(int k=0;k<playersOutDressingRoom.length;k++){
			if(playersOutDressingRoom[k]!=null){
				message+="["+playersOutDressingRoom[k].getName()+"]";
			}
		}
		message+="\nOficinas de los entrenadores\n";
		for(int x=0;x<SIX;x++){
			for(int k = 0;k<SIX;k++){
				if(office[x][k]!=null){
					message += "["+office[x][k].getName()+"]"+" ";
				}else{
					message += "[	X   ]" +" ";
				}
			}
			message+="\n";
		} return message;
	}

	public String toString(){
		return "\n                                          ********************** Club "+name+" ***********************"+"\n                                          **  NIT: "+nit+"\n                                          **  Fecha de fundacion: "+foundationDate;
	}
}
