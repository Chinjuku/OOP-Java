// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class Poring extends JFrame{
//     private JFrame fr;
//     private JLabel lb;

//     public Poring(){
//         fr = new JFrame();
//         lb = new JLabel(new ImageIcon("poring.jpg"));
//         lb.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 dispose();
//             }
//         });
//         fr.add(lb);
//         fr.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//         fr.setResizable(false);
//         fr.setMinimumSize(null);
//         fr.pack();
//         fr.setVisible(true);
//     }
//     public static void main(String[] args) {
//         new Poring();
//       }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Poring extends JFrame implements MouseListener, Runnable{
    private JFrame fr;
    private JLabel lb;

    public Poring() {
        fr = new JFrame();
        lb = new JLabel(new ImageIcon("poring.jpg"));
        lb.addMouseListener(this);
        fr.add(lb);
        fr.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        fr.setResizable(false);
        // fr.setMinimumSize(null);
        fr.pack();
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new Poring();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       dispose();
    }
}

