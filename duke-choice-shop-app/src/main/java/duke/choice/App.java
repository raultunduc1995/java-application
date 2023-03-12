package duke.choice;

import duke.choice.handler.ItemList;
import duke.choice.model.Clothing;
import duke.choice.model.Customer;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import org.jetbrains.annotations.NotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public final class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Duke Choice shop!");
        var c1 = generateCustomer();
        final var items = generateClothingList();

        c1.addItems(items);
        System.out.println("Total: " + c1.getTotalClothingCost());

        final int measurement = 8;
        c1 = c1.copy(measurement);
        System.out.println("Customer: " + c1);

        showAverageClothesPrice(c1);
        showSortedItems(items);

        /* Start a web server
            startWebServer(items);
         */
    }

    @NotNull
    private static Customer generateCustomer() {
        final var c1 = new Customer("Pinky", 14);
        System.out.println("Customer: " + c1);
        return c1;
    }

    @NotNull
    private static List<Clothing> generateClothingList() {
        final var items = new ArrayList<Clothing>();
        final Clothing item1 = new Clothing("Blue Jacket", 20.9),
                item2 = new Clothing("Orange T-shirt", 10.5, "S");
        items.add(item1);
        items.add(item2);
        items.add(new Clothing("Green Scarf", 5, "S"));
        items.add(new Clothing("Blue T-Shirt", 10.5, "S"));
        System.out.println("Items " + items);
        return items;
    }

    private static void showAverageClothesPrice(Customer c1) {
        try {
            System.out.println("Average clothes price: " + c1.getAveragePrice());
        } catch (ArithmeticException exception) {
            String message = exception.getLocalizedMessage();
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void showSortedItems(@NotNull List<Clothing> items) {
        items.sort(null);
        System.out.println("Sorted items: " + items);
    }

    private static void startWebServer(@NotNull List<Clothing> items) {
        try {
            final var itemList = new ItemList(items);
            final var routing = Routing.builder().get("/items", itemList).build();
            final var serverConfig = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888)
                    .build();
            final var webServer = WebServer.create(serverConfig, routing);
            System.out.println("Starting web server...");
            webServer.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
