package btth;

import java.util.Scanner;

public class Ticket extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Vé xe số:" + i);
        }
    }
}