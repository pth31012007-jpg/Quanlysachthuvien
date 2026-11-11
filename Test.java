import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Yeu cau 3: Tao doi tuong tu lop Sach
        System.out.println("=== YEU CAU 3: Tao doi tuong Sach ===");
        Sach s1 = new Sach("S01", "Lap trinh Java", "Nguyen Van A", 2022, 10);
        Sach s2 = new Sach();
        s2.setMaSach("S02");
        s2.setTieuDe("Cau truc du lieu");
        s2.setTacGia("Tran Thi B");
        s2.setNamXuatBan(2020);
        s2.setSoLuong(5);
        s1.hienThiThongTin();
        s2.hienThiThongTin();

        // Yeu cau 4: Quan ly danh sach Sach bang ArrayList
        System.out.println("\n=== YEU CAU 4: Quan ly danh sach Sach ===");
        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(s2);

        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("4. Xoa sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Ma sach: ");
                    String ma = sc.nextLine();
                    System.out.print("Tieu de: ");
                    String tieuDe = sc.nextLine();
                    System.out.print("Tac gia: ");
                    String tacGia = sc.nextLine();
                    System.out.print("Nam xuat ban: ");
                    int nam = Integer.parseInt(sc.nextLine());
                    System.out.print("So luong: ");
                    int sl = Integer.parseInt(sc.nextLine());
                    danhSach.add(new Sach(ma, tieuDe, tacGia, nam, sl));
                    System.out.println("Da them sach.");
                    break;

                case 2:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sach rong.");
                    } else {
                        for (Sach s : danhSach) {
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();
                    boolean timThay = false;
                    for (Sach s : danhSach) {
                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                            s.hienThiThongTin();
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Khong tim thay sach.");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (danhSach.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                            danhSach.remove(i);
                            daXoa = true;
                            break;
                        }
                    }
                    System.out.println(daXoa ? "Da xoa sach." : "Khong tim thay sach.");
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