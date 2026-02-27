package model;

//Model class - data class
public class Student {
	//1. variables
	private String matriculaNumber;
	private String name;
	private String surname;
	private String faculty;
	private int birthYear;
	private Country country;
	private String passportNumber;
	//2. getters
	public String getMatriculaNumber() {
		return matriculaNumber;
	}
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
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
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	//3. setters
	//4. no-arg constructor
	//5. arg-constructor
	//6.toString
	//7. other functions

}
