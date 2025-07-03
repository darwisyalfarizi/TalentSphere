/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.CutiDao;
import java.util.List;
import models.Cuti;

/**
 *
 * @author darwisy
 */
public class CutiController {
     private CutiDao cutiDao = new CutiDao();

    public static List<Cuti> getAllCuti(){
        return CutiDao.getAllCuti();
    }
    public List<Cuti> searchCutis(String keyword) {
        return cutiDao.searchCutis(keyword);
    }
    public boolean insertCuti(Cuti cuti) {
        return cutiDao.insertCuti(cuti);
    }
    public boolean updateCuti(Cuti cuti) {
        return cutiDao.updateCuti(cuti);
    }
    public boolean deleteCuti(String kd) {
        return cutiDao.deleteCuti(kd);
    }
    public String getLastKodeCuti() {
        return cutiDao.getLastKodeCuti();
    }
}
