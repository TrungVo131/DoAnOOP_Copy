package com.myclass.entity;

import java.io.Serializable;
import java.util.Scanner;

public class GiamDoc extends NhanSu implements Serializable {
    private double coPhan;
    
    public GiamDoc() {
        
    }

    public GiamDoc(String maNS, String hoLot, String ten, String gioiTinh, String maPB, String maCV, String maDA, int soNgayLamTrongThang, double luongCoBan, double coPhan) {
        this.maNS = maNS;
        this.hoLot = hoLot;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.maPB = maPB;
        this.maCV = maCV;
        this.maDA = maDA;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.luongCoBan = luongCoBan;
        this.coPhan = coPhan;
    }
    
    @Override
    public void nhap(Scanner scan) {
        super.nhap(scan);
    }
    
    @Override
    public void nhapLuong(Scanner scan) {
        super.nhapLuong(scan);
        System.out.print("Nhập cố phần giám đốc (%): ");
        this.coPhan = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public void xuatBangLuongChiTiet() {
        super.xuatBangLuongChiTiet();
        System.out.println("Cổ phần giám đốc: " + this.coPhan);
        System.out.println("Lương tháng này: " + this.tinhLuong());
    }
    
    @Override 
    public double tinhLuong() {
        return getSoNgayLamTrongThang() * getLuongCoBan() + this.coPhan * getSoNgayLamTrongThang() * getLuongCoBan() / 100;
    }

    @Override
    public String toString() {
        return "GiamDoc{" + "maNS=" + maNS + ", hoLot=" + hoLot + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", maPB=" + maPB + ", maCV=" + maCV + ", maDA=" + maDA + ", soNgayLamTrongThang=" + soNgayLamTrongThang + ", luongCoBan=" + luongCoBan + ", coPhan=" + coPhan + "}\n";
    }

    public double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    } 
}
