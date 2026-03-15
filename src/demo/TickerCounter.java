package demo;

import java.util.Scanner;

public class TickerCounter {
    public static boolean totalticket;
    private static int totalTicket = 10;

    public synchronized void sellTicket(Thread t) {
        System.out.println("thread:" + t.getName() + "da ua duoc ve!!");
        totalTicket--;
    }
}