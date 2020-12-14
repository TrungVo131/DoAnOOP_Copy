package com.myclass.entity;

import java.io.Serializable;
import java.util.Scanner;

public class TruongPhong extends NhanSu implements Serializable {
    private double phuCap;
    
    public TruongPhong() {
    
    }
    
    public TruongPhong(String maNS, String hoLot, String ten, String gioiTinh, String maPB, String maCV, String maDA, int soNgayLamTrongThang, double luongCoBan, double phuCap) {
        this.maNS = maNS;
        this.hoLot = hoLot;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.maPB = maPB;
        this.maCV = maCV;
        this.maDA = maDA;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
    }
    
    @Override
    public void nhapLuong(Scanner scan) {
        super.nhap(scan);
        System.out.print("Nhập phụ cấp trưởng phòng: ");
        this.phuCap = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public void xuatBangLuongChiTiet() {
        super.xuatBangLuongChiTiet();
        System.out.println("Phụ cấp trưởng phòng: " + this.phuCap);
        System.out.println("Lương tháng này: " + this.tinhLuong());
    }

    @Override
    public double tinhLuong() {
        return getSoNgayLamTrongThang() * getLuongCoBan() + this.phuCap;
    }

    @Override
    public String toString() {
        return "TruongPhong{" + "maNS=" + maNS + ", hoLot=" + hoLot + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", maPB=" + maPB + ", maCV=" + maCV + ", maDA=" + maDA + ", soNgayLamTrongThang=" + soNgayLamTrongThang + ", luongCoBan=" + luongCoBan + ", phuCap=" + phuCap + "}\n";
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
    
}
