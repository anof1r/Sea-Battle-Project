package seabattle.database;
/*
 * Copyright
 */
import org.springframework.data.repository.CrudRepository;

/**
 * Crud repository for connection to User table.
 *
 * @since 0.0.1
 */
public interface AuthorizationCrud extends CrudRepository<seabattle.database.authorizationJpa, Integer> {

}


