/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ReservationManagement;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Sanjuna
 */
public class ReservationAnalytics extends javax.swing.JPanel {

    /**
     * Creates new form LogAnalysis
     */
    public ReservationAnalytics() {
        initComponents();

        jPanel6.removeAll();
        jPanel6.add(jPanel15, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel6);

        Font largerFont = new Font("Microsoft Jhenghei", Font.BOLD, 18);
        jButton1.setFont(largerFont);
    }

    private void analyticButton1Selected() {
        if (jButton1.isSelected()) {
            jPanel6.removeAll();
            jPanel6.add(jPanel15, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel6);

            Font largerFont = new Font("Microsoft Jhenghei", Font.BOLD, 18);
            jButton1.setFont(largerFont);

            Font defaultFont = new Font("Microsoft Jhenghei", Font.BOLD, 14);
            jButton2.setFont(defaultFont);
        }
    }

    private void analyticButton2Selected() {
        if (jButton2.isSelected()) {
            jPanel6.removeAll();
            jPanel6.add(jPanel20, BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(jPanel6);

            Font largerFont = new Font("Microsoft Jhenghei", Font.BOLD, 18);
            jButton2.setFont(largerFont);

            Font defaultFont = new Font("Microsoft Jhenghei", Font.BOLD, 14);
            jButton1.setFont(defaultFont);
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

        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel34 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        jPanel5.setMinimumSize(new java.awt.Dimension(740, 600));
        jPanel5.setPreferredSize(new java.awt.Dimension(740, 600));
        jPanel5.setLayout(new java.awt.GridLayout(2, 2, 8, 8));

        jPanel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel15.setMinimumSize(new java.awt.Dimension(740, 510));
        jPanel15.setPreferredSize(new java.awt.Dimension(740, 510));
        jPanel15.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        jPanel18.setLayout(new java.awt.GridLayout(1, 2, 10, 5));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Reservations");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);
        jPanel2.add(jSeparator2, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setForeground(new java.awt.Color(255, 255, 153));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Duration");

        jComboBox2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jComboBox2, 0, 150, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2))
                .addContainerGap())
        );

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel2);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Reservations by Category (Monthly)");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel30.add(jLabel16, java.awt.BorderLayout.PAGE_START);
        jPanel30.add(jSeparator3, java.awt.BorderLayout.CENTER);

        jPanel32.setBackground(new java.awt.Color(255, 255, 204));
        jPanel32.setForeground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel30.add(jPanel32, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel30);

        jPanel15.add(jPanel18);

        jPanel19.setMinimumSize(new java.awt.Dimension(740, 74));
        jPanel19.setPreferredSize(new java.awt.Dimension(740, 244));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reservations per Day");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel19.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel19);

        jPanel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel20.setMinimumSize(new java.awt.Dimension(740, 510));
        jPanel20.setPreferredSize(new java.awt.Dimension(740, 510));
        jPanel20.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        jPanel21.setLayout(new java.awt.GridLayout(1, 2, 10, 5));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Frequent Reservers");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.add(jLabel5, java.awt.BorderLayout.PAGE_START);
        jPanel4.add(jSeparator4, java.awt.BorderLayout.CENTER);

        jPanel34.setBackground(new java.awt.Color(255, 255, 204));
        jPanel34.setForeground(new java.awt.Color(255, 255, 153));

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        jLabel18.setText("Count:");

        jLabel35.setFont(new java.awt.Font("Microsoft JhengHei", 1, 20)); // NOI18N
        jLabel35.setText("x");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(68, 68, 68)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel18))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel34, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel4);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Most Reserved Titles (Quarter)");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel23.add(jLabel12, java.awt.BorderLayout.PAGE_START);
        jPanel23.add(jSeparator5, java.awt.BorderLayout.CENTER);

        jPanel24.setBackground(new java.awt.Color(255, 255, 204));
        jPanel24.setForeground(new java.awt.Color(255, 255, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rank", "Book", "Author", "Count"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(140);
        }

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel23.add(jPanel24, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel23);

        jPanel20.add(jPanel21);

        jPanel25.setMinimumSize(new java.awt.Dimension(740, 74));
        jPanel25.setPreferredSize(new java.awt.Dimension(740, 244));
        jPanel25.setLayout(new java.awt.BorderLayout());

        jPanel44.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        jPanel25.add(jPanel44, java.awt.BorderLayout.CENTER);

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Reservation Growth");
        jLabel34.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jLabel34.setOpaque(true);
        jPanel25.add(jLabel34, java.awt.BorderLayout.PAGE_START);

        jPanel20.add(jPanel25);

        setPreferredSize(new java.awt.Dimension(740, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel11.setMinimumSize(new java.awt.Dimension(740, 90));
        jPanel11.setPreferredSize(new java.awt.Dimension(740, 90));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/analytics.png"))); // NOI18N
        jLabel15.setText("Reservation Analytics");
        jLabel15.setIconTextGap(10);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));
        jPanel13.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Reservation Volume");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton1);

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Reservation Trends");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton2);

        jPanel13.add(jPanel14, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel6.setMinimumSize(new java.awt.Dimension(740, 510));
        jPanel6.setPreferredSize(new java.awt.Dimension(740, 510));
        jPanel6.setLayout(new java.awt.BorderLayout());
        add(jPanel6, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling cod
        jButton1.setSelected(true);
        analyticButton1Selected();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jButton2.setSelected(true);
        analyticButton2Selected();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        /* redacted */
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        /* redacted */
    }//GEN-LAST:event_jButton2MouseReleased

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
