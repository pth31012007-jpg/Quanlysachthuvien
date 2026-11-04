import java.util.Scanner;
import java.time.Year;

public class BTT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== TUAN 3: Nhap thong tin sach =====
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

        // ===== TUAN 4 - Bai 1: Kiem tra hop le =====
        int namHienTai = Year.now().getValue();
        boolean hopLe = true;
        if (donGia <= 0) {
            System.out.println("Loi: Don gia phai > 0");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Loi: So luong phai >= 0");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > namHienTai) {
            System.out.println("Loi: Nam xuat ban khong hop le (1900 - " + namHienTai + ")");
            hopLe = false;
        }
        if (!hopLe) {
            System.out.println("Sach khong hop le!");
            sc.close();
            return;
        }
        System.out.println("Sach hop le.");

        // ===== TUAN 3: Tinh tien =====
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTien = thanhTien + phiVanChuyen;

        // ===== TUAN 4 - Bai 2: Phan loai gia =====
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sach gia thap";
        } else if (donGia <= 100000) {
            loaiGia = "Sach gia trung binh";
        } else if (donGia <= 200000) {
            loaiGia = "Sach gia cao";
        } else {
            loaiGia = "Sach gia dac biet";
        }

        // ===== TUAN 4 - Bai 3: Phan loai ton kho =====
        String tinhTrangKho;
        if (soLuong == 0) {
            tinhTrangKho = "Het sach";
        } else if (soLuong <= 5) {
            tinhTrangKho = "Sap het";
        } else if (soLuong <= 20) {
            tinhTrangKho = "Con it";
        } else {
            tinhTrangKho = "Con nhieu";
        }

        // ===== TUAN 4 - Bai 4: Chon loai sach bang switch =====
        System.out.println("Chon loai sach: 1. Sach giao khoa  2. Sach tham khao  3. Sach chuyen nganh  4. Sach khac");
        System.out.print("Nhap lua chon: ");
        int chon = Integer.parseInt(sc.nextLine());
        String loaiSach;
        switch (chon) {
            case 1:
                loaiSach = "Sach giao khoa";
                break;
            case 2:
                loaiSach = "Sach tham khao";
                break;
            case 3:
                loaiSach = "Sach chuyen nganh";
                break;
            case 4:
                loaiSach = "Sach khac";
                break;
            default:
                loaiSach = "Lua chon khong hop le";
        }

        // ===== Hien thi ket qua =====
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
        System.out.println("Phan loai gia: " + loaiGia);
        System.out.println("Tinh trang kho: " + tinhTrangKho);
        System.out.println("Loai sach: " + loaiSach);

        sc.close();
    }
}