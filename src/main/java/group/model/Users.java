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
 * @author FWA_Training.
 */

@Entity
@Table(name = "Users", schema="adminboard")
@XmlRootElement
public class Users implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;
  @Column(name = "name")
  private String name;
  @Column(name = "active")
  private Boolean active;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "password")
  private String password;
  @JoinColumn(name = "role_id", referencedColumnName = "role_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Role roleId;

  public Users() {
  }

  public Users(Integer userId, String name, Boolean active, String userName,
		String password, Role roleId) {
	super();
	this.userId = userId;
	this.name = name;
	this.active = active;
	this.userName = userName;
	this.password = password;
	this.roleId = roleId;
}

public Users(String name, Boolean active, String userName, String password,
		Role roleId) {
	super();
	this.name = name;
	this.active = active;
	this.userName = userName;
	this.password = password;
	this.roleId = roleId;
}

public Users(Integer userId) {
    this.userId = userId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRoleId() {
    return roleId;
  }

  public void setRoleId(Role roleId) {
    this.roleId = roleId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (userId != null ? userId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not
    // set
    if (!(object instanceof Users)) {
      return false;
    }
    Users other = (Users) object;
    if ((this.userId == null && other.userId != null)
        || (this.userId != null && !this.userId.equals(other.userId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.Users[ userId=" + userId + " ]";
  }

}
