/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;
/**
 *
 * @author darwisy
 */
public class Absensi {
    private String kdAbsensi;       
    private String kdKaryawan;
    private Date tanggal;
    private String status;
    private String keterangan;
    private String karyawan;

    // Constructor
     public Absensi() {
        this.kdAbsensi = "";
        this.kdKaryawan = "";
    }
    
     public String getKdAbsensi() {
        return kdAbsensi;
    }

    public void setKdAbsensi(String kdAbsensi) {
        this.kdAbsensi = kdAbsensi;
    }

   public String getKdKaryawan() {
        return kdKaryawan;
    }

    public void setKdKaryawan(String kdKaryawan) {
        this.kdKaryawan = kdKaryawan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
  
    
    public void setKaryawan(String karyawan) { this.karyawan = karyawan; }
    public String getKaryawan() { return karyawan; }
}
