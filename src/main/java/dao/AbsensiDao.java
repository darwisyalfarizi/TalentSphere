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
import models.Absensi;



/**
 *
 * @author darwisy
 */
public class AbsensiDao {
    public static List<Absensi> getAllAbsensi() {
        String sql = """
            SELECT a.kd_absensi, a.kd_karyawan, k.nama, a.tanggal, 
                   a.status, a.keterangan 
            FROM absensi a 
            JOIN karyawan k ON k.kd_karyawan = a.kd_karyawan
            ORDER BY a.tanggal DESC
            """;
        List<Absensi> absensis = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Absensi absensi = new Absensi();
                absensi.setKdAbsensi(resultSet.getString("kd_absensi"));
                absensi.setKdKaryawan(resultSet.getString("kd_karyawan"));
                absensi.setKaryawan(resultSet.getString("nama"));
                absensi.setTanggal(resultSet.getDate("tanggal"));
                absensi.setStatus(resultSet.getString("status"));
                absensi.setKeterangan(resultSet.getString("keterangan"));
                absensis.add(absensi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absensis;
    }
    
    public static List<Absensi> searchAbsensis(String keyword) {
        String sql = """
            SELECT a.kd_absensi, a.kd_karyawan, k.nama, a.tanggal, 
                   a.status, a.keterangan 
            FROM absensi a 
            JOIN karyawan k ON k.kd_karyawan = a.kd_karyawan
            WHERE k.nama LIKE ? 
               OR a.tanggal LIKE ? 
               OR a.status LIKE ?
               OR a.keterangan LIKE ?
            ORDER BY a.tanggal DESC
            """;
        List<Absensi> absensis = new ArrayList<>();
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            for (int i = 1; i <= 4; i++) {
                statement.setString(i, "%" + keyword + "%");
            }
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Absensi absensi = new Absensi();
                    absensi.setKdAbsensi(resultSet.getString("kd_absensi"));   
                    absensi.setKdKaryawan(resultSet.getString("kd_karyawan"));
                    absensi.setKaryawan(resultSet.getString("nama"));
                    absensi.setTanggal(resultSet.getDate("tanggal"));
                    absensi.setStatus(resultSet.getString("status"));
                    absensi.setKeterangan(resultSet.getString("keterangan"));
                    absensis.add(absensi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absensis;
    }
     
    public boolean insertAbsensi(Absensi absensi) {
        String query = """
            INSERT INTO absensi 
            (kd_absensi, kd_karyawan, tanggal, status, keterangan) 
            VALUES (?, ?, ?, ?, ?)
            """;
            
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, absensi.getKdAbsensi());
            stmt.setString(2, absensi.getKdKaryawan());
            stmt.setDate(3, new java.sql.Date(absensi.getTanggal().getTime()));
            stmt.setString(4, absensi.getStatus());
            stmt.setString(5, absensi.getKeterangan());
            
            int result = stmt.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAbsensi(Absensi absensi) {
        String query = """
            UPDATE absensi 
            SET kd_karyawan=?, tanggal=?, status=?, keterangan=? 
            WHERE kd_absensi=?
            """;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, absensi.getKdKaryawan());
            stmt.setDate(2, new java.sql.Date(absensi.getTanggal().getTime()));
            stmt.setString(3, absensi.getStatus());
            stmt.setString(4, absensi.getKeterangan());
            stmt.setString(5, absensi.getKdAbsensi());
            
            int result = stmt.executeUpdate();
            return result > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteAbsensi(String kdAbsensi) {
        String sql = "DELETE FROM absensi WHERE kd_absensi = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
         
            stmt.setString(1, kdAbsensi);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static String getLastKodeAbsensi() {
        String sql = "SELECT kd_absensi FROM absensi ORDER BY kd_absensi DESC LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getString("kd_absensi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
