package models;

import java.math.BigDecimal;

public class DetailGaji {
    private String kdDetail;
    private String kdSlip;
    private String jenis;
    private String deskripsi;
    private boolean isTambah; // true untuk tambahan, false untuk pengurangan
    private BigDecimal jumlah;  // Changed from double to BigDecimal
    
    

    public String getkdDetail() {
        return kdDetail;
    }

    public void setkdDetail(String kdDetail) {
        this.kdDetail = kdDetail;
    }

    public String getKdSlip() {
        return kdSlip;
    }

    public void setKdSlip(String kdSlip) {
        this.kdSlip = kdSlip;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public boolean isIsTambah() {
        return isTambah;
    }

    public void setIsTambah(boolean isTambah) {
        this.isTambah = isTambah;
    }
    
     public int getIsTambahAsInt() {
        return isTambah ? 1 : 0;
    }
    

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }
 
    
    @Override
    public String toString() {
        return "DetailGaji{" +
                "kdDetail=" + kdDetail +
                ", kdSlip='" + kdSlip + '\'' +
                ", jenis='" + jenis + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", isTambah=" + isTambah +
                ", jumlah=" + jumlah +
                '}';
    }
}