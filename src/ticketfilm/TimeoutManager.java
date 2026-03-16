package ticketfilm;

import java.util.Scanner;

class TimeoutManager extends Thread {
    TicketPool pool;

    public TimeoutManager(TicketPool pool) {
        this.pool = pool;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            pool.releaseExpiredTickets();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}