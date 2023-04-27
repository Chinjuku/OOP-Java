
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TellerGUI implements ActionListener{
    private JFrame fr;
    private JPanel p1, p2, p3, p4;
    private JLabel lb1, lb2;
    private JTextField fe1, fe2;
    private JButton[] btn;
    private JButton btn3;
    private String[] n={"Deposit", "Withdraw"};
    public TellerGUI(){
        fr = new JFrame("Teller GUI");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        fe1 = new JTextField("6000");
        fe2 = new JTextField();
        fe1.setEditable(false);

        lb1 = new JLabel("Balance");
        lb2 = new JLabel("Amount");

        p1.add(lb1);
        p1.add(fe1);
        p2.add(lb2);
        p2.add(fe2);
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new FlowLayout());
        btn = new JButton[2];
        for(int i = 0 ; i < 2 ; i++){
            btn[i] = new JButton(n[i]);
            p3.add(btn[i]);
            btn[i].addActionListener(this);
        }
        btn3 = new JButton("Exit");
        p3.add(btn3);
        btn3.addActionListener(e -> {
            fr.dispose();
         });


        fr.setLayout(new GridLayout(4, 1));
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        fr.pack();
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new TellerGUI();
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int myBalance = (int) Double.parseDouble(fe1.getText());
        int myAmount = (int) Double.parseDouble(fe2.getText());
        Account account = new Account(myBalance, "");
        String buttonText = ae.getActionCommand();
        if (buttonText.matches("Deposit")){
            fe1.setText(   ""+ (myBalance + myAmount));
            System.out.println(myAmount);
            account.deposit(myAmount);
        }
        else if (buttonText.matches("Withdraw")){
            if ((myBalance + myAmount) >= 0){
                account.withdraw(myAmount);
            }
            else{System.out.println("Not enough money");}
            fe1.setText(Integer.toString(myBalance - myAmount));
        }
    }
}
