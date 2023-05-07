import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CooldownAftergame extends JLabel implements MouseListener , Runnable{

    private int totalSeconds;
    private boolean wait, paused;
    private static final int milisecond = 180000;

    public CooldownAftergame(){
        setText("");
        setBorder(new EmptyBorder(20, 15, 20, 15));
        setFont(new Font("Arial", Font.BOLD, 34));
        setVisible(true);
        addMouseListener(this);
    }

    @Override
public void run() {
    while (true) {
        try {
            if (wait) {
                synchronized (this) {
                    while (paused) {
                        wait = true;
                    }
                }
            } else {
                long remainingTime = milisecond - totalSeconds;
                if (remainingTime <= 0) {
                    setText("");
                    wait = true;
                } else {
                    int minutes = (int) (remainingTime / 1000 / 60);
                    int seconds = (int) ((remainingTime / 1000) % 60);

                    String formattedTime = String.format("%02d:%02d", minutes, seconds);
                    setText(formattedTime);
                    totalSeconds += 1000;
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(!wait);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("My Timer");
        CooldownAftergame clock2 = new CooldownAftergame();
        Thread t = new Thread(clock2);
        t.start();
        frame.add(clock2, BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
