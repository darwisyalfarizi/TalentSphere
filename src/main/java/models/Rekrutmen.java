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
public class Rekrutmen {
    private String kdRekrutmen;
    private String namaPelamar;
    private String email;
    private long telepon;
    private String posisi;
    private String status;

    public String getKdRekrutmen() {
        return kdRekrutmen;
    }

    public void setKdRekrutmen(String kdRekrutmen) {
        this.kdRekrutmen = kdRekrutmen;
    }

    public String getNamaPelamar() {
        return namaPelamar;
    }

    public void setNamaPelamar(String namaPelamar) {
        this.namaPelamar = namaPelamar;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelepon() {
        return telepon;
    }

    public void setTelepon(long telepon) {
        this.telepon = telepon;
    }

    
    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
