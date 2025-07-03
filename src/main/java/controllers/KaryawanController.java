/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.KaryawanDao;
import java.util.List;
import models.Karyawan;

/**
 *
 * @author darwisy
 */
public class KaryawanController {
    private KaryawanDao karyawanDao = new KaryawanDao();

    public static List<Karyawan> getAllKaryawan() {
        return KaryawanDao.getAllKaryawan();
    }
    
    public static List<Karyawan> getAllKaryawanForComboBox() {
        return KaryawanDao.getAllKaryawanForComboBox();
    }
    
    public List<Karyawan> searchKaryawans(String keyword) {
        return karyawanDao.searchKaryawans(keyword);
    }
    
    public boolean insertKaryawan(Karyawan karyawan) {
        return karyawanDao.insertKaryawan(karyawan);
    }
    
    public boolean updateKaryawan(Karyawan karyawan) {
        return karyawanDao.updateKaryawan(karyawan);
    }
    
    public boolean deleteKaryawan(String kdKaryawan) {
        return karyawanDao.deleteKaryawan(kdKaryawan);
    }
    
    public String getLastKodeKaryawan() {
        return KaryawanDao.getLastKodeKaryawan();
    }
}
