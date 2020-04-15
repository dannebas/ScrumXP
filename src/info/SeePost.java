/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;

/**
 *
 * @author fabia
 */
public class SeePost extends javax.swing.JFrame {

    /**
     * Creates new form SeePost
     */
    public SeePost(String id) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        Post aPost = new Post(id);
        
        
       lblTiltleSeePost.setText(aPost.getTitle());
       lblAuthorSeePost.setText(aPost.getAuthor());
       lblUploadDateSeePost.setText(aPost.getDate());
       
       txtAreaPostSeePost.setLineWrap(true);
        txtAreaPostSeePost.setWrapStyleWord(true);
        txtAreaPostSeePost.setText(aPost.getDescription().indent(4));
       txtAreaPostSeePost.setEditable(false);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        pnlPostHeaderSeePost = new javax.swing.JPanel();
        lblTiltleSeePost = new javax.swing.JLabel();
        lblUploadedPostSeePost = new javax.swing.JLabel();
        lblUploadDateSeePost = new javax.swing.JLabel();
        pnlFooterSeePost = new javax.swing.JPanel();
        lblFooterImageSeePost = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaPostSeePost = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblProfileImageSeePost = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblAuthorSeePost = new javax.swing.JLabel();
        lblAuthorNameSeePost = new javax.swing.JLabel();
        btnPrintPostSeePost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(126, 197, 239));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 780));

        jPanel3.setBackground(new java.awt.Color(126, 197, 239));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 996, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel2.setPreferredSize(new java.awt.Dimension(1024, 200));

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setPreferredSize(new java.awt.Dimension(1024, 41));

        btnSeePostHome.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeePostHome.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostHome.setText("Home");
        btnSeePostHome.setBorder(null);
        btnSeePostHome.setBorderPainted(false);
        btnSeePostHome.setContentAreaFilled(false);

        btnSeePostEducation.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostEducation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeePostEducation.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostEducation.setText("Education");
        btnSeePostEducation.setBorder(null);
        btnSeePostEducation.setBorderPainted(false);
        btnSeePostEducation.setContentAreaFilled(false);

        btnSeePostResearch.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostResearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeePostResearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostResearch.setText("Research");
        btnSeePostResearch.setBorder(null);
        btnSeePostResearch.setBorderPainted(false);
        btnSeePostResearch.setContentAreaFilled(false);

        btnSeePostGeneral.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostGeneral.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeePostGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostGeneral.setText("General");
        btnSeePostGeneral.setBorder(null);
        btnSeePostGeneral.setBorderPainted(false);
        btnSeePostGeneral.setContentAreaFilled(false);

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
                .addGap(53, 53, 53)
                .addComponent(btnSeePostGeneral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNavBarSeePostLayout.setVerticalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavBarSeePostLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeePostHome)
                    .addComponent(btnSeePostEducation)
                    .addComponent(btnSeePostResearch)
                    .addComponent(btnSeePostGeneral))
                .addContainerGap())
        );

        pnlPostHeaderSeePost.setBackground(new java.awt.Color(153, 153, 153));
        pnlPostHeaderSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlPostHeaderSeePost.setPreferredSize(new java.awt.Dimension(1024, 72));

        lblTiltleSeePost.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTiltleSeePost.setForeground(new java.awt.Color(0, 0, 0));
        lblTiltleSeePost.setText("Title");

        lblUploadedPostSeePost.setForeground(new java.awt.Color(0, 51, 255));
        lblUploadedPostSeePost.setText("Uploaded");

        lblUploadDateSeePost.setForeground(new java.awt.Color(0, 51, 255));
        lblUploadDateSeePost.setText("Date");

        javax.swing.GroupLayout pnlPostHeaderSeePostLayout = new javax.swing.GroupLayout(pnlPostHeaderSeePost);
        pnlPostHeaderSeePost.setLayout(pnlPostHeaderSeePostLayout);
        pnlPostHeaderSeePostLayout.setHorizontalGroup(
            pnlPostHeaderSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPostHeaderSeePostLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlPostHeaderSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTiltleSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPostHeaderSeePostLayout.createSequentialGroup()
                        .addComponent(lblUploadedPostSeePost)
                        .addGap(18, 18, 18)
                        .addComponent(lblUploadDateSeePost)))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        pnlPostHeaderSeePostLayout.setVerticalGroup(
            pnlPostHeaderSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlPostHeaderSeePostLayout.createSequentialGroup()
                .addComponent(lblTiltleSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPostHeaderSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUploadedPostSeePost)
                    .addComponent(lblUploadDateSeePost))
                .addContainerGap())
        );

        pnlFooterSeePost.setPreferredSize(new java.awt.Dimension(1024, 184));

        lblFooterImageSeePost.setBackground(new java.awt.Color(255, 255, 255));
        lblFooterImageSeePost.setForeground(new java.awt.Color(51, 51, 51));
        lblFooterImageSeePost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageSeePost.setText("jLabel3");
        lblFooterImageSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlFooterSeePostLayout = new javax.swing.GroupLayout(pnlFooterSeePost);
        pnlFooterSeePost.setLayout(pnlFooterSeePostLayout);
        pnlFooterSeePostLayout.setHorizontalGroup(
            pnlFooterSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooterImageSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, Short.MAX_VALUE)
        );
        pnlFooterSeePostLayout.setVerticalGroup(
            pnlFooterSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterSeePostLayout.createSequentialGroup()
                .addComponent(lblFooterImageSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(126, 197, 239));

        txtAreaPostSeePost.setBackground(new java.awt.Color(255, 255, 255));
        txtAreaPostSeePost.setColumns(20);
        txtAreaPostSeePost.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAreaPostSeePost.setRows(5);
        txtAreaPostSeePost.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 197, 239), 1, true));
        jScrollPane1.setViewportView(txtAreaPostSeePost);

        jPanel2.setBackground(new java.awt.Color(44, 95, 125));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblProfileImageSeePost.setText("BILD");

        jPanel4.setBackground(new java.awt.Color(44, 95, 125));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        lblAuthorSeePost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthorSeePost.setForeground(new java.awt.Color(102, 255, 153));
        lblAuthorSeePost.setText("User");

        lblAuthorNameSeePost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthorNameSeePost.setForeground(new java.awt.Color(255, 255, 255));
        lblAuthorNameSeePost.setText("Author:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAuthorNameSeePost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAuthorSeePost)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthorSeePost)
                    .addComponent(lblAuthorNameSeePost))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfileImageSeePost)
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblProfileImageSeePost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnPrintPostSeePost.setBackground(new java.awt.Color(44, 95, 125));
        btnPrintPostSeePost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPrintPostSeePost.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintPostSeePost.setText("Print");
        btnPrintPostSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlPostHeaderSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPrintPostSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlFooterSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPostHeaderSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrintPostSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(pnlFooterSeePost, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(535, 535, 535))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(697, 697, 697)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintPostSeePost;
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthorNameSeePost;
    private javax.swing.JLabel lblAuthorSeePost;
    private javax.swing.JLabel lblFooterImageSeePost;
    private javax.swing.JLabel lblProfileImageSeePost;
    private javax.swing.JLabel lblTiltleSeePost;
    private javax.swing.JLabel lblUploadDateSeePost;
    private javax.swing.JLabel lblUploadedPostSeePost;
    private javax.swing.JPanel pnlFooterSeePost;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlPostHeaderSeePost;
    private javax.swing.JTextArea txtAreaPostSeePost;
    // End of variables declaration//GEN-END:variables
}
