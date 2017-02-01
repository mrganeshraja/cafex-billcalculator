package com.capgemini.ddctdev.exercise.basic;

/**
 * BillCalculator calculates total cost of items added to it.
 *
 * @author Ganesh Raja
 * @since 0.1
 */
public interface BillCalculator {

    /** Calculate total */
    double calculateTotal();

    /** Add items to calculator */
    void addItems(String... items);
}
