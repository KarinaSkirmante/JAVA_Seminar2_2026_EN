package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Country;
import model.Course;
import model.Grade;
import model.ProfDegree;
import model.Professor;
import model.Student;

public class MainService {

	private static ArrayList<Student> allStudents 
									= new ArrayList<Student>();
	
	private static ArrayList<Professor> allProfessors
									= new ArrayList<Professor>();
	
	private static ArrayList<Course> allCourses
									= new ArrayList<Course>();
	
	private static ArrayList<Grade> allGrades
	     							= new ArrayList<Grade>();
	
	public static void main(String[] args) {
		System.out.println("-----------STUDENTS---------");
		Student stud1 = new Student();//Aref which is default student
		Student stud2 = new Student("AB987654", "John", "Sarfo",
				"EMF", 2007, Country.Latvia, "LU236890");
		Student stud3 = new Student("AH245768", "Miray", "Turk",
				"ITF", 2008, Country.Latvia, "WP345678");
		allStudents.add(stud1);
		allStudents.add(stud2);
		allStudents.add(stud3);
		System.out.println(allStudents);
		System.out.println("-----------STUDENTS FROM LATVIA---------");
		for(int i = 0; i < allStudents.size(); i++) {
			if(allStudents.get(i).getCountry().equals(Country.Latvia)) {
				System.out.println(allStudents.get(i));
			}
		}
		
		
		
		System.out.println("-----------PROFESSORS---------");
		Professor prof1 = new Professor();//Karina which is default professor
		Professor prof2 = new Professor("Estere", "Vitola",ProfDegree.phd, "RT234567");
		//some wrong values as input arguments
		Professor prof3 = new Professor("%#^%#&^%&^$^%#", "287646", null, "asdfghgds");
		allProfessors.add(prof1);
		allProfessors.add(prof2);
		allProfessors.add(prof3);
		System.out.println(allProfessors);
		
		
		System.out.println("-----------COURSES---------");
		Course course1 = new Course();
		Course course2 = new Course("Data Structures", 10, prof2);
		allCourses.addAll(Arrays.asList(course1, course2));
		System.out.println(allCourses);
		
		System.out.println("-----------GRADE---------");
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(6,stud1, course1);//Aref got 6 in JAVA
		Grade gr3 = new Grade(8, stud2, course1);//John got 8 in JAVA
		Grade gr4 = new Grade(3, stud2, course2);//John got 3 in Data Structures
		allGrades.addAll(Arrays.asList(gr1, gr2, gr3, gr4));
		System.out.println(allGrades);
		
		System.out.println("----------PROFESSORS WITH MASTER DEGREE------");
		filterAllProfessorsWithSpecificDegree(ProfDegree.master);
		System.out.println("----------PROFESSORS WITH PHD DEGREE------");
		filterAllProfessorsWithSpecificDegree(ProfDegree.phd);
		System.out.println("----------STUDENT BIRTH YEAR > 2007------");
		try
		{
		ArrayList<Student> result 
		= filterAllStudentsWhichBirtyearIsLargerThan(2007);
		System.out.println(result);
		
		System.out.println("----------STUDENT IN ITF FACULTY-----");
		ArrayList<Student> result2 =
				filterStudentWhichFaculty("ITF");
		System.out.println(result2);
		
		System.out.println("----------COURSES FOR ESTERE-----");
		ArrayList<Course> result3 = filterCoursesByProfessorId(1);
		System.out.println(result3);
		
		System.out.println("----------FAILED GRADES-----");
		
		ArrayList<Grade> result4 = filterFailedGrades();
		System.out.println(result4);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----------CRUD FOR PROFESSOR-----");
		try {
			createNewProfessor("Karlis", "Immers", ProfDegree.master,"ED123432");
			System.out.println(allProfessors);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

				
	}
	
	
	public static void filterAllProfessorsWithSpecificDegree(ProfDegree degree) {
		//TODO check input param
		//tempP - professor object. In every iteration it is different
		for(Professor tempP : allProfessors) {
			if(tempP.getDegree().equals(degree)) {
				System.out.println(tempP);
			}
		}
	}
	//TODO create filtering function for Students which birthyear is 
	//larger than 2005
	public static ArrayList<Student> 
	filterAllStudentsWhichBirtyearIsLargerThan(int inputBirthyearThreshold) throws Exception
	{
		//TODO check input param
		
		ArrayList<Student> filteredStudents = new ArrayList<Student>();
		for(Student tempS : allStudents) {
			if(tempS.getBirthYear() >= inputBirthyearThreshold) {
				filteredStudents.add(tempS);
			}
		}
		
		
		if(filteredStudents.isEmpty()) {
			Exception myExc = new Exception
				("There is no student which birth year is larger than " + inputBirthyearThreshold);
			throw myExc;
		}
		else
		{
			return filteredStudents;
		}
		
		//John, Sarah, Anne
		
				//1. iteration -> tempS = John
				//2. iteration -> tempS = Sarah
				//3. iteration -> tempS = Anne
	}
	//TODO create filtering function for Students which faculty is ITF
	public static ArrayList<Student> 
	filterStudentWhichFaculty(String inputFaculty) throws Exception{
		//TODO check the input param
		ArrayList<Student> filteredStudents = new ArrayList<Student>();
		
		for(Student tempS : allStudents) {
			if(tempS.getFaculty().equals(inputFaculty)) {
				filteredStudents.add(tempS);
			}
		}
		
		
		if(filteredStudents.isEmpty()) {
			Exception myExc = new Exception
				("There is no student which faculty is " + inputFaculty);
			throw myExc;
		}
		else
		{
			return filteredStudents;
		}
		
	}
	
	
	//TODO create filtering functions for Course 
	//which leading professor's id is 1
	public static ArrayList<Course> 
	filterCoursesByProfessorId(long inputId) throws Exception{
		//TODO check input param
		ArrayList<Course> filteredCourse = new  ArrayList<Course>();
		for(Course tempC : allCourses) {
			if(tempC.getProfessor().getId() == inputId) {
				filteredCourse.add(tempC);
			}
		}
		
		
		if(filteredCourse.isEmpty()) {
			Exception myExc = new Exception
				("There is no course which "
						+ "leading professor is with id " + inputId);
			throw myExc;
		}
		else
		{
			return filteredCourse;
		}
		
	}
	
	
	//TODO create filtering function for Grade which ones are failed 
	//(smaller than 4)
	public static ArrayList<Grade> filterFailedGrades() throws Exception{
		
		ArrayList<Grade> filterGrades = new ArrayList<Grade>();
		
		for(Grade tempG : allGrades) {
			if(tempG.getGradeValue() < 4) {
				filterGrades.add(tempG);
			}
		}
		if(filterGrades.isEmpty()) {
			Exception myExc = new Exception
				("There is no failed grades");
			throw myExc;
		}
		else
		{
			return filterGrades;
		}
	}
	
	//CRUD - C create; R - retrieve; U - updade; D - delete
	
	//C -  create new professor
	public static void createNewProfessor(String inputName, String inputSurname,
			ProfDegree inputDegree, String inputPassportNumber)throws Exception {
		//TODO check input params
		
		for(Professor tempP : allProfessors) {
			if(tempP.getPassportNumber().equals(inputPassportNumber)) {
				Exception myEx = 
				new Exception("Professor already exists in the system");
				throw myEx;
				
			}
		}
		
		Professor newProfessor = 
		new Professor(inputName, inputSurname, inputDegree, inputPassportNumber);
		allProfessors.add(newProfessor);
		
		
		
		
	}
}
