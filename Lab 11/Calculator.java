import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/"};
    private int firstNumber, secondNumber;
    private String operator;

    public Calculator() {
        super("Calculator");

        // Create the text field
        textField = new JTextField(15);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        // Create the buttons
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
        }

        // Set the layout
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < buttonLabels.length; i++) {
            buttonPanel.add(buttons[i]);
        }
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        if (buttonText.equals("C")) {
            textField.setText("");
            firstNumber = 0;
            secondNumber = 0;
            operator = "";
        } else if (buttonText.matches("[0-9]")) {
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.matches("[+\\-*/]")) {
            firstNumber = Integer.parseInt(textField.getText());
            operator = buttonText;
            textField.setText("");
        } else if (buttonText.equals("=")) {
            secondNumber = Integer.parseInt(textField.getText());
            int result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }
            textField.setText(Integer.toString(result));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }
}

