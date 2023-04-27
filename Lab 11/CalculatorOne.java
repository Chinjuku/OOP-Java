
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalculatorOne implements ActionListener {

    private JFrame fr;
    private JPanel p1,p2;
    private JTextField txt1, txt2, txt3;
    private JButton btn1, btn2, btn3, btn4;
    public CalculatorOne(){
    fr = new JFrame("เครืองคิดเลข");
    p1 = new JPanel();
    p2 = new JPanel();
    txt1 = new JTextField();
    txt2 = new JTextField();
    txt3 = new JTextField();
    btn1 = new JButton("+");
    btn2 = new JButton("-");
    btn3 = new JButton("x");
    btn4 = new JButton("/");

    // Add Listener
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    btn4.addActionListener(this);

    // Set Layout
    p1.setLayout(new GridLayout(4,1));
    p1.add(txt1);
    p1.add(txt2);
    p1.add(p2);
    p1.add(txt3);
    p2.setLayout(new FlowLayout());
    p2.add(btn1);
    p2.add(btn2);
    p2.add(btn3);
    p2.add(btn4);
    txt3.setEditable(false);
    fr.getContentPane().add(p1);
    // Set JFrame Property
    fr.setFont(new Font("TimesRoman",Font.BOLD,60));
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.pack();
    fr.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorOne();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        int num = 0;
        if(ae.getSource().equals(btn1)){
            num = (int) ((Double.parseDouble(txt1.getText())) + (Double.parseDouble(txt2.getText())));
        }else if(ae.getSource().equals(btn2)){
            num = (int) ((Double.parseDouble(txt1.getText())) - (Double.parseDouble(txt2.getText())));
        }else if(ae.getSource().equals(btn3)){
            num = (int) ((Double.parseDouble(txt1.getText())) * (Double.parseDouble(txt2.getText())));
        }else if(ae.getSource().equals(btn4)){
            num = (int) ((Double.parseDouble(txt1.getText())) / (Double.parseDouble(txt2.getText())));
        }
        txt3.setText(Integer.toString(num));
    }
}

// package Lab11;
// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;


// public class CalculatorOne implements ActionListener{
//     private JFrame fr;
//     private JPanel p;
//     private JButton bn1, bn2, bn3, bn4;
//     private JTextField fe1, fe2;
//     private JLabel label;
//     public CalculatorOne() {
//         fr = new JFrame("เครื่องคิดเลข");
//         fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         fr.setLayout(new BorderLayout());
//         p = new JPanel();
//         bn1 = new JButton("+");
//         bn2 = new JButton("-");
//         bn3 = new JButton("x");
//         bn4 = new JButton("%");
//         fe1 = new JTextField();
//         fe2 = new JTextField();
//         label = new JLabel();
//         p.add(bn1);
//         p.add(bn2);
//         p.add(bn3);
//         p.add(bn4);
//         p.setLayout(new FlowLayout());
//         fr.add(fe1);
//         fr.add(fe2);
//         fr.add(p);
//         fr.add(label);
//         bn1.addActionListener(this);
//         bn2.addActionListener(this);
//         bn3.addActionListener(this);
//         bn4.addActionListener(this);
//         fr.setLayout(new GridLayout(4, 1));
//         fr.pack();
//         fr.setVisible(true);
//     }
//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         if(ae.getSource().equals(bn1)){
//             int num = (int) ((Double.parseDouble(fe1.getText()) + Double.parseDouble(fe2.getText())));
//         }else if(ae.getSource().equals(bn2)){
//             int num = (int) ((Double.parseDouble(fe1.getText()) - Double.parseDouble(fe2.getText())));
//         }else if(ae.getSource().equals(bn3)){
//             int num = (int) ((Double.parseDouble(fe1.getText()) * Double.parseDouble(fe2.getText())));
//         }else if(ae.getSource().equals(bn4)){
//             int num = (int) ((Double.parseDouble(fe1.getText()) / Double.parseDouble(fe2.getText())));
//         }
//         label.setText(num);
//     }

//     public static void main(String[] args) {
//         new CalculatorOne();
//     }
// }
