package seabattle.business;

/*
 * Copyright
 */
import database.FactorialCrud;
import database.FactorialJpa;
import database.FactorialResultsCrud;
import database.FactorialResultsJpa;

/**
 * Abstract factorial class with writing result in database.
 *
 * @since 0.0.1
 */
public abstract class AbstractFactorial implements Factorial {

    /**
     * Flat factorial.
     */
    private final FactorialJpa factorial;

    /**
     * Crud storage for write a result.
     */
    private final FactorialResultsCrud results;

    /**
     * Constructor.
     * @param factorial Crud for factorial.
     * @param results Crud for results.
     */
    protected AbstractFactorial(
            final FactorialCrud factorial,
            final FactorialResultsCrud results
    ) {
        this.factorial = factorial.getByName(this.getAlgorithmName());
        this.results = results;
    }

    @Override
    public final int calculate(final int value) {
        final int result = this.performCalculation(value);
        this.results.save(new FactorialResultsJpa(this.factorial, value, result));
        return result;
    }

    /**
     * Logic of calculation.
     * @param value Value for factorial.
     * @return Result of operation.
     */
    protected abstract int performCalculation(int value);

    /**
     * Get algorithm for calculation.
     * @return Get algorithm for calculation.
     */
    protected abstract String getAlgorithmName();
}
