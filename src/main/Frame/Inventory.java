package Frame;

import Class.UserClass;
import Frame.Dashboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventory extends javax.swing.JFrame {
    
    private Statement St;
    private Connection Con;
    private ResultSet Rs;
    private String sql ="";
    
    String _username;
    String _role;
    
    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String USER = "root";
    private static final String PASS = "Qa04091518";

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    
    public Inventory(String username, String role) {
        initComponents();
        
         try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        loadInventory();
        this._role = role;
        this._username = username;
        
        if (role.equals("Regular User")) {
            Update.setVisible(false);
            Delete.setVisible(false);
            Add.setVisible(false);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jColorChooser1 = new javax.swing.JColorChooser();
        jDialog1 = new javax.swing.JDialog();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        Total = new javax.swing.JTextField();
        Stok = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IdBarang = new javax.swing.JTextField();
        NamaBarang = new javax.swing.JTextField();
        KategoriBarang = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Done = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(163, 0, 0));
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(108, 108, 108))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(0, 99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(163, 0, 0));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Logistik");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(163, 0, 0));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 0, 0));
        jLabel5.setText("Stok:");

        Update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(163, 0, 0));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(163, 0, 0));
        jLabel6.setText("Total:");

        Delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Delete.setForeground(new java.awt.Color(163, 0, 0));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });

        Stok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StokActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel1.setText("Inventory");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(163, 0, 0));
        jLabel2.setText("ID Barang:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(163, 0, 0));
        jLabel3.setText("Nama Barang:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(163, 0, 0));
        jLabel4.setText("Kategori Barang:");

        IdBarang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        IdBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdBarangActionPerformed(evt);
            }
        });

        NamaBarang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        NamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaBarangActionPerformed(evt);
            }
        });

        KategoriBarang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        KategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KategoriBarangActionPerformed(evt);
            }
        });

        Search.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(163, 0, 0));
        Search.setText("Search");
        Search.setActionCommand("Add");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Kategori Barang", "Total", "Stok"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("ID Barang");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Nama Barang");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Kategori Barang");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Total");
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Stok");
        }

        Done.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Done.setForeground(new java.awt.Color(163, 0, 0));
        Done.setText("Done");
        Done.setToolTipText("");
        Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(IdBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                            .addComponent(NamaBarang)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(KategoriBarang)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Stok, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                            .addComponent(Total)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(Add)
                                        .addGap(18, 18, 18)
                                        .addComponent(Search))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Update)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addGap(18, 18, 18)
                        .addComponent(Done)
                        .addGap(1, 1, 1)))
                .addGap(75, 75, 75))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(IdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(KategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(NamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add)
                            .addComponent(Search))))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(Update)
                    .addComponent(Done))
                .addGap(83, 83, 83))
        );

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right-arrow.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton4)
                .addGap(29, 29, 29)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 1007, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        String searchName = JOptionPane.showInputDialog(this, "Masukkan Nama Barang:");

        if (searchName != null && !searchName.trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            clearTable();  // Kosongkan tabel sebelum menambahkan hasil pencarian

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM inventory WHERE NamaBarang LIKE ?")) {
                 
                statement.setString(1, "%" + searchName + "%");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String idBarang = resultSet.getString("IdBarang");
                    String namaBarang = resultSet.getString("NamaBarang");
                    String kategori = resultSet.getString("Kategori");
                    int total = resultSet.getInt("Total");
                    int stok = resultSet.getInt("Stok");

                    model.addRow(new Object[]{idBarang, namaBarang, kategori, total, stok});
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Barang tidak ditemukan.");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal mencari data dari database: " + e.getMessage());
            }
        }
    }                                      

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);  // Mengosongkan tabel dengan mengatur jumlah baris menjadi 0
    }//GEN-LAST:event_SearchActionPerformed

    private void KategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KategoriBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KategoriBarangActionPerformed

    private void NamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaBarangActionPerformed

    private void IdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdBarangActionPerformed

    private void StokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StokActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        int selectedRowIndex = jTable2.getSelectedRow();

        if (selectedRowIndex != -1) {
            try {
                String idBarang = (String) jTable2.getValueAt(selectedRowIndex, 0);

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.removeRow(selectedRowIndex);
             
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pst = connection.prepareStatement("DELETE FROM inventory WHERE IdBarang=?");
                
                pst.setString(1, idBarang);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus dari database.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
        }
    }//GEN-LAST:event_DeleteActionPerformed
    
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        int selectedRowIndex = jTable2.getSelectedRow();
        
        if (selectedRowIndex != -1) {
            try {
                String idBarang = (String) jTable2.getValueAt(selectedRowIndex, 0);
                String namaBarang = (String) jTable2.getValueAt(selectedRowIndex, 1);
                String kategoriBarang = (String) jTable2.getValueAt(selectedRowIndex, 2);
                // Asumsikan kolom 3 dan 4 adalah Integer
                int total = (Integer) jTable2.getValueAt(selectedRowIndex, 3);
                int stok = (Integer) jTable2.getValueAt(selectedRowIndex, 4);

                IdBarang.setText(idBarang);
                NamaBarang.setText(namaBarang);
                KategoriBarang.setText(kategoriBarang);
                Total.setText(String.valueOf(total));
                Stok.setText(String.valueOf(stok));
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan tipe data di tabel.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diupdate.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String idBarang = IdBarang.getText();
        String namaBarang = NamaBarang.getText();
        String kategoriBarang = KategoriBarang.getText();
        int total = Integer.parseInt(Total.getText());
        int stok = Integer.parseInt(Stok.getText());

        int selectedRowIndex = jTable2.getSelectedRow();

        try {
            if (selectedRowIndex != -1) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                
                model.setValueAt(idBarang, selectedRowIndex, 0);
                model.setValueAt(namaBarang, selectedRowIndex, 1);
                model.setValueAt(kategoriBarang, selectedRowIndex, 2);
                model.setValueAt(total, selectedRowIndex, 3);
                model.setValueAt(stok, selectedRowIndex, 4);

                
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pst = connection.prepareStatement("UPDATE inventory SET NamaBarang=?, Kategori=?, Total=?, Stok=? WHERE IdBarang=?");
                
                pst.setString(1, namaBarang);
                pst.setString(2, kategoriBarang);
                pst.setInt(3, total);
                pst.setInt(4, stok);
                pst.setString(5, idBarang);
                pst.executeUpdate();
            } else {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                String[] rowData = {idBarang, namaBarang, kategoriBarang, String.valueOf(total), String.valueOf(stok)};
                model.addRow(rowData);
                
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO inventory (IdBarang, NamaBarang, Kategori, Total, Stok) VALUES (?, ?, ?, ?, ?)");
                
                statement.setString(1, idBarang);
                statement.setString(2, namaBarang);
                statement.setString(3, kategoriBarang);
                statement.setInt(4, total);
                statement.setInt(5, stok);
                statement.execute();
            }

            JOptionPane.showMessageDialog(null, "Data berhasil diupdate atau ditambahkan ke database.");
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan atau mengupdate data ke database: " + ex.getMessage());
        }

        IdBarang.setText("");
        NamaBarang.setText("");
        KategoriBarang.setText("");
        Total.setText("");
        Stok.setText("");
    }//GEN-LAST:event_AddActionPerformed
    
    private void loadInventory() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM inventory");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String idBarang = resultSet.getString("IdBarang");
                String namaBarang = resultSet.getString("NamaBarang");
                String kategori = resultSet.getString("Kategori");
                int total = resultSet.getInt("Total");
                int stok = resultSet.getInt("Stok");

                model.addRow(new Object[]{idBarang, namaBarang, kategori, total, stok});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    private void DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneActionPerformed
        jTable2.clearSelection();
        loadInventory();
    }//GEN-LAST:event_DoneActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        UserClass userClass = new UserClass();
        UserClass.User user;
        
        if ("Admin".equalsIgnoreCase(_role)) {
            user = userClass.new AdminUser(_username, _role);
        } else {
            user = userClass.new RegularUser(_username, _role);
        }

        Dashboard dashboard = new Dashboard(user);
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Done;
    private javax.swing.JTextField IdBarang;
    private javax.swing.JTextField KategoriBarang;
    private javax.swing.JTextField NamaBarang;
    private javax.swing.JButton Search;
    private javax.swing.JTextField Stok;
    private javax.swing.JTextField Total;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
