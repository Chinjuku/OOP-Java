

import java.awt.*;
import javax.swing.*;

public class CalculatorOneGUI{
    private JFrame fr;
    private JPanel p;
    private JButton bn1, bn2, bn3, bn4;
    private JTextField fe1, fe2, fe3;
    public CalculatorOneGUI() {
        fr = new JFrame("เครื่องคิดเลข");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        p = new JPanel();
        bn1 = new JButton("บวก");
        bn2 = new JButton("ลบ");
        bn3 = new JButton("คูณ");
        bn4 = new JButton("หาร");
        fe1 = new JTextField();
        fe2 = new JTextField();
        fe3 = new JTextField();
        p.add(bn1);
        p.add(bn2);
        p.add(bn3);
        p.add(bn4);
        p.setLayout(new FlowLayout());
        fr.add(fe1);
        fr.add(fe2);
        fr.add(p);
        fr.add(fe3);
        fr.setLayout(new GridLayout(4, 1));
        // fr.add(fe3);
        fr.pack();
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorOneGUI();
        }
}

