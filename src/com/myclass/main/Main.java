package com.myclass.main;

import com.myclass.array.ArrNhanSu;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrNhanSu arrNhanSu = new ArrNhanSu();
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
}
