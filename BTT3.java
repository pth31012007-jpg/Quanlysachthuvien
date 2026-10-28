import java.util.Scanner;

public class BTT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bai 1: Nhap thong tin sach
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = sc.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        // Bai 2: Thanh tien
        double thanhTien = donGia * soLuong;
        // Bai 3: Phi van chuyen = 5% gia tri sach
        double phiVanChuyen = thanhTien * 0.05;
        // Bai 4: Tong tien nhap
        double tongTien = thanhTien + phiVanChuyen;

        // Hien thi lai
        System.out.println("\n===== THONG TIN SACH =====");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.printf("Don gia: %.0f%n", donGia);
        System.out.println("So luong: " + soLuong);
        System.out.printf("Thanh tien: %.0f%n", thanhTien);
        System.out.printf("Phi van chuyen (5%%): %.0f%n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.0f%n", tongTien);

        sc.close();
    }
}