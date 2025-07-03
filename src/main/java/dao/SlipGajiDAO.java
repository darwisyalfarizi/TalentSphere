package dao;

import models.SlipGaji;
import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SlipGajiDAO {
    public static List<SlipGaji> getAllSlipGaji() {
        List<SlipGaji> slipList = new ArrayList<>();
        
        String sql = """
            SELECT s.kd_slip, k.kd_karyawan, k.nama, s.periode, s.gaji_pokok, 
                   COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 1), 0) AS total_tambahan, 
                   COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 0), 0) AS total_pengurangan, 
                   (s.gaji_pokok + COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 1), 0) - 
                   COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 0), 0)) AS gaji_bersih 
            FROM slip_gaji s 
            JOIN karyawan k ON k.kd_karyawan = s.kd_karyawan
            ORDER BY s.periode DESC
            """;
            
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                SlipGaji slip = new SlipGaji();
                slip.setKdSlip(rs.getString("kd_slip"));
                slip.setKdKaryawan(rs.getString("kd_karyawan"));
                slip.setKaryawan(rs.getString("nama"));
                slip.setPeriode(rs.getDate("periode"));
                slip.setGajiPokok(rs.getBigDecimal("gaji_pokok"));
                slip.setTotalTambahan(rs.getBigDecimal("total_tambahan"));
                slip.setTotalPengurangan(rs.getBigDecimal("total_pengurangan"));
                slip.setGajiBersih(rs.getBigDecimal("gaji_bersih"));
                
                slipList.add(slip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slipList;
    }

    public boolean insertSlipGaji(SlipGaji slipGaji) {
        String sql = "INSERT INTO slip_gaji (kd_slip, kd_karyawan, periode, gaji_pokok  ) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, slipGaji.getKdSlip());
            stmt.setString(2, slipGaji.getKdKaryawan());
            stmt.setDate(3, new java.sql.Date(slipGaji.getPeriode().getTime()));
            stmt.setBigDecimal(4, slipGaji.getGajiPokok());
           
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<SlipGaji> searchSlipGajis(String searchKeyword) {
        List<SlipGaji> slipList = new ArrayList<>();
        
        String sql = """
            SELECT s.kd_slip, k.kd_karyawan, k.nama, s.periode, s.gaji_pokok,
                   COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 1), 0) AS total_tambahan,
                   COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 0), 0) AS total_pengurangan,
                   (s.gaji_pokok + COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 1), 0) -
                   COALESCE((SELECT SUM(jumlah) FROM detail_gaji d WHERE d.kd_slip = s.kd_slip AND d.is_tambah = 0), 0)) AS gaji_bersih
            FROM slip_gaji s
            JOIN karyawan k ON k.kd_karyawan = s.kd_karyawan
            WHERE k.nama LIKE ? OR s.kd_slip LIKE ? OR k.kd_karyawan LIKE ?
            ORDER BY s.periode DESC
            """;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String searchParam = "%" + searchKeyword + "%";
            stmt.setString(1, searchParam);
            stmt.setString(2, searchParam);
            stmt.setString(3, searchParam);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    SlipGaji slip = new SlipGaji();
                    slip.setKdSlip(rs.getString("kd_slip"));
                    slip.setKdKaryawan(rs.getString("kd_karyawan"));
                    slip.setKaryawan(rs.getString("nama"));
                    slip.setPeriode(rs.getDate("periode"));
                    slip.setGajiPokok(rs.getBigDecimal("gaji_pokok"));
                    slip.setTotalTambahan(rs.getBigDecimal("total_tambahan"));
                    slip.setTotalPengurangan(rs.getBigDecimal("total_pengurangan"));
                    slip.setGajiBersih(rs.getBigDecimal("gaji_bersih"));
                    
                    slipList.add(slip);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slipList;
    }
    
    public boolean updateSlipGaji(SlipGaji slipGaji) {
        String sql = "UPDATE slip_gaji SET kd_karyawan=?, periode=?, gaji_pokok=? WHERE kd_slip=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, slipGaji.getKdKaryawan());
            stmt.setDate(2, new java.sql.Date(slipGaji.getPeriode().getTime()));
            stmt.setBigDecimal(3, slipGaji.getGajiPokok());
            stmt.setString(4, slipGaji.getKdSlip());
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteSlipGaji(String kdSlip) {
        String sql = "DELETE FROM slip_gaji WHERE kd_slip = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, kdSlip);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public String generateKdSlip() {
//        String sql = "SELECT MAX(kd_slip) AS last_code FROM slip_gaji WHERE kd_slip LIKE 'SLP-%'";
//        String newKdSlip = "SLP-00001"; // default value
//        
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            
//            if (rs.next()) {
//                String lastCode = rs.getString("last_code");
//                if (lastCode != null) {
//                    int lastNum = Integer.parseInt(lastCode.substring(4));
//                    newKdSlip = String.format("SLP-%05d", lastNum + 1);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return newKdSlip;
//    }
}