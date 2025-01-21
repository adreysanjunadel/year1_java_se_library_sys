/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PenaltyManagement.UI;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightContrastIJTheme;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sanjuna
 */
public class Penalties extends javax.swing.JFrame {
    
    private String id;
    
    private static AddPenalty addPenalty;
    private static PenaltyHistory penaltyHistory;
    private static ManagePenaltyReasons managePenaltyReasons;

    /**
     * Creates new form Discipline
     */
    public Penalties(String id) {
        this.id = id;
        initComponents();
        jButton1.setSelected(true);
        jButton1.grabFocus();
        
        jPanel2.removeAll();
        addPenalty = new AddPenalty();
        jPanel2.add(addPenalty,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(260, 600));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel3.setMinimumSize(new java.awt.Dimension(260, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(260, 600));
        jPanel3.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Penalties");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/left.png"))); // NOI18N
        jToggleButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/right.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel4);

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/penalty-add.png"))); // NOI18N
        jButton1.setIconTextGap(15);
        jButton1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jButton1.setPreferredSize(new java.awt.Dimension(180, 50));
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/current.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/reason.png"))); // NOI18N
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jButton3.setIconTextGap(15);
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/current.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/penalty-history.png"))); // NOI18N
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jButton4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/current.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(740, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(740, 600));
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected()){
            jLabel1.setVisible(false);
            Thread t = new Thread(
                () -> {
                    for(int i = 260; i >= 100; i-=10){
                        jPanel1.setPreferredSize(new Dimension(i, jPanel1.getHeight()));
                        SwingUtilities.updateComponentTreeUI(jPanel1);
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            );
            t.start();

        } else {
            jLabel1.setVisible(true);
            Thread t = new Thread(
                () -> {
                    for(int i = 100; i <= 260; i+=10){
                        jPanel1.setPreferredSize(new Dimension(i, jPanel1.getHeight()));
                        SwingUtilities.updateComponentTreeUI(jPanel1);
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            );
            t.start();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setText("Add Penalties");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setText("");
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jButton1.setSelected(true);

        jButton3.setSelected(false);
        jButton4.setSelected(false);

        jPanel2.removeAll();
        addPenalty = new AddPenalty();
        jPanel2.add(addPenalty,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);
        //repaint
        //revalidate
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setText("Manage Reasons");
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setText("");
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jButton3.setSelected(true);

        jButton1.setSelected(false);
        jButton4.setSelected(false);

        jPanel2.removeAll();
        managePenaltyReasons = new ManagePenaltyReasons(id);
        jPanel2.add(managePenaltyReasons,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setText("Penalty History");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        jButton4.setText("");
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jButton4.setSelected(true);

        jButton3.setSelected(false);
        jButton1.setSelected(false);

        jPanel2.removeAll();
        penaltyHistory = new PenaltyHistory();
        jPanel2.add(penaltyHistory,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatSolarizedLightContrastIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Penalties().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
