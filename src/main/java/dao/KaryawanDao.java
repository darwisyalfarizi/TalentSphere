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
import models.Karyawan;


/**
 *
 * @author darwisy
 */
public class KaryawanDao {
    public static List<Karyawan> getAllKaryawan() {
        String sql = """
            SELECT k.kd_karyawan, k.nama, j.nama_jabatan, d.nama_departemen, 
                   k.status, k.tanggal_masuk, k.no_ktp, k.no_hp, k.alamat,
                   k.tanggal_mulai_kontrak, k.tanggal_berakhir_kontrak, k.status_kontrak
            FROM karyawan k
            JOIN jabatan j ON k.jabatan_id = j.id_jabatan
            JOIN departemen d ON k.departemen_id = d.id_departemen
        """;
        List<Karyawan> karyawans = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Karyawan karyawan = new Karyawan();
                karyawan.setKdKaryawan(resultSet.getString("kd_karyawan"));   
                karyawan.setJabatan(resultSet.getString("nama_jabatan"));
                karyawan.setDepartemen(resultSet.getString("nama_departemen"));
                karyawan.setStatus(resultSet.getString("status"));
                karyawan.setTanggalMasuk(resultSet.getDate("tanggal_masuk"));
                karyawan.setNama(resultSet.getString("nama"));
                karyawan.setNoKtp(resultSet.getString("no_ktp"));
                karyawan.setNoHp(resultSet.getString("no_hp"));
                karyawan.setAlamat(resultSet.getString("alamat"));
                karyawan.setTanggalMulaiKontrak(resultSet.getDate("tanggal_mulai_kontrak"));
                karyawan.setTanggalBerakhirKontrak(resultSet.getDate("tanggal_berakhir_kontrak"));
                karyawan.setStatusKontrak(resultSet.getString("status_kontrak"));
                
                karyawans.add(karyawan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return karyawans;
    }
     
    public static List<Karyawan> searchKaryawans(String keyword) {
        String sql = """
            SELECT k.kd_karyawan, k.nama, j.nama_jabatan, d.nama_departemen, 
                   k.status, k.tanggal_masuk, k.no_ktp, k.no_hp, k.alamat,
                   k.tanggal_mulai_kontrak, k.tanggal_berakhir_kontrak, k.status_kontrak
            FROM karyawan k
            JOIN jabatan j ON k.jabatan_id = j.id_jabatan
            JOIN departemen d ON k.departemen_id = d.id_departemen
            WHERE k.nama LIKE ? 
               OR j.nama_jabatan LIKE ? 
               OR d.nama_departemen LIKE ? 
               OR k.status LIKE ? 
               OR k.tanggal_masuk LIKE ?
               OR k.no_ktp LIKE ?
               OR k.no_hp LIKE ?
        """;
        List<Karyawan> karyawans = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            for (int i = 1; i <= 7; i++) {
                statement.setString(i, "%" + keyword + "%");
            }
            
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Karyawan karyawan = new Karyawan();
                    karyawan.setKdKaryawan(resultSet.getString("kd_karyawan"));   
                    karyawan.setJabatan(resultSet.getString("nama_jabatan"));
                    karyawan.setDepartemen(resultSet.getString("nama_departemen"));
                    karyawan.setStatus(resultSet.getString("status"));
                    karyawan.setTanggalMasuk(resultSet.getDate("tanggal_masuk"));
                    karyawan.setNama(resultSet.getString("nama"));
                    karyawan.setNoKtp(resultSet.getString("no_ktp"));
                    karyawan.setNoHp(resultSet.getString("no_hp"));
                    karyawan.setAlamat(resultSet.getString("alamat"));
                    karyawan.setTanggalMulaiKontrak(resultSet.getDate("tanggal_mulai_kontrak"));
                    karyawan.setTanggalBerakhirKontrak(resultSet.getDate("tanggal_berakhir_kontrak"));
                    karyawan.setStatusKontrak(resultSet.getString("status_kontrak"));
                    
                    karyawans.add(karyawan);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return karyawans;
    }
      
    public boolean insertKaryawan(Karyawan karyawan) {
    String query = "INSERT INTO karyawan (kd_karyawan, nama, jabatan_id, departemen_id, status, "
            + "tanggal_masuk, no_ktp, no_hp, alamat, tanggal_mulai_kontrak, "
            + "tanggal_berakhir_kontrak, status_kontrak) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, karyawan.getKdKaryawan());
        stmt.setString(2, karyawan.getNama());
        stmt.setInt(3, karyawan.getJabatanId());
        stmt.setInt(4, karyawan.getDepartemenId());
        stmt.setString(5, karyawan.getStatus());
        stmt.setDate(6, new java.sql.Date(karyawan.getTanggalMasuk().getTime()));
        stmt.setString(7, karyawan.getNoKtp());
        stmt.setString(8, karyawan.getNoHp());
        stmt.setString(9, karyawan.getAlamat());
        stmt.setDate(10, new java.sql.Date(karyawan.getTanggalMulaiKontrak().getTime()));
        stmt.setDate(11, new java.sql.Date(karyawan.getTanggalBerakhirKontrak().getTime()));
        stmt.setString(12, karyawan.getStatusKontrak());

        int result = stmt.executeUpdate();
        return result > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }
    
    public boolean updateKaryawan(Karyawan karyawan) {
        String updateQuery = "UPDATE karyawan SET nama=?, jabatan_id=?, departemen_id=?, status=?, "
                + "tanggal_masuk=?, no_ktp=?, no_hp=?, alamat=?, tanggal_mulai_kontrak=?, "
                + "tanggal_berakhir_kontrak=?, status_kontrak=? WHERE kd_karyawan=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            
            stmt.setString(1, karyawan.getNama());
            stmt.setInt(2, karyawan.getJabatanId());
            stmt.setInt(3, karyawan.getDepartemenId());
            stmt.setString(4, karyawan.getStatus());
            stmt.setDate(5, new java.sql.Date(karyawan.getTanggalMasuk().getTime()));
            stmt.setString(6, karyawan.getNoKtp());
            stmt.setString(7, karyawan.getNoHp());
            stmt.setString(8, karyawan.getAlamat());
            stmt.setDate(9, new java.sql.Date(karyawan.getTanggalMulaiKontrak().getTime()));
            stmt.setDate(10, new java.sql.Date(karyawan.getTanggalBerakhirKontrak().getTime()));
            stmt.setString(11, karyawan.getStatusKontrak());
            stmt.setString(12, karyawan.getKdKaryawan());

            int result = stmt.executeUpdate();
            return result > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteKaryawan(String kdKaryawan) {
        String query = "DELETE FROM karyawan WHERE kd_karyawan = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, kdKaryawan);
            int result = stmt.executeUpdate();
            return result > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public static List<Karyawan> getAllKaryawanForComboBox() {
        String sql = "SELECT kd_karyawan, nama, jabatan_id FROM karyawan";
        List<Karyawan> karyawans = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Karyawan k = new Karyawan();
                k.setKdKaryawan(rs.getString("kd_karyawan"));
                k.setNama(rs.getString("nama"));
                k.setJabatanId(rs.getInt("jabatan_id"));
                karyawans.add(k);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return karyawans;
    }
  
    public static String getLastKodeKaryawan() {
      String sql = "SELECT kd_karyawan FROM karyawan ORDER BY kd_karyawan DESC LIMIT 1";

      try (Connection conn = DatabaseConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()) {

          if (rs.next()) {
              return rs.getString("kd_karyawan");
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }
  
}
