package baitapgioi;

import java.util.Scanner;

public class BookingCounter implements Runnable {
    private String name;
    private TicketPool poolA, poolB;

    public BookingCounter(String name, TicketPool a, TicketPool b) {
        this.name = name;
        this.poolA = a;
        this.poolB = b;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (poolA) {
                    synchronized (poolB) {
                        String v1 = poolA.removeTicket(name);
                        String v2 = poolB.removeTicket(name);
                        System.out.println(name + " combo" + v1 + " & " + v2);
                    }
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
        }
    }
}