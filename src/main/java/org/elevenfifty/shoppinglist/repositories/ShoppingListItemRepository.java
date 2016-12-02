package org.elevenfifty.shoppinglist.repositories;

import java.util.Set;

import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {

	Set<ShoppingListItem> findByShoppingListId(long shoppingListId);
}
