package org.elevenfifty.shoppinglist.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "shopping_list_items")
public class ShoppingListItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "shopping_list_id")
	@NotNull
	private ShoppingList shoppingList;

	@NotEmpty
	private String name;

	@NotNull
	private long sorting;

	@ManyToOne
	@JoinColumn(name = "shopping_list_item_priority_id")
	@NotNull
	private ShoppingListItemPriority shoppingListItemPriority;

	@NotNull
	private boolean isChecked;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	@OneToOne
	@JoinColumn(name = "shopping_list_item_note_id")
	private ShoppingListItemNote shoppingListItemNote;

	public ShoppingListItem() {
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

	public ShoppingList getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
		updateModifiedUtc();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		updateModifiedUtc();
	}

	public long getSorting() {
		return sorting;
	}

	public void setSorting(long sorting) {
		this.sorting = sorting;
		updateModifiedUtc();
	}

	public ShoppingListItemPriority getShoppingListItemPriority() {
		return shoppingListItemPriority;
	}

	public void setShoppingListItemPriority(ShoppingListItemPriority shoppingListItemPriority) {
		this.shoppingListItemPriority = shoppingListItemPriority;
		updateModifiedUtc();
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
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

	public ShoppingListItemNote getShoppingListItemNote() {
		return shoppingListItemNote;
	}

	public void setShoppingListItemNote(ShoppingListItemNote shoppingListItemNote) {
		this.shoppingListItemNote = shoppingListItemNote;
		updateModifiedUtc();
	}

}
