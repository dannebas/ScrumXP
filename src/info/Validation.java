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
        boolean svar = false;
        String[] val = {"Yes", "No"};       //används för att kunna skriva egna alternativ på svenska.
        int n = JOptionPane.showOptionDialog(null,
                "Är du säker på att du vill logga ut?",
                "Logga ut",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, val, val[0]);
        if (n == JOptionPane.YES_OPTION) {
            svar = true;
        } else if (n == JOptionPane.NO_OPTION) {
            svar = false;
        }
        return svar;
    }

    public static boolean kollaRadering() {
        boolean svar = false;
        String[] val = {"Ja", "Nej"};
        int n = JOptionPane.showOptionDialog(null,
                "Är du säker på att du vill radera?",
                "Radera",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, val, val[0]);
        if (n == JOptionPane.YES_OPTION) {
            svar = true;
        } else if (n == JOptionPane.NO_OPTION) {
            svar = false;
        }
        return svar;
    }

}
