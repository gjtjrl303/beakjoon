
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Point> points = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        for (Point point : points) {
            System.out.println(point);
        }

    }

    static class Point implements Comparable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object obj) {
            Point o = (Point) obj;
            if (y > o.y) return 1;
            if (y == o.y && x > o.x) return 1;
            if (x == o.x && y == o.y) return 0;
            return -1;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
