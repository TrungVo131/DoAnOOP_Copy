package com.myclass.entity;

import java.io.Serializable;

public class PhongBan implements Serializable {
    private String maPB;
    private String tenPB;

    public PhongBan() {
    }

    public PhongBan(String maPB, String tenPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
    }
    
    public void xuatThongTinPhongBan() {
        System.out.printf("%-15s%-25s%s", 
                "|" + this.maPB,
                "|" + this.tenPB,
                "|\n");
    }

    @Override
    public String toString() {
        return "PhongBan{" + "maPB=" + maPB + ", tenPB=" + tenPB + "}\n";
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

}
