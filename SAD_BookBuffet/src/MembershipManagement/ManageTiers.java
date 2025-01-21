/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MembershipManagement;

import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import LogsManagement.SearchLogs;
import model.MySQL;
import static BookManagement.ManageBooks.ageCategoryMap;
import static BookManagement.ManageBooks.authorNameMap;
import static BookManagement.ManageBooks.categoryMap;
import static BookManagement.ManageBooks.languageMap;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sanjuna
 */
public class ManageTiers extends javax.swing.JPanel {

    private String id;

    private String userQuery = "SELECT user_type.type FROM user "
            + "INNER JOIN user_type ON user.user_type_id = user_type.id "
            + "WHERE user.id = ?";

    /**
     * Creates new form ManageSubscriptions
     */
    public ManageTiers(String id) {
        initComponents();
        this.id = id;
        jLabel12.setText(id);

        checkUser();
        reset();
    }

    private void checkUser() {
        try (PreparedStatement pstmt = MySQL.prepareStatement(userQuery)) {
            pstmt.setString(1, id);

            try (ResultSet resultSet = pstmt.executeQuery()) {

                while (resultSet.next()) {
                    String userTypeId = resultSet.getString("user_type.type");

                    if ("Admin".equals(userTypeId)) {
                        jPanel3.setVisible(true);
                        jButton4.setEnabled(true);
                    } else {
                        jPanel3.setVisible(false);
                    }

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");

        jTable1.clearSelection();

        jButton2.setEnabled(true);

        loadTierDetails("SELECT * FROM `membership`");
    }

    private void loadTierDetails(String query) {
        try (PreparedStatement pstmt = MySQL.prepareStatement(query); ResultSet resultSet = pstmt.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                String tierId = resultSet.getString("id");
                String tierLevel = resultSet.getString("tier");
                String booksBurrowable = resultSet.getString("books_borrowable");
                String price = resultSet.getString("price");

                Vector<Object> rowData = new Vector<>();
                rowData.add(tierId);
                rowData.add(tierLevel);
                rowData.add(booksBurrowable);
                rowData.add(price);

                model.addRow(rowData);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(740, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(240, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 550));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 550));
        jPanel6.setLayout(new java.awt.GridLayout(11, 1, 5, 3));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Tiers");
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        jPanel6.add(jLabel1);

        jLabel2.setText("Membership Tier");
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jPanel6.add(jLabel2);
        jPanel6.add(jTextField2);

        jLabel3.setText("Books Borrowable");
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jPanel6.add(jLabel3);
        jPanel6.add(jTextField3);

        jLabel8.setText("Price");
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jPanel6.add(jLabel8);
        jPanel6.add(jTextField4);

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/add_btn.png"))); // NOI18N
        jButton2.setText("Add Plan");
        jButton2.setIconTextGap(10);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/update.png"))); // NOI18N
        jButton3.setText("Update Plan");
        jButton3.setIconTextGap(10);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/trash.png"))); // NOI18N
        jButton4.setText("Delete Plan");
        jButton4.setEnabled(false);
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Librarian ID");

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel6.add(jPanel3);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(740, 50));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/sort.png"))); // NOI18N
        jLabel5.setText("Managing Membership Tiers");
        jLabel5.setIconTextGap(10);

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel7.setMinimumSize(new java.awt.Dimension(500, 550));
        jPanel7.setPreferredSize(new java.awt.Dimension(500, 550));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 460));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 15, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tier ID", "Tier", "Books Borrowable", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/refresh.png"))); // NOI18N
        jButton6.setText("Refresh");
        jButton6.setIconTextGap(10);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton6, java.awt.BorderLayout.PAGE_END);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String tierName = jTextField2.getText();
        String booksBorrowable = jTextField3.getText();
        String price = jTextField4.getText();

        String query = "INSERT INTO `membership` (`tier`, `books_borrowable`, `price`) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = MySQL.prepareStatement(query)) {
            pstmt.setString(1, tierName);
            pstmt.setString(2, booksBorrowable);
            pstmt.setString(3, price);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Tier added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                reset();
            } else {
                JOptionPane.showMessageDialog(this, "Tier addition failed.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String tierName = jTextField2.getText();
        String booksBorrowable = jTextField3.getText();
        String price = jTextField4.getText();

        String query = "INSERT INTO `membership` (`tier`, `books_borrowable`, `price`) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = MySQL.prepareStatement(query)) {
            pstmt.setString(1, tierName);
            pstmt.setString(2, booksBorrowable);
            pstmt.setString(3, price);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Tier added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                reset();
            } else {
                JOptionPane.showMessageDialog(this, "Tier addition failed.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {
                /* block cannot exist without librarianDetails */
                try {

                    String tierName = jTable1.getValueAt(selectedRow, 1).toString();
                    jTextField2.setText(tierName);
                    jTextField2.setEnabled(false);

                    String booksBurrowable = jTable1.getValueAt(selectedRow, 2).toString();
                    jTextField3.setText(booksBurrowable);

                    String price = jTable1.getValueAt(selectedRow, 3).toString();
                    jTextField4.setText(price);

                    jButton2.setEnabled(false);

                } catch (Exception ex) {
                    Logger.getLogger(SearchLogs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Delete Tiers
        int selectedRow = jTable1.getSelectedRow();
        String tierId = String.valueOf(jTable1.getValueAt(selectedRow, 0));

        if (selectedRow != -1) {

            String query = "DELETE FROM `membership` WHERE id = ?";
            try (PreparedStatement pstmt = MySQL.prepareStatement(query)) {
                pstmt.setString(1, tierId);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Tier Deleted successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Tier deletion failed.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
