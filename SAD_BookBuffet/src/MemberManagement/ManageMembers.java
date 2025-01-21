/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MemberManagement;

import model.MySQL;
import PenaltyManagement.UI.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author Sanjuna
 */
public class ManageMembers extends javax.swing.JPanel {

    private static HashMap<String, String> membershipTierMap = new HashMap<>();
    private static HashMap<String, String> statusMap = new HashMap<>();
    private static HashMap<String, String> paymentMethodMap = new HashMap<>();

    private String id;
    private Members members;

    /**
     * Creates new form PenaltyReasonsUpdate
     */
    public ManageMembers(String id, Members members) {
        initComponents();

        this.id = id;

        jTextField1.grabFocus();

        loadMembership();
        loadPaymentMethod();
        loadStatus();

        reset();

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setDefaultRenderer(Object.class, renderer);
    }

    private void reset() {

        jTextField1.setText("");
        jTextField1.setEditable(true);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jDateChooser1.setDate(null);
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jTable1.clearSelection();

        loadMembers();
        jTextField1.requestFocus();

        jButton2.setEnabled(true);

    }

    private void loadMembership() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `membership`");

            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox1.getModel();
            model.removeAllElements();

            DefaultComboBoxModel searchModel = (DefaultComboBoxModel) jComboBox5.getModel();
            searchModel.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultset.next()) {
                v.add(resultset.getString("tier"));
                membershipTierMap.put(resultset.getString("tier"), resultset.getString("id"));
            }

            model.addAll(v);
            jComboBox1.setSelectedIndex(0);

            searchModel.addAll(v);
            jComboBox5.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadPaymentMethod() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `payment_method`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox4.getModel();
            typeModel.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultset.next()) {
                v.add(resultset.getString("method"));
                paymentMethodMap.put(resultset.getString("method"), resultset.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox4.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadStatus() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `status`");

            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBox2.getModel();
            model.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultset.next()) {
                v.add(resultset.getString("status"));
                statusMap.put(resultset.getString("status"), resultset.getString("id"));
            }

            model.addAll(v);
            jComboBox2.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadMembers() {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `member` "
                    + "INNER JOIN `membership` ON `member`.`membership_id`=`membership`.`id` "
                    + "INNER JOIN `status` ON `member`.`status_id`=`status`.`id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("membercard_id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("lname"));
                vector.add(resultSet.getString("dob"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("tier"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void setDateForJDateChooser(JDateChooser dateChooser, String dateString) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date date = dateFormat.parse(dateString);
            dateChooser.setDate(date);

        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid date format");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(740, 600));
        setPreferredSize(new java.awt.Dimension(740, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(240, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel6.setMinimumSize(new java.awt.Dimension(240, 550));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 550));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Members");

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/add_btn.png"))); // NOI18N
        jButton2.setText("Add Member");
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

        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/update.png"))); // NOI18N
        jButton3.setText("Update Member");
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

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel8.setText("Card ID");

        jTextField1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextField1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel3.setText("First Name");

        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel4.setText("Last Name");

        jTextField3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel9.setText("DOB");

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel10.setText("NIC");

        jTextField4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel2.setText("Mobile");

        jTextField5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        jTextField6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel11.setText("Tier");

        jComboBox1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel12.setText("Pay Method");

        jComboBox4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox4MouseEntered(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel13.setText("Status");

        jComboBox2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField6)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 3, 10, 3));
        jPanel11.setMinimumSize(new java.awt.Dimension(500, 550));
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 550));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/refresh.png"))); // NOI18N
        jButton6.setText("Refresh");
        jButton6.setIconTextGap(10);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton6, java.awt.BorderLayout.PAGE_END);

        jTable1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Card ID", "First Name", "Last Name", "DOB", "NIC", "Mobile", "Email", "Tier", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 2, 8, 2));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 140));
        jPanel4.setLayout(new java.awt.GridLayout(4, 1, 10, 5));

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Card");
        jPanel5.add(jLabel15);

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField7);

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("1st Name");
        jPanel5.add(jLabel16);

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField8);

        jLabel19.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Surname");
        jPanel5.add(jLabel19);

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField9);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton1.setText("Active");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseEntered(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jRadioButton2.setText("Inactive");
        jRadioButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseEntered(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jRadioButton2);

        jPanel4.add(jPanel5);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Email");
        jPanel9.add(jLabel17);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField10);

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Mobile");
        jPanel9.add(jLabel20);

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField11);

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Tier");
        jPanel9.add(jLabel18);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox5MouseEntered(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox5);

        jPanel4.add(jPanel9);

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        jButton11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton11.setText("Payments View");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton11);

        jPanel4.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        jButton9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton9.setText("Search Members");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton9);

        jPanel4.add(jPanel14);

        jPanel11.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel2.setPreferredSize(new java.awt.Dimension(740, 50));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/member-management.png"))); // NOI18N
        jLabel5.setText("Manage Members");
        jLabel5.setIconTextGap(10);

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
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
        /// INSERT Member

        String memberStatus = "";

        String membercard_id = jTextField1.getText();
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();
        Date dob = jDateChooser1.getDate();
        String nic = jTextField4.getText();
        String mobile = jTextField5.getText();
        String email = jTextField6.getText();
        String membership = String.valueOf(jComboBox1.getSelectedItem());
        String fees = String.valueOf(jComboBox4.getSelectedItem());
        String status = String.valueOf(jComboBox2.getSelectedItem());

        if (membercard_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Membercard Id", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Member First name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Member Last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Member NIC", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Member Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Member Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (membership.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select Membership Tier", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                String checkQuery = "SELECT * FROM `member` WHERE `membercard_id`=? OR `mobile`=? OR `nic`=?";
                PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                checkStmt.setString(1, membercard_id);
                checkStmt.setString(2, mobile);
                checkStmt.setString(3, nic);

                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Member already registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    String insertMemberQuery = "INSERT INTO `member`(`membercard_id`, `fname`, `lname`, `dob`, `nic`, `email`, `mobile`, `membership_id`, `status_id`) "
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertMemberStmt = MySQL.prepareStatement(insertMemberQuery);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    int membercard = Integer.parseInt(membercard_id);

                    insertMemberStmt.setInt(1, membercard);
                    insertMemberStmt.setString(2, fname);
                    insertMemberStmt.setString(3, lname);
                    insertMemberStmt.setString(4, sdf.format(dob));
                    insertMemberStmt.setString(5, nic);
                    insertMemberStmt.setString(6, email);
                    insertMemberStmt.setString(7, mobile);
                    insertMemberStmt.setString(8, membershipTierMap.get(membership)); // Assuming membershipTierMap is a Map
                    insertMemberStmt.setString(9, statusMap.get(status)); // Assuming statusMap is a Map

                    insertMemberStmt.executeUpdate();

                    // Insert into membership_payments
                    LocalDate currentDate = LocalDate.now();
                    Month currentMonth = currentDate.getMonth();
                    LocalDateTime currentDateTime = LocalDateTime.now();

                    String insertPaymentQuery = "INSERT INTO `membership_payments`(`membercard_id`, `month`, `payment_method_id`, `date_time`, `user_id`) "
                            + "VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement insertPaymentStmt = MySQL.prepareStatement(insertPaymentQuery);

                    insertPaymentStmt.setInt(1, membercard);
                    insertPaymentStmt.setString(2, currentMonth.name());
                    insertPaymentStmt.setString(3, paymentMethodMap.get(fees)); // Assuming paymentMethodMap is a Map
                    insertPaymentStmt.setString(4, currentDateTime.toString());
                    insertPaymentStmt.setString(5, id); // Assuming id is the current user's ID

                    insertPaymentStmt.executeUpdate();

                    reset();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // UPDATE Member
        try {

            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select Row", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                String membercard_id = jTextField1.getText();
                String fname = jTextField2.getText();
                String lname = jTextField3.getText();
                Date dob = jDateChooser1.getDate();
                String nic = jTextField4.getText();
                String mobile = jTextField5.getText();
                String email = jTextField6.getText();
                String membership = String.valueOf(jComboBox1.getSelectedItem());
                String fees = String.valueOf(jComboBox4.getSelectedItem());
                String status = String.valueOf(jComboBox2.getSelectedItem());

                if (fname.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Member First name", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (lname.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Member Last name", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (nic.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Member NIC", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (mobile.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Member Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                    JOptionPane.showMessageDialog(this, "Invalid Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter Member Email", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                    JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (membership.equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Please select Membership Tier", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (fees.equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Please select Payment Method", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (status.equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Please select Member Status", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    // Check for duplicate NIC or Mobile
                    String checkQuery = "SELECT * FROM `member` WHERE `nic` = ? OR `mobile` = ?";
                    PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                    checkStmt.setString(1, nic);
                    checkStmt.setString(2, mobile);

                    ResultSet resultset = checkStmt.executeQuery();
                    boolean canUpdate = false;

                    if (resultset.next()) {
                        if (!resultset.getString("email").equals(email)) {
                            JOptionPane.showMessageDialog(this, "NIC or Mobile already used", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            System.out.println("Same data");
                            canUpdate = true;
                        }
                    } else {
                        canUpdate = true;
                    }

                    if (canUpdate) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = sdf.format(dob);

                        // Update `member` table
                        String updateMemberQuery = "UPDATE `member` SET `fname` = ?, `lname` = ?, `dob` = ?, `nic` = ?, "
                                + "`mobile` = ?, `email` = ?, `membership_id` = ?, `status_id` = ? WHERE `membercard_id` = ?";
                        PreparedStatement updateMemberStmt = MySQL.prepareStatement(updateMemberQuery);
                        updateMemberStmt.setString(1, fname);
                        updateMemberStmt.setString(2, lname);
                        updateMemberStmt.setString(3, formattedDate);
                        updateMemberStmt.setString(4, nic);
                        updateMemberStmt.setString(5, mobile);
                        updateMemberStmt.setString(6, email);
                        updateMemberStmt.setString(7, membershipTierMap.get(membership));
                        updateMemberStmt.setString(8, statusMap.get(status));
                        updateMemberStmt.setString(9, membercard_id);

                        int rowsUpdatedMember = updateMemberStmt.executeUpdate();

                        // Update `membership_payments` table
                        String updatePaymentQuery = "UPDATE `membership_payments` SET `payment_method_id` = ? WHERE `membercard_id` = ?";
                        PreparedStatement updatePaymentStmt = MySQL.prepareStatement(updatePaymentQuery);
                        updatePaymentStmt.setString(1, paymentMethodMap.get(fees));
                        updatePaymentStmt.setString(2, membercard_id);

                        int rowsUpdatedPayment = updatePaymentStmt.executeUpdate();

                        if (rowsUpdatedMember > 0 || rowsUpdatedPayment > 0) {
                            JOptionPane.showMessageDialog(this, "Member updated successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);

                            reset();
                        } else {
                            JOptionPane.showMessageDialog(this, "No user was updated.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    checkStmt.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        //search();
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Mouse Click Table

        // Double Click
        if (evt.getClickCount() == 2) {

            jTextField1.setEditable(false);
            jButton2.setEnabled(false);

            int selectedRow = jTable1.getSelectedRow();

            String membercard_id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            String fname = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            String lname = String.valueOf(jTable1.getValueAt(selectedRow, 2));
            String dob = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            String nic = String.valueOf(jTable1.getValueAt(selectedRow, 4));
            String mobile = String.valueOf(jTable1.getValueAt(selectedRow, 5));
            String email = String.valueOf(jTable1.getValueAt(selectedRow, 6));
            String membership_id = String.valueOf(jTable1.getValueAt(selectedRow, 7));
            String status_id = String.valueOf(jTable1.getValueAt(selectedRow, 8));

            jTextField1.setText(membercard_id);
            jTextField2.setText(fname);
            jTextField3.setText(lname);
            jTextField4.setText(nic);
            jTextField5.setText(mobile);
            jTextField6.setText(email);

            jComboBox1.setSelectedItem(membership_id);
            jComboBox2.setSelectedItem(status_id);

            setDateForJDateChooser(jDateChooser1, dob);

        } else if (evt.getClickCount() == 3) {

            int selectedRow = jTable1.getSelectedRow();
            String membercard_id = String.valueOf(jTable1.getValueAt(selectedRow, 0));
            jTextField1.setText(membercard_id);

            MemberAddressView memberaddressview = new MemberAddressView(members, true, membercard_id);
            memberaddressview.setVisible(true);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // Search
        try {
            String status = "";

            String membercard_id = jTextField7.getText();
            String fname = jTextField8.getText();
            String lname = jTextField9.getText();
            String email = jTextField10.getText();
            String mobile = jTextField11.getText();

            String tier = String.valueOf(jComboBox5.getSelectedItem());
            String tierId = membershipTierMap.get(tier);

            if (jRadioButton1.isSelected()) {
                status = "Active";
            } else if (jRadioButton2.isSelected()) {
                status = "Inactive";
            }

            StringBuilder query = new StringBuilder(""
                    + "SELECT member.membercard_id, member.fname, member.lname, member.dob, "
                    + "member.nic, member.mobile, member.email, membership.tier, status.status "
                    + "FROM member "
                    + "INNER JOIN membership ON member.membership_id = membership.id "
                    + "INNER JOIN status ON member.status_id = status.id "
                    + "WHERE 1=1"); // Base Query

            List<Object> parameters = new ArrayList<>();

            // Appending query clauses omitting empty ones
            if (!membercard_id.isEmpty()) {
                query.append(" AND member.membercard_id LIKE ?");
                parameters.add(membercard_id + "%");
            }

            if (!fname.isEmpty()) {
                query.append(" AND member.fname LIKE ?");
                parameters.add(fname + "%");
            }

            if (!lname.isEmpty()) {
                query.append(" AND member.lname LIKE ?");
                parameters.add(lname + "%");
            }

            if (!email.isEmpty()) {
                query.append(" AND member.email LIKE ?");
                parameters.add(email + "%");
            }

            if (!mobile.isEmpty()) {
                query.append(" AND member.mobile LIKE ?");
                parameters.add(mobile + "%");
            }

            if (tierId != null && !tierId.isEmpty()) {
                query.append(" AND member.membership_id = ?");
                parameters.add(tierId); // Correctly bind tierId
            }

            if (!status.isEmpty()) {
                query.append(" AND status.status = ?");
                parameters.add(status); // Correctly bind status
            }

            // Prepare the statement
            PreparedStatement preparedStatement = MySQL.prepareStatement(query.toString());

            // Set parameters dynamically
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                Vector<Object> vector = new Vector<>();

                vector.add(resultSet.getString("member.membercard_id"));
                vector.add(resultSet.getString("member.fname"));
                vector.add(resultSet.getString("member.lname"));
                vector.add(resultSet.getString("member.dob"));
                vector.add(resultSet.getString("member.nic"));
                vector.add(resultSet.getString("member.mobile"));
                vector.add(resultSet.getString("member.email"));
                vector.add(resultSet.getString("membership.tier"));
                vector.add(resultSet.getString("status.status"));

                tableModel.addRow(vector);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        PaymentView paymentview = new PaymentView(members, true);
        paymentview.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jRadioButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseEntered
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jRadioButton1MouseEntered

    private void jRadioButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseEntered
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jRadioButton2MouseEntered

    private void jComboBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseEntered
        jComboBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox5MouseEntered

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseEntered
        jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox4MouseEntered

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
