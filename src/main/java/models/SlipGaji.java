package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SlipGaji {
    private String kdSlip;  
    private String kdKaryawan;
    private Date periode;
    private BigDecimal gajiPokok;
    private BigDecimal totalTambahan;
    private BigDecimal totalPengurangan;
    private BigDecimal gajiBersih;
    private List<DetailGaji> details;
    private String karyawan;
    
    // Constructor kosong
    public SlipGaji() {
        this.gajiPokok = BigDecimal.ZERO;
        this.totalTambahan = BigDecimal.ZERO;
        this.totalPengurangan = BigDecimal.ZERO;
        this.gajiBersih = BigDecimal.ZERO;
        
    }
    
    // Constructor dengan parameter
    public SlipGaji(String kdSlip, String kdKaryawan, Date periode, BigDecimal gajiPokok) {
        this();
        this.kdSlip = kdSlip;
        this.kdKaryawan = kdKaryawan;
        this.periode = periode;
        this.gajiPokok = gajiPokok != null ? gajiPokok : BigDecimal.ZERO;
        this.gajiBersih = this.gajiPokok;
    }
    
    // Getter dan Setter
    public String getKdSlip() {
        return kdSlip;
    }
    
    public void setKdSlip(String kdSlip) {
        this.kdSlip = kdSlip;
    }
    
    public String getKdKaryawan() {
        return kdKaryawan;
    }
    
    public void setKdKaryawan(String kdKaryawan) {
        this.kdKaryawan = kdKaryawan;
    }
    
    public Date getPeriode() {
        return periode;
    }
    
    public void setPeriode(Date periode) {
        this.periode = periode;
    }
    
    public BigDecimal getGajiPokok() {
        return gajiPokok;
    }
    
    public void setGajiPokok(BigDecimal gajiPokok) {
        this.gajiPokok = gajiPokok != null ? gajiPokok : BigDecimal.ZERO;
    }
    
    public BigDecimal getTotalTambahan() {
        return totalTambahan;
    }
    
    public void setTotalTambahan(BigDecimal totalTambahan) {
        this.totalTambahan = totalTambahan != null ? totalTambahan : BigDecimal.ZERO;
    }
    
    public BigDecimal getTotalPengurangan() {
        return totalPengurangan;
    }
    
    public void setTotalPengurangan(BigDecimal totalPengurangan) {
        this.totalPengurangan = totalPengurangan != null ? totalPengurangan : BigDecimal.ZERO;
    }
    
    public BigDecimal getGajiBersih() {
        return gajiBersih;
    }
    
    public void setGajiBersih(BigDecimal gajiBersih) {
        this.gajiBersih = gajiBersih != null ? gajiBersih : BigDecimal.ZERO;
    }
    
    public List<DetailGaji> getDetails() {
        return details;
    }
    
    public void setDetails(List<DetailGaji> details) {
        this.details = details;
    }
    
    
    public void hitungGajiBersih() {
        this.gajiBersih = this.gajiPokok
                .add(this.totalTambahan)
                .subtract(this.totalPengurangan);
    }
    
    @Override
    public String toString() {
        return "SlipGaji{" +
                "kdSlip='" + kdSlip + '\'' +
                ", kdKaryawan=" + kdKaryawan +
                ", periode=" + periode +
                ", gajiPokok=" + gajiPokok +
                ", totalTambahan=" + totalTambahan +
                ", totalPengurangan=" + totalPengurangan +
                ", gajiBersih=" + gajiBersih +
                '}';
    }
    
    public void setKaryawan(String karyawan) { 
        this.karyawan = karyawan; 
    }
    
    public String getKaryawan() { 
        return karyawan; 
    }
}