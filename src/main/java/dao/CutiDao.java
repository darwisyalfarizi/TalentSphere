/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cuti;


/**
 *
 * @author darwisy
 */
public class CutiDao {
    public static List<Cuti> getAllCuti() {
        String sql = "SELECT c.kd_cuti, k.nama, c.tanggal_mulai, c.tanggal_selesai,  c.keterangan, c.status FROM cuti c JOIN karyawan k ON k.kd_karyawan = c.kd_karyawan";
        List<Cuti> cutis = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cuti cuti = new Cuti();
                cuti.setKdCuti(resultSet.getString("kd_cuti"));
                cuti.setKaryawan(resultSet.getString("nama"));
                cuti.setTanggalMulai(resultSet.getDate("tanggal_mulai"));
                cuti.setTanggalSelesai(resultSet.getDate("tanggal_selesai"));
                cuti.setKeterangan(resultSet.getString("keterangan"));
                cuti.setStatus(resultSet.getString("status"));
                
                cutis.add(cuti);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cutis;
    }
    
    public static List<Cuti> searchCutis(String keyword) {
    String sql = "SELECT c.kd_cuti, k.nama, c.tanggal_mulai, c.tanggal_selesai, c.keterangan, c.status " +
                 "FROM cuti c JOIN karyawan k ON k.kd_karyawan = c.kd_karyawan " +
                 "WHERE k.nama LIKE ? OR c.tanggal_mulai LIKE ? OR c.tanggal_selesai LIKE ?  OR c.status LIKE ?";
    
    List<Cuti> cutis = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, "%" + keyword + "%");
        stmt.setString(2, "%" + keyword + "%");
        stmt.setString(3, "%" + keyword + "%");
        stmt.setString(4, "%" + keyword + "%");
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cuti cuti = new Cuti();
            cuti.setKdCuti(rs.getString("kd_cuti"));
            cuti.setKaryawan(rs.getString("nama"));
            cuti.setTanggalMulai(rs.getDate("tanggal_mulai"));
            cuti.setTanggalSelesai(rs.getDate("tanggal_selesai"));
            cuti.setKeterangan(rs.getString("keterangan"));
            cuti.setStatus(rs.getString("status"));
            
            cutis.add(cuti);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cutis;
}
     
    public boolean insertCuti(Cuti cuti) {
        String query = "INSERT INTO cuti (kd_cuti, kd_karyawan, tanggal_mulai, tanggal_selesai, keterangan, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            

            // Set parameters in correct order matching the SQL query
            stmt.setString(1, cuti.getKdCuti());               // kd_cuti
            stmt.setString(2, cuti.getKdKaryawan());           // kd_karyawan
            stmt.setDate(3, new java.sql.Date(cuti.getTanggalMulai().getTime()));      // tanggal_mulai
            stmt.setDate(4, new java.sql.Date(cuti.getTanggalSelesai().getTime()));    // tanggal_selesai
            stmt.setString(5, cuti.getKeterangan());           // keterangan (can be null)
            stmt.setString(6, cuti.getStatus() != null ? cuti.getStatus() : "Menunggu"); // status with default

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            System.err.println("Error inserting cuti: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Validation error: " + e.getMessage());
            return false;
        }
    }

public boolean updateCuti(Cuti cuti) {
    String query = "UPDATE cuti SET kd_karyawan=?, tanggal_mulai=?, tanggal_selesai=?, keterangan=?, status=? WHERE kd_cuti=?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameters in the exact order they appear in the SQL query
        stmt.setString(1, cuti.getKdKaryawan());
        stmt.setDate(2, new java.sql.Date(cuti.getTanggalMulai().getTime()));
        stmt.setDate(3, new java.sql.Date(cuti.getTanggalSelesai().getTime()));
        stmt.setString(4, cuti.getKeterangan());  // Fixed: parameter 4 is keterangan
        stmt.setString(5, cuti.getStatus());      // Fixed: parameter 5 is status
        stmt.setString(6, cuti.getKdCuti());         // Fixed: parameter 6 is WHERE condition
        
        int result = stmt.executeUpdate();
        return result > 0;
        
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean deleteCuti(String kd){
        String sql = "DELETE FROM cuti WHERE kd_cuti =?";
        
         try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setString(1, kd);
        return stmt.executeUpdate() > 0;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public static String getLastKodeCuti() {
        String sql = "SELECT kd_cuti FROM cuti ORDER BY kd_cuti DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("kd_cuti");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
