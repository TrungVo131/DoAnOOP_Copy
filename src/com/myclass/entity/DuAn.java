package com.myclass.entity;

import java.io.Serializable;

public class DuAn implements Serializable {
    private String maDA;
    private String tenDA;
    private String ngayBatDau;
    private String ngayKetThuc;

    public DuAn() {}

    public DuAn(String maDA, String tenDA, String ngayBatDau, String ngayKetThuc) {
        this.maDA = maDA;
        this.tenDA = tenDA;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public void xuat() {
        System.out.println("---------------------------------------");
        System.out.println("|Mã dự án       | " + " " + this.maDA + "        |");
        System.out.println("|Tên            | " + " " + this.tenDA + "      |");
        System.out.println("|Ngày bắt đầu   | " + " " + this.ngayBatDau + "   |");
        System.out.println("|Ngày kết thúc  | " + " " + this.ngayKetThuc + "   |");
        System.out.println("---------------------------------------");
    }
    
    public void xuatThongTinDuAn() {
        System.out.printf("%-15s%-15s%-15s%-15s%s", 
                "|" + this.maDA,
                "|" + this.tenDA,
                "|" + this.ngayBatDau,
                "|" + this.ngayKetThuc,
                "|\n");
    }
    @Override
    public String toString() {
        return "DuAn{" + "maDA=" + maDA + ", tenDA=" + tenDA + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "}\n";
    }

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
    }

    public String getTenDA() {
        return tenDA;
    }

    public void setTenDA(String tenDA) {
        this.tenDA = tenDA;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
}
