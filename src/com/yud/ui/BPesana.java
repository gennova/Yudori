/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yud.ui;

import com.init.tools.AutoCompletion;
import com.init.tools.DaoFactory;
import com.init.tools.PrintReport;
import com.yud.barang.Barang;
import com.yud.barang.BarangTabelModelSimple;
import com.yud.pelanggan.Pelanggan;
import com.yud.pelanggan.PelangganTabelModel;
import com.yud.sales.Sales;
import com.yud.stb.BuktiPesanan;
import com.yud.stb.BuktiPesananTabelModel;
import com.yud.stb.OrderTemp;
import com.yud.stb.OrderTempTabelModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author legollassetd
 */
public class BPesana extends javax.swing.JFrame {

    /**
     * Creates new form BPesana
     */
    private RowSorter<TableModel> sorter = null;
    private TableRowSorter<TableModel> sorter2 = null;

    public BPesana() {
        initComponents();
        setLocationRelativeTo(null);
        loadform();
    }

    private void loadform() {
        setCalenar();
        jInternalFrame1.setVisible(false);
        tunaicheckbox.setSelected(true);
        txtkodefaktur.setText(DaoFactory.getIDUrutPesanan());        
        tampilsaleskombo();
        showordertemp();
        DaoFactory.getOrderTempDao().truncateordertemp();
        loadpelanggan();
        AutoCompletion.enable(txtnama);
        jDesktopPane1.setVisible(true);
        jDesktopPane2.setVisible(false);
    }

    private void loadpelanggan() {
        txtnama.removeAllItems();
        List<Pelanggan> pelanggans = DaoFactory.getPelangganDao().getAllPelanggan();
        for (int i = 0; i < pelanggans.size(); i++) {
            Pelanggan p = pelanggans.get(i);
            txtnama.addItem(p.getNamaPelanggan());
        }
    }

    private void tampilsaleskombo() {
        kombosales.removeAllItems();
        List<Sales> list = DaoFactory.getSalesDao().getAllSales();
        for (int i = 0; i < list.size(); i++) {
            Sales s = new Sales();
            s = list.get(i);
            kombosales.addItem(s.getnamaSales());
        }
    }

    private void setCalenar() {
        GregorianCalendar gc = new GregorianCalendar();
        tglPesananDate.setDate(gc.getTime());
        tglPenagihanDate.setDate(gc.getTime());
        tglPengirimanDate.setDate(gc.getTime());
    }

