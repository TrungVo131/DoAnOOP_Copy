package com.myclass.entity;

import java.util.Scanner;

public class GiamDoc extends NhanSu {
    private double coPhan;
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
        System.out.println("Nhập cổ phần giám đốc (đơn vị %): ");
        this.coPhan = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Cổ phần giám đốc: " + this.coPhan);
        System.out.println("Lương tháng này: " + this.tinhLuong());
    }
    
    public double tinhLuong() {
        return this.getLuongCoBan() * this.getSoNgayLamTrongThang() + (this.coPhan / 100 + this.getLuongCoBan() * this.getSoNgayLamTrongThang());
    }
}
