package com.myclass.entity;

import java.util.Scanner;

public class TruongPhong extends NhanSu {
    private double phuCap;
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
        System.out.println("Nhập phụ cấp trưởng phòng:");
        this.phuCap = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Phụ cấp trưởng phòng: " + this.phuCap);
        System.out.println("Lương tháng này: " + this.tinhLuong());
    }
    
    public double tinhLuong() {
        return this.getSoNgayLamTrongThang() * this.getLuongCoBan() + this.phuCap;
    }
}
