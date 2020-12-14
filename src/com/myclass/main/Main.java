package com.myclass.main;

import com.myclass.array.ArrChucVu;
import com.myclass.array.ArrDuAn;
import com.myclass.array.ArrNhanSu;
import com.myclass.array.ArrPhongBan;
import com.myclass.array.ArrTaiKhoan;
import com.myclass.entity.NhanSu;
import com.myclass.entity.TaiKhoan;
import java.util.Scanner;


public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final ArrNhanSu arrNhanSu = new ArrNhanSu();
    private static final ArrTaiKhoan arrTaiKhoan = new ArrTaiKhoan();
    private static final ArrPhongBan arrPhongBan = new ArrPhongBan();
    private static final ArrDuAn arrDuAn = new ArrDuAn();
    private static final ArrChucVu arrChucVu = new ArrChucVu();
    
    public static void main(String[] args) {
            login(scan);
    }
    
    public static void login(Scanner scan) {
        String taiKhoan, matKhau;
        
        System.out.println("-------=== ĐĂNG NHẬP HỆ THỐNG ===-------");
        System.out.print(  "| Tài khoản: ");
        taiKhoan = scan.nextLine();
        System.out.print(  "| Mật khẩu:  ");
        matKhau = scan.nextLine();
        
        TaiKhoan taiKhoanDangNhap = kiemTraDangNhap(taiKhoan, matKhau);
        
        if(taiKhoanDangNhap != null) {
            System.out.println("========================================");
            System.out.println("|         ĐĂNG NHẬP THÀNH CÔNG         |");
            System.out.println("========================================");
            loginSuccess(taiKhoanDangNhap);
        }
        else {
            System.out.println("========================================");
            System.out.println("|   SAI TÊN ĐĂNG NHẬP HOẶC MẬT KHẨU!   |");
            System.out.println("========================================");
            login(scan);
        }
    }
    
    public static void loginSuccess(TaiKhoan tk) {
        String quyen = tk.getQuyen();

        switch (quyen) {
            case "Manager":
                loginAsAdmin();
                break;
            case "Director":
                loginAsAdmin();
                break;
            case "Staff":
                loginAsStaff(tk);
                break;
            default:
                break;
        }
    }
    
    public static void loginAsAdmin() {
        int luaChon;
        
        do {
            luaChon = menuForAdmin(scan);
                    
            switch(luaChon) {
                case 1:
                    System.out.println("-----=== DANH SÁCH NHÂN SỰ ===-----");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s\n",
                            "|Mã nhân sự","|Họ tên","|Giới tính","|Phòng ban","|Chức vụ","|Tên dự án", "|Tên tài khoản","|");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    arrNhanSu.xuatDanhSach();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    break;   
                case 2:
                    System.out.print("NHẬP MÃ NHÂN SỰ CẦN TÍNH LƯƠNG: ");
                    String ma = scan.nextLine();
                    arrNhanSu.taoBangLuong(ma);
                    System.out.println("Lương nhân sự này: " + arrNhanSu.getById(ma).tinhLuong());
                    break;
                case 3:
                    arrNhanSu.add();
                    break;
                case 4:
                    System.out.println("Nhập mã của nhân sự cần cập nhật:");
                    String updateId = scan.nextLine();
                    arrNhanSu.updateById(updateId);
                    break;
                case 5:
                    System.out.println("Nhập mã của nhân sự cần xóa:");
                    String delId = scan.nextLine();
                    arrNhanSu.deleteById(delId);
                    break;
                case 6:
                    String ten;
                    
                    System.out.print("Nhập tên nhân sự: ");
                    ten = scan.nextLine();
                    System.out.println("-----=== DANH SÁCH NHÂN SỰ ===-----");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s\n",
                            "|Mã nhân sự","|Họ tên","|Giới tính","|Phòng ban","|Chức vụ","|Tên dự án", "|Tên tài khoản","|");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    arrNhanSu.xuatDanhSachByName(ten);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");                    
                    break;
                case 7:
                    String maPB;
                    
                    System.out.println("-----=== DANH SÁCH PHÒNG BAN ===-----");
                    System.out.println("-----------------------------------------");
                    System.out.printf("%-15s%-25s%s\n",
                            "|Mã phòng ban", "|Tên phòng ban","|");
                    System.out.println("-----------------------------------------");
                    arrPhongBan.xuatDanhSach();
                    System.out.println("-----------------------------------------");
                    System.out.print("MỜI CHỌN MÃ PHÒNG BAN: ");
                    maPB = scan.nextLine();
                    
                    System.out.println("-----=== DANH SÁCH NHÂN SỰ " + arrPhongBan.getById(maPB).getTenPB().toUpperCase() + "===-----");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s\n",
                            "|Mã nhân sự","|Họ tên","|Giới tính","|Phòng ban","|Chức vụ","|Tên dự án", "|Tên tài khoản","|");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    arrNhanSu.xuatDanhSachByMaPB(maPB);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");                    
                    break;
                case 8:
                    String maCV;
                    
                    System.out.println("-----=== DANH SÁCH CHỨC VỤ ===-----");
                    System.out.println("-----------------------------------------");
                    System.out.printf("%-15s%-25s%s\n",
                            "|Mã chức vụ", "|Tên chức vụ","|");
                    System.out.println("-----------------------------------------");
                    arrChucVu.xuatDanhSach();
                    System.out.println("-----------------------------------------");
                    System.out.print("MỜI CHỌN MÃ CHỨC VỤ: ");
                    maCV = scan.nextLine();
                    System.out.println("-----=== DANH SÁCH " + arrChucVu.getById(maCV).getTenCV().toUpperCase() + " ===-----");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s\n",
                            "|Mã nhân sự","|Họ tên","|Giới tính","|Phòng ban","|Chức vụ","|Tên dự án", "|Tên tài khoản","|");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    arrNhanSu.xuatDanhSachByMaCV(maCV);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");                    
                    break;
                case 9:
                    readDataFromFile();
                    break;
                default:
                    break;
            }
                    
        } while(luaChon != 10);
    }
    
    public static void loginAsStaff(TaiKhoan tk) {
        int luaChon, n = 0;
        do {
            luaChon = menuForStaff(scan);
                    
            switch(luaChon) {
                case 1:
                    System.out.println("------------------------------------===== THÔNG TIN CÁ NHÂN =====----------------------------------------------");
                    System.out.println("_______________________________________________________________________________________________________________");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s\n","|Mã nhân sự","|Họ tên","|Giới tính","|Phòng ban","|Chức vụ","|Tên dự án", "|Tên tài khoản","|");
                    arrNhanSu.getById(tk.getMaNS()).xuatThongTinCaNhan();
                    System.out.println("---------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("-----=== CHI TIẾT BẢNG LƯƠNG ===-----");
                    arrNhanSu.getById(tk.getMaNS()).xuatBangLuongChiTiet();
                    break;
                case 3:
                    NhanSu[] listTheoPB = arrNhanSu.getListByPB(arrPhongBan.getById(arrNhanSu.getById(tk.getMaNS()).getMaPB()).getTenPB());
                    
                    System.out.println("-----------------------------===== DANH SÁCH NHÂN SỰ " + 
                            arrPhongBan.getById(arrNhanSu.getById(tk.getMaNS()).getMaPB()).getTenPB().toUpperCase() + 
                            " =====-----------------------------");
                    System.out.println("_____________________________________________________________________________________________________");
                    System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s\n","|Mã nhân sự","|Họ tên","|Giới tính","|Phòng ban","|Chức vụ","|Tên dự án", "|Tên tài khoản","|");
                    for(NhanSu ns : listTheoPB) {
                        ns.xuatThongTinCaNhan();
                    }
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("-----=== CHI TIẾT DỰ ÁN ===-----");
                    arrDuAn.getById(arrNhanSu.getById(tk.getMaNS()).getMaDA()).xuat();
                    break;
                default:
                    break;
            }
                    
        } while(luaChon != 5);
    }
    
    public static int menuForAdmin(Scanner scan) {
        int luaChon;
        
        System.out.println( "---------------=== ADMIN MENU ===-----------------");
        System.out.println( "|1.Xuất danh sách nhân sự                        |\n" +
                            "|2.Tính lương nhân sự                            |\n" +
                            "|3.Thêm mới nhân sự                              |\n" +
                            "|4.Cập nhật nhân sự theo mã                      |\n" +
                            "|5.Xóa nhân sự theo mã                           |\n" +
                            "|6.Xem danh sách nhân sự theo tên                |\n" +
                            "|7.Xem danh sách nhân sự theo phòng ban          |\n" +
                            "|8.Xem danh sách nhân sự theo chức vụ            |\n" +                            
                            "|9.Đọc dữ liệu từ file                           |\n" +
                            "|10.Kết thúc chương trình                        |\n" +
                            "--------------------------------------------------");
        System.out.print("MỜI NHẬP LỰA CHỌN: ");
        luaChon = Integer.parseInt(scan.nextLine());
        
        return luaChon;
    }
    
    public static int menuForStaff(Scanner scan) {
        int luaChon;
        
        System.out.println( "--------------=== STAFF MENU ===----------------");
        System.out.println( "|1.Xem thông tin cá nhân                       |\n" + 
                            "|2.Xem chi tiết bảng lương tháng này           |\n" +
                            "|3.Xem danh sách nhân sự theo phòng ban của bạn|\n" + 
                            "|4.Xem chi tiết dự án của bạn                  |\n" +
                            "|5.Kết thúc chương trình                       |\n" +
                            "------------------------------------------------");
        System.out.print("MỜI NHẬP LỰA CHỌN: ");
        luaChon = Integer.parseInt(scan.nextLine());
        
        return luaChon;
    }
    
    public static void readDataFromFile() {
        int luaChon, n = 0;
        
        do {
            luaChon = menuOfFile(scan);
            
            switch(luaChon) {
                case 1:
                    arrNhanSu.readListFromFile();
                    break;
                case 2:
                    arrChucVu.readListFromFile();
                    break;
                case 3:
                    arrDuAn.readListFromFile();
                    break;
                case 4:
                    arrPhongBan.readListFromFile();
                    break;
                case 5:
                    arrTaiKhoan.readListFromFile();
                    break;
                default:
                    break;
            }
        } while(luaChon != 6);
    }
    
    public static int menuOfFile(Scanner scan) {
        int luaChon;
        
        System.out.println( "--------------=== FILE MENU ===-----------------");
        System.out.println( "|1.Xem file dữ liệu nhân sự                    |\n" + 
                            "|2.Xem file dữ liệu chức vụ                    |\n" +
                            "|3.Xem file dữ liệu dự án                      |\n" + 
                            "|4.Xem file dữ liệu phòng ban                  |\n" +
                            "|5.Xem file dữ liệu tài khoản                  |\n" +    
                            "|6.Thoát menu                                  |\n" +
                            "------------------------------------------------");
        System.out.print("MỜI NHẬP LỰA CHỌN: ");
        luaChon = Integer.parseInt(scan.nextLine());
        System.out.println("");
        
        return luaChon;
    }
    
    public static TaiKhoan kiemTraDangNhap(String taiKhoan, String matKhau) {
        for(TaiKhoan tk : arrTaiKhoan.getDsTaiKhoan()) {
            if(tk.getTaiKhoan().equals(taiKhoan) && tk.getMatKhau().equals(matKhau))
                return tk;
        }
        
        return null;
    }
    
}
