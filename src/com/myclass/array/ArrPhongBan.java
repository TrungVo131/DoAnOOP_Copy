package com.myclass.array;

import com.myclass.entity.PhongBan;
import java.util.Scanner;

public class ArrPhongBan {
    private final PhongBan[] dsPhongBan;
    
    public ArrPhongBan() {
        dsPhongBan = new PhongBan[5];
        dsPhongBan[0] = new PhongBan("NS", "Phòng nhân sự");
        dsPhongBan[1] = new PhongBan("IT", "Phòng kỹ thuật");
        dsPhongBan[2] = new PhongBan("KT", "Phòng kế toán tài chính");
        dsPhongBan[3] = new PhongBan("TT", "Phòng thị trường");
        dsPhongBan[4] = new PhongBan("KD", "Phòng kinh doanh");
    }

    public PhongBan[] getDsPhongBan() {
        return dsPhongBan;
    }
    
    public void xuatDsPhongBan() {
        for(int i = 0; i < dsPhongBan.length; i++) {
            System.out.println((i + 1) + "." + dsPhongBan[i].getTenPB());
        }
    }
    
    public PhongBan getById(String id) {
        for(PhongBan pb : dsPhongBan) {
            if(pb.getMaPB().equals(id))
                return pb;
        }
        
        return null;
    }
    
        public String chonPhongBan(Scanner scan) {
        int luaChon;
        String maPB = null;
        
        xuatDsPhongBan();
        System.out.println("Mời chọn phòng ban:");
        luaChon = Integer.parseInt(scan.nextLine());
        
        switch(luaChon) {
            case 1:
                maPB = dsPhongBan[0].getMaPB();
                break;
            case 2:
                maPB = dsPhongBan[1].getMaPB();;
                break;
            case 3:
                maPB = dsPhongBan[2].getMaPB();;
                break;
            case 4:
                maPB = dsPhongBan[3].getMaPB();;
                break;
            case 5:
                maPB = dsPhongBan[4].getMaPB();;
                break;
            default:
                break;
        }
        
        return maPB;
    }
}
