package battleship;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        String[][] field = new String[11][11];
        printInitialBattleField(field);
        System.out.println("\nEnter the coordinates of the Aircraft Carrier (5 cells):\n");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            a = a.toUpperCase();
            b = b.toUpperCase();
            if (a.length() < 2 || b.length() < 2) {
                //verifyDiagonal(a, b, field);
            }
        }

    }

    public static void printInitialBattleField(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "~";
                arr[i][0] = Battleship.LETTER_1[i];
                arr[0][j] = Battleship.NUM[i];
            }
        }
        arr[0][0] = " ";

        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

}
