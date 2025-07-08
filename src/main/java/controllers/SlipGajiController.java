/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.SlipGajiDAO;
import java.util.List;
import models.SlipGaji;


/**
 *
 * @author darwisy
 */
public class SlipGajiController {
    private SlipGajiDAO slipGajiDAO = new SlipGajiDAO();

    public static List<SlipGaji> getAllSlipGaji(){
        return SlipGajiDAO.getAllSlipGaji();
    }
    public List<SlipGaji> searchSlipGajis(String keyword) {
        return slipGajiDAO.searchSlipGajis(keyword);
    }
    public boolean insertSlipGaji(SlipGaji slipGaji) {
      return slipGajiDAO.insertSlipGaji(slipGaji);
    }    
    public boolean updateSlipGaji(SlipGaji slipGaji) {
        return slipGajiDAO.updateSlipGaji(slipGaji);
    }
    public boolean deleteSlipGaji(String kdSlip) {
        return slipGajiDAO.deleteSlipGaji(kdSlip);
    }

    public String getLastKodeSlipGaji() {
        return slipGajiDAO.getLastKodeSlipGaji();
    }
   
}
