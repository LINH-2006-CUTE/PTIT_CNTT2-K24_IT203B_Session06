package ticket;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("Phòng A", 10);
        TicketPool roomB = new TicketPool("Phòng B", 10);

        BookingCounter bc1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter bc2 = new BookingCounter("Quầy 2", roomA, roomB);

        Thread t1 = new Thread(bc1);
        Thread t2 = new Thread(bc2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Vé còn lại phòng A: " + roomA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.getRemainingTickets());
    }
}