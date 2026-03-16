package cenema;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CinemaManager {
    private ExecutorService executor;
    private boolean isRunning = false;
    private int totalRevenue = 0;

    public void startCinema(int numCounters) {
        if (isRunning) return;
        executor = Executors.newFixedThreadPool(numCounters);
        isRunning = true;
        System.out.println("Hệ thống rạp bắt đầu hoạt động với " + numCounters + " quầy");

        for (int i = 1; i <= numCounters; i++) {
            int id = i;
            executor.execute(() -> {
                while (isRunning) {
                    try {
                        System.out.println("Quầy " + id + " đang bán vé...");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) { break; }
                }
            });
        }
    }

    public void stopCinema() {
        isRunning = false;
        if (executor != null) executor.shutdownNow();
        System.out.println("Đã tạm dừng toàn bộ hoạt động");
    }

    public void showReport() {
        System.out.println("Tổng doanh thu: " + (new Random().nextInt(1000000)) + " VNĐ");
    }
}