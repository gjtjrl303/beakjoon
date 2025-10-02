
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        boolean isPlayInRoom = false;
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int m = scanner.nextInt();

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            int l = scanner.nextInt();
            String n = scanner.next();

            Player newPlayer = new Player(l, n);

            for (Room room : rooms) {
                if ((l >= room.level - 10 && room.level + 10 >= l) && !room.isFull()) {
                    room.addPlayer(newPlayer);
                    isPlayInRoom = true;
                    break;
                }
            }

            if (!isPlayInRoom) {
                Room newRoom = new Room(0, m, l);
                newRoom.addPlayer(newPlayer);
                rooms.add(newRoom);
            }
            isPlayInRoom = false;
        }

        for (Room room : rooms) {
            if(room.isFull()) System.out.println("Started!");
            else System.out.println("Waiting!");
            for (Player player : room.players) {
                System.out.println(player.level + " " + player.name);
            }
        }
    }
}

class Room{

    int size;
    int maxSize;
    int level;
    Set<Player> players = new TreeSet<>();

    public Room(int size, int maxSize, int level) {
        this.size = size;
        this.maxSize = maxSize;
        this.level = level;
    }

    public void addPlayer(Player player) {
        size++;
        players.add(player);
    }

    public boolean isFull() {
        return size == maxSize;
    }
}

class Player implements Comparable<Player>{
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player player) {
        return this.name.compareTo(player.name);
    }
}
