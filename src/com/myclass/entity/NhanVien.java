package com.myclass.entity;

import java.util.Scanner;

public class NhanVien extends NhanSu {
    private double luongCoBan;
    
    public NhanVien() {
        this.luongCoBan = 100;
    }
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Lương cơ bản của nhân viên: " + this.luongCoBan);
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
}
