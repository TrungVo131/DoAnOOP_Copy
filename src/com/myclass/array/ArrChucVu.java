package com.myclass.array;

import com.myclass.entity.ChucVu;

public class ArrChucVu {
    private final ChucVu[] dsChucVu;
    
    public ArrChucVu() {
        dsChucVu = new ChucVu[3];
        
        dsChucVu[0] = new ChucVu("Staff", "Nhân viên");
        dsChucVu[1] = new ChucVu("Manager", "Trưởng phòng");
        dsChucVu[2] = new ChucVu("Director", "Giám đốc");
    }

    public ChucVu[] getDsChucVu() {
        return dsChucVu;
    }
    
}
