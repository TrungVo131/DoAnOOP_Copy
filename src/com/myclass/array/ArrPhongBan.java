package com.myclass.array;

import com.myclass.entity.PhongBan;

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
    
}
