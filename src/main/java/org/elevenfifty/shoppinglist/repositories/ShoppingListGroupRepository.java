package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.ShoppingListGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListGroupRepository extends CrudRepository<ShoppingListGroup, Long> {

}
