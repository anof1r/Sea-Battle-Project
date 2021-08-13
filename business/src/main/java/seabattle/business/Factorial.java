/*
 * Copyright
 */

package seabattle.business;

/**
 * Calculate a factorial
 *
 * @since 0.0.1
 */
public interface Factorial {

    /**
     * Calculate a factorial.
     * @param value Value for factorial.
     * @return Result of operation.
     */
    int calculate(int value);
    /**
     * Can we apply this method for calculation.
     * @param value Value of factorial
     * @return True in case of can
     */
    boolean canApply(int value);

}
