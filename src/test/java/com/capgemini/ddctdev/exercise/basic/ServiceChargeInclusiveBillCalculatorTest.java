package com.capgemini.ddctdev.exercise.basic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

/**
 * Unit test to test the features of <code>ServiceChargeBillCalculatorTest</code> class
 */
@RunWith(JUnit4.class)
public class ServiceChargeInclusiveBillCalculatorTest {

    /** Class under test */
    private BillCalculator billCalculator;

    @Before
    public void addItems() {
        billCalculator = new ServiceChargeInclusiveBillCalculator(getItems());
    }

    @Test
    public void serviceChargeNotApplicableForDrinks() {
        billCalculator.addItems("Coffee", "Cola");
        assertTrue(1.5 == billCalculator.calculateTotal());
    }

    @Test
    public void serviceTaxAppliedForDrinkAndFood() {
        billCalculator.addItems("Coffee", "Cheese Sandwich");
        assertTrue(3.3 == billCalculator.calculateTotal());
    }


    @Test
    public void serviceCharge20PcAppliedOnHotFood() {
        billCalculator.addItems("Steak Sandwich");
        assertTrue(5.4 == billCalculator.calculateTotal());
    }

    @Test
    public void serviceChargeOf20PercentAddedIfItemsContainHotFood() {
        billCalculator.addItems("Steak Sandwich", "Cola");
        assertTrue(6.0 == billCalculator.calculateTotal());
    }

    @Test
    public void serviceCharge20AddedHotFoodItemAddedAlongColdFood() {

        billCalculator.addItems("Steak Sandwich", "Cheese Sandwich");
        assertTrue(7.8  == billCalculator.calculateTotal());
    }

    @Test
    public void serviceCharge10PcAddedMultipleColdFoodAndHotDrinkAdded() {

        billCalculator.addItems("Cola", "Cola", "Cheese Sandwich", "Coffee");
        assertTrue(4.4  == billCalculator.calculateTotal());
    }

    @Test
    public void sericeCharge20PcAddedWhenDrinkHotAndColdFoodItemAdded() {
        billCalculator.addItems("Cola", "Cola", "Cheese Sandwich","Steak Sandwich","Coffee");
        assertTrue(10.2  == billCalculator.calculateTotal());
    }

    @Test
    public void serviceTaxOnHotFoodNotToExceedAbove20Pounds() {
        String items[] = new String[25];
        IntStream.range(0,25).forEach(i -> items[i] = "Steak Sandwich");
        double totalCostOf25Sandwiches = 25 * 4.50;
        billCalculator.addItems(items);
        double expectedServiceCharge = billCalculator.calculateTotal() - totalCostOf25Sandwiches;
        assertTrue(20 == expectedServiceCharge);
    }

    private List<Item> getItems() {
        return Arrays.asList(
                new DrinkItem("Cola", "cold", 0.50),
                new DrinkItem("Coffee", "hot", 1.00),
                new FoodItem("Cheese Sandwich",2.00),
                new HotFoodItem("Steak Sandwich", 4.50)
        );
    }

}
