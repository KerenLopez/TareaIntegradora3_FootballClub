package model;
import java.util.*;

public class FootballClub{

	//Constant
	public final static int NUM_TEAMS = 2;

	//Atributes
	private String name;
	private String nit;
	private String foundationDate;

	//Relationships
	private Team[] teams;
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
	* @param pUserName is a String variable.
	*/

	public void setName(String pUserName){
		userName = pUserName;
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

	public void setNit(String pTitle){
		title = pTitle;
	}

	/**
	* This method returns the title of a song. <br>
	* <b>name</b>: getTitle <br>
	* @return String <code> title </code> that is variable with the title of a song.
	*/

	public double getFoundationDate(){
		return foundationDate;
	}

	/**
	* this method modifies the title of a song. <br>
	* <b>name</b>: setTitle <br>
	* <b>post</b>: the title of the song has been changed. <br>
	* @param pTitle is a String variable.
	*/

	public void setFoundationDate(double salary){
		this.salary = salary;
	}

	/**
	* This method returns the genres of a playlist in the manager as list of Genre constants. <br>
	* <b>name</b>: getGenres <br>
	* @return Genre <code> genres[] </code> that is a list with all the genres of a playlist.
	*/

	public Team[] getTeams(){
		return teams;
	}

	/**
	* this method modifies the genres of a playlist. <br>
	* <b>name</b>: setGenres <br>
	* <b>post</b>: the genres of a playlist has been changed. <br>
	* @param pGenres is a list of Genre constants.
	*/

	public void setTeams(Team[] teams){
		this.teams = teams;
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
		teams = new Team[NUM_TEAMS];
		employees = new ArrayList<Employee>();
		Coach[][] office = new Coach[6][6];
	}

	/**
	* This method looks for the name of a user in the list of registered users, and returns an object of type User. <br>
	* <b>name</b>: findTeam.<br>
	* <b>pre</b>: the variable nameUser is already inicializated. <br>
 	* <b>post</b>: An object of type User was returned. <br>
 	* @param nameTeam is a String variable that contains the name of the user. 
 	* @return User <code> objUser </code> that is an object that could be null or full.
	*/

	public Team findTeam(String nameTeam){
		Team objTeam = null;
		boolean find =false;
		for(int k=0;k<teams.length && !find;k++){
			if(teams[k]!=null && teams[k].getName().equalsIgnoreCase(nameTeam)){
				find=true;
				objTeam = teams[k];
			}
		} return objTeam;
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
		Team objTeam = findTeam(nameTeam);
		boolean stop =false;
		if(objTeam==null){
			for(int k=0;k<teams.length && !stop;k++){
				if(teams[k]!=null){
					stop=true;
					teams[k] = new Team(nameTeam, id);
				}
			} 
		} else{
			message = "\nYa existe un equipo registrado con ese nombre, intentelo nuevamente";
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

	public String addEmployee(String name, String id, double salary, int numShirt, String team, int position){
		Employee objEmployee = findEmployee(id);
		Team objTeam = findTeam(team);
		String message;
		if(objEmployee==null && objTeam!=null){
			message = objTeam.findNumShirt(numShirt);
			if(message.equals("El numero de camiseta puede ser asignado")){
				newEmployee = new Player(name, id, salary, numShirt, position);
				message = objTeam.addPlayer(newEmployee);
				if(message.equals("\nEl jugador ha sido asignado al equipo y registrado en el club exitosamente")){
					employees.add(newEmployee);
				}
			} 
		} else{ 
			if(objEmployee!=null){
				message = "\nEl empleado ya se encuentra registrado, intentelo nuevamente";
			} 
			if(objTeam==null){
				message = "\nEl equipo no existe, digitelo nuevamente";
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
		Team objTeam = findTeam(team);
		String message;
		if(objEmployee==null && objTeam!=null){
			newEmployee = new MainCoach(name, id, salary, experience, numTeams, numChampionships, championships);
			message = objTeam.addMainCoach(newEmployee);
			if(message.equals("\nEl entrenador principal ha sido asignado al equipo y registrado en el club exitosamente")){
				employees.add(newEmployee);
			}	
		} else{ 
			if(objEmployee!=null){
				message += "\nEl empleado ya se encuentra registrado, intentelo nuevamente";
			} 
			if(objTeam==null){
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
		Team objTeam = findTeam(team);
		String message;
		if(objEmployee==null && objTeam!=null){
			newEmployee = new MainCoach(name, id, salary, experience, profession, expertises);
			message = objTeam.addAssistantCoach(newEmployee);
			if(message.equals("\nEl entrenador asistente ha sido asignado al equipo y registrado en el club exitosamente")){
				employees.add(newEmployee);
			}	
		} else{
			if(objEmployee!=null){
				message += "\nEl empleado ya se encuentra registrado, intentelo nuevamente";
			} 
			if(objTeam==null){
				message += "\nEl equipo no existe, digitelo nuevamente";
			}
		} return message;	
	}

	public String deleteEmployee(String id, String team){
		String message = "";
		Employee objEmployee = findEmployee(id);
		Team objTeam = findTeam(team);
		if(objEmployee!=null && objTeam!=null){
			message = objTeam.deleteEmployee(objEmployee);
			if(message.equals("\nEl proceso se realizo exitosamente, el empleado fue despedido")){
				objEmployee.setState(Employee.INACTIVE);
			}	
		} else{
			if(objEmployee==null){
				message += "\nNo existe un empleado del club con la identificación ingresada, intentelo nuevamente";
			} 
			if(objTeam==null){
				message += "\nEl equipo ingresado no existe, digitelo nuevamente";
			}
		} return message;	
	}

	public String changeInfoEmployee(String team, String id, double salary, int numShirt, int numGoals, double averageGrade){
		Employee objEmployee = findEmployee(id);
		Team objTeam = findTeam(team);
		String message;
		if(objEmployee!=null && objTeam!=null && objEmployee instanceof Player){
			((Player)objEmployee);
			message = objTeam.findNumShirt(numShirt);
			if(message.equals("El numero de camiseta puede ser asignado")){
				objEmployee.setSalary(salary);
				objEmployee.setNumShirt(numShirt);
				objEmployee.setNumGoals(numGoals);
				objEmployee.setAverageGrade(averageGrade);
				message = "\nLa informacion del empleado fue actualizada correctamente";
			} 
		} else{ 
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			}
			if(objTeam==null){
				message += "\nEl equipo ingresado no existe, digitelo nuevamente";
			} 
			if(!(objEmployee instanceof Player)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un jugador, digitelo nuevamente";
			}
		} return message;	
	}

	public String changeInfoEmployee(String id, double salary, int experience, int numTeams, int numChampionships, Arraylist<String> championships){
		Employee objEmployee = findEmployee(id);
		String message;
		if(objEmployee!=null && objEmployee instanceof MainCoach){
			((MainCoach)objEmployee);
			objEmployee.setSalary(salary);
			objEmployee.setYearsExperience(experience);
			objEmployee.setNumTeams(numTeams);
			objEmployee.setNumChampionships((getNumChampionships())+numChampionships);
			objEmployee.setChampionships(championships);
			for(int i=0;i<objEmployee.getChampionships().size();i++){
				if(objEmployee.getChampionships().get(i).equals(championships.get(i))){
					championships.remove(i);
				}
			}
			for(int j=0;j<championships.size();j++){
				objEmployee.getExpertises().add(championships.get(j));
			}
			message = "\nLa informacion del empleado fue actualizada correctamente";
		} else{ 
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			} 
			if(!(objEmployee instanceof MainCoach)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador principal, digitelo nuevamente";
			}
		} return message;
	}

	public String changeInfoEmployee(String id, double salary, int experience, Arraylist<Integer> expertises){
		Employee objEmployee = findEmployee(id);
		ArrayList<Expertise> cExpertises = new ArrayList<Expertise>();
		String message;
		if(objEmployee!=null && objEmployee instanceof AssistantCoach){
			((AssistantCoach)objEmployee);
			objEmployee.setSalary(salary);
			objEmployee.setYearsExperience(experience);
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
			for(int i=0;i<objEmployee.getExpertises().size();i++){
				if(objEmployee.getExpertises().get(i).equals(cExpertise.get(i))){
					cExpertise.remove(i);
				}
			}
			for(int j=0;j<cExpertise.size();j++){
				objEmployee.getExpertises().add(cExpertise.get(j));
			}
			message = "\nLa informacion del empleado fue actualizada correctamente";
		} else{ 
			if(objEmployee==null){
				message += "\nEl empleado no existe, intentelo nuevamente";
			} 
			if(!(objEmployee instanceof AssistantCoach)){
				message += "\nEl empleado al que desea actualizarle la informacion no es un entrenador asistente, digitelo nuevamente";
			}
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
		String message = "";
		for(int k=0;k<teams.length;k++){
			if(teams[k]!=null){
				message += employees.toString();
			}
		} 
		return message;
	}
}
