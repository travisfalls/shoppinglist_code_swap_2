package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
