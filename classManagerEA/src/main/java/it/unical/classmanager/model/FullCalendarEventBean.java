package it.unical.classmanager.model;

/*
 * This class is representative of an event in the calendar. An event contains information about commitments
 * Params: 
 * @id:Long is the identifier of the event
 * @title:String is the name of the event
 * @start:String is the time (month-day-hours) in which the event should start.
 * @end:String	is the time (month-day-hours) in which the event should terminate.
 * 
 */
public class FullCalendarEventBean {

	private Long id;
	private String title;
	private String start;
	private String end;
	
	public FullCalendarEventBean() {
		//TODO
	}
	
	/*public FullCalendarEventBean(Long id, String title, String start, String end) {
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
	}*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
}

