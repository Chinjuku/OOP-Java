import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PoringConstructor implements ActionListener{
    private JFrame fr;
    private JButton btn;
    public PoringConstructor() {
        fr = new JFrame();
        btn = new JButton("Add");
        btn.addActionListener(this);
        fr.add(btn);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btn)){
            Poring p1 = new Poring();
            Thread t1 = new Thread(p1);
            t1.start();
        }
    }
    public static void main(String[] args) {
        new PoringConstructor();
    }

}
