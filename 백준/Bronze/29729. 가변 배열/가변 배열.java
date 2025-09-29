import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S0 = scanner.nextInt();
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        MyList myList = new MyList(S0);

        for (int i = 0; i < N + M; i++) {
            int option = scanner.nextInt();

            if (option == 1) {
                if (myList.getS() == myList.getU()) {
                    myList.expandSize();
                    myList.add();
                } else myList.add();

            } else myList.remove();
        }

        System.out.println(myList.getS());
    }
}

class MyList {

    private int S;
    private int U;

    public MyList(int s) {
        S = s;
        U = 0;
    }

    public void expandSize() {
        S *= 2;
    }

    public void add() {
        U++;
    }

    public void remove() {
        U--;
    }

    public int getS() {
        return S;
    }

    public int getU() {
        return U;
    }
}
