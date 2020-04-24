/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import JavaMail.NotificationHandler;
import dbUtils.db;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Lukas
 */
public class Booking extends javax.swing.JFrame {

    private static String innehall;
    private static String subject;
    private static String sum;
    private static String user;
    private ArrayList<String> arrayListAddedUsers;

    public Booking() {
        initComponents();
        populateMemberCMBX();
        populateGroupCMBX();
        getUser();
        setLocationRelativeTo(null);
        this.arrayListAddedUsers = new ArrayList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        pnlBread = new javax.swing.JPanel();
        scrlMessage = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        txtTitle = new javax.swing.JTextField();
        pnlPeople = new javax.swing.JPanel();
        cmbGroup = new javax.swing.JComboBox<>();
        btnGroup = new javax.swing.JButton();
        cmbMember = new javax.swing.JComboBox<>();
        btnMember = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        btnEmail = new javax.swing.JButton();
        lblGroup = new javax.swing.JLabel();
        lblMember = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        scrInvitations = new javax.swing.JScrollPane();
        lstInvitations = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        pnlDetails = new javax.swing.JPanel();
        lblLocation = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        btnLocation = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        tp = new com.github.lgooddatepicker.components.TimePicker();
        dp = new com.github.lgooddatepicker.components.DatePicker();
        lblDate = new javax.swing.JLabel();
        btnTime = new javax.swing.JButton();
        btnDate = new javax.swing.JButton();
        pnlSummary = new javax.swing.JPanel();
        scrlSummary = new javax.swing.JScrollPane();
        txtSummary = new javax.swing.JTextArea();
        btnCancel = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();

        jButton4.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Meeting", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBread.setPreferredSize(new java.awt.Dimension(880, 650));
        pnlBread.setLayout(null);

        scrlMessage.setBackground(new java.awt.Color(255, 255, 255));
        scrlMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        scrlMessage.setPreferredSize(new java.awt.Dimension(200, 100));

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        txtMessage.setBorder(null);
        scrlMessage.setViewportView(txtMessage);

        pnlBread.add(scrlMessage);
        scrlMessage.setBounds(30, 120, 240, 140);

        txtTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Title", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBread.add(txtTitle);
        txtTitle.setBounds(30, 50, 240, 50);

        pnlPeople.setBackground(new java.awt.Color(255, 255, 255));
        pnlPeople.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Participants", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlPeople.setLayout(null);

        cmbGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Group", "eHälsa", "osv", "osv" }));
        cmbGroup.setMinimumSize(new java.awt.Dimension(250, 30));
        cmbGroup.setPreferredSize(new java.awt.Dimension(250, 30));
        cmbGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGroupActionPerformed(evt);
            }
        });
        pnlPeople.add(cmbGroup);
        cmbGroup.setBounds(110, 50, 250, 30);

        btnGroup.setBackground(new java.awt.Color(44, 95, 125));
        btnGroup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGroup.setForeground(new java.awt.Color(255, 255, 255));
        btnGroup.setText("Add");
        btnGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGroup.setPreferredSize(new java.awt.Dimension(60, 30));
        btnGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroupActionPerformed(evt);
            }
        });
        pnlPeople.add(btnGroup);
        btnGroup.setBounds(370, 50, 60, 30);

        cmbMember.setMinimumSize(new java.awt.Dimension(250, 30));
        cmbMember.setPreferredSize(new java.awt.Dimension(250, 30));
        pnlPeople.add(cmbMember);
        cmbMember.setBounds(110, 90, 250, 30);

        btnMember.setBackground(new java.awt.Color(44, 95, 125));
        btnMember.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMember.setForeground(new java.awt.Color(255, 255, 255));
        btnMember.setText("Add");
        btnMember.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnMember.setPreferredSize(new java.awt.Dimension(60, 30));
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });
        pnlPeople.add(btnMember);
        btnMember.setBounds(370, 90, 60, 30);

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.setPreferredSize(new java.awt.Dimension(250, 30));
        pnlPeople.add(txtEmail);
        txtEmail.setBounds(110, 130, 250, 30);

        btnEmail.setBackground(new java.awt.Color(44, 95, 125));
        btnEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEmail.setForeground(new java.awt.Color(255, 255, 255));
        btnEmail.setText("Add");
        btnEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnEmail.setPreferredSize(new java.awt.Dimension(60, 30));
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });
        pnlPeople.add(btnEmail);
        btnEmail.setBounds(370, 130, 60, 30);

        lblGroup.setText("Research Group");
        lblGroup.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlPeople.add(lblGroup);
        lblGroup.setBounds(10, 50, 100, 30);

        lblMember.setText("Member");
        lblMember.setMaximumSize(new java.awt.Dimension(100, 30));
        lblMember.setMinimumSize(new java.awt.Dimension(100, 30));
        lblMember.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlPeople.add(lblMember);
        lblMember.setBounds(10, 90, 100, 30);

        lblEmail.setText("E-mail");
        lblEmail.setMaximumSize(new java.awt.Dimension(100, 30));
        lblEmail.setMinimumSize(new java.awt.Dimension(100, 30));
        lblEmail.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlPeople.add(lblEmail);
        lblEmail.setBounds(10, 130, 100, 30);

        scrInvitations.setBackground(new java.awt.Color(255, 255, 255));

        lstInvitations.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrInvitations.setViewportView(lstInvitations);

        pnlPeople.add(scrInvitations);
        scrInvitations.setBounds(10, 180, 420, 130);

        jButton1.setBackground(new java.awt.Color(44, 95, 125));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Remove");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlPeople.add(jButton1);
        jButton1.setBounds(340, 320, 90, 32);

        jCheckBox1.setText("Make public");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setMargin(new java.awt.Insets(-2, -2, -2, -2));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        pnlPeople.add(jCheckBox1);
        jCheckBox1.setBounds(10, 20, 100, 23);

        pnlBread.add(pnlPeople);
        pnlPeople.setBounds(30, 270, 440, 370);

        pnlDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlDetails.setLayout(null);

        lblLocation.setText("Meeting location");
        lblLocation.setMaximumSize(new java.awt.Dimension(100, 30));
        lblLocation.setMinimumSize(new java.awt.Dimension(100, 30));
        lblLocation.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDetails.add(lblLocation);
        lblLocation.setBounds(20, 40, 100, 30);

        txtLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLocation.setMinimumSize(new java.awt.Dimension(250, 30));
        txtLocation.setPreferredSize(new java.awt.Dimension(250, 30));
        pnlDetails.add(txtLocation);
        txtLocation.setBounds(140, 40, 250, 30);

        btnLocation.setBackground(new java.awt.Color(44, 95, 125));
        btnLocation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnLocation.setText("Add");
        btnLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationActionPerformed(evt);
            }
        });
        pnlDetails.add(btnLocation);
        btnLocation.setBounds(410, 40, 75, 30);

        lblTime.setText("Time");
        lblTime.setMaximumSize(new java.awt.Dimension(100, 30));
        lblTime.setMinimumSize(new java.awt.Dimension(100, 30));
        lblTime.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDetails.add(lblTime);
        lblTime.setBounds(20, 140, 100, 30);

        tp.setMinimumSize(new java.awt.Dimension(250, 30));
        tp.setPreferredSize(new java.awt.Dimension(250, 30));
        pnlDetails.add(tp);
        tp.setBounds(140, 140, 250, 30);

        dp.setMinimumSize(new java.awt.Dimension(250, 30));
        dp.setName(""); // NOI18N
        dp.setPreferredSize(new java.awt.Dimension(250, 30));
        pnlDetails.add(dp);
        dp.setBounds(140, 90, 250, 30);

        lblDate.setText("Date");
        lblDate.setMaximumSize(new java.awt.Dimension(100, 30));
        lblDate.setMinimumSize(new java.awt.Dimension(100, 30));
        lblDate.setPreferredSize(new java.awt.Dimension(100, 30));
        pnlDetails.add(lblDate);
        lblDate.setBounds(20, 90, 100, 30);

        btnTime.setBackground(new java.awt.Color(44, 95, 125));
        btnTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTime.setForeground(new java.awt.Color(255, 255, 255));
        btnTime.setText("Add");
        btnTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeActionPerformed(evt);
            }
        });
        pnlDetails.add(btnTime);
        btnTime.setBounds(410, 140, 75, 30);

        btnDate.setBackground(new java.awt.Color(44, 95, 125));
        btnDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDate.setForeground(new java.awt.Color(255, 255, 255));
        btnDate.setText("Add");
        btnDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });
        pnlDetails.add(btnDate);
        btnDate.setBounds(410, 90, 74, 31);

        pnlBread.add(pnlDetails);
        pnlDetails.setBounds(280, 50, 540, 210);

        pnlSummary.setBackground(new java.awt.Color(255, 255, 255));
        pnlSummary.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Summary", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlSummary.setLayout(null);

        scrlSummary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSummary.setColumns(20);
        txtSummary.setRows(5);
        txtSummary.setBorder(null);
        scrlSummary.setViewportView(txtSummary);

        pnlSummary.add(scrlSummary);
        scrlSummary.setBounds(10, 30, 320, 250);

        btnCancel.setBackground(new java.awt.Color(44, 95, 125));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlSummary.add(btnCancel);
        btnCancel.setBounds(40, 310, 100, 40);

        btnBook.setBackground(new java.awt.Color(44, 95, 125));
        btnBook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("Confirm");
        btnBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        pnlSummary.add(btnBook);
        btnBook.setBounds(180, 310, 100, 40);

        pnlBread.add(pnlSummary);
        pnlSummary.setBounds(480, 270, 340, 370);

        getContentPane().add(pnlBread);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateMemberCMBX() {

        ArrayList<HashMap<String, String>> name;

        String q1 = "SELECT LASTNAME, FIRSTNAME FROM USER_PROFILE;";
        try {
            name = db.getDB().fetchRows(q1);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            cmbMember.setModel(model);

            for (HashMap<String, String> list : name) {
                String givenName = "";
                //model.addElement(list);
                int i = 0;

                for (String key : list.keySet()) {

                    String ettNamn = list.get(key);
                    givenName = ettNamn + " " + givenName;
                    i++;

                    //model.addElement(list);
                }

                model.addElement(givenName);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void populateGroupCMBX() {
        ArrayList<String> groups = new ArrayList<>();

        String q1 = "SELECT GROUP_NAME from RESEARCH_GROUP;";

        try {
            groups = db.getDB().fetchColumn(q1);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            cmbGroup.setModel(model);
            for (String group : groups) {
                model.addElement(group);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cmbGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGroupActionPerformed

    public static String sendUser() {
        return user;
    }

    public void getUser() {
        this.user = User.getUser();
    }

    public static String sendSum() {
        return sum;
    }

    public void getSum() {
        this.sum = txtSummary.getText();
    }

    public static String sendText() {
        return innehall;
    }

    public void getText() {
        this.innehall = txtMessage.getText();

    }

    public static String sendSubject() {
        return subject;
    }

    public void getSubject() {
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
        for (int i = 0; i < lstInvitations.getModel().getSize(); i++) {
            String mailAdress = lstInvitations.getModel().getElementAt(i);
            return mailAdress;
        }
        return "";
    }
    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
        try {

            lstInvitations.setModel(invitations);
            String member = cmbMember.getSelectedItem().toString();
            String[] names = member.split("\\s+");
            String n1 = names[0];
            String n2 = names[1];
            String q1 = "select EMAILADDRESS from USER_PROFILE where FIRSTNAME = '" + n1 + "' and LASTNAME = '" + n2 + "';";
            String q2 = "select PROFILE_ID from USER_PROFILE where FIRSTNAME = '" + n1 + "' and LASTNAME = '" + n2 + "';";
            String a = db.getDB().fetchSingle(q1);
            String b = db.getDB().fetchSingle(q2);

            lstInvitations.setModel(invitations);
            noDuplicateTwoValues(a, b);

        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMemberActionPerformed

    DefaultListModel<String> invitations = new DefaultListModel<String>();
    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed

        lstInvitations.setModel(invitations);
        String mailAdress = txtEmail.getText();
        noDuplicate(mailAdress);

    }//GEN-LAST:event_btnEmailActionPerformed

    private void noDuplicateTwoValues(String aString1, String aString2) {
        boolean found = false;
        ListModel model = lstInvitations.getModel();

        for (int i = 0; i < invitations.getSize(); i++) // Check if element already exists in jList.
        {

            System.out.println(model.getElementAt(i));
            if (model.getElementAt(i).equals(aString1)) {
                found = true;
            }

        }
        if (found == false) {
            invitations.addElement(aString1);
            txtEmail.setText("");
            arrayListAddedUsers.add(aString2);
            System.out.println(arrayListAddedUsers);

        } else {
            JOptionPane.showMessageDialog(null, "Participant already added..");
        }
    }

    private void noDuplicate(String aString1) {
        boolean found = false;
        ListModel model = lstInvitations.getModel();

        for (int i = 0; i < invitations.getSize(); i++) // Check if element already exists in jList.
        {

            System.out.println(model.getElementAt(i));
            if (model.getElementAt(i).equals(aString1)) {
                found = true;
            }

        }
        if (found == false) {
            invitations.addElement(aString1);
            txtEmail.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Participant already added..");
        }

    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed

        if (jCheckBox1.isSelected()) {

        }
        getText();
        getSubject();
        getSum();

        String subject = txtTitle.getText();
        String message = txtMessage.getText();
        String location = txtLocation.getText();
        String date = dp.getDateStringOrEmptyString();
        String time = tp.getText().toString();
        arrayListAddedUsers.add(User.getUser());

        try {
            String autoID;
            autoID = db.getDB().getAutoIncrement("MEETINGS", "MEETING_ID");
            if (autoID == null) {
                autoID = "1";
            }

            String q1 = "INSERT into meetings values('" + autoID + "', '" + subject + "', '" + message + "', '" + location + "', '" + date + "', '" + time + "', '" + user + "');";
            db.getDB().insert(q1);
            for (int i = 0; i < arrayListAddedUsers.size(); i++) {
                String q2 = "INSERT into meetingparticipants values('" + autoID + "', '" + arrayListAddedUsers.get(i) + "', false)";
                db.getDB().insert(q2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < lstInvitations.getModel().getSize(); i++) {
            String mailAdress = lstInvitations.getModel().getElementAt(i);

            try {

                //JavaMail.JavaMailUtil.sendMail(mailAdress);
            } catch (Exception ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String telefon = ";";

        try {
            telefon = db.getDB().fetchSingle("SELECT PHONE FROM USER_PROFILE WHERE PROFILE_ID = '" + user + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        NotificationHandler createNotification = new NotificationHandler("", "");
        String text = "Hello you have booked a meeting at: " + date + "\nTime: " + time + "\nThe location is: " + location + "\nThe subject is " + subject + "\nHave a good day!";
        //createNotification.sendSMS(text, "+46 " + telefon);
        System.out.println(text);
        System.out.println(telefon);

        invitations.removeAllElements();
        JOptionPane.showMessageDialog(null, "Meeting booked.");
        this.dispose();
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroupActionPerformed

        String cmbx = cmbGroup.getSelectedItem().toString();

        String q2 = "SELECT PROFILE_ID FROM USER_PROFILE where PROFILE_ID = (SELECT MEMBER FROM group_members WHERE research_group = (SELECT group_id from research_group where group_name='" + cmbx + "'));";

        String q1 = "SELECT EMAILADDRESS FROM USER_PROFILE where PROFILE_ID = (SELECT MEMBER FROM group_members WHERE research_group = (SELECT group_id from research_group where group_name='" + cmbx + "'));";

        try {

            lstInvitations.setModel(invitations);
            ArrayList<String> a2 = db.getDB().fetchColumn(q2);
            ArrayList<String> a1 = db.getDB().fetchColumn(q1);

            for (int i = 0; i < a1.size(); i++) {
                String a = a1.get(i).toString();
                String b = a2.get(i).toString();
                noDuplicateTwoValues(a, b);

            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_btnGroupActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        String summary = txtSummary.getText();
        String date = dp.getDateStringOrEmptyString();
        txtSummary.setText("Date: " + date + "\n" + summary);

    }//GEN-LAST:event_btnDateActionPerformed

    private void btnTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeActionPerformed
        String summary = txtSummary.getText();
        String time = tp.getText();
        txtSummary.setText("Time: " + time + "\n" + summary);

    }//GEN-LAST:event_btnTimeActionPerformed

    private void btnLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationActionPerformed
        String summary = txtSummary.getText();
        String loc = txtLocation.getText();
        txtSummary.setText("Location: " + loc + "\n" + summary);

    }//GEN-LAST:event_btnLocationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultListModel model = (DefaultListModel) lstInvitations.getModel();
        int selectedIndex = lstInvitations.getSelectedIndex();
        if (selectedIndex != -1) {
            String q1 = "SELECT PROFILE_ID FROM USER_PROFILE WHERE EMAILADDRESS = '" + lstInvitations.getSelectedValue() + "'";
            try {
                String a1 = db.getDB().fetchSingle(q1);
                for (int i = 0; i < arrayListAddedUsers.size(); i++) {
                    if (arrayListAddedUsers.get(i).equals(a1)) {
                        arrayListAddedUsers.remove(a1);
                    }

                }
                model.remove(selectedIndex);
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        lstInvitations.setModel(invitations);
        if (jCheckBox1.isSelected()) {
            cmbGroup.setEnabled(false);
            cmbMember.setEnabled(false);
            btnGroup.setEnabled(false);
            btnMember.setEnabled(false);
            txtEmail.setEditable(false);
            btnEmail.setEnabled(false);
            invitations.removeAllElements();
            arrayListAddedUsers.removeAll(arrayListAddedUsers);
            invitations.addElement("public");
            arrayListAddedUsers.add("public");
            System.out.println(arrayListAddedUsers);
            System.out.println("fel");
        } else {
            cmbGroup.setEnabled(true);
            cmbMember.setEnabled(true);
            btnGroup.setEnabled(true);
            btnMember.setEnabled(true);
            txtEmail.setEditable(true);
            btnEmail.setEnabled(true);
            invitations.removeAllElements();
            arrayListAddedUsers.removeAll(arrayListAddedUsers);
            System.out.println(arrayListAddedUsers);
            System.out.println("fel");

        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDate;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnGroup;
    private javax.swing.JButton btnLocation;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton btnTime;
    private javax.swing.JComboBox<String> cmbGroup;
    private javax.swing.JComboBox<String> cmbMember;
    private com.github.lgooddatepicker.components.DatePicker dp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGroup;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblTime;
    private javax.swing.JList<String> lstInvitations;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlPeople;
    private javax.swing.JPanel pnlSummary;
    private javax.swing.JScrollPane scrInvitations;
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
