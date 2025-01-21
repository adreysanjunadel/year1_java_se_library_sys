/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BookManagement;

import model.MySQL;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sanjuna
 */
public class BookHistory extends javax.swing.JPanel {

    public static HashMap<String, String> authorNameMap = new HashMap<>();
    public static HashMap<String, String> languageMap = new HashMap<>();
    public static HashMap<String, String> ageCategoryMap = new HashMap<>();

    /**
     * Creates new form PenaltyHistory
     */
    public BookHistory() {
        initComponents();
        loadAuthors();
        loadLanguages();
        loadAgeCategories();
        loadBooks();
        reset();
    }

    private void loadBooks() {
        try {
            String query = "SELECT book.id, book.isbn, book.name, author.author, language.language, category.category, age.age, book.createdAt, book.updatedAt "
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
                String createdAt = resultSet.getString("book.createdAt");
                String updatedAt = resultSet.getString("book.updatedAt");

                Vector vector = new Vector();
                vector.add(bookId);
                vector.add(ISBN);
                vector.add(bookName);
                vector.add(author);
                vector.add(language);
                vector.add(category);
                vector.add(age);
                vector.add(createdAt);
                vector.add(updatedAt);

                tableModel.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAuthors() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `author`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox2.getModel();
            typeModel.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("author"));
                authorNameMap.put(resultSet.getString("author"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox2.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadLanguages() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `language`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox6.getModel();
            typeModel.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("language"));
                languageMap.put(resultSet.getString("language"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox6.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAgeCategories() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `age`");

            DefaultComboBoxModel typeModel = (DefaultComboBoxModel) jComboBox5.getModel();
            typeModel.removeAllElements();

            Vector v = new Vector();
            v.add("Select");

            while (resultSet.next()) {
                v.add(resultSet.getString("age"));
                ageCategoryMap.put(resultSet.getString("age"), resultSet.getString("id"));
            }

            typeModel.addAll(v);
            jComboBox5.setSelectedIndex(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField3.setText("");
        //jTextField4.setText("");
        jTextField5.setText("");

        //jComboBox1.setSelectedIndex(0);
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
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        dateTimePicker2 = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 160));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/view.png"))); // NOI18N
        jLabel1.setText(" Book History");
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 22)); // NOI18N
        jLabel1.setIconTextGap(10);

        jButton3.setText("Search Books");
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
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

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));

        jPanel5.setPreferredSize(new java.awt.Dimension(740, 77));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Name");
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });

        dateTimePicker2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateTimePicker2MouseEntered(evt);
            }
        });

        jLabel8.setText("ISBN");
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Author");
        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox6MouseEntered(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox5MouseEntered(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Added");
        jLabel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Updated");
        jLabel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 1, 13)); // NOI18N

        jLabel10.setText("Language");
        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N

        jLabel9.setText("Age");
        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N

        dateTimePicker1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateTimePicker1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jComboBox5, 0, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(3, 3, 3)
                        .addComponent(dateTimePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTimePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTimePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTimePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setMinimumSize(new java.awt.Dimension(740, 460));
        jPanel2.setPreferredSize(new java.awt.Dimension(740, 440));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel4.setMinimumSize(new java.awt.Dimension(500, 460));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 460));
        jPanel4.setLayout(new java.awt.BorderLayout());

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
        jPanel4.add(jButton6, java.awt.BorderLayout.PAGE_END);

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 15, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "ISBN", "Name", "Author", "Language", "Category", "Age", "Date Added", "Date Updated"
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        }

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel3.setMinimumSize(new java.awt.Dimension(240, 460));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 460));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Book List Preview");
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/eye.png"))); // NOI18N
        jButton1.setText("View PDF");
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        jButton1.setIconTextGap(10);
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/download.png"))); // NOI18N
        jButton2.setText("Download PDF");
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(12, 12, 12))
        );

        jPanel2.add(jPanel3);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // Search Books
        try {
            String bookName = jTextField3.getText().trim();
            String ISBN = jTextField5.getText().trim();

            String age = String.valueOf(jComboBox5.getSelectedItem());
            String ageRange = ageCategoryMap.get(age);

            String author = String.valueOf(jComboBox2.getSelectedItem());
            String authorName = authorNameMap.get(author);

            String language = String.valueOf(jComboBox6.getSelectedItem());
            String languageName = languageMap.get(language);

            String bookAddedDate = dateTimePicker1.getDatePicker().toString();
            String bookAddedTime = dateTimePicker1.getTimePicker().toString();
            String createdAt = bookAddedDate + " " + bookAddedTime;

            String bookUpdatedDate = dateTimePicker2.getDatePicker().toString();
            String bookUpdatedTime = dateTimePicker2.getTimePicker().toString();
            String updatedAt = bookUpdatedDate + " " + bookUpdatedTime;

            // Check if all fields are empty/selected as "Select"
            if (bookName.isEmpty() && ISBN.isEmpty() && age.equals("Select") && author.equals("Select") && createdAt != null && updatedAt != null) {
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

                if (languageName != null && !languageName.equals("Select")) {
                    conditions.add("`book`.`language_id` = ?");
                    parameters.add(languageName);
                }

                if (!bookAddedDate.isEmpty() && !bookAddedTime.isEmpty()) {
                    conditions.add("`book`.`createdAt` >= ?");
                    parameters.add(createdAt);
                }

                if (!bookUpdatedDate.isEmpty() && !bookUpdatedTime.isEmpty()) {
                    conditions.add("`book`.`updatedAt` <= ?");
                    parameters.add(updatedAt);
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
                        String dateTimeAdded = resultSet.getString("book.createdAt");
                        String dateTimeUpdated = resultSet.getString("book.updatedAt");

                        Vector<String> row = new Vector<>();
                        row.add(bookId);
                        row.add(isbn);
                        row.add(bkName);
                        row.add(authName);
                        row.add(langName);
                        row.add(catName);
                        row.add(ageCat);
                        row.add(dateTimeAdded);
                        row.add(dateTimeUpdated);

                        tableModel.addRow(row);
                    }

                    resultSet.close();
                    pstmt.close();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Resetting Overall Page
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void dateTimePicker1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateTimePicker1MouseEntered
        // TODO add your handling code here:
        dateTimePicker1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_dateTimePicker1MouseEntered

    private void dateTimePicker2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateTimePicker2MouseEntered
        // TODO add your handling code here:
        dateTimePicker1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_dateTimePicker2MouseEntered

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jComboBox6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseEntered
        jComboBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox6MouseEntered

    private void jComboBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseEntered
        jComboBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jComboBox5MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            HashMap<String, Object> map = new HashMap<>();
            String path = "src//Resources/Reports//BookManagement.jasper";

            JRDataSource datasource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(path, map, datasource);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
