/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.dbConnection;
import info.Profil;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 * public@author fabia
 */
class LogInGUI extends javax.swing.JFrame {

    private String userPwd;
    private String userName;
    private final dbConnection conn;

    /**
     * Creates new form LogInGUI
     */
    public LogInGUI(dbConnection conn) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.conn = conn;
        userName = "";
        userPwd = "";

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlBread = new javax.swing.JPanel();
        layerdPaneLogIn = new javax.swing.JLayeredPane();
        pnlLogIn = new javax.swing.JPanel();
        lblWelcomeTxt = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblUserPassword = new javax.swing.JLabel();
        btnforgottPassword = new javax.swing.JButton();
        pwdUserPassword = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();
        pnlForgotPassword = new javax.swing.JPanel();
        lblWelcomeForgotPassword = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtUserEmail = new javax.swing.JTextField();
        btnGetNewPassword = new javax.swing.JButton();
        btnBackToLogIn = new javax.swing.JButton();
        pnlFooter = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlHome.setPreferredSize(new java.awt.Dimension(1024, 768));

        pnlHeader.setPreferredSize(new java.awt.Dimension(1024, 150));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.setPreferredSize(new java.awt.Dimension(1024, 350));

        layerdPaneLogIn.setLayout(new java.awt.CardLayout());

        pnlLogIn.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogIn.setPreferredSize(new java.awt.Dimension(400, 300));

        lblWelcomeTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWelcomeTxt.setText("Use your ORU-account to log in");

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUserName.setText("Username");

        txtUserName.setColumns(10);
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblUserPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUserPassword.setText("Password");

