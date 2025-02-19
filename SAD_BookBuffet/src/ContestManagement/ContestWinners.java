/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ContestManagement;

import model.MySQL;
import static ContestManagement.ManageContests.contestTypeMap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sanjuna
 */
public class ContestWinners extends javax.swing.JPanel {

    public String query = "SELECT * FROM `member` "
            + "INNER JOIN `contest_has_member` "
            + "ON `member`.`membercard_id` = `contest_has_member`.`membercard_id` "
            + "INNER JOIN `contest` ON `contest`.`id` = `contest_has_member`.`contest_id` "
            + "INNER JOIN `contest_type` ON `contest_type`.`id` = `contest`.`contest_type_id` "
            + "WHERE `progress` > '45'";

    /**
     * Creates new form ContestProgress
     */
    public ContestWinners() {
        initComponents();
        loadContestType();
        loadContestWinners(query);
    }

    private void reset() {
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");
        jLabel12.setText("");

        jLabel13.setText("");
        jLabel15.setText("");
        jLabel16.setText("");
        jLabel17.setText("");
        jLabel18.setText("");

        jTextField2.setText("");
        jComboBox2.setSelectedIndex(0);

        jTable1.clearSelection();

        loadContestWinners(query);
    }

    private void loadContestType() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `contest_type`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox2.getModel();
            typeModel.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("type"));
                ManageContests.contestTypeMap.put(resultSet.getString("type"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox2.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadContestWinners(String query) {
        try {

            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("membercard_id"));
                v.add(resultSet.getString("fname") + " " + resultSet.getString("lname"));
                v.add(resultSet.getString("contest.name"));
                v.add(resultSet.getString("contest.id"));
                v.add(resultSet.getString("contest_type.type"));
                v.add(resultSet.getString("contest_has_member.progress"));
                v.add(resultSet.getString("contest_has_member.finishing_place"));

                tableModel.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jImagePanel1 = new main.JImagePanel();
        jImagePanel2 = new main.JImagePanel();
        jImagePanel3 = new main.JImagePanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 460));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 460));
        jPanel1.setLayout(new java.awt.GridLayout(10, 1, 10, 10));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        jLabel1.setText("View Winners");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 20, 1, 1));
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel2.setText("Contestant Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel1.add(jLabel2);

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8);

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel4.setText("Member Card ID");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel1.add(jLabel4);

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel9);

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel5.setText("Contest Name");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel1.add(jLabel5);

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10);

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel7.setText("Finishing Place");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel1.add(jLabel7);

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel12);

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/printer.png"))); // NOI18N
        jButton2.setText("Print Report");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton2.setIconTextGap(10);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(740, 140));

        jLabel24.setText("Contest Type");
        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N

        jLabel23.setText("Contestant Name");
        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextField2.setMinimumSize(new java.awt.Dimension(64, 22));
        jTextField2.setPreferredSize(new java.awt.Dimension(64, 22));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search_btn.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton3.setIconTextGap(10);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Search Contest Winners ");
        jLabel25.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/refresh.png"))); // NOI18N
        jButton4.setText("Refresh");
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton4.setIconTextGap(10);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, 0, 683, Short.MAX_VALUE))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(14, 14, 14))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 460));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Member Card ID", "Contestant Name", "Contest Name", "Contest ID", "Contest Type", "Progress", "Finishing Place"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMinimumSize(new java.awt.Dimension(60, 120));
        jTable1.setPreferredSize(new java.awt.Dimension(300, 120));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel4.add(jScrollPane1);

        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        jPanel7.setLayout(new java.awt.GridLayout(2, 2));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Start Date");
        jPanel7.add(jLabel14);

        jLabel21.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("End Date");
        jPanel7.add(jLabel21);

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("...");
        jPanel7.add(jLabel17);

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("...");
        jPanel7.add(jLabel18);

        jPanel5.add(jPanel7);

        jPanel6.setLayout(new java.awt.GridLayout(2, 3));

        jImagePanel1.setCenterImage(true);
        jImagePanel1.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/place1.png"))); // NOI18N

        javax.swing.GroupLayout jImagePanel1Layout = new javax.swing.GroupLayout(jImagePanel1);
        jImagePanel1.setLayout(jImagePanel1Layout);
        jImagePanel1Layout.setHorizontalGroup(
            jImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jImagePanel1Layout.setVerticalGroup(
            jImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel6.add(jImagePanel1);

        jImagePanel2.setCenterImage(true);
        jImagePanel2.setFitToPanel(false);
        jImagePanel2.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/place2.png"))); // NOI18N

        javax.swing.GroupLayout jImagePanel2Layout = new javax.swing.GroupLayout(jImagePanel2);
        jImagePanel2.setLayout(jImagePanel2Layout);
        jImagePanel2Layout.setHorizontalGroup(
            jImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jImagePanel2Layout.setVerticalGroup(
            jImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel6.add(jImagePanel2);

        jImagePanel3.setCenterImage(true);
        jImagePanel3.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/place3.png"))); // NOI18N

        javax.swing.GroupLayout jImagePanel3Layout = new javax.swing.GroupLayout(jImagePanel3);
        jImagePanel3.setLayout(jImagePanel3Layout);
        jImagePanel3Layout.setHorizontalGroup(
            jImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jImagePanel3Layout.setVerticalGroup(
            jImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel6.add(jImagePanel3);

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("...");
        jPanel6.add(jLabel13);

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("...");
        jPanel6.add(jLabel16);

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("...");
        jPanel6.add(jLabel15);

        jPanel5.add(jPanel6);

        jPanel4.add(jPanel5);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT contest_has_member.membercard_id, fname, lname, contest.name AS contest_name, contest.id AS contest_id, contest_type.type AS contest_type, "
                    + "contest_has_member.progress, contest_has_member.finishing_place "
                    + "FROM contest "
                    + "INNER JOIN contest_has_member ON contest.id = contest_has_member.contest_id "
                    + "INNER JOIN member ON member.membercard_id = contest_has_member.membercard_id "
                    + "INNER JOIN contest_type ON contest.contest_type_id = contest_type.id "
                    + "WHERE status_id = '1'");

            List<Object> parameters = new ArrayList<>();
            String name = jTextField2.getText();
            String type = String.valueOf(jComboBox2.getSelectedItem());

            if (!name.isEmpty() && type.equals("Select")) {
                queryBuilder.append(" AND (fname LIKE ? OR lname LIKE ?)");
                parameters.add(name + "%");
                parameters.add(name + "%");
            } else if (name.isEmpty() && !type.equals("Select")) {
                queryBuilder.append(" AND contest.contest_type_id = ?");
                parameters.add(contestTypeMap.get(type));
            } else if (!name.isEmpty() && !type.equals("Select")) {
                queryBuilder.append(" AND (fname LIKE ? OR lname LIKE ?) AND contest.contest_type_id = ?");
                parameters.add(name + "%");
                parameters.add(name + "%");
                parameters.add(contestTypeMap.get(type));
            }

            // For debugging: print the final query and parameters to verify correctness
            System.out.println("Generated Query: " + queryBuilder.toString());
            System.out.println("Parameters: " + parameters);

            PreparedStatement preparedStatement = MySQL.prepareStatement(queryBuilder.toString());

            // Set the parameters for the PreparedStatement
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0); // Clear existing rows

            boolean hasResults = false; // Flag to track if there are results

            while (resultSet.next()) {
                hasResults = true; // Mark that there is at least one result
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getString("contest_has_member.membercard_id"));
                row.add(resultSet.getString("fname") + " " + resultSet.getString("lname"));
                row.add(resultSet.getString("contest_name"));
                row.add(resultSet.getString("contest_id"));
                row.add(resultSet.getString("contest_type"));
                row.add(resultSet.getString("contest_has_member.progress"));
                row.add(resultSet.getString("contest_has_member.finishing_place"));

                tableModel.addRow(row);
            }

            if (!hasResults) {
                System.out.println("No results found for the specified criteria.");
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {
                // Print all column values for the selected row to verify correctness
                for (int i = 0; i < jTable1.getColumnCount(); i++) {
                    System.out.println("Column " + i + ": " + jTable1.getValueAt(selectedRow, i));
                }

                String contestantName = String.valueOf(jTable1.getValueAt(selectedRow, 1));
                jLabel8.setText(contestantName);

                String memberCardID = String.valueOf(jTable1.getValueAt(selectedRow, 0));
                jLabel9.setText(memberCardID);

                String contestName = String.valueOf(jTable1.getValueAt(selectedRow, 2));
                jLabel10.setText(contestName);

                String finishingPlace = String.valueOf(jTable1.getValueAt(selectedRow, 6));
                jLabel12.setText(finishingPlace);
                System.out.println("GUI Table Finishing Place: " + finishingPlace); // Debugging statement

                try {
                    String contestID = String.valueOf(jTable1.getValueAt(selectedRow, 3)); // Contest ID
                    String query = "SELECT * FROM `contest` "
                            + "INNER JOIN `contest_has_member` ON `contest`.`id` = `contest_has_member`.`contest_id` "
                            + "WHERE `contest`.`id` = ? AND `contest_has_member`.`membercard_id` = ?";

                    PreparedStatement preparedStatement = MySQL.prepareStatement(query);
                    preparedStatement.setString(1, contestID);
                    preparedStatement.setString(2, memberCardID);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        jLabel17.setText(resultSet.getString("start_datetime"));
                        jLabel18.setText(resultSet.getString("end_datetime"));

                        // Clear previous results in ranking labels
                        jLabel13.setText("");
                        jLabel16.setText("");
                        jLabel15.setText("");

                        // Retrieve finishing place from result set
                        String resultFinishingPlace = resultSet.getString("finishing_place");
                        System.out.println("Database Finishing Place: " + resultFinishingPlace);

                        // Update ranking labels based on finishing place
                        if ("1".equals(resultFinishingPlace)) {
                            jLabel13.setText(contestantName); // First place
                        } else if ("2".equals(resultFinishingPlace)) {
                            jLabel16.setText(contestantName); // Second place
                        } else if ("3".equals(resultFinishingPlace)) {
                            jLabel15.setText(contestantName); // Third place
                        } else {
                            System.out.println("Unexpected finishing place: " + resultFinishingPlace);
                        }
                    }

                    resultSet.close();
                    preparedStatement.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        // TODO add your handling code here:
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try {

            HashMap<String, Object> map = new HashMap<>();
            String path = "src//Resources/Reports//ContestantReport.jasper";

            JRDataSource datasource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(path, map, datasource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private main.JImagePanel jImagePanel1;
    private main.JImagePanel jImagePanel2;
    private main.JImagePanel jImagePanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
