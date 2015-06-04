package com.registration.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.registration.Course;
import com.registration.Student;
import com.registration.TraditionalCourse;


public class CTest {
	private Course course ;
	
	@Before
	public void setUp() throws Exception {
		course = new TraditionalCourse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWithNoStudents() {
		
		assertEquals(course.getEnrolledCount(), 0);
		Student s = new Student();
		course.registerStudent(s);
		assertEquals(course.getEnrolledCount(), 1);
	}
	
	@Test
	public void testForRemoveStudents() {
		Student s = new Student();
		course.registerStudent(s);
		assertEquals(course.getEnrolledCount(), 1);
		course.dropStudent(s);
		assertEquals(course.getEnrolledCount(), 0);
	}
	
	@Test
	public void testForWaitingStudents() {
		for(int i=0;i<20;i++){
			Student s = new Student();
			course.registerStudent(s);
		}
		assertEquals(course.getEnrolledCount(), 20);
		assertEquals(course.getWaitingCount(), 0);
		Student s = new Student();
		course.registerStudent(s);
		assertEquals(course.getEnrolledCount(), 20);
		assertEquals(course.getWaitingCount(), 1);
	}

}
