package com.myclass.array;

import com.myclass.entity.GiamDoc;
import com.myclass.entity.NhanSu;
import com.myclass.entity.NhanVien;
import com.myclass.entity.TruongPhong;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrNhanSu {
    Scanner scan = new Scanner(System.in);
    private NhanSu[] dsNhanSu;
    private int arrLen;
    
    public void taoDanhSach() {
        System.out.println("Nhập n:");
        arrLen = Integer.parseInt(scan.nextLine());
        dsNhanSu = new NhanSu[arrLen];
        
        for(int i = 0; i < arrLen; i++) {
            NhanSu nhanSu = null;
            int chon;
            System.out.println("Nhập thông tin nhân sự thứ " + (i + 1) + ":");
            nhanSu = chonViTri(nhanSu);
            nhanSu.nhap(scan);
            dsNhanSu[i] = nhanSu;
        }
    }
    
    public NhanSu chonViTri(NhanSu nhanSu) {
        int chon;
        
        System.out.println("Nhập vị trí nhân sự:");
        System.out.println( "1.Nhân viên\n" +
                            "2.Trưởng phòng\n" +
                            "3.Giám đốc");
        chon = Integer.parseInt(scan.nextLine());
        
        switch(chon) {
            case 1:
                nhanSu = new NhanVien();
                nhanSu.setMaCV("Staff");
                break;
            case 2:
                nhanSu = new TruongPhong();
                nhanSu.setMaCV("Manager");
                break;
            case 3:
                nhanSu = new GiamDoc();
                nhanSu.setMaCV("Director");
                break;
            default:
                break;
            }
        return nhanSu;
    }
    
    public void xuatDanhSach() {
        for(int i = 0; i < arrLen; i++) {
            System.out.println("Thông tin nhân sự thứ " + (i + 1) + ":");
            dsNhanSu[i].xuat();
        }
    }
    
    public void themMoi() {
        NhanSu newNhanSu = null;
        
        System.out.println("Nhập thông tin nhân sự mới:");
        newNhanSu = chonViTri(newNhanSu);
        newNhanSu.nhap(scan);
        
        dsNhanSu = Arrays.copyOf(dsNhanSu, arrLen + 1);
        dsNhanSu[arrLen] = newNhanSu;
        arrLen++;
    }
    
    public void capNhatTheoId(String id) {
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getMaNV().equals(id)) {
                System.out.println("Cập nhật thông tin nhân sự:");
                dsNhanSu[i].nhap(scan);
                break;
            }
        }
    }
    
    public void xoaTheoId(String id) {
        NhanSu[] newDsNhanSu = Arrays.copyOf(dsNhanSu, arrLen - 1);
        int k = 0;
        
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getMaNV().equals(id))
                continue;
            newDsNhanSu[k] = dsNhanSu[i];
            k++;
            dsNhanSu = newDsNhanSu;
        }
        arrLen--;
    }
    
    public void ghiObjectVaoFile(NhanSu ns) {
        try {
            FileOutputStream fos = new FileOutputStream("dsNhanSu.text");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(ns);
            
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrNhanSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArrNhanSu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void docFile() {
        try {
            FileInputStream fis = new FileInputStream("dsNhanSu.text");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            NhanSu[] arr = new NhanSu[dsNhanSu.length];
            
            for(int i = 0; i < arr.length; i++) {
                arr[i] = (NhanSu) ois.readObject();
            }
            
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrNhanSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArrNhanSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArrNhanSu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
