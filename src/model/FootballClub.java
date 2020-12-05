package model;
import java.util.*;

public class FootballClub{

	//Constants
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
	* This method returns the name of the club. <br>
	* <b>name</b>: getName <br>
	* @return String <code> name </code> that is a variable with the name of the club.
	*/

	public String getName(){
		return name;
	}

	/**
	* this method modifies the name of the club. <br>
	* <b>name</b>: setName <br>
	* <b>post</b>: the name of the club has been changed. <br>
	* @param name is a String variable.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* This method returns the NIT of the club. <br>
	* <b>name</b>: getNit <br>
	* @return String <code> nit </code> that is variable with the NIT of the club.
	*/

	public String getNit(){
		return nit;
	}

	/**
	* this method modifies the NIT of the club. <br>
	* <b>name</b>: setNit <br>
	* <b>post</b>: the NIT of the club has been changed. <br>
	* @param nit is a String variable.
	*/

	public void setNit(String nit){
		this.nit = nit;
	}

	/**
	* This method returns the date when the club was founded <br>
	* <b>name</b>: getFoundationDate <br>
	* @return String <code> foundationDate </code> that is variable with the date when the club was founded.
	*/

	public String getFoundationDate(){
		return foundationDate;
	}

	/**
	* this method modifies the date when the club was founded. <br>
	* <b>name</b>: setFoundationDate <br>
	* <b>post</b>: the date when the club was founded has been changed. <br>
	* @param foundationDate is a String variable.
	*/

	public void setFoundationDate(String foundationDate){
		this.foundationDate = foundationDate;
	}

	/**
	* This method returns the team A. <br>
	* <b>name</b>: getTeamA <br>
	* @return Team <code> teamA </code> that is an object that represents the team A.
	*/

	public Team getTeamA(){
		return teamA;
	}

	/**
	* This method modifies the team A. <br>
	* <b>name</b>: setTeamA<br>
	* <b>post</b>: the team A has been changed. <br>
	* @param teamA is an object of type Team.
	*/

	public void setTeamA(Team teamA){
		this.teamA = teamA;
	}

	/**
	* This method returns the team B. <br>
	* <b>name</b>: getTeamB <br>
	* @return Team <code> teamB </code> that is an object that represents the team B.
	*/

	public Team getTeamB(){
		return teamB;
	}

	/**
	* This method modifies the team B. <br>
	* <b>name</b>: setTeamB<br>
	* <b>post</b>: the team B has been changed. <br>
	* @param teamB is an object of type Team.
	*/

	public void setTeamB(Team teamB){
		this.teamB = teamB;
	}

	/**
	* This method returns the club's office of coaches. <br>
	* <b>name</b>: getOffice <br>
	* @return Coach[][] <code> office </code> that is a matrix of coaches that represents how they are located in their office.
	*/

	public Coach[][] getOffice(){
		return office;
	}

	/**
	* this method modifies the club's office of coaches. <br>
	* <b>name</b>: setOffices <br>
	* <b>post</b>: the club's office of coaches has been changed. <br>
	* @param office is a matrix of Coaches.
	*/

	public void setOffice(Coach[][] office){
		this.office = office;
	}

	/**
	* This method returns all the employees of the club. <br>
	* <b>name</b>: getEmployees <br>
	* @return ArrayList of Employee <code> employees </code> that contains all the employees of the club.
	*/

	public ArrayList<Employee> getEmployees(){
		return employees;
	}

	/**
	* This method modifies the employees of the club. <br>
	* <b>name</b>: setEmployees<br>
	* <b>post</b>: the employees of the club has been changed. <br>
	* @param employees is an ArrayList of type Employee.
	*/

	public void setEmployees(ArrayList<Employee> employees){
		this.employees = employees;
	}

	//Methods

	/**
	* Builder method <br>
	* <b>name</b>: FootballClub<br>
	* <b>pre</b>: the variables name, nit and date are already inicializated. <br>
	* <b>post</b>: All the atributes and some relationships of the class were inicializated. <br>
	* @param name is a String variable that contains the name of the club.
	* @param nit is a String variable that contains the NIT of the club.
	* @param date is a String variable that contains the date of foundation of the club.
	*/

