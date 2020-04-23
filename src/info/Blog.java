/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Lukas
 */
public class Blog extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form Forum
     */
    public Blog() {
        initComponents();
        TableColumnModel columnmodel = tblGeneralPost.getColumnModel();
        columnmodel.removeColumn(columnmodel.getColumn(4));
        columnmodel.removeColumn(columnmodel.getColumn(3));
        addAllGeneralPost();
       
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        
        if (User.getAdmin() == false) {
            btnEditPost.setVisible(false);
        }
    }

    public void addAllGeneralPost() // add all the Post which are Informal to the table
    {
        try {
            model = (DefaultTableModel) tblGeneralPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
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
        pnlBreadForum = new javax.swing.JPanel();
        spnTableForum = new javax.swing.JScrollPane();
        tblGeneralPost = new javax.swing.JTable();
        btnEditPost = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlFooterForum = new javax.swing.JPanel();
        lblFooterImageForum = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnResarchAndEducation = new javax.swing.JButton();
        btnBlog = new javax.swing.JButton();

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

        pnlBreadForum.setBackground(new java.awt.Color(255, 255, 255));
        pnlBreadForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBreadForum.setAlignmentX(0.0F);
        pnlBreadForum.setAlignmentY(0.0F);
        pnlBreadForum.setMinimumSize(new java.awt.Dimension(1022, 405));
        pnlBreadForum.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBreadForum.setLayout(null);

        spnTableForum.setBackground(new java.awt.Color(255, 255, 255));
        spnTableForum.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Posts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        spnTableForum.setForeground(new java.awt.Color(0, 0, 0));

        tblGeneralPost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblGeneralPost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "Date", "Description", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGeneralPost.setGridColor(new java.awt.Color(255, 255, 255));
        tblGeneralPost.setPreferredSize(new java.awt.Dimension(300, 450));
        tblGeneralPost.setRowHeight(26);
        tblGeneralPost.setSelectionBackground(new java.awt.Color(0, 153, 102));
        tblGeneralPost.getTableHeader().setReorderingAllowed(false);
        tblGeneralPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGeneralPostMouseClicked(evt);
            }
        });
        spnTableForum.setViewportView(tblGeneralPost);
        if (tblGeneralPost.getColumnModel().getColumnCount() > 0) {
            tblGeneralPost.getColumnModel().getColumn(0).setResizable(false);
            tblGeneralPost.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblGeneralPost.getColumnModel().getColumn(1).setResizable(false);
            tblGeneralPost.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblGeneralPost.getColumnModel().getColumn(2).setResizable(false);
            tblGeneralPost.getColumnModel().getColumn(3).setResizable(false);
            tblGeneralPost.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlBreadForum.add(spnTableForum);
        spnTableForum.setBounds(30, 20, 920, 310);

        btnEditPost.setBackground(new java.awt.Color(44, 95, 125));
        btnEditPost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditPost.setForeground(new java.awt.Color(255, 255, 255));
        btnEditPost.setText("Edit selected post");
        btnEditPost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnEditPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPostActionPerformed(evt);
            }
        });
        pnlBreadForum.add(btnEditPost);
        btnEditPost.setBounds(190, 350, 140, 37);

        jButton2.setBackground(new java.awt.Color(44, 95, 125));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create new post");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlBreadForum.add(jButton2);
        jButton2.setBounds(40, 350, 140, 37);

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

        pnlBackgroundForum.add(pnlNavBarSeePost);
        pnlNavBarSeePost.setBounds(0, 154, 1022, 30);

        getContentPane().add(pnlBackgroundForum);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPostActionPerformed
        int id = tblGeneralPost.getSelectedRow();
        String idString = tblGeneralPost.getModel().getValueAt(id, 4).toString();
        NewPost newPost = new NewPost(idString);
        newPost.setVisible(true);
    }//GEN-LAST:event_btnEditPostActionPerformed

    private void tblGeneralPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGeneralPostMouseClicked
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tblGeneralPost.getSelectedRow();
            try {
                idString = tblGeneralPost.getModel().getValueAt(id, 4).toString();
                new SeePost(idString).setVisible(true);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }

        }
    }//GEN-LAST:event_tblGeneralPostMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new NewPost().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btnEditPost;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnResarchAndEducation;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.ButtonGroup buttonGroupForum;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblFooterImageForum;
    private javax.swing.JLabel lblImageHeader;
    private javax.swing.JPanel pnlBackgroundForum;
    private javax.swing.JPanel pnlBreadForum;
    private javax.swing.JPanel pnlFooterForum;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JScrollPane spnTableForum;
    private javax.swing.JTable tblGeneralPost;
    // End of variables declaration//GEN-END:variables
}