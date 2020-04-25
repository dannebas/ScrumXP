/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        fillUserCombo();
        fillComboYear();
        if (User.getAdmin() == false) {
            btnEditPost.setVisible(false);
        }
        
        jxdDateFrom.setVisible(false);
        jxdDateTo.setVisible(false);
        lblSearchByDates.setVisible(false);
        lblFromDate.setVisible(false);
        lblToDate.setVisible(false);
        
        
        
    }

    private void addAllGeneralPost() // add all the Post which are Informal to the table
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

    private void filterByUser(String user)    {
        try {
            model = (DefaultTableModel) tblGeneralPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT * FROM POSTS WHERE AUTHOR = '"+user+"' AND POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts by this user"});
        }
    }

    private void fillUserCombo() {

        try {
            ArrayList<String> allUsers = db.getDB().fetchColumn("select USER_ID from USER");

            for (String aUser : allUsers) {

                String userFName = db.getDB().fetchSingle("select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + aUser + "'");
                String userLName = db.getDB().fetchSingle("select LASTNAME from USER_PROFILE where PROFILE_ID = '" + aUser + "'");
                String user = aUser + " (" + userFName + " " + userLName + ")";
                jcbUsers.addItem(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void fillComboYear() {
        try {
            ArrayList<String> allYears;
            String addedYear = "";
            String strYear = "";
            allYears = db.getDB().fetchColumn("select DATE from POSTS order by DATE desc");

            for (String aYear : allYears) {
                strYear = aYear.substring(0, 4);
                if (!strYear.equals(addedYear)) {
                    jcbYear.addItem(strYear);
                    addedYear = strYear;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {

        }
    }
    
     private void filterByYear(String year) {
        try {
            model = (DefaultTableModel) tblGeneralPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("select * from POSTS where DATE like '%" + year + "%' AND POST_ID in (select POST_ID from INFORMAL_POST)");
            for (HashMap<String, String> aPost : posts) {
                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }

        } catch (SQLException ex) {
            Logger.getLogger(Forum.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts that year"});
        }

    }

    private void filterByMonth(String month) {
        String year = jcbYear.getSelectedItem().toString();
        System.out.println(year);
        String yearAndMonth = year + "-" + month;
        System.out.println(yearAndMonth);

        if (!year.equals("Year")) {
            try {
                model = (DefaultTableModel) tblGeneralPost.getModel();
                model.setRowCount(0);
                ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("select * from POSTS where DATE like '%" + yearAndMonth + "%' AND POST_ID in (select POST_ID from INFORMAL_POST)");
                for (HashMap<String, String> aPost : posts) {
                    model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                }

            } catch (SQLException ex) {
                Logger.getLogger(Forum.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                model.addRow(new Object[]{"No Posts that month"});
            }
        } else {
            model.addRow(new Object[]{"Please select a year."});
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
        pnlFilter = new javax.swing.JPanel();
        jcbUsers = new javax.swing.JComboBox<>();
        pnlDateSelection = new javax.swing.JPanel();
        jcbYear = new javax.swing.JComboBox<>();
        jcbMonth = new javax.swing.JComboBox<>();
        lblViewDateSelection = new javax.swing.JLabel();
        lblSearchByDates = new javax.swing.JLabel();
        jxdDateFrom = new org.jdesktop.swingx.JXDatePicker();
        jxdDateTo = new org.jdesktop.swingx.JXDatePicker();
        lblFromDate = new javax.swing.JLabel();
        lblToDate = new javax.swing.JLabel();
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
        spnTableForum.setBounds(30, 90, 950, 240);

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

        pnlFilter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FIlter selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlFilter.setForeground(new java.awt.Color(0, 0, 0));
        pnlFilter.setLayout(null);

        jcbUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Users" }));
        jcbUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUsersActionPerformed(evt);
            }
        });
        pnlFilter.add(jcbUsers);
        jcbUsers.setBounds(20, 30, 160, 26);

        pnlBreadForum.add(pnlFilter);
        pnlFilter.setBounds(30, 10, 250, 70);

        pnlDateSelection.setBackground(new java.awt.Color(255, 255, 255));
        pnlDateSelection.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlDateSelection.setForeground(new java.awt.Color(0, 0, 0));
        pnlDateSelection.setLayout(null);

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));
        jcbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbYearActionPerformed(evt);
            }
        });
        pnlDateSelection.add(jcbYear);
        jcbYear.setBounds(20, 30, 80, 26);

        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December" }));
        jcbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMonthActionPerformed(evt);
            }
        });
        pnlDateSelection.add(jcbMonth);
        jcbMonth.setBounds(120, 30, 110, 26);

        lblViewDateSelection.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblViewDateSelection.setForeground(new java.awt.Color(0, 51, 255));
        lblViewDateSelection.setText("Dates");
        lblViewDateSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewDateSelectionMouseClicked(evt);
            }
        });
        pnlDateSelection.add(lblViewDateSelection);
        lblViewDateSelection.setBounds(440, 40, 90, 14);

        lblSearchByDates.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSearchByDates.setForeground(new java.awt.Color(0, 51, 255));
        lblSearchByDates.setText("Search dates");
        lblSearchByDates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchByDatesMouseClicked(evt);
            }
        });
        pnlDateSelection.add(lblSearchByDates);
        lblSearchByDates.setBounds(330, 40, 100, 14);
        pnlDateSelection.add(jxdDateFrom);
        jxdDateFrom.setBounds(20, 30, 134, 24);
        pnlDateSelection.add(jxdDateTo);
        jxdDateTo.setBounds(170, 30, 134, 24);

        lblFromDate.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblFromDate.setForeground(new java.awt.Color(0, 0, 0));
        lblFromDate.setText("from");
        pnlDateSelection.add(lblFromDate);
        lblFromDate.setBounds(20, 18, 19, 10);

        lblToDate.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblToDate.setForeground(new java.awt.Color(0, 0, 0));
        lblToDate.setText("to");
        pnlDateSelection.add(lblToDate);
        lblToDate.setBounds(170, 18, 8, 10);

        pnlBreadForum.add(pnlDateSelection);
        pnlDateSelection.setBounds(440, 10, 540, 70);

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

    private void jcbUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUsersActionPerformed
        String user = jcbUsers.getSelectedItem().toString().split(" ")[0];
        System.out.println(user);
        filterByUser(user);

    }//GEN-LAST:event_jcbUsersActionPerformed

    private void jcbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbYearActionPerformed
        String year = jcbYear.getSelectedItem().toString();
        jcbMonth.setSelectedIndex(0);
        filterByYear(year);
    }//GEN-LAST:event_jcbYearActionPerformed

    private void jcbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMonthActionPerformed
        int index = jcbMonth.getSelectedIndex();
        String month = "";
        switch (index) {
            case 1:
            month = "01";
            break;
            case 2:
            month = "02";
            break;
            case 3:
            month = "03";
            break;
            case 4:
            month = "04";
            break;
            case 5:
            month = "05";
            break;
            case 6:
            month = "06";
            break;
            case 7:
            month = "07";
            break;
            case 8:
            month = "08";
            break;
            case 9:
            month = "09";
            break;
            case 10:
            month = "10";
            break;
            case 11:
            month = "11";
            break;
            case 12:
            month = "12";
            break;
            default:
            month = "01";

        }
        filterByMonth(month);
    }//GEN-LAST:event_jcbMonthActionPerformed

    private void lblViewDateSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewDateSelectionMouseClicked
        String lblText = lblViewDateSelection.getText();
        if(lblText.equals("Dates")){
        {
            
        lblViewDateSelection.setText("Years/Month");    
        jcbMonth.setVisible(false);
        jcbYear.setVisible(false);
        lblSearchByDates.setVisible(true);
         lblFromDate.setVisible(true);
              lblToDate.setVisible(true);
        jxdDateFrom.setVisible(true);
        jxdDateTo.setVisible(true);
        }
        }
        else if(lblText.equals("Years/Month"))
        { 
            lblViewDateSelection.setText("Dates"); 
           jxdDateFrom.setVisible(false);
           jxdDateTo.setVisible(false); 
            lblSearchByDates.setVisible(false);
             lblFromDate.setVisible(false);
              lblToDate.setVisible(false);
           jcbMonth.setVisible(true);
           jcbYear.setVisible(true);     
        }       
    }//GEN-LAST:event_lblViewDateSelectionMouseClicked

    private void lblSearchByDatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchByDatesMouseClicked
       if(jxdDateFrom.getDate() !=null && jxdDateTo.getDate() !=null)
                {
                    filterBetweenTwoDates();
                }
        else{
        JOptionPane.showMessageDialog(null, "Choose two dates to filter by");
        }
    }//GEN-LAST:event_lblSearchByDatesMouseClicked

    
     private void filterBetweenTwoDates()
        {
           model.setRowCount(0);
           
           ArrayList<HashMap<String, String>> aPostList = new ArrayList<>();
            try {
                Date fromDate = jxdDateFrom.getDate();
                Date toDate = jxdDateTo.getDate();

                if (fromDate.before(toDate)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String fromDate1 = sdf.format(fromDate);
                    String toDate1 = sdf.format(toDate);
                    aPostList = db.getDB().fetchRows("SELECT * FROM POSTS WHERE DATE BETWEEN " + "'" + fromDate1 + "'" + "AND" + "'" + toDate1 + "' AND POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");
                    for (HashMap<String, String> aPost: aPostList) {
                    model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                }

            }} catch (SQLException ex) {
                Logger.getLogger(Forum.class
                        .getName()).log(Level.SEVERE, null, ex);}
             catch (NullPointerException e) {
                model.addRow(new Object[]{"No between thess dates"});
            }

        
        }
    
    
    
    
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
    private javax.swing.JComboBox<String> jcbMonth;
    private javax.swing.JComboBox<String> jcbUsers;
    private javax.swing.JComboBox<String> jcbYear;
    private org.jdesktop.swingx.JXDatePicker jxdDateFrom;
    private org.jdesktop.swingx.JXDatePicker jxdDateTo;
    private javax.swing.JLabel lblFooterImageForum;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblImageHeader;
    private javax.swing.JLabel lblSearchByDates;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JLabel lblViewDateSelection;
    private javax.swing.JPanel pnlBackgroundForum;
    private javax.swing.JPanel pnlBreadForum;
    private javax.swing.JPanel pnlDateSelection;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlFooterForum;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JScrollPane spnTableForum;
    private javax.swing.JTable tblGeneralPost;
    // End of variables declaration//GEN-END:variables
}
