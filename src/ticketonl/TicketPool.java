package ticketonl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TicketPool {
    private String name;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String name, int total, int vipCount) {
        this.name = name;
        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(name + String.format("%3d", i), i <= vipCount));
        }
    }
    public synchronized Ticket holdTicket(boolean wantVIP) {
        for (Ticket t : tickets) {
            if (!t.isSold && !t.isHeld && t.isVIP == wantVIP) {
                t.isHeld = true;
                t.expiryTime = System.currentTimeMillis() + 5000;
                return t;
            }
        }
        return null;
    }

    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Ticket t : tickets) {
            if (t.isHeld && !t.isSold && now > t.expiryTime) {
                t.isHeld = false; // Trả lại kho
                System.out.println("TimeoutManager: Vé " + t.id + " hết hạn giữ chỗ, đã trả lại kho");
            }
        }
    }

    public String getName() { return name; }
}