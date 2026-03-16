package btthop;

import java.util.Scanner;

class BookingCounter implements Runnable {
    private String name;
    private TicketPool pool;
    private int soldCount = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Ticket t = pool.sellTicket();
                if (t != null) {
                    soldCount++;
                    System.out.println(name + " bán: " + t.id);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " đã bán  " + soldCount);
        }
    }
}