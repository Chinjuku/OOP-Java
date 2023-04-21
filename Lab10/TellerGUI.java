

import java.awt.*;
import javax.swing.*;

public class TellerGUI {
    private JFrame fr;
    private JPanel p1, p2;
    private JLabel lb1, lb2;
    private JTextField fe1, fe2;
    private JButton[] btn;
    private String[] n={"Deposit", "Withdraw", "Exit"};
    public TellerGUI(){
        fr = new JFrame("Teller GUI");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        fe1 = new JTextField("6000");
        fe2 = new JTextField();
        lb1 = new JLabel("Balance");
        lb2 = new JLabel("Amount");
        p1.add(lb1);
        p1.add(fe1);
        p3.add(lb2);
        p3.add(fe2);
        p1.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        p2.setLayout(new FlowLayout());
        btn = new JButton[3];
        for(int i = 0 ; i < 3 ; i++){
            btn[i] = new JButton(n[i]);
            p2.add(btn[i]);
        }
        fr.setLayout(new GridLayout(4, 1));
        fr.add(p1);
        fr.add(p3);
        fr.add(p2);
        fr.pack();
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new TellerGUI();
        }
}