	public FootballClub(String name, String nit, String date){
		this.name = name;
		this.nit = nit;
		this.foundationDate = date;
		employees = new ArrayList<Employee>();
		office = new Coach[SIX][SIX];
	}

	/**
	* This method creates a team with all its features. <br>
	* <b>name</b>: createTeam.<br>
	* <b>pre</b>: the variables nameTeam and id are already inicializated. <br>
 	* <b>post</b>: the team was created successfully or not. <br>
 	* @param nameTeam is a String variable that contains the name of a team.
 	* @param id is a char variable that contains the ID of a team.
 	* @return String <code> message </code> that is a variable with a notice for the user. 
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
	* <b>pre</b>: the variable id is already inicializated. <br>
 	* <b>post</b>: An object of type Employee was returned. <br>
 	* @param id is a String variable that contains the ID of an employee. 
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
	* This method creates a new employee with its features, and adds it to the ArrayList of employees. <br>
	* <b>name</b>: addEmployee.<br>
	* <b>pre</b>: the variables name, id, salary, numShirt, team, averageGrade, and position are already inicializated. <br>
 	* <b>post</b>: the employee was hired successfully or the employee couldn't be hired. <br>
 	* @param name is a String variable that contains the name of a player. 
 	* @param id is a String variable that contains the ID of a player.
 	* @param salary is a double variable that contains the salary of a player.
 	* @param numShirt an integer variable that contains the number of shirt of a player.
 	* @param team is a String variable that contains the name of a team.
 	* @param position is an integer variable that represents the position of a player in the soccer field.
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
				message = "\nYa existe un empleado registrado en el club con esa identificacion, intentelo nuevamente";
			} 
			if(!(teamA.getName().equalsIgnoreCase(team)) && !(teamB.getName().equalsIgnoreCase(team))){
				message = "\nEl equipo no existe, intentelo nuevamente";
			}
		} return message;	
	}

	/**
	* This method creates a new employee with its features, and adds it to the ArrayList of employees. <br>
	* <b>name</b>: addEmployee.<br>
	* <b>pre</b>: the variables name, id, salary, experience, numTeams, team, numChampionships, and the ArrayList of championships are already inicializated. <br>
 	* <b>post</b>: the employee was hired successfully or the employee couldn't be hired. <br>
 	* @param name is a String variable that contains the name of a main coach. 
 	* @param id is a String variable that contains the ID of a main coach.
 	* @param salary is a double variable that contains the salary of a main coach.
 	* @param experience is an integer variable that contains the main coach's number years of experience.
 	* @param numTeams is an integer variable that contains the number of teams that a main coach has been in charge during his career.
	* @param team is a String variable that contains the name of a team.
	* @param numChampionships is an integer variable that contains the number of championships that a main coach has achieved during his career.
	* @param championships is an ArrayList of Strings that contains the names of all the championships that a main coach has achieved during his career.
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
	* This method creates a new employee with its features, and adds it to the ArrayList of employees. <br>
	* <b>name</b>: addEmployee.<br>
	* <b>pre</b>: the variables name, id, salary, experience, profession, team, and the ArrayList of expertises are already inicializated. <br>
 	* <b>post</b>: the employee was hired successfully or the employee couldn't be hired. <br>
 	* @param name is a String variable that contains the name of an assistant coach. 
 	* @param id is a String variable that contains the ID of an assistant coach.
 	* @param salary is a double variable that contains the salary of an assistant coach.
 	* @param experience is an integer variable that contains the assistant coach's number years of experience.
 	* @param professionalPlayer is an integer variable that represents if the assistant coach has ever been a professional player or not.
	* @param expertises is an ArrayList of integers that represents the expertises of an assistant coach.
	* @param team is a String variable that contains the name of a team.
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

	/**
	* This method adds a coach to an office of the club. <br>
	* <b>name</b>: addCoachesToOffices <br>
	* <b>post</b>: the coach was added successfully to an office of the club. <br>
	* @param coach is an object of type Coach. coach!=null
	*/

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

