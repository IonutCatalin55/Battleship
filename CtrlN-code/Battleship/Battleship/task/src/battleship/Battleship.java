package battleship;

import java.util.Objects;

public class Battleship {

    public boolean diagonal = true;
    public static final String[] LETTER_1 = {"0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    public static final String[] NUM = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public boolean letterOneOnField = false;
    public boolean letterTwoOnField = false;
    public boolean aircraftLetterLength = false;
    public boolean numberOneOnField = false;
    public boolean numberTwoOnField = false;
    public boolean aircraftNumberLength = false;
    public int varI = 0;
    public int varJ = 0;

    public boolean horizontalNumberCheck(String aaa, String bbb, int battleshipSize) {
        char[] arr1 = aaa.toCharArray();
        char[] arr2 = bbb.toCharArray();
        for (char c : arr1) {
            for (char c1 : arr2) {
                if (Character.isDigit(c) && Character.isDigit(c1)) {
                    for (String s : NUM) {
                        if ((c + "").equals(s)) {
                            numberOneOnField = true;
                        }
                        if ((c1 + "").equals(s)) {
                            numberTwoOnField = true;
                        }
                    }
                    int cc = Integer.parseInt(c + "");
                    int c1c1 = Integer.parseInt((c1 + ""));
                    int dif = cc - c1c1;
                    if (Math.abs(dif) + 1 == battleshipSize) {
                        aircraftNumberLength = true;
                    }
                }
            }
        }
        return numberOneOnField && numberTwoOnField && aircraftNumberLength;
    }

    public boolean verticalLetterCheck(String aaa, String bbb, int battleshipSize) {
        char[] arr1 = aaa.toCharArray();
        char[] arr2 = bbb.toCharArray();
        for (char c : arr1) {
            for (char c1 : arr2) {
                if (Character.isLetter(c) && Character.isLetter(c1)) {
                    for (String s : LETTER_1) {
                        if ((c + "").equals(s)) {
                            letterOneOnField = true;
                            break;
                        }
                    }
                    for (String s1 : LETTER_1) {
                        if ((c1 + "").equals(s1)) {
                            letterTwoOnField = true;
                            break;
                        }
                    }
                }
                int dif = Integer.parseInt(arr1[1] + "") - Integer.parseInt(arr2[1] + "");
                if (Math.abs(dif) + 1 == battleshipSize) {
                    aircraftLetterLength = true;
                }
            }
        }

        return letterOneOnField && letterTwoOnField && aircraftLetterLength;
    }

    public boolean verifyDiagonal(String aa, String ba, String[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                char[] arr1 = aa.toCharArray();
                char[] arr2 = ba.toCharArray();
                for (char c : arr1) {
                    for (char c1 : arr2) {
                        if (c == c1) {
                            diagonal = false;
                            break;
                        }
                    }
                }
            }
        }
        return !diagonal;
    }

    public Battleship() {
    }

    public void printBattleField(String a, String b, String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(!Objects.equals(arr[i][j], "O"))
                arr[i][j] = "~";
                arr[i][0] = LETTER_1[i];
                arr[0][j] = NUM[j];
            }
        }


        if (b.charAt(0) == a.charAt(0)) {
            String compare = a.charAt(0) + "";
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (compare.equals(arr[i][j])) {
                        varI = i;
                        break;
                    }
                }
            }
            int aOrizontal = Integer.parseInt(a.charAt(1) + "");
            int bOrizontal = Integer.parseInt(b.charAt(1) + "");


            for (int i = varI; i <= varI; i++) {
                for (int j = Math.min(aOrizontal, bOrizontal); j <= Math.max(aOrizontal, bOrizontal); j++) {
                    arr[i][j] = "O";
                }
            }
        } else if (b.charAt(1) == a.charAt(1)) {
            varJ = Integer.parseInt(a.charAt(1) + "");
            int indexOfLetterA = 0;
            int indexOfLetterB = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if ((a.charAt(0) + "").equals(arr[i][j])) {
                        indexOfLetterA = i;
                    }
                    if ((b.charAt(0) + "").equals(arr[i][j])) {
                        indexOfLetterB = i;
                    }
                }
            }
            for (int i = Math.min(indexOfLetterA, indexOfLetterB); i <= Math.max(indexOfLetterA, indexOfLetterB); i++) {
                for (int j = varJ; j <= varJ; j++) {
                    arr[i][j] = "O";
                }
            }
        }


        arr[0][0] = " ";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean toClose(String a, String b, String[][] arr) {
        boolean toClose = false;
        if (b.charAt(0) == a.charAt(0)) {
            String compare = a.charAt(0) + "";
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (compare.equals(arr[i][j])) {
                        varI = i;
                        break;
                    }
                }
            }
            int aOrizontal = Integer.parseInt(a.charAt(1) + "");
            int bOrizontal = Integer.parseInt(b.charAt(1) + "");


            for (int i = varI - 1; i <= varI + 1; i++) {
                for (int j = Math.min(aOrizontal, bOrizontal) - 1; j <= Math.max(aOrizontal, bOrizontal) + 1; j++) {
                    if (arr[i][j].contains("O")) {
                        toClose = true;
                        break;
                    }
                }
            }
        } else if (b.charAt(1) == a.charAt(1)) {
            varJ = Integer.parseInt(a.charAt(1) + "");
            int indexOfLetterA = 0;
            int indexOfLetterB = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if ((a.charAt(0) + "").equals(arr[i][j])) {
                        indexOfLetterA = i;
                    }
                    if ((b.charAt(0) + "").equals(arr[i][j])) {
                        indexOfLetterB = i;
                    }
                }
            }
            for (int i = Math.min(indexOfLetterA, indexOfLetterB) - 1; i <= Math.max(indexOfLetterA, indexOfLetterB) + 1; i++) {
                for (int j = varJ - 1; j <= varJ + 1; j++) {
                    if (arr[i][j].contains("O")) {
                        toClose = true;
                        break;
                    }
                }
            }
        }

        return toClose;
    }

}
