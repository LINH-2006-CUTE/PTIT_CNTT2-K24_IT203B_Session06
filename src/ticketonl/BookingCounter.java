package ticketonl;

import java.util.Scanner;

public class BookingCounter implements Runnable {
    private String name;
    private TicketPool pool;
    private boolean wantVIP;

    public BookingCounter(String name, TicketPool pool, boolean wantVIP) {
        this.name = name; this.pool = pool; this.wantVIP = wantVIP;
    }

    @Override
    public void run() {
        Ticket t = pool.holdTicket(wantVIP);
        if (t != null) {
            System.out.println(name + " đã giữ vé " + t.id + (t.isVIP ? " (VIP)" : "") + "Thanh toán trong 5s...");

            try {
                Thread.sleep(3000);
                if (name.equals("Quầy 1") || name.equals("Quầy 3")) {
                    t.isSold = true;
                    t.isHeld = false;
                    System.out.println(name + " thanh toán thành công" + t.id);
                }
            } catch (InterruptedException e) {}
        } else {
            System.out.println(name + "Hết vé  " + pool.getName());
        }
    }
}