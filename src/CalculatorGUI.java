import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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


        //Buttons ertellen und auf ein Panel legen
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        for (int i = 0; i < buttons.length; i++) {
            buttonArray[i] = new JButton(buttons[i]);
            buttonArray[i].setFont(new Font("Arial", Font.BOLD, 24));
            buttonArray[i].addActionListener(this);
            buttonPanel.add(buttonArray[i]);

        }

        //Panel zum Frame hinzufügen
        add(buttonPanel, BorderLayout.CENTER);

        //Frame sichtbar machen
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        engine.processCommand(command);
        display.setText(engine.getDisplayText());
    }
}
