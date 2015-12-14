package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.AttendanceStudentLecture;

public interface AttendanceStudentLectureDAO {
	public void create(AttendanceStudentLecture attendanceStudentLecture);

	public void update(AttendanceStudentLecture attendanceStudentLecture);

	public void delete(AttendanceStudentLecture attendanceStudentLecture);

	public AttendanceStudentLecture get(Integer id);

	public void deleteAllAttendanceStudentLectures();

	public int numberOfAttendanceStudentLectures();

	public List<AttendanceStudentLecture> getAllAttendanceStudentLectures();
}