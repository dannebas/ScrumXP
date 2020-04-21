/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lukas
 */
public class ACalendar extends javax.swing.JFrame {

    private int year;
    private int month;
    private int week;
    private int date;
    private String day;
    private int dayOfWeek;
    private int firstDayOfMonth;
    private int daysInMonth;
    private int disabled_col = 2, cur_col = 0;

    /**
     * Creates new form Calendar
     */
    public ACalendar() {
        initComponents();
        getDate();
        fillDates(); //39
        setFirstDayOfMonth();
        //setWeekNumber(); //42
        raknaTalet();
        setLabelCurrentDay();
        setLabelCurrentDate();
        setLabelCurrentMonth();
        setLabelCurrentYear();
    }

    public int getWeek() {
        return week;
    }

    private int getNumberDay(String aString) {

        int theNumber = 0;
        switch (aString) {
            case "Mon ":
                //this.dayOfWeek = 1;
                theNumber = 1;
                break;
            case "Tue ":
                //this.dayOfWeek = 2;
                theNumber = 2;
                break;
            case "Wed ":
                //this.dayOfWeek = 3;
                theNumber = 3;
                break;
            case "Thu ":
                //this.dayOfWeek = 4;
                theNumber = 4;
                break;
            case "Fri ":
                //this.dayOfWeek = 5;
                theNumber = 5;
                break;
            case "Sat ":
                //this.dayOfWeek = 6;
                theNumber = 6;
                break;
            case "Sun ":
                //this.dayOfWeek = 7;
                theNumber = 7;
                break;
        }
        System.out.println("NUMRET ÄR " + theNumber);
        return theNumber;
    }

    private void setLabelCurrentDay() {
        String date = new Date().toString().substring(0, 3);
        System.out.println(date);
        switch (date) {
            case "Mon":
                date = "Monday,";
                break;
            case "Tue":
                date = "Tuesday,";
                break;
            case "Wed":
                date = "Wednesday,";
                break;
            case "Thu":
                date = "Thursday,";
                break;
            case "Fri":
                date = "Friday,";
                break;
            case "Sat ":
                date = "Saturday,";
                break;
            case "Sun":
                date = "Sunday,";
                break;
        }
        labelCurrentDay.setText(date);
    }

    private void setLabelCurrentDate() {
        String labeldate = new Date().toString().substring(4, 10);
        labelCurrentDate.setText(labeldate);
    }

    private void setLabelCurrentMonth() {
        int currentMonth = this.month;
        String monthName = "";
        switch (currentMonth) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "Mars";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        labelCurrentMonth.setText(monthName);
    }

    private void setLabelCurrentYear() {
        labelCurrentYear.setText(Integer.toString(this.year));
    }

    private void getDate() {
        Date dNow = new Date();

        //Date
        SimpleDateFormat date = new SimpleDateFormat("d");
        this.date = Integer.parseInt(date.format(dNow));

        //Day
        SimpleDateFormat day = new SimpleDateFormat("E");
        this.day = (day.format(dNow));
        this.dayOfWeek = getNumberDay(this.day);

//        //Week
//        SimpleDateFormat week = new SimpleDateFormat("w");
//        this.week = Integer.parseInt(week.format(dNow));
        //Month
        SimpleDateFormat month = new SimpleDateFormat("M");
        this.month = Integer.parseInt(month.format(dNow));

        //Year
        SimpleDateFormat year = new SimpleDateFormat("y");
        this.year = Integer.parseInt(year.format(dNow));

        //Get first day of month
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        String date11 = cal.getTime().toString().substring(0, 4);
        System.out.println("DATE11 ÄR " + date11);
        this.firstDayOfMonth = getNumberDay(date11);
        System.out.println("FIRSTDAYOFMONTH ÄR " + this.firstDayOfMonth);

        setDaysInMonth();
        setWeekNumber();
    }

