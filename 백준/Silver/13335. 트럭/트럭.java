
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Truck> queue = new LinkedList<>();
        List<Truck> trucks = new ArrayList<>();
        int N,W,L;
        int time = 1;
        int totalWeight = 0;

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        W = scanner.nextInt();
        L = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            trucks.add(new Truck(scanner.nextInt(), W));
        }

        Truck removed = trucks.remove(0);
        queue.add(removed);
        totalWeight += removed.weight;

        while (!trucks.isEmpty() || !queue.isEmpty()) {
            for (Truck truck : queue) {
                truck.distance--;
            }
            if (queue.peek().distance == 0 && !queue.isEmpty()) {
                Main.Truck remove = queue.poll();
                totalWeight -= remove.weight;
            }

            if (!trucks.isEmpty() && trucks.get(0).weight + totalWeight <= L) {
                Truck remove = trucks.remove(0);
                queue.add(remove);
                totalWeight += remove.weight;
            }
            time++;
        }
        System.out.println(time);
    }

    static class Truck{
        int weight;
        int distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
}
