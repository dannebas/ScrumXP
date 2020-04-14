/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

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
            JOptionPane.showMessageDialog(null, "Please enter a password");
            tf.requestFocusInWindow();
            answer = false;
        }
        return answer;
    }

   /* public static boolean kollaLosenordLangd(JTextField tf) {
        boolean svar = true;
        if (tf.getText().length() > 6) {
            JOptionPane.showMessageDialog(null, "Lösenordet får max vara 6 tecken långt.");
            tf.requestFocusInWindow();
            svar = false;
        }
        return svar;
    }

    public static boolean kollaHeltal(JTextField tf) {
        boolean svar = true;

        try {
            Integer.parseInt(tf.getText());
            tf.requestFocusInWindow();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett heltal");
            svar = false;
        }
        return svar;
    }*/

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
