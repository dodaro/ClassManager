package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name ="lecture")
public class Lecture implements Serializable  {
	private static final long serialVersionUID = -5352067424398543272L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="number", nullable=false)
	private int number;
	
	@Column(name="topic", nullable=false, length=32)
	@Pattern(regexp = "^[A-Za-z0-9 ]+$")
	private String topic;
	
	@Column(name="description", nullable=false, length=256)
	@Pattern(regexp = "^[A-Za-z0-9 ]+$")
	private String description;
	
	@Column(name="date", nullable=false, length=32)
	private Date date;
	
	@Column(name="beginHour", nullable=false, length=32)
	private Time beginHour;
	
	@Column(name="endHour", nullable=false, length=32)
	private Time endHour;
	
	@Column(name="classroom", nullable=false, length=32)
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String classroom;

	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "courseClass")
	private CourseClass courseClass;
	
	@OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Material> materials;
	
	@OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Question> questions;
	
	@OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<AttendanceStudentLecture> attendanceStudentLectures;
	
	@OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Homework> homeworks;
	
	public Lecture(){
		this.id = 0;
		this.number = 0;
		this.topic = "";
		this.description = "";
		this.date = null;
		this.beginHour = null;
		this.endHour = null;
		this.classroom = "";
		this.courseClass = null;
		this.materials = new ArrayList<Material>();
		this.questions = new ArrayList<Question>();
		this.attendanceStudentLectures = new ArrayList<AttendanceStudentLecture>();
		this.homeworks = new ArrayList<Homework>();
	}

	public Lecture(int id, int number, String topic, String description, Date date, Time beginHour, Time endHour,
			String classroom, CourseClass courseClass, List<Material> materials, List<Question> questions,
			List<AttendanceStudentLecture> attendanceStudentLectures, List<Homework> homeworks) {
		this.id = id;
		this.number = number;
		this.topic = topic;
		this.description = description;
		this.date = date;
		this.beginHour = beginHour;
		this.endHour = endHour;
		this.classroom = classroom;
		this.courseClass = courseClass;
		this.materials = materials;
		this.questions = questions;
		this.attendanceStudentLectures = attendanceStudentLectures;
		this.homeworks = homeworks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(Time beginHour) {
		this.beginHour = beginHour;
	}

	public Time getEndHour() {
		return endHour;
	}

	public void setEndHour(Time endHour) {
		this.endHour = endHour;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public CourseClass getCourseClass() {
		return courseClass;
	}

	public void setCourseClass(CourseClass courseClass) {
		this.courseClass = courseClass;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<AttendanceStudentLecture> getAttendanceStudentLectures() {
		return attendanceStudentLectures;
	}

	public void setAttendanceStudentLectures(List<AttendanceStudentLecture> attendanceStudentLectures) {
		this.attendanceStudentLectures = attendanceStudentLectures;
	}

	public List<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	
}