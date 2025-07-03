package dao;

import config.DatabaseConnection;
import models.DetailGaji;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailGajiDao {
    
    public List<DetailGaji> getAllDetailGaji() {
        List<DetailGaji> details = new ArrayList<>();
        String sql = "SELECT * FROM detail_gaji";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                DetailGaji detail = new DetailGaji();
                detail.setkdDetail(rs.getString("kd_detail"));
                detail.setKdSlip(rs.getString("kd_slip"));
                detail.setJenis(rs.getString("jenis"));
                detail.setDeskripsi(rs.getString("deskripsi"));
                detail.setIsTambah(rs.getBoolean("is_tambah"));
                detail.setJumlah(rs.getBigDecimal("jumlah"));
                details.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }
    
    public boolean insertDetailGaji(DetailGaji detailGaji) {
       String sql = "INSERT INTO detail_gaji (kd_detail, kd_slip, jenis, deskripsi, is_tambah, jumlah) VALUES (?,?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
           stmt.setString(1, detailGaji.getkdDetail()); 
           stmt.setString(2, detailGaji.getKdSlip());
            stmt.setString(3, detailGaji.getJenis());
            stmt.setString(4, detailGaji.getDeskripsi());
            stmt.setInt(5, detailGaji.getIsTambahAsInt());
            stmt.setBigDecimal(6, detailGaji.getJumlah());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DetailGaji> searchDetailGajiBySlip(String kdSlip) {
    List<DetailGaji> details = new ArrayList<>();
    String sql = "SELECT * FROM detail_gaji WHERE kd_slip LIKE ?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, "%" + kdSlip + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            DetailGaji detail = new DetailGaji();
            detail.setkdDetail(rs.getString("kd_detail"));
            detail.setKdSlip(rs.getString("kd_slip"));
            detail.setJenis(rs.getString("jenis"));
            detail.setDeskripsi(rs.getString("deskripsi"));
            detail.setIsTambah(rs.getBoolean("is_tambah"));
            detail.setJumlah(rs.getBigDecimal("jumlah"));
            details.add(detail);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return details;
}
    
    public boolean updateDetailGaji(DetailGaji detailGaji) {
    String sql = "UPDATE detail_gaji SET kd_slip=?, jenis=?, deskripsi=?, is_tambah=?, jumlah=? WHERE kd_detail=?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        // Set parameters in the correct order for UPDATE
        stmt.setString(1, detailGaji.getKdSlip());
        stmt.setString(2, detailGaji.getJenis());
        stmt.setString(3, detailGaji.getDeskripsi());
        stmt.setInt(4, detailGaji.getIsTambahAsInt());
        stmt.setBigDecimal(5, detailGaji.getJumlah());
        stmt.setString(6, detailGaji.getkdDetail()); // WHERE condition
        
        int affectedRows = stmt.executeUpdate();
        return affectedRows > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean deleteDetailGaji(String kdDetail) {
        String sql = "DELETE FROM detail_gaji WHERE kd_detail = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, kdDetail);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}