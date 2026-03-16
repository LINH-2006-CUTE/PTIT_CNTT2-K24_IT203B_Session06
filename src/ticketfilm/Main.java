package ticketfilm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketPool poolA = new TicketPool("A", 10);
        new TimeoutManager(poolA).start();

        new BookingCounter("Quầy 1", poolA).start();
    }
}