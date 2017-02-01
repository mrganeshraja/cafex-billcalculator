package com.capgemini.ddctdev.exercise.basic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class StandardBillCalculatorTest {

    private BillCalculator billCalculator;

    @Before
    public void addItems() {
        billCalculator = new StandardBillCalculator(getItems());
    }

    @Test
    public void calculateTotalFor3UniqueItems() {
       billCalculator.addItems("Cola", "Coffee", "Cheese Sandwich");
       assertTrue(3.5 == billCalculator.calculateTotal());
    }

    @Test
    public void calculateTotalForTwoUniqueItems() {
         billCalculator.addItems("Cola", "Cheese Sandwich");
        assertTrue(2.5 == billCalculator.calculateTotal());
    }

    @Test
    public void calculateTotalFor2SimilarItemsAdded() {
        billCalculator.addItems("Cola", "Cola");
        assertTrue(1.0 == billCalculator.calculateTotal());
    }

    @Test
    public void calculateTotalOnMultipleItemsAdded() {
        billCalculator.addItems("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich");
        assertTrue(8.0 == billCalculator.calculateTotal());
    }

    @Test
    public void calcualteTotalOfLargeQuantityItemsAdded() {
        String items[] = new String[40];
        IntStream.range(0, 40).forEach(i -> items[i]="Coffee");
        billCalculator.addItems(items);
        assertTrue(40 == billCalculator.calculateTotal());
    }

    private List<Item> getItems() {
        return Arrays.asList(
                new Item("Cola", "cold", 0.50),
                new Item("Coffee", "hot", 1.00),
                new Item("Cheese Sandwich", "cold", 2.00),
                new Item("Steak Sandwich", "hot", 4.50)
        );
    }

}
