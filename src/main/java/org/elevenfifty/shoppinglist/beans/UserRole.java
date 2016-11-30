package org.elevenfifty.shoppinglist.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull
	private User user;

	@NotBlank
	private String role;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	public UserRole() {
		setCreatedUtc(new Date(System.currentTimeMillis()));
		updateModifiedUtc();
	}

	private void updateModifiedUtc() {
		setModifiedUtc(new Date(System.currentTimeMillis()));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		updateModifiedUtc();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		updateModifiedUtc();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
		updateModifiedUtc();
	}

	public Date getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(Date createdUtc) {
		this.createdUtc = createdUtc;
		updateModifiedUtc();
	}

	public Date getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(Date modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}

}
