package lesson9.labs.prob8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Main {
    static BiPredicate<Stream<OrderItem>, String> existProduct = (orderList, targetName) -> orderList == null ? false : orderList.anyMatch(item -> item.getProduct().getProductName().equals(targetName));
    List<OrderItem> orderItems = new ArrayList<>();

    public static void main(String[] args) {
        Main m = new Main();
        m.loadOrderItemData();
        System.out.println("Do any of these Order Items have an order of flowers? " +
                m.findProduct("Flowers"));
    }

    private boolean findProduct(String prodName) {
        return existProduct.test(orderItems.stream(), prodName);
    }

    private void loadOrderItemData() {
        orderItems.add(new OrderItem(new Product("1016", "Tools", 131.00), 3));
        orderItems.add(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1));
        orderItems.add(new OrderItem(new Product("1018", "Game of Go", 66.00), 2));
        orderItems.add(new OrderItem(new Product("1019", "Flowers", 221.00), 5));
    }
}
