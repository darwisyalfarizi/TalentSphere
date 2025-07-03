/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author darwisy
 */
public class Karyawan {
    private String kdKaryawan;
    private String nama;
    private int jabatanId;
    private int departemenId;
    private String status;
    private Date tanggalMasuk;
    
    private String noKtp;
    private String noHp;
    private String alamat;
    private String jabatan;
    private String departemen;
    
    
    private Date tanggalMulaiKontrak;
    private Date tanggalBerakhirKontrak;
    private String statusKontrak;
    
    public Karyawan() {
        this.kdKaryawan = "";
        this.jabatanId = 0;
        this.nama = "";
        this.noKtp = "";
        this.noHp = "";
        this.alamat = "";
    }
    
    
    public String getKdKaryawan() {
        return kdKaryawan;
    }

    public void setKdKaryawan(String kdKaryawan) {
        this.kdKaryawan = kdKaryawan;
    }
    
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
     public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public Date getTanggalMulaiKontrak() {
        return tanggalMulaiKontrak;
    }

    public void setTanggalMulaiKontrak(Date tanggalMulaiKontrak) {
        this.tanggalMulaiKontrak = tanggalMulaiKontrak;
    }

    public Date getTanggalBerakhirKontrak() {
        return tanggalBerakhirKontrak;
    }

    public void setTanggalBerakhirKontrak(Date tanggalBerakhirKontrak) {
        this.tanggalBerakhirKontrak = tanggalBerakhirKontrak;
    }

    public String getStatusKontrak() {
        return statusKontrak;
    }

    public void setStatusKontrak(String statusKontrak) {
        this.statusKontrak = statusKontrak;
    }
    
    
    

    

    public int getJabatanId() {
        return jabatanId;
    }

    public void setJabatanId(int jabatanId) {
        this.jabatanId = jabatanId;
    }

    public int getDepartemenId() {
        return departemenId;
    }

    public void setDepartemenId(int departemenId) {
        this.departemenId = departemenId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

  

    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
    public String getJabatan() { return jabatan; }

    public void setDepartemen(String departemen) { this.departemen = departemen; }
    public String getDepartemen() { return departemen; }

    @Override
    public String toString() {
        return nama;
    }
}

