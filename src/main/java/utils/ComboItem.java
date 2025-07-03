/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;



/**
 *
 * @author darwisy
 */
public class ComboItem {
    private int idSlip;
    private String displayText;

    public ComboItem(int idSlip, String namaKaryawan, String periode) {
        this.idSlip = idSlip;
        this.displayText = namaKaryawan + " - " + periode;
    }

    public int getIdSlip() {
        return idSlip;
    }

    @Override
    public String toString() {
        return displayText;
    }
}
