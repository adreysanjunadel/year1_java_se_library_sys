/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BookManagement;

import model.MySQL;
import ContestManagement.ManageContests;
import static ContestManagement.ManageContests.contestTypeMap;
import PenaltyManagement.UI.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Sanjuna
 */
public class ManageBooks extends javax.swing.JPanel {

    public static HashMap<String, String> authorNameMap = new HashMap<>();
    public static HashMap<String, String> languageMap = new HashMap<>();
    public static HashMap<String, String> ageCategoryMap = new HashMap<>();
    public static HashMap<String, String> categoryMap = new HashMap<>();

    public ManageBooks() {
        initComponents();
        loadAuthors();
        loadLanguages();
        loadCategories();
        loadAgeCategories();
        reset();
    }

    private void loadBooks() {
        try {
            String query = "SELECT book.id, book.isbn, book.name, author.author, language.language, category.category, age.age "
                    + "FROM book "
                    + "INNER JOIN author ON book.author_id = author.id "
                    + "INNER JOIN language ON book.language_id = language.id "
                    + "INNER JOIN category ON book.category_id = category.id "
                    + "INNER JOIN age ON book.age_id = age.id";

            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0); // Clear existing rows

            while (resultSet.next()) {
                String bookId = resultSet.getString("id");
                String ISBN = resultSet.getString("isbn");
                String bookName = resultSet.getString("name");
                String author = resultSet.getString("author");
                String language = resultSet.getString("language");
                String category = resultSet.getString("category");
                String age = resultSet.getString("age");

                Vector vector = new Vector();
                vector.add(bookId);
                vector.add(ISBN);
                vector.add(bookName);
                vector.add(author);
                vector.add(language);
                vector.add(category);
                vector.add(age);

                tableModel.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAuthors() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `author`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox3.getModel();
            DefaultComboBoxModel typeModelSearch = (DefaultComboBoxModel) jComboBox5.getModel();
            typeModel.removeAllElements();
            typeModelSearch.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("author"));
                authorNameMap.put(resultSet.getString("author"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox3.setSelectedIndex(0);

            typeModelSearch.addAll(v);
            jComboBox5.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLanguages() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `language`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox4.getModel();
            typeModel.removeAllElements();

            DefaultComboBoxModel typeModelSearch = (DefaultComboBoxModel) jComboBox6.getModel();
            typeModelSearch.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("language"));
                languageMap.put(resultSet.getString("language"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox4.setSelectedIndex(0);

            typeModelSearch.addAll(v);
            jComboBox6.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCategories() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `category`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox7.getModel();
            typeModel.removeAllElements();

            DefaultComboBoxModel typeModelSearch = (DefaultComboBoxModel) jComboBox8.getModel();
            typeModelSearch.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("category"));
                categoryMap.put(resultSet.getString("category"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox2.setSelectedIndex(0);

            typeModelSearch.addAll(v);
            jComboBox1.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAgeCategories() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `age`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox2.getModel();
            typeModel.removeAllElements();

            DefaultComboBoxModel typeModelSearch = (DefaultComboBoxModel) jComboBox1.getModel();
            typeModelSearch.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("age"));
                ageCategoryMap.put(resultSet.getString("age"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox2.setSelectedIndex(0);

            typeModelSearch.addAll(v);
            jComboBox1.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField3.setText("");
        jTextField5.setText("");

        jTextField1.setText("");
        jTextField2.setText("");

        jComboBox8.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);

        jTable1.clearSelection();

        jButton2.setEnabled(true);

        loadBooks();
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
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

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Books");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel3.setText("Name");

        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/add_btn.png"))); // NOI18N
        jButton2.setText("Add Book");
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

        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/update.png"))); // NOI18N
        jButton3.setText("Update Book");
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

        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/trash.png"))); // NOI18N
        jButton4.setText("Delete Book");
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

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel10.setText("ISBN");

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel11.setText("Author");

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel12.setText("Language");

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel13.setText("Age");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox3MouseEntered(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox4MouseEntered(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel14.setText("Category");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox7MouseEntered(evt);
            }
        });
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField3)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField5)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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
                "Book ID", "ISBN", "Name", "Author", "Language", "Category", "Age"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(65);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(65);
        }

        jPanel11.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel2.setText("ISBN");

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel4.setText("Author");

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel6.setText("Language");

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel9.setText("Age");

        jComboBox1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N
        jButton1.setText("Search Books");
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

        jComboBox5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox5MouseEntered(evt);
            }
        });

        jComboBox6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox6MouseEntered(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jLabel15.setText("Category");

        jComboBox8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox8MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, 0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 111, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox8, 0, 74, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel2.setPreferredSize(new java.awt.Dimension(740, 50));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/books-management.png"))); // NOI18N
        jLabel5.setText("Manage Books");
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
        // Add Book
        try {
            String bookName = jTextField3.getText();
            String ISBN = jTextField5.getText();

            String authorName = String.valueOf(jComboBox3.getSelectedItem());
            String author = authorNameMap.get(authorName);

            String languageName = String.valueOf(jComboBox4.getSelectedItem());
            String language = languageMap.get(languageName);

            String categoryName = String.valueOf(jComboBox7.getSelectedItem());
            String category = categoryMap.get(categoryName);

            String ageCategory = String.valueOf(jComboBox2.getSelectedItem());
            String age = ageCategoryMap.get(ageCategory);

            if (bookName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the Book Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (ISBN.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the ISBN Code", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (author == null || author.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Enter the Author's Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (language == null || language.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Language", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (category == null || category.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Suitable Category", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (age == null || age.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Suitable Age Range", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                String checkQuery = "SELECT * FROM `book` "
                        + "WHERE `isbn` = ? AND "
                        + "`name` = ? AND "
                        + "`author_id` = ? AND "
                        + "`language_id` = ? AND "
                        + "`category_id` = ? AND "
                        + "`age_id` = ?";

                PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                checkStmt.setString(1, ISBN);
                checkStmt.setString(2, bookName);
                checkStmt.setString(3, author);
                checkStmt.setString(4, language);
                checkStmt.setString(5, category);
                checkStmt.setString(6, age);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    // Just adding another book
                } else {

                    //Insert New Book
                    String insertQuery = "INSERT INTO `book` (`isbn`, `name`, `author_id`, `language_id`, `category_id`, `age_id`, `status_id`, `createdAt`, `updatedAt`) "
                            + "VALUES (?, ?, ?, ?, ?, ?, 1, NOW(), NOW())";

                    PreparedStatement pstmt = MySQL.prepareStatement(insertQuery);
                    pstmt.setString(1, ISBN);
                    pstmt.setString(2, bookName);
                    pstmt.setString(3, author);
                    pstmt.setString(4, language);
                    pstmt.setString(5, category);
                    pstmt.setString(6, age);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Book added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Update Book
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            String bookName = jTextField3.getText();
            String ISBN = jTextField5.getText();

            int bookId = Integer.parseInt(String.valueOf(jTable1.getValueAt(selectedRow, 0)));

            String authorName = String.valueOf(jComboBox3.getSelectedItem());
            String author = authorNameMap.get(authorName);

            String languageName = String.valueOf(jComboBox4.getSelectedItem());
            String language = languageMap.get(languageName);

            String categoryName = String.valueOf(jComboBox7.getSelectedItem());
            String category = categoryMap.get(categoryName);

            String ageCategory = String.valueOf(jComboBox2.getSelectedItem());
            String age = ageCategoryMap.get(ageCategory);

            if (bookName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the Book Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (ISBN.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the ISBN Code", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (author == null || author.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Enter the Author's Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (language == null || language.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Language", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (category == null || category.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Suitable Category", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (age == null || age.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Suitable Age Range", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                try {

                    String checkQuery = "SELECT * FROM `book` "
                            + "WHERE `isbn` = ? AND "
                            + "`name` = ? AND "
                            + "`author_id` = ? AND "
                            + "`language_id` = ? AND "
                            + "`category_id` = ? AND "
                            + "`age_id` = ?";

                    PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                    checkStmt.setString(1, ISBN);
                    checkStmt.setString(2, bookName);
                    checkStmt.setString(3, author);
                    checkStmt.setString(4, language);
                    checkStmt.setString(5, category);
                    checkStmt.setString(6, age);
                    ResultSet resultSet = checkStmt.executeQuery();

                    if (resultSet.next()) {

                    } else {

                        // Update Book Try Catch
                        try {

                            String updateQuery = "UPDATE `book` SET "
                                    + "`isbn` = ?, "
                                    + "`name` = ?, "
                                    + "`author_id` = ?, "
                                    + "`language_id` = ?, "
                                    + "`category_id` = ?, "
                                    + "`age_id` = ?, "
                                    + "`updatedAt` = NOW() "
                                    + "WHERE `book`.`id` = ?";
                            PreparedStatement pstmt = MySQL.prepareStatement(updateQuery);
                            pstmt.setString(1, ISBN);
                            pstmt.setString(2, bookName);
                            pstmt.setString(3, author);
                            pstmt.setString(4, language);
                            pstmt.setString(5, category);
                            pstmt.setString(6, age);
                            pstmt.setInt(7, bookId);

                            System.out.println("Updating book with ID: " + bookId);
                            System.out.println("ISBN: " + ISBN);
                            System.out.println("Book Name: " + bookName);
                            System.out.println("Author ID: " + author);
                            System.out.println("Language ID: " + language);
                            System.out.println("Category ID: " + category);
                            System.out.println("Age ID: " + age);

                            int rowsUpdated = pstmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(this, "Book updated successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                                reset();
                            } else {
                                JOptionPane.showMessageDialog(this, "No book was updated.", "Info", JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Delete Books
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            String bookName = jTextField3.getText();
            String ISBN = jTextField5.getText();

            int bookId = Integer.parseInt(String.valueOf(jTable1.getValueAt(selectedRow, 0)));

            String authorName = String.valueOf(jComboBox3.getSelectedItem());
            String author = authorNameMap.get(authorName);

            String languageName = String.valueOf(jComboBox4.getSelectedItem());
            String language = languageMap.get(languageName);

            String categoryName = String.valueOf(jComboBox7.getSelectedItem());
            String category = categoryMap.get(categoryName);

            String ageCategory = String.valueOf(jComboBox2.getSelectedItem());
            String age = ageCategoryMap.get(ageCategory);

            if (bookName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the Book Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (ISBN.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter the ISBN Code", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (author == null || author.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Enter the Author's Name", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (language == null || language.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Language", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (category == null || category.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Suitable Category", "Warning", JOptionPane.ERROR_MESSAGE);
            } else if (age == null || age.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please Select the Suitable Age Range", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {

                try {
                    // Check if the book exists with the specified details
                    String checkQuery = "SELECT * FROM `book` "
                            + "WHERE `isbn` = ? AND "
                            + "`name` = ? AND "
                            + "`author_id` = ? AND "
                            + "`language_id` = ? AND "
                            + "`category_id` = ? AND "
                            + "`age_id` = ?";

                    PreparedStatement checkStmt = MySQL.prepareStatement(checkQuery);
                    checkStmt.setString(1, ISBN);
                    checkStmt.setString(2, bookName);
                    checkStmt.setString(3, author);
                    checkStmt.setString(4, language);
                    checkStmt.setString(5, category);
                    checkStmt.setString(6, age);
                    ResultSet resultSet = checkStmt.executeQuery();

                    if (resultSet.next()) {
                        // Delete the book if it exists
                        try {
                            String deleteQuery = "DELETE FROM `book` WHERE `id` = ?";
                            PreparedStatement pstmt = MySQL.prepareStatement(deleteQuery);
                            pstmt.setInt(1, bookId);

                            int rowsDeleted = pstmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                JOptionPane.showMessageDialog(this, "Book deleted successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                                reset();
                            } else {
                                JOptionPane.showMessageDialog(this, "No book was deleted.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "The Book you want to delete is not found", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        // TODO add your handling code here:
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Resetting Overall Page
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Value Double Click
        if (evt.getClickCount() == 2) {

            int selectedRow = jTable1.getSelectedRow();

            String bookName = String.valueOf(jTable1.getValueAt(selectedRow, 2));
            String isbn = String.valueOf(jTable1.getValueAt(selectedRow, 1));
            String author = String.valueOf(jTable1.getValueAt(selectedRow, 3));
            String language = String.valueOf(jTable1.getValueAt(selectedRow, 4));
            String category = String.valueOf(jTable1.getValueAt(selectedRow, 5));
            String age = String.valueOf(jTable1.getValueAt(selectedRow, 6));

            jTextField3.setText(bookName);
            jTextField5.setText(isbn);

            jComboBox3.setSelectedItem(author);
            jComboBox4.setSelectedItem(language);
            jComboBox7.setSelectedItem(category);
            jComboBox2.setSelectedItem(age);

            jButton2.setEnabled(false);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Search Books
        try {
            String bookName = jTextField1.getText().trim();
            String ISBN = jTextField2.getText().trim();

            String age = String.valueOf(jComboBox1.getSelectedItem());
            String ageRange = ageCategoryMap.get(age);

            String author = String.valueOf(jComboBox5.getSelectedItem());
            String authorName = authorNameMap.get(author);

            String language = String.valueOf(jComboBox6.getSelectedItem());
            String languageName = languageMap.get(language);

            String category = String.valueOf(jComboBox8.getSelectedItem());
            String categoryName = categoryMap.get(category);

            // Check if all fields are empty/selected as "Select"
            if (bookName.isEmpty() && ISBN.isEmpty() && age.equals("Select") && author.equals("Select") && language.equals("Select") && category.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please enter at least one search criterion.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Start building the SQL query
                StringBuilder queryBuilder = new StringBuilder("SELECT * FROM `book` "
                        + "INNER JOIN `author` ON `author`.`id` = `book`.`author_id` "
                        + "INNER JOIN `language` ON `language`.`id` = `book`.`language_id` "
                        + "INNER JOIN `category` ON `category`.`id` = `book`.`category_id` "
                        + "INNER JOIN `age` ON `age`.`id` = `book`.`age_id` "
                        + "INNER JOIN `status` ON `status`.`id` = `book`.`status_id` ");
                List<Object> parameters = new ArrayList<>();
                List<String> conditions = new ArrayList<>();

                // Add conditions based on user input
                if (!bookName.isEmpty()) {
                    conditions.add("`book`.`name` LIKE ?");
                    parameters.add("%" + bookName + "%");
                }

                if (!ISBN.isEmpty()) {
                    conditions.add("`book`.`isbn` LIKE ?");
                    parameters.add("%" + ISBN + "%");
                }

                if (ageRange != null && !ageRange.equals("Select")) {
                    conditions.add("`book`.`age_id` = ?");
                    parameters.add(ageRange);
                }

                if (authorName != null && !authorName.equals("Select")) {
                    conditions.add("`book`.`author_id` = ?");
                    parameters.add(authorName);
                }

                if (categoryName != null && !categoryName.equals("Select")) {
                    conditions.add("`book`.`category_id` = ?");
                    parameters.add(categoryName);
                }

                if (languageName != null && !languageName.equals("Select")) {
                    conditions.add("`book`.`language_id` = ?");
                    parameters.add(languageName);
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

                    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                    tableModel.setRowCount(0);

                    while (resultSet.next()) {
                        String bookId = resultSet.getString("book.id");
                        String isbn = resultSet.getString("book.isbn");
                        String bkName = resultSet.getString("book.name");
                        String authName = resultSet.getString("author.author");
                        String langName = resultSet.getString("language.language");
                        String catName = resultSet.getString("category.category");
                        String ageCat = resultSet.getString("age.age");

                        Vector<String> row = new Vector<>();
                        row.add(bookId);
                        row.add(isbn);
                        row.add(bkName);
                        row.add(authName);
                        row.add(langName);
                        row.add(catName);
                        row.add(ageCat);

                        tableModel.addRow(row);
                    }

                    resultSet.close();
                    pstmt.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseEntered
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox3MouseEntered

    private void jComboBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseEntered
        jComboBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox4MouseEntered

    private void jComboBox7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox7MouseEntered
        jComboBox7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox7MouseEntered

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseEntered
        jComboBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jComboBox5MouseEntered

    private void jComboBox6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseEntered
        jComboBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox6MouseEntered

    private void jComboBox8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox8MouseEntered
        jComboBox8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox8MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
