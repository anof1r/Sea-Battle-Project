package seabattle.database;

/*
 * Copyright
 */
import org.springframework.data.repository.CrudRepository;

/**
 * Crud repository for connection to factorial_results table.
 *
 * @since 0.0.1
 */
public interface FactorialResultsCrud extends CrudRepository<FactorialResultsJpa, Integer> {

}
