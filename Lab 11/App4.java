import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App4 implements ActionListener {
    private JFrame converterFrame;
    private JPanel converterPanel;
    private JButton convertTemp;
    private JTextField tempCelsius;
    private JLabel celsiusLabel, fahrenheitLabel;
    public App4() {
    converterFrame = new JFrame("Convert Celsius to Fahrenheit");
    converterPanel = new JPanel();
    convertTemp = new JButton("Convert..."); tempCelsius = new JTextField(2);
    celsiusLabel = new JLabel("Celsius",SwingConstants.LEFT);
    fahrenheitLabel = new JLabel("Fahrenheit",SwingConstants.LEFT);
    converterPanel.setLayout(new GridLayout(2, 2));
    converterPanel.add(tempCelsius); converterPanel.add(celsiusLabel);
    converterPanel.add(convertTemp); converterPanel.add(fahrenheitLabel);
    converterFrame.setContentPane(converterPanel);
    convertTemp.addActionListener(this);
    converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    converterFrame.pack(); converterFrame.setVisible(true);
    } public void actionPerformed(ActionEvent event) {
    int tempFahr = (int)((Double.parseDouble(tempCelsius.getText())) * 1.8 + 32);
    fahrenheitLabel.setText(tempFahr + " Fahrenheit");
    } public static void main(String[] args) { new App4(); }
    }
