package cenema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CinemaManager manager = new CinemaManager();

        while (true) {
            System.out.println("1. Bắt đầu rạp | 2. Tạm dừng | 5. Thống kê | 7. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.startCinema(3);
                    break;
                case 2:
                    manager.stopCinema();
                    break;
                case 5:
                    manager.showReport();
                    break;
                case 7:
                    manager.stopCinema();
                    System.out.println("Kết thúc chương trình");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}