package baitapgioi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketPool a = new TicketPool("Phòng A");
        TicketPool b = new TicketPool("Phòng B");
        new Thread(new BookingCounter("Quầy 1", a, b)).start();
        new Thread(new BookingCounter("Quầy 2", a, b)).start();
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3000);
                    a.addTickets(3);
                    b.addTickets(3);
                }
            } catch (Exception e) {}
        }).start();
    }
}