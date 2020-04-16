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
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            model.setRowCount(0);
           ArrayList<HashMap<String, String>> posts =  conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION")});
                
            }
        } catch (SQLException ex) 
        
        {
           Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      catch(NullPointerException e)
          {
              JOptionPane.showMessageDialog(null, "No posts");
          }
    }
    
    
    public void addAllForumPost() // add all the Post to the table
    {
        try {
            
            
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            
            model.setRowCount(0);
           ArrayList<HashMap<String, String>> posts = conn.fetchRows("select * FROM POSTS");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                //model.addRow(new Object[]{"Hej"});
            }
        } catch (SQLException ex) 
        
        {
           Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          catch(NullPointerException e)
          {
              JOptionPane.showMessageDialog(null, "No posts");
          }
    }
        
        
        
        
        public void addResearchForumPost() // add all the Post in a certain category  to the table
        {
       
           
            
            try {
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            model.setRowCount(0);
             
            
            
           ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM RESEARCH_POSTS)");
                   

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                
            }
        } catch (SQLException ex) 
        
        {
           Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             catch(NullPointerException e)
          {
              JOptionPane.showMessageDialog(null, "No posts");
          }
            
            
    
    }
        
        
        public void addEducationForumPost() // add all the Post in a certain category  to the table
        {
       
           
            
            try {
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            model.setRowCount(0);
             
            
            
           ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM EDUCATION_POSTS)");
                   

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                
            }
        } catch (SQLException ex) 
        
        {
           Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             catch(NullPointerException e)
          {
              JOptionPane.showMessageDialog(null, "No posts");
          }
            
            
    
    }
        
        
        
        
        
        
        public void addGroupResearchForumPost(int groupID) // add all the Post in a certain category  to the table
        {
       
           
            try {
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            model.setRowCount(0);
             
            
           ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM RESEARCH_POSTS WHERE RESEARCH_GROUP =" + groupID + ")" );
                   

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                
            }
            
            
        } catch (SQLException ex) 
        
        {
           Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             catch(NullPointerException e)
          {
              JOptionPane.showMessageDialog(null, "No posts");
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
        pnlFooterForum = new javax.swing.JPanel();
        lblFooterImageForum = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 2000));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlHeaderForum.setPreferredSize(new java.awt.Dimension(1024, 150));

        lblImageHeaderForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblImageHeaderForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlHeaderForumLayout = new javax.swing.GroupLayout(pnlHeaderForum);
        pnlHeaderForum.setLayout(pnlHeaderForumLayout);
        pnlHeaderForumLayout.setHorizontalGroup(
            pnlHeaderForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageHeaderForum)
        );
        pnlHeaderForumLayout.setVerticalGroup(
            pnlHeaderForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderForumLayout.createSequentialGroup()
                .addComponent(lblImageHeaderForum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlBreadForum.setBackground(new java.awt.Color(126, 197, 239));
        pnlBreadForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

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
                false, false, false, false, true
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
                .addComponent(spnTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout pnlBreadForumLayout = new javax.swing.GroupLayout(pnlBreadForum);
        pnlBreadForum.setLayout(pnlBreadForumLayout);
        pnlBreadForumLayout.setHorizontalGroup(
            pnlBreadForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBreadForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSortButtonsForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        pnlBreadForumLayout.setVerticalGroup(
            pnlBreadForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBreadForumLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlBreadForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSortButtonsForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblFooterImageForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlFooterForumLayout = new javax.swing.GroupLayout(pnlFooterForum);
        pnlFooterForum.setLayout(pnlFooterForumLayout);
        pnlFooterForumLayout.setHorizontalGroup(
            pnlFooterForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooterImageForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFooterForumLayout.setVerticalGroup(
            pnlFooterForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterForumLayout.createSequentialGroup()
                .addComponent(lblFooterImageForum, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setPreferredSize(new java.awt.Dimension(1024, 50));

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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("My Profile");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Log Out");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
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
                .addGap(53, 53, 53)
                .addComponent(btnSeePostResearch)
                .addGap(57, 57, 57)
                .addComponent(btnSeePostGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(17, 17, 17))
        );
        pnlNavBarSeePostLayout.setVerticalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavBarSeePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeePostEducation, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btnSeePostResearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeePostGeneral)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(btnSeePostHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundForumLayout = new javax.swing.GroupLayout(pnlBackgroundForum);
        pnlBackgroundForum.setLayout(pnlBackgroundForumLayout);
        pnlBackgroundForumLayout.setHorizontalGroup(
            pnlBackgroundForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundForumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFooterForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(pnlHeaderForum, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(pnlBreadForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlBackgroundForumLayout.setVerticalGroup(
            pnlBackgroundForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHeaderForum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBreadForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooterForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(921, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBackgroundForum);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnEHealthForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEHealthForumActionPerformed
      
        addGroupResearchForumPost(1);
    }//GEN-LAST:event_rbtnEHealthForumActionPerformed

    private void btnSeePostEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostEducationActionPerformed
     pnlSortButtonsForum.setVisible(false);
       addEducationForumPost();
        
    }//GEN-LAST:event_btnSeePostEducationActionPerformed

    private void btnSeePostResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostResearchActionPerformed
         pnlSortButtonsForum.setVisible(true);
        addResearchForumPost();
    }//GEN-LAST:event_btnSeePostResearchActionPerformed

    private void btnSeePostGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneralActionPerformed
      pnlSortButtonsForum.setVisible(false);
        addAllGeneralPost();
    }//GEN-LAST:event_btnSeePostGeneralActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
      pnlSortButtonsForum.setVisible(false);
        addAllForumPost();
    

    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void rbtnAllGroupForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAllGroupForumActionPerformed
        addResearchForumPost();
    }//GEN-LAST:event_rbtnAllGroupForumActionPerformed

    private void rbtnEGovForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEGovForumActionPerformed
        addGroupResearchForumPost(2);
    }//GEN-LAST:event_rbtnEGovForumActionPerformed

    private void rbtnICTdevForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnICTdevForumActionPerformed
        addGroupResearchForumPost(3);
    }//GEN-LAST:event_rbtnICTdevForumActionPerformed

    private void rbtnITSecForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnITSecForumActionPerformed
        addGroupResearchForumPost(4);
    }//GEN-LAST:event_rbtnITSecForumActionPerformed

    private void rbtnITEdForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnITEdForumActionPerformed
       addGroupResearchForumPost(5);
    }//GEN-LAST:event_rbtnITEdForumActionPerformed

    private void rbtnSysDevMethForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSysDevMethForumActionPerformed
       addGroupResearchForumPost(6);
    }//GEN-LAST:event_rbtnSysDevMethForumActionPerformed

    private void tblForumPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForumPostMouseClicked
        if (evt.getClickCount() == 2) {
            int id = tblForumPost.getSelectedRow();
          
            String idString = tblForumPost.getModel().getValueAt(id, 4).toString();
            
            new SeePost(idString).setVisible(true);
        }
    }//GEN-LAST:event_tblForumPostMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Profil().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        LogInGUI login = new LogInGUI();
        login.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.ButtonGroup buttonGroupForum;
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
