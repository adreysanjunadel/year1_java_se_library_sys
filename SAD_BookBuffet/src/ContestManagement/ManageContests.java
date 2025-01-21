/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ContestManagement;

import model.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sanjuna
 */
public class ManageContests extends javax.swing.JPanel {

    public static HashMap<String, String> contestTypeMap = new HashMap<>();
    public static HashMap<String, String> contestAgeMap = new HashMap<>();

    private String query = "SELECT * FROM `contest` "
            + "INNER JOIN `contest_type` ON `contest`.`contest_type_id` = `contest_type`.`id` "
            + "INNER JOIN `age` ON `contest`.`age_id` = `age`.`id`";

    public String id;

    /**
     * Creates new form AddContest
     */
    public ManageContests(String id) {
        initComponents();
        loadContestAge();
        loadContestType();
        this.id = id;
        reset();
    }

    private void loadContestType() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `contest_type`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox3.getModel();
            typeModel.removeAllElements();

            DefaultComboBoxModel typeModelA = (DefaultComboBoxModel) jComboBox9.getModel();
            typeModelA.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("type"));
                contestTypeMap.put(resultSet.getString("type"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox3.setSelectedIndex(0);

            typeModelA.addAll(v);
            jComboBox9.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadContestAge() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `age`");

            DefaultComboBoxModel agemodel = (DefaultComboBoxModel) jComboBox4.getModel();
            agemodel.removeAllElements();

            DefaultComboBoxModel agemodelA = (DefaultComboBoxModel) jComboBox5.getModel();
            agemodelA.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("age"));
                contestAgeMap.put(resultSet.getString("age"), resultSet.getString("id"));
            }

            agemodel.addAll(v);
            jComboBox4.setSelectedIndex(0);

            agemodelA.addAll(v);
            jComboBox5.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDateTime() {
        dateTimePicker3.setDateTimePermissive(LocalDateTime.now());
    }

    private void loadContestTable(String query) {
        try {

            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String contestID = resultSet.getString("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String age = resultSet.getString("age");
                String start = resultSet.getString("start_datetime");
                String end = resultSet.getString("end_datetime");

                Vector v = new Vector();
                v.add(contestID);
                v.add(name);
                v.add(type);
                v.add(age);
                v.add(start);
                v.add(end);

                tableModel.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addContestType() {
        String contestType = jTextField2.getText();

        if (contestType.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contest Type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String checkQuery = "SELECT * FROM `contest_type` WHERE `type` = ?";
                PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                checkStmt.setString(1, contestType);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Contest Type Exists", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Insert New Type
                    String insertQuery = "INSERT INTO `contest_type` (`type`) VALUES (?)";
                    PreparedStatement pstmt = MySQL.prepareStatement(insertQuery);
                    pstmt.setString(1, contestType);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Contest Type added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                }

            } catch (Exception e) {
            }
        }
    }

    private void addContestAge() {
        String contestAge = jTextField4.getText();

        if (contestAge.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contest Age", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String checkQuery = "SELECT * FROM `age` WHERE `age` = ?";
                PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                checkStmt.setString(1, contestAge);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Contest Age Exists", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Insert New Type
                    String insertQuery = "INSERT INTO `age` (`age`) VALUES (?)";
                    PreparedStatement pstmt = MySQL.prepareStatement(insertQuery);
                    pstmt.setString(1, contestAge);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Contest Age added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                }

            } catch (Exception e) {
            }
        }
    }

    private void reset() {
        jTextField3.setText("");
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox9.setSelectedIndex(0);

        jTable2.clearSelection();

        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);

        jTextField2.setEnabled(true);
        jTextField4.setEnabled(true);

        jTextField6.setText("");
        jTextField4.setText("");
        jTextField2.setText("");

        dateTimePicker4.setDateTimePermissive(null);

        loadContestType();
        loadContestAge();
        loadContestTable(query);
        setDateTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        dateTimePicker3 = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel12 = new javax.swing.JLabel();
        dateTimePicker4 = new com.github.lgooddatepicker.components.DateTimePicker();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(740, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(740, 600));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/evaluation.png"))); // NOI18N
        jLabel2.setText("Manage Contests");
        jLabel2.setIconTextGap(10);
        jLabel2.setPreferredSize(new java.awt.Dimension(185, 50));
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel6.setMinimumSize(new java.awt.Dimension(240, 460));
        jPanel6.setPreferredSize(new java.awt.Dimension(240, 460));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8));
        jPanel11.setMinimumSize(new java.awt.Dimension(240, 550));
        jPanel11.setPreferredSize(new java.awt.Dimension(240, 550));
        jPanel11.setLayout(new java.awt.GridLayout(12, 1, 10, 10));

        jLabel7.setText("Contest Name");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jPanel11.add(jLabel7);

        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jTextField3.setMaximumSize(new java.awt.Dimension(400, 30));
        jTextField3.setMinimumSize(new java.awt.Dimension(64, 25));
        jTextField3.setPreferredSize(new java.awt.Dimension(64, 25));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField3);

        jLabel9.setText("Type");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jPanel11.add(jLabel9);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setMaximumSize(new java.awt.Dimension(400, 30));
        jComboBox3.setMinimumSize(new java.awt.Dimension(76, 25));
        jComboBox3.setPreferredSize(new java.awt.Dimension(76, 25));
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox3MouseEntered(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBox3);

        jLabel10.setText("Age ");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jPanel11.add(jLabel10);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setMaximumSize(new java.awt.Dimension(400, 30));
        jComboBox4.setPreferredSize(new java.awt.Dimension(76, 25));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox4MouseEntered(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBox4);

        jLabel11.setText("Start Date");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jPanel11.add(jLabel11);

        dateTimePicker3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateTimePicker3MouseEntered(evt);
            }
        });
        jPanel11.add(dateTimePicker3);

        jLabel12.setText("End Date");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jPanel11.add(jLabel12);

        dateTimePicker4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateTimePicker4MouseEntered(evt);
            }
        });
        jPanel11.add(dateTimePicker4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/add_btn.png"))); // NOI18N
        jButton3.setText("Add Contest");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
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
        jPanel11.add(jButton3);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/update.png"))); // NOI18N
        jButton1.setText("Update Contest");
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton1.setIconTextGap(10);
        jButton1.setMaximumSize(new java.awt.Dimension(400, 30));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton1);

        jPanel6.add(jPanel11);

        jPanel2.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel4.setMinimumSize(new java.awt.Dimension(500, 550));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 550));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ContestID", "Name", "Type", "Age", "Start", "End"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

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
        jPanel4.add(jButton4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setPreferredSize(new java.awt.Dimension(500, 160));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel10.setMinimumSize(new java.awt.Dimension(500, 160));
        jPanel10.setPreferredSize(new java.awt.Dimension(500, 160));

        jPanel8.setPreferredSize(new java.awt.Dimension(500, 40));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Contest Name");
        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 60));
        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 5, 5));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Select Type");
        jLabel19.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jPanel1.add(jLabel19);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jComboBox9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox9MouseEntered(evt);
            }
        });
        jPanel1.add(jComboBox9);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Add  Type");
        jLabel22.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jPanel1.add(jLabel22);

        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jPanel1.add(jTextField2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/add_btn.png"))); // NOI18N
        jButton5.setText("Type");
        jButton5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jButton5.setIconTextGap(8);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Select Age");
        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jPanel1.add(jLabel24);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox5MouseEntered(evt);
            }
        });
        jPanel1.add(jComboBox5);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Add  Age");
        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jPanel1.add(jLabel23);

        jTextField4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jPanel1.add(jTextField4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/add_btn.png"))); // NOI18N
        jButton6.setText("Age");
        jButton6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        jButton6.setIconTextGap(8);
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
        jPanel1.add(jButton6);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search_btn.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton2.setIconTextGap(10);
        jButton2.setMaximumSize(null);
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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel7.add(jPanel4);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            String contestName = jTextField3.getText();
            String contestType = String.valueOf(jComboBox3.getSelectedItem());
            String type = contestTypeMap.get(contestType);

            String contestAge = String.valueOf(jComboBox4.getSelectedItem());
            String age = contestAgeMap.get(contestAge);

            String startDate = dateTimePicker3.getDatePicker().toString();
            String startTime = dateTimePicker3.getTimePicker().toString();
            String contestStartDateTime = startDate + " " + startTime;

            String endDate = dateTimePicker4.getDatePicker().toString();
            String endTime = dateTimePicker4.getTimePicker().toString();
            String contestEndDateTime = endDate + " " + endTime;

            if (contestName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the Contest Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (contestType.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest Type", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (contestAge.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest Age", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (contestStartDateTime.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest Start Date & Time", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (contestEndDateTime.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest End Date & Time", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                String checkQuery = "SELECT * FROM `contest` "
                        + "WHERE `contest_type_id` = ? AND "
                        + "`name` = ? AND "
                        + "`start_datetime` = ? AND "
                        + "`end_datetime` = ? AND "
                        + "`age_id` = ?";
                PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                checkStmt.setString(1, type);
                checkStmt.setString(2, contestName);
                checkStmt.setString(3, contestStartDateTime);
                checkStmt.setString(4, contestEndDateTime);
                checkStmt.setString(5, age);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "The Same Contest already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    // Insert new Contest
                    String insertQuery = "INSERT INTO `contest` (`contest_type_id`, `name`, `start_datetime`, `end_datetime`, `age_id`, `user_id`) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = MySQL.prepareStatement(insertQuery);
                    pstmt.setString(1, contestTypeMap.get(contestType));
                    pstmt.setString(2, contestName);
                    pstmt.setString(3, contestStartDateTime);
                    pstmt.setString(4, contestEndDateTime);
                    pstmt.setString(5, contestAgeMap.get(contestAge));
                    pstmt.setInt(6, Integer.parseInt(this.id));

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Contest added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseEntered
        // TODO add your handling code here:
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox3MouseEntered

    private void jComboBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseEntered
        // TODO add your handling code here:
        jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox4MouseEntered

    private void dateTimePicker3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateTimePicker3MouseEntered
        // TODO add your handling code here:
        dateTimePicker3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_dateTimePicker3MouseEntered

    private void dateTimePicker4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateTimePicker4MouseEntered
        // TODO add your handling code here:
        dateTimePicker4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_dateTimePicker4MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBox9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox9MouseEntered
        // TODO add your handling code here:
        jComboBox9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox9MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        addContestType();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseEntered
        // TODO add your handling code here:
        jComboBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox5MouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        addContestAge();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Update Contest
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow != -1) {
            String name = jTextField3.getText();
            int type = jComboBox3.getSelectedIndex();
            int age = jComboBox4.getSelectedIndex();

            String startDate = dateTimePicker3.getDatePicker().toString();
            String startTime = dateTimePicker3.getTimePicker().toString();
            String contestStartDateTime = startDate + " " + startTime;

            String endDate = dateTimePicker4.getDatePicker().toString();
            String endTime = dateTimePicker4.getTimePicker().toString();
            String contestEndDateTime = endDate + " " + endTime;

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the Contest Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (type == 0) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest Type", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (age == 0) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest Age", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (contestStartDateTime.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest Start Date & Time", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (contestEndDateTime.isBlank()) {
                JOptionPane.showMessageDialog(this, "Please Select the Contest End Date & Time", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                try {

                    String checkQuery = "SELECT * FROM `contest` "
                            + "WHERE `contest_type_id` = ? AND "
                            + "`name` = ? AND "
                            + "`start_datetime` = ? AND "
                            + "`end_datetime` = ? AND "
                            + "`age_id` = ?";
                    PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                    checkStmt.setInt(1, type);
                    checkStmt.setString(2, name);
                    checkStmt.setString(3, contestStartDateTime);
                    checkStmt.setString(4, contestEndDateTime);
                    checkStmt.setInt(5, age);
                    ResultSet resultSet = checkStmt.executeQuery();

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(this, "There is a contest with matching details", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {

                        try {
                            String query = "UPDATE `contest` SET "
                                    + "`contest_type_id` = ?, "
                                    + "`name` = ?, "
                                    + "`start_datetime` = ?, "
                                    + "`end_datetime` = ?, "
                                    + "`age_id` = ?, "
                                    + "`user_id` = ? "
                                    + "WHERE `id` = ?";

                            PreparedStatement pstmt = MySQL.prepareStatement(query);
                            pstmt.setInt(1, type);
                            pstmt.setString(2, name);
                            pstmt.setString(3, contestStartDateTime);
                            pstmt.setString(4, contestEndDateTime);
                            pstmt.setInt(5, age);
                            pstmt.setInt(6, Integer.parseInt(this.id));
                            pstmt.setInt(7, Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()));

                            int rowsUpdated = pstmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(this, "Contest updated successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                                reset();
                            } else {
                                JOptionPane.showMessageDialog(this, "No user was updated.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String contestName = jTextField6.getText();
            String contestType = String.valueOf(jComboBox9.getSelectedItem());
            String type = ManageContests.contestTypeMap.get(contestType);

            String contestAge = String.valueOf(jComboBox5.getSelectedItem());
            String age = ManageContests.contestAgeMap.get(contestAge);

            if (contestName.isEmpty() && contestType.equals("Select") && contestAge.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please enter at least one search criterion.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                StringBuilder queryBuilder = new StringBuilder("SELECT * FROM `contest` "
                        + "INNER JOIN `contest_type` ON `contest`.`contest_type_id` = `contest_type`.`id` "
                        + "INNER JOIN `age` ON `contest`.`age_id` = `age`.`id` ");
                List<Object> parameters = new ArrayList<>();
                List<String> conditions = new ArrayList<>();

                if (!contestName.isBlank()) {
                    conditions.add("`contest`.`name` LIKE ?");
                    parameters.add("%" + contestName + "%"); // For partial match with LIKE
                }
                if (type != null && !type.isEmpty()) { // Null check for type
                    conditions.add("`contest`.`contest_type_id` = ?");
                    parameters.add(type);
                }
                if (age != null && !age.isEmpty()) { // Null check for age
                    conditions.add("`contest`.`age_id` = ?");
                    parameters.add(age);
                }

                if (!conditions.isEmpty()) {
                    queryBuilder.append(" WHERE ");
                    queryBuilder.append(String.join(" AND ", conditions)); // Use AND for strict matching
                }

                String query = queryBuilder.toString();

                try (PreparedStatement pstmt = MySQL.prepareStatement(query)) {
                    for (int i = 0; i < parameters.size(); i++) {
                        pstmt.setObject(i + 1, parameters.get(i));
                    }

                    ResultSet resultSet = pstmt.executeQuery();

                    DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                    tableModel.setRowCount(0);

                    while (resultSet.next()) {
                        String contestID = resultSet.getString("contest.id");
                        String name = resultSet.getString("contest.name");
                        String type2 = resultSet.getString("contest_type.type");
                        String age2 = resultSet.getString("age.age");
                        String start = resultSet.getString("start_datetime");
                        String end = resultSet.getString("end_datetime");

                        Vector<String> row = new Vector<>();
                        row.add(contestID);
                        row.add(name);
                        row.add(type2);
                        row.add(age2);
                        row.add(start);
                        row.add(end);

                        tableModel.addRow(row);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            int selectedRow = jTable2.getSelectedRow();

            String contestName = String.valueOf(jTable2.getValueAt(selectedRow, 1));
            String type = String.valueOf(jTable2.getValueAt(selectedRow, 2));
            String age = String.valueOf(jTable2.getValueAt(selectedRow, 3));
            String startDatetime = String.valueOf(jTable2.getValueAt(selectedRow, 4));
            String endDatetime = String.valueOf(jTable2.getValueAt(selectedRow, 5));

            jTextField3.setText(contestName);
            jComboBox3.setSelectedItem(type);
            jComboBox4.setSelectedItem(age);

            // MySQL DATETIME format is usually "yyyy-MM-dd HH:mm:ss"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime parsedDateTime = LocalDateTime.parse(startDatetime, formatter);
            LocalDateTime parsedEndDateTime = LocalDateTime.parse(endDatetime, formatter);

            // Set the parsed LocalDateTime to DateTimePicker
            dateTimePicker3.setDateTimePermissive(parsedDateTime);
            dateTimePicker4.setDateTimePermissive(parsedEndDateTime);

            jButton3.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);

            jTextField2.setEnabled(false);
            jTextField4.setEnabled(false);

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jButton6MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker3;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
