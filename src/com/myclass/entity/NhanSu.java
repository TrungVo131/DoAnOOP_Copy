package com.myclass.entity;

import com.myclass.array.ArrChucVu;
import com.myclass.array.ArrPhongBan;
import com.myclass.array.ArrTaiKhoan;
import java.util.Scanner;

public class NhanSu {
    private String maCV;
    private String maNV;
    private String hoLot;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String CMND;
    private String maPB;
    private String maCCTH;
    private String maNN;
    private String ngayVaoLam;
    private ArrPhongBan arrPhongBan;
    private ArrTaiKhoan arrTaiKhoan;
    private ArrChucVu arrChucVu;
    
//    abstract void tinhLuong();

    public NhanSu() {
        arrPhongBan = new ArrPhongBan();
        arrTaiKhoan = new ArrTaiKhoan();
        arrChucVu = new ArrChucVu();
    }

    public NhanSu(String maNV, String hoLot, String ten, String gioiTinh, String ngaySinh, String diaChi, String CMND, String maPB, String maCCTH, String maNN, String ngayVaoLam) {
        this.maNV = maNV;
        this.hoLot = hoLot;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.CMND = CMND;
        this.maPB = maPB;
        this.maCCTH = maCCTH;
        this.maNN = maNN;
        this.ngayVaoLam = ngayVaoLam;
    }
    
    public void nhap(Scanner scan) {
        int chon;
        System.out.println("Nhập mã nhân viên:");
        this.maNV = scan.nextLine();
        System.out.println("Nhập họ và tên lót:");
        this.hoLot = scan.nextLine();
        System.out.println("Nhập tên:");
        this.ten = scan.nextLine();
        System.out.println("Giới tính:");
        System.out.println( "1.Nam\n" +
                            "2.Nữ");
        chon = Integer.parseInt(scan.nextLine());
        switch(chon) {
            case 1:
                this.gioiTinh = "Nam";
                break;
            case 2:
                this.gioiTinh = "Nữ";
                break;
            default:
                break;
        }
        System.out.println("Nhập ngày tháng năm sinh:");
        this.ngaySinh = scan.nextLine();
        System.out.println("Nhập địa chỉ:");
        this.diaChi = scan.nextLine();
        System.out.println("Nhập số chứng minh nhân dân:");
        this.CMND = scan.nextLine();
        System.out.println("-----===DANH SÁCH PHÒNG BAN===-----");
        this.maPB = arrPhongBan.chonPhongBan(scan);
        System.out.println("Nhập mã chứng chỉ tin học:");
        this.maCCTH = scan.nextLine();
        System.out.println("Nhập mã ngoại ngữ:");
        this.maNN = scan.nextLine();
        System.out.println("Nhập ngày vào làm:");
        this.ngayVaoLam = scan.nextLine();
        System.out.println("Tạo tài khoản hệ thống:");
        arrTaiKhoan.themMoi(scan, this.maNV, this.maCV);
    }
    
    public void xuat() {
        System.out.println("Mã nhân viên: " + this.maNV);
        System.out.println("Họ tên: " + this.hoLot + " " + this.ten);
        System.out.println("Giới tính: " + this.gioiTinh);
        System.out.println("Ngày sinh: " + this.ngaySinh);
        System.out.println("Địa chỉ:" + this.diaChi);
        System.out.println("CMND: " + this.CMND);
        System.out.println("Phòng ban: " + arrPhongBan.getById(this.maPB).getTenPB());
        System.out.println("Chức vụ: " + arrChucVu.getById(this.maCV).getTenCV());
        System.out.println("Mã chứng chỉ tin học: " + this.maCCTH);
        System.out.println("Mã ngoại ngữ: " + this.maNN);
        System.out.println("Ngày vào làm: " + this.ngayVaoLam);
        System.out.println("Tài khoản hệ thống: " + arrTaiKhoan.getById(this.maNV).getTaiKhoan());
        System.out.println("Quyền tài khoản: " + arrTaiKhoan.getById(this.maNV).getQuyen());
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoLot() {
        return hoLot;
    }

    public void setHoLot(String hoLot) {
        this.hoLot = hoLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getMaCCTH() {
        return maCCTH;
    }

    public void setMaCCTH(String maCCTH) {
        this.maCCTH = maCCTH;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getMaNN() {
        return maNN;
    }

    public void setMaNN(String maNN) {
        this.maNN = maNN;
    }

}
