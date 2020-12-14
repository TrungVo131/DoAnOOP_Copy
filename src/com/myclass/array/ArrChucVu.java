package com.myclass.array;

import com.myclass.entity.ChucVu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class ArrChucVu implements Serializable {
    private final ChucVu[] dsChucVu;
    
    public ArrChucVu() {
        dsChucVu = new ChucVu[3];
        
        dsChucVu[0] = new ChucVu("Director", "Giám đốc");
        dsChucVu[1] = new ChucVu("Manager", "Trưởng phòng");
        dsChucVu[2] = new ChucVu("Staff", "Nhân viên");
        
        writeListIntoFile(dsChucVu);
    }

    public void xuatDanhSach() {
        for (ChucVu cv : dsChucVu) {
            cv.xuatThongTinChucVu();
        }
    }

    private void writeListIntoFile(ChucVu[] dsChucVu) {
        File file = new File("ListChucVu.txt");
        Vector<ChucVu> listChucVu = new Vector<>();
          
        for(ChucVu cv : dsChucVu) {
            listChucVu.add(cv);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listChucVu);
            
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void readListFromFile() {
        File file = new File("ListChucVu.txt");
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                
            Vector<ChucVu> listChucVu = (Vector<ChucVu>) ois.readObject();
            System.out.println(listChucVu);
            
            ois.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
        
    public ChucVu[] getDsChucVu() {
        return dsChucVu;
    }
            
    public ChucVu getById(String maCV) {
        for(ChucVu cv : dsChucVu) {
            if(cv.getMaCV().equalsIgnoreCase(maCV))
                return cv;
        }
        
        return null;
    }
    
}
