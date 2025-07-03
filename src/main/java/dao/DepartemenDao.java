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
import models.Departemen;


/**
 *
 * @author darwisy
 */
public class DepartemenDao {
    public static List<Departemen> getAllDepartemen() {
        String sql = "SELECT * FROM departemen";
        List<Departemen> departemens = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Departemen departemen = new Departemen();
                departemen.setId(resultSet.getInt("id_departemen"));   
                departemen.setNamaDepartemen(resultSet.getString("nama_departemen"));
                departemens.add(departemen);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departemens;
    }
    
    public static List<Departemen> searchDepartemens(String keyword) {
        String sql = "SELECT * FROM departemen  WHERE nama_departemen LIKE ?";
        List<Departemen> departemens = new ArrayList<>();
        
        
        try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, "%" + keyword + "%");
        

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Departemen departemen = new Departemen();
            departemen.setNamaDepartemen(rs.getString("nama_departemen"));
            departemens.add(departemen);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return departemens;
        
    }
     
    public boolean insertDepartemen(Departemen departemen) {
        String query = "INSERT INTO departemen (nama_departemen) VALUES (?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, departemen.getNamaDepartemen());
            
            int result = stmt.executeUpdate();
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateDepartemen(Departemen departemen) {
        String sql = "UPDATE departemen SET nama_departemen = ? WHERE id_departemen = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, departemen.getNamaDepartemen());
            
            stmt.setInt(2, departemen.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteDepartemen(int id){
        String sql = "DELETE FROM departemen WHERE id_departemen =?";
        
         try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
}
