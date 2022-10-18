package battleship;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String[][] field = new String[11][11];
        printInitialBattleField(field);

        System.out.println("\nEnter the coordinates of the Aircraft Carrier (5 cells):\n");

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        a = a.toUpperCase();
        b = b.toUpperCase();

        Battleship aircraftCarrier = new Battleship();
        if (a.length() <= 2 && b.length() <= 2) {
            while (true) {
                if (aircraftCarrier.toClose(a, b, field)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    a = scanner.next();
                    b = scanner.next();
                } else {
                    break;
                }
            }
            // trebuie refacut pt stringuri mai mari de 2

            // si trebuie modificate tuUpperCasenpt fiecar input
            while (true) {
                if (aircraftCarrier.horizontalNumberCheck(a, b, 5) &&
                        aircraftCarrier.verticalLetterCheck(a, b, 5) &&
                        aircraftCarrier.verifyDiagonal(a, b, field)) {
                    aircraftCarrier.printBattleField(a, b, field);
                    break;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                    a = scanner.next();
                    b = scanner.next();
                }
            }
            System.out.println("Enter the coordinates of the Battleship (4 cells):");
        }

    }

    public static void printInitialBattleField(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "~";
                arr[i][0] = Battleship.LETTER_1[i];
                arr[0][j] = Battleship.NUM[j];
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
