/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lukas
 */
public class CalendarPrivate extends javax.swing.JFrame {

    private int year;
    private int month;
    private int week;
    private int date;
    private String day;
    private int dayOfWeek;
    private int firstDayOfMonth;
    private int daysInMonth;
    private static ArrayList<String> meetingsArray;

    /**
     * Creates new form Calendar
     */
    public CalendarPrivate() {
        emptyArrayListIfNotEmpty();
        initComponents();
        getDate();
        fillDates();
        runAllSetters();
        getMeetingsPerMonth();
        fillCalenderColors();
    }

    private void fillCalenderColors() {
        jTable1.setDefaultRenderer(Object.class, new EntryCellRenderPrivate());
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

    private void getMeetingsPerMonth() {
        try {
            String q = "SELECT DATE FROM MEETINGS WHERE DATE LIKE '" + this.year + "-" + 0 + this.month + "-%' AND USER = '" + User.getUser() + "'";
            System.out.println(q);
            ArrayList<String> lista = new ArrayList<>();
            lista = db.getDB().fetchColumn(q);

            ArrayList<String> meetings = new ArrayList<>();
            for (String list : lista) {
                list = list.substring(8, 10);
                if (list.startsWith("0")) {
                    list = list.substring(1);
                    System.out.println(list);
                }
                meetings.add(list);
            }
            this.meetingsArray = meetings;
            System.out.println(this.meetingsArray);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NullPointerException ex) {
            System.out.println("No meetings for this month.");
        }
    }

    static ArrayList<String> getMeetingsArray() {
        return meetingsArray;
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
        this.firstDayOfMonth = getNumberDay(date11);

        setDaysInMonth();
        setWeekNumber();
    }

    private Calendar getWeekCal() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, this.month - 1);
        cal.set(Calendar.YEAR, this.year);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal;
    }

    //All Setters
    private void runAllSetters() {
        setFirstDayOfMonth();
        setLabelCurrentUser();
        setLabelCurrentDate();
        setLabelCurrentDay();
        setLabelCurrentMonth();
        setLabelCurrentYear();
    }

    private void setWeekNumber() {
        if (this.week == 4 && getWeekCal().get(Calendar.WEEK_OF_YEAR) == 6) {
            this.week = 5;
        } else {
            this.week = getWeekCal().get(Calendar.WEEK_OF_YEAR);
        }
    }

    private void setDaysInMonth() {
        //Days in month
        YearMonth yearMonthObject = YearMonth.of(this.year, this.month);
        this.daysInMonth = yearMonthObject.lengthOfMonth();
    }

    private void setFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, this.month - 1);
        cal.set(Calendar.YEAR, this.year);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        String firstDay = cal.getTime().toString().substring(0, 4);
        this.firstDayOfMonth = getNumberDay(firstDay);
    }

    private void setLabelCurrentDay() {
        String curDate = new Date().toString().substring(0, 3);
        System.out.println(curDate);
        switch (curDate) {
            case "Mon":
                curDate = "Monday,";
                break;
            case "Tue":
                curDate = "Tuesday,";
                break;
            case "Wed":
                curDate = "Wednesday,";
                break;
            case "Thu":
                curDate = "Thursday,";
                break;
            case "Fri":
                curDate = "Friday,";
                break;
            case "Sat ":
                curDate = "Saturday,";
                break;
            case "Sun":
                curDate = "Sunday,";
                break;
        }
        labelCurrentDay.setText(curDate);
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

    private void setLabelCurrentUser() {
        labelUser.setText(User.getName());
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
            if (this.week == 53) {
                double aYear = this.year;
                aYear = aYear / 4;
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
            String[] array = arrayen.split(",");
            model.addRow(array);
        }
    }

    private void fillList() {
        //Check if column is not the Week column
        if (jTable1.getSelectedColumn() != 0) {
            try {
                DefaultListModel<String> model = new DefaultListModel<>();
                jList1.setModel(model);
                String aMonth = Integer.toString(this.month);
                if (this.month < 10) {
                    aMonth = "0" + aMonth;
                }
                String aDay = fillMeetings();
                if (Integer.parseInt(aDay) < 10) {
                    aDay = "0" + aDay;
                }
                String aYear = Integer.toString(this.year);
                String aDate = aYear + '-' + aMonth + "-" + aDay;
                String q = "SELECT DESCRIPTION, TITLE, LOCATION, TIME FROM MEETINGS WHERE DATE = '" + aDate + "' AND USER = '" + User.getUser() + "'";
                System.out.println(q);
                ArrayList<HashMap<String, String>> lista = new ArrayList<>();
                lista = db.getDB().fetchRows(q);

                for (HashMap<String, String> theList : lista) {
                    String description = "";
                    String title = "";
                    String location = "";
                    String time = "";

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

            } catch (SQLException ex) {
                System.err.println(ex);

            } catch (NullPointerException ex) {
//                System.err.println(ex);
                System.out.println("No meeting this day.");
            } catch (NumberFormatException ex) {
                System.err.println(ex);
                System.out.println("Unvalid cell.");
            }
        }
    }

    private String fillMeetings() {
        int rowIndex = jTable1.getSelectedRow();
        int columnIndex = jTable1.getSelectedColumn();
        Object index = jTable1.getModel().getValueAt(rowIndex, columnIndex);
        return index.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUser = new javax.swing.JPanel();
        labelCurrentDay = new javax.swing.JLabel();
        scrollPaneTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        scrollPaneText = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        labelActivities = new javax.swing.JLabel();
        btnMonthUp = new javax.swing.JButton();
        btnMonthDown = new javax.swing.JButton();
        labelCurrentMonth = new javax.swing.JLabel();
        labelCurrentDate = new javax.swing.JLabel();
        labelCurrentYear = new javax.swing.JLabel();
        dpFrom = new com.github.lgooddatepicker.components.DatePicker();
        dpTo = new com.github.lgooddatepicker.components.DatePicker();
        btnFilter = new javax.swing.JButton();
        labelFrom = new javax.swing.JLabel();
        labelTo = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelUser.setBackground(new java.awt.Color(255, 255, 255));
        panelUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelCurrentDay.setText("Current Day");
        labelCurrentDay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        scrollPaneTable.setHorizontalScrollBar(null);

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
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setRowHeight(30);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        scrollPaneTable.setViewportView(jTable1);
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

        scrollPaneText.setViewportView(jList1);

        labelActivities.setText("Activities for the selected date:");

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

        labelCurrentDate.setText("Current Date");
        labelCurrentDate.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        labelCurrentYear.setText("Current Year");

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        labelFrom.setText("From");

        labelTo.setText("To");

        labelUser.setText("User");

        javax.swing.GroupLayout panelUserLayout = new javax.swing.GroupLayout(panelUser);
        panelUser.setLayout(panelUserLayout);
        panelUserLayout.setHorizontalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPaneText)
                    .addComponent(labelActivities, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelUserLayout.createSequentialGroup()
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFrom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTo)
                            .addComponent(dpTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFilter, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelUserLayout.createSequentialGroup()
                                .addComponent(labelCurrentDay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCurrentDate))
                            .addGroup(panelUserLayout.createSequentialGroup()
                                .addComponent(labelCurrentMonth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCurrentYear))
                            .addComponent(labelUser))
                        .addGap(196, 196, 196)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMonthUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMonthDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollPaneTable))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelUserLayout.setVerticalGroup(
            panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUserLayout.createSequentialGroup()
                        .addComponent(labelUser)
                        .addGap(2, 2, 2)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCurrentDay)
                            .addComponent(labelCurrentDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCurrentMonth)
                            .addComponent(labelCurrentYear))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserLayout.createSequentialGroup()
                        .addComponent(btnMonthUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMonthDown)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelFrom, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelActivities)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneText, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emptyArrayListIfNotEmpty() {
        if (meetingsArray == null || meetingsArray.isEmpty()) {
            //
        } else {
            meetingsArray.removeAll(meetingsArray);
        }
    }
    private void btnMonthUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthUpActionPerformed
        if (this.month == 1) {
            emptyArrayListIfNotEmpty();
            month = 12;
            year--;
            runAllSetters();
            fillDates();
            getMeetingsPerMonth();
            fillCalenderColors();
        } else {
            emptyArrayListIfNotEmpty();
            month--;
            runAllSetters();
            fillDates();
            getMeetingsPerMonth();
            fillCalenderColors();
        }
    }//GEN-LAST:event_btnMonthUpActionPerformed

    private void btnMonthDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthDownActionPerformed
        if (this.month == 12) {
            emptyArrayListIfNotEmpty();
            month = 1;
            year++;
            runAllSetters();
            fillDates();
            getMeetingsPerMonth();
            fillCalenderColors();
        } else {
            emptyArrayListIfNotEmpty();
            month++;
            runAllSetters();
            fillDates();
            getMeetingsPerMonth();
            fillCalenderColors();
        }
    }//GEN-LAST:event_btnMonthDownActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fillList();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (Validation.checkDatePickerEmpty(dpFrom, dpTo)) {
            try {
                String fromDate = dpFrom.getDateStringOrEmptyString();
                String toDate = dpTo.getDateStringOrEmptyString();

                String q = "SELECT DESCRIPTION, TITLE, DATE, LOCATION, TIME FROM MEETINGS WHERE USER = '" + User.getUser() + "' AND DATE BETWEEN " + "'" + fromDate + "'" + " AND " + "'" + toDate + "'" + " ORDER BY DATE";
                System.out.println(q);

                DefaultListModel<String> model = new DefaultListModel<>();
                jList1.setModel(model);
                ArrayList<HashMap<String, String>> lista = new ArrayList<>();
                lista = db.getDB().fetchRows(q);

                for (HashMap<String, String> theList : lista) {
                    String description = "";
                    String title = "";
                    String date = "";
                    String location = "";
                    String time = "";

                    for (String key : theList.keySet()) {
                        if (key.contains("TITLE")) {
                            title = title + key + ": " + theList.get(key);
                        } else if (key.contains("TIME")) {
                            time = time + key + ": " + theList.get(key);
                        } else if (key.contains("DESCRIPTION")) {
                            description = description + key + ": " + theList.get(key);
                        } else if (key.contains("LOCATION")) {
                            location = location + key + ": " + theList.get(key);
                        } else if (key.contains("DATE")) {
                            location = date + key + ": " + theList.get(key);
                        }
                    }
                    model.addElement(title);
                    model.addElement(description);
                    model.addElement(time);
                    model.addElement(location);
                    model.addElement(date);
                    model.addElement("--------------------------------------------------------------------------------------");
                }
                model.addElement("");

            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnMonthDown;
    private javax.swing.JButton btnMonthUp;
    private com.github.lgooddatepicker.components.DatePicker dpFrom;
    private com.github.lgooddatepicker.components.DatePicker dpTo;
    private javax.swing.JList<String> jList1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelActivities;
    private javax.swing.JLabel labelCurrentDate;
    private javax.swing.JLabel labelCurrentDay;
    private javax.swing.JLabel labelCurrentMonth;
    private javax.swing.JLabel labelCurrentYear;
    private javax.swing.JLabel labelFrom;
    private javax.swing.JLabel labelTo;
    private javax.swing.JLabel labelUser;
    private javax.swing.JPanel panelUser;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JScrollPane scrollPaneText;
    // End of variables declaration//GEN-END:variables
}
