/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author darwisy
 */
public class Departemen {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaDepartemen() {
        return nama_departemen;
    }

    public void setNamaDepartemen(String nama_departemen) {
        this.nama_departemen = nama_departemen;
    }
    private String nama_departemen ;

    @Override
    public String toString() {
        return nama_departemen;
    }
}
