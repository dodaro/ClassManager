package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Lecture;

public interface LectureDAO {
	public void create(Lecture lecture);

	public void update(Lecture lecture);

	public void delete(Lecture lecture);

	public Lecture get(Integer id);

	public void deleteAllLectures();

	public int numberOfLectures();

	public List<Lecture> getAllLectures();	
	
	public Lecture getLastLectureAdded(String username);
    
	public List<Lecture> getAllLecturesOfACourse(CourseClass course);
}