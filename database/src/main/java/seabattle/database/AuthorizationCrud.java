package seabattle.database;
/*
 * Copyright
 */
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Crud repository for connection to User table.
 *
 * @since 0.0.1
 */
public interface AuthorizationCrud extends CrudRepository<seabattle.database.authorizationJpa, Integer> {


}


