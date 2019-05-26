/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FWA_Training
 */
@Entity
@Table(name = "Batch", schema="adminboard")
@XmlRootElement
public class Batch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private Integer batchId;
    @Column(name = "batch_name")
    private String batchName;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @JoinTable(name = "BatchCourse", schema="adminboard", joinColumns = {
        @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")}, inverseJoinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courseList;
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Language languageId;
    @OneToMany(mappedBy = "batchId", fetch = FetchType.EAGER)
    private List<Fresher> fresherList;

    public Batch() {
    }
    
    
    
    public Batch(Integer batchId, String batchName, Boolean active,
			String startDate, String endDate,
			Language languageId) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.active = active;
		this.startDate = startDate;
		this.endDate = endDate;
		this.languageId = languageId;
	}



	public Batch(String batchName, Boolean active, String startDate,
			String endDate, Language languageId) {
		super();
		this.batchName = batchName;
		this.active = active;
		this.startDate = startDate;
		this.endDate = endDate;
		this.languageId = languageId;
	}

	public Batch(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    @XmlTransient
    public List<Fresher> getFresherList() {
        return fresherList;
    }

    public void setFresherList(List<Fresher> fresherList) {
        this.fresherList = fresherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batchId != null ? batchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.batchId == null && other.batchId != null) || (this.batchId != null && !this.batchId.equals(other.batchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Batch[ batchId=" + batchId + " ]";
    }
    
}
