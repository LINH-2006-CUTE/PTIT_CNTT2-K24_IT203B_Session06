package ticketonl;

import java.util.Scanner;

public class Ticket {
    String id;
    boolean isHeld = false;
    boolean isSold = false;
    long expiryTime = 0;
    boolean isVIP = false;

    public Ticket(String id, boolean isVIP) {
        this.id = id;
        this.isVIP = isVIP;
    }
}