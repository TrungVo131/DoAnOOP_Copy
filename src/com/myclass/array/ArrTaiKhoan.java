package com.myclass.array;

import com.myclass.entity.TaiKhoan;
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

public class ArrTaiKhoan implements Serializable {
    private TaiKhoan[] dsTaiKhoan;
    private int arrLen;
    
    public ArrTaiKhoan() {
        arrLen = 15;
        dsTaiKhoan = new TaiKhoan[arrLen];
        // tao san mot so tai khoan
        dsTaiKhoan[0] = new TaiKhoan("director1@gmail.com", "123456", "Director", "giamdoc1");
        dsTaiKhoan[1] = new TaiKhoan("manager1@gmail.com", "123456", "Manager", "truongphong1");
        dsTaiKhoan[2] = new TaiKhoan("staff1@gmail.com", "123456", "Staff", "nhanvien1");
        
        dsTaiKhoan[3] = new TaiKhoan("director2@gmail.com", "123456", "Director", "giamdoc2");
        dsTaiKhoan[4] = new TaiKhoan("manager2@gmail.com", "123456", "Manager", "truongphong2");
        dsTaiKhoan[5] = new TaiKhoan("staff2@gmail.com", "123456", "Staff", "nhanvien2");
        
        dsTaiKhoan[6] = new TaiKhoan("director3@gmail.com", "123456", "Director", "giamdoc3");
        dsTaiKhoan[7] = new TaiKhoan("manager3@gmail.com", "123456", "Manager", "truongphong3");
        dsTaiKhoan[8] = new TaiKhoan("staff3@gmail.com", "123456", "Staff", "nhanvien3");
        
        dsTaiKhoan[9] = new TaiKhoan("director4@gmail.com", "123456", "Director", "giamdoc4");
        dsTaiKhoan[10] = new TaiKhoan("manager4@gmail.com", "123456", "Manager", "truongphong4");
        dsTaiKhoan[11] = new TaiKhoan("staff4@gmail.com", "123456", "Staff", "nhanvien4");
        
        dsTaiKhoan[12] = new TaiKhoan("director5@gmail.com", "123456", "Director", "giamdoc5");
        dsTaiKhoan[13] = new TaiKhoan("manager5@gmail.com", "123456", "Manager", "truongphong5");
        dsTaiKhoan[14] = new TaiKhoan("staff5@gmail.com", "123456", "Staff", "nhanvien5");
        
        writeListIntoFile(dsTaiKhoan);
    }
    
    public void add(Scanner scan, String maNV, String maCV) {
        TaiKhoan newTaiKhoan = new TaiKhoan();
        
        System.out.print("Nhập tên tài khoản: ");
        newTaiKhoan.setTaiKhoan(scan.nextLine());
        System.out.print("Nhập mật khẩu: ");
        newTaiKhoan.setMatKhau(scan.nextLine());
        newTaiKhoan.setMaNS(maNV);
        newTaiKhoan.setQuyen(maCV);
        
        dsTaiKhoan = Arrays.copyOf(dsTaiKhoan, arrLen + 1);
        dsTaiKhoan[arrLen] = newTaiKhoan;
        arrLen++;
        
        writeListIntoFile(dsTaiKhoan);
    }
    
    private void writeListIntoFile(TaiKhoan[] dsTaiKhoan) {
        File file = new File("ListTaiKhoan.txt");
        Vector<TaiKhoan> listTaiKhoan = new Vector<>();
          
        for(TaiKhoan tk : dsTaiKhoan) {
            listTaiKhoan.add(tk);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listTaiKhoan);
            
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        
    public void readListFromFile() {
        File file = new File("ListTaiKhoan.txt");
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                
            Vector<TaiKhoan> listTaiKhoan = (Vector<TaiKhoan>) ois.readObject();
            System.out.println(listTaiKhoan);
            
            ois.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public TaiKhoan[] getDsTaiKhoan() {
        return dsTaiKhoan;
    }
    
    public TaiKhoan getById(String id) {
        for(TaiKhoan tk : dsTaiKhoan) {
            if(tk.getMaNS().equals(id))
                return tk;
        }
        
        return null;
    }   
}
