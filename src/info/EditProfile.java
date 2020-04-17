package info;

import dbUtils.PictureHandler;
import dbUtils.db;
import dbUtils.dbConnection;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

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
        jLabel2 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        btnEditPicture = new javax.swing.JButton();
        btnSaveProfileChanges = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        lblEditUserImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlBackgroundEditProfile.setBackground(new java.awt.Color(44, 95, 125));
        pnlBackgroundEditProfile.setPreferredSize(new java.awt.Dimension(500, 300));
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

        jLabel2.setText("Phone");
        pnlUserInfoEditProfile.add(jLabel2);
        jLabel2.setBounds(30, 80, 41, 16);
        pnlUserInfoEditProfile.add(lblUserName);
        lblUserName.setBounds(80, 20, 230, 20);

        pnlBackgroundEditProfile.add(pnlUserInfoEditProfile);
        pnlUserInfoEditProfile.setBounds(140, 60, 340, 150);

        btnEditPicture.setText("Edit Picture");
        btnEditPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPictureActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnEditPicture);
        btnEditPicture.setBounds(10, 220, 100, 32);

        btnSaveProfileChanges.setText("Save");
        btnSaveProfileChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProfileChangesActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnSaveProfileChanges);
        btnSaveProfileChanges.setBounds(250, 230, 111, 32);

        btnCancelEdit.setText("Cancel");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnCancelEdit);
        btnCancelEdit.setBounds(380, 230, 100, 32);

        lblEditUserImage.setText("Image");
        lblEditUserImage.setMaximumSize(new java.awt.Dimension(110, 145));
        lblEditUserImage.setMinimumSize(new java.awt.Dimension(110, 145));
        lblEditUserImage.setPreferredSize(new java.awt.Dimension(110, 145));
        pnlBackgroundEditProfile.add(lblEditUserImage);
        lblEditUserImage.setBounds(10, 60, 110, 145);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Edit Profile");
        jLabel3.setToolTipText("");
        pnlBackgroundEditProfile.add(jLabel3);
        jLabel3.setBounds(20, 10, 220, 40);

        getContentPane().add(pnlBackgroundEditProfile);
        pnlBackgroundEditProfile.setBounds(0, 0, 500, 300);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveProfileChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProfileChangesActionPerformed
        String mail = txfMail.getText();
        String phone = txtPhone.getText();
        updateText(mail);
        
        try {
            db.getDB().update("UPDATE USER_PROFILE SET EMAILADDRESS = '" + mail + "', PHONE = '" + phone + "' WHERE PROFILE_ID = '" + User.getUser() + "'");
            db.getDB().saveFileToDB(file);
            profile.displayProfileImage();
        } catch (SQLException ex) {

            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void updateImage(ImageIcon image) {

        profile.updateProfile(image);
    }

    private void updateText(String mail) {
        profile.updateProfileTexts(mail);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnEditPicture;
    private javax.swing.JButton btnSaveProfileChanges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEditUserEmailEditProfile;
    private javax.swing.JLabel lblEditUserImage;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlBackgroundEditProfile;
    private javax.swing.JPanel pnlUserInfoEditProfile;
    private javax.swing.JTextField txfMail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
