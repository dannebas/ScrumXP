/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import JavaMail.JavaMailUtil;
import static JavaMail.JavaMailUtil.prepareMessage;
import dbUtils.db;
import static dbUtils.db.getDB;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;


/**
 *
 * @author Lukas
 */
public class Booking extends javax.swing.JFrame {

    private static String innehall;
    private static String subject;
    

    
    public Booking() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH); 
        populateMemberCMBX();
        populateGroupCMBX();
    }

    public static void main(String[] args) {
        
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlDate = new javax.swing.JPanel();
        pnlTime = new javax.swing.JPanel();
        scrlMessage = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        cmbGroup = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        scrlSummary = new javax.swing.JScrollPane();
        txtSummary = new javax.swing.JTextArea();
        btnGroup = new javax.swing.JButton();
        btnMember = new javax.swing.JButton();
        btnEmail = new javax.swing.JButton();
        btnLocation = new javax.swing.JButton();
        lblLocation = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblMember = new javax.swing.JLabel();
        lblGroup = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblInvitations = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstInvitations = new javax.swing.JList<>();
        dp = new com.github.lgooddatepicker.components.DatePicker();
        tp = new com.github.lgooddatepicker.components.TimePicker();
        cmbMember = new javax.swing.JComboBox<>();

        jButton4.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlDate.setBackground(new java.awt.Color(255, 255, 255));
        pnlDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlDateLayout = new javax.swing.GroupLayout(pnlDate);
        pnlDate.setLayout(pnlDateLayout);
        pnlDateLayout.setHorizontalGroup(
            pnlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );
        pnlDateLayout.setVerticalGroup(
            pnlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        pnlTime.setBackground(new java.awt.Color(255, 255, 255));
        pnlTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlTimeLayout = new javax.swing.GroupLayout(pnlTime);
        pnlTime.setLayout(pnlTimeLayout);
        pnlTimeLayout.setHorizontalGroup(
            pnlTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        pnlTimeLayout.setVerticalGroup(
            pnlTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        txtMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrlMessage.setViewportView(txtMessage);

        cmbGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Group", "eH�lsa", "osv", "osv" }));
        cmbGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGroupActionPerformed(evt);
            }
        });

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        scrlSummary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSummary.setColumns(20);
        txtSummary.setRows(5);
        txtSummary.setBorder(null);
        scrlSummary.setViewportView(txtSummary);

        btnGroup.setText("Add");
        btnGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroupActionPerformed(evt);
            }
        });

        btnMember.setText("Add");
        btnMember.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });

        btnEmail.setText("Add");
        btnEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        btnLocation.setText("Add");
        btnLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblLocation.setText("Meeting location:");

        lblEmail.setText("E-mail:");

        lblMember.setText("Member:");

        lblGroup.setText("Group:");

        txtTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitle.setText("Title:");

        lblDate.setText("Date:");

        lblTime.setText("Time:");

        lblInvitations.setText("Invited:");

        btnBook.setText("Book");
        btnBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        lblMessage.setText("Message:");

        btnCancel.setText("Cancel");
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lstInvitations.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstInvitations);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrlMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(txtTitle))
                            .addComponent(lblTitle)
                            .addComponent(lblMessage))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbGroup, 0, 259, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLocation)
                                    .addComponent(cmbMember, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMember, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrlSummary, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                            .addComponent(lblLocation)
                            .addComponent(lblEmail)
                            .addComponent(lblMember)
                            .addComponent(lblGroup))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInvitations)
                            .addComponent(jScrollPane1))))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGroup)
                    .addComponent(lblTitle)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitle)
                            .addComponent(cmbGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMember)
                            .addComponent(lblMessage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addComponent(lblEmail))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLocation)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrlSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrlMessage)))
                    .addComponent(pnlDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(lblInvitations))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(pnlTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateMemberCMBX()
    {
        
     
        ArrayList<HashMap<String, String>> name;
            
        String q1 = "SELECT LASTNAME, FIRSTNAME FROM USER_PROFILE;";
        try {
            name = db.getDB().fetchRows(q1);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
        cmbMember.setModel(model);
        
        for (HashMap<String, String> list : name)
        {   
            String givenName = "";
            //model.addElement(list);
            int i = 0;
           
            for(String key : list.keySet())
            {
                if(i<=1){
                    givenName=givenName+" ";
                }
                
                String ettNamn = list.get(key);
                System.out.println(ettNamn);
                givenName = givenName+ettNamn;               
                i++;
                
            //model.addElement(list);
            
            }
            
            model.addElement(givenName);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }
    
    private void populateGroupCMBX()
    {
        ArrayList<String> groups = new ArrayList<>();
        
        String q1 = "SELECT GROUP_NAME from RESEARCH_GROUP;";
        
        try {
            groups = db.getDB().fetchColumn(q1);
            DefaultComboBoxModel model = new  DefaultComboBoxModel();
            cmbGroup.setModel(model);
            for(String group : groups)
            {
                model.addElement(group);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void cmbGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGroupActionPerformed
    public static String sendText()
    {
        return innehall;
    }
    public void getText()
    {
        this.innehall = txtMessage.getText();
              
    }
    public static String sendSubject()
    {
        return subject;
    }
    
    public void getSubject()
    {
        this.subject = txtTitle.getText();
    }
    
    
    
    public String collectTitle() {
       String title = txtTitle.getText();
       return title;
    }
    
    public String collectMessage() {
        String message = txtMessage.getText();
        return message;
    }
    
    private String collectLocation() {
        String location = txtLocation.getText();
        return location;
    }
    
    public String collectMail() {
        for(int i = 0; i<lstInvitations.getModel().getSize(); i++){
            String mailAdress = lstInvitations.getModel().getElementAt(i);
            System.out.println(i);
            return mailAdress;
        }
        return "";
    }
    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
        lstInvitations.setModel(invitations);
        String member = cmbMember.getSelectedItem().toString();
        invitations.addElement(member);
    }//GEN-LAST:event_btnMemberActionPerformed

    DefaultListModel<String> invitations = new DefaultListModel<String>();
    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        lstInvitations.setModel(invitations);
        String mailAdress = txtEmail.getText();
        invitations.addElement(mailAdress);
        txtEmail.setText("");
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        
        getText();
        getSubject();
        
        String subject = txtTitle.getText();
        String message = txtMessage.getText();
        String location = txtLocation.getText();
        String date = dp.getText().toString();
        String time = tp.getText().toString();
        // String user = "getUser()";
        
        
        
        try {
         String autoID;
            autoID = db.getDB().getAutoIncrement("MEETINGS", "MEETING_ID");
            if (autoID == null) {
                    autoID = "1";
                }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
                
        
        
        
        /*String q1 = "INSERT into meetings("+subject+", "+message+", "+location+", "+date+", "+time+")";  // user saknas. metod ej klar. 
        try {
            db.getDB().insert(q1);
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }

*/
        
        
        for(int i = 0; i<lstInvitations.getModel().getSize(); i++){
            String mailAdress = lstInvitations.getModel().getElementAt(i);
            System.out.println(i);
            
            try {  
                
                
                
                JavaMail.JavaMailUtil.sendMail(mailAdress);
                
            } catch (Exception ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        invitations.removeAllElements();

        
        
        
        
    
        
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroupActionPerformed
        
      
        String cmbx = cmbGroup.getSelectedItem().toString();
        String q1 = "SELECT EMAILADDRESS FROM USER_PROFILE where PROFILE_ID = (SELECT MEMBER FROM group_members WHERE research_group = (SELECT group_id from research_group where group_name='"+cmbx+"'));";
        System.out.println(q1);
        try {
            
            lstInvitations.setModel(invitations);
            
            System.out.println(1);
            
            ArrayList<String> al = db.getDB().fetchColumn(q1);
          
            System.out.println(al);
            for(int i = 0; i < al.size(); i++)
            {
                System.out.println(3);
                String a = al.get(i).toString();
                
                invitations.addElement(a);
                
                
               
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(7);
        }
        
        
   
    }//GEN-LAST:event_btnGroupActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnGroup;
    private javax.swing.JButton btnLocation;
    private javax.swing.JButton btnMember;
    private javax.swing.JComboBox<String> cmbGroup;
    private javax.swing.JComboBox<String> cmbMember;
    private com.github.lgooddatepicker.components.DatePicker dp;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblInvitations;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstInvitations;
    private javax.swing.JPanel pnlDate;
    private javax.swing.JPanel pnlTime;
    private javax.swing.JScrollPane scrlMessage;
    private javax.swing.JScrollPane scrlSummary;
    private com.github.lgooddatepicker.components.TimePicker tp;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextArea txtSummary;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
