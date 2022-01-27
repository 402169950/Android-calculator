package com.tongliu.calculator.logic.inf;

/**
 * The interface for calculator, basic functions should be defined here and implemented by implementational class.
 *
 * @param <T> The data type of result.
 */
public interface CalculatorInf<T> {

    /**
     * Clear calculator data
     */
    void clear();

    /**
     * Add a number to the calculator
     *
     * @param number the appendix of number
     */
    void appendNumber(T number);

    /**
     * Add an operator to the calculator.
     *
     * @param opt the appendix of operator
     */
    void appendOperator(String opt);

    /**
     * Calculate the result with current expression.
     */
    void calculate();

    /**
     * Get only the calculation result
     *
     * @return the calculation result
     */
    T getResult();


    /**
     * Check if calculator has encouterd an error
     * @return {@value true} has an error. {@value false} has no error.
     */
    boolean hasError();

    /**
     * Return if calculator has ever calculated number after last clear.
     * @return {@value true} calculator has ever calculated number. {@value false} calculator has never calcualted number.
     */
    boolean hasCalculated();
}
