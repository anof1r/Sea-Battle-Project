/*
 * Copyright
 */

package seabattle.business;

import org.springframework.stereotype.Component;

/**
 * Implementation of recursive factorial.
 *
 * @since 0.0.1
 */
@Component
public class RecursiveFactorial implements Factorial {
    @Override
    public final int calculate(final int value) {
        final int result;
        if (value == 0) {
            result = 1;
        } else {
            result = value * this.calculate(value - 1);
        }
        return result;
    }

    @Override
    public boolean canApply(int value) {
        return false;
    }
}
