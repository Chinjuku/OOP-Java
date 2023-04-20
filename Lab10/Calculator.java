import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    // create components
    private JPanel panel;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonTexts = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", "C", "=", "/"};
    private Font font = new Font("Arial", Font.PLAIN, 30);
    private int num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        // set frame properties
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // create panel and add components
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        textField = new JTextField();
        textField.setFont(font);
        textField.setEditable(false);
        panel.add(textField);

        buttons = new JButton[16];
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonTexts[i]);
            buttons[i].setFont(font);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    // handle button clicks
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();

        if (buttonText.charAt(0) >= '0' && buttonText.charAt(0) <= '9') {
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.equals("+")) {
            num1 = Integer.valueOf(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (buttonText.equals("-")) {
            num1 = Integer.valueOf(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (buttonText.equals("x")) {
            num1 = Integer.valueOf(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (buttonText.equals("/")) {
            num1 = Integer.valueOf(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (buttonText.equals("C")) {
            num1 = Integer.valueOf("0");
            num2 = Integer.valueOf("0");
            result = Integer.valueOf("0");
            textField.setText("");
        } else if (buttonText.equals("=")) {
            num2 = Integer.valueOf(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }
}
