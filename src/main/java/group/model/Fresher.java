/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FWA_Training
 */
@Entity
@Table(name = "Fresher", schema="adminboard")
@XmlRootElement
public class Fresher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "fresher_id")
    private Integer fresherId;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "birthday")
    private String birthday;
    @Column(name="active")
    private Boolean active;
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Batch batchId;

    public Fresher() {
    }
    
	public Fresher(String name, String location, String birthday,
			Boolean active, Batch batchId) {
		super();
		this.name = name;
		this.location = location;
		this.birthday = birthday;
		this.active = active;
		this.batchId = batchId;
	}

	public Fresher(Integer fresherId, String name, String location,
			String birthday, Boolean active, Batch batchId) {
		super();
		this.fresherId = fresherId;
		this.name = name;
		this.location = location;
		this.birthday = birthday;
		this.active = active;
		this.batchId = batchId;
	}
	
	public Fresher(Integer fresherId) {
        this.fresherId = fresherId;
    }

    public Integer getFresherId() {
        return fresherId;
    }

    public void setFresherId(Integer fresherId) {
        this.fresherId = fresherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }
    
    public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (fresherId != null ? fresherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fresher)) {
            return false;
        }
        Fresher other = (Fresher) object;
        if ((this.fresherId == null && other.fresherId != null) || (this.fresherId != null && !this.fresherId.equals(other.fresherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fresher[ fresherId=" + fresherId + " ]";
    }
    
}
