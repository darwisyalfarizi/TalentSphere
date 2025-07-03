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
import models.Rekrutmen;


/**
 *
 * @author darwisy
 */
public class RekrutmenDao {
   public static List<Rekrutmen> getAllRekrutmen() {
        String sql = "SELECT * FROM rekrutmen";
        List<Rekrutmen> rekrutmens = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Rekrutmen rekrutmen = new Rekrutmen();
                rekrutmen.setKdRekrutmen(resultSet.getString("kd_rekrutmen"));   
                rekrutmen.setNamaPelamar(resultSet.getString("nama_pelamar"));
                rekrutmen.setEmail(resultSet.getString("email"));
                rekrutmen.setTelepon(resultSet.getLong("telepon"));  // Changed to getLong
                rekrutmen.setPosisi(resultSet.getString("posisi"));
                rekrutmen.setStatus(resultSet.getString("status"));
                
                rekrutmens.add(rekrutmen);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rekrutmens;
    }

    public List<Rekrutmen> searchRekrutmens(String keyword) {
        String sql = "SELECT * FROM rekrutmen WHERE nama_pelamar LIKE ? OR posisi LIKE ? OR status  LIKE ?";
        List<Rekrutmen> rekrutmens = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            stmt.setString(3, "%" + keyword + "%");
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Rekrutmen rekrutmen = new Rekrutmen();
                rekrutmen.setKdRekrutmen(rs.getString("kd_rekrutmen"));
                rekrutmen.setNamaPelamar(rs.getString("nama_pelamar"));
                rekrutmen.setEmail(rs.getString("email"));
                rekrutmen.setTelepon(rs.getLong("telepon"));
                rekrutmen.setPosisi(rs.getString("posisi"));
                rekrutmen.setStatus(rs.getString("status"));
                
                rekrutmens.add(rekrutmen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rekrutmens;
    }
     
   public boolean insertRekrutmen(Rekrutmen rekrutmen) {
    String query = "INSERT INTO rekrutmen (kd_rekrutmen, nama_pelamar, email, telepon, posisi, status) VALUES (?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, rekrutmen.getKdRekrutmen());
        stmt.setString(2, rekrutmen.getNamaPelamar());
        stmt.setString(3, rekrutmen.getEmail());
        stmt.setLong(4, rekrutmen.getTelepon());
        stmt.setString(5, rekrutmen.getPosisi());
        stmt.setString(6, rekrutmen.getStatus());
        
        int result = stmt.executeUpdate();
        return result > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean updateRekrutmen(Rekrutmen rekrutmen) {
    String sql = "UPDATE rekrutmen SET nama_pelamar=?, email=?, telepon=?, posisi=?, status=? WHERE kd_rekrutmen=?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, rekrutmen.getNamaPelamar());
        stmt.setString(2, rekrutmen.getEmail());
        stmt.setLong(3, rekrutmen.getTelepon());
        stmt.setString(4, rekrutmen.getPosisi());
        stmt.setString(5, rekrutmen.getStatus());
        stmt.setString(6, rekrutmen.getKdRekrutmen());

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        // Add more detailed error logging
        System.err.println("SQL State: " + e.getSQLState());
        System.err.println("Error Code: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());
        return false;
    }
}
    
    public boolean deleteRekrutmen(String kd){
        String sql = "DELETE FROM rekrutmen WHERE kd_rekrutmen =?";
        
         try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setString(1, kd);
        return stmt.executeUpdate() > 0;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    
    public static String getLastKodeRekrutmen() {
        String sql = "SELECT kd_rekrutmen FROM rekrutmen ORDER BY kd_rekrutmen DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("kd_rekrutmen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
