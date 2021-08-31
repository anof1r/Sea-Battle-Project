package seabattle.database;
/*
 * Copyright
 */
import org.springframework.data.repository.CrudRepository;
import seabattle.database.FactorialJpa;

/**
 * Crud repository for connection to Factorial table.
 *
 * @since 0.0.1
 */
public interface FactorialCrud extends CrudRepository<seabattle.database.FactorialJpa, Integer> {

    /**
     * Get algorithm type by name.
     * @param name Name of algorithm.
     * @return Algorithm object.
     */
    FactorialJpa getByName(String name);

}


