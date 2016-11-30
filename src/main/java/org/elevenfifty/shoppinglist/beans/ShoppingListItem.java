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

	@NotNull
	private long priority;

	@NotNull
	private boolean isChecked;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

}
