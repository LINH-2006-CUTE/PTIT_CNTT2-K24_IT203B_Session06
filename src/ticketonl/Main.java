package ticketonl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketPool poolA = new TicketPool("Phòng A", 5, 2);
        List<TicketPool> allPools = Arrays.asList(poolA);
        Thread timer = new Thread(new TimeoutManager(allPools));
        timer.setDaemon(true);
        timer.start();
        new Thread(new BookingCounter("Quầy 1", poolA, true)).start();
        new Thread(new BookingCounter("Quầy 2", poolA, true)).start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        new Thread(new BookingCounter("Quầy 3", poolA, true)).start();
    }
}