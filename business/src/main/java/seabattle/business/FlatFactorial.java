package seabattle.business;

/*
 * Copyright
 */

import seabattle.database.FactorialCrud;
import seabattle.database.FactorialResultsCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Check factorial using cycle.
 *
 * @since 0.0.1
 */
@Component
public class FlatFactorial extends AbstractFactorial {

    /**
     * Default constructor.
     *
     * @param factorial Crud factorial instance.
     * @param results Crus resilts instance.
     */
    @Autowired
    public FlatFactorial(final FactorialCrud factorial, final FactorialResultsCrud results) {
        super(factorial, results);
    }

    @Override
    public final boolean canApply(final int value) {
        final int less = 5;
        return value < less;
    }

    @Override
    protected final int performCalculation(final int value) {
        int result = 1;
        for (int idx = 1; idx <= value; ++idx) {
            result = result * idx;
        }
        return result;
    }

    @Override
    protected final String getAlgorithmName() {
        return "flat";
    }

}
