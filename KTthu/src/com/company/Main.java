package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerStudents manager = new ManagerStudents();
        while (true) {
            System.out.println("------Menu------");
            System.out.println("1. xem danh sách sinh viên");
            System.out.println("2. thêm mới");
            System.out.println("3. cập nhập");
            System.out.println("4. xóa");
            System.out.println("5. sắp xếp");
            System.out.println("6. đọc từ file");
            System.out.println("7. ghi ra file");
            System.out.println("8. thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    manager.show();
                    break;
                case 2:
                    manager.add();
                    break;
                case 3:
                    manager.update();
                    break;
                case 4:
                    manager.remove();
                    break;
                case 5:
                    manager.sort();
                    break;
                case 6:
                    manager.readToFile();
                    break;
                case 7:
                    manager.writeToFile();
                    break;
                case 8:
                    System.exit(0);

            }
        }
    }
}
