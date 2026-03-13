package service;

import model.Country;
import model.Course;
import model.Grade;
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
		
		System.out.println("-----------COURSES---------");
		Course course1 = new Course();
		System.out.println(course1);
		
		Course course2 = new Course("Data Structures", 10, prof2);
		System.out.println(course2);
		
		System.out.println("-----------GRADE---------");
		Grade gr1 = new Grade();
		System.out.println(gr1);
		Grade gr2 = new Grade(6,stud1, course1);//Aref got 6 in JAVA
		System.out.println(gr2);
		Grade gr3 = new Grade(8, stud2, course1);//John got 8 in JAVA
		System.out.println(gr3);
		Grade gr4 = new Grade(10, stud2, course2);//John got 10 in Data Structures
		System.out.println(gr4);
	}

}
