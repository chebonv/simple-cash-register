package chebon.vincent.cashregister;

/**
 * Cash Model (Bean/Pojo Class)
 *
 * This class organizes access to the data through serialization.
 */
public class CashModel {
    private double price;

    // empty constructor
    public CashModel(){}

    /**
     * Constructor with params. Allows an alternative way of getting and setting data
     * through the constructor
     * @param price
     */
    public CashModel(double price) {
        this.price = price;
    }

    /**
     * Gets the price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
