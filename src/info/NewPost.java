/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author fabian
 */
public class NewPost extends javax.swing.JFrame {

    /**
     * Creates new form NewPost
     */
    public NewPost() {
        initComponents();
        fillCb();
        cbScienceGroups.setVisible(false);
        cbEduSci.setVisible(false);
        cbCategory.setVisible(false);
    }

    private void clear() {
        textTitle.setText("");
        textMain.setText("");
    }

    private void fillCb() {
        cbSubject.addItem("Informal");
        if (User.getEduAdmin() || User.getResAdmin()) {
            cbSubject.addItem("Formal");
            try {
                String postCategory = "SELECT CATEGORY_NAME FROM CATEGORY";
                ArrayList<String> categories = new ArrayList<String>();
                categories = db.getDB().fetchColumn(postCategory);
                for (String category : categories) {
                    cbCategory.addItem(category);
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            if (User.getEduAdmin()) {
                cbEduSci.addItem("Education");
            }
            if (User.getResAdmin()) {
                cbEduSci.addItem("Science");
                cbEduSci.setSelectedItem("Science");
                try {
                    String category = "SELECT GROUP_NAME FROM RESEARCH_GROUP";
                    ArrayList<String> subjects = new ArrayList<String>();
                    subjects = db.getDB().fetchColumn(category);
                    for (String subject : subjects) {
                        cbScienceGroups.addItem(subject);
                    }
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Forum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPost().setVisible(true);
            }
        });
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textMain = new javax.swing.JEditorPane();
        buttonPost = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonAttach = new javax.swing.JButton();
        panelRibbon = new javax.swing.JPanel();
        textTitle = new javax.swing.JTextField();
        cbSubject = new javax.swing.JComboBox<>();
        cbEduSci = new javax.swing.JComboBox<>();
        cbScienceGroups = new javax.swing.JComboBox<>();
        cbCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(126, 197, 239));
        jPanel1.setPreferredSize(new java.awt.Dimension(998, 613));

        jPanel2.setBackground(new java.awt.Color(44, 95, 125));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 420));

        textMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane1.setViewportView(textMain);

        buttonPost.setBackground(new java.awt.Color(126, 197, 239));
        buttonPost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonPost.setForeground(new java.awt.Color(255, 255, 255));
        buttonPost.setText("Post");
        buttonPost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPostActionPerformed(evt);
            }
        });

        buttonSave.setBackground(new java.awt.Color(126, 197, 239));
        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Save");
        buttonSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        buttonClear.setBackground(new java.awt.Color(126, 197, 239));
        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonClear.setForeground(new java.awt.Color(255, 255, 255));
        buttonClear.setText("Clear text");
        buttonClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonAttach.setBackground(new java.awt.Color(126, 197, 239));
        buttonAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonAttach.setForeground(new java.awt.Color(255, 255, 255));
        buttonAttach.setText("Attach file");
        buttonAttach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        panelRibbon.setBackground(new java.awt.Color(153, 153, 153));
        panelRibbon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout panelRibbonLayout = new javax.swing.GroupLayout(panelRibbon);
        panelRibbon.setLayout(panelRibbonLayout);
        panelRibbonLayout.setHorizontalGroup(
            panelRibbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRibbonLayout.setVerticalGroup(
            panelRibbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        textTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTitleActionPerformed(evt);
            }
        });

        cbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubjectActionPerformed(evt);
            }
        });

        cbEduSci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEduSciActionPerformed(evt);
            }
        });

        cbScienceGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbScienceGroupsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPost, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRibbon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textTitle)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEduSci, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbScienceGroups, 0, 160, Short.MAX_VALUE)))
                .addGap(0, 125, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(panelRibbon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEduSci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbScienceGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPost, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbScienceGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbScienceGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbScienceGroupsActionPerformed

    private void cbEduSciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEduSciActionPerformed
        showCbEduSci();
    }//GEN-LAST:event_cbEduSciActionPerformed

    private void cbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubjectActionPerformed
        String choice = cbSubject.getSelectedItem().toString();
        if (choice.equals("Formal")) {
            cbEduSci.setVisible(true);
            cbCategory.setVisible(true);
        } else {
            cbEduSci.setVisible(false);
            cbScienceGroups.setVisible(false);
        }
    }//GEN-LAST:event_cbSubjectActionPerformed

    private void textTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTitleActionPerformed

    private void buttonPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPostActionPerformed
        if (Validation.checkTextFieldEmpty(textTitle)) {
            try {
                String autoID;
                autoID = db.getDB().getAutoIncrement("POSTS", "POST_ID");
                System.out.println(autoID);
                if (autoID == null) {
                    autoID = "1";
                }

                Calendar cal = Calendar.getInstance();
                Date date = cal.getTime();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = format1.format(date);

                String title = textTitle.getText();
                String mainText = textMain.getText();

                db.getDB().insert("INSERT INTO POSTS VALUES ('" + autoID + "','" + title + "','" + mainText + "','" + date1 + "','" + User.getUser() + "')");
                JOptionPane.showMessageDialog(null, "Post added!");
                clear();

            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }//GEN-LAST:event_buttonPostActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clear();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void showCbEduSci() {
        String choice = cbEduSci.getSelectedItem().toString();
        if (choice.equals("Science")) {
            cbScienceGroups.setVisible(true);
        } else {
            cbScienceGroups.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAttach;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonPost;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbEduSci;
    private javax.swing.JComboBox<String> cbScienceGroups;
    private javax.swing.JComboBox<String> cbSubject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelRibbon;
    private javax.swing.JEditorPane textMain;
    private javax.swing.JTextField textTitle;
    // End of variables declaration//GEN-END:variables

}