        btnforgottPassword.setForeground(new java.awt.Color(0, 102, 204));
        btnforgottPassword.setText("Forgotten your password?");
        btnforgottPassword.setBorderPainted(false);
        btnforgottPassword.setContentAreaFilled(false);
        btnforgottPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnforgottPasswordActionPerformed(evt);
            }
        });

        pwdUserPassword.setColumns(10);
        pwdUserPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnLogIn.setBackground(new java.awt.Color(126, 197, 239));
        btnLogIn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(255, 255, 255));
        btnLogIn.setText("Log in");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLogInLayout = new javax.swing.GroupLayout(pnlLogIn);
        pnlLogIn.setLayout(pnlLogInLayout);
        pnlLogInLayout.setHorizontalGroup(
            pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogInLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogIn)
                .addGap(189, 189, 189))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogInLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlLogInLayout.createSequentialGroup()
                            .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlLogInLayout.createSequentialGroup()
                                    .addComponent(lblUserPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addComponent(pwdUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(167, 167, 167))
                        .addGroup(pnlLogInLayout.createSequentialGroup()
                            .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblUserName)
                                .addGroup(pnlLogInLayout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(btnforgottPassword)))
                            .addContainerGap()))))
        );
        pnlLogInLayout.setVerticalGroup(
            pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogInLayout.createSequentialGroup()
                .addComponent(lblWelcomeTxt)
                .addGap(43, 43, 43)
                .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserPassword))
                .addGap(25, 25, 25)
                .addComponent(btnLogIn)
                .addGap(18, 18, 18)
                .addComponent(btnforgottPassword)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        layerdPaneLogIn.add(pnlLogIn, "card9");

        pnlForgotPassword.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcomeForgotPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWelcomeForgotPassword.setText("Enter your email ");

        lblEmail.setText("Email");

        txtUserEmail.setColumns(10);
        txtUserEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnGetNewPassword.setBackground(new java.awt.Color(126, 197, 239));
        btnGetNewPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGetNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        btnGetNewPassword.setText("Get new password");
        btnGetNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetNewPasswordActionPerformed(evt);
            }
        });

        btnBackToLogIn.setForeground(new java.awt.Color(0, 51, 255));
        btnBackToLogIn.setText("back");
        btnBackToLogIn.setBorder(null);
        btnBackToLogIn.setBorderPainted(false);
        btnBackToLogIn.setContentAreaFilled(false);
        btnBackToLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlForgotPasswordLayout = new javax.swing.GroupLayout(pnlForgotPassword);
        pnlForgotPassword.setLayout(pnlForgotPasswordLayout);
        pnlForgotPasswordLayout.setHorizontalGroup(
            pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlForgotPasswordLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(btnGetNewPassword)
                .addGap(150, 150, 150))
            .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnBackToLogIn))
                    .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblEmail)
                        .addGap(27, 27, 27)
                        .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWelcomeForgotPassword)
                            .addComponent(txtUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlForgotPasswordLayout.setVerticalGroup(
            pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForgotPasswordLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblWelcomeForgotPassword)
                .addGap(42, 42, 42)
                .addGroup(pnlForgotPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(40, 40, 40)
                .addComponent(btnGetNewPassword)
                .addGap(18, 18, 18)
                .addComponent(btnBackToLogIn)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        layerdPaneLogIn.add(pnlForgotPassword, "card3");

        javax.swing.GroupLayout pnlBreadLayout = new javax.swing.GroupLayout(pnlBread);
        pnlBread.setLayout(pnlBreadLayout);
        pnlBreadLayout.setHorizontalGroup(
            pnlBreadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBreadLayout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(layerdPaneLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        pnlBreadLayout.setVerticalGroup(
            pnlBreadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBreadLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(layerdPaneLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlFooter.setToolTipText("");
        pnlFooter.setPreferredSize(new java.awt.Dimension(1024, 200));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHomeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBread, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnlBread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(pnlHome);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void logIn(){
     String userID = txtUserName.getText();
        char[] password = pwdUserPassword.getPassword();
        StringBuilder sb = new StringBuilder("");
        String convertedPassword = sb.append(password).toString(); 
        if (Validation.checkTextFieldEmpty(txtUserName) && Validation.checkPassword(pwdUserPassword)) {
            try {
                ArrayList<String> allusers = conn.fetchColumn("select USER_ID from USER");
                if (allusers.contains(userID)) {
                    String storedPassword = conn.fetchSingle("select PASSWORD from USER where USER_ID = '" + userID+"'");
                    String name = conn.fetchSingle("select NAME from USER_PROFILE where PROFILE_ID = '" + userID+"'");

                    if (storedPassword.equals(convertedPassword)) {                   
                        new User(txtUserName.getText());
                        JOptionPane.showMessageDialog(null, "Welcome " + User.getName() + ". You have successfully logged in.");
                            new Profil(conn).setVisible(true);   
                            this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong password, please try again.");
                        pwdUserPassword.requestFocusInWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username, please try again.");
                    txtUserName.requestFocusInWindow();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred");
            }

        }

    }
    
    
    
    
    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed

        logIn();
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnBackToLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLogInActionPerformed
        txtUserName.setText("");
        pwdUserPassword.setText("");
        lblWelcomeTxt.setText("Use your ORU-account to log in");
        lblWelcomeTxt.setForeground(Color.black);
        layerdPaneLogIn.removeAll();
        layerdPaneLogIn.add(pnlLogIn);
        layerdPaneLogIn.repaint();
        layerdPaneLogIn.revalidate();
        txtUserName.requestFocus();
    }//GEN-LAST:event_btnBackToLogInActionPerformed

    private void btnGetNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetNewPasswordActionPerformed
        String mailAccount = txtUserEmail.getText();
        if (mailAccount.equals("existingmailaccount")) {
            JOptionPane.showMessageDialog(null, "A new password has been sent to your email");
            btnBackToLogInActionPerformed(evt);
        } else {
            lblWelcomeForgotPassword.setText("Email doesnt exist");
            lblWelcomeForgotPassword.setForeground(Color.red);
        }

    }//GEN-LAST:event_btnGetNewPasswordActionPerformed

    private void btnforgottPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnforgottPasswordActionPerformed
        txtUserEmail.setText("");
        lblWelcomeForgotPassword.setText("Enter your email");
        lblWelcomeForgotPassword.setForeground(Color.black);
        layerdPaneLogIn.removeAll();
        layerdPaneLogIn.add(pnlForgotPassword);
        layerdPaneLogIn.repaint();
        layerdPaneLogIn.revalidate();
        txtUserEmail.requestFocus();
    }//GEN-LAST:event_btnforgottPasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogIn;
    private javax.swing.JButton btnGetNewPassword;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnforgottPassword;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane layerdPaneLogIn;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserPassword;
    private javax.swing.JLabel lblWelcomeForgotPassword;
    private javax.swing.JLabel lblWelcomeTxt;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlForgotPassword;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogIn;
    private javax.swing.JPasswordField pwdUserPassword;
    private javax.swing.JTextField txtUserEmail;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

}
