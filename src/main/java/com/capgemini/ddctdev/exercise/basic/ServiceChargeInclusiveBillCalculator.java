package com.capgemini.ddctdev.exercise.basic;

import java.util.List;
import java.util.function.Function;

/**
 * <code>ServiceChargeInclusiveBillCalculator</Code> calculates total cost of given items
 * inclusive of any service charge applicable to items.
 *
 * @author Ganesh Raja
 * @since 0.1
 */
public class ServiceChargeInclusiveBillCalculator extends StandardBillCalculator {

    /** Cap Service charge greater than 20 */
    private static final Function<Double, Double> capServiceChargeNotGreaterThan20Pounds =
            (i) ->  i > 20 ? 20 : i;

    /** Round tax to two decimal places */
    private static final Function<Double, Double> roundTaxToTwoDecimal =
            (i) -> (double) Math.round(i * 100) / 100;

    /** Twenty percent */
    private final int TWENTY_PERCENT = 20;

    /** Ten percent */
    private final int TEN_PERCENT = 10;

    /**
     * Default Constructor
     *
     * @param menuItems to be used as reference.
     */
    public ServiceChargeInclusiveBillCalculator(List<Item> menuItems) {
        super(menuItems);
    }

    /**
     * Calculates the total value of the items purchased inclusive of service charge
     *
     * @return value of total items purchased inclusive of service charge.
     */
    @Override
    public double calculateTotal() {

        double total = super.calculateTotal();
        double serviceCharge = 0;

        if (isServiceChargeApplicable(TWENTY_PERCENT)) {

            serviceCharge = capServiceChargeNotGreaterThan20Pounds
                    .compose(roundTaxToTwoDecimal).apply(total * 0.20);

        } else if (isServiceChargeApplicable(TEN_PERCENT)) {

            serviceCharge = roundTaxToTwoDecimal.apply(total * 0.10);
        }
        return total + serviceCharge ;
    }

    /**
     * Check if the given service charge percentage is applicable.
     *
     * @return boolean, Return true if the charge is applicable else vice-versa.
     */
    private boolean isServiceChargeApplicable(double serviceChargePercentage) {
        return purchasedItems.stream()
                .anyMatch(item1 -> item1.getServiceCharge() == serviceChargePercentage);
    }

}
