package Budget;

//Creates an expense. 
//consist of name and amount

public class Expense {

	String eName; 
	int eAmount; 
	
	
	//constructor 
	Expense(String name, int amount) { 
		this.eName = name; 
		this.eAmount = amount; 
	};
	
	
	
	//Getters 
	public int getEAmount(){ 

		return eAmount; 
	}
	
	
	public String getEName(){
		return eName; 
	}

	//end of Getters
	

	//Setters
	
	public void setEAmount(int amount){ 
		this.eAmount = amount; 
	}
	
	public void setEName(String name){ 
		this.eName = name; 
	}
	
	//end of Setters
	
	
}
