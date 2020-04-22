package info;

import dbUtils.PictureHandler;
import dbUtils.db;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Viggo
 */
public class EditProfile extends javax.swing.JFrame {

    private Profil profile;
    private File file;
    private ImageIcon profilePicture;

    public EditProfile(Profil profile) {
        initComponents();
        this.profile = profile;

        try {
            profilePicture = new ImageIcon(db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = '" + User.getUser() + "'"));
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            lblEditUserImage.setIcon(null);
        }
        lblEditUserImage.setIcon(profilePicture);

        txfMail.setText(User.getMail());
        txtPhone.setText(User.getPhone());
        lblUserName.setText(User.getName());
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundEditProfile = new javax.swing.JPanel();
        pnlUserInfoEditProfile = new javax.swing.JPanel();
        txfMail = new javax.swing.JTextField();
        lblEditUserEmailEditProfile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        pwdOldPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        pwdNewPassword = new javax.swing.JPasswordField();
        lblOldPassword = new javax.swing.JLabel();
        btnUpdateContact = new javax.swing.JButton();
        btnUpdatePassword = new javax.swing.JButton();
        btnEditPicture = new javax.swing.JButton();
        btnSaveProfileChanges = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        lblEditUserImage = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlBackgroundEditProfile.setBackground(new java.awt.Color(44, 95, 125));
        pnlBackgroundEditProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlBackgroundEditProfile.setPreferredSize(new java.awt.Dimension(600, 500));
        pnlBackgroundEditProfile.setLayout(null);

        pnlUserInfoEditProfile.setBackground(new java.awt.Color(44, 95, 125));
        pnlUserInfoEditProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlUserInfoEditProfile.setLayout(null);
        pnlUserInfoEditProfile.add(txfMail);
        txfMail.setBounds(80, 50, 230, 24);

        lblEditUserEmailEditProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEditUserEmailEditProfile.setText("E-mail");
        pnlUserInfoEditProfile.add(lblEditUserEmailEditProfile);
        lblEditUserEmailEditProfile.setBounds(30, 50, 35, 16);

        jLabel1.setText("Name");
        pnlUserInfoEditProfile.add(jLabel1);
        jLabel1.setBounds(30, 20, 33, 16);
        pnlUserInfoEditProfile.add(txtPhone);
        txtPhone.setBounds(80, 80, 230, 24);

        lblPhone.setText("Phone");
        pnlUserInfoEditProfile.add(lblPhone);
        lblPhone.setBounds(30, 80, 41, 16);
        pnlUserInfoEditProfile.add(lblUserName);
        lblUserName.setBounds(80, 20, 230, 20);

        lblNewPassword.setText("New password");
        pnlUserInfoEditProfile.add(lblNewPassword);
        lblNewPassword.setBounds(30, 230, 100, 16);
        pnlUserInfoEditProfile.add(pwdOldPassword);
        pwdOldPassword.setBounds(140, 200, 170, 22);

        jSeparator1.setPreferredSize(new java.awt.Dimension(100, 10));
        pnlUserInfoEditProfile.add(jSeparator1);
        jSeparator1.setBounds(30, 170, 280, 10);
        pnlUserInfoEditProfile.add(pwdNewPassword);
        pwdNewPassword.setBounds(140, 230, 170, 22);

        lblOldPassword.setText("Old password");
        pnlUserInfoEditProfile.add(lblOldPassword);
        lblOldPassword.setBounds(30, 200, 100, 16);

        btnUpdateContact.setText("Update contact information");
        btnUpdateContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateContactActionPerformed(evt);
            }
        });
        pnlUserInfoEditProfile.add(btnUpdateContact);
        btnUpdateContact.setBounds(121, 120, 190, 32);

        btnUpdatePassword.setText("Update password");
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });
        pnlUserInfoEditProfile.add(btnUpdatePassword);
        btnUpdatePassword.setBounds(121, 270, 190, 32);

        pnlBackgroundEditProfile.add(pnlUserInfoEditProfile);
        pnlUserInfoEditProfile.setBounds(140, 60, 340, 360);

        btnEditPicture.setText("Edit Picture");
        btnEditPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPictureActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnEditPicture);
        btnEditPicture.setBounds(10, 220, 100, 32);

        btnSaveProfileChanges.setText("OK");
        btnSaveProfileChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProfileChangesActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnSaveProfileChanges);
        btnSaveProfileChanges.setBounds(260, 440, 111, 32);

        btnCancelEdit.setText("Cancel");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnCancelEdit);
        btnCancelEdit.setBounds(390, 440, 100, 32);

        lblEditUserImage.setText("Image");
        lblEditUserImage.setMaximumSize(new java.awt.Dimension(110, 145));
        lblEditUserImage.setMinimumSize(new java.awt.Dimension(110, 145));
        lblEditUserImage.setPreferredSize(new java.awt.Dimension(110, 145));
        pnlBackgroundEditProfile.add(lblEditUserImage);
        lblEditUserImage.setBounds(10, 60, 110, 145);

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitle.setText("Edit Profile");
        lblTitle.setToolTipText("");
        pnlBackgroundEditProfile.add(lblTitle);
        lblTitle.setBounds(20, 10, 220, 40);

        getContentPane().add(pnlBackgroundEditProfile);
        pnlBackgroundEditProfile.setBounds(0, 0, 600, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveProfileChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProfileChangesActionPerformed
        if (file != null) {
            try {
                db.getDB().saveFileToDB(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        profile.displayProfileImage();
        this.dispose();
    }//GEN-LAST:event_btnSaveProfileChangesActionPerformed

    private void btnEditPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPictureActionPerformed
        PictureHandler handler = new PictureHandler(190, 190);
        this.file = handler.openFile2();

        Image picture = handler.convertToImageFromFile(file);
        lblEditUserImage.setIcon(new ImageIcon(picture));

    }//GEN-LAST:event_btnEditPictureActionPerformed

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelEditActionPerformed

    private void btnUpdateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateContactActionPerformed
        updateContactInfo();
    }//GEN-LAST:event_btnUpdateContactActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        changePassword();
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void updateContactInfo() {
        String mail = txfMail.getText();
        String phone = txtPhone.getText();
        profile.updateProfileTexts(mail, phone);
        try {
            db.getDB().update("UPDATE USER_PROFILE SET EMAILADDRESS = '" + mail + "', PHONE = '" + phone + "' WHERE PROFILE_ID = '" + User.getUser() + "'");
            JOptionPane.showMessageDialog(null, "Contact information updated.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred.");
        }
    }

    private void changePassword() {
        char[] oPass = pwdOldPassword.getPassword();
        char[] nPass = pwdNewPassword.getPassword();
        StringBuilder sb = new StringBuilder("");
        String oldPass = sb.append(oPass).toString();
        String newPass = sb.append(nPass).toString();
        if (Validation.checkPassword(pwdOldPassword)
                && Validation.checkPassword(pwdNewPassword)) {
            try {
                oldPass = db.getDB().fetchSingle("select PASSWORD from USER where USER_ID = '" + User.getUser() + "'");
                if (pwdOldPassword.getPassword().equals(oldPass)) {
                    db.getDB().update("update USER set PASSWORD = '" + newPass + "' where USER_ID = '" + User.getUser() + "'");
                } else {
                    JOptionPane.showMessageDialog(null, "wrong password.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred.");
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnEditPicture;
    private javax.swing.JButton btnSaveProfileChanges;
    private javax.swing.JButton btnUpdateContact;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEditUserEmailEditProfile;
    private javax.swing.JLabel lblEditUserImage;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlBackgroundEditProfile;
    private javax.swing.JPanel pnlUserInfoEditProfile;
    private javax.swing.JPasswordField pwdNewPassword;
    private javax.swing.JPasswordField pwdOldPassword;
    private javax.swing.JTextField txfMail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
