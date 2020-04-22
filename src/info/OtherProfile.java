
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import JavaMail.MailApplication;
import dbUtils.PictureHandler;
import dbUtils.db;
import dbUtils.dbConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Stefan
 */
public class OtherProfile extends javax.swing.JFrame {

    private static dbConnection conn;
    private String author;
    private DefaultTableModel model;
    private EditProfile a;
    private Forum forum;

    /**
     * Creates new form OtherProfile
     */
    public OtherProfile() {
        forum = new Forum();
        initComponents();
        author = SeePost.getAuthor();
        setInfo();
        addPosts();
        TableColumnModel columnmodel = tblPosts.getColumnModel();
        columnmodel.removeColumn(columnmodel.getColumn(2));
        tblPosts.setTableHeader(null);
        tblPosts.setShowGrid(false);
        scrUserPosts.getViewport().setBackground(Color.white);
        
    }

    public void addPosts() {

        try {
            model = (DefaultTableModel) tblPosts.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> myPosts = db.getDB().fetchRows("SELECT TITLE, DATE, POST_ID FROM POSTS WHERE AUTHOR ='" + author + "'");
            for (HashMap<String, String> aPost : myPosts) {
                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("DATE"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred");
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"This user has no posts"});
            System.out.println(e.getMessage());
        }
        
    }

    private void setInfo() {
        //Set the name of the profile
        System.out.println(author);
        try {
            String qName = "select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String aName = db.getDB().fetchSingle(qName);
            String qName2 = "select LASTNAME from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String aName2 = db.getDB().fetchSingle(qName2);
            lblUserNameProfile.setText(aName + " " + aName2);

            System.out.println(aName);
        } catch (SQLException ex) {
            Logger.getLogger(OtherProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Set EMailaddress
        try {
            String qMail = "select EMAILADDRESS from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String aMail = db.getDB().fetchSingle(qMail);
            Font font = lblUserEmail.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblUserEmail.setFont(font.deriveFont(attributes));
            lblUserEmail.setText(aMail);

        } catch (SQLException ex) {
            Logger.getLogger(OtherProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Set image
        try {
            byte[] b = db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = '" + author + "'");
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

        //set phone
        try {
            String aPhone = db.getDB().fetchSingle("select PHONE from USER_PROFILE where PROFILE_ID = '" + author + "'");
            lblUserPhone.setText(aPhone);

        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("Not found");
            lblUserPhone.setText("");
        }

        try {
            //Set groups
            ArrayList<String> groups = db.getDB().fetchColumn("select GROUP_NAME FROM RESEARCH_GROUP WHERE GROUP_ID in(SELECT RESEARCH_GROUP from GROUP_MEMBERS where MEMBER = '" + author + "'" + ")");

            for (String s : groups) {
                txaGroups.append(s + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OtherProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();
        lblImageHeader = new javax.swing.JLabel();
        pnlBread = new javax.swing.JPanel();
        scrUserGroups = new javax.swing.JScrollPane();
        txaGroups = new javax.swing.JTextArea();
        pnlUserInfoBackground = new javax.swing.JPanel();
        lblUserNameProfile = new javax.swing.JLabel();
        lblEmailProfile = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblNameProfile = new javax.swing.JLabel();
        lblPhoneTitle = new javax.swing.JLabel();
        lblUserPhone = new javax.swing.JLabel();
        lblProfileImage = new javax.swing.JLabel();
        scrUserPosts = new javax.swing.JScrollPane();
        tblPosts = new javax.swing.JTable();
        lblFooterImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Profile");

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
        btnSeePostEducation.setBounds(70, 8, 55, 14);

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
        btnSeePostResearch.setBounds(140, 8, 53, 14);

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
        btnSeePostGeneral.setBounds(200, 8, 60, 14);

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
        btnCalendar.setBounds(810, 5, 60, 20);

        lblImageHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblImageHeader.setAlignmentY(0.0F);
        lblImageHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblImageHeader.setMaximumSize(new java.awt.Dimension(1022, 148));
        lblImageHeader.setMinimumSize(new java.awt.Dimension(1022, 148));
        lblImageHeader.setPreferredSize(new java.awt.Dimension(1022, 148));

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.setAlignmentX(0.0F);
        pnlBread.setAlignmentY(0.0F);
        pnlBread.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBread.setLayout(null);

        scrUserGroups.setBackground(new java.awt.Color(255, 255, 255));
        scrUserGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Research Groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        txaGroups.setBackground(new java.awt.Color(255, 255, 255));
        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        txaGroups.setBorder(null);
        scrUserGroups.setViewportView(txaGroups);

        pnlBread.add(scrUserGroups);
        scrUserGroups.setBounds(10, 240, 500, 150);
        scrUserGroups.getAccessibleContext().setAccessibleName("");

        pnlUserInfoBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlUserInfoBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
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
        lblEmailProfile.setBounds(10, 40, 40, 16);

        lblUserEmail.setBackground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setText("UserEmail");
        lblUserEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserEmailMouseClicked(evt);
            }
        });
        pnlUserInfoBackground.add(lblUserEmail);
        lblUserEmail.setBounds(60, 40, 198, 16);

        lblNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setText("Name:");
        pnlUserInfoBackground.add(lblNameProfile);
        lblNameProfile.setBounds(10, 20, 40, 16);

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

        lblProfileImage.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileImage.setText("Profile picture");
        lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
        pnlBread.add(lblProfileImage);
        lblProfileImage.setBounds(10, 10, 110, 145);

        scrUserPosts.setBackground(new java.awt.Color(255, 255, 255));
        scrUserPosts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Posts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        tblPosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Date", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        tblPosts.setShowGrid(false);
        tblPosts.getTableHeader().setReorderingAllowed(false);
        tblPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPostsMouseClicked(evt);
            }
        });
        scrUserPosts.setViewportView(tblPosts);
        if (tblPosts.getColumnModel().getColumnCount() > 0) {
            tblPosts.getColumnModel().getColumn(0).setResizable(false);
            tblPosts.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblPosts.getColumnModel().getColumn(1).setResizable(false);
            tblPosts.getColumnModel().getColumn(2).setResizable(false);
            tblPosts.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        pnlBread.add(scrUserPosts);
        scrUserPosts.setBounds(530, 10, 480, 380);

        lblFooterImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblFooterImage.setPreferredSize(new java.awt.Dimension(1022, 148));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblImageHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBread, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFooterImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblImageHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFooterImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        forum.setVisible(true);
        forum.swicthCategoryButtons(false);
        forum.addAllGeneralPost();
        this.dispose();//addAllForumPost();


    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new LogInGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void lblUserEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserEmailMouseClicked
        try {
            MailApplication.main(null, author);
        } catch (SQLException ex) {
            Logger.getLogger(OtherProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblUserEmailMouseClicked

    private void tblPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPostsMouseClicked
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tblPosts.getSelectedRow();
            try {
                idString = tblPosts.getModel().getValueAt(id, 4).toString();
                new SeePost(idString).setVisible(true);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        }
    }//GEN-LAST:event_tblPostsMouseClicked

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        new Profil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        new ACalendar().setVisible(true);
    }//GEN-LAST:event_btnCalendarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalendar;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
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
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlUserInfoBackground;
    private javax.swing.JScrollPane scrUserGroups;
    private javax.swing.JScrollPane scrUserPosts;
    private javax.swing.JTable tblPosts;
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
