package com.myclass.array;

import com.myclass.entity.TaiKhoan;
import java.util.Arrays;
import java.util.Scanner;

public class ArrTaiKhoan {
    private TaiKhoan[] dsTaiKhoan;
    private int arrLen;
    
    public ArrTaiKhoan() {
        arrLen = 3;
        dsTaiKhoan = new TaiKhoan[arrLen];
        // tao mot tai khoan admin
        TaiKhoan director = new TaiKhoan("director@gmail.com", "123456", "Director", "giamdoc");
        dsTaiKhoan[0] = director;
        TaiKhoan manager = new TaiKhoan("manager@gmail.com", "123456", "Manager", "truongphong");
        dsTaiKhoan[1] = manager;
        TaiKhoan staff = new TaiKhoan("staff@gmail.com", "123456", "Staff", "nhanvien");
        dsTaiKhoan[2] = staff;
    }
    
    public void themMoi(Scanner scan, String maNV, String maCV) {
        TaiKhoan newTaiKhoan = new TaiKhoan();
        
        System.out.println("Nhập tên tài khoản:");
        newTaiKhoan.setTaiKhoan(scan.nextLine());
        System.out.println("Nhập mật khẩu");
        newTaiKhoan.setMatKhau(scan.nextLine());
        newTaiKhoan.setMaNV(maNV);
        newTaiKhoan.setQuyen(maCV);
        
        dsTaiKhoan = Arrays.copyOf(dsTaiKhoan, arrLen + 1);
        dsTaiKhoan[arrLen] = newTaiKhoan;
        arrLen++;
    }

    public TaiKhoan[] getDsTaiKhoan() {
        return dsTaiKhoan;
    }
    
    public TaiKhoan getById(String id) {
        for(TaiKhoan tk : dsTaiKhoan) {
            System.out.println(tk.getTaiKhoan());
            if(tk.getMaNV().equals(id))
                return tk;
        }
        
        return null;
    }
    
    
}
