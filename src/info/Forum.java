/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import dbUtils.dbConnection;
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
public class Forum extends javax.swing.JFrame {

    private static dbConnection conn;
    private DefaultTableModel model;

    /**
     * Creates new form Forum
     */
    public Forum() {
        initComponents();

        TableColumnModel columnmodel = tblForumPost.getColumnModel();

        columnmodel.removeColumn(columnmodel.getColumn(4));

        conn = db.getDB();

        pnlSortButtonsForum.setVisible(false);

        addAllForumPost();

        setExtendedState(MAXIMIZED_BOTH);

        setLocationRelativeTo(null);
        
        
    }

    public void addAllGeneralPost() // add all the Post which are Informal to the table
    {
        try {
            model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
    }

    public void addAllForumPost() // add all the Post to the table
    {
        try {
             model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT POSTS.POST_ID, TITLE, DESCRIPTION, DATE, AUTHOR FROM POSTS INNER JOIN INFORMAL_POST ON POSTS.POST_ID=INFORMAL_POST.POST_ID\n"
                    + "UNION\n"
                    + "SELECT POSTS.POST_ID, TITLE, DESCRIPTION, DATE, AUTHOR FROM POSTS INNER JOIN RESEARCH_POSTS ON RESEARCH_POSTS.POST_ID=POSTS.POST_ID INNER JOIN GROUP_MEMBERS ON RESEARCH_POSTS.RESEARCH_GROUP=GROUP_MEMBERS.RESEARCH_GROUP WHERE MEMBER = '" + User.getUser() + "'\n"
                    + "UNION\n"
                    + "SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM EDUCATION_POSTS)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                //model.addRow(new Object[]{"Hej"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
    }

    public void addResearchForumPost() // add all the Post in a certain category  to the table
    {

        try {
             model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT POSTS.POST_ID, TITLE, DESCRIPTION, DATE, AUTHOR FROM POSTS INNER JOIN RESEARCH_POSTS ON RESEARCH_POSTS.POST_ID=POSTS.POST_ID"
                    + " INNER JOIN GROUP_MEMBERS ON RESEARCH_POSTS.RESEARCH_GROUP=GROUP_MEMBERS.RESEARCH_GROUP WHERE MEMBER = '" + User.getUser() + "'");
            System.out.println(User.getUser());
            System.out.println(posts);

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
    }

    public void addEducationForumPost() // add all the Post in a certain category  to the table
    {
        try {
             model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM EDUCATION_POSTS)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
           model.addRow(new Object[]{"No Posts"});
        }

    }

    public void addGroupResearchForumPost(int groupID) // add all the Post in a certain category  to the table
    {

        try {
             model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM RESEARCH_POSTS WHERE RESEARCH_GROUP =" + groupID + ")");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }

    }

    
        public void swicthCategoryButtons(boolean state)
        {
           boolean switchState = state;
          
           
           if(switchState)
           {
               pnlSortButtonsForum.setVisible(true);
           }
           
           else
           {
                pnlSortButtonsForum.setVisible(false);
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
        pnlHeaderForum = new javax.swing.JPanel();
        lblImageHeaderForum = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlBreadForum = new javax.swing.JPanel();
        pnlTableForum = new javax.swing.JPanel();
        spnTableForum = new javax.swing.JScrollPane();
        tblForumPost = new javax.swing.JTable();
        pnlSortButtonsForum = new javax.swing.JPanel();
        rbtnAllGroupForum = new javax.swing.JRadioButton();
        rbtnEHealthForum = new javax.swing.JRadioButton();
        rbtnEGovForum = new javax.swing.JRadioButton();
        rbtnICTdevForum = new javax.swing.JRadioButton();
        rbtnITSecForum = new javax.swing.JRadioButton();
        rbtnITEdForum = new javax.swing.JRadioButton();
        rbtnSysDevMethForum = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        pnlFooterForum = new javax.swing.JPanel();
        lblFooterImageForum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlBackgroundForum.setAlignmentX(0.0F);
        pnlBackgroundForum.setAlignmentY(0.0F);
        pnlBackgroundForum.setMaximumSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setMinimumSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setPreferredSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setLayout(null);

        pnlHeaderForum.setPreferredSize(new java.awt.Dimension(1024, 150));
        pnlHeaderForum.setLayout(null);

        lblImageHeaderForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblImageHeaderForum.setAlignmentY(0.0F);
        lblImageHeaderForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblImageHeaderForum.setMaximumSize(new java.awt.Dimension(1022, 148));
        lblImageHeaderForum.setMinimumSize(new java.awt.Dimension(1022, 148));
        lblImageHeaderForum.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlHeaderForum.add(lblImageHeaderForum);
        lblImageHeaderForum.setBounds(0, 0, 1022, 148);

        pnlBackgroundForum.add(pnlHeaderForum);
        pnlHeaderForum.setBounds(6, 6, 1028, 148);

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setPreferredSize(new java.awt.Dimension(1022, 50));
        pnlNavBarSeePost.setLayout(null);

        btnSeePostHome.setBackground(new java.awt.Color(44, 95, 125));
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
        btnSeePostHome.setBounds(22, 8, 33, 40);

        btnSeePostEducation.setBackground(new java.awt.Color(44, 95, 125));
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
        btnSeePostEducation.setBounds(95, 14, 56, 34);

        btnSeePostResearch.setBackground(new java.awt.Color(44, 95, 125));
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
        btnSeePostResearch.setBounds(204, 23, 55, 16);

        btnSeePostGeneral.setBackground(new java.awt.Color(44, 95, 125));
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
        btnSeePostGeneral.setBounds(316, 23, 44, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("My Profile");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        pnlNavBarSeePost.add(jLabel2);
        jLabel2.setBounds(868, 23, 56, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Log Out");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        pnlNavBarSeePost.add(jLabel3);
        jLabel3.setBounds(965, 23, 44, 16);

        pnlBackgroundForum.add(pnlNavBarSeePost);
        pnlNavBarSeePost.setBounds(6, 157, 1022, 50);

        pnlBreadForum.setBackground(new java.awt.Color(255, 255, 255));
        pnlBreadForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBreadForum.setAlignmentX(0.0F);
        pnlBreadForum.setAlignmentY(0.0F);
        pnlBreadForum.setMinimumSize(new java.awt.Dimension(1022, 350));
        pnlBreadForum.setPreferredSize(new java.awt.Dimension(1022, 350));
        pnlBreadForum.setLayout(null);

        pnlTableForum.setBackground(new java.awt.Color(44, 95, 125));
        pnlTableForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTableForum.setPreferredSize(new java.awt.Dimension(910, 400));

        tblForumPost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblForumPost.setModel(new javax.swing.table.DefaultTableModel(
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
        tblForumPost.setGridColor(new java.awt.Color(255, 255, 255));
        tblForumPost.setPreferredSize(new java.awt.Dimension(300, 450));
        tblForumPost.setRowHeight(26);
        tblForumPost.setSelectionBackground(new java.awt.Color(0, 153, 102));
        tblForumPost.getTableHeader().setReorderingAllowed(false);
        tblForumPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForumPostMouseClicked(evt);
            }
        });
        spnTableForum.setViewportView(tblForumPost);

        javax.swing.GroupLayout pnlTableForumLayout = new javax.swing.GroupLayout(pnlTableForum);
        pnlTableForum.setLayout(pnlTableForumLayout);
        pnlTableForumLayout.setHorizontalGroup(
            pnlTableForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableForumLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(spnTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlTableForumLayout.setVerticalGroup(
            pnlTableForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlBreadForum.add(pnlTableForum);
        pnlTableForum.setBounds(158, 22, 765, 307);

        pnlSortButtonsForum.setBackground(new java.awt.Color(44, 95, 125));
        pnlSortButtonsForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        rbtnAllGroupForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnAllGroupForum);
        rbtnAllGroupForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnAllGroupForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAllGroupForum.setText("All groups");
        rbtnAllGroupForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAllGroupForumActionPerformed(evt);
            }
        });

        rbtnEHealthForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnEHealthForum);
        rbtnEHealthForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnEHealthForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEHealthForum.setText("eHealth");
        rbtnEHealthForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEHealthForumActionPerformed(evt);
            }
        });

        rbtnEGovForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnEGovForum);
        rbtnEGovForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnEGovForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEGovForum.setText("eGov");
        rbtnEGovForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEGovForumActionPerformed(evt);
            }
        });

        rbtnICTdevForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnICTdevForum);
        rbtnICTdevForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnICTdevForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnICTdevForum.setText("ICTdev");
        rbtnICTdevForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnICTdevForumActionPerformed(evt);
            }
        });

        rbtnITSecForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnITSecForum);
        rbtnITSecForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnITSecForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnITSecForum.setText("ITsec");
        rbtnITSecForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnITSecForumActionPerformed(evt);
            }
        });

        rbtnITEdForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnITEdForum);
        rbtnITEdForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnITEdForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnITEdForum.setText("ITed");
        rbtnITEdForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnITEdForumActionPerformed(evt);
            }
        });

        rbtnSysDevMethForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnSysDevMethForum);
        rbtnSysDevMethForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnSysDevMethForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSysDevMethForum.setText("SysdevMeth");
        rbtnSysDevMethForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSysDevMethForumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSortButtonsForumLayout = new javax.swing.GroupLayout(pnlSortButtonsForum);
        pnlSortButtonsForum.setLayout(pnlSortButtonsForumLayout);
        pnlSortButtonsForumLayout.setHorizontalGroup(
            pnlSortButtonsForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortButtonsForumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSortButtonsForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnAllGroupForum)
                    .addComponent(rbtnEHealthForum)
                    .addComponent(rbtnEGovForum)
                    .addComponent(rbtnICTdevForum)
                    .addComponent(rbtnITSecForum)
                    .addComponent(rbtnITEdForum)
                    .addComponent(rbtnSysDevMethForum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSortButtonsForumLayout.setVerticalGroup(
            pnlSortButtonsForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortButtonsForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnAllGroupForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnEHealthForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnEGovForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnICTdevForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnITSecForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnITEdForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnSysDevMethForum)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlBreadForum.add(pnlSortButtonsForum);
        pnlSortButtonsForum.setBounds(8, 22, 118, 256);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBreadForum.add(jButton1);
        jButton1.setBounds(952, 182, 51, 32);

        pnlBackgroundForum.add(pnlBreadForum);
        pnlBreadForum.setBounds(6, 219, 1022, 350);

        pnlFooterForum.setAlignmentX(0.0F);
        pnlFooterForum.setAlignmentY(0.0F);
        pnlFooterForum.setMaximumSize(new java.awt.Dimension(1024, 148));
        pnlFooterForum.setMinimumSize(new java.awt.Dimension(1024, 148));
        pnlFooterForum.setPreferredSize(new java.awt.Dimension(1024, 148));
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
        pnlFooterForum.setBounds(6, 575, 1024, 148);

        getContentPane().add(pnlBackgroundForum);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = tblForumPost.getSelectedRow();
        String idString = tblForumPost.getModel().getValueAt(id, 4).toString();
        NewPost newPost = new NewPost(idString);
        newPost.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbtnSysDevMethForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSysDevMethForumActionPerformed
        addGroupResearchForumPost(6);
    }//GEN-LAST:event_rbtnSysDevMethForumActionPerformed

    private void rbtnITEdForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnITEdForumActionPerformed
        addGroupResearchForumPost(5);
    }//GEN-LAST:event_rbtnITEdForumActionPerformed

    private void rbtnITSecForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnITSecForumActionPerformed
        addGroupResearchForumPost(4);
    }//GEN-LAST:event_rbtnITSecForumActionPerformed

    private void rbtnICTdevForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnICTdevForumActionPerformed
        addGroupResearchForumPost(3);
    }//GEN-LAST:event_rbtnICTdevForumActionPerformed

    private void rbtnEGovForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEGovForumActionPerformed
        addGroupResearchForumPost(2);
    }//GEN-LAST:event_rbtnEGovForumActionPerformed

    private void rbtnEHealthForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEHealthForumActionPerformed

        addGroupResearchForumPost(1);
    }//GEN-LAST:event_rbtnEHealthForumActionPerformed

    private void rbtnAllGroupForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAllGroupForumActionPerformed
        addResearchForumPost();
    }//GEN-LAST:event_rbtnAllGroupForumActionPerformed

    private void tblForumPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForumPostMouseClicked
        if (evt.getClickCount() == 2) {
            int id = tblForumPost.getSelectedRow();

            String idString = tblForumPost.getModel().getValueAt(id, 4).toString();

            new SeePost(idString).setVisible(true);
        }
    }//GEN-LAST:event_tblForumPostMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        LogInGUI login = new LogInGUI();
        login.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Profil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnSeePostGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneralActionPerformed
        pnlSortButtonsForum.setVisible(false);
        addAllGeneralPost();
    }//GEN-LAST:event_btnSeePostGeneralActionPerformed

    private void btnSeePostResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostResearchActionPerformed
        pnlSortButtonsForum.setVisible(true);
        addResearchForumPost();
    }//GEN-LAST:event_btnSeePostResearchActionPerformed

    private void btnSeePostEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostEducationActionPerformed
        pnlSortButtonsForum.setVisible(false);
        addEducationForumPost();
    }//GEN-LAST:event_btnSeePostEducationActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        pnlSortButtonsForum.setVisible(false);
        addAllForumPost();
    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.ButtonGroup buttonGroupForum;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFooterImageForum;
    private javax.swing.JLabel lblImageHeaderForum;
    private javax.swing.JPanel pnlBackgroundForum;
    private javax.swing.JPanel pnlBreadForum;
    private javax.swing.JPanel pnlFooterForum;
    private javax.swing.JPanel pnlHeaderForum;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlSortButtonsForum;
    private javax.swing.JPanel pnlTableForum;
    private javax.swing.JRadioButton rbtnAllGroupForum;
    private javax.swing.JRadioButton rbtnEGovForum;
    private javax.swing.JRadioButton rbtnEHealthForum;
    private javax.swing.JRadioButton rbtnICTdevForum;
    private javax.swing.JRadioButton rbtnITEdForum;
    private javax.swing.JRadioButton rbtnITSecForum;
    private javax.swing.JRadioButton rbtnSysDevMethForum;
    private javax.swing.JScrollPane spnTableForum;
    private javax.swing.JTable tblForumPost;
    // End of variables declaration//GEN-END:variables
}
