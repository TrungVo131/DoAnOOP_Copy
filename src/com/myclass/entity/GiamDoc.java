package com.myclass.entity;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
    private double luongCoBan;
    
    public GiamDoc() {
        luongCoBan = 300;
    }
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Lương cơ bản của giám đốc: " + this.luongCoBan);
    }
}
