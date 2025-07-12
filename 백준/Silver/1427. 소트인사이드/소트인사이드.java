
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] charArray = str.toCharArray();
        Character[] characters = new Character[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            characters[i] = charArray[i];
        }

        Arrays.sort(characters, (x,y) -> x > y ? -1 : 1);

        for (Character character : characters) {
            System.out.print(character);
        }
    }
}
