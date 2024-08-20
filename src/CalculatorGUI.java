import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField display;
    private JPanel buttonPanel;
    private String[] buttons = {
            "C", "±", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "00", ".", "="
    };
    private JButton[] buttonArray = new JButton[buttons.length];

    private CalculatorEngine engine;

    public CalculatorGUI(CalculatorEngine engine) {
        this.engine = engine;

        //Frame Einstellungen
        setTitle("Taschenrechner by GheCo");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Display einrichten
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);
        


    }
}
