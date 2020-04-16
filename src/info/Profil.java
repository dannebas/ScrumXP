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
        
        setExtendedState(MAXIMIZED_BOTH);
        
        lblUserNameProfile.setText(User.getName());
        lblUserEmail.setText(User.getMail());
        
        ArrayList<String> groups = User.getUserGroups();
        
        
        
        for (String s : groups) {
            txaGroups.append(s + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProfile = new javax.swing.JPanel();
        pnlFooterProfile = new javax.swing.JPanel();
        lblFooterImageProfil = new javax.swing.JLabel();
        pnlBread1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        pnlUserPicture = new javax.swing.JPanel();
        lblProfileImage = new javax.swing.JLabel();
        lblEditProfile = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaGroups = new javax.swing.JTextArea();
        pnlUserInfoBackground = new javax.swing.JPanel();
        lblUserNameProfile = new javax.swing.JLabel();
        lblEmailProfile = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblNameProfile = new javax.swing.JLabel();
        pnlUserMeetingAndPostBackground = new javax.swing.JPanel();
        cbMeetingProfile = new javax.swing.JComboBox<>();
        cbNewPostProfile = new javax.swing.JComboBox<>();
        lblHeaderImageProfile = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 760));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlProfile.setPreferredSize(new java.awt.Dimension(1028, 700));

        pnlFooterProfile.setPreferredSize(new java.awt.Dimension(1024, 186));

        lblFooterImageProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblFooterImageProfil.setPreferredSize(new java.awt.Dimension(1024, 204));

        javax.swing.GroupLayout pnlFooterProfileLayout = new javax.swing.GroupLayout(pnlFooterProfile);
        pnlFooterProfile.setLayout(pnlFooterProfileLayout);
        pnlFooterProfileLayout.setHorizontalGroup(
            pnlFooterProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooterImageProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFooterProfileLayout.setVerticalGroup(
            pnlFooterProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterProfileLayout.createSequentialGroup()
                .addComponent(lblFooterImageProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlBread1.setBackground(new java.awt.Color(179, 218, 241));
        pnlBread1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread1.setPreferredSize(new java.awt.Dimension(1024, 350));

        jLayeredPane2.setLayout(new java.awt.CardLayout());

        pnlUserPicture.setBackground(new java.awt.Color(102, 102, 102));
        pnlUserPicture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlUserPicture.setForeground(new java.awt.Color(102, 102, 102));

        lblProfileImage.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileImage.setText("Bild");

        javax.swing.GroupLayout pnlUserPictureLayout = new javax.swing.GroupLayout(pnlUserPicture);
        pnlUserPicture.setLayout(pnlUserPictureLayout);
        pnlUserPictureLayout.setHorizontalGroup(
            pnlUserPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserPictureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfileImage)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        pnlUserPictureLayout.setVerticalGroup(
            pnlUserPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserPictureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfileImage)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        lblEditProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEditProfile.setForeground(new java.awt.Color(0, 51, 204));
        lblEditProfile.setText("Redigera profil");
        lblEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditProfileMouseClicked(evt);
            }
        });

        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        txaGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        jScrollPane3.setViewportView(txaGroups);

        pnlUserInfoBackground.setBackground(new java.awt.Color(44, 95, 125));
        pnlUserInfoBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblUserNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblUserNameProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblUserNameProfile.setText("UserName");

        lblEmailProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEmailProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailProfile.setText("E-mail:");

        lblUserEmail.setBackground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblUserEmail.setText("UserEmail");

        lblNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblNameProfile.setText("Name:");

        javax.swing.GroupLayout pnlUserInfoBackgroundLayout = new javax.swing.GroupLayout(pnlUserInfoBackground);
        pnlUserInfoBackground.setLayout(pnlUserInfoBackgroundLayout);
        pnlUserInfoBackgroundLayout.setHorizontalGroup(
            pnlUserInfoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserInfoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserInfoBackgroundLayout.createSequentialGroup()
                        .addComponent(lblNameProfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUserNameProfile))
                    .addGroup(pnlUserInfoBackgroundLayout.createSequentialGroup()
                        .addComponent(lblEmailProfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlUserInfoBackgroundLayout.setVerticalGroup(
            pnlUserInfoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserInfoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserNameProfile)
                    .addComponent(lblNameProfile))
                .addGap(18, 18, 18)
                .addGroup(pnlUserInfoBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailProfile)
                    .addComponent(lblUserEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUserMeetingAndPostBackground.setBackground(new java.awt.Color(44, 95, 125));
        pnlUserMeetingAndPostBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cbMeetingProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New meeting", "See meeting", "Edit meeting" }));
        cbMeetingProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMeetingProfileActionPerformed(evt);
            }
        });

        cbNewPostProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New post", "See post", "Edit post", "See your posts" }));
        cbNewPostProfile.setToolTipText("");
        cbNewPostProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNewPostProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserMeetingAndPostBackgroundLayout = new javax.swing.GroupLayout(pnlUserMeetingAndPostBackground);
        pnlUserMeetingAndPostBackground.setLayout(pnlUserMeetingAndPostBackgroundLayout);
        pnlUserMeetingAndPostBackgroundLayout.setHorizontalGroup(
            pnlUserMeetingAndPostBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserMeetingAndPostBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserMeetingAndPostBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbNewPostProfile, 0, 154, Short.MAX_VALUE)
                    .addComponent(cbMeetingProfile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlUserMeetingAndPostBackgroundLayout.setVerticalGroup(
            pnlUserMeetingAndPostBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserMeetingAndPostBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbNewPostProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbMeetingProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBread1Layout = new javax.swing.GroupLayout(pnlBread1);
        pnlBread1.setLayout(pnlBread1Layout);
        pnlBread1Layout.setHorizontalGroup(
            pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBread1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
            .addGroup(pnlBread1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBread1Layout.createSequentialGroup()
                        .addComponent(pnlUserPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlUserInfoBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEditProfile))
                .addGap(63, 63, 63)
                .addComponent(pnlUserMeetingAndPostBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        pnlBread1Layout.setVerticalGroup(
            pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBread1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBread1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlUserPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBread1Layout.createSequentialGroup()
                            .addComponent(pnlUserMeetingAndPostBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(54, 54, 54)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUserInfoBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEditProfile)
                .addGap(10, 10, 10)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblHeaderImageProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblHeaderImageProfile.setText("jLabel4");
        lblHeaderImageProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblHeaderImageProfile.setPreferredSize(new java.awt.Dimension(1024, 204));

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Log out");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
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
                .addGap(48, 48, 48)
                .addComponent(btnSeePostResearch)
                .addGap(46, 46, 46)
                .addComponent(btnSeePostGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(80, 80, 80))
        );
        pnlNavBarSeePostLayout.setVerticalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavBarSeePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeePostEducation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeePostResearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeePostGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(btnSeePostHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlProfileLayout = new javax.swing.GroupLayout(pnlProfile);
        pnlProfile.setLayout(pnlProfileLayout);
        pnlProfileLayout.setHorizontalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileLayout.createSequentialGroup()
                .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlBread1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeaderImageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
            .addComponent(pnlFooterProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        pnlProfileLayout.setVerticalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileLayout.createSequentialGroup()
                .addComponent(lblHeaderImageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBread1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooterProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        getContentPane().add(pnlProfile);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditProfileMouseClicked
        a = new EditProfile(this);
        a.setVisible(true);
    }//GEN-LAST:event_lblEditProfileMouseClicked

    public void updateProfile(ImageIcon myIcon) {
        lblProfileImage.setIcon(myIcon);
    }

    public void updateProfileTexts(String mail) {
        
        lblUserEmail.setText(mail);
    }

    private void cbNewPostProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNewPostProfileActionPerformed
        int index = cbNewPostProfile.getSelectedIndex();
        String chosenIndexText = cbNewPostProfile.getItemAt(index);

        //New post, See post, Edit post
        switch (chosenIndexText) {
            case "New post":
                new NewPost().setVisible(true);
                break;
            case "See post":
                JOptionPane.showMessageDialog(null, "See post");
                // new SeePost().setVisible(true);
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
    }//GEN-LAST:event_cbNewPostProfileActionPerformed

    private void cbMeetingProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMeetingProfileActionPerformed
        int index = cbMeetingProfile.getSelectedIndex();
        String chosenIndexText = cbMeetingProfile.getItemAt(index);

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
    }//GEN-LAST:event_cbMeetingProfileActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        new Forum().setVisible(true);
        this.dispose();//addAllForumPost();

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       
        new LogInGUI().setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.JComboBox<String> cbMeetingProfile;
    private javax.swing.JComboBox<String> cbNewPostProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEditProfile;
    private javax.swing.JLabel lblEmailProfile;
    private javax.swing.JLabel lblFooterImageProfil;
    private javax.swing.JLabel lblHeaderImageProfile;
    private javax.swing.JLabel lblNameProfile;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserNameProfile;
    private javax.swing.JPanel pnlBread1;
    private javax.swing.JPanel pnlFooterProfile;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlUserInfoBackground;
    private javax.swing.JPanel pnlUserMeetingAndPostBackground;
    private javax.swing.JPanel pnlUserPicture;
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
