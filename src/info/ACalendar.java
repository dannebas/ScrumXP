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
    private static ArrayList<String> meetingsArray;

    /**
     * Creates new form Calendar
     */
    public ACalendar() {
        initComponents();
        getDate();
        fillDates();
        calcNumber();
        setFirstDayOfMonth();
        setLabelCurrentDay();
        setLabelCurrentDate();
        setLabelCurrentMonth();
        setLabelCurrentYear();
        getMeetingsPerMonth();
        fillCalenderColors();
        setLabelCurrentUser();
    }

    private void fillCalenderColors() {
        jTable1.setDefaultRenderer(Object.class, new EntryCellRender());
        jTable1.repaint();
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

    private void getMeetingsPerMonth() {
        try {
            String q = "SELECT DATE FROM MEETINGS WHERE DATE LIKE '" + this.year + "-" + 0 + this.month + "-%'";
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

    private void setWeekNumber() {

        if (this.week == 4 && getWeekCal().get(Calendar.WEEK_OF_YEAR) == 6) {
            this.week = 5;
        } else {
            this.week = getWeekCal().get(Calendar.WEEK_OF_YEAR);
        }
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

    private void fillDates2() {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH)); //first day of the month
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        SimpleDateFormat format2 = new SimpleDateFormat("E"); // first day of month simplified
        Date date = cal.getTime();

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(date); // Dagens datum

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
        int daysMonth = theDate.lengthOfMonth(); // Dagar per månad
        int daysYear = theDate.lengthOfYear();// Dagar per år

//
//        LocalDate date2 = LocalDate.of(date1);
//        int days = date2.lengthOfMonth();
//        System.out.println(days);
    }

    private void calcNumber() {
        double ettTal = 2020;
        ettTal = ettTal / 4;
        if (ettTal % 1 != 0) {
//            System.out.println("TALET FUNKADE EJ");
        } else {
//            System.out.println("TALET FUNKADE");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
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
        panelPublic = new javax.swing.JPanel();
        labelCurrentDay1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        labelActivities1 = new javax.swing.JLabel();
        btnMonthUp1 = new javax.swing.JButton();
        btnMonthDown1 = new javax.swing.JButton();
        labelCurrentMonth1 = new javax.swing.JLabel();
        labelCurrentDate1 = new javax.swing.JLabel();
        labelCurrentYear1 = new javax.swing.JLabel();
        dpFrom1 = new com.github.lgooddatepicker.components.DatePicker();
        dpTo1 = new com.github.lgooddatepicker.components.DatePicker();
        btnFilter1 = new javax.swing.JButton();
        labelFrom1 = new javax.swing.JLabel();
        labelTo1 = new javax.swing.JLabel();
        labelUser1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelUser.setBackground(new java.awt.Color(255, 255, 255));
        panelUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelCurrentDay.setText("Current Day");
        labelCurrentDay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jScrollPane1.setHorizontalScrollBar(null);

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

        jScrollPane2.setViewportView(jList1);

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
                    .addComponent(jScrollPane2)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addComponent(jScrollPane1)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelPublic.setBackground(new java.awt.Color(255, 255, 255));
        panelPublic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPublic.setPreferredSize(new java.awt.Dimension(568, 619));

        labelCurrentDay1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCurrentDay1.setText("Current Day");

        jScrollPane3.setHorizontalScrollBar(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setRowHeight(30);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setShowGrid(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(7).setResizable(false);
        }

        jScrollPane4.setViewportView(jList2);

        labelActivities1.setText("Activities for the selected date:");

        btnMonthUp1.setText("Up");
        btnMonthUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthUp1ActionPerformed(evt);
            }
        });

        btnMonthDown1.setText("Down");
        btnMonthDown1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthDown1ActionPerformed(evt);
            }
        });

        labelCurrentMonth1.setText("Current Month");

        labelCurrentDate1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelCurrentDate1.setText("Current Date");

        labelCurrentYear1.setText("Current Year");

        btnFilter1.setText("Filter");
        btnFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilter1ActionPerformed(evt);
            }
        });

        labelFrom1.setText("From");

        labelTo1.setText("To");

        labelUser1.setText("Public Calender");

        javax.swing.GroupLayout panelPublicLayout = new javax.swing.GroupLayout(panelPublic);
        panelPublic.setLayout(panelPublicLayout);
        panelPublicLayout.setHorizontalGroup(
            panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPublicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(labelActivities1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPublicLayout.createSequentialGroup()
                        .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFrom1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTo1)
                            .addComponent(dpTo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFilter1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPublicLayout.createSequentialGroup()
                        .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPublicLayout.createSequentialGroup()
                                .addComponent(labelCurrentDay1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCurrentDate1))
                            .addGroup(panelPublicLayout.createSequentialGroup()
                                .addComponent(labelCurrentMonth1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCurrentYear1))
                            .addComponent(labelUser1))
                        .addGap(196, 196, 196)
                        .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMonthUp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMonthDown1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelPublicLayout.setVerticalGroup(
            panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPublicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPublicLayout.createSequentialGroup()
                        .addComponent(labelUser1)
                        .addGap(2, 2, 2)
                        .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCurrentDay1)
                            .addComponent(labelCurrentDate1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCurrentMonth1)
                            .addComponent(labelCurrentYear1))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPublicLayout.createSequentialGroup()
                        .addComponent(btnMonthUp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMonthDown1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTo1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelFrom1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPublicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpTo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelActivities1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPublic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMonthUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthUpActionPerformed
        if (this.month == 1) {
            meetingsArray.clear();
            month = 12;
            year--;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            getMeetingsPerMonth();
            fillCalenderColors();
        } else {
            meetingsArray.clear();
            this.month = this.month - 1;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            getMeetingsPerMonth();
            fillCalenderColors();
        }
    }//GEN-LAST:event_btnMonthUpActionPerformed

    private void btnMonthDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthDownActionPerformed
        if (this.month == 12) {
            meetingsArray.clear();
            month = 1;
            year++;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            getMeetingsPerMonth();
            fillCalenderColors();
        } else {
            meetingsArray.clear();
            this.month = this.month + 1;
            setFirstDayOfMonth();
            setDaysInMonth();
            setWeekNumber();
            fillDates();
            setLabelCurrentMonth();
            setLabelCurrentYear();
            getMeetingsPerMonth();
            fillCalenderColors();
        }
    }//GEN-LAST:event_btnMonthDownActionPerformed

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        fillList();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (Validation.checkDatePickerEmpty(dpFrom, dpTo)) {
            try {
                String fromDate = dpFrom.getDateStringOrEmptyString();
                String toDate = dpTo.getDateStringOrEmptyString();

                String q = "SELECT DESCRIPTION, TITLE, DATE, LOCATION, TIME FROM MEETINGS WHERE DATE BETWEEN " + "'" + fromDate + "'" + " AND " + "'" + toDate + "'" + " ORDER BY DATE";
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

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnMonthUp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthUp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMonthUp1ActionPerformed

    private void btnMonthDown1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthDown1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMonthDown1ActionPerformed

    private void btnFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFilter1ActionPerformed

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
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnFilter1;
    private javax.swing.JButton btnMonthDown;
    private javax.swing.JButton btnMonthDown1;
    private javax.swing.JButton btnMonthUp;
    private javax.swing.JButton btnMonthUp1;
    private com.github.lgooddatepicker.components.DatePicker dpFrom;
    private com.github.lgooddatepicker.components.DatePicker dpFrom1;
    private com.github.lgooddatepicker.components.DatePicker dpTo;
    private com.github.lgooddatepicker.components.DatePicker dpTo1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelActivities;
    private javax.swing.JLabel labelActivities1;
    private javax.swing.JLabel labelCurrentDate;
    private javax.swing.JLabel labelCurrentDate1;
    private javax.swing.JLabel labelCurrentDay;
    private javax.swing.JLabel labelCurrentDay1;
    private javax.swing.JLabel labelCurrentMonth;
    private javax.swing.JLabel labelCurrentMonth1;
    private javax.swing.JLabel labelCurrentYear;
    private javax.swing.JLabel labelCurrentYear1;
    private javax.swing.JLabel labelFrom;
    private javax.swing.JLabel labelFrom1;
    private javax.swing.JLabel labelTo;
    private javax.swing.JLabel labelTo1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelUser1;
    private javax.swing.JPanel panelPublic;
    private javax.swing.JPanel panelUser;
    // End of variables declaration//GEN-END:variables
}
