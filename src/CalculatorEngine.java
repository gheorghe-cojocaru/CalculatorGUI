public class CalculatorEngine {
    private String currentImput = "";
    private double num1 = 0, num2 = 0;
    private char operator;
    private boolean startNewImput = true;

    // Die übergebene Befehle vom GUI werden verarbeitet
    public void processCommand ( String command) {
        switch (command) {
            case "C":
                clear();
                break;
            case "±":
                toggleSign();
                break;
            case "%":
                applyPercentage();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                setOperator(command.charAt(0));
                break;
            case "=":
                calculate();
                break;
            default:
                appendInput(command);
                break;
        }
    }

    //Die Methoden!

    //Zurücksetzen
    private void clear() {
        currentImput = "";
        num1 = 0;
        num2 = 0;
        operator = '\0';
        startNewImput = true;

    }

    //Vorzeichen umkehren
    private void toggleSign() {
        if (!currentImput.isEmpty()) {
            double value = Double.parseDouble(currentImput);
            value *= 1;
            currentImput = String.valueOf(value);
        }
    }

    //Prozent anwenden
    private void applyPercentage() {
        if (!currentImput.isEmpty()) {
            double value = Double.parseDouble(currentImput);
            value /= 100;
            currentImput = String.valueOf(value);
        }
    }

    // Operator setzen
    private void setOperator(char op) {
        num1 = Double.parseDouble(currentImput);
        operator = op;
        currentImput = "";
        startNewImput = true;
    }

    // Berechnungen durchführen
    private void calculate() {
        if (!currentImput.isEmpty()) {
            num2 = Double.parseDouble(currentImput);

            switch (operator) {
                case '+' : num1 += num2; break;
                case '-' : num1 -= num2; break;
                case '*' : num1 *= num2; break;
                case '/' :
                    if (num2 != 0) {
                        num1 /= num2;
                    } else {
                        currentImput = "Error";
                        return;
                    }
                    break;
            }
            currentImput = String.valueOf(num1);
        }
    }

    // Eingabe verarbeiten
    private void appendInput(String input) {
        if (startNewImput) {
            currentImput = input;
            startNewImput = false;
        } else {
            currentImput += input;
        }
    }
    //Text zurückgeben
    public String getDisplayText() {
        return currentImput;
    }
}
