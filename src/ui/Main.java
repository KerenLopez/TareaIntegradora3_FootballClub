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
		createTeams();
	}

	public static void main(String[] args){
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 11);
	}

	public void createClub(){
		String name, nit, date;
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
	}

	public void createTeams(){
		String name, nit, date, teamA, teamB, message;
		char team1='A', team2='B';
		System.out.println("\nIngrese el nombre del equipo A: ");
		teamA = lector.nextLine();
		message = mainFootballClub.createTeam(teamA, team1);
		System.out.println(message);
		do{
			System.out.println("\nIngrese el nombre del equipo B: ");
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
				"      4. Actualizar la informacion de un equipo (cambiar el nombre o agregar una alineacion)\n"+
				"      5. Conocer la informacion de todos empleados del club\n"+
				"      6. Conocer toda la informacion de los dos equipos\n"+
				"      7. Conocer la informacion de un empleado en especifico\n"+
				"      8. Conocer la informacion de un equipo en especifico\n"+
				"      9. Conocer la informacion acerca de las instalaciones del club (camerinos y oficinas)\n"+
				"      10. Conocer toda la informacion del club\n"+
				"      11. Finalizar la aplicacion\n"
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
					updateTeam();
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
					displayAnEmployee();
					menu = false;
					break;
				case 8:	
					displayATeam();
					menu = false;
					break;
				case 9:	
					displayInfoFacilities();
					menu = false;
					break;
				case 10:	
					showAllInfoClub();
					menu = false;
					break;
				case 11:	
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
    	String name = "", id = "", team = "", nameChampionship = "", message = "";
    	double salary = 0, averageGrade = 0;
    	ArrayList<String> championships = new ArrayList<>();
    	ArrayList<Integer> expertises = new ArrayList<>();
    	int option = 0, numShirt = 0, position = 0, experience = 0, numTeams = 0, numChampionships = 0, expertise = 0, profession = 0, decision = 0, cont = 0;
    	do{
    		System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                                         CONTRATAR A UN EMPLEADO"+
				"\n************************************************************************************************************************"+
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
    				System.out.println("Ingrese la calificacion promedio del empleado (jugador): Recuerde que debe encontrarse entre un rango de 1,0 a 10,0");
    				averageGrade = lector.nextDouble();
    				if (averageGrade<1.0 || averageGrade>10.0){
    					message = "La calificacion promedio debe encontrarse entre un rango de 1,0 a 10,0";
    					System.out.println(message);
    				}
    			} while(averageGrade<1.0 || averageGrade>10.0);
    			do{
    				System.out.println(
						"\nElija la posicion del empleado a registrar (jugador) dentro del terreno de juego: "+
						"\n    1. Portero"+
						"\n    2. Defensor"+
						"\n    3. Volante"+
						"\n    4. Delantero"
					);
    				position = lector.nextInt();lector.nextLine();
    				if(position!=1 && position != 2 && position!=3 && position!=4){
    					System.out.println("Ingrese una opcion correcta");
    				}
    			} while(position!=1 && position!=2 && position!=3 && position!=4);
    			message = mainFootballClub.addEmployee(name, id, salary, numShirt, team, averageGrade, position);
    			System.out.println(message);
    			break;
    		case 2:
    			System.out.println("Ingrese los anios de experiencia del empleado a registrar (entrenador principal): ");
    			experience = lector.nextInt();
    			System.out.println("Ingrese el numero de equipos que ha tenido a cargo el empleado a registrar en su carrera como manager: ");
    			numTeams = lector.nextInt(); lector.nextLine();
    			System.out.println("Ingrese el nombre del equipo al que pertenecera el nuevo empleado (entrenador principal): ");
    			team = lector.nextLine();
    			System.out.println("Ingrese la cantidad de campeonatos conseguidos: ");
    			numChampionships = lector.nextInt();lector.nextLine();
    			for(int k=0;k<numChampionships;k++){
					System.out.println("Ingrese el nombre del nuevo campeonato #"+(k+1)+": ");
					nameChampionship = lector.nextLine();
					championships.add(nameChampionship);
    			}
    			message = mainFootballClub.addEmployee(name, id, salary, experience, numTeams, team, numChampionships, championships);
    			System.out.println(message);
    			break;
   			case 3:
    			System.out.println("Ingrese los anios de experiencia del empleado a registrar (entrenador asistente): ");
    			experience = lector.nextInt();
    			do{
    				System.out.println("Ha sido jugador profesional en algun momento de su vida? (1. Si / 2. No):");
    				profession = lector.nextInt();
    				if(profession!=1 && profession!=2){
    					System.out.println("Ingrese una opcion correcta");
    				}
    			} while(profession!=1 && profession!=2);	
    			do{
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
	    				if(expertise!=1 && expertise!= 2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6){
	    					System.out.println("Ingrese una opcion correcta");
	    				} else{
	    					cont = 0;
	    					for(int k=0;k<expertises.size();k++){
	    						if(expertises.get(k)==expertise){
	    							cont+=1;
	    						}
	    					}
	    					if(cont==0){
	    						expertises.add(expertise);
	    					}
	    				}
	    			}while(expertise!=1 && expertise!= 2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6);	
    				do{
    					System.out.println("Desea agregar otra experticia? (1. Si/ 2. No):");
    					decision = lector.nextInt();lector.nextLine();
    					if(decision!=1 && decision!=2){
    						System.out.println("Digite una opcion correcta");
    					}
    				} while(decision!=1 && decision!=2);	
    			} while(decision==1);
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
    	String id = "", nameChampionship = "", message = "", team = "";
    	double salary = 0, averageGrade = 0;
    	ArrayList<String> championships = new ArrayList<>();
    	ArrayList<Integer> expertises = new ArrayList<>();
    	int option = 0, numShirt = 0, experience = 0, numTeams = 0, numChampionships = 0, expertise = 0, numGoals = 0, decision = 0, position = 0, cont = 0;
    	do{
    		System.out.println(
				"\n************************************************************************************************************************\n"+
				"                                            ACTUALIZAR LA INFORMACION DE UN EMPLEADO"+
				"\n************************************************************************************************************************"+
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
    	switch(option){
    		case 1:
    			do{ 
	    			System.out.println(
						"\nElija una opcion para continuar: "+
						"\n    1. Actualizar el salario del jugador"+
						"\n    2. Actualizar el numero de camiseta del jugador"+
						"\n    3. Actualizar el numero de goles que el jugador ha marcado en el club"+
						"\n    4. Actualizar la calificacion promedio del jugador"+
						"\n    5. Actualizar la posicion de un jugador dentro del terreno de juego"
					);
					decision = lector.nextInt();lector.nextLine();
					if(decision!=1 && decision!=2 && decision!=3 && decision!=4 && decision!=5){
	    				System.out.println("Ingrese una opcion correcta");
	    			}
	    		}while(decision!=1 && decision!=2 && decision!=3 && decision!=4 && decision!=5);	
    			switch(decision){
    				case 1:
    					System.out.println("Ingrese el nuevo salario del empleado: ");
    					salary = lector.nextDouble();
    					message = mainFootballClub.changeSalaryEmployee(id,salary,option);
    					System.out.println(message);
    					break;
    				case 2:
    					System.out.println("Ingrese el nombre del equipo al que pertenece el jugador actualmente: ");
    					team = lector.nextLine();
    					System.out.println("Ingrese el nuevo numero de camiseta del empleado (jugador): ");
    					numShirt = lector.nextInt(); lector.nextLine();
    					message = mainFootballClub.changeNumShirt(id,team,numShirt,option);
    					System.out.println(message);
    					break;
    				case 3:
    					System.out.println("Ingrese el numero de goles que el jugador ha marcado en el club: ");
    					numGoals = lector.nextInt();
    					message = mainFootballClub.changeNumGoals(id,numGoals,option);
    					System.out.println(message);
    					break;		
					case 4:
						do{
    						System.out.println("Ingrese la nueva calificacion promedio del (jugador): Recuerde que debe encontrarse entre un rango de 1,0 a 10,0");
    						averageGrade = lector.nextDouble();
    						if (averageGrade<1.0 || averageGrade>10.0){
    							message = "La calificacion promedio debe encontrarse entre un rango de 1,0 a 10,0";
    							System.out.println(message);
    						}
    					} while(averageGrade<1.0 || averageGrade>10.0);
    					message = mainFootballClub.changeAverageGrade(id,averageGrade,option);
    					System.out.println(message);
    					break;
    				case 5:
    					do{
    						System.out.println(
								"\nElija la nueva posicion del jugador dentro del terreno de juego: "+
								"\n    1. Portero"+
								"\n    2. Defensor"+
								"\n    3. Volante"+
								"\n    4. Delantero"
							);
    						position = lector.nextInt();lector.nextLine();
    						if(position!=1 && position != 2 && position!=3 && position!=4){
    							System.out.println("Ingrese una opcion correcta");
    						}
    					} while(position!=1 && position!=2 && position!=3 && position!=4);
    					message = mainFootballClub.changePosition(id,position,option);
    					System.out.println(message);	
    					break;	    			
    			}
    			break;
    		case 2:
    			do{
	    			System.out.println(
						"\nElija una opcion para continuar: "+
						"\n    1. Actualizar el salario del entrenador principal"+
						"\n    2. Actualizar el numero de anios de experiencia del entrenador principal"+
						"\n    3. Actualizar el numero de equipos que ha tenido a cargo el entrenador principal"+
						"\n    4. Actualizar la cantidad de campeonatos conseguidos por el entrenador principal"
					);
					decision = lector.nextInt();lector.nextLine();
					if(decision!=1 && decision!=2 && decision!=3 && decision!=4){
	    				System.out.println("Ingrese una opcion correcta");
	    			}
	    		}while(decision!=1 && decision!=2 && decision!=3 && decision!=4);
    			switch(decision){
    				case 1:
    					System.out.println("Ingrese el nuevo salario del empleado: ");
    					salary = lector.nextDouble();
    					message = mainFootballClub.changeSalaryEmployee(id,salary,option);
    					System.out.println(message);
    					break;
    				case 2:
    					System.out.println("Ingrese el nuevo numero de anios de experiencia que tiene empleado (entrenador principal): ");
    					experience = lector.nextInt();
    					message = mainFootballClub.changeExperienceEmployee(id,experience,option);
    					System.out.println(message);
    					break;
    				case 3:
    					System.out.println("Ingrese el nuevo numero de equipos que ha tenido a cargo el empleado en su carrera como manager: ");
    					numTeams = lector.nextInt(); 
    					message = mainFootballClub.changeNumTeamsEmployee(id,numTeams,option);
    					System.out.println(message);
    					break;		
					case 4:
		    			System.out.println("Ingrese la cantidad de nuevos campeonatos conseguidos por el empleado: ");
		    			numChampionships = lector.nextInt();lector.nextLine();
		    			for(int k=0;k<numChampionships;k++){
	    					System.out.println("Ingrese el nombre del nuevo campeonato conseguido #"+(k+1)+": ");
	    					nameChampionship = lector.nextLine();
	    					championships.add(nameChampionship);
		    			}
		    			message = mainFootballClub.changeChampionshipsEmployee(id,numChampionships,championships,option);
    					System.out.println(message); 	
		    			break;
		    	}
    			break;
   			case 3:
   				do{
	   				System.out.println(
						"\nElija una opcion para continuar: "+
						"\n    1. Actualizar el salario del entrenador asistente"+
						"\n    2. Actualizar el numero de anios de experiencia del entrenador asistente"+
						"\n    3. Actualizar las experticias del entrenador asistente"
					);
					decision = lector.nextInt();lector.nextLine();
					if(decision!=1 && decision!=2 && decision!=3){
		    			System.out.println("Ingrese una opcion correcta");
		    		}
		    	}while(decision!=1 && decision!=2 && decision!=3);	
    			switch(decision){
    				case 1:
    					System.out.println("Ingrese el nuevo salario del empleado: ");
    					salary = lector.nextDouble();
    					message = mainFootballClub.changeSalaryEmployee(id,salary,option);
    					System.out.println(message);
    					break;
    				case 2:
    					System.out.println("Ingrese el nuevo numero de anios de experiencia que tiene empleado (entrenador principal): ");
    					experience = lector.nextInt();
    					message = mainFootballClub.changeExperienceEmployee(id,experience,option);
    					System.out.println(message);
    					break;
    				case 3:
		    			do{
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
			    				if(expertise!=1 && expertise!= 2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6){
			    					System.out.println("Ingrese una opcion correcta");
			    				} else{
			    					cont=0;
			    					for(int k=0;k<expertises.size();k++){
			    						if(expertises.get(k)==expertise){
			    							cont+=1;
			    						}
			    					}
			    					if(cont==0){
			    						expertises.add(expertise);
			    					}
			    				}
			    			}while(expertise!=1 && expertise!= 2 && expertise!=3 && expertise!=4 && expertise!=5 && expertise!=6);	
		    				do{
		    					System.out.println("Desea agregar otra nueva experticia que ha adquirido el empleado? (1. Si/ 2. No):");
		    					decision = lector.nextInt(); lector.nextLine();
		    					if(decision!=1 && decision!=2){
		    						System.out.println("Digite una opcion correcta");
		    					}
		    				} while(decision!=1 && decision!=2);	
		    			} while(decision==1);
		    			message = mainFootballClub.changeExpertisesEmployee(id,expertises,option);
    					System.out.println(message);
		    			break;
		    	}
		    	break;							
    	}
    }

    public void updateTeam(){
    	String nameTeam, newName, message, date;
    	int defenses, midfielders, forwards, sum, tactic;
    	int option = 0;
    	System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                            ACTUALIZAR LA INFORMACION DE UN EQUIPO"+
			"\n************************************************************************************************************************"+
			"\n    Elija una opcion para continuar: "+
			"\n    1. Actualizar el nombre de un equipo"+
			"\n    2. Agregar una nueva alineacion a un equipo"
		);
    	option = lector.nextInt();lector.nextLine();
    	System.out.println("Ingrese el nombre del equipo: ");
    	nameTeam = lector.nextLine();
    	switch(option){
    		case 1:
    			System.out.println("Digite el nuevo nombre que le quiere asignar al equipo: ");
    			newName = lector.nextLine();
    			message = mainFootballClub.changeInfoTeam(nameTeam, newName);
    			System.out.println(message);
    			break;
    		case 2:
    			System.out.println("Ingrese la fecha en que esta creando la alineacion: ");
    			date = lector.nextLine();
    			do{
    				System.out.println(
						"\nElija la tactica implementada en la alineacion: "+
						"\n    1. Posesion"+
						"\n    2. Contraataque"+
						"\n    3. Presion alta"+
						"\n    4. Por defecto"
					);
    				tactic = lector.nextInt();
    				if(tactic!=1 && tactic!= 2 && tactic!=3 && tactic!=4){
    					System.out.println("Ingrese una opcion correcta");
    				}
    			} while(tactic!=1 && tactic!= 2 && tactic!=3 && tactic!=4);	
    			do{
    				do{
    					System.out.println("Ingrese el numero de defensores que quiere agregar para la alineacion: ");
    					defenses = lector.nextInt();
    					if(defenses<1 || defenses>7){
    						if(defenses<1){
    							message = "Debe ingresar por lo menos 1 jugador en la linea de defensa";
    							System.out.println(message);
    						}else{
    							message = "El numero maximo de jugadores que se puede ingresar en la linea de defensa es 7";
    							System.out.println(message);
    						}
    					}
    				}while(defenses<1 || defenses>7);
    				do{	
    					System.out.println("Ingrese el numero de volantes que quiere agregar para la alineacion: ");
    					midfielders = lector.nextInt();
    					if(midfielders<1 || defenses>7){
    						if(midfielders<1){
    							message = "Debe ingresar por lo menos 1 jugador en la linea de volantes";
    							System.out.println(message);
    						} else{
    							message = "El numero maximo de jugadores que se puede ingresar en la linea de volantes es 7";
    							System.out.println(message);
    						}	
    					}
    				}while(midfielders<1 || defenses>7);	
    				do{
    					System.out.println("Ingrese el numero de delanteros que quiere agregar para la alineacion: ");
    					forwards = lector.nextInt();
    					if(forwards<1 || forwards>7){
    						if(forwards<1){
    							message = "Debe ingresar por lo menos 1 jugador en la linea de delanteros";
    							System.out.println(message);
    						}else{
    							message = "\nEl numero maximo de jugadores que se puede ingresar en la linea de delanteros es 7";
    							System.out.println(message);
    						}
    					}
    				}while(forwards<1 || forwards>7);
    				sum = defenses+midfielders+forwards;
    				if(sum!=10){
    					message = "No es posible realizar la formacion escogida, recuerde que el numero total de jugadores escogidos debe ser igual a 10\n";
    					System.out.println(message);
    				}
    			} while(sum!=10);
    			message = mainFootballClub.addLineupToTeam(nameTeam,date,tactic,defenses,midfielders,forwards);
    			System.out.println(message);
    			lector.nextLine();
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

	public void displayAnEmployee(){
		String id, message;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                     INFORMACION DEL EMPLEADO"+
			"\n************************************************************************************************************************"
		);
		System.out.println("Ingrese el numero de identificacion del empleado sobre el cual quiere conocer toda su informacion: ");
		id = lector.nextLine();
		message = mainFootballClub.showAnEmployee(id);
		System.out.println(message);
	}

	public void displayATeam(){
		String name, message;
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                       INFORMACION DEL EQUIPO"+
			"\n************************************************************************************************************************"
		);
		System.out.println("Ingrese el nombre del equipo sobre el cual quiere conocer toda su informacion: ");
		name = lector.nextLine();
		message = mainFootballClub.showATeam(name);
		System.out.println(message);
	}

	public void displayInfoFacilities(){
		String message = mainFootballClub.showFacilities();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                INFORMACION DE LAS INSTALACIONES DEL CLUB"+
			"\n************************************************************************************************************************"+
			message
		);
	}

	public void showAllInfoClub(){
		String message = mainFootballClub.toString()+mainFootballClub.showEmployees()+mainFootballClub.showTeams()+mainFootballClub.showFacilities();
		System.out.println(
			"\n************************************************************************************************************************\n"+
			"                                                   INFORMACION COMPLETA SOBRE EL CLUB"+
			"\n************************************************************************************************************************"+
			message
		);
	}
}	