package it.unical.classmanager.model.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="material")
public class Material implements Serializable  {
	private static final long serialVersionUID = -7994141386221102256L;

	@Id
	@Column(name="id", nullable=false, length=250)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name", nullable=false, length=250)
	private String name;
	
	@Column(name="type", nullable=false, length=250)
	private String type;

	@Column(name="hidden", nullable=false)
	private boolean hidden;
	
	@Column(name="filePath", nullable=false, length=256)
	private String filePath;
	
	//	Foreign key section
	@ManyToOne
	@JoinColumn(name = "lecture")
	private Lecture lecture;
	
	public Material(){
		this.id = 0;
		this.name = "";
		this.hidden = true;
		this.filePath = "";
		this.lecture = null;
	}

	public Material(int id, String name, String type, boolean hidden, String filePath, Lecture lecture) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.hidden = hidden;
		this.filePath = filePath;
		this.lecture = lecture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + (hidden ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((lecture == null) ? 0 : lecture.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (hidden != other.hidden)
			return false;
		if (id != other.id)
			return false;
		if (lecture == null) {
			if (other.lecture != null)
				return false;
		} else if (!lecture.equals(other.lecture))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}