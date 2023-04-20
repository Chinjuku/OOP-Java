

import java.awt.*;
import javax.swing.*;

public class CalculatorTwoGUI {
    private JFrame fr;
    private JPanel p;
    private JButton[] btn;
    private String[] n={"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", "c", "=", "/"};
    private JTextField fe;
    public CalculatorTwoGUI(){
        fr = new JFrame("My Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new JPanel();
        fe = new JTextField();
        fr.add(fe, BorderLayout.NORTH);
        p.setLayout(new GridLayout(4, 4));
        btn = new JButton[16];
        for(int i = 0; i<16; i++){
            btn[i] = new JButton(n[i]);
            p.add(btn[i]);
        }
        fr.add(p);
        fr.pack();
        fr.setVisible(true);
        p.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        new CalculatorTwoGUI();
    }
}
