package baitapgioi;

import java.util.Scanner;
import java.util.LinkedList;

public class TicketPool {
    private String name;
    private LinkedList<String> list = new LinkedList<>();
    private int count = 1;

    public TicketPool(String name) { this.name = name; }

    public synchronized String removeTicket(String seller) throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println(seller + " đang ĐỢI vé tại " + name);
            wait();
        }
        return list.removeFirst();
    }

    public synchronized void addTickets(int num) {
        for (int i = 0; i < num; i++) {
            list.add(name + (count++));
        }
        System.out.println(" đã thêm " + num + " vé vào " + name );
        notifyAll();
    }
}