	/**
	* This method fires an employee of the club. <br>
	* <b>name</b>: deleteEmployee.<br>
	* <b>pre</b>: the variables id and team are already inicializated. <br>
 	* <b>post</b>: the employee was removed successfully or the employee couldn't be removed of the club. <br>
 	* @param id is a String variable that contains the ID of an employee.
 	* @param team is a String variable that contains the name of a team.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

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

	/**
	* This method changes the salary of an employee. <br>
	* <b>name</b>: changeSalaryEmployee.<br>
	* <b>pre</b>: the variables id, newSalary and option are already inicializated. <br>
 	* <b>post</b>: the salary of the employee was updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of an employee.
 	* @param salary is a double variable that contains the salary of an employee.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeSalaryEmployee(String id, double newSalary, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		switch(option){
			case 1:
				if(objEmployee!=null && objEmployee instanceof Player){
					((Player)objEmployee).setSalary(newSalary);
					 message = "\nEl salario del empleado ha sido actualizado exitosamente";
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
					 message = "\nEl salario del empleado ha sido actualizado exitosamente";
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
					 message = "\nEl salario del empleado ha sido actualizado exitosamente";
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

	/**
	* This method changes the number of shirt of a player. <br>
	* <b>name</b>: changeNumShirt.<br>
	* <b>pre</b>: the variables id, team, numShirt and option are already inicializated. <br>
 	* <b>post</b>: the number of shirt of a player was updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a player.
  	* @param numShirt an integer variable that contains the number of shirt of a player.
 	* @param team is a String variable that contains the name of a team.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeNumShirt(String id, String team, int numShirt, int option){
		Employee objEmployee = findEmployee(id);
		String message = "", advice1 = "", advice2 = "";
		if(objEmployee!=null && (teamA.getName().equalsIgnoreCase(team)||teamB.getName().equalsIgnoreCase(team)) && objEmployee instanceof Player && option==1){
			if(teamA.getName().equalsIgnoreCase(team)){
				advice1 = teamA.findNumShirt(numShirt);
				advice2 = teamA.findMember(id);
			}else{
				advice1 = teamB.findNumShirt(numShirt);
				advice2= teamB.findMember(id);
			}
			if(advice1.equals("El numero de camiseta puede ser asignado") && advice2.equals("\nEl empleado pertenece al equipo")){
				((Player)objEmployee).setNumShirt(numShirt);
				message =  "\nEl numero de camiseta del jugador ha sido actualizado exitosamente";
			}else{
				if(!advice1.equals("El numero de camiseta puede ser asignado")){
					message += advice1;
				}
				if(!advice2.equals("\nEl empleado pertenece al equipo")){
					message += advice2;
				}
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

	/**
	* This method changes the number of goals that a player has scored in the club. <br>
	* <b>name</b>: changeNumGoals.<br>
	* <b>pre</b>: the variables id, numGoals and option are already inicializated. <br>
 	* <b>post</b>: the number of goals that a player has scored in the club was updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a player.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @param numGoals is an integer variable that represents the number of goals that a player has scored in the club.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeNumGoals(String id, int numGoals, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		if(objEmployee!=null && objEmployee instanceof Player && option==1){
			((Player)objEmployee).setNumGoals(numGoals);
			message = "\nEl numero de goles que el jugador ha marcado en el club ha sido actualizado exitosamente";
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

	/**
	* This method changes the average grade of a player. <br>
	* <b>name</b>: changeAverageGrade.<br>
	* <b>pre</b>: the variables id, averageGrade and option are already inicializated. <br>
 	* <b>post</b>: the average grade of a player was updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a player.
 	* @param averageGrade is a double variable that represents the average grade of a player.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeAverageGrade(String id, double averageGrade, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		if(objEmployee!=null && objEmployee instanceof Player && option==1){
			((Player)objEmployee).setAverageGrade(averageGrade);
			message = "\nLa calificacion promedio del jugador ha sido actualizada exitosamente";
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

	/**
	* This method changes the position of a player in the soccer field. <br>
	* <b>name</b>: changePosition.<br>
	* <b>pre</b>: the variables id, position and option are already inicializated. <br>
 	* <b>post</b>: the position of a player in the soccer field was updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a player.
 	* @param position is an integer variable that represents the position of a player in the soccer field.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changePosition(String id, int position, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
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
			 message = "\nLa posicion del jugador ha sido actualizada exitosamente";		
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

	/**
	* This method changes the years of experience that a coach has. <br>
	* <b>name</b>: changeExperienceEmployee.<br>
	* <b>pre</b>: the variables id, experience and option are already inicializated. <br>
 	* <b>post</b>: the years of experience that a coach has were updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a coach.
 	* @param experience is an integer variable that contains the coach's number years of experience.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeExperienceEmployee(String id, int experience, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		switch(option){
			case 1:
				message = "\nLo sentimos, este atributo solo puede ser actualizado a entrenadores";
				break;
			case 2:
				if(objEmployee!=null && objEmployee instanceof MainCoach){
					((MainCoach)objEmployee).setYearsExperience(experience);
					message = "\nLos anios de experiencia del entrenador han sido actualizados exitosamente";
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
					message = "\nLos anios de experiencia del entrenador han sido actualizados exitosamente";
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

	/**
	* This method changes the number of teams that a main coach has been in charge during his career. <br>
	* <b>name</b>: changeNumTeamsEmployee.<br>
	* <b>pre</b>: the variables id, numTeams and option are already inicializated. <br>
 	* <b>post</b>: the number of teams that a main coach has been in charge during his career were updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of an main coach.
 	* @param numTeams is an integer variable that contains the number of teams that a main coach has been in charge during his career.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeNumTeamsEmployee(String id, int numTeams, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		if(objEmployee!=null && objEmployee instanceof MainCoach && option==2){
			((MainCoach)objEmployee).setNumTeams(numTeams);
			message = "\nEl numero de equipos que el entrenador ha tenido a cargo durante su carrera ha sido actualizado exitosamente";
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

	/**
	* This method changes the championships that a main coach has achieved during his career. <br>
	* <b>name</b>: changeChampionshipsEmployee.<br>
	* <b>pre</b>: the variables id, numChampionships, option, and the ArrayList championships are already inicializated. <br>
 	* <b>post</b>: the championships that a main coach has achieved during his career were updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a main coach.
 	* @param numChampionships is an integer variable that contains the number of championships that a main coach has achieved during his career.
	* @param championships is an ArrayList of Strings that contains the names of all the championships that a main coach has achieved during his career.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeChampionshipsEmployee(String id, int numChampionships, ArrayList<String> championships, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		if(objEmployee!=null && objEmployee instanceof MainCoach && option==2){
			((MainCoach)objEmployee).setNumChampionships((((MainCoach)objEmployee).getNumChampionships())+numChampionships);
			for(int j=0;j<championships.size();j++){
				((MainCoach)objEmployee).getChampionships().add(championships.get(j));
			}
			message = "\nLos campeonatos ganados por el entrenador principal han sido actualizados exitosamente";
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

	/**
	* This method changes the expertises that an assistant coach has. <br>
	* <b>name</b>: changeExpertisesEmployee.<br>
	* <b>pre</b>: the variables id, option, and the ArrayList expertises are already inicializated. <br>
 	* <b>post</b>: the expertises that an assistant coach has were updated successfully or not. <br>
 	* @param id is a String variable that contains the ID of a main coach.
 	* @param expertises is an ArrayList of integers that represents the expertises of an assistant coach.
 	* @param option is an integer variable that represents the menu option chosen by the user.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String changeExpertisesEmployee(String id, ArrayList<Integer> expertises, int option){
		Employee objEmployee = findEmployee(id);
		String message = " ";
		if(objEmployee!=null && objEmployee instanceof AssistantCoach && option==3){
			((AssistantCoach)objEmployee).updateExpertises(expertises);
			message = "\nLas experticias del entrenador han sido actualizadas exitosamente";
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

	/**
	* This method changes the name of a team. <br>
	* <b>name</b>: changeInfoTeam.<br>
	* <b>pre</b>: the variables name and newName are already inicializated. <br>
 	* <b>post</b>: the name of the team was updated successfully or not. <br>
 	* @param name is a String variable that contains the name of a team.
 	* @param newName is a String variable that contains the new name that is going to assign to a team.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

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

	/**
	* This method adds a lineup to a specific team. <br>
	* <b>name</b>: addLineupToTeam.<br>
	* <b>pre</b>: the variables such as nameTeam, date, tactic, defenses, midfielders and forwards are already inicializated. <br>
 	* <b>post</b>: the lineup of a team was added successfully to a team or not. <br>
 	* @param nameTeam is a String variable that contains the name of a team.
 	* @param date is a String variable that contains the date when a lineup was implemented by a team.
	* @param tactic is a integer variable that represents the tactic that is used in a lineup.
	* @param defenses is a integer variable that contains the number of players that are going to be in the line of defense at the formation.
	* @param midfielders is a integer variable that contains the number of players that are going to be in the line of midfielders at the formation.
	* @param forwards is a integer variable that contains the number of players that are going to be in the line of forwards at the formation.
 	* @return String <code> message </code> that is a variable with a notice for the user.
	*/

