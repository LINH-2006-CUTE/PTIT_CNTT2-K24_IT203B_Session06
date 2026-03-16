package btthop;

import java.util.Scanner;

import java.util.LinkedList;
import java.util.Queue;

class TicketPool {
    private Queue<Ticket> tickets = new LinkedList<>();
    private int capacity;

    public TicketPool(int initialTickets) {
        for (int i = 1; i <= initialTickets; i++) {
            tickets.add(new Ticket("Vé" + i));
            tickets.add(new Ticket("Vé" + i));
            tickets.add(new Ticket("Vé" + i));
        }
    }

    public synchronized Ticket sellTicket() throws InterruptedException {
        while (tickets.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + ": Hết vé");
            wait();
        }
        return tickets.poll();
    }

    public synchronized void addTickets(int count) {
        int startId = tickets.size() + 100; // Giả định ID mới để tránh trùng

        System.out.println("Nhà cung cấp đã thêm " + count + " vé.");
        notifyAll();
    }

    public synchronized int getAvailableCount() {
        return tickets.size();
    }
}