package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;

public interface RegistrationStudentClassDAO {
	
	public void create(RegistrationStudentClass registrationStudentClass);

	public void update(RegistrationStudentClass registrationStudentClass);

	public void delete(RegistrationStudentClass registrationStudentClass);

	public RegistrationStudentClass get(Integer id);

	public void deleteAllRegistrationStudentClasses();

	public int numberOfRegistrationStudentClasses();

	public List<RegistrationStudentClass> getAllRegistrationStudentClasses();

	List<Student> getStudentsRegisteredToACourse( CourseClass course);
}
