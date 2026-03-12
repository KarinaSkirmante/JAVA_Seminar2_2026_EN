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
	
	//4. no-args constructor
	//5. args constructors
	//6. toString
	//7. additional function (if necessary)

}
