package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.CourseClass;

public interface CourseClassDAO {
	public void create(CourseClass courseClass);

	public void update(CourseClass courseClass);

	public void delete(CourseClass courseClass);

	public CourseClass get(Integer id);

	public void deleteAllCourseClasses();

	public int numberOfCourseClasses();

	public List<CourseClass> getAllCourseClasses();	
}