package com.capgemini.ddctdev.exercise.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Standard Bill Calculator used to calculate value of purchased items
 *
 * @see com.capgemini.ddctdev.exercise.basic.BillCalculator
 * @author Ganesh Raja
 * @since 0.1
 */
public class StandardBillCalculator implements BillCalculator {

    /** List of menu items in the cafe */
    private final List<Item> menuItems;

    /** List of items purchased */
    protected List<Item> purchasedItems;

    /**
     * Default Constructor
     *
     * @param menuItems to be used as reference.
     */
    public StandardBillCalculator(List<Item> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Calculate the total value of the items purchased
     *
     * @return value of total items
     */
    @Override
    public double calculateTotal() {
        return purchasedItems.stream().mapToDouble(item -> item.getCost()).sum();
    }

    /**
     * Adds Items to the calculator
     *
     * @param items to be added
     */
    @Override
    public void addItems(String... items) {
        purchasedItems = new ArrayList<Item>(5);
        enrichItemsFromMenu(purchasedItems, items);
    }

    /**
     * Enrich items available in the menu
     *
     * @param purchasedItems
     * @param items
     */
    private void enrichItemsFromMenu(List<Item> purchasedItems, String[] items) {
        Arrays.asList(items).forEach(item -> {

            Optional<Item> itemOptional = menuItems.stream()
                    .filter(i -> i.getName().equalsIgnoreCase(item))
                    .findAny();

            if (itemOptional.isPresent()) {
                purchasedItems.add(itemOptional.get());
            }
        });
    }

}
