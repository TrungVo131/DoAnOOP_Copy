package com.myclass.array;

import com.myclass.entity.PhongBan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

public class ArrPhongBan implements Serializable {
    private final PhongBan[] dsPhongBan;
    
    public ArrPhongBan() {
        dsPhongBan = new PhongBan[5];
        dsPhongBan[0] = new PhongBan("NS", "Phòng nhân sự");
        dsPhongBan[1] = new PhongBan("IT", "Phòng kỹ thuật");
        dsPhongBan[2] = new PhongBan("KT", "Phòng kế toán");
        dsPhongBan[3] = new PhongBan("TT", "Phòng thị trường");
        dsPhongBan[4] = new PhongBan("KD", "Phòng kinh doanh");
        
        writeListIntoFile(dsPhongBan);
    }

    public void xuatDanhSach() {
        for (PhongBan pb : dsPhongBan) {
            pb.xuatThongTinPhongBan();
        }
    }
    
    public PhongBan getById(String id) {
        for(PhongBan pb : dsPhongBan) {
            if(pb.getMaPB().equalsIgnoreCase(id))
                return pb;
        }
        
        return null;
    }
    
    public String chonPhongBan(Scanner scan) {
        int luaChon;
        String maPB = null;
        
        xuatDanhSach();
        System.out.print("MỜI CHỌN PHÒNG BAN BẰNG CÁCH NHẬP MÃ: ");
        maPB = scan.nextLine();
        
        return maPB;
    }
        
    private void writeListIntoFile(PhongBan[] dsPhongBan) {
        File file = new File("ListPhongBan.txt");
        Vector<PhongBan> listPhongBan = new Vector<>();
          
        for(PhongBan pb : dsPhongBan) {
            listPhongBan.add(pb);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listPhongBan);
            
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        
    public void readListFromFile() {
        File file = new File("ListPhongBan.txt");
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                
            Vector<PhongBan> listPhongBan = (Vector<PhongBan>) ois.readObject();
            System.out.println(listPhongBan);
            
            ois.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
        
    public PhongBan[] getDsPhongBan() {
        return dsPhongBan;
    }
    
}
