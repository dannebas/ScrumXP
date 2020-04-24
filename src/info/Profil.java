/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.PictureHandler;
import dbUtils.db;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Viggo
 */
public class Profil extends javax.swing.JFrame {

    private EditProfile a;
    private Forum forum;
    private DefaultTableModel model;
    private String user;

    public Profil() {
        user = User.getUser();
        initComponents();
        forum = new Forum();
        setExtendedState(MAXIMIZED_BOTH);

        lblUserNameProfile.setText(User.getName());
        lblUserEmail.setText(User.getMail());
        lblUserPhone.setText(User.getPhone());

        ArrayList<String> groups = User.getUserGroups();
        for (String s : groups) {
            txaGroups.append(s + "\n");
        }

        displayProfileImage();

        TableColumnModel columnmodel = tblMyPosts.getColumnModel();
        columnmodel.removeColumn(columnmodel.getColumn(2));
        tblMyPosts.getTableHeader().setUI(null);
        tblMyPosts.setShowGrid(false);
        scrMyPostsTable.getViewport().setBackground(Color.white);
        getMyPosts();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProfile = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblImageHeader = new javax.swing.JLabel();
        pnlBread = new javax.swing.JPanel();
        scrGroups = new javax.swing.JScrollPane();
        txaGroups = new javax.swing.JTextArea();
        pnlUserInfoBackground = new javax.swing.JPanel();
        lblUserNameProfile = new javax.swing.JLabel();
        lblEmailProfile = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblNameProfile = new javax.swing.JLabel();
        lblPhoneTitle = new javax.swing.JLabel();
        lblUserPhone = new javax.swing.JLabel();
        pnlUserMeetingAndPostBackground = new javax.swing.JPanel();
        cbMeetingProfile = new javax.swing.JComboBox<>();
        cbNewPostProfile = new javax.swing.JComboBox<>();
        btnEditProfile = new javax.swing.JButton();
        lblProfileImage = new javax.swing.JLabel();
        scrMyPostsTable = new javax.swing.JScrollPane();
        tblMyPosts = new javax.swing.JTable();
        pnlFooter = new javax.swing.JPanel();
        lblFooterImage = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnResarchAndEducation = new javax.swing.JButton();
        btnBlog = new javax.swing.JButton();

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

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.setAlignmentX(0.0F);
        pnlBread.setAlignmentY(0.0F);
        pnlBread.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBread.setLayout(null);

        scrGroups.setBackground(new java.awt.Color(255, 255, 255));
        scrGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Research Groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        txaGroups.setBorder(null);
        scrGroups.setViewportView(txaGroups);
        txaGroups.getAccessibleContext().setAccessibleName("My research groups");
        txaGroups.getAccessibleContext().setAccessibleDescription("");

        pnlBread.add(scrGroups);
        scrGroups.setBounds(10, 240, 500, 150);

        pnlUserInfoBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlUserInfoBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlUserInfoBackground.setLayout(null);

        lblUserNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblUserNameProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblUserNameProfile.setText("UserName");
        pnlUserInfoBackground.add(lblUserNameProfile);
        lblUserNameProfile.setBounds(60, 20, 190, 16);

        lblEmailProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEmailProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblEmailProfile.setText("E-mail:");
        pnlUserInfoBackground.add(lblEmailProfile);
        lblEmailProfile.setBounds(10, 40, 38, 16);

        lblUserEmail.setBackground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setText("UserEmail");
        pnlUserInfoBackground.add(lblUserEmail);
        lblUserEmail.setBounds(60, 40, 198, 16);

        lblNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setText("Name:");
        pnlUserInfoBackground.add(lblNameProfile);
        lblNameProfile.setBounds(10, 20, 36, 16);

        lblPhoneTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblPhoneTitle.setText("Phone:");
        pnlUserInfoBackground.add(lblPhoneTitle);
        lblPhoneTitle.setBounds(10, 60, 41, 16);

        lblUserPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblUserPhone.setText("UserPhone");
        pnlUserInfoBackground.add(lblUserPhone);
        lblUserPhone.setBounds(60, 60, 220, 16);

        pnlBread.add(pnlUserInfoBackground);
        pnlUserInfoBackground.setBounds(130, 10, 380, 90);

        pnlUserMeetingAndPostBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlUserMeetingAndPostBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
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
        cbMeetingProfile.setBounds(190, 30, 154, 25);

        cbNewPostProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New post", "See post", "Edit post", "See your posts" }));
        cbNewPostProfile.setToolTipText("");
        cbNewPostProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNewPostProfileActionPerformed(evt);
            }
        });
        pnlUserMeetingAndPostBackground.add(cbNewPostProfile);
        cbNewPostProfile.setBounds(10, 30, 154, 25);

        pnlBread.add(pnlUserMeetingAndPostBackground);
        pnlUserMeetingAndPostBackground.setBounds(130, 110, 380, 100);

        btnEditProfile.setBackground(new java.awt.Color(44, 95, 125));
        btnEditProfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProfile.setText("Edit Profile");
        btnEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });
        pnlBread.add(btnEditProfile);
        btnEditProfile.setBounds(10, 175, 110, 37);

        lblProfileImage.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileImage.setText("Profile picture");
        lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
        pnlBread.add(lblProfileImage);
        lblProfileImage.setBounds(10, 20, 110, 145);

        scrMyPostsTable.setBackground(new java.awt.Color(255, 255, 255));
        scrMyPostsTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "My Posts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        tblMyPosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Date", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMyPosts.getTableHeader().setResizingAllowed(false);
        tblMyPosts.getTableHeader().setReorderingAllowed(false);
        tblMyPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMyPostsMouseClicked(evt);
            }
        });
        scrMyPostsTable.setViewportView(tblMyPosts);
        if (tblMyPosts.getColumnModel().getColumnCount() > 0) {
            tblMyPosts.getColumnModel().getColumn(0).setResizable(false);
            tblMyPosts.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblMyPosts.getColumnModel().getColumn(1).setResizable(false);
            tblMyPosts.getColumnModel().getColumn(2).setResizable(false);
            tblMyPosts.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        pnlBread.add(scrMyPostsTable);
        scrMyPostsTable.setBounds(530, 10, 480, 380);

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

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setAlignmentX(0.0F);
        pnlNavBarSeePost.setAlignmentY(0.0F);
        pnlNavBarSeePost.setAutoscrolls(true);
        pnlNavBarSeePost.setMinimumSize(new java.awt.Dimension(1022, 30));
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
        btnLogOut.setBounds(950, 8, 60, 14);

        btnCalendar.setBackground(new java.awt.Color(44, 95, 125));
        btnCalendar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCalendar.setForeground(new java.awt.Color(255, 255, 255));
        btnCalendar.setText("Calendar");
        btnCalendar.setBorder(null);
        btnCalendar.setBorderPainted(false);
        btnCalendar.setContentAreaFilled(false);
        btnCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnCalendar);
        btnCalendar.setBounds(250, 8, 50, 14);

        btnMyProfile.setBackground(new java.awt.Color(44, 95, 125));
        btnMyProfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMyProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnMyProfile.setText("My Profile");
        btnMyProfile.setBorder(null);
        btnMyProfile.setBorderPainted(false);
        btnMyProfile.setContentAreaFilled(false);
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnMyProfile);
        btnMyProfile.setBounds(880, 8, 60, 14);

        btnResarchAndEducation.setBackground(new java.awt.Color(44, 95, 125));
        btnResarchAndEducation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnResarchAndEducation.setForeground(new java.awt.Color(255, 255, 255));
        btnResarchAndEducation.setText("Research & Education");
        btnResarchAndEducation.setBorder(null);
        btnResarchAndEducation.setBorderPainted(false);
        btnResarchAndEducation.setContentAreaFilled(false);
        btnResarchAndEducation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResarchAndEducationActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnResarchAndEducation);
        btnResarchAndEducation.setBounds(70, 8, 123, 14);

        btnBlog.setBackground(new java.awt.Color(44, 95, 125));
        btnBlog.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBlog.setForeground(new java.awt.Color(255, 255, 255));
        btnBlog.setText("Blog");
        btnBlog.setBorder(null);
        btnBlog.setBorderPainted(false);
        btnBlog.setContentAreaFilled(false);
        btnBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlogActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnBlog);
        btnBlog.setBounds(210, 8, 24, 14);

        pnlProfile.add(pnlNavBarSeePost);
        pnlNavBarSeePost.setBounds(0, 154, 1022, 30);

        getContentPane().add(pnlProfile);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getMyPosts() {
        try {
            model = (DefaultTableModel) tblMyPosts.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> myPosts = db.getDB().fetchRows("SELECT TITLE, DATE, POST_ID FROM POSTS WHERE AUTHOR ='" + User.getUser() + "'");
            for (HashMap<String, String> aPost : myPosts) {
                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("DATE"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred");
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"You have not posted anything yet"});
            System.out.println(e.getMessage());
        }
    }

    public void updateProfile(ImageIcon myIcon) {

        displayProfileImage();
    }

    public void updateProfileTexts(String mail, String phone) {

        lblUserEmail.setText(mail);
        lblUserPhone.setText(phone);
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
                
                EditMeeting obj = new EditMeeting();
                obj.setLocationRelativeTo(null);
                obj.setVisible(true);
                
                
                
                
                
                
                
                break;
            
            default:
        }
    }//GEN-LAST:event_cbMeetingProfileActionPerformed

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        a = new EditProfile(this);
        a.setVisible(true);

    }//GEN-LAST:event_btnEditProfileActionPerformed

    private void tblMyPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMyPostsMouseClicked
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tblMyPosts.getSelectedRow();
            try {

                idString = tblMyPosts.getModel().getValueAt(id, 2).toString();
                new SeePost(idString).setVisible(true);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        }
    }//GEN-LAST:event_tblMyPostsMouseClicked

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new LogInGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        new CalendarView().setVisible(true);
    }//GEN-LAST:event_btnCalendarActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        new Profil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnResarchAndEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResarchAndEducationActionPerformed
        new Forum().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnResarchAndEducationActionPerformed

    private void btnBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlogActionPerformed
        new Blog().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBlogActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlog;
    private javax.swing.JButton btnCalendar;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnResarchAndEducation;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JComboBox<String> cbMeetingProfile;
    private javax.swing.JComboBox<String> cbNewPostProfile;
    private javax.swing.JLabel lblEmailProfile;
    private javax.swing.JLabel lblFooterImage;
    private javax.swing.JLabel lblImageHeader;
    private javax.swing.JLabel lblNameProfile;
    private javax.swing.JLabel lblPhoneTitle;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserNameProfile;
    private javax.swing.JLabel lblUserPhone;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlUserInfoBackground;
    private javax.swing.JPanel pnlUserMeetingAndPostBackground;
    private javax.swing.JScrollPane scrGroups;
    private javax.swing.JScrollPane scrMyPostsTable;
    private javax.swing.JTable tblMyPosts;
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
