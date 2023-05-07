import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimeStopper extends JLabel implements Runnable, MouseListener{
    private final Object lock = new Object();
    public static int timer, numsec, nummin, numhour;
    public boolean isPaused;
    public int clickCount;

    public TimeStopper(){
        clickCount = 0;
        // setText(getText());
        setFont(new Font("Arial", Font.BOLD, 34));
        setVisible(true);
        addMouseListener(this);
    }
    public void run(){
        while (true){
            int numhour = (timer) / 3600;
            int nummin = ((timer) / 60 ) % 60;
            int numsec = timer % 60;
            String alltimer = String.format("%02d:%02d:%02d", numhour,  nummin, numsec);
            setText(alltimer);
            timer++;
         try {
            Thread.sleep(1000);
            if (isPaused == true) {
                waitForResume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
    public void resume() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }
    public void waitForResume() {
        synchronized (lock) {
            while (isPaused) {
                try { lock.wait(); }
                catch (InterruptedException e) {e.printStackTrace();}
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(this)){
        clickCount++;
        if((clickCount % 2) != 0)
        { isPaused = true;}
        else
        { isPaused = false;
          resume(); }
        System.out.println(isPaused);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
