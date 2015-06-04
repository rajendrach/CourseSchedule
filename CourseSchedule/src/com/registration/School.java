package com.registration;

import java.util.ArrayList;
import java.util.List;

public class School {
	private String name;
	private List<Course> offeringCourses;

	public School() {
		offeringCourses = new ArrayList<Course>();

	}

	public School(String name, List<Course> courses) {
		this.name = name;
		this.offeringCourses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getOfferingCourses() {
		return offeringCourses;
	}

	public void setOfferingCourses(List<Course> offeringCourses) {
		this.offeringCourses = offeringCourses;
	}
}
