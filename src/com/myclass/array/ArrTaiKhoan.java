package com.myclass.array;

import com.myclass.entity.TaiKhoan;
import java.util.Arrays;
import java.util.Scanner;

public class ArrTaiKhoan {
    private TaiKhoan[] dsTaiKhoan;
    private int arrLen;
    
    public ArrTaiKhoan() {
        arrLen = 1;
        dsTaiKhoan = new TaiKhoan[arrLen];
        // tao mot tai khoan admin
        TaiKhoan tk = new TaiKhoan();
        tk.setMaNV("admin");
        tk.setTaiKhoan("admin@gmail.com");
        tk.setMatKhau("123456");
        tk.setQuyen("Director");
        dsTaiKhoan[0] = tk;
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
