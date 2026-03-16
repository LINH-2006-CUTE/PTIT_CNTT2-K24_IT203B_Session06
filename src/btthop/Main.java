package btthop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketPool pool = new TicketPool(10);
        Thread q1 = new Thread(new BookingCounter("Quầy 1", pool));
        Thread q2 = new Thread(new BookingCounter("Quầy 2", pool));
        Thread supplier = new Thread(new TicketSupplier(pool));
        q1.start();
        q2.start();
        supplier.start();
        supplier.join();
        Thread.sleep(2000);
        q1.interrupt();
        q2.interrupt();
    }
}