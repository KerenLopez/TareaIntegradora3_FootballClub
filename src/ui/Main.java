package ui;
import model.FootballClub;
import java.util.*;

public class Main{

	//Global variable
	public Scanner lector;

	//Relationship
	private FootballClub mainFootballClub;

	/**
	* Builder method <br>
	* <b>name</b>: Main <br>
	* <b>post</b>: The relationship and the global variable were inicializated. <br>
	*/

	public Main(){
		lector = new Scanner(System.in);
		createClub();
	}

	public static void main(String[] args){
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= );
	}

	public void createClub(){
		String name, nit, date, teamA, teamB, message;
		char team1='A', team2='B';
		System.out.println(
			"\n************************************************************************************************************************\n"+   
			"                                      BIENVENIDO AL SOFTWARE DE ENTIDADES DEPORTIVAS"+
			"\n************************************************************************************************************************\n"+
			"REGISTRAR LOS DATOS DEL CLUB"
		);
		System.out.println("\nDigite el nombre del club: ");
		name = lector.nextLine();
		System.out.println("\nIngrese el numero de NIT del club: ");
		nit = lector.nextLine();
		System.out.println("\nIngrese la fecha de fundacion del club: ");
		date = lector.nextLine();
		mainFootballClub = new FootballClub(name, nit, date);
		System.out.println("Ingrese el nombre del equipo A: ");
		teamA = lector.nextLine();
		message = mainFootballClub.createTeam(teamA, team1);
		System.out.println(message);
		do{
			System.out.println("Ingrese el nombre del equipo B: ");
			teamB = lector.nextLine();
			message = mainFootballClub.createTeam(teamB, team2);
			System.out.println(message);
		} while(message.equals("\nYa existe un equipo registrado con ese nombre, intentelo nuevamente"));	
	}

	/**
	* This method displays a menu and appeals to other methods depending on the option chosen by the user. <br>
	* <b>name</b>: menu.<br>
 	* <b>post</b>: the option that the user chose was returned. <br>
 	* @return integer <code> option </code> that is a variable with a number that the user selected.
	*/

	public int menu(){
		int option = 0;
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                               Seleccione una opcion para continuar"+
				"\n************************************************************************************************************************\n"+
				"      1. Contratar a un empleado\n"+
				"      2. Despedir a un empleado\n"+
				"      3. Actualizar la informacion de un empleado\n"+
				"      4. Actualizar la informacion de un equipo\n"+
				"      5. Conocer la lista de empleados del club\n"+
				"      6. Conocer la informacion de los equipos\n"+
				"      7. Conocer toda la informacion del club\n"+
				"      8. Agregar una alineacion a un equipo\n"+
				"      9. Ubicar a un jugador dentro de un camerino\n"+
				"	   10. Ubicar a un entrenador dentro de una oficina\n"+
				"      11.Finalizar la aplicacion\n"
			);
			option = lector.nextInt(); lector.nextLine();
			switch(option){
				case 1:
					hireEmployee();
					menu = false;
					break;
				case 2:
					fireEmployee();
					menu = false;
					break;
				case 3:
					updateEmployee();
					menu = false;
					break;	
				case 4:
				
					menu = false;
					break;		
				case 5:
					displayEmployees();
					menu = false;
					break;	
				case 6:	
					displayTeams();
					menu = false;
					break;
				case 7:	
					
					menu = false;
					break;
				case 8:	
					
					menu = false;
					break;
				case 9:	
					System.out.println("\n************************************************************************************************************************\n"+"Gracias por utilizar el sistema, vuelva pronto"+"\n************************************************************************************************************************\n");
					menu = false;
					break;				
				default:
					System.out.println("\n************************************************************************************************************************\n"+"Error, opcion no valida");
					menu = false;
					break;	    	
			} 	
		} return option;
    }

    public void hireEmployee(){
    	String name, id, team, nameChampionship, message;
    	double salary;
    	Arraylist<String> championships = new Arraylist<>();
    	Arraylist<Integer> expertises = new Arraylist<>();
    	int option, numShirt, position, experience, numTeams, numChampionships, expertise, profession, decision, cont;
    	do{
    		System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                                         CONTRATAR A UN EMPLEADO"+
				"\n************************************************************************************************************************"
				"\nSeleccione el tipo de empleado a contratar: "+
				"\n    1. Jugador"+
				"\n    2. Entrenador principal"+
				"\n    3. Entrenador asistente"
			);
    		option = lector.nextInt();lector.nextLine();
    		if(option!=1 && option!=2 && option!=3){
    			System.out.println("Ingrese una opcion correcta");
    		}
    	} while(option!=1 && option!=2 && option!=3);
    	System.out.println("Ingrese el nombre del nuevo empleado: ");
    	name = lector.nextLine();
    	System.out.println("Ingrese la identificacion del nuevo empleado: ");
    	id = lector.nextLine();
    	System.out.println("Ingrese el salario del nuevo empleado: ");
    	salary = lector.nextDouble();
    	switch(option){
    		case 1: 
    			System.out.println("Ingrese el numero de camiseta del nuevo empleado (jugador): ");
    			numShirt = lector.nextInt(); lector.nextLine();
    			System.out.println("Ingrese el nombre del equipo al que pertenecera el nuevo empleado (jugador): ");
    			team = lector.nextLine();
    			do{
    				System.out.println(
						"\nElija la posicion del empleado a registrar (jugador) dentro del terreno de juego: "+
						"\n    1. Portero"+
						"\n    2. Defensor"+
						"\n    3. Volante"+
						"\n    4. Delantero"
					);
    				position = lector.nextInt();lector.nextLine();
    				if(position!=1 && position = 2 && position!=3){
    					System.out.println("Ingrese una opcion correcta");
    				}
    			} while(position!=1 && position!=2 && position!=3);
    			message = mainFootballClub.addEmployee(name, id, salary, numShirt, team, position);
    			System.out.println(message);
    			break;
    		case 2:
    			System.out.println("Ingrese los años de experiencia del empleado a registrar (entrenador principal): ");
    			experience = lector.nextInt();
    			System.out.println("Ingrese el numero de equipos que ha tenido a cargo el empleado a registrar en su carrera como manager: ");
    			numTeams = lector.nextInt(); lector.nextLine();
    			System.out.println("Ingrese el nombre del equipo al que pertenecera el nuevo empleado (entrenador principal): ");
    			team = lector.nextLine();
    			System.out.println("Ingrese la cantidad de campeonatos conseguidos: ");
    			numChampionships = lector.nextInt();lector.nextLine();
    			for(int k=0;k<numChampionships;k++){
    				do{
    					System.out.println("Ingrese el nombre del campeonato"+(k+1)+": ");
    					nameChampionship = lector.nextLine();
    					for(int k=0;k<championships.size();k++){
    						if(championships.get(k).equalsIgnoreCase(nameChampionship)){
    							cont+=1;
    						}
    					}
    					if(cont==0){
    						championships.add(nameChampionship);
    					} else{
    						message = "\nIngresaste un campeonato con ese mismo nombre, intentelo nuevamente";
    						System.out.println(message);
    					}
    				} while(message.equals("\nIngresaste un campeonato con ese mismo nombre, intentelo nuevamente"))	
    			}	
    			message = mainFootballClub.addEmployee(name, id, salary, experience, numTeams, team, numChampionships, championships);
    			System.out.println(message);
    			break;
   			case 3:
    			System.out.println("Ingrese los años de experiencia del empleado a registrar (entrenador asistente): ");
    			experience = lector.nextInt();
    			do{
    				System.out.println("Ha sido jugador profesional en algun momento de su vida? (1. Si / 2. No):");
    				profession = lector.nextInt();
    				if(profession!=1 && profession!=2){
    					System.out.println("Ingrese una opcion correcta");
    				}
    			} while(profession!=1 && profession!=2);	
    			do{
    				System.out.println(
						"\nElija la experticia del empleado a registrar (entrenador asistente): "+
						"\n    1. Ofensivo"+
						"\n    2. Defensivo"+
						"\n    3. Posesion"+
						"\n    4. Jugadas de laboratorio"+
						"\n    5. Entrenador fisico"+
						"\n    6. Entrenador de arqueros"
					);
    				expertise = lector.nextInt();
    				if(expertise!=1 && expertise = 2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6){
    					System.out.println("Ingrese una opcion correcta");
    				} else{
    					for(int k=0;k<expertises.size();k++){
    						if(expertises.get(k)==expertise){
    							cont+=1;
    						}
    					}
    					if(cont==0){
    						expertises.add(expertise);
    					}
    				}
    				do{
    					System.out.println("Desea agregar otra experticia? (1. Si/ 2. No):");
    					decision = lector.nextInt();lector.nextLine();
    					if(decision!=1 && decision!=2){
    						System.out.println("Digite una opcion correcta");
    					}
    				} while(decision!=1 && decision!=2);	
    			} while(expertise!=1 && expertise!=2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6 && (decision.equalsIgnoreCase("si")));
    			System.out.println("Ingrese el nombre del equipo al que pertenecera el nuevo empleado (jugador): ");
    			team = lector.nextLine();
    			message = mainFootballClub.addEmployee(name, id, salary, experience, profession, expertises, team);
    			System.out.println(message);
    			break;				
    	}
    }

    public void fireEmployee(){
    	String message, id, team;
    	System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                         DESPEDIR A UN EMPLEADO"+
			"\n************************************************************************************************************************"
		);
		System.out.println("Ingrese la identificacion del empleado a despedir: ");
    	id = lector.nextLine();
    	System.out.println("Ingrese el equipo al que pertenece el empleado que va a despedir: ");
    	team = lector.nextLine();
    	message = mainFootballClub.deleteEmployee(id, team);
    	System.out.println(message); 
    }

    public void updateEmployee(){
    	String id, nameChampionship, message, team;
    	double salary, averageGrade;
    	Arraylist<String> championships = new Arraylist<>();
    	Arraylist<Integer> expertises = new Arraylist<>();
    	int option, numShirt, experience, numTeams, numChampionships, expertise, numGoals, decision, cont = 0;
    	do{
    		System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                            ACTUALIZAR LA INFORMACION DE UN EMPLEADO"+
				"\n************************************************************************************************************************"
				"\nSeleccione el tipo de empleado al cual desea actualizarle la informacion: "+
				"\n    1. Jugador"+
				"\n    2. Entrenador principal"+
				"\n    3. Entrenador asistente"
			);
    		option = lector.nextInt();lector.nextLine();
    		if(option!=1 && option!=2 && option!=3){
    			System.out.println("Ingrese una opcion correcta");
    		}
    	} while(option!=1 && option!=2 && option!=3);
    	System.out.println("Ingrese la identificacion del empleado: ");
    	id = lector.nextLine();
    	System.out.println("Ingrese el nuevo salario del empleado: ");
    	salary = lector.nextDouble();
    	switch(option){
    		case 1: 
    			System.out.println("Ingrese el nuevo numero de camiseta del empleado (jugador): ");
    			numShirt = lector.nextInt(); lector.nextLine();
    			System.out.println("Ingrese el nombre del equipo al que pertenece el empleado (jugador) actualmente: ");
    			team = lector.nextLine();
    			System.out.println("Ingrese de goles que el empleado (jugador) ha marcado en el club: ");
    			numGoals = lector.nextInt();
    			System.out.println("Ingrese la calificacion promedio del empleado (jugador): ");
    			averageGrade = lector.nextDouble();lector.nextLine();
    			message = mainFootballClub.changeInfoEmployee(team, id, salary, numShirt, numGoals, averageGrade);
    			System.out.println(message);
    			break;
    		case 2:
    			System.out.println("Ingrese el nuevo numero de años de experiencia que tiene empleado (entrenador principal): ");
    			experience = lector.nextInt();
    			System.out.println("Ingrese el nuevo numero de equipos que ha tenido a cargo el empleado en su carrera como manager: ");
    			numTeams = lector.nextInt(); 
    			System.out.println("Ingrese la cantidad de nuevos campeonatos conseguidos por el empleado: ");
    			numChampionships = lector.nextInt();lector.nextLine();
    			for(int k=0;k<numChampionships;k++){
    				do{
    					System.out.println("Ingrese el nombre del nuevo campeonato"+(k+1)+": ");
    					nameChampionship = lector.nextLine();
    					for(int k=0;k<championships.size();k++){
    						if(championships.get(k).equalsIgnoreCase(nameChampionship)){
    							cont+=1;
    						}
    					}
    					if(cont==0){
    						championships.add(nameChampionship);
    					} else{
    						message = "\nIngresaste un campeonato con ese mismo nombre, intentelo nuevamente";
    						System.out.println(message);
    					}
    				} while(message.equals("\nIngresaste un campeonato con ese mismo nombre, intentelo nuevamente"))	
    			}	
    			message = mainFootballClub.changeInfoEmployee(id, salary, experience, numTeams, numChampionships, championships);
    			System.out.println(message);
    			break;
   			case 3:
    			System.out.println("Ingrese los nuevos años de experiencia del empleado (entrenador asistente): ");
    			experience = lector.nextInt();
    			do{
    				System.out.println(
						"\nElija la nueva experticia adquirida por el empleado (entrenador asistente): "+
						"\n    1. Ofensivo"+
						"\n    2. Defensivo"+
						"\n    3. Posesion"+
						"\n    4. Jugadas de laboratorio"+
						"\n    5. Entrenador fisico"+
						"\n    6. Entrenador de arqueros"
					);
    				expertise = lector.nextInt();
    				if(expertise!=1 && expertise = 2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6){
    					System.out.println("Ingrese una opcion correcta");
    				} else{
    					for(int k=0;k<expertises.size();k++){
    						if(expertises.get(k)==expertise){
    							cont+=1;
    						}
    					}
    					if(cont==0){
    						expertises.add(expertise);
    					}
    				}
    				do{
    					System.out.println("Desea agregar otra nueva experticia que ha adquirido el empleado? (1. Si/ 2. No):");
    					decision = lector.nextInt();
    					if(decision!=1 && decision!=2){
    						System.out.println("Digite una opcion correcta");
    					}
    				} while(decision!=1 && decision!=2);	
    			} while(expertise!=1 && expertise!=2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6 && (decision.equalsIgnoreCase("si")));
    			message = mainFootballClub.changeInfoEmployee(id, salary, experience, expertises);
    			System.out.println(message);
    			break;				
    	}
    }

    public void displayEmployees(){
		String message = mainFootballClub.showEmployees();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                  LISTA DE EMPLEADOS DEL CLUB"+
			"\n************************************************************************************************************************"+
			message
		);
	}

	public void displayTeams(){
		String message = mainFootballClub.showTeams();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                              INFORMACION DE LOS EQUIPOS DEL CLUB"+
			"\n************************************************************************************************************************"+
			message
		);
	}
}	