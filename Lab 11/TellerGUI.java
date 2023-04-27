
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TellerGUI implements ActionListener{
    private JPanel myPanel1,myPanel2, myPanel3;
    private JButton deposit, withdraw, exit;
    private JFrame Frame;
    private JLabel balance;
    private  JTextField amount;
    private Account account;
    public TellerGUI(){
        Frame = new JFrame("TellerGUI");
        Frame.setLayout(new GridLayout(4,1));

        // สร้าง Panel1 ประเภท Grid(1 rows, 2 cols) ข้างใน Panel1 จะมี (JLabel"Balance", JLabel"6000")
        // JLabel คล้ายๆ พวก TextBox | JLabel คือ component ไว้แสดงข้อความ/อธิบายอะไรบางอย่าง
        myPanel1 = new JPanel(new GridLayout(1, 2));
        myPanel1.add(new JLabel("   Balance: "));
        myPanel1.add(balance = new JLabel("6000"));

        // สร้าง Panel2 ประเภท Grid(1 rows, 2 cols) ข้างใน Panel2 จะมี (JLabel "Amount", JTextField)
        myPanel2 = new JPanel(new GridLayout(1, 2));
        myPanel2.add(new JLabel("   Amount: "));
        myPanel2.add(amount = new JTextField());

        // สร้าง Panel3 ประเภท Grid(1 rows, 3 cols) ข้างใน Panel3 จะมี  ปุ่ม Deposit WithDraw Exit
        myPanel3 = new JPanel();
        myPanel3.setLayout(new GridLayout(1, 3));
        myPanel3.add(deposit = new JButton("Deposit"));
        myPanel3.add(withdraw = new JButton("Withdraw"));
        myPanel3.add(exit = new JButton("Exit"));

        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        exit.addActionListener(this);

        //เพิ่มสิ่งที่เราสร้างเข้าไปใน JFrame ตามลำดับของโจทย์//
        Frame.add(myPanel1, BorderLayout.NORTH);
        Frame.add(myPanel2, BorderLayout.CENTER);
        Frame.add(myPanel3, BorderLayout.SOUTH);
        Frame.add(new JLabel(""), BorderLayout.SOUTH);
        Frame.pack() ;
        Frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        int myBalance = (int) Double.parseDouble(balance.getText());
        int myAmount = (int) Double.parseDouble(amount.getText());
        account = new Account(myBalance, "");

        if (e.getSource() == deposit){
            balance.setText(   ""+ (myBalance + myAmount));
            account.deposit(myAmount);
        }
        else if(e.getSource() == withdraw){

                if((myBalance + myAmount) >= 0){ //เงินพอ
                    account.withdraw(myAmount);
                }
                else{ //เงินไม่พอ
                }

            balance.setText(Integer.toString(myBalance - myAmount));
//            account.withdraw(  (Double.parseDouble(balance.getText()) + Double.parseDouble(amount.getText())) );
        }
    }

    public static void main(String[] args) {
        new TellerGUI();
    }
}

// import java.awt.event.*;
// // import javax.swing.event.*;
// import java.awt.*;
// import javax.swing.*;

// public class TellerGUI implements ActionListener{
//     private JFrame fr;
//     private JPanel p1, p2, p3, p4;
//     private JLabel lb1, lb2;
//     private JTextField fe1, fe2, num;
//     private JButton[] btn;
//     private String[] n={"Deposit", "Withdraw", "Exit"};
//     public TellerGUI(){
//         fr = new JFrame("Teller GUI");
//         fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         p1 = new JPanel();
//         p2 = new JPanel();
//         p3 = new JPanel();
//         p4 = new JPanel();
        
//         fe1 = new JTextField("6000");
//         fe2 = new JTextField();
//         num = new JTextField();
        
//         lb1 = new JLabel("Balance");
//         lb2 = new JLabel("Amount");
        
//         p1.add(lb1);
//         p1.add(fe1);
//         p2.add(lb2);
//         p2.add(fe2);
//         p1.setLayout(new GridLayout(1, 2));
//         p2.setLayout(new GridLayout(1, 2));
//         p3.setLayout(new FlowLayout());
//         btn = new JButton[3];
//         for(int i = 0 ; i < 3 ; i++){
//             btn[i] = new JButton(n[i]);
//             p3.add(btn[i]);
//         }
//         p4.add(num);
//         p4.setLayout(new GridLayout(1,1));
        
//         fr.setLayout(new GridLayout(4, 1));
//         fr.add(p1);
//         fr.add(p2);
//         fr.add(p3);
//         fr.add(p4);
//         fr.pack();
//         fr.setVisible(true);
//     }
//     public static void main(String[] args) {
//         new TellerGUI();
//         }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         int myBalance = (int) Double.parseDouble(fe1.getText());
//         int myAmount = (int) Double.parseDouble(fe2.getText());
//         Account account = new Account(myBalance, "");
//         String buttonText = ae.getActionCommand();
//         if(buttonText.matches("Deposit")){
//             fe1.setText(   ""+ (myBalance + myAmount));
//             account.deposit(myAmount);
//         }
//         else if(buttonText.matches("Withdraw")){
//             if ((myBalance+myAmount) >= 0){
//                 account.withdraw(myAmount);
//             }
//             else{System.out.println("Not enough money");}
//             fe1.setText(Integer.toString(myBalance - myAmount));
//         }
//     }
// }
