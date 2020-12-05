package model;

public abstract class Employee{

	//Constants
	public final static String ACTIVE = "activo";
	public final static String INACTIVE = "inactivo";

	//Atributes
	private String name;
	private String id;
	private double salary;
	private String state;

	//Getters and Setters 

	/**
	* This method returns the name of an employee. <br>
	* <b>name</b>: getName <br>
	* @return String <code> name </code> that is a variable with the name of an employee.
	*/

	public String getName(){
		return name;
	}

	/**
	* This method modifies the name of an employee. <br>
	* <b>name</b>: setName <br>
	* <b>post</b>: the name of an employee has been changed. <br>
	* @param name is a String variable.
	*/

	public void setName(String name){
		this.name = name;
	}

	/**
	* This method returns the id of an employee. <br>
	* <b>name</b>: getId <br>
	* @return String <code> id </code> that is variable with the id of an employee.
	*/

	public String getId(){
		return id;
	}

	/**
	* This method modifies the id of an employee. <br>
	* <b>name</b>: setId <br>
	* <b>post</b>: the id of an employee has been changed. <br>
	* @param id is a String variable.
	*/

	public void setId(String id){
		this.id = id;
	}

	/**
	* This method returns the salary of an employee. <br>
	* <b>name</b>: getSalary <br>
	* @return double <code> salary </code> that is variable with the salary of an employee.
	*/

	public double getSalary(){
		return salary;
	}

	/**
	* This method modifies the salary of an employee. <br>
	* <b>name</b>: setSalary<br>
	* <b>post</b>: the salary of an employee has been changed. <br>
	* @param salary is a double variable.
	*/

	public void setSalary(double salary){
		this.salary = salary;
	}

	/**
	* This method returns the state of an employee. <br>
	* <b>name</b>: getState <br>
	* @return String <code> state </code> that is variable with the state of an employee.
	*/

	public String getState(){
		return state;
	}

	/**
	* This method modifies the state of an employee. <br>
	* <b>name</b>: setState <br>
	* <b>post</b>: the state of an employee has been changed. <br>
	* @param state is a String variable.
	*/

	public void setState(String state){
		this.state = state;
	}

	/**
	* Builder method <br>
	* <b>name</b>: Employee <br>
	* <b>pre</b>: the variables name, id and salary are already inicializated. <br>
	* <b>post</b>: All the atributes of the class were inicializated. <br>
	* @param name is a String variable that contains the name of an employee.
	* @param id is a String variable that contains the identificacion of an employee.
	* @param salary is a double variable that contains the value of the employee's salary.
	*/

	public Employee(String name, String id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
		state = ACTIVE;
	}

	/**
	* This method produces a String with all the information about an employee. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of an employee was returned. <br>
 	* @return out in a <code> String </code> variable all the information about an employee.
	*/

	public String toString(){
		String message = "\n                                          *******************************************************"+
			"\n                                          ********************** Empleado ***********************"+
			"\n                                          **  Nombre: "+name+
			"\n                                          **  Identificacion: "+id+
			"\n                                          **  Salario: "+salary+
			"\n                                          **  Estado: "+state;
		return message;
	}
}