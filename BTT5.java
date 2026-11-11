import java.util.Scanner;

public class BTT5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bai 1: Nhap n sach bang vong lap
        int n;
        do {
            System.out.print("Nhap so luong sach n (n > 0): ");
            n = Integer.parseInt(sc.nextLine());
        } while (n <= 0);

        String[] maSach = new String[n];
        String[] tenSach = new String[n];
        double[] donGia = new double[n];
        int[] soLuong = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap sach thu " + (i + 1) + " ---");
            System.out.print("Ma sach: ");
            maSach[i] = sc.nextLine();
            System.out.print("Ten sach: ");
            tenSach[i] = sc.nextLine();
            do {
                System.out.print("Don gia (> 0): ");
                donGia[i] = Double.parseDouble(sc.nextLine());
            } while (donGia[i] <= 0);
            do {
                System.out.print("So luong (>= 0): ");
                soLuong[i] = Integer.parseInt(sc.nextLine());
            } while (soLuong[i] < 0);
        }

        // Bai 3: Menu lap den khi chon Thoat
        int chon;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hien thi danh sach sach");
            System.out.println("2. Tinh tong so luong va tong gia tri");
            System.out.println("3. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.println("\nDANH SACH SACH:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%d. %s - %s - Don gia: %.0f - SL: %d%n",
                                i + 1, maSach[i], tenSach[i], donGia[i], soLuong[i]);
                    }
                    break;

                case 2:
                    // Bai 2: Tong so luong va tong gia tri
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;
                    for (int i = 0; i < n; i++) {
                        tongSoLuong += soLuong[i];
                        tongGiaTri += donGia[i] * soLuong[i];
                    }
                    System.out.println("Tong so luong: " + tongSoLuong);
                    System.out.printf("Tong gia tri: %.0f%n", tongGiaTri);
                    break;

                case 3:
                    // Bai 4: Tim sach theo ma
                    System.out.print("Nhap ma sach can tim: ");
                    String ma = sc.nextLine();
                    boolean timThay = false;
                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equalsIgnoreCase(ma)) {
                            System.out.printf("Tim thay: %s - %s - Don gia: %.0f - SL: %d%n",
                                    maSach[i], tenSach[i], donGia[i], soLuong[i]);
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Khong tim thay sach co ma " + ma);
                    }
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}