package model;

public class Lineup{

	//Constants
	public final static int TEN = 10;
	public final static int SEVEN = 7;

	//Atributes
	private String date;
	private String fieldFormation;
	private int[][] formation;

	//Relationships
	private Tactic lineupTactic;

	//Getters and Setters 

	/**
	* This method returns the date when a lineup was implemented. <br>
	* <b>name</b>: getDate <br>
	* @return String <code> date </code> that is a variable with the date when a lineup was implemented.
	*/

	public String getDate(){
		return date;
	}

	/**
	* This method modifies the date when a lineup was implemented. <br>
	* <b>name</b>: setDate <br>
	* <b>post</b>: the date when a lineup was implemented has been changed. <br>
	* @param date is a String variable.
	*/

	public void setDate(String date){
		this.date = date;
	}

	/**
	* This method returns the formation used in a lineup. <br>
	* <b>name</b>: getFieldFormation <br>
	* @return String <code> fieldFormation </code> that is variable with the formation of a lineup.
	*/

	public String getFieldFormation(){
		return fieldFormation;
	}

	/**
	* This method modifies the formation of a lineup. <br>
	* <b>name</b>: setFieldFormation <br>
	* <b>post</b>: the formation of a lineup has been changed. <br>
	* @param fieldFormation is a String variable.
	*/

	public void setFieldFormation(String fieldFormation){
		this.fieldFormation = fieldFormation;
	}

	/**
	* This method returns the formation used in a lineup as matrix of integers. <br>
	* <b>name</b>: getFormation <br>
	* @return integer[][] <code> formation </code> that is a matrix with the formation of a lineup.
	*/

	public int[][] getFormation(){
		return formation;
	}

	/**
	* This method modifies the formation of a lineup. <br>
	* <b>name</b>: setFormation <br>
	* <b>post</b>: the formation of a lineup has been changed. <br>
	* @param formation is a matrix of integers.
	*/

	public void setFormation(int[][] formation){
		this.formation = formation;
	}

	/**
	* This method returns the tactic that was implemented in a lineup. <br>
	* <b>name</b>: getLineupTactic <br>
	* @return Tactic <code> lineupTactic </code> that is a constant that represents the tactic that was implemented in a lineup.
	*/

	public Tactic getLineupTactic(){
		return lineupTactic;
	}

	/**
	* this method modifies the tactic that was implemented in a lineup. <br>
	* <b>name</b>: setLineupTactic<br>
	* <b>post</b>: the tactic that was implemented in a lineup has been changed. <br>
	* @param lineupTactic is a constant of type Tactic.
	*/

	public void setLineupTactic(Tactic lineupTactic){
		this.lineupTactic = lineupTactic;
	}

	/**
	* Builder method <br>
	* <b>name</b>: Lineup <br>
	* <b>pre</b>: the variables name and lineupTactic are already inicializated. <br>
	* <b>post</b>: some atributes or relationships of the class were inicializated. <br>
	* @param date is a String variable that contains the date when a lineup was implemented by a team.
	* @param lineupTactic is a integer variable that represents the tactic that is used in a lineup.
	*/

	public Lineup(String date, int lineupTactic){
		this.date = date;
		formation = new int[TEN][SEVEN];
		switch(lineupTactic){
			case 1:
				this.lineupTactic = Tactic.POSESION; 
				break;
			case 2:
				this.lineupTactic = Tactic.CONTRAATAQUE;
				break;
			case 3:
				this.lineupTactic = Tactic.PRESION_ALTA;
				break;
			case 4:
				this.lineupTactic = Tactic.POR_DEFECTO;
				break;	
		}
	}

	/**
	* This method adds a new formation of the players of a team. <br>
	* <b>name</b>: addFormation <br>
	* <b>post</b>: All the defenses, midfielders and forwards were correctly placed in the soccer field (matrix). <br>
	* @param defenses is a integer variable that contains the number of players that are going to be in the line of defense.
	* @param midfielders is a integer variable that contains the number of players that are going to be in the line of midfielders.
	* @param forwards is a list of PlayList objects that contains the number of players that are going to be in the line of forwards.
	*/

	public void addFormation(int defenses, int midfielders, int forwards){
		int x=1;
		for(int i=TEN-2;i>=0;i-=3){
			if(i==TEN-2){	
				for(int j=forwards-1;j>=0;j--){
					formation[i][j] = x;
				}
			}
			if(i==TEN-5){
				for(int j=midfielders-1;j>=0;j--){
					formation[i][j] = x;
				}
			}
			if(i==TEN-8){
				for(int j=defenses-1;j>=0;j--){
					formation[i][j] = x;
				}
			}	
		}
	}

	/**
	* This method shows to the user the formation that was implemented in a lineup. <br>
	* <b>name</b>: showFormation.<br>
	* <b>pre</b>: the variables such as defenses, midfielders, and forwards are already inicializated. <br>
 	* <b>post</b>: the formation implemented in a lineup was returned succesfully in a String variable. <br>
 	* @param defenses is a integer variable that contains the number of players that are going to be in the line of defense.
	* @param midfielders is a integer variable that contains the number of players that are going to be in the line of midfielders.
	* @param forwards is a list of PlayList objects that contains the number of players that are going to be in the line of forwards.
 	* @return String <code> fieldformation </code> that is a variable with the formation of a lineup.
	*/

	public String showFormation(int defenses, int midfielders, int forwards){
		addFormation(defenses,midfielders,forwards);
		int numDefenses = 0, numMidfielders = 0, numForwards = 0;
		for(int i=TEN-2;i>=0;i-=3){
			if(i==TEN-2){	
				for(int j=SEVEN-1;j>=0;j--){
					numForwards += formation[i][j];
				}
			}
			if(i==TEN-5){
				for(int j=SEVEN-1;j>=0;j--){
					numMidfielders += formation[i][j];
				}
			}
			if(i==TEN-8){
				for(int j=SEVEN-1;j>=0;j--){
					numDefenses += formation[i][j];
				}
			}	
		}
		fieldFormation = "La formacion ingresada es: "+numForwards+"-"+numMidfielders+"-"+numDefenses;
		return fieldFormation;
	}

	/**
	* This method produces a String with the information of a lineup. <br>
	* <b>name</b>: toString.<br>
 	* <b>post</b>: the information of a lineup was returned. <br>
 	* @return out in a <code> String </code> variable all the information of a lineup.
	*/

	public String toString(){
		return "\n                                          *******************************************************"+
			"\n                                          ********************** Alineacion *********************"+
			"\n                                          **  Fecha: "+date+
			"\n                                          **  Tactica: "+lineupTactic+
			"\n                                          **  Formacion: "+fieldFormation;	
	}
}