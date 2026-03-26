package service;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

import model.Country;
import model.Course;
import model.Grade;
import model.Person;
import model.ProfDegree;
import model.Professor;
import model.Student;

public class MainService {

	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	
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
		allPersons.add(stud1);
		allPersons.add(stud2);
		allPersons.add(stud3);
		//print out only students
		for(Person tempP : allPersons) {
			if(tempP instanceof Student) {//if this person is actually student
				System.out.println(tempP);
			}
		}
		
		
		
		System.out.println("-----------STUDENTS FROM LATVIA---------");
		for(int i = 0; i < allPersons.size(); i++) {
			if(allPersons.get(i) instanceof Student)//checks if person is actually a Student
			{
				Student tempStudent = (Student)allPersons.get(i);
				if(tempStudent.getCountry().equals(Country.Latvia)) {
					System.out.println(tempStudent);
				}
			}
		}
		
		
		
		System.out.println("-----------PROFESSORS---------");
		Professor prof1 = new Professor();//Karina which is default professor
		Professor prof2 = new Professor("Estere", "Vitola",ProfDegree.phd, "RT234567");
		//some wrong values as input arguments
		Professor prof3 = new Professor("%#^%#&^%&^$^%#", "287646", null, "asdfghgds");
		allPersons.add(prof1);
		allPersons.add(prof2);
		allPersons.add(prof3);
		for(Person tempP : allPersons) {
			if(tempP instanceof Professor) {
				System.out.println(tempP);
			}
		}
		
		System.out.println("-----------ALL PERSONS---------");
		System.out.println(allPersons);
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
			System.out.println("---CREATE------");
			createNewProfessor("Karlis", "Immers", ProfDegree.master,"ED123432");
			for(Person tempP : allPersons) {
				if(tempP instanceof Professor) {
					System.out.println(tempP);
				}
			}
			System.out.println("---RETRIEVE BY ID------");
			System.out.println(getProfessorById(5));//Karlis
			System.out.println("---UPDATE BY ID------");
			updateProfessorById(2, "Vairis", "Caune", ProfDegree.phd);
			for(Person tempP : allPersons) {
				if(tempP instanceof Professor) {
					System.out.println(tempP);
				}
			}
			System.out.println("---DELETE BY ID------");
			deleteProfessorById(1);//Estere will be removed
			for(Person tempP : allPersons) {
				if(tempP instanceof Professor) {
					System.out.println(tempP);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

				
	}
	
	
	public static void filterAllProfessorsWithSpecificDegree(ProfDegree degree) {
		//TODO check input param
		//tempP - professor object. In every iteration it is different
		for(Person tempP : allPersons) {
			if(tempP instanceof Professor)
			{
				Professor tempProfessor = (Professor)tempP;
				if(tempProfessor.getDegree().equals(degree)) {
					System.out.println(tempProfessor);
				}
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
		for(Person tempP : allPersons) {
			if(tempP instanceof Student) {
				Student tempStudent = (Student) tempP;
				if(tempStudent.getBirthYear() >= inputBirthyearThreshold) {
					filteredStudents.add(tempStudent);
				}
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
		
		for(Person tempP : allPersons) {
			if(tempP instanceof Student)
			{
				Student tempStudent = (Student)tempP;
				
				if(tempStudent.getFaculty().equals(inputFaculty)) {
					filteredStudents.add(tempStudent);
				}
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
	
	//CRUD - C create; R - retrieve; U - update; D - delete
	
	//C -  create new professor
	public static void createNewProfessor(String inputName, String inputSurname,
			ProfDegree inputDegree, String inputPassportNumber)throws Exception {
		//TODO check input params
		
		for(Person tempP : allPersons) {
			//TODO if we want we can check for professor, bet passportNukber is also created in the person class
			if(tempP.getPassportNumber().equals(inputPassportNumber)) {
				Exception myEx = 
				new Exception("Professor already exists in the system");
				throw myEx;
				
			}
		}
		
		Professor newProfessor = 
		new Professor(inputName, inputSurname, inputDegree, inputPassportNumber);
		allPersons.add(newProfessor);
	}
	
	
	//R - retrieve by id
	
	public static Professor getProfessorById(long inputId) throws Exception {
		//if id is negative
		if(inputId < 0) {
			Exception myEx = new Exception("Id shoudl be 0 or positive");
			throw myEx;
		}
		//if professor with this id is found
		for(Person tempP : allPersons) {
			if(tempP instanceof Professor)
			{
				Professor tempProfessor = (Professor)tempP;
				
				if(tempProfessor.getId() == inputId) {
					return tempProfessor;
				}
			}
				
		
		}
		//if professor is not found
		Exception myEx = new Exception("No such professor with id " 
				+ inputId);
		throw myEx;
		
		
	}
	
	
	//U - update by id
	public static void updateProfessorById(long inputId,
			String inputName, String inputSurname,
			ProfDegree inputDegree) throws Exception {
		
		Professor profForUpdate = getProfessorById(inputId);
		//TODO check input params
		
		profForUpdate.setName(inputName);
		profForUpdate.setSurname(inputSurname);
		profForUpdate.setDegree(inputDegree);
	}
	
	//D - delete by id
	public static void deleteProfessorById(long inputId) throws Exception{
		Professor profForDeleting = getProfessorById(inputId);
		allPersons.remove(profForDeleting);
	}
	
}
