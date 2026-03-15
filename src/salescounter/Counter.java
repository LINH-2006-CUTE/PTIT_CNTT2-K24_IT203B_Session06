package salescounter;

import demo.TickerCounter;

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Thread shop1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (TickerCounter.totalticket) {

                }
            }
        });

    }
}