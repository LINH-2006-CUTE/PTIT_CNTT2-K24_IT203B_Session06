package ticketfilm;

import java.util.Scanner;

class BookingCounter extends Thread {
    String name;
    TicketPool pool;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        Ticket t = pool.holdTicket();
        if (t != null) {
            System.out.println(name + ": Đã giữ vé " + t.id + ". Vui lòng thanh toán");
            try {
                Thread.sleep(3000);
                pool.sellTicket(t);
                System.out.println(name + "Thanh toán thành công vé " + t.id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}