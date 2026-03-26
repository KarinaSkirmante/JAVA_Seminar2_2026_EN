package model;

public class Person {
	//1. variables
	private String name;
	private String surname;
	private String passportNumber;
	
	
	//2. getters
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	//3.setters
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
	
	//4. both constructors
	public Person() {
		setName("Samuil");
		setSurname("Irfan");
		setPassportNumber("QW987654");
		
	}
	
	public Person(String inputName, String inputSurname, 
			String inputPassportNumber) {
		setName(inputName);
		setSurname(inputSurname);
		setPassportNumber(inputPassportNumber);
	}
	
	//5. toString
	public String toString() {
		String result = name + " " + surname + " (" + passportNumber + ")";
		return result;
	}
	
}
