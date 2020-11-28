package com.myclass.entity;

public class TaiKhoan {
    private String taiKhoan;
    private String matKhau;
    private String quyen;   
    private String maNV;
    
    public TaiKhoan() {}
    
    public TaiKhoan(String taiKhoan, String matKhau, String quyen, String maNV) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.quyen = quyen;
        this.maNV = maNV;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}