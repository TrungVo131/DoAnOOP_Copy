package com.myclass.array;

import com.myclass.entity.DuAn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ArrDuAn implements Serializable {
    private DuAn[] dsDuAn;
    private int arrLen;
    
    public ArrDuAn() {
        arrLen = 5;
        dsDuAn = new DuAn[arrLen];
        
        dsDuAn[0] = new DuAn("duan1", "Dự án 1", "01/10/2020", "01/11/2020");
        dsDuAn[1] = new DuAn("duan2", "Dự án 2", "01/10/2020", "01/11/2020");
        dsDuAn[2] = new DuAn("duan3", "Dự án 3", "01/10/2020", "01/11/2021");
        dsDuAn[3] = new DuAn("duan4", "Dự án 4", "01/10/2020", "01/11/2021");
        dsDuAn[4] = new DuAn("duan5", "Dự án 5", "01/10/2020", "01/11/2021");
        
        writeListIntoFile(dsDuAn);
    }

    public void xuatDanhSach() {
        for (DuAn da : dsDuAn) {
            da.xuatThongTinDuAn();
        }
    }
    public void add(Scanner scan, String maDA) {
        DuAn newDuAn = new DuAn();
        
        newDuAn.setMaDA(maDA);
        System.out.print("Nhập tên dự án: ");
        newDuAn.setTenDA(scan.nextLine());
        System.out.print("Nhập ngày bắt đầu dự án: ");
        newDuAn.setNgayBatDau(scan.nextLine());
        System.out.print("Nhập ngày kết thúc dự án: ");
        newDuAn.setNgayKetThuc(scan.nextLine());
        
        dsDuAn = Arrays.copyOf(dsDuAn, arrLen + 1);
        dsDuAn[arrLen] = newDuAn;
        arrLen++;
    }
    
    public String chonDuAn(Scanner scan) {
        int luaChon;
        String maDA = null;
        
        xuatDanhSach();
        System.out.print("MỜI PHÂN CÔNG DỰ ÁN BẰNG CÁCH NHẬP MÃ: ");
        maDA = scan.nextLine();
        
        return maDA;        
    }
     
    private void writeListIntoFile(DuAn[] dsDuAn) {
        File file = new File("ListDuAn.txt");
        Vector<DuAn> listDuAn = new Vector<>();
          
        for(DuAn da : dsDuAn) {
            listDuAn.add(da);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listDuAn);
            
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void readListFromFile() {
        File file = new File("ListDuAn.txt");
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                
            Vector<DuAn> listDuAn = (Vector<DuAn>) ois.readObject();
            System.out.println(listDuAn);
            
            ois.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public DuAn getById(String id) {
        for(DuAn da : dsDuAn) {
            if(da.getMaDA().equals(id))
                return da;
        }
        
        return null;
    }
    
    public DuAn[] getDsDuAn() {
        return dsDuAn;
    }

}
