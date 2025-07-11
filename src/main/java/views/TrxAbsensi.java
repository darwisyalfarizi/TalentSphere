/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;


import controllers.AbsensiController;

import controllers.KaryawanController;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Absensi;
import models.Karyawan;


/**
 *
 * @author darwisy
 */
public class TrxAbsensi extends javax.swing.JPanel {

    /**
     * Creates new form User
     */
    public TrxAbsensi() {
        initComponents();
        setTableAbsensi();
        loadAbsensi();
        loadComboStatus();
        loadComboKaryawan();
        tambahTanggal.setDate(LocalDate.now());

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        panelMain = new javax.swing.JPanel();
        panelView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelAbsensi = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        panelAdd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnTambahBatal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnTambahReset = new javax.swing.JButton();
        tambahTanggal = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tambahKeterangan = new javax.swing.JTextArea();
        tambahStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tambahKaryawan = new javax.swing.JComboBox<>();
        tambahKd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        panelMain.setLayout(new java.awt.CardLayout());

        panelView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Transaksi > Absensi");
        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel2.setText("Data Absensi");
        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        tabelAbsensi.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tabelAbsensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelAbsensi.setGridColor(new java.awt.Color(204, 204, 204));
        tabelAbsensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelAbsensiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelAbsensi);

        txtSearch.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtSearch.setText("Search...");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.setBackground(new java.awt.Color(81, 108, 248));
        btnTambah.setBorder(null);
        btnTambah.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setBackground(new java.awt.Color(248, 173, 80));
        btnBatal.setBorder(null);
        btnBatal.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setPreferredSize(new java.awt.Dimension(62, 22));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.setBackground(new java.awt.Color(248, 80, 108));
        btnDelete.setBorder(null);
        btnDelete.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setPreferredSize(new java.awt.Dimension(62, 22));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelViewLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(panelViewLayout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        panelMain.add(panelView, "card9");

        panelAdd.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Transaksi > Absensi");
        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel4.setText("Tambah Data Absensi");
        jLabel4.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        btnSimpan.setText("Simpan");
        btnSimpan.setBackground(new java.awt.Color(81, 108, 248));
        btnSimpan.setBorder(null);
        btnSimpan.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTambahBatal.setBackground(new java.awt.Color(248, 173, 80));
        btnTambahBatal.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnTambahBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahBatal.setText("Batal");
        btnTambahBatal.setBorder(null);
        btnTambahBatal.setMaximumSize(new java.awt.Dimension(90, 28));
        btnTambahBatal.setMinimumSize(new java.awt.Dimension(90, 28));
        btnTambahBatal.setPreferredSize(new java.awt.Dimension(90, 28));
        btnTambahBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBatalActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        btnTambahReset.setBackground(new java.awt.Color(51, 51, 51));
        btnTambahReset.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnTambahReset.setForeground(new java.awt.Color(255, 255, 255));
        btnTambahReset.setText("Reset");
        btnTambahReset.setBorder(null);
        btnTambahReset.setMaximumSize(new java.awt.Dimension(90, 28));
        btnTambahReset.setMinimumSize(new java.awt.Dimension(90, 28));
        btnTambahReset.setPreferredSize(new java.awt.Dimension(90, 28));
        btnTambahReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahResetActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama Karyawan");
        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        status.setText("Status");
        status.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        tambahKeterangan.setColumns(20);
        tambahKeterangan.setRows(5);
        jScrollPane2.setViewportView(tambahKeterangan);

        tambahStatus.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel7.setText("Tanggal");
        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel6.setText("Keterangan");
        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        tambahKaryawan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        tambahKd.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setText("Kode Absensi");

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tambahStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(tambahTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                                .addComponent(tambahKaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tambahKd))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 493, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddLayout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnTambahReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnTambahBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambahKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambahKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambahTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambahStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelMain.add(panelAdd, "card9");

        add(panelMain, "card9");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String currentText = btnSimpan.getText();

        switch (currentText) {
            case "Tambah":
                btnSimpan.setText("Simpan");
                break;
            case "Simpan":
                insertData();
                break;

            case "Perbarui":
                updateData();
                break;
        }
        
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        panelMain.removeAll();
        panelMain.add(panelAdd);
        panelMain.repaint();
        panelMain.revalidate();
        
        tambahTanggal.setDate(LocalDate.now());

        
        if (btnTambah.getText().equals("Ubah")) {
            dataTable(); 
            btnSimpan.setText("Perbarui");
            tambahKd.setEditable(false);
        } else {
            resetForm(); 
            btnSimpan.setText("Simpan");
            tambahKd.setText(generateKodeAbsensi());
            tambahKd.setEditable(false);
            tambahTanggal.setDate(LocalDate.now());

        }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTambahBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBatalActionPerformed
        showPanelView();
        loadAbsensi();
        resetForm();
        if(btnTambah.getText().equals("Ubah")){
            btnTambah.setText("Tambah");
        }
    }//GEN-LAST:event_btnTambahBatalActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        searchData();
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnTambahResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnTambahResetActionPerformed

