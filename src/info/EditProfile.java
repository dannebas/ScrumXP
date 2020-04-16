package info;

import dbUtils.PictureHandler;
import dbUtils.db;
import dbUtils.dbConnection;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Viggo
 */

public class EditProfile extends javax.swing.JFrame
{

    private Profil profile;
    
    public EditProfile(Profil profile) 
    {
        initComponents();
        this.profile = profile;
        
        txfMail.setText(User.getMail());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundEditProfile = new javax.swing.JPanel();
        pnlEditPictureEditProfile = new javax.swing.JPanel();
        lblEditUserImage = new javax.swing.JLabel();
        lblEditPicture = new javax.swing.JLabel();
        btnUpdateText = new javax.swing.JButton();
        pnlUserInfoEditProfile = new javax.swing.JPanel();
        txfMail = new javax.swing.JTextField();
        lblEditUserEmailEditProfile = new javax.swing.JLabel();
        pnlHeaderEditProfile = new javax.swing.JPanel();
        lblHeaderImageEditProfile = new javax.swing.JLabel();
        pnlfooterEditProfile = new javax.swing.JPanel();
        lblFooterImageEditProfile = new javax.swing.JLabel();
        lblBacktoProfile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackgroundEditProfile.setBackground(new java.awt.Color(126, 197, 239));

        pnlEditPictureEditProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlEditPictureEditProfile.setForeground(new java.awt.Color(102, 102, 102));

        lblEditUserImage.setText("Image");

        javax.swing.GroupLayout pnlEditPictureEditProfileLayout = new javax.swing.GroupLayout(pnlEditPictureEditProfile);
        pnlEditPictureEditProfile.setLayout(pnlEditPictureEditProfileLayout);
        pnlEditPictureEditProfileLayout.setHorizontalGroup(
            pnlEditPictureEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditPictureEditProfileLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblEditUserImage)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        pnlEditPictureEditProfileLayout.setVerticalGroup(
            pnlEditPictureEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditPictureEditProfileLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblEditUserImage)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        lblEditPicture.setBackground(new java.awt.Color(0, 0, 0));
        lblEditPicture.setForeground(new java.awt.Color(0, 51, 204));
        lblEditPicture.setText("Edit Picture");
        lblEditPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditPictureMouseClicked(evt);
            }
        });

        btnUpdateText.setText("Save");
        btnUpdateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTextActionPerformed(evt);
            }
        });

        pnlUserInfoEditProfile.setBackground(new java.awt.Color(44, 95, 125));
        pnlUserInfoEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblEditUserEmailEditProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEditUserEmailEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblEditUserEmailEditProfile.setText("E-mail");

        javax.swing.GroupLayout pnlUserInfoEditProfileLayout = new javax.swing.GroupLayout(pnlUserInfoEditProfile);
        pnlUserInfoEditProfile.setLayout(pnlUserInfoEditProfileLayout);
        pnlUserInfoEditProfileLayout.setHorizontalGroup(
            pnlUserInfoEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoEditProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditUserEmailEditProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfMail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        pnlUserInfoEditProfileLayout.setVerticalGroup(
            pnlUserInfoEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserInfoEditProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserInfoEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditUserEmailEditProfile)
                    .addComponent(txfMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        lblHeaderImageEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblHeaderImageEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblHeaderImageEditProfile.setPreferredSize(new java.awt.Dimension(1024, 204));

        javax.swing.GroupLayout pnlHeaderEditProfileLayout = new javax.swing.GroupLayout(pnlHeaderEditProfile);
        pnlHeaderEditProfile.setLayout(pnlHeaderEditProfileLayout);
        pnlHeaderEditProfileLayout.setHorizontalGroup(
            pnlHeaderEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeaderImageEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlHeaderEditProfileLayout.setVerticalGroup(
            pnlHeaderEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderEditProfileLayout.createSequentialGroup()
                .addComponent(lblHeaderImageEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        lblFooterImageEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageEditProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlfooterEditProfileLayout = new javax.swing.GroupLayout(pnlfooterEditProfile);
        pnlfooterEditProfile.setLayout(pnlfooterEditProfileLayout);
        pnlfooterEditProfileLayout.setHorizontalGroup(
            pnlfooterEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooterImageEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlfooterEditProfileLayout.setVerticalGroup(
            pnlfooterEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfooterEditProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFooterImageEditProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblBacktoProfile.setForeground(new java.awt.Color(0, 51, 204));
        lblBacktoProfile.setText("Back");
        lblBacktoProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBacktoProfileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundEditProfileLayout = new javax.swing.GroupLayout(pnlBackgroundEditProfile);
        pnlBackgroundEditProfile.setLayout(pnlBackgroundEditProfileLayout);
        pnlBackgroundEditProfileLayout.setHorizontalGroup(
            pnlBackgroundEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeaderEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlfooterEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBackgroundEditProfileLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlBackgroundEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEditPictureEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditPicture))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundEditProfileLayout.createSequentialGroup()
                        .addComponent(btnUpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundEditProfileLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBacktoProfile)
                            .addComponent(pnlUserInfoEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlBackgroundEditProfileLayout.setVerticalGroup(
            pnlBackgroundEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundEditProfileLayout.createSequentialGroup()
                .addComponent(pnlHeaderEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundEditProfileLayout.createSequentialGroup()
                        .addComponent(pnlEditPictureEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEditPicture)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundEditProfileLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(pnlUserInfoEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnUpdateText)
                .addGap(18, 18, 18)
                .addComponent(lblBacktoProfile)
                .addGap(18, 18, 18)
                .addComponent(pnlfooterEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackgroundEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackgroundEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblEditPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditPictureMouseClicked
        PictureHandler handler = new PictureHandler(190, 190);
        File picture = handler.openFile2();
        try {
            db.getDB().saveFileToDB(picture);
            profile.displayProfileImage();
        } catch (IOException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblEditPictureMouseClicked

    private void btnUpdateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTextActionPerformed
        String mail = txfMail.getText();
        
        updateText(mail);
        try{
        db.getDB().update("UPDATE USER_PROFILE SET EMAILADDRESS = '" + mail + "'" + "WHERE PROFILE_ID = '" + User.getUser() + "'");
        }
        catch(SQLException ex)
        {
            
           Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }//GEN-LAST:event_btnUpdateTextActionPerformed

    private void lblBacktoProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBacktoProfileMouseClicked
        dispose();
    }//GEN-LAST:event_lblBacktoProfileMouseClicked

    
    private void updateImage(ImageIcon image)
    {
        
        profile.updateProfile(image);
    }
    
    private void updateText(String mail)
    {
        profile.updateProfileTexts(mail);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateText;
    private javax.swing.JLabel lblBacktoProfile;
    private javax.swing.JLabel lblEditPicture;
    private javax.swing.JLabel lblEditUserEmailEditProfile;
    private javax.swing.JLabel lblEditUserImage;
    private javax.swing.JLabel lblFooterImageEditProfile;
    private javax.swing.JLabel lblHeaderImageEditProfile;
    private javax.swing.JPanel pnlBackgroundEditProfile;
    private javax.swing.JPanel pnlEditPictureEditProfile;
    private javax.swing.JPanel pnlHeaderEditProfile;
    private javax.swing.JPanel pnlUserInfoEditProfile;
    private javax.swing.JPanel pnlfooterEditProfile;
    private javax.swing.JTextField txfMail;
    // End of variables declaration//GEN-END:variables
}
