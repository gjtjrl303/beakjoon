
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String option = scanner.next();
            if (option.equals("order")) {
                int tableNumber = scanner.nextInt();
                int time = scanner.nextInt();
                orders.add(new Order(tableNumber, time));
            } else if (option.equals("sort")) {
               Collections.sort(orders);
            } else if (option.equals("complete")) {
                orders.remove(new Order(scanner.nextInt(), 0));
            }

            if (orders.isEmpty()) System.out.println("sleep");
            else {
                for (Order order : orders) {
                    System.out.print(order.tableNumber + " ");
                }
                System.out.println();
            }
        }
    }
}

class Order implements Comparable {
    int tableNumber;
    int time;

    public Order(int tableNumber, int time) {
        this.tableNumber = tableNumber;
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        Order order = (Order) o;
        if (time == order.time) {
            return tableNumber - order.tableNumber;
        }
        return time - order.time;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        return tableNumber == order.tableNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber);
    }
}
