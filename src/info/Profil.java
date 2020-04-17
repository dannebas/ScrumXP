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
        pnlHeader = new javax.swing.JPanel();
        lblImageHeader = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        pnlBread = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblMyPosts = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        lblFooterImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1066, 1758));
        setSize(new java.awt.Dimension(1024, 2000));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlProfile.setAlignmentX(0.0F);
        pnlProfile.setAlignmentY(0.0F);
        pnlProfile.setPreferredSize(new java.awt.Dimension(1024, 768));
        pnlProfile.setRequestFocusEnabled(false);
        pnlProfile.setLayout(null);

        pnlHeader.setAlignmentX(0.0F);
        pnlHeader.setAlignmentY(0.0F);
        pnlHeader.setPreferredSize(new java.awt.Dimension(1024, 150));

        lblImageHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblImageHeader.setAlignmentY(0.0F);
        lblImageHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblImageHeader.setMaximumSize(new java.awt.Dimension(1022, 148));
        lblImageHeader.setMinimumSize(new java.awt.Dimension(1022, 148));
        lblImageHeader.setPreferredSize(new java.awt.Dimension(1022, 148));

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlProfile.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 1028, 148);

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setAlignmentX(0.0F);
        pnlNavBarSeePost.setAlignmentY(0.0F);
        pnlNavBarSeePost.setAutoscrolls(true);
        pnlNavBarSeePost.setMinimumSize(new java.awt.Dimension(1022, 30));
        pnlNavBarSeePost.setPreferredSize(new java.awt.Dimension(1022, 30));
        pnlNavBarSeePost.setLayout(null);

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
        pnlNavBarSeePost.add(btnSeePostHome);
        btnSeePostHome.setBounds(20, 8, 33, 14);

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
        pnlNavBarSeePost.add(btnSeePostEducation);
        btnSeePostEducation.setBounds(100, 8, 55, 14);

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
        pnlNavBarSeePost.add(btnSeePostResearch);
        btnSeePostResearch.setBounds(200, 8, 53, 14);

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
        pnlNavBarSeePost.add(btnSeePostGeneral);
        btnSeePostGeneral.setBounds(300, 8, 60, 14);

        btnLogOut.setBackground(new java.awt.Color(44, 95, 125));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log out");
        btnLogOut.setBorder(null);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnLogOut);
        btnLogOut.setBounds(950, 8, 44, 14);

        pnlProfile.add(pnlNavBarSeePost);
        pnlNavBarSeePost.setBounds(0, 154, 1022, 30);

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.setAlignmentX(0.0F);
        pnlBread.setAlignmentY(0.0F);
        pnlBread.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBread.setLayout(null);

        jLayeredPane2.setLayout(new java.awt.CardLayout());
        pnlBread.add(jLayeredPane2);
        jLayeredPane2.setBounds(727, 214, 0, 0);

        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        txaGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        jScrollPane3.setViewportView(txaGroups);
        txaGroups.getAccessibleContext().setAccessibleDescription("");

        pnlBread.add(jScrollPane3);
        jScrollPane3.setBounds(200, 250, 270, 130);

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

        pnlBread.add(pnlUserInfoBackground);
        pnlUserInfoBackground.setBounds(130, 10, 340, 190);

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

        pnlBread.add(pnlUserMeetingAndPostBackground);
        pnlUserMeetingAndPostBackground.setBounds(10, 250, 170, 127);

        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });
        pnlBread.add(btnEditProfile);
        btnEditProfile.setBounds(10, 170, 100, 32);

        lblProfileImage.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileImage.setText("Profile picture");
        lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
        pnlBread.add(lblProfileImage);
        lblProfileImage.setBounds(10, 10, 110, 145);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        pnlBread.add(jScrollPane1);
        jScrollPane1.setBounds(500, 40, 500, 340);

        lblMyPosts.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMyPosts.setForeground(new java.awt.Color(51, 51, 51));
        lblMyPosts.setText("My posts");
        pnlBread.add(lblMyPosts);
        lblMyPosts.setBounds(500, 10, 70, 16);

        pnlProfile.add(pnlBread);
        pnlBread.setBounds(0, 190, 1022, 405);

        pnlFooter.setAlignmentX(0.0F);
        pnlFooter.setAlignmentY(0.0F);
        pnlFooter.setMinimumSize(new java.awt.Dimension(1022, 148));
        pnlFooter.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlFooter.setLayout(null);

        lblFooterImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblFooterImage.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlFooter.add(lblFooterImage);
        lblFooterImage.setBounds(0, 0, 1022, 148);

        pnlProfile.add(pnlFooter);
        pnlFooter.setBounds(0, 600, 1022, 148);

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

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        a = new EditProfile(this);
        a.setVisible(true);
       
    }//GEN-LAST:event_btnEditProfileActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
         new LogInGUI().setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.JComboBox<String> cbMeetingProfile;
    private javax.swing.JComboBox<String> cbNewPostProfile;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEmailProfile;
    private javax.swing.JLabel lblFooterImage;
    private javax.swing.JLabel lblImageHeader;
    private javax.swing.JLabel lblMyPosts;
    private javax.swing.JLabel lblNameProfile;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserNameProfile;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlUserInfoBackground;
    private javax.swing.JPanel pnlUserMeetingAndPostBackground;
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
