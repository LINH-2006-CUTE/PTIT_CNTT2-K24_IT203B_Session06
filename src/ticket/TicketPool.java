package ticket;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int quantity) {
        this.roomName = roomName;
        for (int i = 1; i <= quantity; i++) {
            String prefix = roomName.contains("A") ? "A" : "B";
            String id = prefix + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }
        return null;
    }

    public synchronized int getRemainingTickets() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) count++;
        }
        return count;
    }
}