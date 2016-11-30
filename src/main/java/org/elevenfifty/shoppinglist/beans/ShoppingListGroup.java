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
@Table(name = "shopping_list_groups")
public class ShoppingListGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String name;

	@NotNull
	private long sorting;

	@NotNull
	private Date createdUtc;

	@NotNull
	private Date modifiedUtc;

	@OneToMany
	private Set<ShoppingList> shoppingLists;

}
