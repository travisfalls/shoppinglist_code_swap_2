package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