    private Calendar getWeekCal() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, this.month - 1);
        cal.set(Calendar.YEAR, this.year);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR) + "THISMONTHHHHH");
        return cal;
    }

    private void setWeekNumber() {
        System.out.println("THIS WEEK IS" + this.week);
        /*if(((getWeekCal().get(Calendar.WEEK_OF_YEAR))- this.week)  != 0 && this.week < 52 )
        {
            this.week = this.week + 1;
        }*/
        if (this.week == 4 && getWeekCal().get(Calendar.WEEK_OF_YEAR) == 6) {
            this.week = 5;
        } else {
            this.week = getWeekCal().get(Calendar.WEEK_OF_YEAR);
        }
        System.out.println("BUT THIS WEEK IS" + this.week);

        /*if (((getWeekCal().get(Calendar.WEEK_OF_YEAR)) - this.week) != 1 && this.week != 53) {
            this.week = this.week + 1;
        } else {
            System.out.println(cal.getTime() + " : xdveckonummer");
            this.week = cal.get(Calendar.WEEK_OF_YEAR);
            System.out.println(week + " : veckonummer");
        }*/
        //System.out.println(cal.getTime() + " : xdveckonummer");
        //this.week = cal.get(Calendar.WEEK_OF_YEAR);
        //System.out.println(week + " : veckonummer");
    }

    private void setWeek(int week) {

    }

    private void setFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, this.month - 1);
        cal.set(Calendar.YEAR, this.year);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        String firstDay = cal.getTime().toString().substring(0, 4);
        this.firstDayOfMonth = getNumberDay(firstDay);
    }

    private void setDaysInMonth() {
        //Days in month
        YearMonth yearMonthObject = YearMonth.of(this.year, this.month);
        this.daysInMonth = yearMonthObject.lengthOfMonth();
    }

    private void fillDates() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int counter2 = 0;
        int y = 1;
        int w = 0;
        int rowCount = 5;
        int checker = 0;
        if (this.firstDayOfMonth == 7 || (this.firstDayOfMonth == 6 && this.daysInMonth == 31)) {
            rowCount = 6;
        } else if (this.month == 2 && this.firstDayOfMonth == 1) {
            rowCount = 4;
        }

        for (int i = 0; i < rowCount; i++) {
            this.week = this.week + w;
            System.out.println(this.week + "DENNAVECKAN");
            if (this.week == 53) {
                System.out.println(this.year);
                double aYear = this.year;
                aYear = aYear / 4;
                System.out.println(aYear + "AWEEK");
                if (aYear % 1 != 0) {
                    this.week = 1;
                }
            }
            if (this.week == 1 && checker < 1) {
                double aYear = this.year - 1;
                aYear = aYear / 4;
                if (aYear % 1 == 0) {
                    this.week = 53;
                    checker++;
                }
            }
            if (this.week == 54) {
                this.week = 1;
            }

            Integer weeknumber = getWeek();
            String arrayen = weeknumber.toString();
            int z = y;
            int counter = -1;
            if (w < 1) {
                w++;
            }
            for (int x = y; x < (8 + y); x++) {
                if (x <= (this.firstDayOfMonth - 1) && counter2 < 1) {
                    arrayen = arrayen + " ,";
                    continue;
                }
                counter++;
                arrayen = arrayen + "," + z;
//                System.out.println(arrayen);
//                System.out.println(x + " är mindre än " + this.firstDayOfMonth);
                if (x == this.daysInMonth) {
                    break;
                }
                z++;
                /*
                TANKAR TILL MIG SJÄLV INFÖR MÅNDAG: Använd firstDayOfMonth för att försöka få
                in arrayen till att hoppa över de dagar som finns innan t.ex. Wed(Mån, Tis) så
                så att den börjar på iteration 3 i forloopen.
                 */
            }
            counter2++;
            y = y + counter;
//            System.out.println("Y är " + y);
            String[] array = arrayen.split(",");
//            System.out.println(arrayen);
            model.addRow(array);
            System.out.println(this.week + "WTF");
        }
    }

    private void fillDates2() {
        Calendar cal = Calendar.getInstance();

        //Date date = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH)); //first day of the month
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println(week);
        SimpleDateFormat format2 = new SimpleDateFormat("E"); // first day of month simplified
        System.out.println(format2.format(cal.getTime()));
        System.out.println(cal.getTime());
        Date date = cal.getTime();
        //cal.set(Calendar.DAY_OF_MONTH, cal.getWeekYear());

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(date); // Dagens datum

        System.out.println("Dages Datum: " + date1);
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate dt = dtf.parseLocalDate(date1);
        Locale locale = new Locale("en", "UK");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(locale);
        //formatter = formatter.with// Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        /*for (int i = 1; i <= 12; i++) {
            String ettDatum = "";
            if (i < 10) {
                ettDatum = "2020-0" + i + "-01";
            } else {
                ettDatum = "2020-" + i + "-01";
            }
            LocalDate theDate = LocalDate.parse(ettDatum, formatter);
            System.out.println(theDate);
            //theDate.
            int daysMonth = theDate.lengthOfMonth();
            int daysYear = theDate.lengthOfYear();
            System.out.println(daysYear);
            System.out.println(daysMonth);
        }*/
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(5);
        model.addColumn(locale);

        System.out.println(date1);
        LocalDate theDate = LocalDate.parse(date1, formatter);
        System.out.println("KASDKAKSD " + theDate.getMonthValue() + " " + theDate.getYear());
        System.out.println(theDate);
        int daysMonth = theDate.lengthOfMonth(); // Dagar per månad
        int daysYear = theDate.lengthOfYear();// Dagar per år

        //System.out.println(daysYear);
        //System.out.println(daysMonth);
