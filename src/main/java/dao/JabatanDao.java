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
import models.Jabatan;

/**
 *
 * @author darwisy
 */
public class JabatanDao {
    public static List<Jabatan> getAllJabatan() {
        String sql = "SELECT * FROM jabatan";
        List<Jabatan> jabatans = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Jabatan jabatan = new Jabatan();
                jabatan.setIdJabatan(resultSet.getInt("id_jabatan"));   
                jabatan.setNamaJabatan(resultSet.getString("nama_jabatan"));
                jabatan.setGajiPokok(resultSet.getBigDecimal("gaji_pokok"));
                
                jabatans.add(jabatan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jabatans;
    }
     
    public static List<Jabatan> searchJabatans(String keyword) {
        String sql = "SELECT * FROM jabatan  WHERE nama_jabatan LIKE ?";
        List<Jabatan> jabatans = new ArrayList<>();
        
        
        try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + keyword + "%");
        

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Jabatan jabatan = new Jabatan();
            jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
            jabatan.setGajiPokok(rs.getBigDecimal("gaji_pokok"));
            jabatans.add(jabatan);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return jabatans;
        
    }
      
    public boolean insertJabatan(Jabatan jabatan) {
        String query = "INSERT INTO jabatan (nama_jabatan, gaji_pokok) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
          PreparedStatement stmt = conn.prepareStatement(query)) {

         stmt.setString(1, jabatan.getNamaJabatan());
         stmt.setBigDecimal(2, jabatan.getGajiPokok());

         int result = stmt.executeUpdate();
         return result > 0;

        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateJabatan(Jabatan jabatan) {
        String sql = "UPDATE jabatan SET nama_jabatan = ?, gaji_pokok = ? WHERE id_jabatan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jabatan.getNamaJabatan());
            stmt.setBigDecimal(2, jabatan.getGajiPokok());
            stmt.setInt(3, jabatan.getIdJabatan());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteJabatan(int id){
        String sql = "DELETE FROM jabatan WHERE id_jabatan =?";
        
         try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    public static List<Jabatan> getNameJabatan() {
        String sql = "SELECT id_jabatan, nama_jabatan FROM jabatan";
        List<Jabatan> jabatans = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Jabatan jabatan = new Jabatan();
                jabatan.setIdJabatan(resultSet.getInt("id_jabatan"));   
                jabatan.setNamaJabatan(resultSet.getString("nama_jabatan"));
                
                
                jabatans.add(jabatan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jabatans;
    }
    public Jabatan getById(int id) {
        String sql = "SELECT * FROM jabatan WHERE id_jabatan = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Jabatan jabatan = new Jabatan();
                    jabatan.setIdJabatan(rs.getInt("id_jabatan"));
                    jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                    jabatan.setGajiPokok(rs.getBigDecimal("gaji_pokok"));
                    return jabatan;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
