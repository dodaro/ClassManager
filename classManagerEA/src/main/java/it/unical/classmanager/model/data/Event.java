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
	public static final short ID_EVENT_TEMP = -1;
	
	@Id
	@Column(name="id", nullable=false, length=32)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="title", nullable=false, length=32)
	private String title;
	
	@Column(name="description", nullable=true, length=256)	
	private String description;
		
	@Column(name="startDate", nullable=false)
	private Date startDate;
	
	@Column(name="endDate", nullable=false)
	private Date endDate;

	@Column(name="place", nullable=true, length=32)
	private String place;
	
	@Column(name="hourBegin", nullable=true)
	private Time hourBegin;
	
	@Column(name="hourEnd", nullable=true)
	private Time hourEnd;
	
	@Column(name="color", nullable=true)
	private String color;
	
	//	Foreign key section	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	public Event(){
		this.id = 0;
		this.title = "";
		this.description = "";
		this.setStartDate(null);
		this.setEndDate(null);
		this.place = "";
		this.hourBegin = null;
		this.hourEnd = null;
		this.user = null;
		this.color = null;
	}

	public Event(int id, String title, String description, Date startDate, Date endDate, String place, Time hourBegin,
			Time hourEnd, User user) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.hourBegin = hourBegin;
		this.hourEnd = hourEnd;
		this.user = user;
	}

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}