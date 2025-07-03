/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigDecimal;

/**
 *
 * @author darwisy
 */
public class Jabatan {
    private int id_jabatan;
    private String nama_jabatan;
    private BigDecimal gaji_pokok;

    public int getIdJabatan() {
        return id_jabatan;
    }

    public void setIdJabatan(int id_jabatan) {
        this.id_jabatan = id_jabatan;
    }

    public String getNamaJabatan() {
        return nama_jabatan;
    }

    public void setNamaJabatan(String nama_jabatan) {
        this.nama_jabatan = nama_jabatan;
    }

    public BigDecimal getGajiPokok() {
        return gaji_pokok;
    }

    public void setGajiPokok(BigDecimal gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }
    
    public String toString() {
        return nama_jabatan;
    }

    
}
