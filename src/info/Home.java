/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Lukas
 */
public class Home extends javax.swing.JFrame {
    
    private DefaultTableModel model;

    /**
     * Creates new form Forum
     */
    public Home() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        loadNews();
        loadBlog();
        this.model = new DefaultTableModel();

        TableColumnModel columnmodel = tableNotifications.getColumnModel();
        columnmodel.removeColumn(columnmodel.getColumn(4));
        //tableNotifications.getTableHeader().setUI(null);
        tableNotifications.setShowGrid(false);
        scrNotifications.getViewport().setBackground(Color.white);
        loadNotifications();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupForum = new javax.swing.ButtonGroup();
        pnlBackgroundForum = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblImageHeader = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnResarchAndEducation = new javax.swing.JButton();
        btnBlog = new javax.swing.JButton();
        pnlBreadForum = new javax.swing.JPanel();
        pnlLatest = new javax.swing.JPanel();
        scrLatest = new javax.swing.JScrollPane();
        jlLatest = new javax.swing.JList<>();
        pnlBlog = new javax.swing.JPanel();
        scrBlog = new javax.swing.JScrollPane();
        jlBlog = new javax.swing.JList<>();
        pnlNotifications = new javax.swing.JPanel();
        scrNotifications = new javax.swing.JScrollPane();
        tableNotifications = new javax.swing.JTable();
        pnlActions1 = new javax.swing.JPanel();
        lblNewMeeting = new javax.swing.JLabel();
        pnlFooterForum = new javax.swing.JPanel();
        lblFooterImageForum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlBackgroundForum.setAlignmentX(0.0F);
        pnlBackgroundForum.setAlignmentY(0.0F);
        pnlBackgroundForum.setMaximumSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setMinimumSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setPreferredSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setLayout(null);

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

        pnlBackgroundForum.add(pnlHeader);
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

        pnlBackgroundForum.add(pnlNavBarSeePost);
        pnlNavBarSeePost.setBounds(0, 154, 1022, 30);

        pnlBreadForum.setBackground(new java.awt.Color(255, 255, 255));
        pnlBreadForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBreadForum.setAlignmentX(0.0F);
        pnlBreadForum.setAlignmentY(0.0F);
        pnlBreadForum.setMinimumSize(new java.awt.Dimension(1022, 405));
        pnlBreadForum.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBreadForum.setLayout(null);

        pnlLatest.setBackground(new java.awt.Color(255, 255, 255));
        pnlLatest.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Latest News", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlLatest.setForeground(new java.awt.Color(0, 0, 0));
        pnlLatest.setLayout(null);

        scrLatest.setBorder(null);

        jlLatest.setBackground(new java.awt.Color(255, 255, 255));
        jlLatest.setForeground(new java.awt.Color(0, 0, 0));
        scrLatest.setViewportView(jlLatest);

        pnlLatest.add(scrLatest);
        scrLatest.setBounds(11, 27, 370, 120);

        pnlBreadForum.add(pnlLatest);
        pnlLatest.setBounds(30, 30, 410, 160);

        pnlBlog.setBackground(new java.awt.Color(255, 255, 255));
        pnlBlog.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "The Blog", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBlog.setForeground(new java.awt.Color(0, 0, 0));
        pnlBlog.setLayout(null);

        scrBlog.setBorder(null);

        jlBlog.setBackground(new java.awt.Color(255, 255, 255));
        jlBlog.setForeground(new java.awt.Color(0, 0, 0));
        scrBlog.setViewportView(jlBlog);

        pnlBlog.add(scrBlog);
        scrBlog.setBounds(11, 27, 380, 100);

        pnlBreadForum.add(pnlBlog);
        pnlBlog.setBounds(30, 210, 410, 160);

        pnlNotifications.setBackground(new java.awt.Color(255, 255, 255));
        pnlNotifications.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notifications", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlNotifications.setForeground(new java.awt.Color(0, 0, 0));
        pnlNotifications.setLayout(null);

        tableNotifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Location", "Date", "Title", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNotifications.setMaximumSize(new java.awt.Dimension(430, 160));
        tableNotifications.setMinimumSize(new java.awt.Dimension(430, 160));
        tableNotifications.setPreferredSize(new java.awt.Dimension(430, 160));
        tableNotifications.getTableHeader().setReorderingAllowed(false);
        tableNotifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNotificationsMouseClicked(evt);
            }
        });
        scrNotifications.setViewportView(tableNotifications);
        if (tableNotifications.getColumnModel().getColumnCount() > 0) {
            tableNotifications.getColumnModel().getColumn(0).setResizable(false);
            tableNotifications.getColumnModel().getColumn(1).setResizable(false);
            tableNotifications.getColumnModel().getColumn(2).setResizable(false);
            tableNotifications.getColumnModel().getColumn(3).setResizable(false);
            tableNotifications.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlNotifications.add(scrNotifications);
        scrNotifications.setBounds(10, 30, 410, 110);

        pnlBreadForum.add(pnlNotifications);
        pnlNotifications.setBounds(520, 30, 440, 160);

        pnlActions1.setBackground(new java.awt.Color(255, 255, 255));
        pnlActions1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlActions1.setForeground(new java.awt.Color(0, 0, 0));
        pnlActions1.setLayout(null);

        lblNewMeeting.setText("New meeting");
        lblNewMeeting.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.darkGray));
        lblNewMeeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNewMeetingMouseClicked(evt);
            }
        });
        pnlActions1.add(lblNewMeeting);
        lblNewMeeting.setBounds(40, 40, 80, 70);

        pnlBreadForum.add(pnlActions1);
        pnlActions1.setBounds(520, 210, 440, 160);

        pnlBackgroundForum.add(pnlBreadForum);
        pnlBreadForum.setBounds(0, 190, 1022, 405);

        pnlFooterForum.setAlignmentX(0.0F);
        pnlFooterForum.setAlignmentY(0.0F);
        pnlFooterForum.setMaximumSize(new java.awt.Dimension(1024, 148));
        pnlFooterForum.setMinimumSize(new java.awt.Dimension(1024, 148));
        pnlFooterForum.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlFooterForum.setLayout(null);

        lblFooterImageForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageForum.setAlignmentY(0.0F);
        lblFooterImageForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblFooterImageForum.setMaximumSize(new java.awt.Dimension(1022, 148));
        lblFooterImageForum.setMinimumSize(new java.awt.Dimension(1022, 148));
        lblFooterImageForum.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlFooterForum.add(lblFooterImageForum);
        lblFooterImageForum.setBounds(0, 0, 1022, 148);

        pnlBackgroundForum.add(pnlFooterForum);
        pnlFooterForum.setBounds(0, 600, 1022, 148);

        getContentPane().add(pnlBackgroundForum);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void loadNotifications() {
        ArrayList<HashMap<String, String>> notifications = null;
        model = (DefaultTableModel) tableNotifications.getModel();
        model.setRowCount(0);
        tableNotifications.setModel(model);

        try {
            //SELECT * FROM MEETINGPARTICIPANTS WHERE USER_ID = 'tms' AND SEEN = FALSE
            //"SELECT * FROM MEETINGPARTICIPANTS WHERE USER_ID = '" + User.getUser() + "' AND SEEN = FALSE"
            notifications = db.getDB().fetchRows("SELECT * FROM MEETINGPARTICIPANTS WHERE USER_ID = '" + User.getUser() + "' AND SEEN = FALSE");
            System.out.println("SIZE: " + notifications.size());

            for (HashMap<String, String> aNotifications : notifications) {

                String meetingID = aNotifications.get("MEETING_ID");
                String time = db.getDB().fetchSingle("SELECT TIME FROM MEETINGS WHERE MEETING_ID = " + meetingID);
                String location = db.getDB().fetchSingle("SELECT LOCATION FROM MEETINGS WHERE MEETING_ID = " + meetingID);
                String date = db.getDB().fetchSingle("SELECT DATE FROM MEETINGS WHERE MEETING_ID = " + meetingID);
//                String description = db.getDB().fetchSingle("SELECT DESCRIPTION FROM MEETINGS WHERE MEETING_ID = " + meetingID);
                String title = db.getDB().fetchSingle("SELECT TITLE FROM MEETINGS WHERE MEETING_ID = " + meetingID);
//                
//                String notificationText = "Time: " + time + " Location: " + location + " Date: " + date + " Description: " + description + " Title: " + title;
//                System.out.println(notificationText);

                model.addRow(new Object[]{time, location, date, title, meetingID});
                //listNotifications
            }

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException ex)
        {
            tableNotifications.setVisible(false);
            scrNotifications.setVisible(false);
        }
    }

    private void loadNews() {
        DefaultListModel model = new DefaultListModel();
        jlLatest.setModel(model);
        int numberOfFiles = 0;
        try {

            numberOfFiles = Integer.parseInt(db.getDB().fetchSingle("select COUNT(*) from FORMAL_POST"));

        } catch (SQLException e) {
        }
        if (numberOfFiles > 0) {
            try {
                ArrayList<HashMap<String, String>> news = db.getDB().fetchRows("SELECT * from POSTS where POST_ID in (select POST_ID from FORMAL_POST) order by POST_ID desc limit 5");
                for (HashMap<String, String> aNews : news) {
                    String authorName = db.getDB().fetchSingle("select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + aNews.get("AUTHOR") + "'");

                    model.addElement(authorName + " posted: " + aNews.get("TITLE") + " on: " + aNews.get("DATE"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void loadBlog() {
        DefaultListModel model = new DefaultListModel();

        jlBlog.setModel(model);

        int numberOfFiles = 0;

        try {

            numberOfFiles = Integer.parseInt(db.getDB().fetchSingle("select COUNT(*) from INFORMAL_POST"));

        } catch (SQLException e) {
        }

        if (numberOfFiles > 0) {
            try {
                ArrayList<HashMap<String, String>> news = db.getDB().fetchRows("SELECT * from POSTS where POST_ID in (select POST_ID from INFORMAL_POST) order by POST_ID desc limit 5");
                for (HashMap<String, String> aNews : news) {
                    String authorName = db.getDB().fetchSingle("select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + aNews.get("AUTHOR") + "'");

                    model.addElement(authorName + " posted: " + aNews.get("TITLE") + " on: " + aNews.get("DATE"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new LogInGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        new Profil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        new CalendarView().setVisible(true);
    }//GEN-LAST:event_btnCalendarActionPerformed

    private void btnResarchAndEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResarchAndEducationActionPerformed
        new Forum().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnResarchAndEducationActionPerformed

    private void btnBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlogActionPerformed
        new Blog().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBlogActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void lblNewMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewMeetingMouseClicked
        new Booking().setVisible(true);
    }//GEN-LAST:event_lblNewMeetingMouseClicked

    private void tableNotificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNotificationsMouseClicked
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tableNotifications.getSelectedRow();
            try {
                idString = tableNotifications.getModel().getValueAt(id, 4).toString();

                int index = JOptionPane.showConfirmDialog(null, "Remove notification?");

                int row = tableNotifications.getSelectedRow();

                if (index == 0) {
                    model.removeRow(row);
                    try {
                        db.getDB().update("UPDATE MEETINGPARTICIPANTS SET SEEN = TRUE WHERE MEETING_ID = '" + idString + "' AND USER_ID = '" + User.getUser() + "'");
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        }
    }//GEN-LAST:event_tableNotificationsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlog;
    private javax.swing.JButton btnCalendar;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnResarchAndEducation;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.ButtonGroup buttonGroupForum;
    private javax.swing.JList<String> jlBlog;
    private javax.swing.JList<String> jlLatest;
    private javax.swing.JLabel lblFooterImageForum;
    private javax.swing.JLabel lblImageHeader;
    private javax.swing.JLabel lblNewMeeting;
    private javax.swing.JPanel pnlActions1;
    private javax.swing.JPanel pnlBackgroundForum;
    private javax.swing.JPanel pnlBlog;
    private javax.swing.JPanel pnlBreadForum;
    private javax.swing.JPanel pnlFooterForum;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlLatest;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlNotifications;
    private javax.swing.JScrollPane scrBlog;
    private javax.swing.JScrollPane scrLatest;
    private javax.swing.JScrollPane scrNotifications;
    private javax.swing.JTable tableNotifications;
    // End of variables declaration//GEN-END:variables
}
