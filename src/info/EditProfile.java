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
        catch (NullPointerException ex){
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
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        btnEditPicture = new javax.swing.JButton();
        btnSaveProfileChanges = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        lblEditUserImage = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlBackgroundEditProfile.setBackground(new java.awt.Color(44, 95, 125));
        pnlBackgroundEditProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlBackgroundEditProfile.setPreferredSize(new java.awt.Dimension(500, 400));
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

        lblPassword.setText("New password");
        pnlUserInfoEditProfile.add(lblPassword);
        lblPassword.setBounds(30, 120, 100, 16);

        pwdPassword.setText("jPasswordField1");
        pnlUserInfoEditProfile.add(pwdPassword);
        pwdPassword.setBounds(30, 140, 90, 22);

        pnlBackgroundEditProfile.add(pnlUserInfoEditProfile);
        pnlUserInfoEditProfile.setBounds(140, 60, 340, 230);

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
        btnSaveProfileChanges.setBounds(260, 320, 111, 32);

        btnCancelEdit.setText("Cancel");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnCancelEdit);
        btnCancelEdit.setBounds(380, 320, 100, 32);

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
        pnlBackgroundEditProfile.setBounds(0, 0, 500, 400);

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
    private javax.swing.JLabel lblEditUserEmailEditProfile;
    private javax.swing.JLabel lblEditUserImage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlBackgroundEditProfile;
    private javax.swing.JPanel pnlUserInfoEditProfile;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txfMail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
