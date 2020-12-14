package com.myclass.entity;

import com.myclass.array.ArrChucVu;
import com.myclass.array.ArrDuAn;
import com.myclass.array.ArrPhongBan;
import com.myclass.array.ArrTaiKhoan;
import java.io.Serializable;
import java.util.Scanner;

public abstract class NhanSu implements NhanSuImpl, Serializable {
    protected String maNS;
    protected String hoLot;
    protected String ten;
    protected String gioiTinh;
    protected String maPB;
    protected String maCV;
    protected String maDA;
    protected int soNgayLamTrongThang;
    protected double luongCoBan;

    private final ArrPhongBan arrPhongBan;
    private final ArrTaiKhoan arrTaiKhoan;
    private final ArrChucVu arrChucVu;
    private final ArrDuAn arrDuAn;

    public NhanSu() {
        arrPhongBan = new ArrPhongBan();
        arrTaiKhoan = new ArrTaiKhoan();
        arrChucVu = new ArrChucVu();
        arrDuAn = new ArrDuAn();
    }
    
    @Override
    public void nhap(Scanner scan) {
        int chon;
        System.out.print("Nhập mã nhân viên: ");
        this.maNS = scan.nextLine();
        System.out.print("Nhập họ và tên lót: ");
        this.hoLot = scan.nextLine();
        System.out.print("Nhập tên: ");
        this.ten = scan.nextLine();
        System.out.print("Giới tính: ");
        this.gioiTinh = scan.nextLine();
        System.out.println(" ---== DANH SÁCH PHÒNG BAN ==---");
        this.maPB = arrPhongBan.chonPhongBan(scan);
        System.out.println(" ---== TẠO TÀI KHOẢN HỆ THỐNG ==---");
        arrTaiKhoan.add(scan, this.maNS, this.maCV);
        System.out.println("-------------------=== DANH SÁCH DỰ ÁN ===-------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%s\n",
        "|Mã dự án","|Tên dự án","|Ngày bắt đầu","|Ngày kết thúc","|");
        System.out.println("-------------------------------------------------------------");
        this.maDA = arrDuAn.chonDuAn(scan);
    }
    
    @Override
    public void nhapLuong(Scanner scan) {
        System.out.print("Nhập số ngày làm trong tháng: ");
        this.soNgayLamTrongThang = Integer.parseInt(scan.nextLine());
        System.out.print("Nhập lương cơ bản: ");
        this.luongCoBan = Double.parseDouble(scan.nextLine());
    }
    
    @Override
    public void xuatThongTinCaNhan() {
        System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-20s%s", 
                "|" + this.maNS,
                "|" + this.hoLot + " " + this.ten,
                "|" + this.gioiTinh,
                "|" + arrPhongBan.getById(this.maPB).getTenPB(),
                "|" + arrChucVu.getById(this.maCV).getTenCV(),
                "|" + arrDuAn.getById(this.maDA).getTenDA(),
                "|" + arrTaiKhoan.getById(this.maNS).getTaiKhoan(),
                "|\n");
    }
    
    @Override
    public void xuatBangLuongChiTiet() {
        System.out.println("---------------------------------------");
        System.out.println("|Số ngày làm trong tháng | " + " " + this.soNgayLamTrongThang + "        |");
        System.out.println("|Lương cơ bản            | " + " " + this.luongCoBan + "     |");
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }
    
    public String getMaNV() {
        return maNS;
    }

    public void setMaNV(String maNV) {
        this.maNS = maNV;
    }

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
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
    
    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public int getSoNgayLamTrongThang() {
        return soNgayLamTrongThang;
    }

    public void setSoNgayLamTrongThang(int soNgayLamTrongThang) {
        this.soNgayLamTrongThang = soNgayLamTrongThang;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    
}
