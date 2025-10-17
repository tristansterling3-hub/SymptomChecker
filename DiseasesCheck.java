package SymptomChecker;

public class DiseasesCheck {

    public static String assessDisease(boolean hasFever, boolean hasCough, boolean hasShortnessOfBreath) {
        if (hasFever && hasCough && hasShortnessOfBreath) {
            return "You may have a severe respiratory infection. Seek medical attention immediately.";
        } else if (hasFever || hasCough) {
            return "You may have a common cold or mild infection.";
        } else {
            return "Symptoms are mild or unclear. Monitor your health and consult a physician if needed.";
        }
    }
}
