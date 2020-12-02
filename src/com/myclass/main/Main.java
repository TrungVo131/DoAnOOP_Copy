package com.myclass.main;

import com.myclass.array.ArrNhanSu;
import com.myclass.array.ArrTaiKhoan;
import com.myclass.entity.TaiKhoan;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrNhanSu arrNhanSu = new ArrNhanSu();
        ArrTaiKhoan arrTaiKhoan = new ArrTaiKhoan();
        String taiKhoan, matKhau;

        System.out.println("ĐĂNG NHẬP HỆ THỐNG");
        System.out.print("Tài khoản: ");
        taiKhoan = scan.nextLine();
        System.out.print("Mật khẩu: ");
        matKhau = scan.nextLine();
        
        TaiKhoan taiKhoanDangNhap = kiemTraDangNhap(arrTaiKhoan, taiKhoan, matKhau);
        
        if(taiKhoanDangNhap != null) {
            System.out.println("ĐĂNG NHẬP THÀNH CÔNG");
            loginSuccess(scan, arrNhanSu, taiKhoanDangNhap.getQuyen());
        }
        else {
            System.out.println("SAI TÊN ĐĂNG NHẬP HOẶC MẬT KHẨU");
        }
        
    }
    
    public static void loginSuccess(Scanner scan, ArrNhanSu arrNhanSu, String quyenHeThong) {
        int luaChon, n = 0;
        do {
            luaChon = menu(scan);
                    
            switch(luaChon) {
                case 1:
                    arrNhanSu.taoDanhSach();
                    break;
                case 2:
                    System.out.println("-----===DANH SÁCH NHÂN SỰ===-----");
                    arrNhanSu.xuatDanhSach();
                    break;
                case 3:
                    arrNhanSu.themMoi();
                    break;
                case 4:
                    System.out.println("Nhập mã của nhân sự cần cập nhật:");
                    String updateId = scan.nextLine();
                    arrNhanSu.capNhatTheoId(updateId);
                    break;
                case 5:
                    System.out.println("Nhập mã của nhân sự cần xóa:");
                    String delId = scan.nextLine();
                    arrNhanSu.xoaTheoId(delId);
                    break;
                default:
                    break;
            }
                    
        } while(luaChon != 8);
    }
    
    public static int menu(Scanner scan) {
        int luaChon;
        
        System.out.println("Menu:");
        System.out.println( "1.Tạo n nhân sự mới đầu tiên\n" +
                            "2.Xuất danh sách nhân sự\n" +
                            "3.Thêm mới nhân sự\n" +
                            "4.Cập nhật nhân sự theo mã\n" +
                            "5.Xóa nhân sự theo mã\n" +
                            "6.Tìm kiếm nhiều khóa từ chính xác đến gần đúng\n" +
                            "7.Thống kê số liệu theo nhiều khóa\n" +
                            "8.Thoát");
        System.out.println("Mời nhập lựa chọn:");
        luaChon = Integer.parseInt(scan.nextLine());
                
        return luaChon;
    }
    
    public static TaiKhoan kiemTraDangNhap(ArrTaiKhoan arrTaiKhoan, String taiKhoan, String matKhau) {
        for(TaiKhoan tk : arrTaiKhoan.getDsTaiKhoan()) {
            if(tk.getTaiKhoan().equals(taiKhoan) || tk.getMatKhau().equals(matKhau))
                return tk;
        }
        
        return null;
    }
    
}
