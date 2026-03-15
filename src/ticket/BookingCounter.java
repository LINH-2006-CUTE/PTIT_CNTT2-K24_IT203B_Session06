package ticket;

import java.util.Random;
import java.util.Scanner;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;
    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {
        while (true) {
            Ticket t = null;
            boolean chooseA = random.nextBoolean();

            if (chooseA) {
                t = roomA.sellTicket();
                if (t == null) t = roomB.sellTicket();
            } else {
                t = roomB.sellTicket();
                if (t == null) t = roomA.sellTicket();
            }
            if (t == null) {
                break;
            }

            System.out.println(counterName + " đã bán vé " + t.getTicketId());
            soldCount++;

            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
        System.out.println(counterName + " bán được: " + soldCount + " vé");
    }
}