//
//        LocalDate date2 = LocalDate.of(date1);
//        int days = date2.lengthOfMonth();
//        System.out.println(days);
    }

    private void raknaTalet() {
        double ettTal = 2020;
        ettTal = ettTal / 4;
        if (ettTal % 1 != 0) {
            System.out.println("TALET FUNKADE EJ");
        } else {
            System.out.println("TALET FUNKADE");
        }
    }

    private String fillMeetings() {

        int rowIndex = jTable1.getSelectedRow();
        int columnIndex = jTable1.getSelectedColumn();
        Object index = jTable1.getModel().getValueAt(rowIndex, columnIndex);
        return index.toString();

        //System.out.println(target.getModel().getValueAt(rowIndex, columnIndex));
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
        labelCurrentDay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnMonthUp = new javax.swing.JButton();
        btnMonthDown = new javax.swing.JButton();
        labelCurrentMonth = new javax.swing.JLabel();
        labelCurrentDate = new javax.swing.JLabel();
        labelCurrentYear = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelCurrentDay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCurrentDay.setText("Current Day");

        jScrollPane1.setHorizontalScrollBar(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, "", null},
                {null, null, null, "", null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Week", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Aktiviteter för datumet:");

        btnMonthUp.setText("Up");
        btnMonthUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthUpActionPerformed(evt);
            }
        });

        btnMonthDown.setText("Down");
        btnMonthDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthDownActionPerformed(evt);
            }
        });

        labelCurrentMonth.setText("Current Month");

        labelCurrentDate.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCurrentDate.setText("Current Date");

        labelCurrentYear.setText("Current Year");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCurrentDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCurrentDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMonthUp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelCurrentMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCurrentYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMonthDown)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMonthUp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCurrentDay)
                        .addComponent(labelCurrentDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMonthDown)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCurrentMonth)
                        .addComponent(labelCurrentYear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMonthUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthUpActionPerformed
        if (this.month == 1) {
            month = 12;
            year--;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            System.out.println(month + " CURRENT MONTH");
            System.out.println(year + " CURRENT YEAR");
        } else {
            this.month = this.month - 1;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            System.out.println(month + " CURRENT MONTH");
            System.out.println(year + " CURRENT YEAR");
        }
    }//GEN-LAST:event_btnMonthUpActionPerformed

    private void btnMonthDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthDownActionPerformed
        if (this.month == 12) {
            month = 1;
            year++;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            System.out.println(month + " CURRENT MONTH");
            System.out.println(year + " CURRENT YEAR");
        } else {
            this.month = this.month + 1;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            System.out.println(month + " CURRENT MONTH");
            System.out.println(year + " CURRENT YEAR");
        }
    }//GEN-LAST:event_btnMonthDownActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillMeetings();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fillList() {
        //Check if column is not the Week column
        if (jTable1.getSelectedColumn() != 0) {
            try {
                DefaultListModel<String> model = new DefaultListModel<>();
                jList1.setModel(model);
                String aMonth = Integer.toString(this.month);
                if (this.month <= 9) {
                    aMonth = "0" + aMonth;
                }
                String aYear = Integer.toString(this.year);
                String aDate = aYear + '-' + aMonth + "-" + fillMeetings();
                String q = "SELECT DESCRIPTION, TITLE, LOCATION, TIME FROM MEETINGS WHERE DATE = '" + aDate + "' AND USER = '" + "tms'";
                System.out.println(q);
                ArrayList<HashMap<String, String>> lista = new ArrayList<>();
                lista = db.getDB().fetchRows(q);

                for (HashMap<String, String> theList : lista) {
                    String title = "";
                    String time = "";
                    String description = "";
                    String location = "";

                    System.out.println(theList);
                    for (String key : theList.keySet()) {
                        if (key.contains("TITLE")) {
                            title = title + key + ": " + theList.get(key);
                        } else if (key.contains("TIME")) {
                            time = time + key + ": " + theList.get(key);
                        } else if (key.contains("DESCRIPTION")) {
                            description = description + key + ": " + theList.get(key);
                        } else if (key.contains("LOCATION")) {
                            location = location + key + ": " + theList.get(key);
                        }
                    }
                    model.addElement(title);
                    model.addElement(description);
                    model.addElement(time);
                    model.addElement(location);
                    model.addElement("--------------------------------------------------------------------------------------");
                }
                model.addElement("");
                //for (String key : lista.keySet()) {
                // System.out.println(key);

            } catch (SQLException ex) {
                System.err.println(ex);
            }
            //jList1.add(q, this);
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fillList();
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ACalendar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ACalendar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ACalendar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ACalendar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ACalendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMonthDown;
    private javax.swing.JButton btnMonthUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCurrentDate;
    private javax.swing.JLabel labelCurrentDay;
    private javax.swing.JLabel labelCurrentMonth;
    private javax.swing.JLabel labelCurrentYear;
    // End of variables declaration//GEN-END:variables
}
