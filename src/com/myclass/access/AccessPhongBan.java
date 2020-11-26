package com.myclass.access;

import com.myclass.array.ArrPhongBan;
import com.myclass.entity.PhongBan;
import java.util.Scanner;

public class AccessPhongBan {
    private final ArrPhongBan arrPhongBan;
    private final PhongBan[] dsPhongBan;
    
    public AccessPhongBan() {
        arrPhongBan = new ArrPhongBan();
        dsPhongBan = arrPhongBan.getDsPhongBan();
    }
    
    public String chonPhongBan(Scanner scan) {
        int luaChon;
        String maPB = null;
        
        arrPhongBan.xuatDsPhongBan();
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
    
    public String getTenPBTheoId(String id) {
        for(PhongBan phongBan : dsPhongBan) {
            if(phongBan.getMaPB().equals(id)) {
                return phongBan.getTenPB();
            }
        }
            
        return null;
    }
}
