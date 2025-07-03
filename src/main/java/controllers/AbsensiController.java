/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.AbsensiDao;
import java.util.List;
import models.Absensi;

/**
 *
 * @author darwisy
 */
public class AbsensiController {
     private AbsensiDao absensiDao = new AbsensiDao();

    public static List<Absensi> getAllAbsensi(){
        return AbsensiDao.getAllAbsensi();
    }
    public List<Absensi> searchAbsensis(String keyword) {
        return absensiDao.searchAbsensis(keyword);
    }
    public boolean insertAbsensi(Absensi absensi) {
        return absensiDao.insertAbsensi(absensi);
    }
    public boolean updateAbsensi(Absensi absensi) {
        return absensiDao.updateAbsensi(absensi);
    }
    public boolean deleteAbsensi(String kdKaryawan) {
        return absensiDao.deleteAbsensi(kdKaryawan);
    }
    public String getLastKodeAbsensi() {
        return absensiDao.getLastKodeAbsensi();
    }
}
