package model;

public class Professor {
	//1. variables
	private long id;
	private String name;
	private String surname;
	private ProfDegree degree;
	private String passportNumber;
	
	//helper variable and no need to create set or get for it
	private static long counter = 0;
	//2. getters
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public ProfDegree getDegree() {
		return degree;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	//3. setters
	public void setId() {
		id = counter;
		counter++;
	}
	
	public void setName(String inputName) {
		if( (inputName != null) && (!inputName.isEmpty()) 
			&& (inputName.matches("[A-Z]{1}[a-z]{2,15}([ ]{1}[A-Z]{1}[a-z]{2,15})?"))) {
			name = inputName;
		}
		else
		{
			name = "Unknown";
		}
		
	}
	
	public void setSurname(String inputSurname) {
		if( (inputSurname != null) && (!inputSurname.isEmpty()) 
			&& (inputSurname.matches("[A-Z]{1}[a-z]{2,15}([ ]{1}[A-Z]{1}[a-z]{2,15})?"))) {
			surname = inputSurname;
		}
		else
		{
			surname = "Unknown";
		}
		
	}
	
	public void setDegree(ProfDegree inputDegree) {
		if(inputDegree!=null) {
			degree = inputDegree;
		}
		else
		{
			degree = ProfDegree.unknown;
		}
	}
	
	public void setPassportNumber(String inputPassportNumber) {
		if( (inputPassportNumber != null) && (!inputPassportNumber.isEmpty()
				&& (inputPassportNumber.matches("[A-Z]{2}[0-9]{6}")))) {
			passportNumber = inputPassportNumber;
		}
		else
		{
			passportNumber = "Unknown";
		}
	}
	
	
	//4. no args constructor
	public Professor() {
		setId();
		setName("Karina");
		setSurname("Skirmante");
		setDegree(ProfDegree.master);
		setPassportNumber("AQ123456");
	}
	
	
	//5. args constructor
	public Professor(String inputName, String inputSurname,
			ProfDegree inputDegree, String inputPassportNumber) {
		setId();
		setName(inputName);
		setSurname(inputSurname);
		setDegree(inputDegree);
		setPassportNumber(inputPassportNumber);
	}
	//6. toString
	public String toString() {
		//0: Karina Skirmante (master)
		String result = id + ": " + name + " " + surname +
				" (" + degree + ") " + passportNumber;
		return result;
	}
	
	
}