    private void showbarang() {
        BarangTabelModelSimple barangTabelModel = new BarangTabelModelSimple(DaoFactory.getBarangDao().getAllBarang());
        sorter2 = new TableRowSorter<TableModel>(barangTabelModel);
        TabelBarang.setRowMargin(0);
        sorter = new TableRowSorter<TableModel>(barangTabelModel);
        TabelBarang.setModel(barangTabelModel);
        TabelBarang.setRowSorter(sorter2);
        //TabelBarang.setAutoResizeMode(0);
        TabelBarang.getColumnModel().getColumn(0).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void showbuktipesanan() {
        BuktiPesananTabelModel bptab = new BuktiPesananTabelModel(DaoFactory.getBuktiPesananDao().getAllBuktiPesanan());
        sorter2 = new TableRowSorter<TableModel>(bptab);
        TabelBSTU.setRowMargin(0);
        TabelBSTU.setModel(bptab);
        TabelBSTU.setRowSorter(sorter2);
        //TabelBarang.setAutoResizeMode(0);
        TabelBSTU.getColumnModel().getColumn(0).setPreferredWidth(50);
        TabelBSTU.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelBSTU.getColumnModel().getColumn(4).setPreferredWidth(150);
        TabelBSTU.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void showpelanggans() {
        //BarangTabelModelSimple barangTabelModel = new BarangTabelModelSimple(DaoFactory.getBarangDao().getAllBarang());
        BarangTabelModelSimple barangTabelModel = new BarangTabelModelSimple(DaoFactory.getBarangDao().getAllBarang());
        PelangganTabelModel model = new PelangganTabelModel(DaoFactory.getPelangganDao().getAllPelanggan());

    }

    private void showordertemp() {
        OrderTempTabelModel ottm = new OrderTempTabelModel(DaoFactory.getOrderTempDao().getAllOrderTemo());
        sorter = new TableRowSorter<TableModel>(ottm);
        TabelOrder.setRowMargin(0);
        sorter = new TableRowSorter<TableModel>(ottm);
        TabelOrder.setModel(ottm);
        TabelOrder.setRowSorter(sorter);
        //TabelBarang.setAutoResizeMode(0);
        TabelOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
        TabelOrder.getColumnModel().getColumn(1).setPreferredWidth(100);
        TabelOrder.getColumnModel().getColumn(2).setPreferredWidth(100);
        TabelOrder.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kategoriorder = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txttelepon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tglPesananDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        tglPenagihanDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tglPengirimanDate = new com.toedter.calendar.JDateChooser();
        txtisicekboxlainnya = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtkodebarang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelOrder = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtUM = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel12 = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelBarang = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtnamabarang = new javax.swing.JLabel();
        okOrder = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtunit = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        batalbutton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtAngsuran = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        txtSisa1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        tunaicheckbox = new javax.swing.JRadioButton();
        dropcheckbox = new javax.swing.JRadioButton();
        laincheckbox = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        kombosales = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtkomisi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtkodebp = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        txtManualKodePelanggan = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtkodemanualbp = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtnama = new javax.swing.JComboBox<>();
        txtkodefaktur = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        textFilterbstu = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelBSTU = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bukti Pesanan");
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BUKTI PESANAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setText("Nama :");

        jLabel2.setText("Alamat / Wilayah");

        txtalamat.setColumns(20);
        txtalamat.setLineWrap(true);
        txtalamat.setRows(5);
        txtalamat.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtalamat);

        jLabel3.setText("Telepon");

        jLabel4.setText("Tgl. Pesanan");

        jLabel5.setText("Tgl. Penagihan");

        jLabel6.setText("Tgl Pengiriman");

        txtisicekboxlainnya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtisicekboxlainnyaKeyTyped(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Pesanan"));

        jLabel8.setText("Kode Barang");

        txtkodebarang.setEditable(false);
        txtkodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodebarangActionPerformed(evt);
            }
        });
        txtkodebarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkodebarangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkodebarangKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkodebarangKeyTyped(evt);
            }
        });

        TabelOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Nama Barang", "Unit", "Harga"
            }
        ));
        jScrollPane2.setViewportView(TabelOrder);

        jLabel9.setText("Total");

        jLabel10.setText("UM");

        jLabel11.setText("Sisa");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/save32.png"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/door.png"))); // NOI18N
        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Cari Barang");
        jInternalFrame1.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, -1, -1));

        filterText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filterTextKeyTyped(evt);
            }
        });
        jInternalFrame1.getContentPane().add(filterText, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 0, 380, -1));

        TabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode", "Nama Barang"
            }
        ));
        TabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelBarangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelBarang);

        jInternalFrame1.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 480, 210));

        jButton3.setText("Tutup");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jInternalFrame1.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 110, -1));

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtnamabarang.setText("............................");

        okOrder.setText("Ok");
        okOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okOrderActionPerformed(evt);
            }
        });

        jLabel13.setText("Unit");

        jLabel14.setText("Harga");

        batalbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/analyze.png"))); // NOI18N
        batalbutton.setText("Batal");
        batalbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalbuttonActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/delete.png"))); // NOI18N
        jButton9.setText("Hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Angsuran");

        txtAngsuran.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Code/Name/Flamboyan/Files/settings.png"))); // NOI18N
        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        txtSisa1.setEditable(false);
        txtSisa1.setToolTipText("Harga Promosi Tunai");

        jButton5.setText("-");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batalbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(29, 29, 29)
                                .addComponent(txtAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtUM, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSisa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInternalFrame1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(txtnamabarang)
                            .addComponent(okOrder)
                            .addComponent(jLabel13)
                            .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtSisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAngsuran)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(batalbutton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel11)
                        .addGap(75, 75, 75)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        kategoriorder.add(tunaicheckbox);
        tunaicheckbox.setText("Tunai");
        tunaicheckbox.setOpaque(false);

        kategoriorder.add(dropcheckbox);
        dropcheckbox.setText("Drop A1");
        dropcheckbox.setOpaque(false);

        kategoriorder.add(laincheckbox);
        laincheckbox.setText("INDENT");
        laincheckbox.setOpaque(false);

        jLabel15.setText("Sales");

        kombosales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Komisi Sales");

        jLabel17.setText("%");

        jLabel19.setText("Kode Bukti Pesanan");

        txtkodebp.setEditable(false);

        jButton6.setText("Daftar BP");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtManualKodePelanggan.setEditable(false);
        txtManualKodePelanggan.setToolTipText("Kode Pelanggan");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("REFERENSI KODE BP MANUAL");

        txtnama.setEditable(true);
        txtnama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnamaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnamaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel19))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(tglPesananDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttelepon)
                                    .addComponent(txtkodebp)
                                    .addComponent(txtnama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6)
                                            .addComponent(txtManualKodePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(38, 38, 38))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tglPengirimanDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tglPenagihanDate, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtkodefaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kombosales, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtkomisi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17))
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(laincheckbox)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtisicekboxlainnya, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tunaicheckbox)
                                    .addComponent(dropcheckbox)
                                    .addComponent(txtkodemanualbp))
                                .addGap(97, 97, 97))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(19, 19, 19))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtkodefaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(txtkodebp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel16)
                                            .addComponent(txtkomisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17)
                                            .addComponent(txtManualKodePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(kombosales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tglPesananDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tglPenagihanDate, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtkodemanualbp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglPengirimanDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tunaicheckbox)
                        .addGap(3, 3, 3)
                        .addComponent(dropcheckbox)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtisicekboxlainnya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(laincheckbox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane2.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDesktopPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("DAFTAR BUKTI PESANAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(404, 404, 404))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        jLabel20.setText("Cari");

        textFilterbstu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFilterbstuKeyReleased(evt);
            }
        });

        TabelBSTU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Kode BP", "Nama", "Jumlah"
            }
        ));
        jScrollPane4.setViewportView(TabelBSTU);

        jButton7.setText("Keluar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Pilih");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setText("Cetak");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFilterbstu))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textFilterbstu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton10))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jDesktopPane2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1230, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jInternalFrame1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtkodebarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodebarangKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtkodebarangKeyTyped

    private void txtkodebarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodebarangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodebarangKeyReleased

    private void txtkodebarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodebarangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodebarangKeyPressed

    private void txtkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodebarangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtkodebarangActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code he
        showbarang();
        jInternalFrame1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelBarangMouseClicked
        // TODO add your handling code here:
        int row = TabelBarang.getSelectedRow();
        if (row >= 0) {
            txtkodebarang.setText(String.valueOf(TabelBarang.getValueAt(row, 0)));
            txtnamabarang.setText(String.valueOf(TabelBarang.getValueAt(row, 1)));
            Barang b = DaoFactory.getBarangDao().getBarangByID(Integer.parseInt(TabelBarang.getValueAt(row, 0).toString()));
            if (tunaicheckbox.isSelected() == true) {
                txtharga.setText(String.valueOf(TabelBarang.getValueAt(row, 2)));
            } else if (dropcheckbox.isSelected() == true) {
                txtharga.setText(String.valueOf(b.getHargadrop()));
            } else if (laincheckbox.isSelected() == true) {
                if ("".equals(txtisicekboxlainnya.getText())) {
                    txtharga.setText(String.valueOf(b.getHargaindent()));
                } else {
                    txtharga.setText(txtisicekboxlainnya.getText());
                }
            }
        }
        jInternalFrame1.setVisible(false);
        txtunit.requestFocus();
    }//GEN-LAST:event_TabelBarangMouseClicked

    private void filterTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextKeyTyped
        // TODO add your handling code here:
        String text = filterText.getText();
        if (text.length() == 0) {
            sorter2.setRowFilter(null);
        } else {
            System.out.println("y");
            sorter2.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_filterTextKeyTyped

    private void okOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okOrderActionPerformed
        // TODO add your handling code here:

        if (txtkodebarang.getText().length() > 0) {
            if ("".equals(txtunit.getText())) {
                JOptionPane.showMessageDialog(null, "Data Unit Belum Diisi");
            } else {
                String kodebarang = txtkodebarang.getText();
                String namabarang = txtnamabarang.getText();
                String unit = txtunit.getText();
                String harga = txtharga.getText();
                String hargabaru = "";
                String kodepesanan = "";
                if (txtkodebp.getText().equalsIgnoreCase("")) {
                    kodepesanan = txtkodefaktur.getText();
                } else {
                    kodepesanan = txtkodebp.getText();
                }

                if (tunaicheckbox.isSelected()) {
                    hargabaru = String.valueOf(DaoFactory.getBarangDao().getBarangByID(Integer.parseInt(kodebarang)).getHargatunai());
                } else if (dropcheckbox.isSelected()) {
                    hargabaru = String.valueOf(DaoFactory.getBarangDao().getBarangByID(Integer.parseInt(kodebarang)).getHargadrop());
                } else if (dropcheckbox.isSelected()) {
                    hargabaru = txtisicekboxlainnya.getText();
                } else {
                    hargabaru = txtharga.getText();
                }
                int kodebarangnya = Integer.parseInt(kodebarang);
                int unitnya = Integer.parseInt(unit);
                int harganya = Integer.parseInt(hargabaru);
                int total = unitnya * harganya;
                OrderTemp orderTemp = new OrderTemp();
                orderTemp.setKodeBarang(kodebarangnya);
                orderTemp.setNamaBarang(namabarang);
                orderTemp.setUnit(unitnya);
                orderTemp.setHarga(harganya);
                orderTemp.setTotal(total);
                orderTemp.setKodepesanan(kodepesanan);
                DaoFactory.getOrderTempDao().insertordertemp(orderTemp);
                showordertemp();
                Barang b = DaoFactory.getBarangDao().getBarangByID(kodebarangnya);
                txttotal.setText(String.valueOf(DaoFactory.getOrderTempDao().getSumOrder(kodepesanan)));
                txtUM.setText(String.valueOf(b.getUM()));
                txtSisa.setText(String.valueOf(b.getSisa1()));
                txttotal.setText(String.valueOf(total));
                txtAngsuran.setText(String.valueOf(b.getSisa2()));
                String a = String.valueOf(b.getHargapromosi());
                txtSisa1.setText(String.valueOf(b.getHargapromosi()));
                System.out.println(a);
            }
        }
        cleardetailfield();
    }//GEN-LAST:event_okOrderActionPerformed

    private void batalbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalbuttonActionPerformed
        // TODO add your handling code here:
        DaoFactory.getOrderTempDao().truncateordertemp();
        loadform();
        txttotal.setText("");
        txtUM.setText("");
        txtSisa.setText("");
        cleardetailfield();
        cleardetailfieldall();
        setCalenar();
    }//GEN-LAST:event_batalbuttonActionPerformed

    private void cleardetailfield() {
        txtkodebarang.setText("");
        txtnamabarang.setText("............................");
        txtunit.setText("");
        txtharga.setText("");
    }

    private void cleardetailfieldall() {
        txtkodebarang.setText("");
        txtkodebp.setText("");
        txtnamabarang.setText("............................");
        txtunit.setText("");
        txtharga.setText("");
        txtnama.setSelectedIndex(0);
        txtalamat.setText("");
        txttelepon.setText("");
        txtkomisi.setText("");
        txtisicekboxlainnya.setText("");
        txtAngsuran.setText("");
        txtSisa1.setText("");
        txtkodemanualbp.setText("");
    }
    private void txtisicekboxlainnyaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtisicekboxlainnyaKeyTyped
        // TODO add your handling code here:
        txtharga.setText(txtisicekboxlainnya.getText());
    }//GEN-LAST:event_txtisicekboxlainnyaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String kodebp = txtkodebp.getText();
        boolean status = new BuktiPesanan().cekbp(kodebp);
        if (status == false) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String kodemanualbp = txtkodemanualbp.getText();
            String kodemanualpel = txtManualKodePelanggan.getText();
            String namapelanggan = txtnama.getSelectedItem().toString();
            String alamat = txtalamat.getText();
            String telepon = txttelepon.getText();
            String tglPesanan = df.format(tglPesananDate.getDate());
            String tglPenagihan = df.format(tglPenagihanDate.getDate());
            String tglPengiriman = df.format(tglPengirimanDate.getDate());
            String namaSales = kombosales.getSelectedItem().toString();
            int komisisales = Integer.parseInt(txtkomisi.getText());
            String statusorder = "";
            if (tunaicheckbox.isSelected()) {
                statusorder = "TUNAI";
            } else if (dropcheckbox.isSelected()) {
                statusorder = "DROP A1";
            } else if (laincheckbox.isSelected()) {
                statusorder = "LAINNYA";
            } else {
                statusorder = "TUNAI";
            }
            String angsuran = txtAngsuran.getText();
            String kodeBuktiPesanan = txtkodefaktur.getText();
            //data pelanggan
            Pelanggan p = new Pelanggan();
            p.setKodemanualpelanggan(kodemanualpel);
            p.setNamaPelanggan(namapelanggan);
            p.setAlamatpelanggan(alamat);
            p.setTelepon(telepon);
            //data sales
            Sales s = DaoFactory.getSalesDao().getSalesByName(namaSales);
            //DataBP
            BuktiPesanan bp = new BuktiPesanan();
            bp.setKodePesanan(kodeBuktiPesanan); //1
            bp.setNoFakturPesanan(kodemanualbp); //2            
            bp.setPelanggan(p); // 3,4,5,6
            bp.setSales(s); //7
            bp.setKomisiSales(komisisales); //8
            bp.setJenisOrder(statusorder); //9
            bp.setTglPesanan(tglPesanan); //10
            bp.setTglPenagihan(tglPenagihan); //11
            bp.setTglPengiriman(tglPengiriman); //12
            bp.setAngsuran(Integer.parseInt(angsuran)); //13
            bp.setTotal(Integer.parseInt(txttotal.getText())); //14
            bp.setUM(Integer.parseInt(txtUM.getText())); //15
            bp.setSisa(Integer.parseInt(txtSisa.getText())); //16
            bp.setHargaTunai(Integer.parseInt(txtSisa1.getText()));//17
            bp.setStatusKirimBarang("belum"); // 18
            try {
                DaoFactory.insertUrutPesanan(kodeBuktiPesanan);
            } catch (SQLException ex) {
                Logger.getLogger(BPesana.class.getName()).log(Level.SEVERE, null, ex);
            }
            DaoFactory.getBuktiPesananDao().InsertBuktiPesanan(bp);
            DaoFactory.getOrderTempDao().truncateordertemp();
            new PrintReport("./report/BPesanan.jasper", "kodeBPParams", bp.getKodePesanan());
            cleardetailfield();
            cleardetailfieldall();
            DaoFactory.getOrderTempDao().truncateordertemp();
            loadform();
            txttotal.setText("");
            txtUM.setText("");
            txtSisa.setText("");
            cleardetailfield();
            cleardetailfieldall();
            setCalenar();
        } else {
            JOptionPane.showMessageDialog(null, "Data Sudah Ada");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DaoFactory.getOrderTempDao().truncateordertemp();
        showbuktipesanan();
        jDesktopPane1.setVisible(false);
        jDesktopPane2.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jDesktopPane2.setVisible(false);
        jDesktopPane1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void textFilterbstuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFilterbstuKeyReleased
        // TODO add your handling code here:
        String text = textFilterbstu.getText();
        if (text.length() == 0) {
            sorter2.setRowFilter(null);
        } else {
            //System.out.println("y");
            sorter2.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_textFilterbstuKeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int row = TabelBSTU.getSelectedRow();
        if (row >= 0) {
            String kode = TabelBSTU.getValueAt(row, 9).toString();
            int opsi = JOptionPane.showConfirmDialog(null, "Yakin akan mencetak?");
            if (opsi == 0) {
                new PrintReport("./report/BPesanan.jasper", "kodeBPParams", kode);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int row = TabelBSTU.getSelectedRow();
        if (row >= 0) {
            String kode = TabelBSTU.getValueAt(row, 9).toString();
            BuktiPesanan bp = DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(kode);
            txtkodebp.setText(bp.getKodePesanan());
            txtnama.setSelectedItem(bp.getPelanggan().getNamaPelanggan());
            txtalamat.setText(bp.getPelanggan().getAlamatpelanggan());
            txttelepon.setText(bp.getPelanggan().getTelepon());
            txtManualKodePelanggan.setText(bp.getPelanggan().getKodemanualpelanggan());
            txtkodemanualbp.setText(bp.getPelanggan().getKodemanualpelanggan());
            txtkodemanualbp.setText(bp.getNoFakturPesanan());
            //--------------------------------------------------
            String statusorder = bp.getJenisOrder();
            if (statusorder.equalsIgnoreCase("TUNAI")) {
                tunaicheckbox.setSelected(true);
            } else if (statusorder.equalsIgnoreCase("DROP A1")) {
                dropcheckbox.setSelected(true);
            } else if (statusorder.equalsIgnoreCase("LAINNYA")) {
                laincheckbox.setSelected(true);
            } else {
                tunaicheckbox.setSelected(true);
            }
            //---------------------------------------------------
            txttotal.setText(String.valueOf(bp.getTotal()));
            txtUM.setText(String.valueOf(bp.getUM()));
            txtSisa.setText(String.valueOf(bp.getSisa()));
            txtSisa1.setText(String.valueOf(bp.getHargaTunai()));
            txtAngsuran.setText(String.valueOf(bp.getAngsuran()));

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                tglPesananDate.setDate(df.parse(bp.getTglPesanan()));
                tglPenagihanDate.setDate(df.parse(bp.getTglPenagihan()));
                tglPengirimanDate.setDate(df.parse(bp.getTglPengiriman()));
            } catch (ParseException ex) {
                Logger.getLogger(BPesana.class.getName()).log(Level.SEVERE, null, ex);
            }
            kombosales.setSelectedItem(bp.getSales().getnamaSales());
            txtkomisi.setText(String.valueOf(bp.getKomisiSales()));
            DaoFactory.getBuktiPesananDao().getTempDetailPesanan(kode);
            showordertemp();
            jDesktopPane2.setVisible(false);
            jDesktopPane1.setVisible(true);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Yakin akan menghapus bp?");
        if (opsi == 0) {
            String password = JOptionPane.showInputDialog(null, "Masukkan Password admin : ");
            if (password == "adminyudori") {
                String kodebp = txtkodebp.getText();
                BuktiPesanan bp = DaoFactory.getBuktiPesananDao().getBuktiPesananByKodeBP(kodebp);
                if (!kodebp.equalsIgnoreCase("")) {
                    DaoFactory.getBuktiPesananDao().DeleteBuktiPesanan(bp);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password Salah");
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String password = "Yudori2017";
        String opsi = JOptionPane.showInputDialog(null, "Masukkan Password Admin Untuk Update Data");
        if (opsi.equals(password)) {
            String kodebp = txtkodebp.getText();
            boolean status = new BuktiPesanan().cekbp(kodebp);
            if (status == true) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String kodemanualbp = txtkodemanualbp.getText();
                String kodemanualpel = txtManualKodePelanggan.getText();
                String namapelanggan = txtnama.getSelectedItem().toString();
                String alamat = txtalamat.getText();
                String telepon = txttelepon.getText();
                String tglPesanan = df.format(tglPesananDate.getDate());
                String tglPenagihan = df.format(tglPenagihanDate.getDate());
                String tglPengiriman = df.format(tglPengirimanDate.getDate());
                String namaSales = kombosales.getSelectedItem().toString();
                int komisisales = Integer.parseInt(txtkomisi.getText());
                String statusorder = "";
                if (tunaicheckbox.isSelected()) {
                    statusorder = "TUNAI";
                } else if (dropcheckbox.isSelected()) {
                    statusorder = "DROP A1";
                } else if (laincheckbox.isSelected()) {
                    statusorder = "LAINNYA";
                } else {
                    statusorder = "TUNAI";
                }
                String angsuran = txtAngsuran.getText();
                String kodeBuktiPesanan = txtkodebp.getText();
                //data pelanggan
                Pelanggan p = new Pelanggan();
                p.setKodemanualpelanggan(kodemanualpel);
                p.setNamaPelanggan(namapelanggan);
                p.setAlamatpelanggan(alamat);
                p.setTelepon(telepon);
                //data sales
                Sales s = DaoFactory.getSalesDao().getSalesByName(namaSales);
                //DataBP
                BuktiPesanan bp = new BuktiPesanan();
                bp.setKodePesanan(kodeBuktiPesanan); //1
                bp.setNoFakturPesanan(kodemanualbp); //2            
                bp.setPelanggan(p); // 3,4,5,6
                bp.setSales(s); //7
                bp.setKomisiSales(komisisales); //8
                bp.setJenisOrder(statusorder); //9
                bp.setTglPesanan(tglPesanan); //10
                bp.setTglPenagihan(tglPenagihan); //11
                bp.setTglPengiriman(tglPengiriman); //12
                bp.setAngsuran(Integer.parseInt(angsuran)); //13
                bp.setTotal(Integer.parseInt(txttotal.getText())); //14
                bp.setUM(Integer.parseInt(txtUM.getText())); //15
                bp.setSisa(Integer.parseInt(txtSisa.getText())); //16
                bp.setHargaTunai(Integer.parseInt(txtSisa1.getText())); //17
                bp.setStatusKirimBarang("belum"); // 18
                DaoFactory.getBuktiPesananDao().UpdateBuktiPesanan(bp);
                DaoFactory.getOrderTempDao().truncateordertemp();
                new PrintReport("./report/BPesanan.jasper", "kodeBPParams", bp.getKodePesanan());
                cleardetailfield();
                cleardetailfieldall();
                DaoFactory.getOrderTempDao().truncateordertemp();
                loadform();
                txttotal.setText("");
                txtUM.setText("");
                txtSisa.setText("");
                txtSisa1.setText("");
                txtAngsuran.setText("");
                cleardetailfield();
                cleardetailfieldall();
                setCalenar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Maaf anda tidak berhak mengubah data");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DaoFactory.getOrderTempDao().truncateordertemp();
        cleardetailfield();
        txttotal.setText("");
        txtUM.setText("");
        txtSisa.setText("");
        txtSisa1.setText("");
        txtAngsuran.setText("");
        showordertemp();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DaoFactory.getOrderTempDao().truncateordertemp();
        loadform();
        txttotal.setText("");
        txtUM.setText("");
        txtSisa.setText("");
        cleardetailfield();
        cleardetailfieldall();
        setCalenar();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
        if (txtnama.getItemCount() > 1) {
            String teks = txtnama.getSelectedItem().toString();
            if (teks != "") {
                Pelanggan p = DaoFactory.getPelangganDao().getPelangganByName(teks);
                txtalamat.setText(p.getAlamatpelanggan());
                txttelepon.setText(p.getTelepon());
                txtManualKodePelanggan.setText(p.getKodemanualpelanggan());
            }
        }


    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtnamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyPressed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_txtnamaKeyPressed

    private void txtnamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyReleased
        // TODO add your handling code here:
        String teks = txtnama.getSelectedItem().toString();
        if (teks != "") {
            Pelanggan p = DaoFactory.getPelangganDao().getPelangganByName(teks);
            txtalamat.setText(p.getAlamatpelanggan());
            txttelepon.setText(p.getTelepon());
        }
    }//GEN-LAST:event_txtnamaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new BPesana().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BPesana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BPesana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BPesana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BPesana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelBSTU;
    private javax.swing.JTable TabelBarang;
    private javax.swing.JTable TabelOrder;
    private javax.swing.JButton batalbutton;
    private javax.swing.JRadioButton dropcheckbox;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.ButtonGroup kategoriorder;
    private javax.swing.JComboBox<String> kombosales;
    private javax.swing.JRadioButton laincheckbox;
    private javax.swing.JButton okOrder;
    private javax.swing.JTextField textFilterbstu;
    private com.toedter.calendar.JDateChooser tglPenagihanDate;
    private com.toedter.calendar.JDateChooser tglPengirimanDate;
    private com.toedter.calendar.JDateChooser tglPesananDate;
    private javax.swing.JRadioButton tunaicheckbox;
    private javax.swing.JTextField txtAngsuran;
    private javax.swing.JTextField txtManualKodePelanggan;
    private javax.swing.JTextField txtSisa;
    private javax.swing.JTextField txtSisa1;
    private javax.swing.JTextField txtUM;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtisicekboxlainnya;
    private javax.swing.JTextField txtkodebarang;
    private javax.swing.JTextField txtkodebp;
    private javax.swing.JLabel txtkodefaktur;
    private javax.swing.JTextField txtkodemanualbp;
    private javax.swing.JTextField txtkomisi;
    private javax.swing.JComboBox<String> txtnama;
    private javax.swing.JLabel txtnamabarang;
    private javax.swing.JTextField txttelepon;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txtunit;
    // End of variables declaration//GEN-END:variables
}
