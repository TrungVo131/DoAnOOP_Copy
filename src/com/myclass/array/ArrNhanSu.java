package com.myclass.array;

import com.myclass.entity.ChucVu;
import com.myclass.entity.DuAn;
import com.myclass.entity.GiamDoc;
import com.myclass.entity.NhanSu;
import com.myclass.entity.NhanVien;
import com.myclass.entity.PhongBan;
import com.myclass.entity.TruongPhong;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrNhanSu {
    Scanner scan = new Scanner(System.in);
    private NhanSu[] dsNhanSu;
    private final ArrPhongBan arrPhongBan;
    private final PhongBan[] dsPhongBan;
    private final ArrChucVu arrChucVu;
    private final ChucVu[] dsChucVu;
    private final ArrDuAn arrDuAn;
    private final DuAn[] dsDuAn;
    private int arrLen;
    
    public ArrNhanSu() {
        arrPhongBan = new ArrPhongBan();
        dsPhongBan = arrPhongBan.getDsPhongBan();
        arrChucVu = new ArrChucVu();
        dsChucVu = arrChucVu.getDsChucVu();
        arrDuAn = new ArrDuAn();
        dsDuAn = arrDuAn.getDsDuAn();
                
        arrLen = 15;
        dsNhanSu = new NhanSu[arrLen];
        
        dsNhanSu[0] = new GiamDoc("giamdoc1", "Nguyen Van", "A", "Nam", dsPhongBan[0].getMaPB(), dsChucVu[0].getMaCV(), dsDuAn[0].getMaDA(), 30, 500, 20);
        dsNhanSu[1] = new TruongPhong("truongphong1", "Nguyen Van", "B", "Nam", dsPhongBan[0].getMaPB(), dsChucVu[1].getMaCV(), dsDuAn[0].getMaDA(), 30, 200, 200);
        dsNhanSu[2] = new NhanVien("nhanvien1", "Nguyen Van", "C", "Nữ", dsPhongBan[0].getMaPB(), dsChucVu[2].getMaCV(), dsDuAn[0].getMaDA(), 30, 100, 100);
        
        dsNhanSu[3] = new GiamDoc("giamdoc2", "Tran Van", "A", "Nam", dsPhongBan[1].getMaPB(), dsChucVu[0].getMaCV(), dsDuAn[1].getMaDA(), 30, 500, 20);
        dsNhanSu[4] = new TruongPhong("truongphong2", "Tran Van", "B", "Nam", dsPhongBan[1].getMaPB(), dsChucVu[1].getMaCV(), dsDuAn[1].getMaDA(), 30, 200, 200);
        dsNhanSu[5] = new NhanVien("nhanvien2", "Tran Van", "C", "Nữ", dsPhongBan[1].getMaPB(), dsChucVu[2].getMaCV(), dsDuAn[1].getMaDA(), 30, 100, 100);
        
        dsNhanSu[6] = new GiamDoc("giamdoc3", "Vo Van", "A", "Nam", dsPhongBan[2].getMaPB(), dsChucVu[0].getMaCV(), dsDuAn[2].getMaDA(), 30, 500, 20);
        dsNhanSu[7] = new TruongPhong("truongphong3", "Vo Van", "B", "Nam", dsPhongBan[2].getMaPB(), dsChucVu[1].getMaCV(), dsDuAn[2].getMaDA(), 30, 200, 200);
        dsNhanSu[8] = new NhanVien("nhanvien3", "Vo Van", "C", "Nữ", dsPhongBan[2].getMaPB(), dsChucVu[2].getMaCV(), dsDuAn[2].getMaDA(), 30, 100, 100);
        
        dsNhanSu[9] = new GiamDoc("giamdoc4", "Nguyen Thanh", "A", "Nam", dsPhongBan[3].getMaPB(), dsChucVu[0].getMaCV(), dsDuAn[3].getMaDA(), 30, 500, 20);
        dsNhanSu[10] = new TruongPhong("truongphong4", "Nguyen Thanh", "B", "Nam", dsPhongBan[3].getMaPB(), dsChucVu[1].getMaCV(), dsDuAn[3].getMaDA(), 30, 200, 200);
        dsNhanSu[11] = new NhanVien("nhanvien4", "Nguyen Thanh", "C", "Nữ", dsPhongBan[3].getMaPB(), dsChucVu[2].getMaCV(), dsDuAn[3].getMaDA(), 30, 100, 100);
        
        dsNhanSu[12] = new GiamDoc("giamdoc5", "Le Thanh", "A", "Nam", dsPhongBan[4].getMaPB(), dsChucVu[0].getMaCV(), dsDuAn[4].getMaDA(), 30, 500, 20);
        dsNhanSu[13] = new TruongPhong("truongphong5", "Le Thanh", "B", "Nam", dsPhongBan[4].getMaPB(), dsChucVu[1].getMaCV(), dsDuAn[4].getMaDA(), 30, 200, 200);
        dsNhanSu[14] = new NhanVien("nhanvien5", "Le Thanh", "C", "Nữ", dsPhongBan[4].getMaPB(), dsChucVu[2].getMaCV(), dsDuAn[4].getMaDA(), 30, 100, 100);
        
        writeListIntoFile(dsNhanSu);
    }
    
    public void taoBangLuong(String ma) {
        for(NhanSu ns : dsNhanSu) {
            if(ns.getMaNV().equals(ma)) {
                if(ns.tinhLuong() == 0) {
                    ns.nhapLuong(scan);
                    break;
                }
                else {
                    System.out.println("KHÔNG CẦN TÍNH LẠI, NHÂN SỰ ĐÃ CÓ LƯƠNG");
                }
            }
        }
    }
    
    public NhanSu chonViTri(NhanSu nhanSu) {
        int chon;
        
        System.out.println(" -----== CHỌN VỊ TRÍ ==-----");
        System.out.println(" 1.Nhân viên\n" +
                           " 2.Trưởng phòng\n" +
                           " 3.Giám đốc\n" +
                           " ---------------------------");
        System.out.print("MỜI NHẬP LỰA CHỌN: ");
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
    
    public NhanSu[] getListByPB(String tenPB) {
        int len = 0;
        NhanSu[] list = new NhanSu[len];
        
        for(NhanSu ns : dsNhanSu) {
            if(arrPhongBan.getById(ns.getMaPB()).getTenPB().equals(tenPB)) {
                NhanSu newNhanSu = ns;
                list = Arrays.copyOf(list, len + 1);
                list[len] = newNhanSu;
                len++;
            }   
        }
        
        return list;
    }
    
    public NhanSu getById(String id) {
        for(NhanSu nhanSu : dsNhanSu) {
            if(nhanSu.getMaNV().equals(id))
                return nhanSu;
        }
        return null;
    }
    
    public void xuatDanhSach() {
        for(int i = 0; i < arrLen; i++) {
            dsNhanSu[i].xuatThongTinCaNhan();
        }
    }
    
    public void xuatDanhSachByName(String ten) {
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getHoLot().contains(ten) || dsNhanSu[i].getTen().contains(ten)) {
                dsNhanSu[i].xuatThongTinCaNhan();
            }
        }
    }
    
    public void xuatDanhSachByMaPB(String maPB) {
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getMaPB().equalsIgnoreCase(maPB)) {
                dsNhanSu[i].xuatThongTinCaNhan();
            }
        }        
    }
    
    public void xuatDanhSachByMaCV(String maCV) {
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getMaCV().equalsIgnoreCase(maCV)) {
                dsNhanSu[i].xuatThongTinCaNhan();
            }
        }        
    }
    
    public void add() {
        NhanSu newNhanSu = null;
        
        System.out.println("Nhập thông tin nhân sự mới:");
        newNhanSu = chonViTri(newNhanSu);
        newNhanSu.nhap(scan);
        
        dsNhanSu = Arrays.copyOf(dsNhanSu, arrLen + 1);
        dsNhanSu[arrLen] = newNhanSu;
        arrLen++;
        
        writeListIntoFile(dsNhanSu);
    }
    
    public void updateById(String id) {
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getMaNV().equals(id)) {
                System.out.println("Cập nhật thông tin nhân sự:");
                dsNhanSu[i].nhap(scan);
                break;
            }
        }
        
        writeListIntoFile(dsNhanSu);
    }
    
    public void deleteById(String id) {
        NhanSu[] newDsNhanSu = Arrays.copyOf(dsNhanSu, arrLen - 1);
        int k = 0;
        
        for(int i = 0; i < arrLen; i++) {
            if(dsNhanSu[i].getMaNV().equals(id))
                continue;
            newDsNhanSu[k] = dsNhanSu[i];
            k++;
        }
        dsNhanSu = newDsNhanSu;
        arrLen--;
        
        writeListIntoFile(dsNhanSu);
    }

    public NhanSu[] getDsNhanSu() {
        return dsNhanSu;
    }

    public void setDsNhanSu(NhanSu[] dsNhanSu) {
        this.dsNhanSu = dsNhanSu;
    }
        
    private void writeListIntoFile(NhanSu[] dsNhanSu) {
        File file = new File("ListNhanSu.txt");
        Vector<NhanSu> listNhanSu = new Vector<>();
          
        for(NhanSu ns : dsNhanSu) {
            listNhanSu.add(ns);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listNhanSu);
            
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        
    public void readListFromFile() {
        File file = new File("ListNhanSu.txt");
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                
            Vector<NhanSu> listNhanSu = (Vector<NhanSu>) ois.readObject();
            System.out.println(listNhanSu);
            
            ois.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
