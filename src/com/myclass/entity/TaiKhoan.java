package com.myclass.entity;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String taiKhoan;
    private String matKhau;
    private String quyen;   
    private String maNS;
    
    public TaiKhoan() {}
    
    public TaiKhoan(String taiKhoan, String matKhau, String quyen, String maNV) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.quyen = quyen;
        this.maNS = maNV;
    }
    
    public void xuat() {
        System.out.println("Tên tài khoản: " + this.taiKhoan);
        System.out.println("Mật khẩu: " + this.matKhau);
        System.out.println("Quyền tài khoản: " + this.quyen);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", quyen=" + quyen + ", maNV=" + maNS + "}\n";
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getMaNS() {
        return maNS;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }
    
}