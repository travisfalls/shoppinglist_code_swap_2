package org.elevenfifty.shoppinglist.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "shopping_list_item_priorities")
public class ShoppingListItemPriority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String name;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	public ShoppingListItemPriority() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
