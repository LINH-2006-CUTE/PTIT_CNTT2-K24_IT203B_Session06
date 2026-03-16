package btthop;

import java.util.Scanner;

class TicketSupplier implements Runnable {
    private TicketPool pool;

    public TicketSupplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(3000);
                pool.addTickets(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}