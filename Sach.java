import java.time.Year;

public class Sach {
    // Yeu cau 1: tat ca thuoc tinh khai bao private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach() {
    }

    // Yeu cau 4: constructor day du tham so (goi setter de kiem tra du lieu)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }

    // Yeu cau 2: getters va setters public
    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }

    public String getTacGia() { return tacGia; }
    public void setTacGia(String tacGia) { this.tacGia = tacGia; }

    public int getNamXuatBan() { return namXuatBan; }

    // Yeu cau 3: nam xuat ban phai > 0 va <= nam hien tai
    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam xuat ban khong hop le (phai tu 1 den " + currentYear + "): " + namXuatBan);
        }
    }

    public int getSoLuong() { return soLuong; }

    // Yeu cau 3: so luong khong am
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong khong hop le (phai >= 0): " + soLuong);
        }
    }

    public void hienThiThongTin() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("-------------------------");
    }
}