	public String addLineupToTeam(String nameTeam, String date, int tactic, int defenses, int midfielders, int forwards){
		String message = " ";
		if(teamA.getName().equalsIgnoreCase(nameTeam)||teamB.getName().equalsIgnoreCase(nameTeam)){
			if(teamA.getName().equalsIgnoreCase(nameTeam)){
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
		if(employees.isEmpty()){
			message = "\n                                          No hay ningun empleado registrado en el club aun";
		}else{
			for(int k=0;k<employees.size();k++){
				message += employees.get(k).toString();
			}
		} 
		return message;
	}

	/**
	* This method displays all the information of the two teams. <br>
	* <b>name</b>: showTeams.<br>
 	* <b>post</b>: the information of each team was returned. <br>
 	* @return String <code> message </code> that is a variable with all the information of the teams.
	*/

	public String showTeams(){
		String message = teamA.toString()+"\n"+teamB.toString();
		return message;
	}

	/**
	* This method shows all the information of a specific employee of the club. <br>
	* <b>name</b>: showAnEmployee.<br>
 	* <b>post</b>: the information of a specific employee of the club was returned. <br>
 	* @param id is a String variable that contains the ID of an employee.
 	* @return String <code> message </code> that is a variable with all the information of an employee.
	*/

	public String showAnEmployee(String id){
		String message = "";
		Employee objEmployee = findEmployee(id);
		if(objEmployee==null){
			message = "El empleado no existe, intentelo nuevamente";
		} else{
			message = objEmployee.toString();
		} return message;
	}

	/**
	* This method shows all the information of a specific team of the club. <br>
	* <b>name</b>: showATeam.<br>
 	* <b>post</b>: the information of a specific team of the club was returned. <br>
 	* @param name is a String variable that contains the name of a team.
 	* @return String <code> message </code> that is a variable with all the information of a team.
	*/

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

	/**
	* This method shows all the information about the facilities of the club. <br>
	* <b>name</b>: showFacilities.<br>
 	* <b>post</b>: the information about the facilities of the club was returned. <br>
  	* @return String <code> message </code> that is a variable with all the information about the facilities of the club.
	*/

	public String showFacilities(){
		String message = "\nCamerino del equipo A: \n"+teamA.showDressingRoom()+"\nCamerino del equipo B: \n"+teamB.showDressingRoom()+"\nJugadores del equipo B que se quedaron sin camerino: \n";
		ArrayList<Player> playersOutDressingRoom = teamB.calculatePlayersOut();
		for(int k=0;k<playersOutDressingRoom.size();k++){
			message+="["+playersOutDressingRoom.get(k).getName()+"]";
		}
		message+="\nOficinas de los entrenadores\n";
		for(int x=0;x<SIX;x++){
			for(int k = 0;k<SIX;k++){
				if(office[x][k]!=null){
					message += "["+office[x][k].getName()+"]"+" ";
				}else{
					message += "[	    ]" +" ";
				}
			}
			message+="\n";
		} return message;
	}

	/**
	* This method produces a String with all the atributes of the club. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: All the atributes of the club was returned. <br>
 	* @return out in a <code> String </code> variable all the atributes of the club.
	*/

	public String toString(){
		return "\n                                          ********************** Club "+name+" ***********************"+"\n                                          **  NIT: "+nit+"\n                                          **  Fecha de fundacion: "+foundationDate;
	}
}
