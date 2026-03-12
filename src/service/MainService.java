package service;

import model.Country;
import model.ProfDegree;
import model.Professor;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		System.out.println("-----------STUDENTS---------");
		Student stud1 = new Student();//Aref which is default student
		System.out.println(stud1);
		
		Student stud2 = new Student("AB987654", "John", "Sarfo",
				"ITF", 2007, Country.other, "LU236890");
		System.out.println(stud2);
		
		System.out.println("-----------PROFESSORS---------");
		Professor prof1 = new Professor();//Karina which is default professor
		System.out.println(prof1);
		Professor prof2 = new Professor("Estere", "Vitola",ProfDegree.master);
		System.out.println(prof2);
		//some wrong values as input arguments
		Professor prof3 = new Professor("%#^%#&^%&^$^%#", "287646", null);
		System.out.println(prof3);
		
		
		
		
		
	}

}
