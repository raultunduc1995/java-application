package duke.choice.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Clothing implements Comparable<Clothing> {
    private static final double MIN_PRICE = 10;
    private static final double TAX_RATE = 0.2;

    private final String description;
    private final String size;
    private double price;

    public Clothing(@NotNull String description, double price) {
        this(description, price, "M");
    }

    public Clothing(@NotNull String description, double price, @NotNull String size) {
        this.description = description;
        setPrice(price);
        this.size = size;
    }

    public double getPrice() {
        return price * (1 + TAX_RATE);
    }

    private void setPrice(double price) {
        this.price = Math.max(price, MIN_PRICE);
    }

    public String getSize() {
        return size;
    }

    public boolean isSizeS() {
        return size.equalsIgnoreCase("S");
    }

    public boolean isSizeL() {
        return size.equalsIgnoreCase("L");
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Clothing{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull Clothing other) {
        var lexicalComparison = this.description.compareTo(other.description);
        assert lexicalComparison != 0 || this.description.equals(other.description);
        return lexicalComparison;
    }
}
