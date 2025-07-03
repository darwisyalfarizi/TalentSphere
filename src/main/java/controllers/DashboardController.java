/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DashboardDao;
import java.util.List;
import models.Karyawan;

/**
 *
 * @author darwisy
 */
public class DashboardController {
     
    public int[] getDashboardStats() {
        int[] stats = new int[3];
        stats[0] = DashboardDao.getTotalKaryawan();
        stats[1] = DashboardDao.getKaryawanMasukHariIni();
        stats[2] = DashboardDao.getTotalCutiBulanIni();
        return stats;
    }
    
    public List<Karyawan> getKaryawanList() {
        return DashboardDao.getAllKaryawanDashboard();
    }
}