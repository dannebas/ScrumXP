/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class Validation {

    public static boolean checkTextFieldEmpty(JTextField tf) {
        boolean answer = true;

        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "A field is empty.");
            tf.requestFocusInWindow();
            answer = false;
        }
        return answer;
    }

    public static boolean checkPassword(JPasswordField tf) {
        boolean answer = true;

        if (tf.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please enter a password.");
            tf.requestFocusInWindow();
            answer = false;
        }
        return answer;
    }

    public static boolean checkDatePickerEmpty(DatePicker... args) {
        boolean answer = true;

        for (DatePicker arg : args) {
            if (arg.getDateStringOrEmptyString().equals("")) {
                arg.requestFocusInWindow();
                answer = false;
            }
        }
        if (!answer) {
            JOptionPane.showMessageDialog(null, "Please fill out a date.");
        }
        return answer;
    }

    public static boolean checkLogOut() {
        boolean answer = false;
        String[] opt = {"Yes", "No"};       //används för att kunna skriva egna alternativ på svenska.
        int n = JOptionPane.showOptionDialog(null,
                "Are you sure you want to log out?",
                "Log out",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opt, opt[0]);
        if (n == JOptionPane.YES_OPTION) {
            answer = true;
        } else if (n == JOptionPane.NO_OPTION) {
            answer = false;
        }
        return answer;
    }

    public static boolean checkDelete() {
        boolean answer = false;
        String[] opt = {"Ja", "Nej"};
        int n = JOptionPane.showOptionDialog(null,
                "Are you sure you want to delete?",
                "Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opt, opt[0]);
        if (n == JOptionPane.YES_OPTION) {
            answer = true;
        } else if (n == JOptionPane.NO_OPTION) {
            answer = false;
        }
        return answer;
    }

}
