import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Poring extends JFrame implements MouseListener, Runnable{
    public JFrame fr;
    public JLabel lb, lb1;
    private static int num = 1;

    public Poring() {
        fr = new JFrame();
        lb = new JLabel(new ImageIcon("poring.jpg"));
        lb1 = new JLabel(Integer.toString(num));
        lb.addMouseListener(this);
        fr.add(lb);
        fr.add(lb1);
        fr.setLayout(new FlowLayout());
        fr.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        fr.setResizable(false);
        fr.pack();
        fr.setVisible(true);
        num++;
    }
    public void run(){
        while (true){
            try{
            fr.setLocation(new Random().nextInt(1000), new Random().nextInt(1000));
            Thread.sleep(1000);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       fr.dispose();
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}

