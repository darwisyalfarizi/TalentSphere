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
public class Cuti {
    private String kdCuti;
    private String kdKaryawan;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private String keterangan;

    public String getKdCuti() {
        return kdCuti;
    }

    public void setKdCuti(String kdCuti) {
        this.kdCuti = kdCuti;
    }
    
    public String getKdKaryawan() {
    return kdKaryawan;
        }

        public void setKdKaryawan(String kdKaryawan) {
            this.kdKaryawan = kdKaryawan;
        }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(String karyawan) {
        this.karyawan = karyawan;
    }
    private String status;
    private String karyawan;
}
