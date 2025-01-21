/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PenaltyManagement.UI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Sanjuna
 */
public class ManagePenaltyReasons extends javax.swing.JPanel {

    private String query = "SELECT * FROM `penalty_reasons`";
    
    private String userQuery = "SELECT user_type.type FROM user "
            + "INNER JOIN user_type ON user.user_type_id = user_type.id "
            + "WHERE user.id = ?";

    private String id;

    /**
     * Creates new form PenaltyReasonsUpdate
     */
    public ManagePenaltyReasons(String id) {
        initComponents();
        this.id = id;

        reset();
        checkUser();
        jLabel12.setText(id);
        jButton4.setEnabled(false);
    }
    
    private void reset () {
        jTextField3.setText("");
        jTextField4.setText("");
        jTable1.clearSelection();
        
        jButton3.setEnabled(false);
        
        loadPenaltyReasons(query);
    }
    
    private void checkUser() {
        try (PreparedStatement pstmt = MySQL.prepareStatement(userQuery)) {
            pstmt.setString(1, id);

            try (ResultSet resultSet = pstmt.executeQuery()) {

                while (resultSet.next()) {
                    String userTypeId = resultSet.getString("user_type.type");
                    System.out.println(userTypeId);

                    if ("Admin".equals(userTypeId)) {
                        jButton4.setEnabled(true);
                    } else {
                        // Deleted Disabled
                    }

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPenaltyReasons(String query) {
        try {
            System.out.println("Executing Query: " + query);  // Debugging line to check the query

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            PreparedStatement pstmt = MySQL.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Vector<Object> rowData = new Vector<>();
                rowData.add(resultSet.getString("penalty_reasons.id"));
                rowData.add(resultSet.getString("penalty_reasons.reason"));
                rowData.add(resultSet.getString("penalty_reasons.fee"));
                model.addRow(rowData);
            }

            resultSet.close();
            pstmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();  // Print the stack trace to catch any exceptions
            JOptionPane.showMessageDialog(this, "Error loading logs: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel7 = new javax.swing.JLabel();
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
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(740, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(240, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel6.setMinimumSize(new java.awt.Dimension(240, 550));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 550));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manage Reasons");
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N

        jLabel3.setText("Reason");
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        jLabel8.setText("Penalty Fee");
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/add_btn.png"))); // NOI18N
        jButton2.setText("Add Plan");
        jButton2.setIconTextGap(10);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/update.png"))); // NOI18N
        jButton3.setText("Update Plan");
        jButton3.setIconTextGap(10);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/trash.png"))); // NOI18N
        jButton4.setText("Delete Plan");
        jButton4.setEnabled(false);
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton4.setIconTextGap(10);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Librarian ID");
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("...");
        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(jTextField3)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField4)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel11.setMinimumSize(new java.awt.Dimension(500, 550));
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 550));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 15, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reason ID", "Reason", "Penalty Fee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/refresh.png"))); // NOI18N
        jButton6.setText("Refresh");
        jButton6.setIconTextGap(10);
        jPanel11.add(jButton6, java.awt.BorderLayout.PAGE_END);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel2.setPreferredSize(new java.awt.Dimension(740, 50));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/sort.png"))); // NOI18N
        jLabel5.setText("Sorting Penalty Reasons");
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel5.setIconTextGap(10);

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Add Penalty
        Double penaltyFee;
        String penaltyReason = jTextField3.getText();
        penaltyFee = Double.parseDouble(jTextField4.getText());

        if (penaltyReason.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a Penalty Reason", "Warning", JOptionPane.ERROR_MESSAGE);
        } else if (penaltyFee.equals(0)) {
            JOptionPane.showMessageDialog(this, "Please Select a Penalty Fee", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String checkQuery = "SELECT * FROM `penalty_reasons` WHERE `reason` = ?";
                PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                checkStmt.setString(1, penaltyReason);

                ResultSet resultSet = checkStmt.executeQuery();

                if (!resultSet.next()) {  // No existing entry
                    String insertQuery = "INSERT INTO `penalty_reasons` (`reason`, `fee`) VALUES (?, ?)";
                    PreparedStatement pstmt = MySQL.prepareStatement(insertQuery);
                    pstmt.setString(1, penaltyReason);
                    pstmt.setDouble(2, penaltyFee);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Penalty Reason added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Penalty Reason already exists for this log!", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding penalty: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Update Penalty Reasons
        try {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select Row", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                String penaltyReason = jTextField3.getText();
                String penaltyFee = jTextField4.getText();

                if (penaltyReason.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter the Penalty Reason", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (penaltyFee.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter the Penalty Fee", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    String checkQuery = "SELECT * FROM `penalty_reasons` WHERE `reason` = ?";
                    PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                    checkStmt.setString(1, penaltyReason);

                    ResultSet resultSet = checkStmt.executeQuery();
                    boolean canUpdate = false;

                    if (resultSet.next()) {
                        if (!resultSet.getString("reason").equals(penaltyReason)) {
                            JOptionPane.showMessageDialog(this, "Penalty Reason already used", "Warning", JOptionPane.WARNING_MESSAGE);

                        } else {
                            canUpdate = true;
                        }
                    } else {
                        canUpdate = true;
                    }

                    if (canUpdate) {
                        String updatePenaltyQuery = "UPDATE `penalty_reasons` SET `fee` = ?";
                        PreparedStatement updatePenaltyStmt = MySQL.prepareStatement(updatePenaltyQuery);
                        updatePenaltyStmt.setString(1, penaltyFee);

                        int rowUpdatedPenalty = updatePenaltyStmt.executeUpdate();

                        if (rowUpdatedPenalty > 0) {
                            JOptionPane.showMessageDialog(this, "Penalty Reason updated successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);

                            reset();
                        } else {
                            JOptionPane.showMessageDialog(this, "No penalty was updated.", "Info", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    
                    checkStmt.close();

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete Penalty Reason
        int selectedRow = jTable1.getSelectedRow();
        String reservationId = String.valueOf(jTable1.getValueAt(selectedRow, 0));

        if (selectedRow != -1) {

            String query = "DELETE FROM `penalty_reasons` WHERE id = ?";
            try (PreparedStatement pstmt = MySQL.prepareStatement(query)) {
                pstmt.setString(1, reservationId);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Penalty Reason Deleted successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Penalty Reason deletion failed.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {

                jButton3.setEnabled(true);
                jButton2.setEnabled(false);
                jTextField3.setEnabled(false);
                jButton4.setEnabled(true);

                String penaltyReason = String.valueOf(jTable1.getValueAt(selectedRow, 1));
                String penaltyFee = String.valueOf(jTable1.getValueAt(selectedRow, 2));

                jTextField3.setText(penaltyReason);
                jTextField4.setText(penaltyFee);

            }
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
