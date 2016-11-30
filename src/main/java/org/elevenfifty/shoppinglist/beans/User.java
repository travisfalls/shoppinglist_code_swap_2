package org.elevenfifty.shoppinglist.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String fullName;

	@NotNull
	private boolean active;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	@OneToMany
	private Set<ShoppingList> shoppingLists;

	@OneToMany
	private Set<UserRole> userRoles;

	public User() {
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

	public String getUserName() {
		return email;
	}

	public void setUserName(String userName) {
		this.email = userName;
		updateModifiedUtc();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		updateModifiedUtc();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
		updateModifiedUtc();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public Set<ShoppingList> getShoppingLists() {
		return shoppingLists;
	}

	public void setShoppingLists(Set<ShoppingList> shoppingLists) {
		this.shoppingLists = shoppingLists;
		updateModifiedUtc();
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
		updateModifiedUtc();
	}

}
