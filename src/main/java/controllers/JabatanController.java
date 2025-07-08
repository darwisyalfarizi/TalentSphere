/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.JabatanDao;
import java.util.List;
import models.Jabatan;

/**
 *
 * @author darwisy
 */
public class JabatanController {
    private JabatanDao jabatanDao = new JabatanDao();

    public static List<Jabatan> getAllJabatan(){
        return JabatanDao.getAllJabatan();
    }
    public List<Jabatan> searchJabatans(String keyword) {
        return jabatanDao.searchJabatans(keyword);
    }
    public boolean insertUser(Jabatan jabatan) {
        return jabatanDao.insertJabatan(jabatan);
    }
    public boolean updateUser(Jabatan jabatan) {
        return jabatanDao.updateJabatan(jabatan);
    }
    public boolean deleteJabatan(int id) {
        return jabatanDao.deleteJabatan(id);
    }
    public static List<Jabatan> getNameJabatan(){
        return JabatanDao.getNameJabatan();
    }
    public Jabatan getJabatanById(int id) {
    
    JabatanDao jabatanDao = new JabatanDao();
    return jabatanDao.getById(id);
    }
}
