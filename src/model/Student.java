package model;

//Model class - data class
public class Student extends Person  {
	//1. variables
	private String matriculaNumber;
	private String faculty;
	private int birthYear;
	private Country country;
	
	//name, surname, passportNumber is from Person class
	
	//2. getters
	public String getMatriculaNumber() {
		return matriculaNumber;
	}
		
	public String getFaculty() {
		return faculty;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public Country getCountry() {
		return country;
	}
	

	
	//3. setters
	public void setMatriculaNumber(String inputMatriculaNumber) {
		if( (inputMatriculaNumber != null) 
				&& (!inputMatriculaNumber.isEmpty())
				&& (inputMatriculaNumber.matches("[A-Z]{2}[0-9]{6}"))) {
			matriculaNumber = inputMatriculaNumber;
		}
		else
		{
			matriculaNumber = "AA000000";
		}
	}
	
	
	
	
	
	
	public void setFaculty(String inputFaculty) {
		if((inputFaculty != null) && (!inputFaculty.isEmpty())
				&& (inputFaculty.matches("[A-Za-z ]{3,100}"))) {
			faculty = inputFaculty;
		}
		else
		{
			faculty = "Unknown";
		}
	}
	
	//no need to check !=null because this is primitive data type
	public void setBirthYear(int inputBirthYear) {
		if((inputBirthYear >= 1950) && (inputBirthYear <= 2020)) {
			birthYear = inputBirthYear;
		}
		else
		{
			birthYear = 2008;
		}
	}
	//enums also are referenced data type - need to check != null
	public void setCountry(Country inputCountry) {
		if(inputCountry != null) {
			country = inputCountry;
		}
		else
		{
			country = Country.unknown;
		}
	}
	
	
	//4. no-arg constructor
	public Student() {
		super();//this will call no argument constructor Person()
		setMatriculaNumber("AB123456");
		//setName("Aref");
		//setSurname("Hosseini");
		setFaculty("ITF");
		setBirthYear(2006);
		setCountry(Country.Spain);
		//setPassportNumber("SP092345");
		
	}
	//5. arg-constructor
	public Student(String inputMatriculaNumber,String inputName,
		String inputSurname, String inputFaculty, 
		int inputBirthYear, Country inputCountry, 
		String inputPassportNumber) {
		
		super(inputName, inputSurname,inputPassportNumber);
		//^^^ this will call argument constructor from the Person class
		//public Person(String inputName, String inputSurname, String inputPassportNumber)
		setMatriculaNumber(inputMatriculaNumber);
		//setName(inputName);
		//setSurname(inputSurname);
		setFaculty(inputFaculty);
		setBirthYear(inputBirthYear);
		setCountry(inputCountry);
		//setPassportNumber(inputPassportNumber);
		}
	//6.toString
	public String toString() {
		
		//Aref Hosseini (AB123456) ITF, 2006 [Spain], SP092345
		String result = name + " " + surname 
				+ " (" + matriculaNumber + ") " + faculty
				+ ", " + birthYear + " [" + country + "], "
				+ passportNumber;
		return result;
	}
	//7. other functions

}
