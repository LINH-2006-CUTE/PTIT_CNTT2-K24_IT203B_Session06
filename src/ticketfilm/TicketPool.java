package ticketfilm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TicketPool {
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {
        for (int i = 1; i <= count; i++) tickets.add(new Ticket(roomName + "-" + i));
    }

    public synchronized Ticket holdTicket() {
        for (Ticket t : tickets) {
            if (!t.isHeld && !t.isSold) {
                t.isHeld = true;
                t.holdExpiryTime = System.currentTimeMillis() + 5000;
                return t;
            }
        }
        return null;
    }

    public synchronized void sellTicket(Ticket t) {
        if (t != null && t.isHeld) {
            t.isSold = true;
            t.isHeld = false;
        }
    }

    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Ticket t : tickets) {
            if (t.isHeld && now > t.holdExpiryTime) {
                t.isHeld = false;
                System.out.println("TimeoutManager: Vé " + t.id + " đã trả lại kho");
            }
        }
    }
}