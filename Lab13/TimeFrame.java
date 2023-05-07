import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TimeFrame {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        TimeStopper ts = new TimeStopper();
        Thread t1 = new Thread(ts);
        ts.setBorder(new EmptyBorder(20, 15, 20, 15));
        fr.add(ts);
        t1.start();
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
