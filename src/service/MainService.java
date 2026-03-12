package service;

import model.Country;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		Student stud1 = new Student();//Aref which is default student
		System.out.println(stud1);
		
		Student stud2 = new Student("AB987654", "John", "Sarfo",
				"ITF", 2007, Country.other, "LU236890");
		System.out.println(stud2);
		
		
	}

}
