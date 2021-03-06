/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.ui;

import com.init.tools.DaoFactory;
import com.yud.pelanggan.Pelanggan;
import com.yud.pelanggan.PelangganTabelModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author legollas
 */
public class PelangganForm extends javax.swing.JFrame {

    private TableRowSorter<TableModel> rowSorter = null;
    private RowSorter<TableModel> sorter = null;
    private TableRowSorter<TableModel> sorter2 = null;

    /**
     * Creates new form PelangganForm
     */
    public PelangganForm() {
        initComponents();
        setLocationRelativeTo(null);
        showpelanggans();
    }

    private void clearfield() {
        txtKodePelanggan.setText("");
        txtNamaPelanggan.setText("");
        txtAlamatPelanggan.setText("");
        txtTelepon.setText("");
        txtmankodepel.setText("");
    }

    private void showpelanggans() {
        PelangganTabelModel pelangganTabelModel = new PelangganTabelModel(DaoFactory.getPelangganDao().getAllPelanggan());
        pelanggantabel.setRowMargin(0);
        rowSorter = new TableRowSorter<TableModel>(pelangganTabelModel);
        pelanggantabel.setModel(pelangganTabelModel);
        pelanggantabel.setRowSorter(rowSorter);
        pelanggantabel.getColumnModel().getColumn(0).setPreferredWidth(50);
        pelanggantabel.getColumnModel().getColumn(1).setPreferredWidth(100);
        pelanggantabel.getColumnModel().getColumn(2).setPreferredWidth(200);
        pelanggantabel.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKodePelanggan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNamaPelanggan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamatPelanggan = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        pelanggantabel = new javax.swing.JTable();
        simpanbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        hapusbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmankodepel = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MASTER DATA PELANGGAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(284, 284, 284))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Data Pelanggan"));

        jLabel2.setText("Kode Pelanggan");

        txtKodePelanggan.setEditable(false);

        jLabel3.setText("Nama Pelanggan");

        jLabel4.setText("Alamat Pelanggan");

        txtAlamatPelanggan.setColumns(20);
        txtAlamatPelanggan.setRows(5);
        jScrollPane1.setViewportView(txtAlamatPelanggan);

        jLabel5.setText("Telepon");

        pelanggantabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Pelanggan", "Alamat", "Telepon"
            }
        ));
        pelanggantabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelanggantabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pelanggantabel);

        simpanbutton.setText("Simpan");
        simpanbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbuttonActionPerformed(evt);
            }
        });

        updatebutton.setText("Update");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        hapusbutton.setText("Hapus");
        hapusbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbuttonActionPerformed(evt);
            }
        });

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Cari");

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        jLabel7.setText("Ref. Pelanggan");

        jButton2.setText("Cetak");

        jButton3.setText("Keluar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(txtNamaPelanggan))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtTelepon)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(hapusbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(updatebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(simpanbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(6, 6, 6))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKodePelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtmankodepel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFilter)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtmankodepel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpanbutton)
                            .addComponent(updatebutton)
                            .addComponent(hapusbutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbuttonActionPerformed
        // TODO add your handling code here:
        String kodeelangganexist = txtKodePelanggan.getText();
        int kode = 0;
        boolean status = false;
        if (!kodeelangganexist.equalsIgnoreCase("")) {
            kode = Integer.parseInt(kodeelangganexist);
            status = new Pelanggan().cekpelanggan(kode);
        }
        if (status == false) {
            if (!"".equals(txtNamaPelanggan.getText())) {
                String namapelanggan = txtNamaPelanggan.getText();
                String manualkodepelanggan = txtmankodepel.getText();
                String alamat = txtAlamatPelanggan.getText();
                String telepon = txtTelepon.getText();
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setKodemanualpelanggan(manualkodepelanggan);
                pelanggan.setNamaPelanggan(namapelanggan);
                pelanggan.setAlamatpelanggan(alamat);
                pelanggan.setTelepon(telepon);
                DaoFactory.getPelangganDao().insertPelanggan(pelanggan);
                showpelanggans();
                clearfield();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data Sudah Ada");
        }

    }//GEN-LAST:event_simpanbuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Yakin akan mengupdate data?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (result == 0) {
            if (txtKodePelanggan.getText() != "" && txtNamaPelanggan.getText() != "") {
                String kode = txtKodePelanggan.getText();
                String nama = txtNamaPelanggan.getText();
                String alamat = txtAlamatPelanggan.getText();
                String telepon = txtTelepon.getText();
                String mankodepel = txtmankodepel.getText();
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setKodemanualpelanggan(mankodepel);
                pelanggan.setIdPelanggan(Integer.parseInt(kode));
                pelanggan.setNamaPelanggan(nama);
                pelanggan.setAlamatpelanggan(alamat);
                pelanggan.setTelepon(telepon);
                DaoFactory.getPelangganDao().updatePelanggan(pelanggan);
                showpelanggans();
                clearfield();
            }
        }

    }//GEN-LAST:event_updatebuttonActionPerformed

    private void hapusbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbuttonActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Yakin akan mengapus data?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        if (result == 0) {
            if (!txtKodePelanggan.getText().equalsIgnoreCase("")) {
                String kodepelanggan = txtKodePelanggan.getText();
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(Integer.parseInt(kodepelanggan));
                DaoFactory.getPelangganDao().deletePelanggan(pelanggan);
                showpelanggans();
                clearfield();
            }
        }

    }//GEN-LAST:event_hapusbuttonActionPerformed

    private void pelanggantabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelanggantabelMouseClicked
        // TODO add your handling code here:
        int row = pelanggantabel.getSelectedRow();
        if (row >= 0) {
            txtKodePelanggan.setText(String.valueOf(pelanggantabel.getValueAt(row, 0)));
            txtmankodepel.setText(String.valueOf(pelanggantabel.getValueAt(row, 1)));
            txtNamaPelanggan.setText(String.valueOf(pelanggantabel.getValueAt(row, 2)));
            txtAlamatPelanggan.setText(String.valueOf(pelanggantabel.getValueAt(row, 3)));
            txtTelepon.setText(String.valueOf(pelanggantabel.getValueAt(row, 4)));
        }
    }//GEN-LAST:event_pelanggantabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearfield();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        // TODO add your handling code here:
        String text = txtFilter.getText();
        if (text.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            //System.out.println("y");
            rowSorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txtFilterKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PelangganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PelangganForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapusbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable pelanggantabel;
    private javax.swing.JButton simpanbutton;
    private javax.swing.JTextArea txtAlamatPelanggan;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtKodePelanggan;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtmankodepel;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
