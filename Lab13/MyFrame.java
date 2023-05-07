import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MyFrame{
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        Clock clock = new Clock();
        Thread t1 = new Thread(clock);
        fr.setLayout(new BorderLayout());
        clock.setBorder(new EmptyBorder(15, 15, 15, 15));
        fr.add(clock, BorderLayout.CENTER);
        // fr.setResizable(false);
        t1.start();
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }
}
