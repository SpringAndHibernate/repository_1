package by.tms.util;

import java.util.Scanner;

public class Reader {

    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.nextInt();
        } else return -666;
    }

    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
