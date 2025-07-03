/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.DepartemenDao;
import java.util.List;
import models.Departemen;

/**
 *
 * @author darwisy
 */
public class DepartemenController {
    private DepartemenDao departemenDao = new DepartemenDao();

    public static List<Departemen> getAllDepartemen(){
        return DepartemenDao.getAllDepartemen();
    }
    public List<Departemen> searchDepartemens(String keyword) {
        return departemenDao.searchDepartemens(keyword);
    }
    public boolean insertDepartemen(Departemen departemen) {
        return departemenDao.insertDepartemen(departemen);
    }
    public boolean updateDepartemen(Departemen departemen) {
        return departemenDao.updateDepartemen(departemen);
    }
    public boolean deleteDepartemen(int id) {
        return departemenDao.deleteDepartemen(id);
    }
}
