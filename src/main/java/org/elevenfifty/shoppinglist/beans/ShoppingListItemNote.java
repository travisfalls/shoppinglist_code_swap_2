package org.elevenfifty.shoppinglist.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shopping_list_item_notes")
public class ShoppingListItemNote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	private String body;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	public ShoppingListItemNote() {
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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
