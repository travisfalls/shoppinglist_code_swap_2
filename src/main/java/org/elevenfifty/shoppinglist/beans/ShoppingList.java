package org.elevenfifty.shoppinglist.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "shopping_lists")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull
	private User user;

	@NotBlank
	private String name;

	@NotBlank
	private String color;

	@NotNull
	private long sorting;

	@ManyToOne
	@JoinColumn(name = "shopping_list_group_id")
	@NotNull
	private ShoppingListGroup shoppingListGroup;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	@OneToMany
	private Set<ShoppingListItem> shoppingListItems;

}
