/*
 * Ho ten: Phan Thanh Hien
 * Bai tap tuan 6: ArrayList
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BTT6 {
    static Scanner sc = new Scanner(System.in);

    // ===== Ham ho tro nhap so =====
    static int docInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    static double docDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
    }

    // ===== Bai 1: Mang int[] soLuong (5 cuon sach) =====
    static void bai1() {
        int[] soLuong = new int[5];
        for (int i = 0; i < soLuong.length; i++) {
            do {
                soLuong[i] = docInt("Nhap so luong sach thu " + (i + 1) + ": ");
            } while (soLuong[i] < 0);
        }

        System.out.println("\nSo luong cac cuon sach:");
        int tong = 0;
        int max = soLuong[0];
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + max);
    }

    // ===== Bai 2: ArrayList<String> luu ma sach =====
    static void bai2() {
        ArrayList<String> dsMa = new ArrayList<>();
        int chon;
        do {
            System.out.println("\n--- QUAN LY MA SACH ---");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("0. Quay lai");
            chon = docInt("Chon: ");

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach can them: ");
                    String maThem = sc.nextLine().trim();
                    if (dsMa.contains(maThem)) {
                        System.out.println("Ma sach da ton tai!");
                    } else {
                        dsMa.add(maThem);
                        System.out.println("Da them.");
                    }
                    break;
                case 2:
                    if (dsMa.isEmpty()) {
                        System.out.println("Danh sach rong.");
                    } else {
                        for (int i = 0; i < dsMa.size(); i++) {
                            System.out.println((i + 1) + ". " + dsMa.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine().trim();
                    int viTri = dsMa.indexOf(maTim);
                    if (viTri >= 0) {
                        System.out.println("Tim thay o vi tri " + (viTri + 1));
                    } else {
                        System.out.println("Khong tim thay.");
                    }
                    break;
                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine().trim();
                    if (dsMa.remove(maXoa)) {
                        System.out.println("Da xoa.");
                    } else {
                        System.out.println("Khong tim thay.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ===== Bai 3 + Bai 4: ArrayList<String> danhSachSach =====
    // Moi phan tu co dang: "maSach;tenSach;donGia;soLuong"
    static ArrayList<String> danhSachSach = new ArrayList<>();

    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            if (p[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    static void inSach(int viTri) {
        String[] p = danhSachSach.get(viTri).split(";");
        System.out.printf("Ma: %s | Ten: %s | Don gia: %.0f | So luong: %s%n",
                p[0], p[1], Double.parseDouble(p[2]), p[3]);
    }

    static void themSach() {
        System.out.print("Nhap ma sach: ");
        String ma = sc.nextLine().trim();
        if (timViTri(ma) >= 0) {
            System.out.println("Ma sach da ton tai!");
            return;
        }
        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine().trim();
        double donGia;
        do {
            donGia = docDouble("Nhap don gia (> 0): ");
        } while (donGia <= 0);
        int soLuong;
        do {
            soLuong = docInt("Nhap so luong (>= 0): ");
        } while (soLuong < 0);
        danhSachSach.add(ma + ";" + ten + ";" + donGia + ";" + soLuong);
        System.out.println("Da them sach.");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        System.out.println("\nDANH SACH SACH:");
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.print((i + 1) + ". ");
            inSach(i);
        }
    }

    static void timSach() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine().trim();
        int viTri = timViTri(ma);
        if (viTri >= 0) {
            System.out.print("Tim thay: ");
            inSach(viTri);
        } else {
            System.out.println("Khong tim thay sach co ma " + ma);
        }
    }

    static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine().trim();
        int viTri = timViTri(ma);
        if (viTri >= 0) {
            danhSachSach.remove(viTri);
            System.out.println("Da xoa sach.");
        } else {
            System.out.println("Khong tim thay sach co ma " + ma);
        }
    }

    static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine().trim();
        int viTri = timViTri(ma);
        if (viTri < 0) {
            System.out.println("Khong tim thay sach co ma " + ma);
            return;
        }
        System.out.print("Nhap ten moi: ");
        String ten = sc.nextLine().trim();
        double donGia;
        do {
            donGia = docDouble("Nhap don gia moi (> 0): ");
        } while (donGia <= 0);
        int soLuong;
        do {
            soLuong = docInt("Nhap so luong moi (>= 0): ");
        } while (soLuong < 0);
        danhSachSach.set(viTri, ma + ";" + ten + ";" + donGia + ";" + soLuong);
        System.out.println("Da sua sach.");
    }

    static void tinhTongSoLuong() {
        int tong = 0;
        for (String s : danhSachSach) {
            tong += Integer.parseInt(s.split(";")[3]);
        }
        System.out.println("Tong so luong: " + tong);
    }

    static void tinhTongGiaTri() {
        double tong = 0;
        for (String s : danhSachSach) {
            String[] p = s.split(";");
            tong += Double.parseDouble(p[2]) * Integer.parseInt(p[3]);
        }
        System.out.printf("Tong gia tri: %.0f%n", tong);
    }

    // Bai 4: Menu hoan chinh
    static void menuSach() {
        int chon;
        do {
            System.out.println("\n===== MENU QUAN LY SACH =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            chon = docInt("Chon: ");

            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 5: suaSach(); break;
                case 6: tinhTongSoLuong(); break;
                case 7: tinhTongGiaTri(); break;
                case 8: System.out.println("Thoat menu."); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 8);
    }

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== BTT6 =====");
            System.out.println("1. Bai 1: Mang so luong");
            System.out.println("2. Bai 2: ArrayList ma sach");
            System.out.println("3. Bai 3 + 4: Menu quan ly sach");
            System.out.println("0. Thoat chuong trinh");
            chon = docInt("Chon: ");

            switch (chon) {
                case 1: bai1(); break;
                case 2: bai2(); break;
                case 3: menuSach(); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        sc.close();
    }
}