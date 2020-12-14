package com.myclass.entity;

import java.io.Serializable;

public class ChucVu implements Serializable {
    private String maCV;
    private String tenCV;
    
    public ChucVu() {}
    
    public ChucVu(String maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public void xuatThongTinChucVu() {
        System.out.printf("%-15s%-25s%s", 
                "|" + this.maCV,
                "|" + this.tenCV,
                "|\n");
    }

    @Override
    public String toString() {
        return "ChucVu{" + "maCV=" + maCV + ", tenCV=" + tenCV + "}\n";
    }
    
    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
}
