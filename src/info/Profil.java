/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Viggo
 */
public class Profil extends javax.swing.JFrame {

    private EditProfile a;

    public Profil() {
        initComponents();
        
        ArrayList<String> groups = User.getUserGroups();
        groups.add("abc");
        groups.add("EFG");
        groups.add("HIG");
        for(String s : groups)
        {
            txaGroups.append(s + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProfil = new javax.swing.JPanel();
        pnlFooterProfil = new javax.swing.JPanel();
        lblFooterImageProfil = new javax.swing.JLabel();
        pnlBread1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblProfilBild = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTele = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaGroups = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlProfil.setPreferredSize(new java.awt.Dimension(1024, 1500));

        lblFooterImageProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlFooterProfilLayout = new javax.swing.GroupLayout(pnlFooterProfil);
        pnlFooterProfil.setLayout(pnlFooterProfilLayout);
        pnlFooterProfilLayout.setHorizontalGroup(
            pnlFooterProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooterImageProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFooterProfilLayout.setVerticalGroup(
            pnlFooterProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterProfilLayout.createSequentialGroup()
                .addComponent(lblFooterImageProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlBread1.setBackground(new java.awt.Color(102, 204, 255));
        pnlBread1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread1.setPreferredSize(new java.awt.Dimension(1024, 350));

        jLayeredPane2.setLayout(new java.awt.CardLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New post", "See post", "Edit post", "See your posts" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New meeting", "See meeting", "Edit meeting" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Namn");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Telefon");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Mail");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        lblProfilBild.setText("jLabel18");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfilBild)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfilBild)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Redigera profil");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Posts");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Meetings");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("jLabel3");

        lblTele.setBackground(new java.awt.Color(0, 0, 0));
        lblTele.setText("jLabel4");

        lblMail.setBackground(new java.awt.Color(0, 0, 0));
        lblMail.setText("jLabel11");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Groups");

        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        jScrollPane3.setViewportView(txaGroups);

        javax.swing.GroupLayout pnlBread1Layout = new javax.swing.GroupLayout(pnlBread1);
        pnlBread1.setLayout(pnlBread1Layout);
        pnlBread1Layout.setHorizontalGroup(
            pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBread1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
            .addGroup(pnlBread1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBread1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblTele)
                            .addComponent(lblMail)))
                    .addGroup(pnlBread1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBread1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBread1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox2, 0, 190, Short.MAX_VALUE)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        pnlBread1Layout.setVerticalGroup(
            pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBread1Layout.createSequentialGroup()
                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBread1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBread1Layout.createSequentialGroup()
                                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lblTele))
                                .addGap(18, 18, 18)
                                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblMail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlBread1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBread1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addGap(4, 4, 4)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBread1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(pnlBread1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        jLabel8.setText("jLabel3");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        jLabel5.setText("jLabel4");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setPreferredSize(new java.awt.Dimension(1024, 50));

        btnSeePostHome.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostHome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostHome.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostHome.setText("Home");
        btnSeePostHome.setBorder(null);
        btnSeePostHome.setBorderPainted(false);
        btnSeePostHome.setContentAreaFilled(false);
        btnSeePostHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostHomeActionPerformed(evt);
            }
        });

        btnSeePostEducation.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostEducation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostEducation.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostEducation.setText("Education");
        btnSeePostEducation.setBorder(null);
        btnSeePostEducation.setBorderPainted(false);
        btnSeePostEducation.setContentAreaFilled(false);
        btnSeePostEducation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostEducationActionPerformed(evt);
            }
        });

        btnSeePostResearch.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostResearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostResearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostResearch.setText("Research");
        btnSeePostResearch.setBorder(null);
        btnSeePostResearch.setBorderPainted(false);
        btnSeePostResearch.setContentAreaFilled(false);
        btnSeePostResearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostResearchActionPerformed(evt);
            }
        });

        btnSeePostGeneral.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostGeneral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostGeneral.setText("General");
        btnSeePostGeneral.setBorder(null);
        btnSeePostGeneral.setBorderPainted(false);
        btnSeePostGeneral.setContentAreaFilled(false);
        btnSeePostGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostGeneralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavBarSeePostLayout = new javax.swing.GroupLayout(pnlNavBarSeePost);
        pnlNavBarSeePost.setLayout(pnlNavBarSeePostLayout);
        pnlNavBarSeePostLayout.setHorizontalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavBarSeePostLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnSeePostHome)
                .addGap(40, 40, 40)
                .addComponent(btnSeePostEducation)
                .addGap(56, 56, 56)
                .addComponent(btnSeePostResearch)
                .addGap(51, 51, 51)
                .addComponent(btnSeePostGeneral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNavBarSeePostLayout.setVerticalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavBarSeePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeePostEducation, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(btnSeePostHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeePostResearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeePostGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlProfilLayout = new javax.swing.GroupLayout(pnlProfil);
        pnlProfil.setLayout(pnlProfilLayout);
        pnlProfilLayout.setHorizontalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBread1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
            .addGroup(pnlProfilLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfilLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlFooterProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlProfilLayout.setVerticalGroup(
            pnlProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(pnlBread1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooterProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(669, 669, 669)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        getContentPane().add(pnlProfil);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        a = new EditProfile(this);
        a.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    public void updateProfile(ImageIcon myIcon) {
        lblProfilBild.setIcon(myIcon);
    }

    public void updateProfileTexts(String phone, String mail) {
        lblTele.setText(phone);
        lblMail.setText(mail);
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int index = jComboBox1.getSelectedIndex();
        String chosenIndexText = jComboBox1.getItemAt(index);

        //New post, See post, Edit post
        switch (chosenIndexText) {
            case "New post":
                JOptionPane.showMessageDialog(null, "New post");
                new NewPost().setVisible(true);
                break;
            case "See post":
                JOptionPane.showMessageDialog(null, "See post");
                new SeePost().setVisible(true);
                //Metod
                break;
            case "Edit post":
                JOptionPane.showMessageDialog(null, "Edit post");
                //Metod
                break;
            case "See your posts":
                JOptionPane.showMessageDialog(null, "See your posts");
                new SeeYourPost().setVisible(true);
                break;
            default:

        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int index = jComboBox2.getSelectedIndex();
        String chosenIndexText = jComboBox2.getItemAt(index);

        //New meeting, See meeting, Edit meeting
        switch (chosenIndexText) {
            case "New meeting":
                JOptionPane.showMessageDialog(null, "New meeting");
                new Booking().setVisible(true);
                break;
            case "See meeting":
                JOptionPane.showMessageDialog(null, "See meeting");
                new SeeBooking().setVisible(true);
                break;
            case "Edit meeting":
                JOptionPane.showMessageDialog(null, "Edit meeting");
                //Metod
                break;
            default:

        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        //addAllForumPost();

    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void btnSeePostEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostEducationActionPerformed

        //addCategoryForumPost(getEducationCategoryID());

    }//GEN-LAST:event_btnSeePostEducationActionPerformed

    private void btnSeePostResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostResearchActionPerformed
        //addCategoryForumPost(getResearchCategoryID());
    }//GEN-LAST:event_btnSeePostResearchActionPerformed

    private void btnSeePostGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneralActionPerformed
        //addAllGeneralPost();
    }//GEN-LAST:event_btnSeePostGeneralActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFooterImageProfil;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblProfilBild;
    private javax.swing.JLabel lblTele;
    private javax.swing.JPanel pnlBread1;
    private javax.swing.JPanel pnlFooterProfil;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlProfil;
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
