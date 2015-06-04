package com.registration;
import java.util.ArrayList;
import java.util.List;


public class Course {
	private String name;
	private Instructor courseInstructor;
	private List<Student> enrolledStudents;
	protected int enrollmentLimit;
	private List<Student> waitingStudents;
	
	public Course(){
		enrolledStudents = new ArrayList<Student>();
		waitingStudents = new ArrayList<Student>();
		enrollmentLimit = 20;//assuming 20 is default enrollment Limit
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Instructor getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(Instructor courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	public int getEnrollmentLimit() {
		return enrollmentLimit;
	}
	public void setEnrollmentLimit(int enrollmentLimit) {
		this.enrollmentLimit = enrollmentLimit;
	}
	public List<Student> getWaitingStudents() {
		return waitingStudents;
	}
	public void setWaitingStudents(List<Student> waitingStudents) {
		this.waitingStudents = waitingStudents;
	}
	
	
	public int getEnrolledCount(){
		return enrolledStudents.size();
	}
	
	public int getWaitingCount(){
		return waitingStudents.size();
	}
	//business logic methods
	
	
	//This method adds a Student into enrolledStudents list, If limit exceeds it ll add to waiting list
	public void registerStudent(Student student){
		int enrolledCount =enrolledStudents.size();
		if(enrolledCount>= enrollmentLimit){
			waitingStudents.add(student);
		}else{
			enrolledStudents.add(student);
		}
		
	}
	
	//This method removes a Student from enrolledStudents list, adds the first of waiting list into enrollment list
	public void dropStudent(Student student){
		enrolledStudents.remove(student);
		if(!waitingStudents.isEmpty()){
			Student firstStudent = waitingStudents.remove(0);
			if(enrolledStudents.size()<enrollmentLimit){
				enrolledStudents.add(firstStudent);
			}
		}
	}
	
	

}
