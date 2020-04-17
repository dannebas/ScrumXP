/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.PictureHandler;
import dbUtils.db;
import dbUtils.dbConnection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Viggo
 */
public class Profil extends javax.swing.JFrame {

    private EditProfile a;
    
    private Forum forum;
    

    public Profil() {
        initComponents();

        setExtendedState(MAXIMIZED_BOTH);

        lblUserNameProfile.setText(User.getName());
        lblUserEmail.setText(User.getMail());

        ArrayList<String> groups = User.getUserGroups();

        
        forum = new Forum();
        
        for (String s : groups) {
            txaGroups.append(s + "\n");
        }
        displayProfileImage();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProfile = new javax.swing.JPanel();
        pnlFooterProfile = new javax.swing.JPanel();
        lblFooterImageProfil = new javax.swing.JLabel();
        pnlBread1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
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
        btnEditProfile = new javax.swing.JButton();
        lblProfileImage = new javax.swing.JLabel();
        lblHeaderImageProfile = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1066, 1758));
        setSize(new java.awt.Dimension(1024, 2000));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlProfile.setPreferredSize(new java.awt.Dimension(1024, 768));
        pnlProfile.setRequestFocusEnabled(false);

        pnlFooterProfile.setPreferredSize(new java.awt.Dimension(1024, 186));

        lblFooterImageProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblFooterImageProfil.setPreferredSize(new java.awt.Dimension(1022, 148));

        javax.swing.GroupLayout pnlFooterProfileLayout = new javax.swing.GroupLayout(pnlFooterProfile);
        pnlFooterProfile.setLayout(pnlFooterProfileLayout);
        pnlFooterProfileLayout.setHorizontalGroup(
            pnlFooterProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterProfileLayout.createSequentialGroup()
                .addComponent(lblFooterImageProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFooterProfileLayout.setVerticalGroup(
            pnlFooterProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterProfileLayout.createSequentialGroup()
                .addComponent(lblFooterImageProfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        pnlBread1.setBackground(new java.awt.Color(179, 218, 241));
        pnlBread1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread1.setPreferredSize(new java.awt.Dimension(1024, 350));
        pnlBread1.setLayout(null);

        jLayeredPane2.setLayout(new java.awt.CardLayout());
        pnlBread1.add(jLayeredPane2);
        jLayeredPane2.setBounds(727, 214, 0, 0);

        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        txaGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        jScrollPane3.setViewportView(txaGroups);
        txaGroups.getAccessibleContext().setAccessibleDescription("");

        pnlBread1.add(jScrollPane3);
        jScrollPane3.setBounds(510, 20, 210, 180);

        pnlUserInfoBackground.setBackground(new java.awt.Color(44, 95, 125));
        pnlUserInfoBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlUserInfoBackground.setLayout(null);

        lblUserNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblUserNameProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblUserNameProfile.setText("UserName");
        pnlUserInfoBackground.add(lblUserNameProfile);
        lblUserNameProfile.setBounds(56, 8, 190, 16);

        lblEmailProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEmailProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailProfile.setText("E-mail:");
        pnlUserInfoBackground.add(lblEmailProfile);
        lblEmailProfile.setBounds(10, 30, 38, 16);

        lblUserEmail.setBackground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblUserEmail.setText("UserEmail");
        pnlUserInfoBackground.add(lblUserEmail);
        lblUserEmail.setBounds(60, 30, 198, 16);

        lblNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblNameProfile.setText("Name:");
        pnlUserInfoBackground.add(lblNameProfile);
        lblNameProfile.setBounds(8, 8, 36, 16);

        pnlBread1.add(pnlUserInfoBackground);
        pnlUserInfoBackground.setBounds(130, 10, 300, 100);

        pnlUserMeetingAndPostBackground.setBackground(new java.awt.Color(44, 95, 125));
        pnlUserMeetingAndPostBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlUserMeetingAndPostBackground.setMaximumSize(new java.awt.Dimension(32767, 200));
        pnlUserMeetingAndPostBackground.setPreferredSize(new java.awt.Dimension(179, 200));
        pnlUserMeetingAndPostBackground.setLayout(null);

        cbMeetingProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New meeting", "See meeting", "Edit meeting" }));
        cbMeetingProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMeetingProfileActionPerformed(evt);
            }
        });
        pnlUserMeetingAndPostBackground.add(cbMeetingProfile);
        cbMeetingProfile.setBounds(8, 52, 154, 26);

        cbNewPostProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New post", "See post", "Edit post", "See your posts" }));
        cbNewPostProfile.setToolTipText("");
        cbNewPostProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNewPostProfileActionPerformed(evt);
            }
        });
        pnlUserMeetingAndPostBackground.add(cbNewPostProfile);
        cbNewPostProfile.setBounds(8, 8, 154, 26);

        pnlBread1.add(pnlUserMeetingAndPostBackground);
        pnlUserMeetingAndPostBackground.setBounds(730, 20, 170, 127);

        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });
        pnlBread1.add(btnEditProfile);
        btnEditProfile.setBounds(10, 170, 100, 32);

        lblProfileImage.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileImage.setText("Profile picture");
        lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
        pnlBread1.add(lblProfileImage);
        lblProfileImage.setBounds(10, 10, 110, 145);

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
                .addGap(39, 39, 39)
                .addComponent(btnSeePostEducation)
                .addGap(50, 50, 50)
                .addComponent(btnSeePostResearch)
                .addGap(47, 47, 47)
                .addComponent(btnSeePostGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );
        pnlNavBarSeePostLayout.setVerticalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavBarSeePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeePostHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeePostEducation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeePostResearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeePostGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlProfileLayout = new javax.swing.GroupLayout(pnlProfile);
        pnlProfile.setLayout(pnlProfileLayout);
        pnlProfileLayout.setHorizontalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFooterProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlProfileLayout.createSequentialGroup()
                .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeaderImageProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBread1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlProfileLayout.setVerticalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeaderImageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBread1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooterProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlProfile);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void updateProfile(ImageIcon myIcon) {

       displayProfileImage();
    }

    public void updateProfileTexts(String mail) {

        lblUserEmail.setText(mail);
    }

    public void displayProfileImage() {

        try {
            byte[] b = db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = '" + User.getUser() + "'");
            PictureHandler handler = new PictureHandler(110, 145);

            ImageIcon image = new ImageIcon(b);
            Image picture = handler.resize(image.getImage());
            ImageIcon resized = new ImageIcon(picture);
            lblProfileImage.setIcon(resized);

        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("Not found");
            lblProfileImage.setIcon(null);
        }

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
        forum.setVisible(true);
        
        forum.swicthCategoryButtons(false);
        
        forum.addAllGeneralPost();
       
        this.dispose();//addAllForumPost();

    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void btnSeePostEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostEducationActionPerformed

        forum.swicthCategoryButtons(false);
        
        forum.addEducationForumPost();
        
        forum.setVisible(true);
        
        
        
        
        this.dispose();
    }//GEN-LAST:event_btnSeePostEducationActionPerformed

    private void btnSeePostResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostResearchActionPerformed
       
        
        forum.addResearchForumPost();
        
        forum.setVisible(true);
        
        forum.swicthCategoryButtons(true);
        
        
        this.dispose();
    }//GEN-LAST:event_btnSeePostResearchActionPerformed

    private void btnSeePostGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneralActionPerformed
       
        
        forum.addAllGeneralPost();
        
        forum.setVisible(true);
        
        forum.swicthCategoryButtons(false);
        
        
        this.dispose();
    }//GEN-LAST:event_btnSeePostGeneralActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        new LogInGUI().setVisible(true);

        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        a = new EditProfile(this);
        a.setVisible(true);
       
    }//GEN-LAST:event_btnEditProfileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.JComboBox<String> cbMeetingProfile;
    private javax.swing.JComboBox<String> cbNewPostProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
