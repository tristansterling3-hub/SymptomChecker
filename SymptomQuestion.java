package SymptomChecker;

import javax.swing.JOptionPane;

public class SymptomQuestion {

    public static boolean askSymptomQuestion(String symptom) {
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Do you have " + symptom + "?",
                "Symptom Checker",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        return choice == JOptionPane.YES_OPTION;
    }
}
