package ticket;

import java.util.Scanner;

public class Ticket {
    private String ticketId;
    private String roomName;
    private boolean isSold;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
    }

    public String getTicketId() { return ticketId; }
    public void setSold(boolean sold) { isSold = sold; }
    public boolean isSold() { return isSold; }
}