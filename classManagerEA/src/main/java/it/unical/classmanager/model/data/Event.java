package it.unical.classmanager.model.data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="event")
public class Event implements Serializable  {
	private static final long serialVersionUID = -7308089602591068853L;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="title", nullable=false, length=32)
	private String title;
	
	@Column(name="description", nullable=false, length=256)	
	private String description;
		
	@Column(name="startDate", nullable=false)
	private Date start;
	
	@Column(name="endDate", nullable=false)
	private Date end;

	@Column(name="place", nullable=false, length=32)
	private String place;
	
	@Column(name="hourBegin", nullable=false)
	private Time hourBegin;
	
	@Column(name="hourEnd", nullable=false)
	private Time hourEnd;
	
	//	Foreign key section	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	public Event(){
		this.id = 0;
		this.title = "";
		this.description = "";
		this.start = null;
		this.end = null;
		this.place = "";
		this.hourBegin = null;
		this.hourEnd = null;
		this.user = null;
	}

	/*public Event(int id, String title, String description, Date startDate, Date endDate, String place, Time hourBegin,
			Time hourEnd, User user) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.start = startDate;
		this.end = endDate;
		this.place = place;
		this.hourBegin = hourBegin;
		this.hourEnd = hourEnd;
		this.user = user;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date startDate) {
		this.start = startDate;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date endDate) {
		this.end = endDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Time getHourBegin() {
		return hourBegin;
	}

	public void setHourBegin(Time hourBegin) {
		this.hourBegin = hourBegin;
	}

	public Time getHourEnd() {
		return hourEnd;
	}

	public void setHourEnd(Time hourEnd) {
		this.hourEnd = hourEnd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}