    private void tabelAbsensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelAbsensiMouseClicked
        if(btnTambah.getText().equals("Tambah")){
            btnTambah.setText("Ubah");
        }
        btnBatal.setVisible(true);
        btnDelete.setVisible(true);
    }//GEN-LAST:event_tabelAbsensiMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        showPanelView();
        loadAbsensi();
        resetForm();
         if(btnTambah.getText().equals("Ubah")){
            btnTambah.setText("Tambah");
        }
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteData();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambahBatal;
    private javax.swing.JButton btnTambahReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JLabel status;
    private javax.swing.JTable tabelAbsensi;
    private javax.swing.JComboBox<Karyawan> tambahKaryawan;
    private javax.swing.JTextField tambahKd;
    private javax.swing.JTextArea tambahKeterangan;
    private javax.swing.JComboBox<String> tambahStatus;
    private com.github.lgooddatepicker.components.DatePicker tambahTanggal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    
    private void showPanelView(){
        panelMain.removeAll();
        panelMain.add(panelView);
        btnBatal.setVisible(false);
        btnDelete.setVisible(false);
        panelMain.repaint();
        panelMain.revalidate();
    }
    
    private void loadAbsensi() {
        btnBatal.setVisible(false);
        btnDelete.setVisible(false);
        AbsensiController absensiController = new AbsensiController();
        List<Absensi> absensis = absensiController.getAllAbsensi();

        DefaultTableModel model = (DefaultTableModel)tabelAbsensi.getModel(); 
        model.setRowCount(0);

        if (absensis != null) {
            int number = 1;
            for (Absensi absensi : absensis) {
                model.addRow(new Object[]{
                    number++,
                    absensi.getKdAbsensi(),
                    absensi.getKaryawan(),
                    absensi.getTanggal(),
                    absensi.getStatus(),
                    absensi.getKeterangan(),
                });
            }
        }
    }

    private void setTableAbsensi() {
        DefaultTableModel model = new DefaultTableModel() {
        @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        model.addColumn("No");
        model.addColumn("Kode Absensi");
        model.addColumn("Nama Karyawan");
        model.addColumn("Tanggal");
        model.addColumn("Status");
        model.addColumn("Keterangan");
        
        tabelAbsensi.setModel(model);
        tabelAbsensi.getColumnModel().getColumn(0).setPreferredWidth(10);   
        tabelAbsensi.getColumnModel().getColumn(1).setPreferredWidth(80);   
        tabelAbsensi.getColumnModel().getColumn(2).setPreferredWidth(150);  
        tabelAbsensi.getColumnModel().getColumn(3).setPreferredWidth(120);  
        tabelAbsensi.getColumnModel().getColumn(4).setPreferredWidth(150);  
        tabelAbsensi.getColumnModel().getColumn(5).setPreferredWidth(100);  

    }

    private void resetForm() {
         
        
        tambahKeterangan.setText("");
        // Reset combo boxes
        tambahKaryawan.setSelectedIndex(0);
        tambahStatus.setSelectedIndex(0);
        
        // Reset date pickers
        tambahTanggal.setDate(LocalDate.now());

       
        // Reset focus
        tambahKaryawan.requestFocusInWindow();
    }
    
    private void searchData() {
        String keyword = txtSearch.getText();
        AbsensiController absensiController = new AbsensiController();
        List<Absensi> absensis = absensiController.searchAbsensis(keyword);

        DefaultTableModel model = (DefaultTableModel) tabelAbsensi.getModel();
        model.setRowCount(0);

        int number = 1;
        for (Absensi absensi : absensis) {
            model.addRow(new Object[]{
                number++,
                absensi.getKdAbsensi(), 
                absensi.getKaryawan(),
                absensi.getTanggal(),
                absensi.getStatus(),
                absensi.getKeterangan(),
            });
        }
    }

    private void dataTable() {
        panelView.setVisible(false);
        panelAdd.setVisible(true);

        int row = tabelAbsensi.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data karyawan terlebih dahulu!");
            return;
        }

        jLabel4.setText("Ubah Data Absensi");

        // Get ID from column 1 (since column 0 is now the numbering)
        tambahKd.setText(tabelAbsensi.getValueAt(row, 1).toString());

        // Set basic fields
        tambahKeterangan.setText(tabelAbsensi.getValueAt(row, 5).toString());

        // Set combo boxes
        setComboFromTable(tambahKaryawan, tabelAbsensi.getValueAt(row, 2).toString());
        setComboFromTable(tambahStatus, tabelAbsensi.getValueAt(row, 4).toString());

        // Set dates
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Handle possible null dates
            if (tabelAbsensi.getValueAt(row, 3) != null) {
                Date tgl = sdf.parse(tabelAbsensi.getValueAt(row, 3).toString());
                tambahTanggal.setDate(tgl.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error parsing dates: " + ex.getMessage());
            ex.printStackTrace();
        }

        btnSimpan.setText("Perbarui");
    }

    private void insertData() {
        try {
            // Get values
            String keterangan = tambahKeterangan.getText();
            String kdAbsensi = tambahKd.getText();
            Karyawan selectedKaryawan = (Karyawan) tambahKaryawan.getSelectedItem();
            String status = (String) tambahStatus.getSelectedItem();

            // Validate
            if (selectedKaryawan == null || tambahTanggal.getDate() == null) {
                JOptionPane.showMessageDialog(this, 
                    "Pilih Karyawan dan tanggal!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create Absensi
            Absensi absensi = new Absensi();
            absensi.setKdAbsensi(kdAbsensi);
            absensi.setKeterangan(keterangan);
            absensi.setKdKaryawan(selectedKaryawan.getKdKaryawan()); // Use setIdKaryawan()
            absensi.setStatus(status);

            // Convert LocalDate to java.sql.Date
            LocalDate localDate = tambahTanggal.getDate();
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
            absensi.setTanggal(sqlDate);

            // Save
            AbsensiController controller = new AbsensiController();
            if (controller.insertAbsensi(absensi)) {
                JOptionPane.showMessageDialog(this, "Absensi berhasil ditambahkan!");
                loadAbsensi();
                showPanelView();
                btnTambah.setText("Tambah");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan Absensi.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void updateData() {
        try {
            // Get values
            String kdAbsensi = tambahKd.getText();
            String keterangan = tambahKeterangan.getText();
            Karyawan selectedKaryawan = (Karyawan) tambahKaryawan.getSelectedItem();
            String status = (String) tambahStatus.getSelectedItem();

            // Validate
            if (selectedKaryawan == null || tambahTanggal.getDate() == null || kdAbsensi.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Data tidak lengkap! Pastikan memilih karyawan, tanggal dan ID tersedia", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create Absensi
            Absensi absensi = new Absensi();
            absensi.setKdAbsensi(kdAbsensi); // THIS WAS MISSING
            absensi.setKeterangan(keterangan);
            absensi.setKdKaryawan(selectedKaryawan.getKdKaryawan());
            absensi.setStatus(status);

            // Convert LocalDate to java.sql.Date
            LocalDate localDate = tambahTanggal.getDate();
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
            absensi.setTanggal(sqlDate);

            // Update
            AbsensiController controller = new AbsensiController();
            if (controller.updateAbsensi(absensi)) {
                JOptionPane.showMessageDialog(this, "Absensi berhasil diperbarui!");
                loadAbsensi();
                showPanelView();
                btnTambah.setText("Tambah");
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Gagal memperbarui absensi. Periksa data atau koneksi database.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    } 

    private void deleteData() {
        int selectedRow = tabelAbsensi.getSelectedRow();
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda ingin menghapus data ini ?",
                "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Now kdAbsensi is in column 1 (column 0 is the numbering)
                String kdAbsensi = tabelAbsensi.getValueAt(selectedRow, 1).toString();

                AbsensiController absensiController = new AbsensiController();
                boolean success = absensiController.deleteAbsensi(kdAbsensi);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    loadAbsensi(); 
                    resetForm(); 
                    showPanelView();
                    btnTambah.setText("Tambah");
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadComboKaryawan() {
        KaryawanController controller = new KaryawanController();
        List<Karyawan> karyawanList = controller.getAllKaryawanForComboBox();

        tambahKaryawan.removeAllItems();
        tambahKaryawan.addItem(new Karyawan()); // Opsi kosong

        for (Karyawan karyawan : karyawanList) {
            tambahKaryawan.addItem(karyawan);
        }
    }

    private void loadComboStatus() {
            tambahStatus.removeAllItems();
            tambahStatus.addItem("Hadir");
            tambahStatus.addItem("Izin");
            tambahStatus.addItem("Sakit");
            tambahStatus.addItem("Alpa");
     }

    private void setComboFromTable(JComboBox<?> combo, String value) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            Object item = combo.getItemAt(i);
            String displayValue = item.toString(); // Works for both String and objects with toString()
            if (displayValue.equalsIgnoreCase(value)) {
                combo.setSelectedIndex(i);
                return;
            }
        }
        // If not found, select first item or none
        if (combo.getItemCount() > 0) {
            combo.setSelectedIndex(0);
        }
    }

    private String generateKodeAbsensi() { 
        AbsensiController controller = new AbsensiController();
        String lastKode = controller.getLastKodeAbsensi();

        if (lastKode == null || lastKode.isEmpty()) {
            return "ABS-001"; // If no employees exist yet
        }

        try {
            // Extract the numeric part
            String numericPart = lastKode.split("-")[1];
            int number = Integer.parseInt(numericPart);

            // Increment and format with leading zeros
            return String.format("ABS-%03d", number + 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error generating employee code: " + e.getMessage());
            return "ABS-001"; // Fallback
        }
    }
    
    

}
