/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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

    /**
     * Creates new form Calendar
     */
    public ACalendar() {
        initComponents();
        getDate();
        //fillDates();
        fillDates2();
        System.out.println(dayOfWeek);

    }

    public int getWeek() {
        return week;
    }

    private void setCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(cal.getTime()));
        for (int i = 1; i < maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, i + 1);
            System.out.println(", " + df.format(cal.getTime()));
        }
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
                System.out.println("RÄTT");
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

    private void getDate() {
        Date dNow = new Date();

        //Date
        SimpleDateFormat date = new SimpleDateFormat("d");
        this.date = Integer.parseInt(date.format(dNow));
        System.out.println(date.format(dNow));

        //Day
        SimpleDateFormat day = new SimpleDateFormat("E");
        labelDay.setText(day.format(dNow));
        this.day = (day.format(dNow));
        System.out.println(day.format(dNow));

        /*switch (this.day) {
            case "Mon":
                this.dayOfWeek = 1;
                break;
            case "Tue":
                this.dayOfWeek = 2;
                break;
            case "Wed":
                this.dayOfWeek = 3;
                break;
            case "Thu":
                this.dayOfWeek = 4;
                break;
            case "Fri":
                this.dayOfWeek = 5;
                break;
            case "Sat":
                this.dayOfWeek = 6;
                break;
            case "Sun":
                this.dayOfWeek = 7;
                break;
        }


         */
        this.dayOfWeek = getNumberDay(this.day);

        SimpleDateFormat week = new SimpleDateFormat("w");
        this.week = Integer.parseInt(week.format(dNow));
        System.out.println(week.format(dNow));

        //Month
        SimpleDateFormat month = new SimpleDateFormat("M");
        labelMonth.setText(month.format(dNow));
        this.month = Integer.parseInt(month.format(dNow));
        System.out.println("Månad " + month.format(dNow));

        //Year
        SimpleDateFormat year = new SimpleDateFormat("y");
        jLabel1.setText(year.format(dNow));
        this.year = Integer.parseInt(year.format(dNow));
        System.out.println(year.format(dNow));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date date10 = cal.getTime();
        String date11 = date10.toString().substring(0, 4);
        System.out.println("DATE11 ÄR " + date11);
        this.firstDayOfMonth = getNumberDay(date11);
        System.out.println("FIRSTDAYOFMONTH ÄR " + this.firstDayOfMonth);

        //Days in month
        YearMonth yearMonthObject = YearMonth.of(this.year, this.month);
        this.daysInMonth = yearMonthObject.lengthOfMonth();

    }

    private void fillDates2() {
        //YearMonth yearMonthObject = YearMonth.of(this.year, this.month);
        //int daysInMonth = yearMonthObject.lengthOfMonth();
        //System.out.println(daysInMonth);

        //Calendar cal = Calendar.getInstance();
        //cal.set(Calendar.WEEK_OF_YEAR, this.month);
        //System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
        //System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        //System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        //System.out.println((cal.get(Calendar.DAY_OF_YEAR)) / (cal.get(Calendar.DAY_OF_WEEK)));
        //System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
        //System.out.println("Week in Year: " + c.get(Calendar.WEEK_OF_YEAR));
        //Integer[][] rowData = {};
        //String[] columnNames = {"Week", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        //Object[][] data = /*new Object[][]*/ {
        //          {1, 1, 2, 3, 4, 5, 6, 7},
        //        {2, 8, 9, 10, 11, 12, 13, 14},
        //      {3, 15, 16, 17, 18, 19, 20, 21},
        //    {4, 22, 23, 24, 25, 26, 27, 28},
        //  {5, 29, 30, 31},};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int w = 0;
        int y = 1;
        for (int i = 0; i < 5/*daysInMonth + 1*/; i++) {
            //Integer[] array = {};
            Integer weeknumber = getWeek() + i;
            String arrayen = weeknumber.toString();
            int z = y;
            int counter = -1;
            for (int x = y; x < (8 + y); x++) {
                //int z = x;
                if (x <= (this.firstDayOfMonth - 1)) {
                    arrayen = arrayen + " ,";
                    //z--;
                    continue;
                }
                counter++;
                arrayen = arrayen + "," + z;
                //Arrays.fill(arrayen, x);
                System.out.println(arrayen);
                System.out.println(x + " är mindre än " + this.firstDayOfMonth);
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
            y = y + counter;
            System.out.println("Y är " + y);
            //Arrays.fill(array, arrayen
            String[] array = arrayen.split(",");
            System.out.println(arrayen);
            model.addRow(array);
            //String[] array = {arrayen.split(" ")};
            //Integer[] array = {Integer.parseInt(arrayen)};
            //System.out.println(array);
            //model.addRow(array);
            /*int p = 1;
            if (i == 1 || i == 8 || i == 15 || i == 22) {
                Integer[] array2 = {this.week};
            } else {
                Integer[] array = {this.week + w, i, i + 1, i + 2, i + 3, i + 4, i + 5, i + 6};
            Arrays.fill(array2, this.week, 1,2);
            model.addRow(array);

            w++;*/

        }
        //Integer[] array = {this.week, 1, 2, 3, 4, 5, 6, 7};     x
        //model.addRow(array);
        //model.addRow(new Object[]{"Hej"});

        /*for (int i = 1;
                i < daysInMonth;                                s
                i++) {
            model.addRow(rowData);
        /* }

        /*
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(date);
        Locale locale = new Locale("en", "UK");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(locale);
        LocalDate theDate = LocalDate.parse(date1, formatter);
        int daysMonth = theDate.lengthOfMonth();
         */
    }

    private void fillDates() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelMonth = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelMonth.setText("Månad");

        labelDay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDay.setText("Dag");

        jScrollPane1.setHorizontalScrollBar(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, "", null},
                {null, null, null, "", null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Vecka", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setText("jButton1");

        jLabel3.setText("Aktiviteter för datumet:");

        jLabel1.setText("Year");

        jButton2.setText("Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Down");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDay)
                            .addComponent(labelMonth)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(labelDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMonth)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.month = this.month + 1;
        fillDates2();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelMonth;
    // End of variables declaration//GEN-END:variables
}
