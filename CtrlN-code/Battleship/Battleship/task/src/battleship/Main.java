package battleship;

import java.util.Arrays;
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
        boolean strigSize = a.length() <= 2 && b.length() <= 2;

        Battleship aircraftCarrier = new Battleship();
        creatShip(aircraftCarrier, field, strigSize, a, b, 5);
        aircraftCarrier.printBattleField(a, b, field);
        System.out.println("Enter the coordinates of the Battleship (4 cells):");

        Battleship battleship = new Battleship();
        a = scanner.next();
        b = scanner.next();
        a = a.toUpperCase();
        b = b.toUpperCase();
        creatShip(battleship, field, strigSize, a, b, 4);
        battleship.printBattleField(a, b, field); // de modificat printarea sa nu suprascrie cu ~ vechia asezare
        // System.out.println(Arrays.deepToString(field));

//        if (strigSize) {
//            while (true) {
//                if (aircraftCarrier.toClose(a, b, field) || !strigSize) {
//                    System.out.println("Error! You placed it too close to another one. Try again:");
//                    a = scanner.next();
//                    b = scanner.next();
//                    a.toUpperCase();
//                    b.toUpperCase();
//                } else {
//                    break;
//                }
//            }
//
//            while (true) {
//                if (aircraftCarrier.horizontalNumberCheck(a, b, 5) &&
//                        aircraftCarrier.verticalLetterCheck(a, b, 5) &&
//                        aircraftCarrier.verifyDiagonal(a, b, field)) {
//                    aircraftCarrier.printBattleField(a, b, field);
//                    break;
//                } else {
//                    System.out.println("Error! Wrong ship location! Try again:");
//                    a = scanner.next();
//                    b = scanner.next();
//                    a = a.toUpperCase();
//                    b = b.toUpperCase();
//                    while (!strigSize) {
//                        a = scanner.next();
//                        b = scanner.next();
//                        a = a.toUpperCase();
//                        b = b.toUpperCase();
//                    }
//                }
//            }
//
// }

    }

    public static void creatShip(Battleship bat, String[][] arr, boolean bol, String a, String b, int shipSize){

        Scanner scanner = new Scanner(System.in);
        if (bol) {
            while (true) {
                if (bat.toClose(a, b, arr) || !bol) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    a = scanner.next();
                    b = scanner.next();
                    a.toUpperCase();
                    b.toUpperCase();
                } else {
                    break;
                }
            }

            while (true) {
                if (bat.horizontalNumberCheck(a, b, shipSize) &&
                        bat.verticalLetterCheck(a, b, shipSize) &&
                        bat.verifyDiagonal(a, b, arr)) {
                   // bat.printBattleField(a, b, arr);
                    break;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
                    a = scanner.next();
                    b = scanner.next();
                    a = a.toUpperCase();
                    b = b.toUpperCase();
                    while (!bol) {
                        a = scanner.next();
                        b = scanner.next();
                        a = a.toUpperCase();
                        b = b.toUpperCase();
                    }
                }
            }
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
