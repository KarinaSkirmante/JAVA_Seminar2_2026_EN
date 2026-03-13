package model;

public class Course {
	//1.variables
	private long id;
	private String title;
	private int creditPoints;
	private Professor professor;
	
	
	private static long counter = 10000;
	//2.getters
	
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getCreditPoints() {
		return creditPoints;
	}
	public Professor getProfessor() {
		return professor;
	}
	//3.setters
	public void setId() {
		id = counter;
		counter++;
	}
	
	public void setTitle(String inputTitle) {
		if((inputTitle!=null) && (!inputTitle.isEmpty())
				&& (inputTitle.matches("[A-Za-z 0-9]{3,100}"))) {
			title = inputTitle;
		}
		else
		{
			title = "Unknown";
		}
	}
	
	public void setCreditPoints(int inputCreditPoints) {
		if(inputCreditPoints > 0 && inputCreditPoints <= 10 ) {
			creditPoints = inputCreditPoints;
		}
		else
		{
			creditPoints = 1;
		}
	}
	
	public void setProfessor(Professor inputProfessor) {
		if(inputProfessor != null) {
			professor = inputProfessor;
		}
		else
		{
			professor = new Professor();
		}
	}
	
	//4. no-args constructor
	public Course() {
		setId();
		setTitle("JAVA");
		setCreditPoints(6);
		setProfessor(new Professor());//default professor will be linked to default course
	}
	//5. args constructors
	public Course(String inputTitle, int inputCreditPoints,
			Professor inputProfessor) {
		setId();
		setTitle(inputTitle);
		setCreditPoints(inputCreditPoints);
		setProfessor(inputProfessor);
	}
	//6. toString
	public String toString() {
		//0: JAVA (6 CP), K. Skirmante
		String result = id + ": " + title + " (" + creditPoints
				+ " CP), " + professor.getName().charAt(0)
				+ ". " + professor.getSurname();
		return result;
	}
	//7. additional function (if necessary)

}
