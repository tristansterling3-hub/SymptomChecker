package SymptomChecker;

import javax.swing.JOptionPane;

public class SymptomCheckDemo {

    public static void main(String[] args) {
        String[] options = {"Contact a physician", "AI symptom assessment"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Welcome to the Symptom Checker. How would you like to proceed?",
                "Symptom Checker",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == 0) {
            JOptionPane.showMessageDialog(null, "Please contact your healthcare provider or nearest medical facility.");
        } else if (choice == 1) {
            performSymptomAssessment();
        }
    }

    private static void performSymptomAssessment() {
        String[] symptoms = {"fever", "a cough", "shortness of breath"};
        boolean[] hasSymptoms = new boolean[symptoms.length];

        for (int i = 0; i < symptoms.length; i++) {
            hasSymptoms[i] = SymptomQuestion.askSymptomQuestion(symptoms[i]);
        }

        String diseaseSuggestion = DiseasesCheck.assessDisease(
                hasSymptoms[0],
                hasSymptoms[1],
                hasSymptoms[2]
        );

        JOptionPane.showMessageDialog(null, diseaseSuggestion);

        handleMedicationOptions(diseaseSuggestion);
    }

    private static void handleMedicationOptions(String diseaseSuggestion) {
        if (diseaseSuggestion.contains("unclear")) {
            JOptionPane.showMessageDialog(null, "Consult a healthcare professional for proper evaluation.");
            return;
        }

        String[] medicationOptions = {"Yes", "No"};
        int medicationChoice = JOptionPane.showOptionDialog(
                null,
                "Would you like to consider getting medication?",
                "Medication Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                medicationOptions,
                medicationOptions[0]
        );

        if (medicationChoice == 0) {
            String[] pharmacyOptions = {"Pick up medication from a pharmacy", "Have medication delivered"};
            int pharmacyChoice = JOptionPane.showOptionDialog(
                    null,
                    "How would you like to obtain medication?",
                    "Medication Option",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    pharmacyOptions,
                    pharmacyOptions[0]
            );

            if (pharmacyChoice == 0) {
                JOptionPane.showMessageDialog(null, "You can visit your nearest pharmacy for over-the-counter medications.");
            } else if (pharmacyChoice == 1) {
                JOptionPane.showMessageDialog(null, "You can arrange medication delivery through a local pharmacy or delivery service.");
            } else {
                JOptionPane.showMessageDialog(null, "Consult a healthcare professional if unsure.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Consult a healthcare professional for guidance.");
        }
    }
}
