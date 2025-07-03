/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.RekrutmenDao;
import java.util.List;
import models.Rekrutmen;

/**
 *
 * @author darwisy
 */
public class RekrutmenController {
    private RekrutmenDao rekrutmenDao = new RekrutmenDao();

    public List<Rekrutmen> getAllRekrutmen() {
        return rekrutmenDao.getAllRekrutmen();
    }

    public List<Rekrutmen> searchRekrutmens(String keyword) {
        return rekrutmenDao.searchRekrutmens(keyword);
    }

    public boolean insertRekrutmen(Rekrutmen rekrutmen) {
        return rekrutmenDao.insertRekrutmen(rekrutmen);
    }

    public boolean updateRekrutmen(Rekrutmen rekrutmen) {
        return rekrutmenDao.updateRekrutmen(rekrutmen);
    }

    public boolean deleteRekrutmen(String kd) {
        return rekrutmenDao.deleteRekrutmen(kd);
    }
    public String getLastKodeRekrutmen() {
        return rekrutmenDao.getLastKodeRekrutmen();
    }
    
}
