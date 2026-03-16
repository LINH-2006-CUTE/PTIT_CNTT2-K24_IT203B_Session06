package ticketfilm;

import java.util.Scanner;

class Ticket {
    String id;
    boolean isHeld = false;
    boolean isSold = false;
    long holdExpiryTime = 0;

    public Ticket(String id) {
        this.id = id;
    }
}