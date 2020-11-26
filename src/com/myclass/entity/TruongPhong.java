package com.myclass.entity;

import java.util.Scanner;

public class TruongPhong extends NhanSu {
    private double luongCoBan;
    
    public TruongPhong() {
        this.luongCoBan = 200;
    }
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Lương cơ bản của trưởng phòng: " + this.luongCoBan);
    }
}
