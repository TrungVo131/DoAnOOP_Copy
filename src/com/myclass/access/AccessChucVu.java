package com.myclass.access;

import com.myclass.array.ArrChucVu;
import com.myclass.entity.ChucVu;

public class AccessChucVu {
    private final ArrChucVu arrChucVu;
    private final ChucVu[] dsChucVu;
    
    public AccessChucVu() {
        arrChucVu = new ArrChucVu();
        dsChucVu = arrChucVu.getDsChucVu();
    }
    
    public String getTenCVTheoId(String id) {
        for(ChucVu chucVu : dsChucVu) {
            if(chucVu.getMaCV().equals(id)) {
                return chucVu.getTenCV();
            }
        }
        
        return null;
    }
}
