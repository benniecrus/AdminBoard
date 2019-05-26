/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates.
 * and open the template in the editor.
 */

package group.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FWA_Training.
 */
@Entity
@Table(name = "Course", schema = "adminboard")
@XmlRootElement
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;
	@Column(name = "name")
	private String name;
	@Column(name = "learning_duration")
	private Integer learningDuration;
	@Column(name = "number_of_lecture")
	private Integer numberOfLecture;
	@ManyToMany(mappedBy = "courseList", fetch = FetchType.EAGER)
	private List<Batch> batchList;
	@JoinColumn(name = "level_id", referencedColumnName = "level_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Level levelId;
	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Language languageId;

	public Course() {
	}
	
	public Course(String name, Integer learningDuration,
			Integer numberOfLecture, Level levelId, Language languageId) {
		super();
		this.name = name;
		this.learningDuration = learningDuration;
		this.numberOfLecture = numberOfLecture;
		this.levelId = levelId;
		this.languageId = languageId;
	}

	public Course(Integer courseId, String name, Integer learningDuration,
			Integer numberOfLecture, Level levelId, Language languageId) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.learningDuration = learningDuration;
		this.numberOfLecture = numberOfLecture;
		this.levelId = levelId;
		this.languageId = languageId;
	}

	public Course(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLearningDuration() {
		return learningDuration;
	}

	public void setLearningDuration(Integer learningDuration) {
		this.learningDuration = learningDuration;
	}

	public Integer getNumberOfLecture() {
		return numberOfLecture;
	}

	public void setNumberOfLecture(Integer numberOfLecture) {
		this.numberOfLecture = numberOfLecture;
	}

	@XmlTransient
	public List<Batch> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<Batch> batchList) {
		this.batchList = batchList;
	}

	public Level getLevelId() {
		return levelId;
	}

	public void setLevelId(Level levelId) {
		this.levelId = levelId;
	}

	public Language getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Language languageId) {
		this.languageId = languageId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (courseId != null ? courseId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not
		// set
		if (!(object instanceof Course)) {
			return false;
		}
		Course other = (Course) object;
		if ((this.courseId == null && other.courseId != null)
				|| (this.courseId != null && !this.courseId
						.equals(other.courseId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Course[ courseId=" + courseId + " ]";
	}

}
