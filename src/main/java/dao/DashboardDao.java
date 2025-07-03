package dao;

import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Karyawan;

public class DashboardDao {
    
    public static List<Karyawan> getAllKaryawanDashboard() {
        List<Karyawan> karyawans = new ArrayList<>();
        String sql = """
            SELECT k.kd_karyawan, k.nama, j.nama_jabatan, d.nama_departemen, k.status
            FROM karyawan k
            LEFT JOIN jabatan j ON k.jabatan_id = j.id_jabatan
            LEFT JOIN departemen d ON k.departemen_id = d.id_departemen
            ORDER BY k.nama
            """;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Karyawan karyawan = new Karyawan();
                karyawan.setKdKaryawan(rs.getString("kd_karyawan"));
                karyawan.setNama(rs.getString("nama"));
                karyawan.setJabatan(rs.getString("nama_jabatan"));
                karyawan.setDepartemen(rs.getString("nama_departemen"));
                karyawan.setStatus(rs.getString("status"));
                karyawans.add(karyawan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return karyawans;
    }
    
    public static int getTotalKaryawan() {
        String sql = "SELECT COUNT(*) AS total FROM karyawan WHERE status = 'Aktif'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static int getKaryawanMasukHariIni() {
        String sql = """
            SELECT COUNT(DISTINCT kd_karyawan) AS total 
            FROM absensi 
            WHERE DATE(tanggal) = CURRENT_DATE()
            AND status = 'Hadir'
            """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static int getTotalCutiBulanIni() {
        String sql = """
            SELECT COUNT(*) AS total 
            FROM cuti 
            WHERE MONTH(tanggal_mulai) = MONTH(CURRENT_DATE())
            AND YEAR(tanggal_mulai) = YEAR(CURRENT_DATE())
            AND status = 'Disetujui'
            """;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}