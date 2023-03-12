package duke.choice.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class Customer {
    private final String name;
    private final String size;
    private final List<Clothing> items;

    public Customer(@NotNull String name, @NotNull String size) {
        this(name, size, new ArrayList<>());
    }

    public Customer(@NotNull String name, int measurement) {
        this(name, measurement, new ArrayList<>());
    }

    public Customer(@NotNull String name, int measurement, @NotNull List<Clothing> items) {
        this(name, getSizeAsString(measurement), items);
    }

    public Customer(@NotNull String name, @NotNull String size, @NotNull List<Clothing> items) {
        this.name = name;
        this.size = size;
        this.items = items;
    }

    private static @NotNull String getSizeAsString(int measurement) {
        return switch (measurement) {
            case 1, 2, 3 -> "S";
            case 4, 5, 6 -> "M";
            case 7, 8, 9 -> "L";
            default -> "XL";
        };
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull Customer copy(@NotNull String size) {
        return new Customer(name, size, items);
    }

    @Contract("_ -> new")
    public @NotNull Customer copy(int measurement) {
        return new Customer(name, getSizeAsString(measurement), items);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull Customer copy(@NotNull String name, @NotNull String size) {
        return new Customer(name, size, items);
    }

    @Contract("_, _ -> new")
    public @NotNull Customer copy(@NotNull String name, int measurement) {
        return new Customer(name, getSizeAsString(measurement), items);
    }

    public void addItems(@NotNull List<Clothing> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    public List<Clothing> getItems() {
        return items;
    }

    public double getTotalClothingCost() {
        return items.stream()
                .map(Clothing::getPrice)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public double getAveragePrice() {
        double averagePrice = 0.0;
        int count = 0;
        for (Clothing item : items) {
            if (item.isSizeL()) {
                count++;
                averagePrice += item.getPrice();
            }
        }
        return count == 0 ? 0 : averagePrice / count;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
